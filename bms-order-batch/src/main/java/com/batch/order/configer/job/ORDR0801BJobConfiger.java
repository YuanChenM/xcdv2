package com.batch.order.configer.job;

import com.batch.order.configer.step.ORDR0801BStepConfiger;
import com.batch.order.listener.ORDR0801BJobListener;
import com.framework.batch.core.BaseJobConfiger;
import com.framework.batch.core.support.SimpleBatchConfiger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liutao on 2017/1/4.
 */
@Configuration
@AutoConfigureAfter({ SimpleBatchConfiger.class, ORDR0801BJobConfiger.class })
public class ORDR0801BJobConfiger extends BaseJobConfiger {
    @Autowired
    private ORDR0801BStepConfiger ordr0801BStepConfiger;

    public JobExecutionListener jobListener() {
        return new ORDR0801BJobListener();
    }

    public Job ORDR0801BJob() {
        return super.buildJob("ORDR0801BJob", ordr0801BStepConfiger.ORDR0801BStep());
    }
}
