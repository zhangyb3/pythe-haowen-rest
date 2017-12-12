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
import com.pythe.rest.service.QuestionService;
import com.pythe.rest.service.UserService;

@Controller
public class QuestionController {

	@Autowired
	private QuestionService service;
	
	@Autowired
	private UserService userService;

	/**
	 * 插入一条question记录(注意有2种情况：所以要保证url格式一致)
	 * 注意：出现乱码
	 * @return
	 */
	@RequestMapping(value = "/question/insert/", method = RequestMethod.POST)
	@ResponseBody
	public PytheResult insertQuestion(@RequestBody String url) throws Exception {
		// 调用login方法来验证是否是注册用户
		try {
			return PytheResult.ok(service.insertQuestion(url));
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	
	  /**
     * 老师列表
     * @param gradeId
     * @return
     */
    @RequestMapping(value = "/question/teacherList", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult selectTeacherList(	
			@RequestParam(defaultValue="-1") Long userId,
			@RequestParam(defaultValue="-1") Integer subjectId,
			@RequestParam(defaultValue="1") Integer pageNum,
			@RequestParam(defaultValue="10") Integer pageSize){
    	try {
			return service.selectTeacherList(userId,subjectId,pageNum,pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    
    
    
	  /**
     * 查看老师详情
     * @param gradeId
     * @return
     */
    @RequestMapping(value = "/question/teacher/detail", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult selectTeacherDetail(	
			@RequestParam(required = true, value = "userId") Long userId
			){
    	try {
			return service.selectTeacherDetail(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
    
  
    
    /**
     * 收藏:查看收藏老师列表
     * @param 
     * @param 
     * @return
     */
    @RequestMapping(value = "/collection/teacher", method = RequestMethod.GET)
  	@ResponseBody
  	public PytheResult selectCollectTeacherByTeacherId(@RequestParam("userId")Long userId,
			@RequestParam(defaultValue="1") Integer pageNum,
			@RequestParam(defaultValue="10") Integer pageSize){

    	try {
  			return userService.selectCollectTeacherByTeacherId(userId,pageNum,pageSize);
  		} catch (Exception e) {
  			e.printStackTrace();
  			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
  		}
  	}
	
	

}
