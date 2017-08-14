package com.batch.prce.service;

import com.batch.prce.bean.entity.PrceProductInfo;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sunjiaju on 2017/2/16.
 */
public interface PRCE0101BService extends BaseService {
    @Transactional
    int goodsSync();

    List<PrceProductInfo> getBackUp();
}
