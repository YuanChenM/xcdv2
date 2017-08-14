package com.batch.order.listener;

import com.framework.batch.core.listener.BaseJobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;

/**
 * Created by liutao on 2017/1/4.
 */
public class ORDR0101BJobListener implements BaseJobListener {
    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(ORDR0101BJobListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        logger.info("确认订单batch start.");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        logger.info("确认订单batch end.");
    }
}
