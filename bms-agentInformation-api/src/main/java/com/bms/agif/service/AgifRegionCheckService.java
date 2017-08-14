package com.bms.agif.service;

import com.bms.agif.bean.param.AgentDemesneParam;
import com.bms.agif.bean.param.AgentParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by guan_zhongheng on 2017/4/12.
 */
public interface AgifRegionCheckService extends BaseService {

    @Transactional
    int checkRegionNum(AgentParam param);
    @Transactional
    int checkLgcsRegionNum(AgentDemesneParam param);
}
