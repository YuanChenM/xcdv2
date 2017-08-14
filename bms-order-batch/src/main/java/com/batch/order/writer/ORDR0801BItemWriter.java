package com.batch.order.writer;

import com.batch.order.bean.param.BaseRestParam;
import com.framework.batch.item.database.MybatisItemWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by liutao on 2017/1/4.
 */
public class ORDR0801BItemWriter extends MybatisItemWriter<BaseRestParam> {
    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(ORDR0801BItemWriter.class);


    @Override
    protected void doWrite(List<BaseRestParam> list) throws Exception {

    }
}
