package com.bms.agif.service.impl;

import com.bms.agif.dao.AgifPartnerAgentDao;
import com.bms.agif.service.AgifPartnerAgentService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by guan_zhongheng on 2017/4/12.
 */
@Service
public class AgifPartnerAgentServiceImpl extends BaseServiceImpl implements AgifPartnerAgentService {

    @Autowired
    private AgifPartnerAgentDao agifPartnerAgentDao;

    @Override
    public BaseDao getBaseDao() {
        return agifPartnerAgentDao;
    }
}
