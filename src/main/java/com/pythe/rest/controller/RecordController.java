package com.pythe.rest.controller;

import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pythe.common.pojo.PytheResult;
import com.pythe.common.utils.ExceptionUtil;
import com.pythe.rest.service.RecordService;
import com.pythe.rest.service.UserService;

@Controller
public class RecordController {
	

	@Autowired
	private UserService service;


	@Autowired
	private RecordService recordService;

	/**
	 * 问题账单
	 */
	@RequestMapping(value = "/record/askQuestion", method = RequestMethod.POST)
	@ResponseBody
	public PytheResult  recordAskQuestion(
			@RequestBody String parameters
	)
	{
		  
		try {
			parameters = URLDecoder.decode(parameters, "UTF-8");
    		JSONObject json = JSONObject.parseObject(parameters);
    		Long studentId = json.getLong("studentId");
    		Long teacherId = json.getLong("teacherId");
    		Long questionId = json.getLong("questionId");
    		Double money = json.getDouble("money");
    		String payId = json.getString("payId");
    		String outTradeNo = json.getString("outTradeNo");
    		
			return recordService.recordAskQuestion(studentId,teacherId,questionId,money,payId,outTradeNo);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	/**
	 * 答题账单
	 */
	@RequestMapping(value = "/record/answerQuestion", method = RequestMethod.POST)
	@ResponseBody
	public PytheResult  recordAnswerQuestion(
			@RequestBody String parameters
	)
	{
		  
		try {
			parameters = URLDecoder.decode(parameters, "UTF-8");
    		JSONObject json = JSONObject.parseObject(parameters);
    		Long studentId = json.getLong("studentId");
    		Long teacherId = json.getLong("teacherId");
    		Long answerId = json.getLong("answerId");
    		Double money = json.getDouble("money");
    		
			return recordService.recordAnswerQuestion(studentId,teacherId,answerId,money);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	
	/**
	 * 查询账单
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/bill/check", method = RequestMethod.POST)
	@ResponseBody
	public PytheResult checkBill(@RequestBody String params) throws Exception {
	

		params = URLDecoder.decode(params, "UTF-8");
		try {
			return PytheResult.ok(recordService.checkBill(params));
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	/**
	 * 查询账单对应问答详情
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/bill/checkQADetail", method = RequestMethod.POST)
	@ResponseBody
	public PytheResult checkBillDetail(@RequestBody String params) throws Exception {
	

		params = URLDecoder.decode(params, "UTF-8");
		try {
			return (recordService.checkBillQADetail(params));
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	
	/**
	 * 打赏纪录
	 */
	@RequestMapping(value = "/record/rewardAnswer", method = RequestMethod.POST)
	@ResponseBody
	public PytheResult  recordAnswerReward(
			@RequestBody String parameters
	)
	{
		  
		try {
			parameters = URLDecoder.decode(parameters, "UTF-8");
    		JSONObject json = JSONObject.parseObject(parameters);
    		Long studentId = json.getLong("studentId");
    		Long teacherId = json.getLong("teacherId");
    		Long answerId = json.getLong("answerId");
    		Double money = json.getDouble("money");
    		String payId = json.getString("payId");
    		String outTradeNo = json.getString("outTradeNo");
    		
			return recordService.recordAnswerReward(studentId,teacherId,answerId,money,payId,outTradeNo);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
}
