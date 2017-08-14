package com.batch.prce.processor;


import com.batch.prce.bean.entity.PrceProductInfo;
import com.framework.batch.item.BaseItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sunjiaju on 2017/2/16.
 */
public class BackUpProcessor implements BaseItemProcessor<PrceProductInfo, PrceProductInfo> {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(BackUpProcessor.class);


    @Override
    public PrceProductInfo process(PrceProductInfo prceProductInfo) throws Exception {
        return prceProductInfo;
    }
}
