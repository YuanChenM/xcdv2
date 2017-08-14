package com.batch.order.reader;

import com.batch.order.bean.result.ORDR0201BOrderResult;
import com.batch.order.service.ORDR0201BService;
import com.batch.order.bean.param.BaseRestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutao on 2017/1/4.
 */
//@Component
public class ORDR0201BItemReader extends MyServiceItemReader<ORDR0201BOrderResult> {

    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(ORDR0201BItemReader.class);

    @Override
    protected List<ORDR0201BOrderResult> query() {
        ORDR0201BService ordr0201BService = (ORDR0201BService)super.getBaseService();
        return ordr0201BService.getOrderResults();
    }
}
