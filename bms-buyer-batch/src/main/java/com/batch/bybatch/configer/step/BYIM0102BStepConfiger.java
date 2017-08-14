package com.batch.bybatch.configer.step;

import com.batch.bybatch.bean.result.BuyerProductResult;
import com.batch.bybatch.bean.result.ByimBuyerResult;
import com.batch.bybatch.configer.chunk.BYIM0101BChunkConfiger;
import com.batch.bybatch.configer.chunk.BYIM0102BChunkConfiger;
import com.framework.batch.core.BaseStepConfiger;
import com.framework.batch.core.support.SimpleBatchConfiger;
import org.springframework.batch.core.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan_zhifei on 2017/5/25.
 */
@Configuration
@AutoConfigureAfter({SimpleBatchConfiger.class, BYIM0102BChunkConfiger.class})
public class BYIM0102BStepConfiger extends BaseStepConfiger<BuyerProductResult, BuyerProductResult> {

    @Autowired
    private BYIM0102BChunkConfiger byim0102BChunkConfiger;

    public Step Byim0102bStep() {
        return super.buildStep("Byim0102bStep", byim0102BChunkConfiger);
    }

    @Override
    public List<Step> buildFlow() {
        List<Step> steps = new ArrayList<Step>();
        steps.add(this.Byim0102bStep());
        return steps;
    }
}
