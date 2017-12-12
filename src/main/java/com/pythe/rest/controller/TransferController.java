package com.pythe.rest.controller;

import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pythe.common.pojo.PytheResult;
import com.pythe.common.utils.ExceptionUtil;
import com.pythe.rest.service.QuestionService;
import com.pythe.rest.service.TransferService;
import com.pythe.rest.service.UserService;

@Controller
public class TransferController {

	@Autowired
	private TransferService transferService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private QuestionService questionService;

	
	/**
	 *个人向企业付款
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/pay/information", method = RequestMethod.POST)
	@ResponseBody
	public PytheResult transferBusiness(@RequestBody String url) throws Exception {
	

		url = URLDecoder.decode(url, "UTF-8");
		try {
			return PytheResult.ok(userService.selectResponseByPrePayImforamtion(url));
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	
	
	/**
	 * 企业向个人转账
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/pay/transfer", method = RequestMethod.POST)
	@ResponseBody
	public PytheResult transferIndividual(@RequestBody String url) throws Exception {
	

		url = URLDecoder.decode(url, "UTF-8");
		try {
			return PytheResult.ok(transferService.transferIndividual(url));
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	/**
	 * 问题账单列表
	 */
	@RequestMapping(value = "/user/record/questionPay", method = RequestMethod.POST)
	@ResponseBody
	public PytheResult  questionPayRecord(
			@RequestBody String parameters
	)
	{
		  
		try {
			parameters = URLDecoder.decode(parameters, "UTF-8");
    		JSONObject json = JSONObject.parseObject(parameters);
    		int pageNum = json.getInteger("pageNum");
    		int pageSize = json.getInteger("pageSize");
    		Long studentId = json.getLong("studentId");
    		
    		
			return transferService.queryQuestionPayRecord(studentId,pageNum,pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	
	/**
	 * 问题账单列表
	 */
	@RequestMapping(value = "/bill/mapQuestion", method = RequestMethod.POST)
	@ResponseBody
	public PytheResult  billMapQuestion(
			@RequestBody String parameters
	)
	{
		  
		try {
			parameters = URLDecoder.decode(parameters, "UTF-8");
    		JSONObject json = JSONObject.parseObject(parameters);
    		
    		Long questionId = json.getLong("questionId");
    		Long studentId = json.getLong("studentId");
    		
    		questionService.closeQuestion(questionId);
    		
			return transferService.billMapQuestion(questionId,studentId);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	
	/**
	 * 订单退款
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/pay/refund", method = RequestMethod.POST)
	@ResponseBody
	public PytheResult refundByOrder(@RequestBody String url) throws Exception {
	

		url = URLDecoder.decode(url, "UTF-8");
		try {
			return PytheResult.ok(transferService.refundByOrder(url));
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	
	
	/**
	 * 老师提现,企业向个人转账
	 * 
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/enchashment", method = RequestMethod.POST)
	@ResponseBody
	public PytheResult teacherEnchashment(@RequestBody String parameters) throws Exception {
	

		parameters = URLDecoder.decode(parameters, "UTF-8");
		try {
			return transferService.teacherEnchashment(parameters);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	
	
	
	

}
