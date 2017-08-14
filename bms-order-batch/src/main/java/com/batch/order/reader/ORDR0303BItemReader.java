package com.batch.order.reader;

import com.batch.order.bean.param.BaseRestParam;
import com.batch.order.service.ORDR0303BService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutao on 2017/1/4.
 */
//@Component
public class ORDR0303BItemReader extends MyServiceItemReader<BaseRestParam> {

    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(ORDR0303BItemReader.class);

    @Override
    protected List<BaseRestParam> query() {
        ORDR0303BService ordr0303BService = (ORDR0303BService)super.getBaseService();
        ordr0303BService.createDistributionNotification();
        return new ArrayList<BaseRestParam>();
    }
}
