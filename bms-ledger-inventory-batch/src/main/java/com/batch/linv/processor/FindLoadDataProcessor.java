package com.batch.linv.processor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.batch.linv.bean.entity.LinvLoad;
import com.framework.batch.item.BaseItemProcessor;

import java.util.Map;

/**
 * Created by wangfan on 2017/2/21.
 */
public class FindLoadDataProcessor implements BaseItemProcessor<Map, Map> {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(FindLoadDataProcessor.class);


    @Override
    public Map process(Map map) throws Exception {
        return map;
    }
}
