package com.batch.order.configer.job;

import com.batch.order.configer.step.ORDR0201BStepConfiger;
import com.batch.order.listener.ORDR0201BJobListener;
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
@AutoConfigureAfter({SimpleBatchConfiger.class, ORDR0201BJobConfiger.class})
public class ORDR0201BJobConfiger extends BaseJobConfiger {
    @Autowired
    private ORDR0201BStepConfiger ordr0201BStepConfiger;

    public JobExecutionListener jobListener() {
        return new ORDR0201BJobListener();
    }

    public Job ORDR0201BJob() {
        return super.buildJob("ORDR0201BJob", ordr0201BStepConfiger.buildFlow());
    }
}
