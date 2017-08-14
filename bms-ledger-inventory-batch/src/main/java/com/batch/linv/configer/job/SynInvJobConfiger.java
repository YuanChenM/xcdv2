package com.batch.linv.configer.job;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import com.batch.linv.configer.step.SynInvStepConfiger;
import com.framework.batch.core.BaseJobConfiger;
import com.framework.batch.core.support.SimpleBatchConfiger;

/**
 * Created by wangfan on 2017/2/21.
 */
@Configuration
@AutoConfigureAfter({ SimpleBatchConfiger.class, SynInvJobConfiger.class })
public class SynInvJobConfiger extends BaseJobConfiger {
    @Autowired
    private SynInvStepConfiger synInvStepConfiger;

    public List<Step> buildFlow() {
        List<Step> steps = new ArrayList<>();
        steps.add(synInvStepConfiger.synInvStep());
        return steps;
    }

    public Job synInvJob() {
        return super.buildJob("Inventory0101BJob", buildFlow());
    }
}
