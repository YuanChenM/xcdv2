package com.batch.prce.reader;

import com.batch.prce.bean.entity.PrceProductInfo;
import com.batch.prce.service.PRCE0101BService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by sunjiaju on 2017/2/16.
 */
//@Component
public class BackUpReader extends MyServiceItemReader<PrceProductInfo> {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(BackUpReader.class);

    @Override
    protected List<PrceProductInfo> query() {
        PRCE0101BService prce0101BService = (PRCE0101BService) super.getBaseService();
        return prce0101BService.getBackUp();
    }
}
