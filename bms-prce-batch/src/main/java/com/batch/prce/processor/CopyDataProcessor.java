package com.batch.prce.processor;


import com.batch.prce.bean.param.BaseRestParam;
import com.framework.batch.item.BaseItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sunjiaju on 2017/2/16.
 */
public class CopyDataProcessor implements BaseItemProcessor<BaseRestParam, BaseRestParam> {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(CopyDataProcessor.class);


    @Override
    public BaseRestParam process(BaseRestParam aVoid) throws Exception {
        return null;
    }
}
