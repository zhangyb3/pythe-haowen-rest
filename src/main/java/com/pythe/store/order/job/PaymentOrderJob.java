package com.pythe.store.order.job;

import org.joda.time.DateTime;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.pythe.mapper.TblVerificationMapper;
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
        System.out.println("======================>"+(new DateTime().minusDays(1).toDate()));
        applicationContext.getBean(TblVerificationMapper.class).paymentOrderScan(new DateTime().minusDays(1).toDate());
    }

}
