package com.batch.order.reader;

import com.batch.order.bean.result.ORDR0201BOrderResult;
import com.batch.order.service.ORDR0201BService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjijau on 2017/3/20.
 */
//@Component
public class ORDR0201BEmailItemReader extends MyServiceItemReader<ORDR0201BOrderResult> {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(ORDR0201BEmailItemReader.class);

    @Override
    protected List<ORDR0201BOrderResult> query() {
        ORDR0201BService ordr0201BService = (ORDR0201BService) super.getBaseService();
        ordr0201BService.sendEmail();
        return new ArrayList<ORDR0201BOrderResult>();
    }
}
