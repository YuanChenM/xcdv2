package com.batch.order.configer.chunk;

import com.batch.order.bean.param.BaseRestParam;
import com.batch.order.dao.ORDR0301BDao;
import com.batch.order.processor.ORDR0301BItemProcessor;
import com.batch.order.reader.ORDR0301BItemReader;
import com.batch.order.service.ORDR0301BService;
import com.batch.order.writer.ORDR0301BItemWriter;
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
public class ORDR0301BChunkConfiger extends BaseChunkConfiger<BaseRestParam, BaseRestParam> {
    @Autowired
    private ORDR0301BDao ordr0301BDao;

    @Autowired
    private ORDR0301BService ordr0301BService;

    @Override
    public ItemReader<BaseRestParam> reader() {
        ORDR0301BItemReader reader = new ORDR0301BItemReader();
        reader.setBaseService(ordr0301BService);
        return reader;
    }

    @Override
    public ItemProcessor<BaseRestParam, BaseRestParam> processor() {
        return new ORDR0301BItemProcessor();
    }

    @Override
    public ItemWriter<BaseRestParam> writer() {
        ORDR0301BItemWriter writer = new ORDR0301BItemWriter();
        writer.setBaseDao(ordr0301BDao);
        return writer;
    }

    @Override
    public Class[] skipExceptionClasses() {
        return new Class[]{};
    }

    @Override
    public Class[] noSkipExceptionClasses() {
        return new Class[]{};
    }
}
