package com.pythe.rest.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
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
import com.pythe.common.utils.FactoryUtils;
import com.pythe.common.utils.HttpClientUtil;
import com.pythe.common.utils.Xml2JsonUtil;
import com.pythe.mapper.TblBillMapper;
import com.pythe.mapper.TblUserMapper;
import com.pythe.mapper.VHomepageListMapper;
import com.pythe.mapper.VStudentBillMapper;
import com.pythe.mapper.VStudentMapper;
import com.pythe.mapper.VStudentStatisticsMapper;
import com.pythe.mapper.VTeacherBillMapper;
import com.pythe.mapper.VTeacherStatisticsMapper;
import com.pythe.pojo.TblBill;
import com.pythe.pojo.TblBillExample;
import com.pythe.pojo.TblUserExample;
import com.pythe.pojo.TblUserWithBLOBs;
import com.pythe.pojo.VHomepageListExample;
import com.pythe.pojo.VHomepageListWithBLOBs;
import com.pythe.pojo.VStudentBill;
import com.pythe.pojo.VStudentBillExample;
import com.pythe.pojo.VStudentExample;
import com.pythe.pojo.VStudentStatisticsExample;
import com.pythe.pojo.VStudentWithBLOBs;
import com.pythe.pojo.VTeacherBill;
import com.pythe.pojo.VTeacherBillExample;
import com.pythe.pojo.VTeacherExample;
import com.pythe.pojo.VTeacherStatisticsExample;
import com.pythe.rest.service.RecordService;
import com.pythe.rest.service.TransferService;
import com.vdurmont.emoji.EmojiParser;

@Service
public class RecordServiceImpl implements RecordService {

	@Value("${WX_APPID}")
	private String WX_APPID;

	@Value("${WX_APPSECRET}")
	private String WX_APPSECRET;

	@Value("${WX_KEY}")
	private String WX_KEY;

	@Value("${WX_MCH_ID}")
	private String WX_MCH_ID;

	
	@Value("${WX_CERTIFICATE_PATH}")
	private String WX_CERTIFICATE_PATH;
	
	@Autowired
	private VHomepageListMapper homeMapper;
	
	
	@Autowired
	private VTeacherBillMapper teacherBillMapper;
	
	
	@Autowired
	private VStudentBillMapper studentBillMapper;
	
	@Autowired
	private TblBillMapper billMapper;
	
	@Autowired
	private TblUserMapper userMapper;
	
	@Autowired
	private VTeacherStatisticsMapper teacherStatisticsMapper;

	@Autowired
	private VStudentStatisticsMapper studentStatisticsMapper;

	@Override
	public PytheResult recordAskQuestion(Long studentId, Long teacherId, Long questionId, Double money, String payId, String outTradeNo) {
		
		TblBill bill = new TblBill();
		bill.setMoney(money);
		bill.setObjectid(questionId);
		bill.setOperationtime(new Date());
		bill.setOperationtype("ask question");
		bill.setStudentOutid(studentId);
		bill.setTeacherInid(teacherId);
		bill.setPayId(payId);
		bill.setOutTradeNo(outTradeNo);
		
		bill.setPaid(0);
//		bill.setPid(FactoryUtils.getUUID());
		billMapper.insert(bill);
		
		return PytheResult.ok(true);
	}


	@Override
	public PytheResult recordAnswerQuestion(Long studentId, Long teacherId, Long answerId, Double money) {
		
		TblBill bill = new TblBill();
		bill.setMoney(money);
		bill.setObjectid(answerId);
		bill.setOperationtime(new Date());
		bill.setOperationtype("answer question");
		bill.setStudentOutid(studentId);
		bill.setTeacherInid(teacherId);
//		bill.setPid(FactoryUtils.getUUID());
		billMapper.insert(bill);
		
		return PytheResult.ok(true);
	}


	@Override
	public PytheResult teacherQueryBills(Long teacherId, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		VTeacherBillExample example = new VTeacherBillExample();
		example.createCriteria().andTeacherInidEqualTo(teacherId);
		List<VTeacherBill> bills = teacherBillMapper.selectByExample(example);
		
		
		if(bills.isEmpty())
		{
			return PytheResult.build(400, "尚无进账");
		}
		
		List<JSONObject> list = new ArrayList<JSONObject>();
		for(VTeacherBill bill:bills)
		{
			JSONObject json = new JSONObject();
			json.put("bill", bill);
			json.put("money", bill.getMoney());
			json.put("operationTime", bill.getOperationtime());
			json.put("studentName", EmojiParser.parseToUnicode(bill.getUsername()));
			json.put("studentAvatar", bill.getUserimg());
			
			list.add(json);
		}
		
		return PytheResult.ok(list);
	}

	
	
	@Override
	public Object checkBill(String params) {
		
		JSONObject paramsObject = JSONObject.parseObject(params);
		Long studentId = paramsObject.getLong("studentId");
		Long teacherId = paramsObject.getLong("teacherId");
		
		TblBillExample billExample = new TblBillExample();
		
		if(studentId != null)
		{
			billExample.clear();
			billExample.createCriteria().andStudentOutidEqualTo(studentId);
		}
		if(teacherId != null)
		{
			billExample.clear();
			billExample.createCriteria().andTeacherInidEqualTo(teacherId);
		}
		
		List<TblBill> bills = billMapper.selectByExample(billExample);
//		Collections.sort(bills);	
		
		List<JSONObject> result = new ArrayList<JSONObject>();
		for(TblBill bill: bills)
		{
			JSONObject o = new JSONObject();
			o.put("bill", bill);
			
		}
		
		return bills;
	}


	@Override
	public PytheResult studentQueryBills(Long studentId, Integer pageNum, Integer pageSize) {
		VStudentBillExample example = new VStudentBillExample();
		example.createCriteria().andStudentOutidEqualTo(studentId);
		 List<VStudentBill> bills = studentBillMapper.selectByExample(example);
		
		if(bills.isEmpty())
		{
			return PytheResult.build(400, "尚无消费");
		}
		List<JSONObject> list = new ArrayList<JSONObject>();
		for(VStudentBill bill:bills)
		{
			JSONObject json = new JSONObject();
			json.put("bill", bill);
			json.put("money", bill.getMoney());
			json.put("operationTime", bill.getOperationtime());
			json.put("studentName", EmojiParser.parseToUnicode(bill.getUsername()));
			json.put("studentAvatar", bill.getUserimg());
			list.add(json);
		}
		
		return PytheResult.ok(list);
		
	}


	@Override
	public PytheResult queryStatistics(Long userId) {
		
		TblUserWithBLOBs user = userMapper.selectByPrimaryKey(userId);
		
		
		if(user.getStatus() == 1)
		{
			VTeacherStatisticsExample vTeacherStatisticsExample = new VTeacherStatisticsExample();
			vTeacherStatisticsExample.createCriteria().andTeacheridEqualTo(userId);
			
			return PytheResult.ok(teacherStatisticsMapper.selectByExample(vTeacherStatisticsExample).get(0));
		}
		if(user.getStatus() == 0)
		{
			VStudentStatisticsExample vStudentStatisticsExample = new VStudentStatisticsExample();
			vStudentStatisticsExample.createCriteria().andStudentidEqualTo(userId);
			
			return PytheResult.ok(studentStatisticsMapper.selectByExample(vStudentStatisticsExample).get(0));
		}
		
		
		return PytheResult.build(400, "查无此人");
	}


	@Override
	public PytheResult recordAnswerReward(Long studentId, Long teacherId, Long answerId, Double money, String payId,
			String outTradeNo) {
		
		TblBill bill = new TblBill();
		bill.setMoney(money);
		bill.setObjectid(answerId);
		bill.setOperationtime(new Date());
		bill.setOperationtype("reward answer");
		bill.setStudentOutid(studentId);
		bill.setTeacherInid(teacherId);
		bill.setPayId(payId);
		bill.setOutTradeNo(outTradeNo);
		
		bill.setPaid(1);
//		bill.setPid(FactoryUtils.getUUID());
		billMapper.insert(bill);
		
		return PytheResult.ok(true);
		
	}


	@Override
	public PytheResult checkBillQADetail(String params) {
		
		JSONObject parameters = JSONObject.parseObject(params);
		String operationType = parameters.getString("operationtype");
		Long questionId = parameters.getLong("objectid");
		Long answerId = parameters.getLong("objectid");
		
		VHomepageListExample example = new VHomepageListExample();
		if(operationType.equals("ask question"))
		{
			example.createCriteria().andQuestionidEqualTo(questionId);
		}
		else
		{
			example.createCriteria().andAnsweridEqualTo(answerId);
		}
    	
    	
    	List<VHomepageListWithBLOBs> results = homeMapper.selectByExampleWithBLOBs(example);
    	for(VHomepageListWithBLOBs record: results)
    	{
    		record.setStudentname(EmojiParser.parseToUnicode(record.getStudentname()));
	    	record.setTeachername(EmojiParser.parseToUnicode(record.getTeachername()));
    	}
		return PytheResult.ok(results.get(0));
	}

}
