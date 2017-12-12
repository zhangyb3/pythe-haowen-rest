package com.pythe.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.pythe.common.pojo.PytheResult;
import com.pythe.common.utils.JsonUtils;
import com.pythe.mapper.TblOrganizationMapper;
import com.pythe.mapper.TblUserMapper;
import com.pythe.mapper.VTeacherMapper;
import com.pythe.pojo.TblOrganization;
import com.pythe.pojo.TblOrganizationExample;
import com.pythe.pojo.TblOrganizationWithBLOBs;
import com.pythe.pojo.TblUserWithBLOBs;
import com.pythe.pojo.VTeacher;
import com.pythe.pojo.VTeacherExample;
import com.pythe.pojo.VTeacherWithBLOBs;
import com.pythe.rest.service.OrganizationService;
import com.vdurmont.emoji.EmojiParser;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private TblUserMapper userMapper;
	
	@Autowired
	private VTeacherMapper teacherMapper;
	
	@Autowired
	private TblOrganizationMapper organizationMapper;
	

	@Override
	public PytheResult setupOrg(Long teacherId, String orgName) {
		
		VTeacherExample vTeacherExample = new VTeacherExample();
		vTeacherExample.createCriteria().andUseridEqualTo(teacherId);
		VTeacherWithBLOBs teacher = teacherMapper.selectByExampleWithBLOBs(vTeacherExample).get(0);
		
		TblOrganizationExample orgExample = new TblOrganizationExample();
		orgExample.createCriteria().andManagerIdEqualTo(teacherId);
		List<TblOrganizationWithBLOBs> orgs = organizationMapper.selectByExampleWithBLOBs(orgExample);
		
		if(!orgs.isEmpty() && orgs.get(0).getName().equals(orgName) )
		{
			return PytheResult.build(400, "该名称已注册");
		}
		else 
		{
			TblOrganizationWithBLOBs newOrg = new TblOrganizationWithBLOBs();
			newOrg.setName(orgName);
			newOrg.setManagerId(teacherId);
			organizationMapper.insertSelective(newOrg);
			
			TblOrganizationExample organizationExample = new TblOrganizationExample();
			organizationExample.createCriteria().andManagerIdEqualTo(teacherId);
			return PytheResult.ok(organizationMapper.selectByExampleWithBLOBs(organizationExample).get(0));
		}
		
		
	}


	@Override
	public PytheResult editOrg(Long managerId, String orgName, String orgDescription, String orgAddress, Double orgLatitude, Double orgLongitude) {

		TblOrganizationExample orgExample = new TblOrganizationExample();
		orgExample.createCriteria().andManagerIdEqualTo(managerId);
		TblOrganizationWithBLOBs org = organizationMapper.selectByExampleWithBLOBs(orgExample).get(0);
		
		if(orgName != null)
		{
			org.setName(orgName);
		}
		if(orgDescription != null)
		{
			org.setDescription(orgDescription);
		}
		if(orgAddress != null)
		{
			org.setAddress(orgAddress);
		}
		if(orgLatitude != null)
		{
			org.setLatitude(orgLatitude);
		}
		if(orgLongitude != null)
		{
			org.setLongitude(orgLongitude);
		}
		organizationMapper.updateByPrimaryKeySelective(org);
		
		return PytheResult.ok(organizationMapper.selectByExampleWithBLOBs(orgExample));
	}


	@Override
	public PytheResult addOrgTeacher(Long orgId, Long teacherId) {
		
		TblOrganizationWithBLOBs org = organizationMapper.selectByPrimaryKey(orgId);
		
		List<Long> teacherIds = new ArrayList<Long>();
		if(org.getMember() != null)
		{
			teacherIds.addAll(JsonUtils.jsonToList(org.getMember(), Long.class));
		}
		teacherIds.add(teacherId);
		org.setMember(JSON.toJSONString(teacherIds));
		organizationMapper.updateByPrimaryKeySelective(org);
		
		TblUserWithBLOBs teacher = userMapper.selectByPrimaryKey(teacherId);
		teacher.setOrganizationid(orgId);
		userMapper.updateByPrimaryKeySelective(teacher);
		
		return PytheResult.ok(org);
	}


	@Override
	public PytheResult deleteOrgTeacher(Long orgId, Long teacherId) {
		
		TblUserWithBLOBs teacher = userMapper.selectByPrimaryKey(teacherId);
		TblOrganizationWithBLOBs org = organizationMapper.selectByPrimaryKey(orgId);
		List<Long> teacherIds = JsonUtils.jsonToList(org.getMember(), Long.class);
		if(teacherIds.contains(teacherId))
		{
			teacherIds.remove(teacherId);
			org.setMember(JsonUtils.objectToJson(teacherIds));
			organizationMapper.updateByPrimaryKeySelective(org);
			teacher.setOrganizationid(-1L);
			userMapper.updateByPrimaryKeySelective(teacher);
		}
		
		
		
		return PytheResult.ok(org);
	}


	@Override
	public PytheResult orgQueryTeacher(Long orgId, String teacherPhone) {
		
		VTeacherExample teacherExample = new VTeacherExample();
		teacherExample.createCriteria().andPhonenumEqualTo(teacherPhone.trim());
		List<VTeacherWithBLOBs> teachers = teacherMapper.selectByExampleWithBLOBs(teacherExample);
		
		if(teachers.isEmpty())
		{
			return PytheResult.build(400, "无此老师");
		}
		else if(teachers.get(0).getOrganizationid() == null || teachers.get(0).getOrganizationid() <= 0)
		{
			VTeacherWithBLOBs teacher = teachers.get(0);
			teacher.setUsername(EmojiParser.parseToUnicode(teacher.getUsername()));
			teacher.setDescription(EmojiParser.parseToUnicode(teacher.getDescription()));
			return PytheResult.ok(teacher);
		}
		else if(!teachers.get(0).getOrganizationid().equals(orgId))
		{
			return PytheResult.build(400, "无此老师");
		}
		else
		{
			return PytheResult.build(400, "无此老师");
		}
		
	}


	@Override
	public PytheResult queryInformation(Long orgId) {
		
		TblOrganization organization = organizationMapper.selectByPrimaryKey(orgId);
		
		VTeacherExample teacherExample = new VTeacherExample();
		teacherExample.createCriteria().andUseridEqualTo(organization.getManagerId());
		List<VTeacherWithBLOBs> managers = teacherMapper.selectByExampleWithBLOBs(teacherExample);
		if(managers.isEmpty())
		{
			return PytheResult.build(400, "无负责人");
		}
		
		teacherExample.clear();
		teacherExample.createCriteria().andOrganizationidEqualTo(orgId);
		List<VTeacherWithBLOBs> members = teacherMapper.selectByExampleWithBLOBs(teacherExample);
		for(VTeacherWithBLOBs memeber: members)
		{
			memeber.setUsername(EmojiParser.parseToUnicode(memeber.getUsername()));
			memeber.setDescription(EmojiParser.parseToUnicode(memeber.getDescription()));
		}
		
		JSONObject json = new JSONObject();
		json.put("organization", organization);
		VTeacherWithBLOBs manager = managers.get(0);
		manager.setUsername(EmojiParser.parseToUnicode(manager.getUsername()));
		json.put("manager", manager);
		json.put("members", members);
		
		return PytheResult.ok(json);
	}


	@Override
	public PytheResult queryOrgByManager(Long managerId) {
		
		TblOrganizationExample orgExample = new TblOrganizationExample();
		orgExample.createCriteria().andManagerIdEqualTo(managerId);
		List<TblOrganizationWithBLOBs> orgs = organizationMapper.selectByExampleWithBLOBs(orgExample);
		
		if(orgs.isEmpty())
		{
			return PytheResult.build(400, "无机构");
		}
		else
		{
			return PytheResult.ok(orgs.get(0));
		}
	}


	@Override
	public PytheResult queryInformationTeachers(Long orgId) {
		
		VTeacherExample teacherExample = new VTeacherExample();
		teacherExample.createCriteria().andOrganizationidEqualTo(orgId);
		List<VTeacherWithBLOBs> teachers = teacherMapper.selectByExampleWithBLOBs(teacherExample);
		
		if(teachers.isEmpty())
		{
			return PytheResult.build(400, "尚无老师");
		}
		else
		{
			boolean collectOrNot = false;
			List<JSONObject> teacherList = new ArrayList<JSONObject>();
			for(VTeacherWithBLOBs teacher: teachers)
			{
				teacher.setUsername(EmojiParser.parseToUnicode(teacher.getUsername()));
				teacher.setDescription(EmojiParser.parseToUnicode(teacher.getDescription()));
			}
			return PytheResult.ok(teachers);
		}
		
	}


	@Override
	public PytheResult updateAvatar(Long orgId, String avatarUrl) {
		
		TblOrganizationWithBLOBs organization = organizationMapper.selectByPrimaryKey(orgId);
		organization.setAvatar(avatarUrl);
		organizationMapper.updateByPrimaryKeySelective(organization);
		
		return PytheResult.ok(organization);
		
	}


	@Override
	public PytheResult queryNearestOrgs(double longitude, double latitude, int pageNum, int pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		
		List<TblOrganizationWithBLOBs> nearestOrgs = organizationMapper.queryNearestOrgs(longitude,latitude);
		
		
		return PytheResult.ok(nearestOrgs);
	}


	@Override
	public PytheResult queryNearbyOrgsOnMap(double longitude, double latitude, int quantity) {
		
		List<TblOrganizationWithBLOBs> nearbyOrgsOnMap = organizationMapper.queryNearbyOrgsOnMap(longitude,latitude,quantity);
		
		
		return PytheResult.ok(nearbyOrgsOnMap);
	}

	

}








