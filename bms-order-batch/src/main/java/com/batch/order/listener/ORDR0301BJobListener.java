package com.batch.order.listener;

import com.framework.batch.core.listener.BaseJobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;

/**
 * Created by liutao on 2017/1/4.
 */
public class ORDR0301BJobListener implements BaseJobListener {
    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(ORDR0301BJobListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        logger.info("配送通知单生产 start.");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        logger.info("配送通知单生产 end.");
    }
}
