package com.batch.order.configer.chunk;

import com.batch.order.bean.param.BaseRestParam;
import com.batch.order.dao.ORDR0801BDao;
import com.batch.order.processor.ORDR0801BItemProcessor;
import com.batch.order.reader.ORDR0801BItemReader;
import com.batch.order.service.ORDR0801BService;
import com.batch.order.writer.ORDR0801BItemWriter;
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
public class ORDR0801BChunkConfiger extends BaseChunkConfiger<BaseRestParam, BaseRestParam> {
    @Autowired
    private ORDR0801BDao ordr0801BDao;

    @Autowired
    private ORDR0801BService ordr0801BService;

    @Override
    public ItemReader<BaseRestParam> reader() {
        ORDR0801BItemReader reader = new ORDR0801BItemReader();
        reader.setBaseService(ordr0801BService);
        return reader;
    }

    @Override
    public ItemProcessor<BaseRestParam, BaseRestParam> processor() {
        return new ORDR0801BItemProcessor();
    }

    @Override
    public ItemWriter<BaseRestParam> writer() {
        ORDR0801BItemWriter writer = new ORDR0801BItemWriter();
        writer.setBaseDao(ordr0801BDao);
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
