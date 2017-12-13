package com.pythe.rest.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.pythe.common.pojo.PytheResult;
import com.pythe.common.utils.FactoryUtils;
import com.pythe.common.utils.HttpClientUtil;
import com.pythe.common.utils.Xml2JsonUtil;
import com.pythe.mapper.TblAnswerMapper;
import com.pythe.mapper.TblBillMapper;
import com.pythe.mapper.TblTransferMapper;
import com.pythe.mapper.TblUserMapper;
import com.pythe.mapper.VTeacherStatisticsMapper;
import com.pythe.pojo.TblBill;
import com.pythe.pojo.TblBillExample;
import com.pythe.pojo.TblTransfer;
import com.pythe.pojo.TblUserWithBLOBs;
import com.pythe.pojo.VTeacherStatistics;
import com.pythe.pojo.VTeacherStatisticsExample;
import com.pythe.rest.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {

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
	private TblBillMapper billMapper;
	
	@Autowired
	private TblUserMapper userMapper;
	
	@Autowired
	private TblTransferMapper transferMapper;
	
	@Autowired
	private VTeacherStatisticsMapper teacherStatisticsMapper;

	private static final String TRANSFERS_PAY = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers"; // 企业付款

	// amount //re_user_name //desc
	@Override
	public String transferIndividual(String parameters) throws Exception {
		// TODO Auto-generated method stub
		String openid = JSONObject.parseObject(parameters).getString("openid");
		String amount = JSONObject.parseObject(parameters).getString("amount");
		String re_user_name = JSONObject.parseObject(parameters).getString("re_user_name");
		String desc = JSONObject.parseObject(parameters).getString("desc");

		String appid = WX_APPID;// appid
		String mch_id = WX_MCH_ID;// 微信支付商户号
		String nonce_str = FactoryUtils.getUUID();// 随机码
		// String time_start = getCurrTime();// 交易起始时间(订单生成时间非必须)
		// String sessionId =JSONObject.parseObject(url).getString("sessionId");
		String partner_trade_no = FactoryUtils.getUUID();
		String spbill_create_ip = FactoryUtils.getLocalAddress();

		SortedMap<String, String> params = new TreeMap<String, String>();
		params.put("amount", amount); // 转账金额
		params.put("check_name", "NO_CHECK"); // 校验用户姓名选项 OPTION_CHECK
		params.put("desc", desc); // 企业付款描述信息
		params.put("mch_appid", appid); // 公众账号appid
		params.put("mchid", mch_id); // 商户号
		params.put("nonce_str", nonce_str); // 随机字符串
		params.put("openid", openid); // 用户openid
		params.put("partner_trade_no", partner_trade_no); // 商户订单号
		params.put("re_user_name", re_user_name); // check_name设置为FORCE_CHECK或OPTION_CHECK，则必填
		params.put("spbill_create_ip", spbill_create_ip); // 服务器Ip地址

		// 参数xml化
		String xmlParams = FactoryUtils.parseString2Xml(params, FactoryUtils.getSign(params, WX_KEY));

		// 获取证书，发送POST请求;
		String xmlResult = HttpClientUtil.doPostXmlSafely(TRANSFERS_PAY, xmlParams, mch_id,
				new File(WX_CERTIFICATE_PATH));
		System.out.println(xmlResult);
		JSONObject strJson = Xml2JsonUtil.xml2Json(xmlResult);
		String result_code = strJson.getString("result_code");
		// if ("SUCCESS".equals(result_code)) {
		JSONObject json = new JSONObject();
		json.put("result_code", strJson.getString(result_code));// 商户转账订单号
		json.put("payment_no", strJson.getString("payment_no"));// 微信订单号
		json.put("payment_time", strJson.getString("payment_time")); // 微信支付成功时间
		return json.toString();
		// }
		// urn null;
	}

	@Override
	public String refundByOrder(String url) {

		JSONObject json = JSONObject.parseObject(url);
		
		String appid = WX_APPID;// appid
		String mch_id = WX_MCH_ID;// 微信支付商户号
		String nonce_str = FactoryUtils.getUUID();// 随机码
		String sign = "";
		String out_trade_no  = json.getString("out_trade_no");
		String out_refund_no = FactoryUtils.getUUID();
		String total_fee = json.getString("total_fee");
		String refund_fee = json.getString("refund_fee");
		String op_user_id = WX_MCH_ID;
		 //sign
		 SortedMap<String, String> params = new TreeMap<String, String>();
		 params.put("appid", appid);
		 params.put("mch_id", mch_id);
		 params.put("nonce_str", nonce_str);
		 params.put("out_trade_no", out_trade_no);
		 params.put("out_refund_no", out_refund_no);
		 params.put("out_trade_no", out_trade_no);
		 params.put("total_fee", total_fee);
		 params.put("refund_fee", refund_fee);
		 params.put("op_user_id", op_user_id);

		// 1第一次签名
		sign = FactoryUtils.getSign(params, WX_KEY);
		// 参数xml化
		String xmlParams = FactoryUtils.parseString2Xml(params, sign);
		// 判断返回码
		String str = "";
		String xw_url = "https://api.mch.weixin.qq.com/secapi/pay/refund";
		try {
			str = HttpClientUtil.doPostXmlSafely(xw_url, xmlParams, mch_id,
					new File(this.getClass().getClassLoader().getResource("resource/apiclient_cert.p12").getPath()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return str;
	}

	@Override
	public PytheResult queryQuestionPayRecord(Long studentId, int pageNum, int pageSize) {

		PageHelper.startPage(pageNum, pageSize);
		TblBillExample billExample = new TblBillExample();
		billExample.createCriteria().andStudentOutidEqualTo(studentId);
		List<TblBill> bills = billMapper.selectByExample(billExample);

		if (bills.isEmpty()) {
			return PytheResult.build(400, "无纪录");
		} else {
			return PytheResult.ok(billMapper.selectByExample(billExample));
		}

	}

	@Override
	public PytheResult billMapQuestion(Long questionId, Long studentId) {
		
		TblBillExample billExample = new TblBillExample();
		billExample.createCriteria().andStudentOutidEqualTo(studentId).andObjectidEqualTo(questionId);
		
		List<TblBill> bills = billMapper.selectByExample(billExample);
		
		if(bills.isEmpty())
		{
			return PytheResult.build(400, "该支付查询不到");
		}
		else
		{
			return PytheResult.ok(bills.get(0));
		}
		
		
	}

	@Override
	public PytheResult teacherEnchashment(String parameters) throws Exception {
		
		JSONObject jsonObject = JSONObject.parseObject(parameters);
		Long teacherId = jsonObject.getLong("userId");
		int status = jsonObject.getIntValue("roleStatus");
		double money = jsonObject.getDoubleValue("money");
		String openId = jsonObject.getString("openId");
		
		if(status == 1)
		{
			TblUserWithBLOBs user = userMapper.selectByPrimaryKey(teacherId);
			if(user.getOpenid().equals(openId))
			{
				VTeacherStatisticsExample teacherStatisticsExmample = new VTeacherStatisticsExample();
				teacherStatisticsExmample.createCriteria().andTeacheridEqualTo(teacherId);
				VTeacherStatistics teacherStatistics = teacherStatisticsMapper.selectByExampleWithBLOBs(teacherStatisticsExmample).get(0);
				
				//if(money <= teacherStatistics.getIncome())
				{
					String transferResultStr;
					//提现，先插入纪录，然后企业付款到老师账户，最后修改状态
					
					//1 插入纪录
					TblTransfer transfer = new TblTransfer();
					transfer.setMoney(teacherStatistics.getIncome());
					transfer.setObject(openId);
					transfer.setUserId(teacherId);
					transfer.setOperationType("enchashment");
					transfer.setStatus(0);
					
					transferMapper.insert(transfer);
					
					//2 企业付款
					transferResultStr = transferIndividual(parameters);
					
					
					//3 插入纪录
					JSONObject transferResult = JSON.parseObject(transferResultStr);
					if(transferResult.getString("result_code").equals("SUCCESS"))
					{
						transfer.setPaymentNo(transferResult.getString("payment_no"));
						transfer.setOperationTime(new Date());
						transfer.setStatus(1);
						return PytheResult.ok("已转账");
					}
					else
					{
						return PytheResult.build(500, "提现出错");
					}
					
				}
//				else
//				{
//					return PytheResult.build(500, "金额参数错误");
//				}
			}
			else
			{
				return PytheResult.build(500, "用户参数错误");
			}
		}
		else
		{
			return PytheResult.build(500, "用户群体不符");
		}
		
		
	}

}
