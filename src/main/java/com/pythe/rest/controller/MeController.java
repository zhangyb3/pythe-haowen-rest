package com.pythe.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pythe.common.pojo.PytheResult;
import com.pythe.common.utils.ExceptionUtil;
import com.pythe.rest.service.AnswerService;
import com.pythe.rest.service.BlacklistService;
import com.pythe.rest.service.QuestionAnswersService;
import com.pythe.rest.service.QuestionService;
import com.pythe.rest.service.UserService;

@Controller
public class MeController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AnswerService answerService;
	
	
	
	@Autowired
	private BlacklistService blacklistService;
	
	
	
	  /**
     * 赚取的总额
     * @param teacherId
     * @return
     */
    @RequestMapping(value = "/me/earn", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult  selectEarnByTeacherId(@RequestParam("teacherId")Long teacherId){
    	try {
			return answerService.selectSumByTeacherId(teacherId);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
   
    
    /**
     * 点击答案，有问题和答案的显示
     * @return
     */
    @RequestMapping(value = "/me/question/click", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult  selectAnswersByQuestionId(
			@RequestParam("userId")Long userId,
			@RequestParam("questionId")Long questionId){
    	try {
			return PytheResult.ok(questionService.selectAnswersByQuestionId(userId,questionId));
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    
    /**
     * 选择答案
     * @param answer1,answer2
     * @return
     */
    @RequestMapping(value = "/me/question/select", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult  insertAnswersAndDistributeMoneyByQuestionId(
			@RequestParam("userId")Long userId,
			@RequestParam("questionId")Long questionId
			,@RequestParam("answerIds")String answerIds){
    	try {
			return PytheResult.ok(questionService.insertAnswersAndDistributeMoneyByQuestionId(userId,questionId,answerIds));
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    
    /**
     * 查看答案详情
     * @param answerId
     * @return
     */
    @RequestMapping(value = "/me/question/answers", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult  findAnswerByAnswerId(@RequestParam("answerId")Long answerId){
    	try {
			return PytheResult.ok(questionService.findAnswerByAnswerId(answerId));
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    
    /**
     * 我问：举报
     * @param userId complainedId
     * @return
     */
    @RequestMapping(value = "/me/question/report", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult  ReportSingleOne(@RequestParam("userId")Long userId,
			@RequestParam("complainedId")Long complainedId,
			@RequestParam("answerId")Long answerId){
    	try {
			return PytheResult.ok(blacklistService.insertBlacklistRecord(userId,complainedId,answerId));
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    
    
    /**
     * 我问：撤销举报
     * @param userId complainedId
     * @return
     */
    @RequestMapping(value = "/me/question/recall", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult  RecallReport(@RequestParam("userId")Long userId,
			@RequestParam("answerId")Long answerId){
    	try {
			return blacklistService.deleteBlacklistRecord(userId,answerId);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    
    
	  /**
     * 编辑用户信息
     * @param username
     * @param description
     * @return
     */
    @RequestMapping(value = "/me/imformation", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult updatePersonalImformation(@RequestParam("userId")  Long userId,
			@RequestParam("username")String username,@RequestParam("description")String description){
    	try {
			return PytheResult.ok(userService.updatePersonalImformation(userId,username,description));
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    
    /**
     * 我的收藏:查看收藏题列表
     * @param 
     * @param 
     * @return
     */
    @RequestMapping(value = "/me/collection/question", method = RequestMethod.GET)
  	@ResponseBody
  	public PytheResult selectCollectQuestionByHomeId(@RequestParam("userId")Long userId,
			@RequestParam(defaultValue="1") Integer pageNum,
			@RequestParam(defaultValue="10") Integer pageSize){
    	try {
  			return (userService.selectCollectQuestionByHomeId(userId,pageNum,pageSize));
  		} catch (Exception e) {
  			e.printStackTrace();
  			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
  		}
  	}
    

}
