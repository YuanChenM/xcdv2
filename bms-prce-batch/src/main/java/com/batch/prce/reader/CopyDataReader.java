package com.batch.prce.reader;

import com.batch.prce.bean.param.BaseRestParam;
import com.batch.prce.service.PRCE0101BService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjiaju on 2017/2/16.
 */
//@Component
public class CopyDataReader extends MyServiceItemReader<BaseRestParam> {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(CopyDataReader.class);

    @Override
    protected List<BaseRestParam> query() {
        PRCE0101BService prce0101BService = (PRCE0101BService) super.getBaseService();
        prce0101BService.goodsSync();
        return new ArrayList<BaseRestParam>();
    }
}
