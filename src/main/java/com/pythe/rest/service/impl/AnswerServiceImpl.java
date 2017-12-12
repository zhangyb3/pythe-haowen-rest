package com.pythe.rest.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.pythe.common.pojo.PytheResult;
import com.pythe.common.utils.JsonUtils;
import com.pythe.mapper.TblAnswerMapper;
import com.pythe.mapper.TblBillMapper;
import com.pythe.mapper.TblKnowledgeMapper;
import com.pythe.mapper.TblQuestionMapper;
import com.pythe.mapper.TblUserMapper;
import com.pythe.mapper.VQuestionAnswersMapper;
import com.pythe.pojo.Collection;
import com.pythe.pojo.TblAnswer;
import com.pythe.pojo.TblAnswerExample;
import com.pythe.pojo.TblUserWithBLOBs;
import com.pythe.pojo.TblAnswerExample.Criteria;
import com.pythe.pojo.TblBill;
import com.pythe.pojo.TblBillExample;
import com.pythe.pojo.TblKnowledge;
import com.pythe.pojo.TblQuestion;
import com.pythe.pojo.TblUserExample;
import com.pythe.pojo.VQuestion;
import com.pythe.pojo.VQuestionAnswersExample;
import com.pythe.pojo.VQuestionExample;
import com.pythe.rest.service.AnswerService;
import com.vdurmont.emoji.EmojiParser;
import com.pythe.rest.dao.JedisClient;


@Service
public class AnswerServiceImpl implements AnswerService{
	@Autowired
	private TblAnswerMapper mapper;
	@Autowired
	private TblQuestionMapper questionMapper;
	@Autowired
	private TblUserMapper userMapper;
	@Autowired
	private TblKnowledgeMapper knowledgeMapper;
	@Autowired
	private TblBillMapper billMapper;

	@Value("${REDIS_USER_SESSION_KEY}")
	private String REDIS_USER_SESSION_KEY;
	@Value("${QUESTION_REWARD_STATUS}")
	private Integer QUESTION_REWARD_STATUS;
	@Value("${QUESTION_CHOOSED_STATUS}")
	private Integer QUESTION_CHOOSED_STATUS;
	@Value("${QUESTION_SOLVED_STATUS}")
	private Integer QUESTION_SOLVED_STATUS;

	
	@Override
	public PytheResult updateLikesNumById(Long userId, Long questionId, Long answerId){
		// 检测是否点赞过某条题
		TblUserWithBLOBs user = userMapper.selectByPrimaryKey(userId);
		Collection collection = JsonUtils.jsonToPojo(user.getCollection(), Collection.class);
		List<Long> answerList =  collection.getAnswers();
//		//answerList没有收藏过
//	    if (answerList.contains(answerId)) {
//	    	return 0;
//		}
		
		//1先收
		List<Long> questions = new ArrayList<Long>();
		List<Long> answers = new ArrayList<Long>();
		
		for (Long question : collection.getQuestions()) {
			questions.add(question);
		}
		for (Long answer : collection.getAnswers()) {
			answers.add(answer);
		}
		
		questions.add(questionId);
		answers.add(answerId);

		Collection collection2 = new Collection();
		collection2.setAnswers(answers);
		collection2.setQuestions(questions);
		collection2.setTeacherIds(collection.getTeacherIds());

		TblUserWithBLOBs user2 = new TblUserWithBLOBs();
		user2.setUserid(user.getUserid());
		user2.setCollection(JsonUtils.objectToJson(collection2));
		userMapper.updateByPrimaryKeySelective(user2);
		//========================================================
		//2后插入记录
		TblAnswerExample example = new TblAnswerExample();
		Criteria criteria = example.createCriteria();
		criteria.andAnsweridEqualTo(answerId);
		
		Long likesNum = mapper.selectByPrimaryKey(answerId).getLikesnum();
		TblAnswer answer = new TblAnswer();
		answer.setLikesnum(likesNum+1);
		mapper.updateByExampleSelective(answer, example);
		return PytheResult.ok("点赞成功");
	}

	@Override
	public PytheResult updateRewardNumById(Long answerId,Double fee,Long questionId,String openId) {

		//根据token从redis中查询用户信息
//		String json = jedisClient.get(REDIS_USER_SESSION_KEY + ":" + openId);
//		//判断是否为空
//		if (StringUtils.isBlank(json)) {
//			System.out.println("===================================>我进来了");
//			TblAnswerExample example = new TblAnswerExample();
//			Criteria criteria = example.createCriteria();
//			criteria.andAnsweridEqualTo(answerId);
//			//先查出TblAnswerId的likeNum
//			TblAnswer answer = mapper.selectByPrimaryKey(answerId);
//			//给rewardNum+fee 同时 likesNum也要加1
//			TblAnswer answer1 = new TblAnswer();
//			answer1.setFee(answer.getFee()+fee);
//			return mapper.updateByExampleSelective(answer1, example);
//		}
		
		
		TblAnswerExample example = new TblAnswerExample();
		Criteria criteria = example.createCriteria();
		criteria.andAnsweridEqualTo(answerId);
		//先查出TblAnswerId的likeNum
		TblAnswer answer = mapper.selectByPrimaryKey(answerId);
		
		//给rewardNum+fee 同时 likesNum也要加1
		TblAnswer answer1 = new TblAnswer();
		answer1.setFee(answer.getFee()+fee);
		int num = mapper.updateByExampleSelective(answer1, example);
		//并收藏
		TblUserExample example2 = new TblUserExample();
		example2.createCriteria().andOpenidEqualTo(openId);
		List<TblUserWithBLOBs> userList = userMapper.selectByExampleWithBLOBs(example2);
		
		System.out.println("updateRecordNum=============>"+updateLikesNumById(userList.get(0).getUserid(),questionId,answerId));
		return PytheResult.ok("打赏成功");
	}

//	@Override
//	public PytheResult selectAnswerDefaultList(Long teacherId,Integer pageNum, Integer pageSize) {
//		VQuestionExample example = new VQuestionExample();
//		//没有5号状态
//		example.createCriteria().andStatusEqualTo(QUESTION_REWARD_STATUS);
//		example.setOrderByClause("startTime desc");
//		PageHelper.startPage(pageNum, pageSize);
//		List<VQuestion> list = vQuestionMapper.selectByExampleWithBLOBs(example);
//		System.out.println("================》list.size"+list.size());
//		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
//		List<JSONObject> resultList=new ArrayList<>();
//		for (VQuestion vQuestion2 : list) {
//			JSONObject json = new JSONObject();
//			json.put("question", JsonUtils.objectToJson(vQuestion2));
//			json.put("current", vQuestion2.getCounter().getTime());
//			json.put("timer",format.format(vQuestion2.getCounter()));
//			List<Long> answeredList = JSONObject.parseArray(vQuestion2.getAnswered(), Long.class);
//		    if (answeredList.contains(teacherId)) {
//		    	json.put("isAnswered",0);
//			}else{
//				json.put("isAnswered",1);
//			}
//			resultList.add(json);
//		}
//        return PytheResult.ok(resultList);
//	}

//	@Override
//	public List<JSONObject> selectAnswerConditionList(Long teacherId,Integer subjectId, String condition, String order,Integer pageNum, Integer pageSize) {
//		// TODO Auto-generated method stub
//		VQuestionExample example = new VQuestionExample();
//		com.pythe.pojo.VQuestionExample.Criteria criteria = example.createCriteria();
//		criteria.andStatusEqualTo(QUESTION_REWARD_STATUS);
//		//选择科目后才按科目排
//		if (-1!=subjectId) {
//			criteria.andSubjectidEqualTo(subjectId);
//		}
//		
//		example.setOrderByClause(condition+" "+order);
//		PageHelper.startPage(pageNum, pageSize);
//	    List<VQuestion> vQuestion = vQuestionMapper.selectByExampleWithBLOBs(example);
//	    System.out.println("================》vQuestion .size"+vQuestion.size());
//	    
//		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
//		List<JSONObject> list=new ArrayList<>();
//		for (VQuestion vQuestion2 : vQuestion) {
//			JSONObject json = new JSONObject();
//			json.put("question", JsonUtils.objectToJson(vQuestion2));
//			json.put("current", vQuestion2.getCounter().getTime());
//			json.put("timer",format.format(vQuestion2.getCounter()));
//			List<Long> answeredList = JSONObject.parseArray(vQuestion2.getAnswered(), Long.class);
//		    if (answeredList.contains(teacherId)) {
//		    	json.put("isAnswered",0);
//			}else{
//				json.put("isAnswered",1);
//			}
//			list.add(json);
//		}
//		return list;
//	}

	@Override
	public PytheResult insertAnswer(String url) {
		// TODO Auto-generated method stub
		//先更新question 后 更新 answer
		JSONObject json = JSONObject.parseObject(url).getJSONObject("parameters");
		Long questionId = json.getLong("questionId");
		Double rewardNum = json.getDouble("rewardNum");
		
		Long knowledgeId= json.getLong("knowledgeId");
		Long studentId= json.getLong("studentId");
		Long teacherId= json.getLong("teacherId");
		String answerContent = json.getString("answerContent");
				
		TblAnswer answer = new TblAnswer();
		answer.setQuestionid(questionId);
		answer.setKnowledgeid(knowledgeId);
		answer.setStudentid(studentId);
		answer.setTeacherid(teacherId);
		
		answer.setAnswercontent(EmojiParser.parseToUnicode(answerContent));
		answer.setAnswertime(new Date());
		answer.setFee(0d);
		answer.setLikesnum(0l);
		answer.setRewardnum(rewardNum);
		//更新答案
		mapper.insert(answer);
		
		//更新questionId的counter,当counter==0时候，就变掉状态，让别人无法答了。
		//先查quesiton
		TblQuestion question = questionMapper.selectByPrimaryKey(questionId);
		//更新question_updated
		TblQuestion question_updated = new TblQuestion();
		question_updated.setQuestionid(questionId);
		List<Long> answeredList = JSONObject.parseArray(question.getAnswered(), Long.class);
		answeredList.add(teacherId);
		question_updated.setAnswered(JsonUtils.objectToJson(answeredList));
		question_updated.setStatus(QUESTION_SOLVED_STATUS);
		questionMapper.updateByPrimaryKeySelective(question_updated);
		
		TblUserWithBLOBs teacher = userMapper.selectByPrimaryKey(teacherId);
		List<Long> questionList = JSONObject.parseArray(teacher.getSolved(), Long.class);
		questionList.add(questionId);
		teacher.setSolved(JsonUtils.objectToJson(questionList));
		userMapper.updateByPrimaryKeySelective(teacher);
		
		//更新账单
		TblBillExample billExample = new TblBillExample();
		billExample.createCriteria()
		.andObjectidEqualTo(questionId)
		.andStudentOutidEqualTo(studentId)
		.andTeacherInidEqualTo(teacherId);
		
		List<TblBill> bills = billMapper.selectByExample(billExample);
		if(!bills.isEmpty())
		{
			TblBill bill = bills.get(0);
			bill.setPaid(1);
			billMapper.updateByExampleSelective(bill, billExample);
		}
		else
		{
			return PytheResult.build(500, "账单无付款纪录");
		}
		
		
		return PytheResult.ok("插入成功");
	}
	

	@Override
	public PytheResult selectSumByTeacherId(Long teacherId) {
		// TODO Auto-generated method stub
			return PytheResult.ok(mapper.selectSumByTeacherId(teacherId));
	}

	@Override
	public List<TblKnowledge> selectKnowledgeList(Integer subjectId,Long studentId) {
		// 1001语文，1002数学，1003英语
		
	    TblUserExample example = new TblUserExample();
		Integer gradeId =userMapper.selectByExample(example).get(0).getGradeid();
		Integer phase = gradeId/100;
		return knowledgeMapper.selectFirstKnowledgeList(phase,subjectId);
	}

	@Override
	public List<TblKnowledge> selectSecondKnowledgeList(String level1) {
		// TODO Auto-generated method stub
		return knowledgeMapper.selectSecondKnowledgeList(level1);
	}









}
