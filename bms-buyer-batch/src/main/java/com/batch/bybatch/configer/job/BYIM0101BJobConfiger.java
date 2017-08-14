package com.batch.bybatch.configer.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import com.batch.bybatch.configer.step.BYIM0101BStepConfiger;
import com.batch.bybatch.listener.BYIM0101BJobListener;
import com.framework.batch.core.BaseJobConfiger;
import com.framework.batch.core.support.SimpleBatchConfiger;

/**
 * Created by guan_zhongheng on 2017/2/23.
 */
@Configuration
@AutoConfigureAfter({ SimpleBatchConfiger.class, BYIM0101BJobConfiger.class })
public class BYIM0101BJobConfiger extends BaseJobConfiger {

    @Autowired
    private BYIM0101BStepConfiger byim0101BStepConfiger;

    public JobExecutionListener jobListener() {
        return new BYIM0101BJobListener();
    }

    public Job Byim0101bJob() {
        return super.buildJob("Byim0101bJob", byim0101BStepConfiger.Byim0101bStep());
    }
}
