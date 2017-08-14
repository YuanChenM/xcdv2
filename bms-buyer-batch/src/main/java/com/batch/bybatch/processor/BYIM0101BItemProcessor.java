package com.batch.bybatch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.batch.bybatch.bean.result.ByimBuyerResult;
import com.framework.batch.item.BaseItemProcessor;

/**
 * Created by guan_zhongheng on 2017/2/23.
 */
public class BYIM0101BItemProcessor implements BaseItemProcessor<ByimBuyerResult,ByimBuyerResult>{

    private static final Logger logger = LoggerFactory.getLogger(BYIM0101BItemProcessor.class);

    @Override
    public ByimBuyerResult process(ByimBuyerResult byimBuyerResult) throws Exception {
        logger.info("处理工作");
        return byimBuyerResult;
    }
}
