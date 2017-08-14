package com.batch.bybatch.configer.chunk;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import com.batch.bybatch.bean.result.ByimBuyerResult;
import com.batch.bybatch.processor.BYIM0101BItemProcessor;
import com.batch.bybatch.reader.BYIM0101BItemReader;
import com.batch.bybatch.service.BYIM0101BService;
import com.batch.bybatch.writer.BYIM0101BItemWriter;
import com.framework.batch.core.BaseChunkConfiger;
import com.framework.batch.core.support.SimpleBatchConfiger;

/**
 * Created by guan_zhongheng on 2017/2/23.
 */
@Configuration
@AutoConfigureAfter(SimpleBatchConfiger.class)
public class BYIM0101BChunkConfiger extends BaseChunkConfiger<ByimBuyerResult,ByimBuyerResult> {

    @Autowired
    private BYIM0101BService byim0101BService;

    @Override
    public ItemReader<ByimBuyerResult> reader() {
        BYIM0101BItemReader reader = new BYIM0101BItemReader();
        reader.setBaseService(byim0101BService);
        return reader;
    }

    @Override
    public ItemProcessor<ByimBuyerResult, ByimBuyerResult> processor() {
        return new BYIM0101BItemProcessor();
    }

    @Override
    public ItemWriter<ByimBuyerResult> writer() {
        BYIM0101BItemWriter writer = new BYIM0101BItemWriter();
        writer.setBaseService(byim0101BService);
        return writer;
    }
}
