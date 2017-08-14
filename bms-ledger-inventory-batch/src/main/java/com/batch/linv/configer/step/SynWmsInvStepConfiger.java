package com.batch.linv.configer.step;


import java.util.Map;

import com.batch.linv.bean.entity.InvmLoad;
import com.batch.linv.configer.chunk.SynWmsInvChunkConfiger;
import org.springframework.batch.core.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import com.batch.linv.configer.chunk.SynInvChunkConfiger;
import com.framework.batch.core.BaseStepConfiger;
import com.framework.batch.core.support.SimpleBatchConfiger;

/**
 * Created by wangfan on 2017/5/6.
 */
@Configuration
@AutoConfigureAfter({SimpleBatchConfiger.class, SynWmsInvStepConfiger.class})
public class SynWmsInvStepConfiger extends BaseStepConfiger<InvmLoad, InvmLoad> {
    @Autowired
    private SynWmsInvChunkConfiger synInvChunkConfiger;

    public Step synInvStep() {
        return super.buildStep("SynInvStep", synInvChunkConfiger);
    }
}

