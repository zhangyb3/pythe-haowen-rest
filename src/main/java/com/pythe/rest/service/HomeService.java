package com.pythe.rest.service;

import java.util.List;

import com.pythe.common.pojo.PytheResult;
import com.pythe.pojo.VHomepageListWithBLOBs;

public interface HomeService {
	List<VHomepageListWithBLOBs> selectDefaultListByGradeId(Integer gradeId, Integer pageNum, Integer pageSize);
	
	
	
	
    /**
     * 科目列表
     * @param pageSize 
     * @param pageNum 
     * @param string
     * @return
     */

	List<VHomepageListWithBLOBs> selectListByGradeIdAndSubject(Integer gradeId, Integer subjectId, Integer pageNum, Integer pageSize);

	
    /**
     * isClick为 0 ，没有为1。
     * @param questionId
     * @param userId
     * @return
     */
	PytheResult selectListByQuestionId(Long questionId, Long userId);

	PytheResult selectListByFeeAndLikesNum(Integer gradeId, Integer pageNum, Integer pageSize);



	PytheResult selectKnowledgeOrQuestionContent(String query,Long userId, Integer pageNum, Integer pageSize);




	PytheResult selectListByTeacher(String query, Long userId, Integer subjectId, Integer pageNum, Integer pageSize);




	PytheResult selectListByOrganization(String query, Long userId, Integer pageNum, Integer pageSize);






	

	
}
