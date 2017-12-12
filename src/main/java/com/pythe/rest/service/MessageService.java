package com.pythe.rest.service;

import com.pythe.common.pojo.PytheResult;

public interface MessageService {

	/**
	 * 单条发送
	 * @return
	 */
	PytheResult singleSend(String url) throws Exception;

	PytheResult pushQuestionInformationForUser(String prepay_id);

	PytheResult pushAnswerInformationToStudent(Long answerId);


	
}
