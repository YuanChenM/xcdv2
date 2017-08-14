package com.batch.order.service;

import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liutao on 2017/1/4.
 */
public interface ORDR0303BService extends BaseService {
    @Transactional
    void createDistributionNotification();
}
