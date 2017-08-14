package com.batch.bybatch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;

import com.framework.batch.core.listener.BaseJobListener;

/**
 * Created by guan_zhongheng on 2017/2/23.
 */
public class BYIM0101BJobListener implements BaseJobListener {
    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(BYIM0101BJobListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        logger.info("买家订单信息分析开始......!");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        logger.info("买家订单信息分析结束......!");
    }
}
