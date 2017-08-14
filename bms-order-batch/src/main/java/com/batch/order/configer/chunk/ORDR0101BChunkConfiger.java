package com.batch.order.configer.chunk;

import com.batch.order.bean.param.BaseRestParam;
import com.batch.order.bean.result.ORDR0101BOrderResult;
import com.batch.order.dao.ORDR0101BDao;
import com.batch.order.dao.ORDR0301BDao;
import com.batch.order.processor.ORDR0101BItemProcessor;
import com.batch.order.reader.ORDR0101BItemReader;
import com.batch.order.service.ORDR0101BService;
import com.batch.order.writer.ORDR0101BItemWriter;
import com.framework.batch.core.BaseChunkConfiger;
import com.framework.batch.core.support.SimpleBatchConfiger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liutao on 2017/1/4.
 */
@Configuration
@AutoConfigureAfter(SimpleBatchConfiger.class)
public class ORDR0101BChunkConfiger extends BaseChunkConfiger<BaseRestParam, BaseRestParam> {
    @Autowired
    private ORDR0101BService ordr0101BService;

    @Autowired
    private ORDR0101BDao ordr0101BDao;

    public int commitInterval() {
        return 100;
    }

    public int skipLimit() {
        return 11100;
    }

    public int retryLimit() {
        return 2;
    }

    public Class[] retryableExceptionClasses() {
        return new Class[]{};
    }

    public Class[] nonRetryableExceptionClasses() {
        return new Class[]{Exception.class};
    }

    public Class[] skipExceptionClasses() {
        return new Class[]{Exception.class};
    }

    public Class[] noSkipExceptionClasses() {
        return new Class[]{};
    }

    @Override
    public ItemReader<BaseRestParam> reader() {
        ORDR0101BItemReader reader = new ORDR0101BItemReader();
        reader.setBaseService(ordr0101BService);
        return reader;
    }

    @Override
    public ItemProcessor<BaseRestParam, BaseRestParam> processor() {
        return new ORDR0101BItemProcessor();
    }

    @Override
    public ItemWriter<BaseRestParam> writer() {
        ORDR0101BItemWriter writer = new ORDR0101BItemWriter();
        writer.setBaseDao(ordr0101BDao);
        return writer;
    }
}
