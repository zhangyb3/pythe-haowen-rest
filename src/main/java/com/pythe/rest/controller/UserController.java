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
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private RecordService recordService;


	/**
	 * 注册（首次登录）
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	//http://localhost:8081/rest/user/register/
	//{"status":1,"userName":"yangnianen","phoneNum":"13828494261","subjectId":1001,"gradeId":312,openId:"fkhfkha"}
	@RequestMapping(value = "/user/register/", method = RequestMethod.POST)
	@ResponseBody
	public PytheResult register(@RequestBody String url) throws Exception {

		try {
			return service.register(url);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	

	/**
	 * 注册科目列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/register/subject", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult selectAllSubject() {
		try {
			return PytheResult.ok(service.selectAllSubject());
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}

	}

	/**
	 * 注册年级列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/register/grade", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult selectAllGrade() {
		try {
			return PytheResult.ok(service.selectAllGrade());
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}

	}

	/**
	 * 用户解码
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/decode", method = RequestMethod.POST)
	@ResponseBody
	public PytheResult decodeUserInfo(
			@RequestBody String parameters) {
		try {
			JSONObject json = JSONObject.parseObject(parameters);
			String encryptedData = json.getString("encryptedData");
			String iv = json.getString("iv");
			String session_key = json.getString("session_key");
//			System.out.println(encryptedData + "," + iv + "," + session_key);
			return PytheResult.ok(service.decodeUserInfo(encryptedData, iv, session_key));
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	/**
	 * 转发请求
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/login/request", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult updateRequest(@RequestParam(required = true, value = "code") String code) {
		try {

			return PytheResult.ok(service.updateRequest(code));
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	

	/**
	 * 查看sessionId是否存在
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/login/session", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult findSessionId(@RequestParam(required = true, value = "sessionId") String sessionId) {
		try {
			return PytheResult.ok(service.findSessionId(sessionId));
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	
	
	/**
	 * 查看openId上的UserId是否存在
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/login/prepare", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult selectUserIdByOpenId(@RequestParam(required = true, value = "openId") String openId) {
		try {
			return service.selectUserIdByOpenId(openId);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	/**
	 * 查询用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/imformation", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult selectOpenId(@RequestParam(required = true, value = "userId") Long userId) {
		try {
			return service.selectUserByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	/**
	 * 更新用户头像
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/updateAvatar", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult updateAvatar(
			@RequestParam(required = true, value = "userId") Long userId,
			@RequestParam(required = true, value = "avatar") String avatarUrl
			) {
		try {
			return service.updateAvatar(userId,avatarUrl);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	
	
	
	
	
//	/**
//	 * 判断用户是否有点赞过某题的答案
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/user/question/likes", method = RequestMethod.GET)
//	@ResponseBody
//	public PytheResult selectAnswerIsLiked(@RequestParam(required = true, value = "userId") Long userId,
//			@RequestParam(required = true, value = "answerId") Long answerId) {
//		try {
//			return service.selectAnswerIsLiked(userId,answerId);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
//		}
//	}
	
	
	
	
	
//	/**
//	 * 判断用户是否有点赞过某老师
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/user/teacher/likes", method = RequestMethod.GET)
//	@ResponseBody
//	public PytheResult selectTeacherIsLiked(@RequestParam(required = true, value = "userId") Long userId,
//			@RequestParam(required = true, value = "teacherId") Long teacherId) {
//		try {
//			return service.selectTeacherIsLiked(userId,teacherId);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
//		}
//	}
	
	
	
    /**
	 * 查账单
	 */
	@RequestMapping(value = "/student/queryBill", method = RequestMethod.GET)
    @ResponseBody
    public PytheResult  studentQueryBills(
		  @RequestParam(required = true,value = "studentId")Long studentId,
		  @RequestParam(defaultValue="1") Integer pageNum,
		  @RequestParam(defaultValue="10") Integer pageSize
		  
	)
    {
		try {
			return recordService.studentQueryBills(studentId,pageNum,pageSize);
	    } catch (Exception e) {
		e.printStackTrace();
		return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
	    }
    }

	
	
	/**
	 * 查账单
	 */
	@RequestMapping(value = "/user/statistics", method = RequestMethod.GET)
    @ResponseBody
    public PytheResult  queryStatistics(
		  @RequestParam(required = true,value = "userId")Long userId
	)
    {
		try {
			return recordService.queryStatistics(userId);
	    } catch (Exception e) {
		e.printStackTrace();
		return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
	    }
    }


}
