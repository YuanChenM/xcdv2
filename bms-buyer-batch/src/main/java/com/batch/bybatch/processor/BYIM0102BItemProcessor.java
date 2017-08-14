package com.batch.bybatch.processor;

import com.batch.bybatch.bean.result.BuyerProductResult;
import com.framework.batch.item.BaseItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yuan_zhifei on 2017/5/25.
 */
public class BYIM0102BItemProcessor implements BaseItemProcessor<BuyerProductResult, BuyerProductResult> {

    private static final Logger logger = LoggerFactory.getLogger(BYIM0102BItemProcessor.class);

    @Override
    public BuyerProductResult process(BuyerProductResult buyerProductResult) throws Exception {
        logger.info("处理工作");
        return buyerProductResult;
    }
}
