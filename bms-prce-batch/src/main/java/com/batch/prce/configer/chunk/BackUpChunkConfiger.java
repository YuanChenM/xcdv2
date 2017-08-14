package com.batch.prce.configer.chunk;


import com.batch.prce.bean.entity.PrceProductInfo;
import com.batch.prce.dao.PRCE0101BDao;
import com.batch.prce.processor.BackUpProcessor;
import com.batch.prce.reader.BackUpReader;
import com.batch.prce.service.PRCE0101BService;
import com.batch.prce.writer.BackUpWriter;
import com.batch.prce.writer.CopyDataWriter;
import com.framework.batch.core.BaseChunkConfiger;
import com.framework.batch.core.support.SimpleBatchConfiger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sunjiaju on 2017/2/16.
 */
@Configuration
@AutoConfigureAfter(SimpleBatchConfiger.class)
public class BackUpChunkConfiger extends BaseChunkConfiger<PrceProductInfo, PrceProductInfo> {
    @Autowired
    private PRCE0101BDao prce0101BDao;

    @Autowired
    private PRCE0101BService prce0101BService;

    @Override
    public ItemReader<PrceProductInfo> reader() {
        BackUpReader reader = new BackUpReader();
        reader.setBaseService(prce0101BService);
        return reader;
    }

    @Override
    public ItemProcessor<PrceProductInfo, PrceProductInfo> processor() {
        return new BackUpProcessor();
    }

    @Override
    public ItemWriter<PrceProductInfo> writer() {
        BackUpWriter writer = new BackUpWriter();
        writer.setBaseDao(prce0101BDao);
        return writer;
    }
}
