package com.batch.bybatch.service;

import com.batch.bybatch.bean.result.BuyerProductResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yuan_zhifei on 2017/5/25.
 */
public interface BYIM0102BService extends BaseService {
    @Transactional
    void doProcessWork(List<? extends BuyerProductResult> results);
}
