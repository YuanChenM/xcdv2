package com.batch.linv.configer.chunk;

import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import com.batch.linv.dao.LinvSynInvDao;
import com.batch.linv.processor.FindLoadDataProcessor;
import com.batch.linv.reader.SynInvReader;
import com.batch.linv.service.Inventory0101BService;
import com.batch.linv.writer.SynInvWriter;
import com.framework.batch.core.BaseChunkConfiger;
import com.framework.batch.core.support.SimpleBatchConfiger;

/**
 * Created by wangfan on 2017/2/16.
 */
@Configuration
@AutoConfigureAfter(SimpleBatchConfiger.class)
public class SynInvChunkConfiger extends BaseChunkConfiger<Map, Map> {

    @Autowired
    private LinvSynInvDao linvSynInvDao;

    @Autowired
    private Inventory0101BService inventory0101BService;

    @Override
    public ItemReader<Map> reader() {
        SynInvReader reader = new SynInvReader();
        reader.setBaseService(inventory0101BService);
        return reader;
    }

    @Override
    public ItemProcessor<Map, Map> processor() {
        return new FindLoadDataProcessor();
    }

    @Override
    public ItemWriter<Map> writer() {
        SynInvWriter writer = new SynInvWriter();
        writer.setBaseDao(linvSynInvDao);
        return writer;
    }
}
