package com.batch.order.configer.step;

import com.batch.order.bean.param.BaseRestParam;
import com.batch.order.bean.result.ORDR0101BOrderResult;
import com.batch.order.configer.chunk.ORDR0101BChunkConfiger;
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
@AutoConfigureAfter({ SimpleBatchConfiger.class,ORDR0101BChunkConfiger.class})
public class ORDR0101BStepConfiger extends BaseStepConfiger<BaseRestParam, BaseRestParam> {
    @Autowired
    private ORDR0101BChunkConfiger ordr0101BChunkConfiger;


    public Step ORDR0101BStep() {
        return super.buildStep("ORDR0101BStep", ordr0101BChunkConfiger);
    }
}

