package com.batch.bybatch.configer.step;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import com.batch.bybatch.bean.result.ByimBuyerResult;
import com.batch.bybatch.configer.chunk.BYIM0101BChunkConfiger;
import com.framework.batch.core.BaseStepConfiger;
import com.framework.batch.core.support.SimpleBatchConfiger;

/**
 * Created by guan_zhongheng on 2017/2/23.
 */
@Configuration
@AutoConfigureAfter({ SimpleBatchConfiger.class,BYIM0101BChunkConfiger.class})
public class BYIM0101BStepConfiger extends BaseStepConfiger<ByimBuyerResult,ByimBuyerResult>{

    @Autowired
    private BYIM0101BChunkConfiger byim0101BChunkConfiger;

    public Step Byim0101bStep(){
        return super.buildStep("Byim0101bStep",byim0101BChunkConfiger);
    }

    @Override
    public List<Step> buildFlow() {
        List<Step> steps = new ArrayList<Step>();
        steps.add(this.Byim0101bStep());
        return steps;
    }
}
