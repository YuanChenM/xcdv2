package com.batch.bybatch.reader;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.batch.bybatch.bean.result.ByimBuyerResult;
import com.batch.bybatch.service.BYIM0101BService;

/**
 * Created by guan_zhongheng on 2017/2/23.
 */
public class BYIM0101BItemReader extends MyServiceItemReader<ByimBuyerResult>{

    private static final Logger logger = LoggerFactory.getLogger(BYIM0101BItemReader.class);

    @Override
    protected List<ByimBuyerResult> query() {
        System.out.println("reader。。。。。。。。。。。。。。。。。");
        BYIM0101BService service = (BYIM0101BService)super.getBaseService();
        return service.findByimBasicList();
    }

}
