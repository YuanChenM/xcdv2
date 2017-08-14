package com.bms.agif.dao;

import com.bms.agif.bean.param.AgentDemesneParam;
import com.bms.agif.bean.param.AgentParam;
import com.framework.boot.base.BaseDao;

/**
 * Created by guan_zhongheng on 2017/4/12.
 */
public interface AgifRegionCheckDao extends BaseDao {

    int checkRegionNum(AgentParam param);

    int checkLgcsRegionNum(AgentDemesneParam param);
}
