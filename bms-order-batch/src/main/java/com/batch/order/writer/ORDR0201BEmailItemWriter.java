package com.batch.order.writer;

import com.batch.order.bean.result.ORDR0201BOrderResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by sunjiaju on 2017/3/20.
 */
public class ORDR0201BEmailItemWriter extends MyServiceItemWriter<ORDR0201BOrderResult> {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(ORDR0201BEmailItemWriter.class);

    @Override
    protected void doWrite(List<? extends ORDR0201BOrderResult> var1) throws Exception {
    }
}
