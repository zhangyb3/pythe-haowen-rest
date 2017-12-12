package com.pythe.rest.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.pythe.common.pojo.PytheResult;
import com.pythe.common.utils.FtpUtil;
import com.pythe.mapper.TblAnswerMapper;
import com.pythe.rest.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Value("${FTP_HOST}")
	private String FTP_HOST;

	@Value("${FTP_POST}")
	private Integer FTP_POST;

	@Value("${FTP_USER}")
	private String FTP_USER;

	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;

	@Value("${FTP_BASEPATH}")
	private String FTP_BASEPATH;
	
	@Value("${FILE_CLASSPATH}")
	private String FILE_CLASSPATH;
	

	// private static String DOWNLOAD_FLUSH_AREA_BASHPATH
	// ="/usr/local/pythe-server/rest-8081-pythe/webapps";
	// "/image/2017/3/30/store_2054369272o6zAJszZtla1bslHFhnJTbWBTVik1490879237598.jpg"
	@Override
	public PytheResult uploadFile(HttpServletRequest request) throws Exception {
		String fileType = null;
		FileItem file = null;
		InputStream input = null;
		String filePath = null;
		String fileName = null;
		request.setCharacterEncoding("UTF-8");

		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 2、创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 解决上传文件名的中文乱码
		upload.setHeaderEncoding("UTF-8");
		// 1. 得到 FileItem 的集合 items
		List<FileItem> items = upload.parseRequest(request);
		// 2. 遍历 items:
		for (FileItem item : items) {

			String name = item.getFieldName();

			// 若是一个一般的表单域, 打印信息
			if (item.isFormField()) {

				if (name.equals("path")) {
					String str = item.getString("utf-8");
					filePath = str.substring(0, str.lastIndexOf("/"));
					fileName = str.substring(str.lastIndexOf("/") + 1);
					System.out.println("==================>str_path"+str);
				}

				if (name.equals("fileType")) {
					fileType = item.getString("utf-8");
					System.out.println("==================>fileType"+fileType);
				}

			} else {
				file = item;
				input = file.getInputStream();
			}
		}

//		boolean up_flag = FtpUtil.uploadFile(FTP_HOST, FTP_POST, FTP_USER, FTP_PASSWORD, FTP_BASEPATH, filePath,fileName, input);

		// 上传完毕后，把图片微信小程序rest服务器
		// String remotePath = FTP_BASEPATH + filePath;
		// System.out.println("remotePath=======>"+remotePath);
		// String localPath =DOWNLOAD_FLUSH_AREA_BASHPATH+remotePath;
		// System.out.println("filePath=======>"+filePath);
		// Boolean down_flag = FtpUtil.downloadFile(FTP_HOST, FTP_POST,
		// FTP_USER, FTP_PASSWORD, remotePath, fileName,
		// localPath);
				
		//直接将上传文件存在当前项目的子目录下
		ByteArrayOutputStream swapStream = null;
		boolean up_flag = false;
		if(file == null){
			System.out.println("file null");
        }
		else{
			
            swapStream = new ByteArrayOutputStream();

            input = file.getInputStream();
            byte[] buff = new byte[1024];
            int rc = 0;
            while ((rc = input.read(buff)) > 0) {
                swapStream.write(buff, 0, rc);
            }

           

            final byte[] bytes = swapStream.toByteArray();
//            Path store_path = Paths.get(FILE_CLASSPATH + filePath, fileName); 
            String stored_path = 
            		//request.getSession().getServletContext().getRealPath("/") + 
            		FILE_CLASSPATH + filePath + "/" + fileName;
            System.out.println("stored_path=============================>"+stored_path);
            File stored_file = new File(stored_path);
            
            //判断目标文件所在的目录是否存在  
            if(!stored_file.getParentFile().exists()) {  
                //如果目标文件所在的目录不存在，则创建父目录  
                System.out.println("no dir ");  
                if(!stored_file.getParentFile().mkdirs()) {  
                    System.out.println("mkdir fail");  
                    
                }  
            }  
            //创建目标文件  
            try {  
                if (stored_file.createNewFile()) {  
                    System.out.println(stored_path + " success");  
                    up_flag = true;  
                } else {  
                    System.out.println(stored_path + " fail");  
                      
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
                System.out.println(stored_path + " exception " + e.getMessage());  
                  
            }  
            FileOutputStream fos = new FileOutputStream(stored_path);

            //用FileOutputStream 的write方法写入字节数组
            fos.write(bytes);
            fos.close();
            
//            try{
//            	System.out.println("stored name : " + store_path.getFileName());
//            	Files.write(store_path, bytes);

                //上传成功的情况
                up_flag = true;
            	
//            }catch(IOException e) {
//            	System.out.println("error message : " + e.getMessage());
//            }
            
            
        }
    	

		JSONObject json = new JSONObject();
		json.put("up_flag", up_flag);
		// json.put("down_flag", down_flag);

		return PytheResult.ok(json);
	}

	// @Override
	// public Boolean downloadFile(String remotePath, String fileName, String
	// localPath) throws Exception {
	// // TODO Auto-generated method stub
	// // http://update
	// // "/home/ftpuser/www/动态", "hello.jpg", "F://");
	// /// home/ftpuser/www/image/2017/3/30
	// // store_2a42fd9ddab4c5d5002a7465225fc25a3271f65221ed5f13.jpg
	// ///
	// usr/local/pythe-server/rest-8081-pythe/webapps/home/ftpuser/www/image/2017/3/30/store_2a42fd9ddab4c5d5002a7465225fc25a3271f65221ed5f13.jpg
	//
	// System.out.println(remotePath);
	// System.out.println(fileName);
	// System.out.println(localPath);
	//
	// Boolean flag = FtpUtil.downloadFile(FTP_HOST, FTP_POST, FTP_USER,
	// FTP_PASSWORD, remotePath, fileName,
	// localPath);
	// return flag;
	//
	// }

	@Override
	public String uploadFilePrepare(String parameters) {

		JSONObject uploadParameters = JSONObject.parseObject(parameters);

		String filePathAndFileName = uploadParameters.getString("userFilePath");
		String userFilePath = filePathAndFileName.substring(0, filePathAndFileName.lastIndexOf("/") + 1);
		String fileName = filePathAndFileName.substring(filePathAndFileName.lastIndexOf("/") + 1);
		String fileType = uploadParameters.getString("fileType");

		DateTime time = new DateTime();
		String filePath = fileType + "/" + time.getYear() + "/" + time.getMonthOfYear() + "/" + time.getDayOfMonth();

		JSONObject json = new JSONObject();
		json.put("fileType", fileType);
		// json.put("path", FTP_BASEPATH + "/" + filePath + "/" + fileName);
		// path :
		// "/image/2017/3/30/store_2054369272o6zAJszZtla1bslHFhnJTbWBTVik1490879237598.jpg"
		json.put("path", "/" + filePath + "/" + fileName);
		return json.toString();

	}

//	@Override
//	public PytheResult identifySingleImage(String path) throws Exception {
//		Tesseract1 instance = new Tesseract1();
//
//		System.out.println("doOCR on a PNG image");
//		File imageFile = new File(path);
//
//		String result = instance.doOCR(imageFile);
//		return PytheResult.ok(result);
//
//	}


}
