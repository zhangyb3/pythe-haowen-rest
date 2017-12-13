package com.pythe.rest.service.impl;

import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.pythe.common.pojo.PytheResult;
import com.pythe.common.utils.AES;
import com.pythe.common.utils.FactoryUtils;
import com.pythe.common.utils.HttpClientUtil;
import com.pythe.common.utils.JsonUtils;
import com.pythe.common.utils.Xml2JsonUtil;
import com.pythe.mapper.TblGradeMapper;
import com.pythe.mapper.TblIdentifierMapper;
import com.pythe.mapper.TblQuestionMapper;
import com.pythe.mapper.TblSessionMapper;
import com.pythe.mapper.TblSubjectMapper;
import com.pythe.mapper.TblUserMapper;
import com.pythe.mapper.TblVerificationMapper;
import com.pythe.mapper.VHomepageListMapper;
import com.pythe.mapper.VTeacherMapper;
import com.pythe.pojo.CodePacket;
import com.pythe.pojo.Collection;
import com.pythe.pojo.TblGrade;
import com.pythe.pojo.TblIdentifier;
import com.pythe.pojo.TblIdentifierExample;
import com.pythe.pojo.TblQuestion;
import com.pythe.pojo.TblQuestionExample;
import com.pythe.pojo.TblSession;
import com.pythe.pojo.TblSubject;
import com.pythe.pojo.TblSubjectExample;
import com.pythe.pojo.TblUser;
import com.pythe.pojo.TblUserExample;
import com.pythe.pojo.TblUserWithBLOBs;
import com.pythe.pojo.TblVerification;
import com.pythe.pojo.TblVerificationExample;
import com.pythe.pojo.VHomepageListExample;
import com.pythe.pojo.VHomepageListWithBLOBs;
import com.pythe.pojo.VTeacherExample;
import com.pythe.pojo.VTeacherWithBLOBs;
import com.pythe.rest.service.UserService;
import com.vdurmont.emoji.EmojiParser;
import com.vdurmont.emoji.EmojiParser.FitzpatrickAction;

import org.apache.commons.codec.binary.Base64;
import org.joda.time.DateTime;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private VHomepageListMapper homeMapper;

	@Autowired
	private TblUserMapper userMapper;

	@Autowired
	private TblSubjectMapper subjectMapper;

	@Autowired
	private TblGradeMapper gradeMapper;

	@Autowired
	private VTeacherMapper teacherMapper;

	@Autowired
	private TblSessionMapper sessionMapper;

	@Autowired
	private TblQuestionMapper questionMapper;

	@Autowired
	private TblVerificationMapper verificationMapper;
	
	@Autowired
	private TblIdentifierMapper identifierMapper;
	

	@Value("${USER_COLLECTION_INIT}")
	private String USER_COLLECTION_INIT;
	
	@Value("${USER_COMPLAINTLIST_INIT}")
	private String USER_COMPLAINTLIST_INIT;
	
	@Value("${TEACHER_SOLVED_INIT}")
	private String TEACHER_SOLVED_INIT;
	
	@Value("${TEACHER_POPULARATY_INIT}")
	private String TEACHER_POPULARATY_INIT;

	@Value("${WX_APPID}")
	private String WX_APPID;

	@Value("${WX_APPSECRET}")
	private String WX_APPSECRET;

	@Value("${WX_KEY}")
	private String WX_KEY;

	@Value("${WX_MCH_ID}")
	private String WX_MCH_ID;

	@Value("${WX_OPEN_ID}")
	private String WX_OPEN_ID;
	
	@Value("${REGISTER_GRADELIST_KEY}")
	private String REGISTER_GRADELIST_KEY;
	
	@Value("${REGISTER_SUBJECTLIST_KEY}")
	private String REGISTER_SUBJECTLIST_KEY;
	
	@Value("${REDIS_USER_SESSION_KEY}")
	private String REDIS_USER_SESSION_KEY;
	
	@Value("${SSO_SESSION_EXPIRE}")
	private Integer SSO_SESSION_EXPIRE;


	// @Override
	// public TblUser login(String username, String password) {
	// TblUser user = mapper.selectByName(username);
	// if (user!=null) {
	// if (user.getUsername().equals(username) &&
	// user.getPassword().equals(password)) {
	// return user;
	// }
	// }
	//
	// return null;
	// }

	@Override
	public PytheResult selectAllSubject() {
		// TODO Auto-generated method stub

		
//		String result = jedisClient.get(REGISTER_SUBJECTLIST_KEY);
//		if (!StringUtils.isBlank(result)) {
//			//把字符串转换成list
//			return PytheResult.ok(JsonUtils.jsonToList(result, TblSubject.class));
//		}
		
		TblSubjectExample example = new TblSubjectExample();
		example.createCriteria().andSubjectidGreaterThanOrEqualTo(1000);
		List<TblSubject> list = subjectMapper.selectByExample(example);
		
//		String cacheString = JsonUtils.objectToJson(list);
//		jedisClient.set(REGISTER_SUBJECTLIST_KEY, cacheString);
		
		return PytheResult.ok(list);
	}

	@Override
	public PytheResult selectAllGrade() {
		List<TblGrade> list = gradeMapper.selectByCustomer();
		return PytheResult.ok(list);
		
	}

	@Override
	public TblUser login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PytheResult register(String url) {
		// 用户
		JSONObject user_imformation = JSONObject.parseObject(url);
		//Long userid = user_imformation.getLong("userId");
		String verificationCode= user_imformation.getString("verificationCode");
		String openId= user_imformation.getString("openId");
		String phonenum = user_imformation.getString("phoneNum");
		
		String unionId= user_imformation.getString("unionId");
		
		TblUserExample userExample = new TblUserExample();
		userExample.createCriteria().andOpenidEqualTo(openId);
		List<TblUserWithBLOBs> checkUsers = userMapper.selectByExampleWithBLOBs(userExample);
		if(!checkUsers.isEmpty())
		{
			return PytheResult.build(400, "该微信用户已注册");
		}

		// 注意：用户没有注册，是不可能跳掉这里来的。(只需要判断验证码即可)
		TblVerificationExample example = new TblVerificationExample();
		example.createCriteria().andUserPhoneNumberEqualTo(phonenum)
		.andGenerateTimeGreaterThanOrEqualTo(new DateTime().minusMinutes(1).toDate());
		List<TblVerification> verificationList = verificationMapper.selectByExample(example);
//		//验证码对象不存在：是因为之前没有插入或者超时导致的
		if (verificationList.size()==0) {
			return PytheResult.build(400, "验证码超时");
		}

		TblVerification verification_info = verificationList.get(0);

		//验证码不正确
		if (!verificationCode.equals(verification_info.getVerificationCode())) {
			return PytheResult.build(400, "验证码输入不正确");
		}
		
		// // 判断用户是否已经存在，返回用户
		Integer status = user_imformation.getInteger("status");
		String username = user_imformation.getString("userName");
		String userimg = user_imformation.getString("userImg");
		
		//老师和学生只能选择一样
		TblUserWithBLOBs newUser = new TblUserWithBLOBs();
		if (status == 0) {
			newUser.setGradeid(user_imformation.getInteger("gradeId"));
			newUser.setKnowledgespace("mathspace");
		}else {
			newUser.setGradeid(332);
			newUser.setSubjectid(user_imformation.getInteger("subjectId"));
			newUser.setPopularity(TEACHER_POPULARATY_INIT);
			newUser.setSolved(TEACHER_SOLVED_INIT);
		}
		newUser.setStatus(status);
		
		newUser.setUsername(EmojiParser.parseToAliases(username, FitzpatrickAction.PARSE));
		newUser.setUserimg(userimg);
		newUser.setPhonenum(phonenum);
		newUser.setCreated(new Date());
		newUser.setUpdated(new Date());
		newUser.setOpenid(openId);
		newUser.setStatus(status);
		newUser.setCollection(USER_COLLECTION_INIT);
		newUser.setComplaintlist(USER_COMPLAINTLIST_INIT);
		userMapper.insert(newUser);
//		TblUserWithBLOBs user = userMapper.selectByPrimaryKey(newUser.getUserid());		
		TblIdentifierExample identifierExample = new TblIdentifierExample();
		identifierExample.createCriteria().andMiniprogramOpenidEqualTo(openId);
		List<TblIdentifier> identifiers = identifierMapper.selectByExample(identifierExample);
		if(identifiers.isEmpty())
		{
			TblIdentifier newIdentifier = new TblIdentifier();
			newIdentifier.setMiniprogramOpenid(openId);
			newIdentifier.setUnionid(unionId);
			identifierMapper.insert(newIdentifier);
		}
		
		return PytheResult.ok(newUser);
	}
	
	@Override
	public  PytheResult selectUserIdByOpenId(String openId) {
		// TODO Auto-generated method stub
		
		//根据token从redis中查询用户信息
//		String json = jedisClient.get(REDIS_USER_SESSION_KEY + ":" + openId);
		
		//判断是否为空
//		if (StringUtils.isBlank(json)) {
//			TblUserExample user_example = new TblUserExample();
//			user_example.createCriteria().andOpenidEqualTo(openId);
//			List<TblUserWithBLOBs> user1 = userMapper.selectByExampleWithBLOBs(user_example);
//			
//			if (user1.size()!=0) {
//				jedisClient.set(REDIS_USER_SESSION_KEY + ":" + openId, JsonUtils.objectToJson(user1));
//				TblUserWithBLOBs userSingle = user1.get(0);
//				return PytheResult.ok(userSingle);
//			}
//			return PytheResult.build(400, "redis中此用户不存在！");
//		}
		
		//更新过期时间
		//jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + openId, SSO_SESSION_EXPIRE);
		//返回用户信息
		TblUserExample example = new TblUserExample();
		example.createCriteria().andOpenidEqualTo(openId);
		List<TblUserWithBLOBs> users = userMapper.selectByExampleWithBLOBs(example);
	    if(users.size()>0){
	    	TblUserWithBLOBs user = users.get(0);
	    	user.setUsername(EmojiParser.parseToUnicode(user.getUsername()));
	    	user.setDescription(EmojiParser.parseToUnicode(user.getDescription()));
	    	return PytheResult.ok(user);
	    }
	    return PytheResult.build(400, "数据库中没有该用户");
	}

	@Override
	public TblUserWithBLOBs updatePersonalImformation(Long userId, String username, String description) throws Exception {
		// TODO Auto-generated method stub
		TblUserWithBLOBs updateUser = new TblUserWithBLOBs();
		updateUser.setUsername(EmojiParser.parseToAliases(username, FitzpatrickAction.PARSE));
	
		updateUser.setDescription(EmojiParser.parseToAliases(description, FitzpatrickAction.PARSE));
		TblUserExample example = new TblUserExample();
		example.createCriteria().andUseridEqualTo(userId);
		userMapper.updateByExampleSelective(updateUser, example);
		TblUserWithBLOBs user = userMapper.selectByPrimaryKey(userId);
		return user;
	}

	@Override
	public PytheResult selectCollectQuestionByHomeId(Long userId, Integer pageNum,
			Integer pageSize) {
		TblUserWithBLOBs user = userMapper.selectByPrimaryKey(userId);
		Collection collection = JsonUtils.jsonToPojo(user.getCollection(), Collection.class);
		if (collection.getQuestions().size()==0) {
			return null;
		}
		
		PageHelper.startPage(pageNum, pageSize);
		
		VHomepageListExample example = new VHomepageListExample();
    	example.createCriteria().andQuestionidIn(collection.getQuestions());
    	List<VHomepageListWithBLOBs> results = homeMapper.selectByExampleWithBLOBs(example);
    	for(VHomepageListWithBLOBs record: results)
    	{
    		record.setStudentname(EmojiParser.parseToUnicode(record.getStudentname()));
	    	record.setTeachername(EmojiParser.parseToUnicode(record.getTeachername()));
	    	record.setAnswercontent(EmojiParser.parseToUnicode(record.getAnswercontent()));
	    	record.setQuestioncontent(EmojiParser.parseToUnicode(record.getQuestioncontent()));
	    	
    	}
		return PytheResult.ok(results);
	}

	@Override
	public PytheResult selectCollectTeacherByTeacherId(Long userId, Integer pageNum,
			Integer pageSize) {

		TblUserWithBLOBs user = userMapper.selectByPrimaryKey(userId);
		Collection collection = JsonUtils.jsonToPojo(user.getCollection(), Collection.class);

		PageHelper.startPage(pageNum, pageSize);
		
		VTeacherExample example = new VTeacherExample();
		List<Long> list = collection.getTeacherIds();
		if (list.size()==0) {
			return null;
		}
		
		example.createCriteria().andUseridIn(list);
		
		List<VTeacherWithBLOBs> teachers = teacherMapper.selectByExampleWithBLOBs(example);
		for(VTeacherWithBLOBs teacher: teachers)
		{
			teacher.setUsername(EmojiParser.parseToUnicode(teacher.getUsername()));
			teacher.setDescription(EmojiParser.parseToUnicode(teacher.getDescription()));
		}
		
		return PytheResult.ok(teachers);
	}

	@Override
	public String decodeUserInfo(String encryptedData, String iv, String session_key) {
		// TODO Auto-generated method stub
		
		
		//小程序唯一标识   (在微信小程序管理后台获取)
        

        ////////////////2、对encryptedData加密数据进行AES解密 ////////////////
		AES aes = new AES();
		try {
			
			String result = aes.decrypt((encryptedData), (session_key),
					(iv));
			
				return result;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object updateRequest(String code) {
		// TODO Auto-generated method stub
		// CodePacket codePacket = new CodePacket();
		// codePacket.setAppid(WX_APPID);
		// codePacket.setAppsecret(WX_APPSECRET);
		// codePacket.setCode(code);
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + WX_APPID + "&secret=" + WX_APPSECRET
				+ "&js_code=" + code + "&grant_type=authorization_code";
		String prePayResult = HttpClientUtil.doGet(url, null);
		String session_id = FactoryUtils.getUUID();
		String session_key = JSONObject.parseObject(prePayResult).getString("session_key");
		String openid = JSONObject.parseObject(prePayResult).getString("openid");

		TblSession session = new TblSession();
		session.setSessionId(session_id);
		session.setSessionKey(session_key);
		session.setOpenId(openid);
		sessionMapper.insert(session);

		JSONObject packet = new JSONObject();
		packet.put("session_id",session_id);
		packet.put("openid",openid);
		packet.put("session_key",session_key);
		// System.out.println(prePayResult);
		// {"status":200,"msg":"OK","data":"
		// {\"session_key\":\"G+m8VhyQqd6xZvHB0xPCHA==\",\"expires_in\":7200,\"openid\":\"oU6Xr0Iddiof1I7YFsioFTkwmJiU\"}"}
		return packet;
	}

	@Override
	public String selectResponseByPrePayImforamtion(String prepayment_imforamtion) throws Exception {
		// TODO Auto-generated method stub
		String appid = WX_APPID;// appid
		String mch_id = WX_MCH_ID;// 微信支付商户号
		String nonce_str = FactoryUtils.getUUID();// 随机码
		 JSONObject json = JSONObject.parseObject(prepayment_imforamtion);
		String body = json.getString("body");// 商品描述
		String out_trade_no = System.currentTimeMillis() + "" + new java.util.Random().nextInt(8);// 商品订单号
		String product_id = FactoryUtils.getUUID();// 商品编号
		String total_fee = json.getInteger("total_fee") + "";// 总金额
																										// 分
		// String time_start = getCurrTime();// 交易起始时间(订单生成时间非必须)
		String trade_type = json.getString("trade_type");// 公众号支付
		String notify_url = json.getString("notify_url");// 回调函数
		// String sessionId
		// =JSONObject.parseObject(prepayment_imforamtion).getString("sessionId");
		String openid = json.getString("openId");

		SortedMap<String, String> params = new TreeMap<String, String>();
		params.put("appid", appid);
		params.put("body", body);// 商品描述
		params.put("mch_id", mch_id);
		params.put("nonce_str", nonce_str);
		params.put("notify_url", notify_url);
		params.put("openid", openid);
		params.put("out_trade_no", out_trade_no);
		params.put("product_id", product_id);
		params.put("total_fee", total_fee);
		params.put("trade_type", trade_type);

		// 1第一次签名
		String sign = "";// 签名(该签名本应使用微信商户平台的API证书中的密匙key,但此处使用的是微信公众号的密匙APP_SECRET)
		sign = FactoryUtils.getSign(params, WX_KEY);
		// 参数xml化
		String xmlParams = FactoryUtils.parseString2Xml(params, sign);
		// 判断返回码
		String str = "";
		String xw_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		str = HttpClientUtil.doPostJson(xw_url, xmlParams);

		// 2第二步签名
		JSONObject strJson = Xml2JsonUtil.xml2Json(str);
		// System.out.println("=======>strJson"+strJson.toString());
		// String return_code = strJson.getString("return_code");
		// String return_msg = strJson.getString("return_msg");
		String prepay_id = strJson.getString("prepay_id");
		String sign2 = strJson.getString("sign");
		String nonce_str2 = FactoryUtils.getUUID();
		String signType = "MD5";
		SortedMap<String, String> params2 = new TreeMap<String, String>();
		// String timeStamp = new
		// Timestamp(System.currentTimeMillis()).toString();
		String timeStamp = String.valueOf(System.currentTimeMillis());

		params2.put("appId", appid);
		// params2.put("mch_id", mch_id);
		params2.put("nonceStr", nonce_str2);
		// params2.put("openid", openid);
		// params2.put("prepay_id", prepay_id);
		params2.put("package", "prepay_id=" + prepay_id);
		params2.put("signType", signType);
		params2.put("timeStamp", timeStamp);
		// params2.put("return_code",return_code);
		// params2.put("return_msg", return_msg);
		// params2.put("trade_type", trade_type);
		String signB = "";// 签名(该签名本应使用微信商户平台的API证书中的密匙key,但此处使用的是微信公众号的密匙APP_SECRET)
		signB = FactoryUtils.getSign(params2, WX_KEY);
//		System.out.println("======================>" + signB);

		// String prepay_id ="";
		// for (String s : str.split("\n"))
		// if (s.contains("prepay_id")) prepay_id =
		// s.substring((s.indexOf("CDATA")+6), (s.lastIndexOf("]")-1));
		//
		// JSONObject json = new JSONObject();
		// json.put("return_code", "SUCCESS");
		// json.put("return_msg", "OK");
		// json.put("prepay_id",prepay_id);
		// json.toString()
		// 2第一步签名

		// String nonceStr = FactoryUtils.getUUID();
		// String signType ="MD5";
		// JSONObject strJson = Xml2JsonUtil.xml2Json(str);
		// strJson.put("appId", appid);
		strJson.put("paySign", signB);
		strJson.put("timeStamp", timeStamp);
		strJson.put("nonceStr", nonce_str2);
		strJson.put("out_trade_no", out_trade_no);
		// strJson.put("package", "prepay_id="+prepay_id);
		// strJson.put("signType", "signType");

		return strJson.toString();
	}

	@Override
	public Boolean findSessionId(String sessionId) {
		// TODO Auto-generated method stub
		TblSession session = sessionMapper.selectByPrimaryKey(sessionId);
		if (session != null) {
			// 如果验证通过,则将用户信息传到前台
			return true;
		} else {
			return false;
		}
	}

	

	@Override
	public PytheResult selectUserByUserId(Long userId) {
		// TODO Auto-generated method stub
		
		return PytheResult.ok(userMapper.selectByPrimaryKey(userId));
	}

	@Override
	public PytheResult updateAvatar(Long userId, String avatarUrl) {
		
		TblUserWithBLOBs user = userMapper.selectByPrimaryKey(userId);
		user.setUserimg(avatarUrl);
		userMapper.updateByPrimaryKeySelective(user);
		
		return PytheResult.ok(user);
	}





}








