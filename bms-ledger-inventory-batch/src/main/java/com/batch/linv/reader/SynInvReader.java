package com.batch.linv.reader;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.batch.linv.service.Inventory0101BService;

/**
 * Created by wangfan on 2017/2/21.
 */
// @Component
public class SynInvReader extends MyServiceItemReader<Map> {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(SynInvReader.class);

    @Override
    protected List<Map> query() {
        Inventory0101BService inventory0101BService = (Inventory0101BService) super.getBaseService();
        return inventory0101BService.findLoadData();
    }
}
