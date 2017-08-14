package com.batch.order.processor;

import com.batch.order.bean.param.BaseRestParam;
import com.framework.batch.item.BaseItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liutao on 2017/1/4.
 */
public class ORDR0101BItemProcessor implements BaseItemProcessor<BaseRestParam, BaseRestParam> {
    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(ORDR0101BItemProcessor.class);


    @Override
    public BaseRestParam process(BaseRestParam aVoid) throws Exception {
        return null;
    }
}
