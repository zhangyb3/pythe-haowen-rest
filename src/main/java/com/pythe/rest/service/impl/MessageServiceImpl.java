package com.pythe.rest.service.impl;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pythe.common.pojo.PytheResult;
import com.pythe.common.utils.DateUtils;
import com.pythe.common.utils.ExceptionUtil;
import com.pythe.common.utils.FactoryUtils;
import com.pythe.common.utils.HttpClientUtil;
import com.pythe.common.utils.JsonUtils;
import com.pythe.mapper.TblBillMapper;
import com.pythe.mapper.TblIdentifierMapper;
import com.pythe.mapper.TblUserMapper;
import com.pythe.mapper.TblVerificationMapper;
import com.pythe.mapper.VQuestionAnswersMapper;
import com.pythe.pojo.TblBill;
import com.pythe.pojo.TblBillExample;
import com.pythe.pojo.TblIdentifier;
import com.pythe.pojo.TblIdentifierExample;
import com.pythe.pojo.TblUser;
import com.pythe.pojo.TblUserWithBLOBs;
import com.pythe.pojo.TblVerification;
import com.pythe.pojo.VQuestionAnswersExample;
import com.pythe.pojo.VQuestionAnswersWithBLOBs;
import com.pythe.rest.service.MessageService;
import com.vdurmont.emoji.EmojiParser;


@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	private TblVerificationMapper verificationMapper;
	
	@Autowired
	private TblBillMapper billMapper;
	
	@Autowired
	private TblUserMapper userMapper;
	
	@Autowired
	private VQuestionAnswersMapper vQuestionAnswersMapper;
	
	@Autowired
	private TblIdentifierMapper identifierMapper;
	
	@Value("${MESSAGE_CONTENT_BASE}")
	private String MESSAGE_CONTENT_BASE;
	@Value("${MESSAGE_CONTENT_SUPPLE}")
	private String MESSAGE_CONTENT_SUPPLE;
	@Value("${MESSAGE_USER_ID}")
	private String MESSAGE_USER_ID;
	@Value("${MESSAGE_USER_PASSWORD}")
	private String MESSAGE_USER_PASSWORD;
	@Value("${MESSAGE_API_KEY}")
	private String MESSAGE_API_KEY;

	@Value("${WX_APPID}")
	private String WX_APPID;

	@Value("${WX_APPSECRET}")
	private String WX_APPSECRET;
	
	@Value("${WX_PUBLIC_APPID}")
	private String WX_PUBLIC_APPID;

	@Value("${WX_PUBLIC_APPSECRET}")
	private String WX_PUBLIC_APPSECRET;
	

	/**
	 * mobile
	 * 
	 */
	@Override
	public PytheResult singleSend(String url) throws Exception {
		// TODO Auto-generated method stub
		
		JSONObject message_json = JSONObject.parseObject(url);
		String mobile = message_json.getString("mobile");
	    String verificationCode = FactoryUtils.genMessageVerificationCode();
		String content = URLEncoder.encode(new String(MESSAGE_CONTENT_BASE.getBytes("iso8859-1"),"UTF-8")+verificationCode+new String(MESSAGE_CONTENT_SUPPLE.getBytes("iso8859-1"),"UTF-8"), "GBK");
//	    String content =URLEncoder.encode("验证码为123456，您正在修改登录密码，请确认是本人操作。", "GBK"); 
		String timestamp = DateUtils.formatTimeStampKey(new Date());
		System.out.println(timestamp);
		
		message_json.put("apikey", MESSAGE_API_KEY);
		message_json.put("mobile", mobile);
		message_json.put("content",content);
		message_json.put("timestamp",timestamp);
		// 判断返回码
		String str = "";
		//String monternet_url = "http://api01.monyun.cn:7901/sms/v2/std/";
		String monternet_url = "http://114.67.62.211:7901/sms/v2/std/single_send";
		str = HttpClientUtil.doPostJson( monternet_url, message_json.toString());
		int result  = JSONObject.parseObject(str).getInteger("result");
		
		if (result==0) {
			System.out.println(str);
			TblVerification verification = new TblVerification();
			verification.setGenerateTime(new Date());
			verification.setUserPhoneNumber(mobile);
			verification.setVerificationCode(verificationCode);
			verificationMapper.insert(verification);
			return PytheResult.ok(str);
		}else {
			return PytheResult.build(500, "单条发送失败，错误码"+result);
		}
		
		
		
	}



	@Override
	public PytheResult pushQuestionInformationForUser(String prepay_id) {
		// TODO Auto-generated method stub
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential" + "&appid=" + WX_PUBLIC_APPID
		+"&secret=" + WX_PUBLIC_APPSECRET;
		String result = HttpClientUtil.doGet(url, null);
		System.out.println(result);
		String access_token = JSONObject.parseObject(result).getString("access_token");
		System.out.println("notify===========>"+access_token);
		//https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN
		
		TblBillExample billExample = new TblBillExample();
		billExample.createCriteria().andPayIdEqualTo(prepay_id);
		TblBill bill = billMapper.selectByExample(billExample).get(0);
		
		TblUserWithBLOBs teacher = userMapper.selectByPrimaryKey(bill.getTeacherInid());
		TblUserWithBLOBs student = userMapper.selectByPrimaryKey(bill.getStudentOutid());
			
	    SortedMap<String, Object> params = new TreeMap<String, Object>();
	    //找出教师的公众号openid并发送
	    TblIdentifierExample identifierExample = new TblIdentifierExample();
		identifierExample.createCriteria().andMiniprogramOpenidEqualTo(teacher.getOpenid());
		List<TblIdentifier> identifiers = identifierMapper.selectByExample(identifierExample);
		if(identifiers.isEmpty())
		{
			return PytheResult.build(400, "教师不存在或未关注公众号，无法通知");
		}
		params.put("touser", identifiers.get(0).getPublicOpenid());
		params.put("template_id","jN5f2F9wyI_Df4rLrejFZgD9zFZIVCSq95wUlXmJjQE");// 商品描述
		System.out.println(prepay_id);
//		params.put("form_id", prepay_id);
		
		TreeMap<String, String> mimiprogram_value_map = new TreeMap<String, String>();
		mimiprogram_value_map.put("appid","wx341f13cb3e75d864");
		mimiprogram_value_map.put("pagepath","pages/answer/answer");
		params.put("miniprogram", mimiprogram_value_map);
		
//		TreeMap<String, TreeMap<String, String>> keyword_map = new TreeMap<String, TreeMap<String, String>>();
//	    
//		TreeMap<String, String> keword1_value_map = new TreeMap<String, String>();
//		keword1_value_map.put("value",DateUtils.formatTime(new Date()));
//		keword1_value_map.put("color","#173177");
//		
//		TreeMap<String, String> keword2_value_map = new TreeMap<String, String>();
//		keword2_value_map.put("value",student.getUsername());
//		keword2_value_map.put("color","#173177");
//		
//		TreeMap<String, String> keword3_value_map = new TreeMap<String, String>();
//		keword3_value_map.put("value",String.valueOf(bill.getObjectid()));
//		keword3_value_map.put("color","#173177");
//		
//		TreeMap<String, String> keword4_value_map = new TreeMap<String, String>();
//		keword4_value_map.put("value","无");
//		keword4_value_map.put("color","#173177");
//		
//		TreeMap<String, String> keword5_value_map = new TreeMap<String, String>();
//		keword5_value_map.put("value","24小时");
//		keword5_value_map.put("color","#173177");
//		
//		keyword_map.put("keyword1", keword1_value_map);
//		keyword_map.put("keyword2", keword2_value_map);
//		keyword_map.put("keyword3", keword3_value_map);
//		keyword_map.put("keyword4", keword4_value_map);
//		keyword_map.put("keyword5", keword5_value_map);
		
//		TreeMap<String, TreeMap<String,TreeMap<String, String>>> data_map = new TreeMap<String, TreeMap<String,TreeMap<String, String>>>();
//		data_map.put("data", keyword_map);
//		System.out.println(keyword_map);
//		String data = JsonUtils.objectToJson(data_map);
//		System.out.println(data);
		
		TreeMap<String, String> first_value_map = new TreeMap<String, String>();
		first_value_map.put("value","学生请教了一个新问题");
		
		TreeMap<String, String> keword1_value_map = new TreeMap<String, String>();
		keword1_value_map.put("value",EmojiParser.parseToUnicode(student.getUsername()));
		
		TreeMap<String, String> keword2_value_map = new TreeMap<String, String>();
		keword2_value_map.put("value",DateUtils.formatTime(bill.getOperationtime()));
		
		TreeMap<String, String> keword3_value_map = new TreeMap<String, String>();
		keword3_value_map.put("value","问题" + bill.getObjectid());
		
		TreeMap<String, String> remark_value_map = new TreeMap<String, String>();
		remark_value_map.put("value","请点击查看");
		
		TreeMap<String, TreeMap<String, String>> keyword_map = new TreeMap<String, TreeMap<String, String>>();
		keyword_map.put("first", first_value_map);
		keyword_map.put("keyword1", keword1_value_map);
		keyword_map.put("keyword2", keword2_value_map);
		keyword_map.put("keyword3", keword3_value_map);
		keyword_map.put("remark", remark_value_map);
		
		params.put("data", keyword_map);

//		params.put("color", "#173177");
//		params.put("openid", openid);
//		params.put("emphasis_keyword","Pythe好学急件");
		
		String params_json= JsonUtils.objectToJson(params);
		System.out.println("### params to post =========================> " + params_json);
		
		String xw_url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token;
		String str = HttpClientUtil.doPostJson(xw_url, params_json);

		return PytheResult.ok(str);
	}



	@Override
	public PytheResult pushAnswerInformationToStudent(Long answerId) {
		
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential" + "&appid=" + WX_APPID
						+"&secret=" + WX_APPSECRET;
		String result = HttpClientUtil.doGet(url, null);
		System.out.println(result);
		String access_token = JSONObject.parseObject(result).getString("access_token");
		System.out.println("=====================>"+access_token);
		
		VQuestionAnswersExample vqaExample = new VQuestionAnswersExample();
		vqaExample.createCriteria().andAnsweridEqualTo(answerId);
		VQuestionAnswersWithBLOBs vqa = vQuestionAnswersMapper.selectByExampleWithBLOBs(vqaExample).get(0);
		
		TblBillExample billExample = new TblBillExample();
		billExample.createCriteria().andObjectidEqualTo(vqa.getQuestionid()).andOperationtypeEqualTo("ask question");
		TblBill bill = billMapper.selectByExample(billExample).get(0);
		
		TblUserWithBLOBs student = userMapper.selectByPrimaryKey(bill.getStudentOutid());
		
		SortedMap<String, String> params = new TreeMap<String, String>();
		params.put("touser", student.getOpenid());
		params.put("template_id","8ArqeWXorJzDU83fc3ZDGwAyVIzs3rMuiOV4ZeE7ujE");// 商品描述
		System.out.println(bill.getPayId());
		params.put("form_id", bill.getPayId());
		
		TreeMap<String, TreeMap<String, String>> keyword_map = new TreeMap<String, TreeMap<String, String>>();
	    
		TreeMap<String, String> keword1_value_map = new TreeMap<String, String>();
		keword1_value_map.put("value",DateUtils.formatTime(new Date()));
		keword1_value_map.put("color","#173177");
		
		TreeMap<String, String> keword2_value_map = new TreeMap<String, String>();
		keword2_value_map.put("value",student.getUsername());
		keword2_value_map.put("color","#173177");
		
		TreeMap<String, String> keword3_value_map = new TreeMap<String, String>();
		keword3_value_map.put("value",String.valueOf(bill.getObjectid()));
		keword3_value_map.put("color","#173177");
		
		TreeMap<String, String> keword4_value_map = new TreeMap<String, String>();
		keword4_value_map.put("value","无");
		keword4_value_map.put("color","#173177");
		
		TreeMap<String, String> keword5_value_map = new TreeMap<String, String>();
		keword5_value_map.put("value","24小时");
		keword5_value_map.put("color","#173177");
		
		keyword_map.put("keyword1", keword1_value_map);
		keyword_map.put("keyword2", keword2_value_map);
		keyword_map.put("keyword3", keword3_value_map);
		keyword_map.put("keyword4", keword4_value_map);
		keyword_map.put("keyword5", keword5_value_map);
		
		TreeMap<String, TreeMap<String,TreeMap<String, String>>> data_map = new TreeMap<String, TreeMap<String,TreeMap<String, String>>>();
//		data_map.put("data", keyword_map);
		System.out.println(keyword_map);
		String data = JsonUtils.objectToJson(data_map);
		System.out.println(data);
		
		//链接到小程序指定页面
		params.put("data", data);
		params.put("page", "pages/answer/answer?from=serviceInfo");
		String params_json= JsonUtils.objectToJson(params);
		
		String xw_url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="+access_token;
		String str = HttpClientUtil.doPostJson(xw_url, params_json);

		return PytheResult.ok(str);
	}


}
