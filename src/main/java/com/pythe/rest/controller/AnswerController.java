package com.pythe.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pythe.common.pojo.PytheResult;
import com.pythe.common.utils.ExceptionUtil;
import com.pythe.rest.service.AnswerService;
import com.pythe.rest.service.QuestionAnswersService;






@Controller
public class AnswerController {  
	
	@Autowired  
    private AnswerService service;  
     
	@Autowired  
    private QuestionAnswersService questionAnswersService;
    
    /**
     *点赞
     * @param string
     * @return  localhost:8081/rest/likesnum?answerId=2&userId=1&questionId=3
     * Long userId, Long questionId, Long answerId
     */
    @RequestMapping(value="/likesnum", method=RequestMethod.GET)
	@ResponseBody
	public PytheResult updateLikesNumById(
			@RequestParam("userId")Long userId,
			@RequestParam("questionId")Long questionId,
			@RequestParam("answerId")Long answerId
			){
    	try {

    		return PytheResult.ok(service.updateLikesNumById(userId,questionId,answerId));
    	} catch (Exception e) {
    		e.printStackTrace();
    		return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
    	}
    	
    }
	
    
    /**
     *打赏
     * @param string
     * @return
     */
    @RequestMapping(value="/rewardnum", method=RequestMethod.GET)
	@ResponseBody
	public PytheResult updateRewardNumById(
			@RequestParam("answerId")Long answerId, 
			@RequestParam("questionId")Long questionId, 
			@RequestParam("f")Double fee,
			@RequestParam("openId")String openId
			){
    	try {
    		return PytheResult.ok(service.updateRewardNumById(answerId,fee,questionId,openId));
    	} catch (Exception e) {
    		e.printStackTrace();
    		return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
    	}
    }
    
    

//    /**
//     * 答的列表
//     * 过来掉超时并且没有打完的
//     */
//    @RequestMapping(value="/answer/defaultList", method=RequestMethod.GET)
//	@ResponseBody
//	public PytheResult selectAnswerDefaultList(	
//			@RequestParam(defaultValue="-1") Long teacherId,
//			@RequestParam(defaultValue="1") Integer pageNum,
//			@RequestParam(defaultValue="10") Integer pageSize){
//    	try {
//
//    		return service.selectAnswerDefaultList(teacherId,pageNum,pageSize);
//    	} catch (Exception e) {
//    		e.printStackTrace();
//    		return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
//    	}
//    }
    
//    /**
//     * 选择列表
//     * 默认按最新发布时间排
//     * 分二种情况：
//     * (1)选择了科目就按科目并按时间降序排
//     * (2)选择科目并按金额降序
//     * 注：你要按金额排conditon=reward,按时间排就condition=startTime
//     * localhost:8081/answer/conditionList?subjectId=1001
//     */
//    @RequestMapping(value="/answer/conditionList", method=RequestMethod.GET)
//	@ResponseBody
//	public PytheResult selectAnswerConditionList(
//			@RequestParam(defaultValue="-1") Long teacherId,
//			@RequestParam(defaultValue="-1")Integer subjectId, 
//			@RequestParam(defaultValue="startTime")String condition, 
//			@RequestParam(defaultValue="desc")String order,
//			@RequestParam(defaultValue="1") Integer pageNum,
//			@RequestParam(defaultValue="10") Integer pageSize
//			){
//    	try {
//    		return PytheResult.ok(service.selectAnswerConditionList(teacherId,subjectId,condition,order,pageNum,pageSize));
//    	} catch (Exception e) {
//    		e.printStackTrace();
//    		return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
//    	}
//    }
    
    /**
	 * 插入一条answer记录(注意有2种情况：所以要保证url格式一致)
	 * 注意：出现乱码
	 * @return
	 */
	@RequestMapping(value = "/answer/insert/", method = RequestMethod.POST)
	@ResponseBody
	public PytheResult insertAnswer(@RequestBody String url) throws Exception {

		try {
			return PytheResult.ok(service.insertAnswer(url));
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    
	
	/**
	 * 选择一级知识点列表
	 * @param subjectId 该参数是科目的ID,由问题者发出
	 * @param gradeId
	 */
    @RequestMapping(value="/answer/knowledgeList/one", method=RequestMethod.GET)
	@ResponseBody
	public PytheResult selectKnowledgeList(@RequestParam("subjectId")Integer subjectId,
			@RequestParam("studentId")Long studentId){
    	try {
    		return PytheResult.ok(service.selectKnowledgeList(subjectId,studentId));
    	} catch (Exception e) {
    		e.printStackTrace();
    		return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
    	}
    }
    
    
	/**
	 * 点击一级列表然后选择二级知识点列表
	 * @param level1
	 */
    @RequestMapping(value="/answer/knowledgeList/two", method=RequestMethod.GET)
	@ResponseBody
	public PytheResult selectKnowledgeList(@RequestParam("level1")String level1){
    	try {
    		return PytheResult.ok(service.selectSecondKnowledgeList(level1));
    	} catch (Exception e) {
    		e.printStackTrace();
    		return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
    	}
    }
    
    /**
     * 老师的已答和未答列表
     */
    /**
     * 我答:未答列表
     * @param teacherId
     * @return
     */
    @RequestMapping(value = "/teacher/answer/isnot", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult  selectIsNotAnswerListByTeacherId(@RequestParam("teacherId")Long teacherId,
			@RequestParam(defaultValue="1") Integer pageNum,
			@RequestParam(defaultValue="10") Integer pageSize){
    	try {
			return questionAnswersService.selectIsNotAnswerListByTeacherId(teacherId,pageNum,pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    
    
    
    /**
     * 我答:已答列表
     * @param teacherId
     * @return
     */
    @RequestMapping(value = "/teacher/answer/is", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult  selectIsAnswerListByTeacherId(@RequestParam("teacherId")Long teacherId,
			@RequestParam(defaultValue="1") Integer pageNum,
			@RequestParam(defaultValue="10") Integer pageSize){
    	try {
			return questionAnswersService.selectIsAnswerListByTeacherId(teacherId,pageNum,pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    
    
    
    /**
     * 学生的已答和未答列表
     */
    /**
     * 我答:未答列表
     * @param teacherId
     * @return
     */
    @RequestMapping(value = "/student/answer/isnot", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult  selectIsNotAnswerListByStudentId(@RequestParam("studentId")Long studentId,
			@RequestParam(defaultValue="1") Integer pageNum,
			@RequestParam(defaultValue="10") Integer pageSize){
    	try {
			return questionAnswersService.selectIsNotAnswerListByStudentId(studentId,pageNum,pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    
    
    /**
     * 我答:已答列表
     * @param teacherId
     * @return
     */
    @RequestMapping(value = "/student/answer/is", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult  selectIsAnswerListByStudentId(@RequestParam("studentId")Long studentId,
			@RequestParam(defaultValue="1") Integer pageNum,
			@RequestParam(defaultValue="10") Integer pageSize){
    	try {
			return questionAnswersService.selectIsAnswerListByStudentId(studentId,pageNum,pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    
    
    
    /**
     * 查看答案详情
     * @return
     */
    @RequestMapping(value = "/answer/detail", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult  selectAnswerByQuestionId(
			@RequestParam("userId")Long userId,
			@RequestParam("questionId")Long questionId){
    	try {
			return questionAnswersService.selectQuestionDetail(userId,questionId);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    
    
 
    
    
}  
