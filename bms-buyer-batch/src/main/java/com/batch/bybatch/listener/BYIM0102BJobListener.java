package com.batch.bybatch.listener;

import com.framework.batch.core.listener.BaseJobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;

/**
 * Created by yuan_zhifei on 2017/5/25.
 */
public class BYIM0102BJobListener implements BaseJobListener {
    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(BYIM0102BJobListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        logger.info("买家订单信息分析开始......!");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        logger.info("买家订单信息分析结束......!");
    }
}
