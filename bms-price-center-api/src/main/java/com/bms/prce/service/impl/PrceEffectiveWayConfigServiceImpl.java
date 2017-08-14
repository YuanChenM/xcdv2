/*
 * 2017/01/13 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.prce.service.impl;

import com.bms.prce.dao.PrceEffectiveWayConfigDao;
import com.bms.prce.service.PrceEffectiveWayConfigService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>PrceEffectiveWayConfigService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class PrceEffectiveWayConfigServiceImpl extends BaseServiceImpl implements PrceEffectiveWayConfigService {

    @Autowired
    private PrceEffectiveWayConfigDao prceEffectiveWayConfigDao;

    @Override
    public BaseDao getBaseDao() {
        return prceEffectiveWayConfigDao;
    }
}