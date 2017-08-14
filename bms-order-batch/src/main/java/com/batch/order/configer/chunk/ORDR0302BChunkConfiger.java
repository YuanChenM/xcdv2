package com.batch.order.configer.chunk;

import com.batch.order.bean.param.BaseRestParam;
import com.batch.order.dao.ORDR0302BDao;
import com.batch.order.processor.ORDR0302BItemProcessor;
import com.batch.order.reader.ORDR0302BItemReader;
import com.batch.order.service.ORDR0302BService;
import com.batch.order.writer.ORDR0302BItemWriter;
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
public class ORDR0302BChunkConfiger extends BaseChunkConfiger<BaseRestParam, BaseRestParam> {
    @Autowired
    private ORDR0302BDao ordr0302BDao;

    @Autowired
    private ORDR0302BService ordr0302BService;

    @Override
    public ItemReader<BaseRestParam> reader() {
        ORDR0302BItemReader reader = new ORDR0302BItemReader();
        reader.setBaseService(ordr0302BService);
        return reader;
    }

    @Override
    public ItemProcessor<BaseRestParam, BaseRestParam> processor() {
        return new ORDR0302BItemProcessor();
    }

    @Override
    public ItemWriter<BaseRestParam> writer() {
        ORDR0302BItemWriter writer = new ORDR0302BItemWriter();
        writer.setBaseDao(ordr0302BDao);
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
