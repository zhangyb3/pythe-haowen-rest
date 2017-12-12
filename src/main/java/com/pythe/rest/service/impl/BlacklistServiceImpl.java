package com.pythe.rest.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pythe.common.pojo.PytheResult;
import com.pythe.common.utils.JsonUtils;
import com.pythe.mapper.TblBlacklistMapper;
import com.pythe.mapper.TblUserMapper;
import com.pythe.pojo.TblBlacklist;
import com.pythe.pojo.TblBlacklistExample;
import com.pythe.pojo.TblUser;
import com.pythe.pojo.TblUserWithBLOBs;
import com.pythe.rest.service.BlacklistService;


@Service
public class BlacklistServiceImpl implements BlacklistService{
	@Autowired
	private TblBlacklistMapper blacklistMapper;
	
	@Autowired
	private TblUserMapper userMapper;
	 
	@Value("${BLACKLIST_CLOCK_STATUS}")
	private Integer BLACKLIST_CLOCK_STATUS;
	
	@Override
	public Long insertBlacklistRecord(Long userId, Long complainedId,Long answerId) {
		// TODO Auto-generated method stub
		TblBlacklistExample example = new TblBlacklistExample();
		example.createCriteria().andUseridEqualTo(userId).andComplainedidEqualTo(complainedId);
		
		//判断是否已经投诉过了
//		List<TblBlacklist> blackList = blacklistMapper.selectByExample(example);
//		if (blackList.size()>0) {
//			return 0l;
//		}
		
		TblBlacklist blacklist = new TblBlacklist();
		blacklist.setUserid(userId);
		blacklist.setStarttime(new Date());
		blacklist.setComplainedid(complainedId);
		blacklist.setComplainedid(answerId);
		blacklist.setStatus(BLACKLIST_CLOCK_STATUS);
		
		//并插入用户投诉表中
		TblUserWithBLOBs user = userMapper.selectByPrimaryKey(userId);
		List<Long> compaintList = JSONObject.parseArray(user.getComplaintlist(), Long.class);
		compaintList.add(answerId);
		user.setComplaintlist(JsonUtils.objectToJson(compaintList));
		userMapper.updateByPrimaryKeySelective(user);
		blacklistMapper.insert(blacklist);
		return blacklist.getBlacklistid();
		
		
	}

	@Override
	public PytheResult deleteBlacklistRecord(Long userId, Long answerId) {
		//删除投诉列表中的
		TblUserWithBLOBs user = userMapper.selectByPrimaryKey(userId);
		List<Long> compaintList = JSONObject.parseArray(user.getComplaintlist(), Long.class);
        compaintList.remove(compaintList.indexOf(answerId));
		user.setComplaintlist(JsonUtils.objectToJson(compaintList));
		userMapper.updateByPrimaryKeySelective(user);
		TblBlacklistExample example = new TblBlacklistExample();
		example.createCriteria().andAnsweridEqualTo(answerId);
		return PytheResult.ok(blacklistMapper.deleteByExample(example));
	}


}
