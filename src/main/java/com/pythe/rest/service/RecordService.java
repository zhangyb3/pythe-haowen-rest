package com.pythe.rest.service;

import com.pythe.common.pojo.PytheResult;

public interface RecordService  {
    


	PytheResult recordAskQuestion(Long studentId, Long teacherId, Long questionId, Double money, String payId, String outTradeNo);

	PytheResult recordAnswerQuestion(Long studentId, Long teacherId, Long answerId, Double money);

	PytheResult teacherQueryBills(Long teacherId, Integer pageNum, Integer pageSize);


	Object checkBill(String params);

	PytheResult studentQueryBills(Long studentId, Integer pageNum, Integer pageSize);

	PytheResult queryStatistics(Long userId);

	PytheResult recordAnswerReward(Long studentId, Long teacherId, Long answerId, Double money, String payId,
			String outTradeNo);

	PytheResult checkBillQADetail(String params);





	
	
}
