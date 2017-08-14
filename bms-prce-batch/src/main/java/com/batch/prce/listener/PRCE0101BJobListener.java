package com.batch.prce.listener;

import com.framework.batch.core.listener.BaseJobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;

/**
 * Created by sunjiaju on 2017/2/16.
 */
public class PRCE0101BJobListener implements BaseJobListener {
    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(PRCE0101BJobListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        logger.info("商品同步batch start.");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        logger.info("商品同步batch end.");
    }
}
