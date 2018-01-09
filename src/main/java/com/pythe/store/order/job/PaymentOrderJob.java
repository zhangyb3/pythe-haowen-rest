package com.pythe.store.order.job;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.alibaba.fastjson.JSONObject;
import com.pythe.common.utils.DateUtils;
import com.pythe.common.utils.FactoryUtils;
import com.pythe.common.utils.HttpClientUtil;
import com.pythe.common.utils.JsonUtils;
import com.pythe.mapper.TblBillMapper;
import com.pythe.mapper.TblQuestionMapper;
import com.pythe.mapper.TblVerificationMapper;
import com.pythe.pojo.TblBill;
import com.pythe.pojo.TblBillExample;
import com.pythe.pojo.TblQuestion;
import com.pythe.pojo.TblVerification;




/**
 * 扫描超过1天未处理的题订单
 * 1.退款并关闭
 * 2.分发并关闭
 */
public class PaymentOrderJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        ApplicationContext applicationContext = (ApplicationContext) context.getJobDetail().getJobDataMap()
                .get("applicationContext");
        //时间参数，当前时间向前推2天
        TblBillMapper billMapper = applicationContext.getBean(TblBillMapper.class);
        TblQuestionMapper questionMapper = applicationContext.getBean(TblQuestionMapper.class);
        Long questionid = null;
		String json = null;
		Date date =null;
        List<TblQuestion> questionList = questionMapper.selectQuestionStatusEqualsOne();
        if (!questionList.isEmpty()) {
            for (TblQuestion question : questionList) {
            	date =  new DateTime().minusDays(1).toDate();
            	if (date.after(question.getStarttime())) {
         			questionid = question.getQuestionid();
        	        TblBillExample example = new TblBillExample();
        	        example.createCriteria().andOperationtypeEqualTo("ask question").andObjectidEqualTo(questionid);
        	        TblBill bill = billMapper.selectByExample(example).get(0);
        	        JSONObject object = new JSONObject();
        	        object.put("out_trade_no",bill.getOutTradeNo());
        	        object.put("total_fee",bill.getMoney());
        	        object.put("refund_fee",bill.getMoney());
        	        json = JsonUtils.objectToJson(object);
        	        HttpClientUtil.doPostJson("https://xue.pythe.cn/pythe-haowen-rest/rest/user/pay/refund", json);
        	        //question的状态更新为2超时未答
        	        question.setStatus(2);
        	        question.setEndtime(new Date());
        	        questionMapper.updateByPrimaryKeyWithBLOBs(question);
        	        
				}
   
    		}
		}
        

        
        
//        System.out.println("======================>"+(new DateTime().minusDays(1).toDate()));
//        applicationContext.getBean(TblVerificationMapper.class).paymentOrderScan(new DateTime().minusDays(1).toDate());
    }

}
