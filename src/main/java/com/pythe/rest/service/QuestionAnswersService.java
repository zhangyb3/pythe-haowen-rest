package com.pythe.rest.service;

import java.util.List;

import com.pythe.common.pojo.PytheResult;
import com.pythe.pojo.VQuestionAnswers;
import com.pythe.pojo.VQuestionAnswersWithBLOBs;

public interface QuestionAnswersService {


	 /**
     * 未答列表
     * @param teacherId
	 * @param pageSize 
	 * @param pageNum 
     * @return
     */
	public PytheResult selectIsAnswerListByTeacherId(Long teacherId, Integer pageNum, Integer pageSize);
	
	 /**
     *  已答列表
     * @param teacherId
	 * @param pageSize 
	 * @param pageNum 
     * @return
     */
	public PytheResult selectIsNotAnswerListByTeacherId(Long teacherId, Integer pageNum, Integer pageSize);

	public PytheResult selectIsNotAnswerListByStudentId(Long studentId, Integer pageNum, Integer pageSize);

	public PytheResult selectIsAnswerListByStudentId(Long studentId, Integer pageNum, Integer pageSize);

	public PytheResult selectQuestionDetail(Long userId, Long questionId);

}
