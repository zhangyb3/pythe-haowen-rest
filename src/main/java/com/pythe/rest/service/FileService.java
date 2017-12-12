package com.pythe.rest.service;

import javax.servlet.http.HttpServletRequest;

import com.pythe.common.pojo.PytheResult;

public interface FileService {



//HttpServletRequest request
	PytheResult uploadFile(HttpServletRequest request) throws Exception;

//	Boolean downloadFile(String remotePath,String fileName,String localPath) throws Exception;

	String uploadFilePrepare(String parameters) throws Exception;

//	PytheResult identifySingleImage(String path) throws Exception;




	
}
