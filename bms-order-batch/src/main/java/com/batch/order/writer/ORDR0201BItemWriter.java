package com.batch.order.writer;

import com.batch.order.bean.param.BaseRestParam;
import com.batch.order.bean.result.ORDR0201BOrderResult;
import com.batch.order.service.ORDR0201BService;
import com.framework.batch.item.database.MybatisItemWriter;
import com.framework.core.utils.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by liutao on 2017/1/4.
 */
public class ORDR0201BItemWriter extends MyServiceItemWriter<ORDR0201BOrderResult> {
    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(ORDR0201BItemWriter.class);

    @Override
    protected void doWrite(List<? extends ORDR0201BOrderResult> var1) throws Exception {
        ORDR0201BService ordr0201BService = (ORDR0201BService)super.getBaseService();
        if (!CollectionUtils.isEmpty(var1)){
            for (ORDR0201BOrderResult var : var1){
                ordr0201BService.createSplitOrderDetail(var);
            }
        }
    }
}
