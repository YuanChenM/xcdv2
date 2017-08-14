package com.batch.order.configer.chunk;

import com.batch.order.bean.param.BaseRestParam;
import com.batch.order.dao.ORDR0303BDao;
import com.batch.order.processor.ORDR0303BItemProcessor;
import com.batch.order.reader.ORDR0303BItemReader;
import com.batch.order.service.ORDR0303BService;
import com.batch.order.writer.ORDR0303BItemWriter;
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
public class ORDR0303BChunkConfiger extends BaseChunkConfiger<BaseRestParam, BaseRestParam> {
    @Autowired
    private ORDR0303BDao ordr0303BDao;

    @Autowired
    private ORDR0303BService ordr0303BService;

    @Override
    public ItemReader<BaseRestParam> reader() {
        ORDR0303BItemReader reader = new ORDR0303BItemReader();
        reader.setBaseService(ordr0303BService);
        return reader;
    }

    @Override
    public ItemProcessor<BaseRestParam, BaseRestParam> processor() {
        return new ORDR0303BItemProcessor();
    }

    @Override
    public ItemWriter<BaseRestParam> writer() {
        ORDR0303BItemWriter writer = new ORDR0303BItemWriter();
        writer.setBaseDao(ordr0303BDao);
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
