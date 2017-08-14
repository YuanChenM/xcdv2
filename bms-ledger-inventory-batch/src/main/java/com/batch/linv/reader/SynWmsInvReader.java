package com.batch.linv.reader;

import java.util.List;
import java.util.Map;

import com.batch.linv.bean.entity.InvmLoad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.batch.linv.service.Inventory0101BService;

/**
 * Created by wangfan on 2017/5/6.
 */
// @Component
public class SynWmsInvReader extends MyServiceItemReader<InvmLoad> {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(SynWmsInvReader.class);

    @Override
    protected List<InvmLoad> query() {
        Inventory0101BService inventory0101BService = (Inventory0101BService) super.getBaseService();
        return inventory0101BService.findAllSkuCode();
    }
}
