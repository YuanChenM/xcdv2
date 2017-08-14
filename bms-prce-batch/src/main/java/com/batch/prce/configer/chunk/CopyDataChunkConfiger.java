package com.batch.prce.configer.chunk;


import com.batch.prce.bean.param.BaseRestParam;
import com.batch.prce.dao.PRCE0101BDao;
import com.batch.prce.processor.CopyDataProcessor;
import com.batch.prce.reader.CopyDataReader;
import com.batch.prce.service.PRCE0101BService;
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
public class CopyDataChunkConfiger extends BaseChunkConfiger<BaseRestParam, BaseRestParam> {
    @Autowired
    private PRCE0101BDao prce0101BDao;

    @Autowired
    private PRCE0101BService prce0101BService;

    @Override
    public ItemReader<BaseRestParam> reader() {
        CopyDataReader reader = new CopyDataReader();
        reader.setBaseService(prce0101BService);
        return reader;
    }

    @Override
    public ItemProcessor<BaseRestParam, BaseRestParam> processor() {
        return new CopyDataProcessor();
    }

    @Override
    public ItemWriter<BaseRestParam> writer() {
        CopyDataWriter writer = new CopyDataWriter();
        writer.setBaseDao(prce0101BDao);
        return writer;
    }
}
