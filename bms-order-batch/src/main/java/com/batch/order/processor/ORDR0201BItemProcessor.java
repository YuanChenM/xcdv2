package com.batch.order.processor;

import com.batch.order.bean.param.BaseRestParam;
import com.batch.order.bean.result.ORDR0201BOrderResult;
import com.framework.batch.item.BaseItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liutao on 2017/1/4.
 */
public class ORDR0201BItemProcessor implements BaseItemProcessor<ORDR0201BOrderResult, ORDR0201BOrderResult> {
    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(ORDR0201BItemProcessor.class);


    @Override
    public ORDR0201BOrderResult process(ORDR0201BOrderResult aVoid) throws Exception {
        return aVoid;
    }
}
