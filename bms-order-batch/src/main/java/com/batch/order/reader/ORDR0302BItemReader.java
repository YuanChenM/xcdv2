package com.batch.order.reader;

import com.batch.order.bean.param.BaseRestParam;
import com.batch.order.service.ORDR0302BService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutao on 2017/1/4.
 */
//@Component
public class ORDR0302BItemReader extends MyServiceItemReader<BaseRestParam> {

    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(ORDR0302BItemReader.class);

    @Override
    protected List<BaseRestParam> query() {
        ORDR0302BService ordr0302BService = (ORDR0302BService)super.getBaseService();
        ordr0302BService.createDistributionNotification();
        return new ArrayList<BaseRestParam>();
    }
}
