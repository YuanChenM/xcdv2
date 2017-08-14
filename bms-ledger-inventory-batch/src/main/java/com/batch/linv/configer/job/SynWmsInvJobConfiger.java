package com.batch.linv.configer.job;

import java.util.ArrayList;
import java.util.List;

import com.batch.linv.configer.step.SynWmsInvStepConfiger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import com.batch.linv.configer.step.SynInvStepConfiger;
import com.framework.batch.core.BaseJobConfiger;
import com.framework.batch.core.support.SimpleBatchConfiger;

/**
 * Created by wangfan on 2017/5/6.
 */
@Configuration
@AutoConfigureAfter({ SimpleBatchConfiger.class, SynWmsInvJobConfiger.class })
public class SynWmsInvJobConfiger extends BaseJobConfiger {
    @Autowired
    private SynWmsInvStepConfiger synInvStepConfiger;

    public List<Step> buildFlow() {
        List<Step> steps = new ArrayList<>();
        steps.add(synInvStepConfiger.synInvStep());
        return steps;
    }

    public Job synWmsInvJob() {
        return super.buildJob("linv0002BJob", buildFlow());
    }
}
