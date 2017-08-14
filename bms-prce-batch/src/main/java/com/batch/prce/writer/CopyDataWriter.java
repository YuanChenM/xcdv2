package com.batch.prce.writer;


import com.batch.prce.bean.param.BaseRestParam;
import com.framework.batch.item.database.MybatisItemWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by sunjiaju on 2017/2/16.
 */
public class CopyDataWriter extends MybatisItemWriter<BaseRestParam> {
    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(CopyDataWriter.class);


    @Override
    protected void doWrite(List<BaseRestParam> list) throws Exception {

    }
}
