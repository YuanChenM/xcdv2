package com.batch.bybatch.writer;

import com.batch.bybatch.bean.result.BuyerProductResult;
import com.batch.bybatch.bean.result.ByimBuyerResult;
import com.batch.bybatch.service.BYIM0102BService;
import com.framework.core.utils.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by yuan_zhifei on 2017/5/25.
 */
public class BYIM0102BItemWriter extends MyServiceItemWriter<BuyerProductResult> {

    private static final Logger logger = LoggerFactory.getLogger(BYIM0102BItemWriter.class);

    @Override
    protected void doWrite(List<? extends BuyerProductResult> var1) throws Exception {
        BYIM0102BService service = (BYIM0102BService) super.getBaseService();
        if (CollectionUtils.isNotEmpty(var1)) {
            service.doProcessWork(var1);
        }
    }
}
