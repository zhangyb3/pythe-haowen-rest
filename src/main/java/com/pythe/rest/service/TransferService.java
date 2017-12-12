package com.pythe.rest.service;

import com.pythe.common.pojo.PytheResult;

public interface TransferService  {
    
	
	



	String transferIndividual(String url) throws Exception;

	String refundByOrder(String url);

	PytheResult queryQuestionPayRecord(Long studentId, int pageNum, int pageSize);

	PytheResult billMapQuestion(Long questionId, Long studentId);

	PytheResult teacherEnchashment(String parameters) throws Exception;






	
	
}
