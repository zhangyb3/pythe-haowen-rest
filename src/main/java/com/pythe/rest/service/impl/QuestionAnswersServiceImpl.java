package com.pythe.rest.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.pythe.common.pojo.PytheResult;
import com.pythe.common.utils.JsonUtils;
import com.pythe.mapper.TblUserMapper;
import com.pythe.mapper.VQuestionAnswersMapper;
import com.pythe.mapper.VQuestionIsAnswersMapper;
import com.pythe.mapper.VQuestionNotAnswersMapper;
import com.pythe.pojo.Collection;
import com.pythe.pojo.TblUserWithBLOBs;
import com.pythe.pojo.VHomepageListExample;
import com.pythe.pojo.VHomepageListWithBLOBs;
import com.pythe.pojo.VQuestionAnswers;
import com.pythe.pojo.VQuestionAnswersExample;
import com.pythe.pojo.VQuestionAnswersWithBLOBs;
import com.pythe.pojo.VQuestionIsAnswersExample;
import com.pythe.pojo.VQuestionIsAnswersWithBLOBs;
import com.pythe.pojo.VQuestionNotAnswersExample;
import com.pythe.pojo.VQuestionNotAnswersWithBLOBs;
import com.pythe.rest.service.QuestionAnswersService;
import com.vdurmont.emoji.EmojiParser;

@Service
public class QuestionAnswersServiceImpl implements QuestionAnswersService {
	@Autowired
	private VQuestionAnswersMapper mapper;

	@Autowired
	private TblUserMapper userMapper;

	@Autowired
	private VQuestionIsAnswersMapper questionIsAnswersMapper;

	@Autowired
	private VQuestionNotAnswersMapper questionNotAnswersMapper;

	@Override
	public PytheResult selectIsAnswerListByTeacherId(Long teacherId, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		// List<VQuestionAnswersWithBLOBs> list =
		// mapper.selectIsAnswerListByTeacherId(teacherId);
		VQuestionIsAnswersExample example = new VQuestionIsAnswersExample();
		example.createCriteria().andTeacheridEqualTo(teacherId);
		List<VQuestionIsAnswersWithBLOBs> list = questionIsAnswersMapper.selectByExampleWithBLOBs(example);

		List<JSONObject> resultList = new ArrayList<>();
		for (VQuestionIsAnswersWithBLOBs vQuestionAnswersWithBLOBs : list) {
			JSONObject json = new JSONObject();
			vQuestionAnswersWithBLOBs
					.setQuestioncontent(EmojiParser.parseToUnicode(vQuestionAnswersWithBLOBs.getQuestioncontent()));
			vQuestionAnswersWithBLOBs
					.setAnswercontent(EmojiParser.parseToUnicode(vQuestionAnswersWithBLOBs.getAnswercontent()));
			// 计算时间

			// long l=(new
			// Date().getTime())-vQuestionAnswersWithBLOBs.getStarttime().getTime();
			//
			// long day=l/(24*60*60*1000);
			//
			// long hour=(l/(60*60*1000)-day*24);
			//
			// long min=((l/(60*1000))-day*24*60-hour*60);
			//
			// long second=(l/1000-day*24*60*60-hour*60*60-min*60);
			//
			// String d = String.valueOf(day);
			// String h = String.valueOf(hour);
			// String m = String.valueOf(min);
			// String s = String.valueOf(second);
			//
			// if(day<10) d = "0"+day;
			// if(hour<10) h = "0"+hour;
			// if(min<10) m = "0"+min;
			// if(second<10) s = "0"+second;

			vQuestionAnswersWithBLOBs
					.setTeachername(EmojiParser.parseToUnicode(vQuestionAnswersWithBLOBs.getTeachername()));
			vQuestionAnswersWithBLOBs
					.setStudentname(EmojiParser.parseToUnicode(vQuestionAnswersWithBLOBs.getStudentname()));

			// 装入object中
			// json.put("counter", h+":"+m+":"+s);
			// json.put("question", vQuestionAnswersWithBLOBs);
			// resultList.add(json);
		}
		return PytheResult.ok(list);
		// return
		// PytheResult.ok(mapper.selectIsAnswerListByTeacherId(teacherId));

	}

	@Override
	public PytheResult selectIsNotAnswerListByTeacherId(Long teacherId, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		VQuestionNotAnswersExample example = new VQuestionNotAnswersExample();
		example.createCriteria().andTeacheridEqualTo(teacherId);
		List<VQuestionNotAnswersWithBLOBs> list = questionNotAnswersMapper.selectByExampleWithBLOBs(example);

		// List<VQuestionAnswersWithBLOBs> list =
		// mapper.selectIsNotAnswerListByTeacherId(teacherId);
		List<JSONObject> resultList = new ArrayList<>();
		for (VQuestionNotAnswersWithBLOBs vQuestionAnswersWithBLOBs : list) {
			JSONObject json = new JSONObject();

			vQuestionAnswersWithBLOBs
					.setQuestioncontent(EmojiParser.parseToUnicode(vQuestionAnswersWithBLOBs.getQuestioncontent()));
			// 计算时间
			long l = (new Date().getTime()) - vQuestionAnswersWithBLOBs.getStarttime().getTime();

			long day = l / (24 * 60 * 60 * 1000);

			long hour = (l / (60 * 60 * 1000) - day * 24);

			long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);

			long second = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

			String d = String.valueOf(day);
			String h = String.valueOf(hour);
			String m = String.valueOf(min);
			String s = String.valueOf(second);

			if (day < 10)
				d = "0" + day;
			if (hour < 10)
				h = "0" + hour;
			if (min < 10)
				m = "0" + min;
			if (second < 10)
				s = "0" + second;

			vQuestionAnswersWithBLOBs
					.setTeachername(EmojiParser.parseToUnicode(vQuestionAnswersWithBLOBs.getTeachername()));
			vQuestionAnswersWithBLOBs
					.setStudentname(EmojiParser.parseToUnicode(vQuestionAnswersWithBLOBs.getStudentname()));

			// 装入object中
			json.put("counter", h + ":" + m + ":" + s);
			json.put("question", vQuestionAnswersWithBLOBs);
			resultList.add(json);
		}
		return PytheResult.ok(resultList);
	}

	@Override
	public PytheResult selectIsAnswerListByStudentId(Long studentId, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		VQuestionIsAnswersExample example = new VQuestionIsAnswersExample();
		example.createCriteria().andStudentidEqualTo(studentId);
		List<VQuestionIsAnswersWithBLOBs> list = questionIsAnswersMapper.selectByExampleWithBLOBs(example);

		List<JSONObject> resultList = new ArrayList<>();
		for (VQuestionIsAnswersWithBLOBs vQuestionAnswersWithBLOBs : list) {
			JSONObject json = new JSONObject();
			vQuestionAnswersWithBLOBs
					.setQuestioncontent(EmojiParser.parseToUnicode(vQuestionAnswersWithBLOBs.getQuestioncontent()));
			vQuestionAnswersWithBLOBs
					.setAnswercontent(EmojiParser.parseToUnicode(vQuestionAnswersWithBLOBs.getAnswercontent()));
			// 计算时间
			// long l=(new
			// Date().getTime())-vQuestionAnswersWithBLOBs.getStarttime().getTime();
			//
			// long day=l/(24*60*60*1000);
			//
			// long hour=(l/(60*60*1000)-day*24);
			//
			// long min=((l/(60*1000))-day*24*60-hour*60);
			//
			// long second=(l/1000-day*24*60*60-hour*60*60-min*60);
			//
			// String d = String.valueOf(day);
			// String h = String.valueOf(hour);
			// String m = String.valueOf(min);
			// String s = String.valueOf(second);
			//
			// if(day<10) d = "0"+day;
			// if(hour<10) h = "0"+hour;
			// if(min<10) m = "0"+min;
			// if(second<10) s = "0"+second;

			vQuestionAnswersWithBLOBs
					.setTeachername(EmojiParser.parseToUnicode(vQuestionAnswersWithBLOBs.getTeachername()));
			vQuestionAnswersWithBLOBs
					.setStudentname(EmojiParser.parseToUnicode(vQuestionAnswersWithBLOBs.getStudentname()));

			// 装入object中
			// json.put("counter", h+":"+m+":"+s);
			// json.put("question", vQuestionAnswersWithBLOBs);
			resultList.add(json);
		}
		return PytheResult.ok(list);
		// return
		// PytheResult.ok(mapper.selectIsAnswerListByStudentId(studentId));
	}

	@Override
	public PytheResult selectIsNotAnswerListByStudentId(Long studentId, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		//List<VQuestionAnswersWithBLOBs> list = mapper.selectIsNotAnswerListByStudentId(studentId);

		VQuestionNotAnswersExample example = new VQuestionNotAnswersExample();
		example.createCriteria().andStudentidEqualTo(studentId);
		List<VQuestionNotAnswersWithBLOBs> list = questionNotAnswersMapper.selectByExampleWithBLOBs(example);

		
		List<JSONObject> resultList = new ArrayList<>();
		for (VQuestionNotAnswersWithBLOBs vQuestionAnswersWithBLOBs : list) {
			vQuestionAnswersWithBLOBs
					.setQuestioncontent(EmojiParser.parseToUnicode(vQuestionAnswersWithBLOBs.getQuestioncontent()));
			JSONObject json = new JSONObject();

			// 计算时间
			long l = (new Date().getTime()) - vQuestionAnswersWithBLOBs.getStarttime().getTime();

			long day = l / (24 * 60 * 60 * 1000);

			long hour = (l / (60 * 60 * 1000) - day * 24);

			long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);

			long second = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

			String d = String.valueOf(day);
			String h = String.valueOf(hour);
			String m = String.valueOf(min);
			String s = String.valueOf(second);

			if (day < 10)
				d = "0" + day;
			if (hour < 10)
				h = "0" + hour;
			if (min < 10)
				m = "0" + min;
			if (second < 10)
				s = "0" + second;

			vQuestionAnswersWithBLOBs
					.setTeachername(EmojiParser.parseToUnicode(vQuestionAnswersWithBLOBs.getTeachername()));
			vQuestionAnswersWithBLOBs
					.setStudentname(EmojiParser.parseToUnicode(vQuestionAnswersWithBLOBs.getStudentname()));

			// 装入object中
			json.put("counter", h + ":" + m + ":" + s);
			json.put("question", vQuestionAnswersWithBLOBs);
			resultList.add(json);
		}
		return PytheResult.ok(resultList);
	}

	@Override
	public PytheResult selectQuestionDetail(Long userId, Long questionId) {
		// TODO Auto-generated method stub
		VQuestionAnswersExample example = new VQuestionAnswersExample();
		example.createCriteria().andQuestionidEqualTo(questionId);
		VQuestionAnswersWithBLOBs questionDetail = mapper.selectByExampleWithBLOBs(example).get(0);

		TblUserWithBLOBs user = userMapper.selectByPrimaryKey(userId);
		Collection collection = JsonUtils.jsonToPojo(user.getCollection(), Collection.class);
		List<Long> answerList = collection.getAnswers();
		// 查看用户是否收藏过,并返回问答数据
		JSONObject json = new JSONObject();
		json.put("question", JsonUtils.objectToJson(questionDetail));
		if (answerList.contains(questionDetail.getAnswerid())) {
			json.put("isClick", 1);
		} else {
			json.put("isClick", 0);
		}
		return PytheResult.ok(json);
	}

}
