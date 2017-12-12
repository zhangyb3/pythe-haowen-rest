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
import com.pythe.rest.service.TransferService;
import com.pythe.rest.service.UserService;

@Controller
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private UserService userService;

	
	@RequestMapping(value = "/org/query", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult  queryOrganization(
			@RequestParam(required = true,value = "orgId")Long orgId
	)
	{
		  
		try {

			return organizationService.queryInformation(orgId);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	@RequestMapping(value = "/org/managerQuery", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult managerQueryOrganization(
			@RequestParam(required = true,value = "managerId")Long managerId
	)
	{
		  
		try {

			return organizationService.queryOrgByManager(managerId);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	
	@RequestMapping(value = "/org/queryTeachers", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult  queryOrganizationTeachers(
			@RequestParam(required = true,value = "orgId")Long orgId
	)
	{
		  
		try {

			return organizationService.queryInformationTeachers(orgId);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	/**
	 * 更新机构头像
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/org/updateAvatar", method = RequestMethod.GET)
	@ResponseBody
	public PytheResult updateOrgAvatar(
			@RequestParam(required = true, value = "orgId") Long orgId,
			@RequestParam(required = true, value = "avatar") String avatarUrl
			) {
		try {
			return organizationService.updateAvatar(orgId,avatarUrl);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	
	/**
	 * 查询最近的机构
	 */
	@RequestMapping(value = "/nearestOrgs", method = RequestMethod.POST)
	@ResponseBody
	public PytheResult  queryNearestOrgs(
			@RequestBody String parameters
	)
	{
		  
		try {
			parameters = URLDecoder.decode(parameters, "UTF-8");
    		JSONObject json = JSONObject.parseObject(parameters);
    		
    		double longitude = json.getDoubleValue("longitude");
    		double latitude = json.getDoubleValue("latitude");
    		
    		int pageNum = json.getIntValue("pageNum");
    		int pageSize = json.getIntValue("pageSize");
    		
			return organizationService.queryNearestOrgs(longitude,latitude,pageNum,pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	/**
	 * 刷新地图定点附近的机构
	 */
	@RequestMapping(value = "/nearbyOrgsOnMap", method = RequestMethod.POST)
	@ResponseBody
	public PytheResult  queryNearbyOrgsOnMap(
			@RequestBody String parameters
	)
	{
		  
		try {
			parameters = URLDecoder.decode(parameters, "UTF-8");
    		JSONObject json = JSONObject.parseObject(parameters);
    		
    		double longitude = json.getDoubleValue("longitude");
    		double latitude = json.getDoubleValue("latitude");
    		
    		int quantity = json.getIntValue("quantity");
    		
			return organizationService.queryNearbyOrgsOnMap(longitude,latitude,quantity);
		} catch (Exception e) {
			e.printStackTrace();
			return PytheResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
}
