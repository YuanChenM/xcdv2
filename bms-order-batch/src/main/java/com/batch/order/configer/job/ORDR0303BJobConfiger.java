package com.batch.order.configer.job;

import com.batch.order.configer.step.ORDR0303BStepConfiger;
import com.batch.order.listener.ORDR0303BJobListener;
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
@AutoConfigureAfter({ SimpleBatchConfiger.class, ORDR0303BJobConfiger.class })
public class ORDR0303BJobConfiger extends BaseJobConfiger {
    @Autowired
    private ORDR0303BStepConfiger ordr0303BStepConfiger;

    public JobExecutionListener jobListener() {
        return new ORDR0303BJobListener();
    }

    public Job ORDR0303BJob() {
        return super.buildJob("ORDR0303BJob", ordr0303BStepConfiger.ORDR0303BStep());
    }
}
