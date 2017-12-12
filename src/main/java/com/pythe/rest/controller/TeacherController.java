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
import com.pythe.rest.service.OrganizationService;
import com.pythe.rest.service.QuestionService;
import com.pythe.rest.service.RecordService;

@Controller
public class TeacherController {

	@Autowired
	private QuestionService service;
	
	@Autowired
	private OrganizationService orgService;
	
	@Autowired
	private RecordService recordService;

    /**
	 * 点赞老师
	 * 先更新学生已收藏列表，后更新老师被收藏列表（统计老师被谁关注）
	 * @return
	 */
	  @RequestMapping(value = "/question/teacher/likes", method = RequestMethod.GET)
		@ResponseBody
		public PytheResult  updateLikesByTeacherId(
				@RequestParam(required = true,value = "userId")Long userId,
				@RequestParam(required = true,value = "teacherId")Long teacherId
				){
	    	try {

				return service.updateLikesByTeacherId(userId,teacherId);
			} catch (Exception e) {
				e.printStackTrace();
				return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
			}
		}

	  
	  
	  
	  /**
	   * 创建机构
	   */
	  @RequestMapping(value = "/teacher/setupOrg", method = RequestMethod.GET)
	  @ResponseBody
	  public PytheResult  setupOrganizationByTeacher(
			@RequestParam(required = true,value = "teacherId")Long teacherId,
			@RequestParam(defaultValue="")String orgName
		)
	  {
		  
    	try {

			return orgService.setupOrg(teacherId,orgName);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	  }
	  
	  
	  /**
	   * 编辑机构
	   */
	  @RequestMapping(value = "/teacher/editOrg", method = RequestMethod.POST)
	  @ResponseBody
	  public PytheResult  editOrganizationByTeacher(
			  @RequestBody String parameters
		)
	  {
		  
    	try {
    		parameters = URLDecoder.decode(parameters, "UTF-8");
    		JSONObject json = JSONObject.parseObject(parameters);
    		String orgName = json.getString("orgName");
    		String orgDescription = json.getString("description");
    		String orgAddress = json.getString("address");
    		Double orgLatitude = json.getDouble("latitude");
    		Double orgLongitude = json.getDouble("longitude");
    		Long managerId= json.getLong("managerId");
    		
			return orgService.editOrg(managerId,orgName,orgDescription,orgAddress,orgLatitude,orgLongitude);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	  }
	  
	  
	  /**
	   * 编辑
	   */
	  @RequestMapping(value = "/teacher/orgQuery", method = RequestMethod.GET)
	  @ResponseBody
	  public PytheResult  orgQueryTeacher(
			  @RequestParam(required = true,value = "teacherPhone")String teacherPhone,
			  @RequestParam(required = true,value = "orgId")Long orgId
		)
	  {
		  
    	try {
    		
    		
			return orgService.orgQueryTeacher(orgId,teacherPhone);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	  }
	  
  
    
	  /**
	   * 编辑
	   */
	  @RequestMapping(value = "/teacher/orgAdd", method = RequestMethod.GET)
	  @ResponseBody
	  public PytheResult  addOrgTeacher(
			  @RequestParam(required = true,value = "teacherId")Long teacherId,
			  @RequestParam(required = true,value = "orgId")Long orgId
		)
	  {
		  
    	try {
    		
    		
			return orgService.addOrgTeacher(orgId,teacherId);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	  }
	  
	  
    
	  
	  /**
	   * 编辑
	   */
	  @RequestMapping(value = "/teacher/orgDelete", method = RequestMethod.GET)
	  @ResponseBody
	  public PytheResult  deleteOrgTeacher(
			  @RequestParam(required = true,value = "teacherId")Long teacherId,
			  @RequestParam(required = true,value = "orgId")Long orgId
		)
	  {
		  
    	try {
    		
    		
			return orgService.deleteOrgTeacher(orgId,teacherId);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	  }
	  
	  
	  /**
	   * 查账单
	   */
	  @RequestMapping(value = "/teacher/queryBill", method = RequestMethod.GET)
	  @ResponseBody
	  public PytheResult  teacherQueryBills(
			  @RequestParam(required = true,value = "teacherId")Long teacherId,
			  @RequestParam(defaultValue="1") Integer pageNum,
			  @RequestParam(defaultValue="10") Integer pageSize
			  
		)
	  {
		  
    	try {
    		
    		
			return recordService.teacherQueryBills(teacherId,pageNum,pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	  }
	

}
