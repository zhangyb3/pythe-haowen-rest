package com.pythe.rest.controller;

import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pythe.common.pojo.PytheResult;
import com.pythe.common.utils.ExceptionUtil;
import com.pythe.rest.service.MessageService;






@Controller
public class MessageController {  
	
	@Autowired  
    private MessageService service;  
      
    
    /**
	 *发送一条短信
	 * @return
	 */
	@RequestMapping(value = "/message/verification/", method = RequestMethod.POST)
	@ResponseBody
	public PytheResult singleSend(@RequestBody String url) throws Exception {

		url = URLDecoder.decode(url, "UTF-8");
		System.out.println(url);

		try {
			return service.singleSend(url);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	/**
	 * 模版消息
	 *localhost:8081/rest/user/push/imformation?openid=oU6Xr0Iddiof1I7YFsioFTkwmJiU&prepay_id=wx2017072119473215210610f20231611249
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/ask/push/information", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult pushQuestionInformationToTeacher(
//			@RequestParam(required = true, value = "openid") String  openid,
			@RequestParam(required = true, value = "prepay_id") String prepay_id
			) {
		try {
			return service.pushQuestionInformationForUser(prepay_id);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	
	@RequestMapping(value = "/answer/push/information", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult pushAnswerInformationToStudent(
			@RequestParam(required = true, value = "answerId") Long answerId
			) {
		try {
			return service.pushAnswerInformationToStudent(answerId);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    
    
    
}  
