package com.batch.order.reader;

import com.batch.order.bean.param.BaseRestParam;
import com.batch.order.bean.result.ORDR0101BOrderResult;
import com.batch.order.service.ORDR0101BService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutao on 2017/1/4.
 */
//@Component
public class ORDR0101BItemReader extends MyServiceItemReader<BaseRestParam> {

    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(ORDR0101BItemReader.class);

    @Override
    protected List<BaseRestParam> query() {
        ORDR0101BService ordr0101BService = (ORDR0101BService)super.getBaseService();
        ordr0101BService.confirmOrder();
        return new ArrayList<BaseRestParam>();
    }
}
