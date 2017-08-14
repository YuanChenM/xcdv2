package com.batch.bybatch.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.batch.bybatch.bean.result.ByimBuyerResult;
import com.batch.bybatch.service.BYIM0101BService;
import com.framework.core.utils.CollectionUtils;

/**
 * Created by guan_zhongheng on 2017/2/23.
 */
public class BYIM0101BItemWriter extends MyServiceItemWriter<ByimBuyerResult>{

    private static final Logger logger = LoggerFactory.getLogger(BYIM0101BItemWriter.class);

    @Override
    protected void doWrite(List<? extends ByimBuyerResult> var1) throws Exception {
        BYIM0101BService service = (BYIM0101BService)super.getBaseService();
        if(CollectionUtils.isNotEmpty(var1)){
            for(ByimBuyerResult var:var1){
                service.doProcessWork(var);
            }
        }
    }
}
