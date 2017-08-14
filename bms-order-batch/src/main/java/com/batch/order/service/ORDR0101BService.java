package com.batch.order.service;

import com.batch.order.bean.result.ORDR0101BOrderResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by liutao on 2017/1/4.
 */
public interface ORDR0101BService extends BaseService {
    @Transactional
    void confirmOrder();
}
