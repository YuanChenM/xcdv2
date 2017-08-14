package com.batch.linv.configer.chunk;

import java.util.Map;

import com.batch.linv.bean.entity.InvmLoad;
import com.batch.linv.reader.SynWmsInvReader;
import com.batch.linv.writer.SynWmsInvWriter;
import com.framework.boot.base.BaseDao;
import com.framework.redis.dao.BaseRedisDao;
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
 * Created by wangfan on 2017/5/6.
 */
@Configuration
@AutoConfigureAfter(SimpleBatchConfiger.class)
public class SynWmsInvChunkConfiger extends BaseChunkConfiger<InvmLoad, InvmLoad> {

    @Autowired
    private LinvSynInvDao linvSynInvDao;

    @Autowired
    private BaseRedisDao baseRedisDao;

    @Autowired
    private Inventory0101BService inventory0101BService;

    @Override
    public ItemReader<InvmLoad> reader() {
        SynWmsInvReader reader = new SynWmsInvReader();
        reader.setBaseService(inventory0101BService);
        return reader;
    }

    @Override
    public ItemProcessor<InvmLoad, InvmLoad> processor() {
        return null;
    }

    @Override
    public ItemWriter<InvmLoad> writer() {
        SynWmsInvWriter writer = new SynWmsInvWriter();
        writer.setBaseDao(linvSynInvDao);
        return writer;
    }
}
