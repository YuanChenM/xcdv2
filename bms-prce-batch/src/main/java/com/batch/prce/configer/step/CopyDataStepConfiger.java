package com.batch.prce.configer.step;


import com.batch.prce.bean.param.BaseRestParam;
import com.batch.prce.configer.chunk.CopyDataChunkConfiger;
import com.framework.batch.core.BaseStepConfiger;
import com.framework.batch.core.support.SimpleBatchConfiger;
import org.springframework.batch.core.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sunjiaju on 2017/2/16.
 */
@Configuration
@AutoConfigureAfter({SimpleBatchConfiger.class, CopyDataChunkConfiger.class})
public class CopyDataStepConfiger extends BaseStepConfiger<BaseRestParam, BaseRestParam> {
    @Autowired
    private CopyDataChunkConfiger copyDataChunkConfiger;

    public Step CopyDataStep() {
        return super.buildStep("CopyDataStep", copyDataChunkConfiger);
    }
}

