package com.batch.order.configer.step;

import com.batch.order.bean.param.BaseRestParam;
import com.batch.order.configer.chunk.ORDR0301BChunkConfiger;
import com.framework.batch.core.BaseStepConfiger;
import com.framework.batch.core.support.SimpleBatchConfiger;
import org.springframework.batch.core.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutao on 2017/1/4.
 */
@Configuration
@AutoConfigureAfter({ SimpleBatchConfiger.class,ORDR0301BChunkConfiger.class})
public class ORDR0301BStepConfiger extends BaseStepConfiger<BaseRestParam, BaseRestParam> {
    @Autowired
    private ORDR0301BChunkConfiger ordr0301BChunkConfiger;

    public Step ORDR0301BStep() {
        return super.buildStep("ORDR0301BStep", ordr0301BChunkConfiger);
    }

    @Override
    public List<Step> buildFlow() {
        List<Step> steps = new ArrayList<Step>();
        steps.add(this.ORDR0301BStep());
        return steps;
    }
}

