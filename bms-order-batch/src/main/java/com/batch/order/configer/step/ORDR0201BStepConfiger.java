package com.batch.order.configer.step;

import com.batch.order.bean.param.BaseRestParam;
import com.batch.order.bean.result.ORDR0201BOrderResult;
import com.batch.order.configer.chunk.ORDR0201BChunkConfiger;
import com.batch.order.configer.chunk.ORDR0201BEmailChunkConfiger;
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
@AutoConfigureAfter({ SimpleBatchConfiger.class,ORDR0201BChunkConfiger.class})
public class ORDR0201BStepConfiger extends BaseStepConfiger<ORDR0201BOrderResult, ORDR0201BOrderResult> {
    @Autowired
    private ORDR0201BChunkConfiger ordr0201BChunkConfiger;

    @Autowired
    private ORDR0201BEmailChunkConfiger ordr0201BEmailChunkConfiger;

    public Step ORDR0201BStep() {
        return super.buildStep("ORDR0201BStep", ordr0201BChunkConfiger);
    }

    public Step ORDR0201BEmailStep() {
        return super.buildStep("ORDR0201BEmailStep", ordr0201BEmailChunkConfiger);
    }

    @Override
    public List<Step> buildFlow() {
        List<Step> steps = new ArrayList<Step>();
        steps.add(this.ORDR0201BStep());
        steps.add(this.ORDR0201BEmailStep());
        return steps;
    }
}

