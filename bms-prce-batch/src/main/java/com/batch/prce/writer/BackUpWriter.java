package com.batch.prce.writer;


import com.batch.prce.bean.entity.PrceProductInfo;
import com.batch.prce.dao.PRCE0101BDao;
import com.framework.batch.item.database.MybatisItemWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by sunjiaju on 2017/2/16.
 */
public class BackUpWriter extends MybatisItemWriter<PrceProductInfo> {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(BackUpWriter.class);

    @Override
    protected void doWrite(List<PrceProductInfo> list) throws Exception {
        PRCE0101BDao prce0101BDao = (PRCE0101BDao) super.getBaseDao();
        prce0101BDao.batchInsertHis(list);
    }
}
