package com.pythe.rest.service.impl;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.pythe.common.pojo.PytheResult;
import com.pythe.common.utils.JsonUtils;
import com.pythe.mapper.TblOrganizationMapper;
import com.pythe.mapper.TblUserMapper;
import com.pythe.mapper.VHomepageListMapper;
import com.pythe.mapper.VTeacherMapper;
import com.pythe.pojo.Collection;
import com.pythe.pojo.TblOrganizationExample;
import com.pythe.pojo.TblUserWithBLOBs;
import com.pythe.pojo.VHomepageListExample;
import com.pythe.pojo.VHomepageListWithBLOBs;
import com.pythe.pojo.VTeacherExample;
import com.pythe.pojo.VTeacherWithBLOBs;
import com.pythe.rest.service.HomeService;
import com.vdurmont.emoji.EmojiParser;

@Service
public class HomeServiceImpl implements HomeService{
	
	@Autowired
	private VHomepageListMapper homeMapper;
	
	@Autowired
	private TblOrganizationMapper organizationMapper;
	
	@Autowired
	private VTeacherMapper teacherMapper;
	
	
	@Autowired
	private TblUserMapper userMapper;
	
	@Value("${ANSWER_SELECTED_STATUS}")
	private Integer ANSWER_SELECTED_STATUS;
	

	@Override
	public List<VHomepageListWithBLOBs> selectListByGradeIdAndSubject(Integer gradeId, Integer subjectId, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
        if (gradeId==-1) {
    		VHomepageListExample example = new VHomepageListExample();
    		example.createCriteria().andSubjectidEqualTo(subjectId);
    		return homeMapper.selectByExampleWithBLOBs(example);
		}
		return homeMapper.selectListByGradeIdAndSubject(gradeId, subjectId);
	}

	@Override
	public PytheResult selectListByQuestionId(Long questionId, Long userId) {
		// TODO Auto-generated method stub
		VHomepageListExample example = new VHomepageListExample();
		example.createCriteria().andQuestionidEqualTo(questionId);
		VHomepageListWithBLOBs questionDetail = homeMapper.selectByExampleWithBLOBs(example).get(0);
		
		questionDetail.setTeachername(EmojiParser.parseToUnicode(questionDetail.getTeachername()));
		questionDetail.setStudentname(EmojiParser.parseToUnicode(questionDetail.getStudentname()));
		
		List<Long> answerList = new LinkedList<Long>();
		if(userId != -1)
		{
			TblUserWithBLOBs user = userMapper.selectByPrimaryKey(userId);
			Collection collection = JsonUtils.jsonToPojo(user.getCollection(), Collection.class);
			answerList =  collection.getAnswers();
		}
		
		//查看用户是否收藏过,并返回问答数据
		JSONObject json = new JSONObject();
		json.put("question", JsonUtils.objectToJson(questionDetail));
		if(userId != -1)
		{
			if (answerList.contains(questionDetail.getAnswerid())) {
		    	json.put("isClick",1);
			}else{
				json.put("isClick",0);
			}
		}
		else
		{
			json.put("isClick",0);
		}
		
		
		return PytheResult.ok(json);
	}
	
	

	@Override
	public List<VHomepageListWithBLOBs> selectDefaultListByGradeId(Integer gradeId,Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
	    if (gradeId==-1) {
	    	VHomepageListExample example = new VHomepageListExample();
	    	List<VHomepageListWithBLOBs> results = homeMapper.selectByExampleWithBLOBs(example);
	    	for(VHomepageListWithBLOBs result: results)
	    	{
	    		result.setTeachername(EmojiParser.parseToUnicode(result.getTeachername()));
				result.setStudentname(EmojiParser.parseToUnicode(result.getStudentname()));
	    	}
	    	
			return results;
		}
	    //根据gradeId给学生返回数据
        List<VHomepageListWithBLOBs> results = homeMapper.selectDefaultListByGradeId(gradeId);
    	for(VHomepageListWithBLOBs result: results)
    	{
    		result.setTeachername(EmojiParser.parseToUnicode(result.getTeachername()));
			result.setStudentname(EmojiParser.parseToUnicode(result.getStudentname()));
    	}
    	
		return results;
	}


	@Override
	public PytheResult selectListByFeeAndLikesNum(Integer gradeId, Integer pageNum, Integer pageSize) {
	     PageHelper.startPage(pageNum, pageSize);
		    if (gradeId==-1) {
		    	VHomepageListExample example = new VHomepageListExample();
		    	example.setOrderByClause("likesNum desc");
		    	return PytheResult.ok(homeMapper.selectByExampleWithBLOBs(example));
			}
	     return PytheResult.ok(homeMapper.selectListByFeeAndLikesNum(gradeId));
	}


	@Override
	public PytheResult selectKnowledgeOrQuestionContent(String query, Long userId, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
    	VHomepageListExample example = new VHomepageListExample();
    	example.createCriteria().andKnowledgeLike("%" + query + "%");
    	
    	List<VHomepageListWithBLOBs> results = homeMapper.selectByExampleWithBLOBs(example);
    	for(VHomepageListWithBLOBs record: results)
    	{
    		record.setStudentname(EmojiParser.parseToUnicode(record.getStudentname()));
	    	record.setTeachername(EmojiParser.parseToUnicode(record.getTeachername()));
    	}
    	
		return PytheResult.ok(results);
	}

	@Override
	public PytheResult selectListByTeacher(String query, Long userId, Integer subjectId, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
//		if (userId==-1) {
//			VTeacherExample example = new VTeacherExample();
//			example.createCriteria().andUsernameLike("%" + query + "%");
//			return PytheResult.ok(teacherMapper.selectByExampleWithBLOBs(example));
//		}
		
		VTeacherExample example = new VTeacherExample();
		if(query.length() >= 1)
		{
			example.createCriteria().andUsernameLike("%" + query + "%");
		}
		if(subjectId != -1)
		{
			example.createCriteria().andSubjectidEqualTo(subjectId);
		}
		List<VTeacherWithBLOBs> list = teacherMapper.selectByExampleWithBLOBs(example);
		TblUserWithBLOBs user = userMapper.selectByPrimaryKey(userId);
		boolean collectOrNot = false;
		List<Long> teacherList = new ArrayList<Long>();
		if(user!=null && user.getCollection()!=null)
		{
			Collection collection = JsonUtils.jsonToPojo(user.getCollection(), Collection.class);
			teacherList = collection.getTeacherIds();
		}
				

		List<JSONObject> resultList=new ArrayList<>();
		for (VTeacherWithBLOBs record : list) {
			JSONObject json = new JSONObject();
			record.setUsername(EmojiParser.parseToUnicode(record.getUsername()));
	    	record.setDescription(EmojiParser.parseToUnicode(record.getDescription()));
			json.put("teacher", JsonUtils.objectToJson(record));
		    if (teacherList.contains(record.getUserid())) {
		    	collectOrNot = true;
			}else{
				collectOrNot = false;
			}
		    json.put("collectOrNot", collectOrNot);
			resultList.add(json);
		}
		return PytheResult.ok(resultList);
	}

	@Override
	public PytheResult selectListByOrganization(String query, Long userId, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
	    TblOrganizationExample example = new TblOrganizationExample();
	    example.createCriteria().andNameLike("%" + query + "%");
		return PytheResult.ok(organizationMapper.selectByExampleWithBLOBs(example));
	}

}