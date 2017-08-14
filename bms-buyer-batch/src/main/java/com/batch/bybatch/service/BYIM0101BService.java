package com.batch.bybatch.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.batch.bybatch.bean.result.ByimBuyerResult;
import com.framework.boot.base.BaseService;

/**
 * Created by guan_zhongheng on 2017/2/23.
 */
public interface BYIM0101BService extends BaseService {

    @Transactional
    List<ByimBuyerResult> findByimBasicList();

    @Transactional
    void doProcessWork(ByimBuyerResult result);


}
