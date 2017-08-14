package com.batch.order.configer.chunk;

import com.batch.order.bean.result.ORDR0201BOrderResult;
import com.batch.order.processor.ORDR0201BItemProcessor;
import com.batch.order.reader.ORDR0201BItemReader;
import com.batch.order.service.ORDR0201BService;
import com.batch.order.writer.ORDR0201BItemWriter;
import com.framework.batch.core.BaseChunkConfiger;
import com.framework.batch.core.support.SimpleBatchConfiger;
import com.framework.exception.BusinessException;
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
public class ORDR0201BChunkConfiger extends BaseChunkConfiger<ORDR0201BOrderResult, ORDR0201BOrderResult> {
    @Autowired
    private ORDR0201BService ordr0201BService;

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
    public ItemReader<ORDR0201BOrderResult> reader() {
        ORDR0201BItemReader reader = new ORDR0201BItemReader();
        reader.setBaseService(ordr0201BService);
        return reader;
    }

    @Override
    public ItemProcessor<ORDR0201BOrderResult, ORDR0201BOrderResult> processor() {
        return new ORDR0201BItemProcessor();
    }

    @Override
    public ItemWriter<ORDR0201BOrderResult> writer() {
        ORDR0201BItemWriter writer = new ORDR0201BItemWriter();
        writer.setBaseService(ordr0201BService);
        return writer;
    }
}
