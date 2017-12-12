package com.pythe.rest.controller;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pythe.common.pojo.PytheResult;
import com.pythe.common.utils.ExceptionUtil;
import com.pythe.rest.service.FileService;


@Controller
public class FileController {

	@Autowired
	private FileService service;

	@Autowired
    HttpServletRequest request;
	
	
	//private static String DOWNLOAD_FLUSH_AREA_BASHPATH ="D://pythe/code/pythe-rest/src/main/webapp";
	//private static String DOWNLOAD_FLUSH_AREA_BASHPATH ="/usr/local/pythe-server/rest-8081-pythe/webapps";
	  /**
     * 上传
     * @return
     * userFilePath 文件路径+文件名
     * fileType 前端知道传过来的文件类型
     */
	@RequestMapping(value = "/file/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public PytheResult uploadFile(){
    	try {
    		
    		/*
    		String realPath = request.getSession().getServletContext().getRealPath("/");
    		System.out.println("real path : " + realPath);
    		String stored_path = request.getSession().getServletContext().getRealPath("/") 
            		+ "files/www" + "/test/" + "template.jpg";
            File stored_file = new File(stored_path);
            
            //判断目标文件所在的目录是否存在  
            if(!stored_file.getParentFile().exists()) {  
                //如果目标文件所在的目录不存在，则创建父目录  
                System.out.println("no dir ");  
                if(!stored_file.getParentFile().mkdirs()) {  
                    System.out.println("mkdir fail");  
                    
                }  
            }  
    		return PytheResult.ok(null);
    		*/
    		
			return service.uploadFile(request);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    
    /**
     * 下载
     * @return
//   * file/downloadFile?path=
     * "/home/ftpuser/www/audio/2017/3/17/store_766871476o6zAJszZtla1bslHFhnJTbWBTVik1489667443752.silk"
     *  测试：/home/ftpuser/www/image/2017/3/12/1489250910037730.jpg
     */
	
	/**
	 * path==========>/home/ftpuser/www/image/2017/3/30/store_2a42fd9ddab4c5d5002a7465225fc25a3271f65221ed5f13.jpg
remotePath=======>/home/ftpuser/www/image/2017/3/30
fileName=======>store_2a42fd9ddab4c5d5002a7465225fc25a3271f65221ed5f13.jpg
filePath=======>/usr/local/pythe-server/rest-8081-pythe/webapps/home/ftpuser/www/image/2017/3/30
/home/ftpuser/www/image/2017/3/30

	 */
//	@RequestMapping(value = "/file/downloadFile", method = RequestMethod.GET)
//	@ResponseBody
//	///home/ftpuser/www/image/2017/3/30/store_2a42fd9ddab4c5d5002a7465225fc25a3271f65221ed5f13.jpg
//	public PytheResult downloadFile(
//			@RequestParam(required = true, value = "path") String path){
//    	try {
//    	    path = URLDecoder.decode(path, "UTF-8");
//    		System.out.println("path==========>"+URLDecoder.decode(path, "UTF-8"));
//    		String remotePath = path.substring(0,path.lastIndexOf("/"));
//    		System.out.println("remotePath=======>"+remotePath);
//    		String fileName = path.substring(path.lastIndexOf("/")+1);
//    		System.out.println("fileName=======>"+fileName);
//    		String filePath =DOWNLOAD_FLUSH_AREA_BASHPATH+remotePath;
//    		System.out.println("filePath=======>"+filePath);
//
//			return PytheResult.ok(service.downloadFile(remotePath,fileName,filePath));
//		} catch (Exception e) {
//			e.printStackTrace();
//			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
//		}
//	}
    
  
	/**
     * 上传文件前的准备，返回上传文件在文件服务器的路径
     * @return
     * userFilePath 文件路径+文件名
     * fileType 前端知道传过来的文件类型
	 * @throws Exception 
     */
	@RequestMapping(value = "/file/uploadFilePrepare")
	@ResponseBody
	public PytheResult uploadFilePrepare(@RequestBody String parameters) throws Exception{
		//System.out.println("======================>parameters"+parameters);
		parameters = URLDecoder.decode(parameters, "UTF-8");
		//System.out.println("======================>parameters_URLDecoder"+parameters);
    	try {
//    		System.out.println("upload prepare result JSONString : " + service.uploadFilePrepare(parameters));
    		PytheResult result = PytheResult.ok(service.uploadFilePrepare(parameters));
    		//System.out.println("upload prepare data : " + result.getData());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	
	

	
//	@RequestMapping(value = "/image", method = RequestMethod.GET)
//	@ResponseBody
//	///http://10.0.0.9:8081/rest/image?path=/root/1.tif
//	public PytheResult identifySingleImage(
//			@RequestParam(required = true, value = "path") String path){
//    	try {
//
//			return service.identifySingleImage(path);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
//		}
//	}
//	
	
	
	
	

}
