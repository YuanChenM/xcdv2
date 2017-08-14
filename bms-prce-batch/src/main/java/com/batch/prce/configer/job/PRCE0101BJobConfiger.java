package com.batch.prce.configer.job;


import com.batch.prce.configer.step.BackUpStepConfiger;
import com.batch.prce.configer.step.CopyDataStepConfiger;
import com.batch.prce.listener.PRCE0101BJobListener;
import com.framework.batch.core.BaseJobConfiger;
import com.framework.batch.core.support.SimpleBatchConfiger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjiaju on 2017/2/16.
 */
@Configuration
@AutoConfigureAfter({SimpleBatchConfiger.class, PRCE0101BJobConfiger.class})
public class PRCE0101BJobConfiger extends BaseJobConfiger {
    @Autowired
    private CopyDataStepConfiger copyDataStepConfiger;

    @Autowired
    private BackUpStepConfiger backUpStepConfiger;

    public JobExecutionListener jobListener() {
        return new PRCE0101BJobListener();
    }

    public List<Step> buildFlow() {
        List<Step> steps = new ArrayList<>();
        steps.add(backUpStepConfiger.BackUpStep());
        steps.add(copyDataStepConfiger.CopyDataStep());
        return steps;
    }

    public Job PRCE0101BJob() {
        return super.buildJob("PRCE0101BJob", buildFlow());
    }
}
