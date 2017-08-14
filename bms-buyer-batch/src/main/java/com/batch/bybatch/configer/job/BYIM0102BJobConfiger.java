package com.batch.bybatch.configer.job;

import com.batch.bybatch.configer.step.BYIM0102BStepConfiger;
import com.batch.bybatch.listener.BYIM0102BJobListener;
import com.framework.batch.core.BaseJobConfiger;
import com.framework.batch.core.support.SimpleBatchConfiger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yuan_zhifei on 2017/5/25.
 */
@Configuration
@AutoConfigureAfter({SimpleBatchConfiger.class, BYIM0102BJobConfiger.class})
public class BYIM0102BJobConfiger extends BaseJobConfiger {

    @Autowired
    private BYIM0102BStepConfiger byim0102BStepConfiger;

    public JobExecutionListener jobListener() {
        return new BYIM0102BJobListener();
    }

    public Job Byim0102bJob() {
        return super.buildJob("Byim0102bJob", byim0102BStepConfiger.Byim0102bStep());
    }
}
