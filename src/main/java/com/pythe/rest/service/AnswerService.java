package com.pythe.rest.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.pythe.common.pojo.PytheResult;
import com.pythe.pojo.TblKnowledge;

public interface AnswerService {

	/**
	 * 点赞
	 * @param answerId2 
	 * @param questionId 
	 * 
	 * @param string
	 * @return
	 */
	PytheResult updateLikesNumById(Long userId, Long questionId, Long answerId);
	/**
	 * 打赏
	 * @param openId 
	 * 
	 * @param string
	 * @return
	 */
	PytheResult updateRewardNumById(Long answerId,Double fee,Long questionId, String openId);

//	/**
//	 * 返回问的列表
//	 * @param pageSize 
//	 * @param pageNum 
//	 * 
//	 * @return
//	 */
//	PytheResult selectAnswerDefaultList(Long teacherId,Integer pageNum, Integer pageSize);

//	/**
//	 * 条件选择列表
//	 * 
//	 * @return
//	 */
//	List<JSONObject> selectAnswerConditionList(Long teacherId,Integer subjectId, String condition, String order,Integer pageNum, Integer pageSize);
//	
	/**
	 * 插入一条answer记录
	 * 
	 * @return
	 */
	PytheResult insertAnswer(String url);

	 /**
     * 赚取的总额
     * @param teacherId
     * @return
     */
	PytheResult selectSumByTeacherId(Long teacherId);
	
	/**
	 * 一级知识点列表
	 * @param subjectId
	 * @param gradeId
	 * @return
	 */
	List<TblKnowledge> selectKnowledgeList(Integer subjectId, Long studentId);
	/**
	 * 二级知识点列表
	 * @param subjectId
	 * @param gradeId
	 * @return
	 */
	List<TblKnowledge> selectSecondKnowledgeList(String level1);
	
	
	


	
}
