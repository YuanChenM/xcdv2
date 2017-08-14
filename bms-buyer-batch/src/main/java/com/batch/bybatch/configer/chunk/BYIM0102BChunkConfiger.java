package com.batch.bybatch.configer.chunk;

import com.batch.bybatch.bean.result.BuyerProductResult;
import com.batch.bybatch.bean.result.ByimBuyerResult;
import com.batch.bybatch.processor.BYIM0102BItemProcessor;
import com.batch.bybatch.reader.BYIM0102BItemReader;
import com.batch.bybatch.service.BYIM0102BService;
import com.batch.bybatch.writer.BYIM0102BItemWriter;
import com.framework.batch.core.BaseChunkConfiger;
import com.framework.batch.core.support.SimpleBatchConfiger;
import com.framework.core.utils.CollectionUtils;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yuan_zhifei on 2017/5/25.
 */
@Configuration
@AutoConfigureAfter(SimpleBatchConfiger.class)
public class BYIM0102BChunkConfiger extends BaseChunkConfiger<BuyerProductResult, BuyerProductResult> {

    @Autowired
    private BYIM0102BService byim0102BService;

    @Override
    public ItemReader<BuyerProductResult> reader() {
        BYIM0102BItemReader reader = new BYIM0102BItemReader();
        reader.setBaseService(byim0102BService);
        return reader;
    }

    @Override
    public ItemProcessor<BuyerProductResult, BuyerProductResult> processor() {
        return new BYIM0102BItemProcessor();
    }

    @Override
    public ItemWriter<BuyerProductResult> writer() {
        BYIM0102BItemWriter writer = new BYIM0102BItemWriter();
        writer.setBaseService(byim0102BService);
        return writer;
    }
}
