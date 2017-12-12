package com.pythe.controller;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import com.pythe.common.utils.FtpUtil;



//import com.taotao.common.utils.FtpUtil;

public class FTPTest {

	@Test
	public void testFtpClient() throws Exception {
		//创建一个FtpClient对象
		FTPClient ftpClient = new FTPClient();
		//创建ftp连接。默认是21端口
		ftpClient.connect("10.0.0.9", 21);
		//登录ftp服务器，使用用户名和密码
		ftpClient.login("ftpuser", "pythe888");
		//上传文件。
		//读取本地文件
		FileInputStream inputStream = new FileInputStream(new File("D://love.jpg"));
		//设置上传的路径
		ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/");
		//修改上传文件的格式
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		//第一个参数：服务器端文档名
		//第二个参数：上传文档的inputStream
		ftpClient.storeFile("hello.jpg", inputStream);
		//关闭连接
		ftpClient.logout();
		
	}
	
	@Test
	public void testFtpUtil_Upload() throws Exception {
		FileInputStream inputStream = new FileInputStream(new File("D://hate.jpg"));
		boolean flag =FtpUtil.uploadFile("139.199.212.174", 21, "ftpuser","pythe888", "/home/ftpuser/www/image", "/2015/09/15/test", "hate.jpg", inputStream);
		 System.out.println(flag);  
	}
	
	@Test
	public void testFtpUtil_down() throws Exception {
		 boolean flag =FtpUtil.downloadFile("192.168.1.15", 21, "ftpuser","pythe888", 
				 "/home/ftpuser/www/images", "hello.jpg", "F://");
         
         System.out.println(flag);  
		
	}
}
