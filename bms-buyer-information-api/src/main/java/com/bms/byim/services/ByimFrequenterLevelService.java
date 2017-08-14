package com.bms.byim.services;

import com.bms.byim.bean.param.FrequenterLevelRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yuan_zhifei on 2017/3/21.
 */
public interface ByimFrequenterLevelService extends BaseService {
    @Transactional
    int saveFrequenterLevel(FrequenterLevelRsParam levelRsParam);
}
