package com.pythe.rest.service;

import java.util.List;

import com.pythe.common.pojo.PytheResult;
import com.pythe.pojo.TblAnswer;
import com.pythe.pojo.TblQuestion;
import com.pythe.pojo.TblTeacher;
import com.pythe.pojo.VQuestionAnswers;

public interface QuestionService {
	public Object insertQuestion(String question);

	public PytheResult selectTeacherList(Long userId,Integer subjectId,Integer pageNum, Integer pageSize);


	// public Object selectAnswersByQuestionId(Long questionId);

	public int insertAnswersAndDistributeMoneyByQuestionId(Long userId,Long questionId, String answerIds);

	public TblAnswer findAnswerByAnswerId(Long answerId);


	public PytheResult updateLikesByTeacherId(Long userId, Long teacherId);

	public PytheResult selectAnswersByQuestionId(Long userId,Long questionId);

	public PytheResult selectTeacherDetail(Long userId);

	public boolean closeQuestion(Long questionId);

}
