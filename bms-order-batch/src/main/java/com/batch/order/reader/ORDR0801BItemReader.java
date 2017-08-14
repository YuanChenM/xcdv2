package com.batch.order.reader;

import com.batch.order.bean.param.BaseRestParam;
import com.batch.order.service.ORDR0801BService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutao on 2017/1/4.
 */
public class ORDR0801BItemReader extends MyServiceItemReader<BaseRestParam> {

    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(ORDR0801BItemReader.class);

    @Override
    protected List<BaseRestParam> query() {
        ORDR0801BService ordr0801BService = (ORDR0801BService)super.getBaseService();
        ordr0801BService.createReturnXml();
        return new ArrayList<BaseRestParam>();
    }
}
