package com.pythe.rest.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.pythe.common.pojo.PytheResult;
import com.pythe.common.utils.JsonUtils;
import com.pythe.mapper.TblAnswerMapper;
import com.pythe.mapper.TblOrganizationMapper;
import com.pythe.mapper.TblQuestionMapper;
import com.pythe.mapper.TblUserMapper;
import com.pythe.mapper.VQuestionAnswersMapper;
import com.pythe.mapper.VTeacherMapper;
import com.pythe.pojo.Collection;
import com.pythe.pojo.TblAnswer;
import com.pythe.pojo.TblAnswerExample;
import com.pythe.pojo.TblOrganization;
import com.pythe.pojo.TblQuestion;
import com.pythe.pojo.TblQuestionExample;
import com.pythe.pojo.TblUserWithBLOBs;
import com.pythe.pojo.VQuestionAnswersExample;
import com.pythe.pojo.VQuestionAnswersWithBLOBs;
import com.pythe.pojo.VTeacherExample;
import com.pythe.pojo.VTeacherWithBLOBs;
import com.pythe.rest.service.QuestionService;
import com.vdurmont.emoji.EmojiParser;
import com.vdurmont.emoji.EmojiParser.FitzpatrickAction;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private TblQuestionMapper mapper;

	@Autowired
	private TblAnswerMapper answerMapper;
	
	@Autowired
	private TblQuestionMapper questionMapper;

	@Autowired
	private VTeacherMapper teacherMapper;

	@Autowired
	private TblUserMapper userMapper;
	
	@Autowired
	private TblOrganizationMapper organizationMapper;

	@Autowired
	private VQuestionAnswersMapper questionAnswersMapper;

	@Value("${QUESTION_REWARD_STATUS}")
	private Integer QUESTION_REWARD_STATUS;

	@Value("${QUESTION_CHOOSED_STATUS}")
	private Integer QUESTION_CHOOSED_STATUS;

	@Value("${ANSWER_SELECTED_STATUS}")
	private Integer ANSWER_SELECTED_STATUS;

	@Value("${IS_ANSWER_INIT}")
	private String IS_ANSWER_INIT;

	// @Value("${USER_IS_SELECT_INIT}")
	// private String USER_IS_SELECT_INIT;

	// 向老师插入问题或者普通插入
	@Override
	public Object insertQuestion(String url) {
		// q.questionId,q.studentId,q.teacherId,q.questionContent,q.reward,q.startTime,q.endTime,q.subject,

		JSONObject json = JSON.parseObject(url).getJSONObject("parameters");
		Long studentId = json.getLong("studentId");
		JSONObject questionContent = json.getJSONObject("questionContent");
		// 钱一定要改回来才可以，或者给的钱和插到数据库里面的钱。

		double reward = json.getDouble("reward");
		Integer subjectId = json.getIntValue("subjectId");
		TblQuestion question = new TblQuestion();
		question.setStudentid(studentId);
		Long teacherId = json.getLong("teacherId");
		question.setTeacherid(teacherId);

		// 给是否已经答，设置一下IS_ANSWER_INIT
		question.setAnswered(IS_ANSWER_INIT);
		question.setQuestioncontent(EmojiParser.parseToAliases(questionContent.toJSONString(), FitzpatrickAction.PARSE));
		question.setReward(reward);
		question.setStarttime(new Date());
		question.setSubjectid(subjectId);
		question.setStatus(QUESTION_REWARD_STATUS);
		mapper.insert(question);
		
		return question.getQuestionid();
	}

	@Override
	public PytheResult selectTeacherList(Long userId, Integer subjectId, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<VTeacherWithBLOBs> list = new LinkedList<VTeacherWithBLOBs>();
		

		VTeacherExample example = new VTeacherExample();
		example.createCriteria().andSubjectidEqualTo(subjectId);
		list = teacherMapper.selectByExampleWithBLOBs(example);
		
		List<Long> teacherList = new LinkedList<Long>();
		if (userId != -1) 
		{
			TblUserWithBLOBs user = userMapper.selectByPrimaryKey(userId);
			Collection collection = JsonUtils.jsonToPojo(user.getCollection(), Collection.class);
			teacherList = collection.getTeacherIds();
		}
		
		// answerList没有收藏过

		List<JSONObject> resultList = new ArrayList<>();
		for (VTeacherWithBLOBs record : list) {
			JSONObject json = new JSONObject();
			record.setUsername(EmojiParser.parseToUnicode(record.getUsername()));
	    	record.setDescription(EmojiParser.parseToUnicode(record.getDescription()));
			json.put("question", JsonUtils.objectToJson(record));
			if (teacherList.isEmpty()) {
				json.put("isClick", 0);
			} else if (!teacherList.isEmpty() && teacherList.contains(record.getUserid())){
				json.put("isClick", 1);
			}
			else
			{
				json.put("isClick", 0);
			}
			resultList.add(json);
		}
		return PytheResult.ok(resultList);
	}

//	@Override
//	public List<TblQuestion> selectQuestionListByStudentId(Long studentId, Integer pageNum, Integer pageSize) {
//		// TODO Auto-generated method stub
//		PageHelper.startPage(pageNum, pageSize);
//		return mapper.selectQuestionListByStudentId(studentId);
//	}

	@Override
	public int insertAnswersAndDistributeMoneyByQuestionId(Long userId, Long questionId, String answerIds) {
		// 对question表的处理
		TblQuestion question = mapper.selectByPrimaryKey(questionId);

		// 对answer表的处理
		List<Long> idList = new ArrayList<Long>();
		for (String answerId : answerIds.split(",")) {
			idList.add(Long.parseLong(answerId));
		}

		// 更新题的被选状态，和该题被他人选中的状态
		TblQuestion record = new TblQuestion();
		record.setQuestionid(questionId);
		record.setStatus(QUESTION_CHOOSED_STATUS);
		// List<Long> selectList =
		// JSONObject.parseArray(question.getUsersSelected(), Long.class);
		// selectList.add(userId);
		// record.setUsersSelected(JsonUtils.objectToJson(selectList));
		record.setUsersSelected(userId + "");
		mapper.updateByPrimaryKeySelective(record);

		// 分发钱
		TblAnswer answer = new TblAnswer();
		answer.setRewardnum(question.getReward() / new Integer(idList.size()).doubleValue());
		answer.setaStatus(ANSWER_SELECTED_STATUS);
		TblAnswerExample example = new TblAnswerExample();
		example.createCriteria().andAnsweridIn(idList);

		return answerMapper.updateByExampleSelective(answer, example);
	}

	@Override
	public TblAnswer findAnswerByAnswerId(Long answerId) {

		return answerMapper.selectByPrimaryKey(answerId);
	}

	@Override

	public PytheResult updateLikesByTeacherId(Long userId, Long teacherId) {

		//先找到用户收藏列表
		TblUserWithBLOBs user = userMapper.selectByPrimaryKey(userId);
		Collection collection = JsonUtils.jsonToPojo(user.getCollection(), Collection.class);
		if(collection == null)
		{
			List<Long> teacherList = new ArrayList<Long>();
			teacherList.add(teacherId);
			Collection collection1 = new Collection();
			collection1.setTeacherIds(teacherList);
			
			
			user.setCollection(JsonUtils.objectToJson(collection1));
			userMapper.updateByPrimaryKeySelective(user);
			
			TblUserWithBLOBs teacher = userMapper.selectByPrimaryKey(teacherId);
			TblUserWithBLOBs record = new TblUserWithBLOBs();
			List<Long> popularityList = JSONObject.parseArray(teacher.getPopularity(), Long.class);
			popularityList.add(userId);
			teacher.setPopularity(JsonUtils.objectToJson(popularityList));
			
			userMapper.updateByPrimaryKeySelective(teacher);
			
			return PytheResult.ok("关注成功");
		}
		
		List<Long> teacherList = collection.getTeacherIds();


		// 修改收藏列表
		teacherList.add(teacherId);
		Collection collection2 = new Collection();
		collection2.setTeacherIds(teacherList);
		collection2.setQuestions(collection.getQuestions());
		collection2.setAnswers(collection.getAnswers());
		
        //将收藏列表放回该用户上
		user.setCollection(JsonUtils.objectToJson(collection2));
		userMapper.updateByPrimaryKeySelective(user);

		
		// 后给老师添加学生ID,用于统计有多少学生关注过该老师
		TblUserWithBLOBs teacher = userMapper.selectByPrimaryKey(teacherId);
		TblUserWithBLOBs record = new TblUserWithBLOBs();
		List<Long> popularityList = JSONObject.parseArray(teacher.getPopularity(), Long.class);
		popularityList.add(userId);
		teacher.setComplaintlist(JsonUtils.objectToJson(popularityList));
		userMapper.updateByPrimaryKeySelective(teacher);
		
		return PytheResult.ok("关注成功");

	}

	@Override
	public PytheResult selectAnswersByQuestionId(Long userId, Long questionId) {

		VQuestionAnswersExample example = new VQuestionAnswersExample();
		example.createCriteria().andQuestionidEqualTo(questionId).andAnsweridIsNotNull();
		List<VQuestionAnswersWithBLOBs> list = questionAnswersMapper.selectByExampleWithBLOBs(example);
		TblUserWithBLOBs user = userMapper.selectByPrimaryKey(userId);
		// 投诉列表放的是answerId
		List<Long> compaintList = JSONObject.parseArray(user.getComplaintlist(), Long.class);
		List<JSONObject> resultList = new ArrayList<>();
		for (VQuestionAnswersWithBLOBs record : list) {
			JSONObject json = new JSONObject();
			json.put("question", JsonUtils.objectToJson(record));
			if (compaintList.contains(record.getAnswerid())) {
				json.put("isClick", 0);
			} else {
				json.put("isClick", 1);
			}
			resultList.add(json);
		}

		return PytheResult.ok(resultList);
	}

	@Override
	public PytheResult selectTeacherDetail(Long userId) {
		// TODO Auto-generated method stub
		VTeacherExample example = new VTeacherExample();
		example.createCriteria().andUseridEqualTo(userId);
		VTeacherWithBLOBs teacher = teacherMapper.selectByExampleWithBLOBs(example).get(0);
		List<Long> populairyList = JSONObject.parseArray(teacher.getPopularity(), Long.class);
		List<Long> solvedList = JSONObject.parseArray(teacher.getSolved(), Long.class);
		

		JSONObject json = new JSONObject();
		json.put("name", EmojiParser.parseToUnicode(teacher.getUsername()));
		json.put("icon", teacher.getUserimg());
		json.put("description", EmojiParser.parseToUnicode(teacher.getDescription()));
		
		TblOrganization org = organizationMapper.selectByPrimaryKey(teacher.getOrganizationid());
		if(org != null )
		{
			json.put("org", org);
			json.put("orgName", org.getName());
		}
		

		if (solvedList.size() > 0) {
			//查看题
			TblQuestionExample example2 = new TblQuestionExample();
			example2.createCriteria().andQuestionidIn(solvedList);
			List<TblQuestion> questionList = mapper.selectByExampleWithBLOBs(example2);
			json.put("questionList", questionList);
		}else{
			json.put("questionList",null);
		}
		
		double sovledQuantity = (double)solvedList.size();
		if(sovledQuantity > 999)
		{
			sovledQuantity = sovledQuantity / 1000;
			json.put("solvedCount", String.valueOf(sovledQuantity) + "K");
		}
		else
		{
			json.put("solvedCount", sovledQuantity);
		}
		
		double populairyQuantity = (double)populairyList.size();
		if(populairyQuantity > 999)
		{
			populairyQuantity = populairyQuantity / 1000;
			json.put("populairyCount", String.valueOf(populairyQuantity) + "K");
		}
		else
		{
			json.put("populairyCount", populairyQuantity);
		}
		
		return PytheResult.ok(json);
	}

	@Override
	public boolean closeQuestion(Long questionId) {
		
		TblQuestion question = questionMapper.selectByPrimaryKey(questionId);
		question.setStatus(2);
		questionMapper.updateByPrimaryKeySelective(question);
		
		return true;
	}

}
