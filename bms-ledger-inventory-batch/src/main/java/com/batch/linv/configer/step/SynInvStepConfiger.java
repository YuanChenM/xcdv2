package com.batch.linv.configer.step;


import org.springframework.batch.core.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import com.batch.linv.configer.chunk.SynInvChunkConfiger;
import com.framework.batch.core.BaseStepConfiger;
import com.framework.batch.core.support.SimpleBatchConfiger;

import java.util.Map;

/**
 * Created by wangfan on 2017/2/21.
 */
@Configuration
@AutoConfigureAfter({SimpleBatchConfiger.class, SynInvStepConfiger.class})
public class SynInvStepConfiger extends BaseStepConfiger<Map, Map> {
    @Autowired
    private SynInvChunkConfiger synInvChunkConfiger;

    public Step synInvStep() {
        return super.buildStep("SynInvStep", synInvChunkConfiger);
    }
}

