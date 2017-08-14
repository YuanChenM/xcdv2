package com.batch.order.configer.job;

import com.batch.order.configer.step.ORDR0302BStepConfiger;
import com.batch.order.listener.ORDR0302BJobListener;
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
@AutoConfigureAfter({ SimpleBatchConfiger.class, ORDR0302BJobConfiger.class })
public class ORDR0302BJobConfiger extends BaseJobConfiger {
    @Autowired
    private ORDR0302BStepConfiger ordr0302BStepConfiger;

    public JobExecutionListener jobListener() {
        return new ORDR0302BJobListener();
    }

    public Job ORDR0302BJob() {
        return super.buildJob("ORDR0302BJob", ordr0302BStepConfiger.ORDR0302BStep());
    }
}
