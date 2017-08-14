package com.batch.order.configer.job;

import com.batch.order.configer.step.ORDR0101BStepConfiger;
import com.batch.order.listener.ORDR0101BJobListener;
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
@AutoConfigureAfter({SimpleBatchConfiger.class, ORDR0101BJobConfiger.class})
public class ORDR0101BJobConfiger extends BaseJobConfiger {
    @Autowired
    private ORDR0101BStepConfiger ordr0101BStepConfiger;

    public JobExecutionListener jobListener() {
        return new ORDR0101BJobListener();
    }

    public Job ORDR0101BJob() {
        return super.buildJob("ORDR0101BJob", ordr0101BStepConfiger.ORDR0101BStep());
    }
}
