package com.batch.order.configer.job;

import com.batch.order.configer.step.ORDR0301BStepConfiger;
import com.batch.order.listener.ORDR0301BJobListener;
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
@AutoConfigureAfter({ SimpleBatchConfiger.class, ORDR0301BJobConfiger.class })
public class ORDR0301BJobConfiger extends BaseJobConfiger {
    @Autowired
    private ORDR0301BStepConfiger ordr0301BStepConfiger;

    public JobExecutionListener jobListener() {
        return new ORDR0301BJobListener();
    }

    public Job ORDR0301BJob() {
        return super.buildJob("ORDR0301BJob", ordr0301BStepConfiger.ORDR0301BStep());
    }
}
