package com.batch.order.reader;

import com.batch.order.bean.param.BaseRestParam;
import com.batch.order.service.ORDR0201BService;
import com.batch.order.service.ORDR0301BService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutao on 2017/1/4.
 */
//@Component
public class ORDR0301BItemReader extends MyServiceItemReader<BaseRestParam> {

    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(ORDR0301BItemReader.class);

    @Override
    protected List<BaseRestParam> query() {
        ORDR0301BService ordr0301BService = (ORDR0301BService)super.getBaseService();
        ordr0301BService.createDistributionNotification();
        return new ArrayList<BaseRestParam>();
    }
}
