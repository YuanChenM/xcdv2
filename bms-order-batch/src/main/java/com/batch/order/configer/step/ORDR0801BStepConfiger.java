package com.batch.order.configer.step;

import com.batch.order.bean.param.BaseRestParam;
import com.batch.order.configer.chunk.ORDR0801BChunkConfiger;
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
@AutoConfigureAfter({ SimpleBatchConfiger.class,ORDR0801BChunkConfiger.class})
public class ORDR0801BStepConfiger extends BaseStepConfiger<BaseRestParam, BaseRestParam> {
    @Autowired
    private ORDR0801BChunkConfiger ordr0801BChunkConfiger;

    public Step ORDR0801BStep() {
        return super.buildStep("ORDR0801BStep", ordr0801BChunkConfiger);
    }

    @Override
    public List<Step> buildFlow() {
        List<Step> steps = new ArrayList<Step>();
        steps.add(this.ORDR0801BStep());
        return steps;
    }
}

