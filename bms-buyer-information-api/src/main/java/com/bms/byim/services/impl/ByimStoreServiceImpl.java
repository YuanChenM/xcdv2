/*
 * 2016/12/29 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services.impl;

import com.bms.byim.bean.entity.ByimStore;
import com.bms.byim.bean.param.StoreRsParam;
import com.bms.byim.dao.ByimStoreDao;
import com.bms.byim.services.ByimStoreService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>ByimStoreService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class ByimStoreServiceImpl extends BaseServiceImpl implements ByimStoreService {

    @Autowired
    private ByimStoreDao byimStoreDao;

    @Override
    public BaseDao getBaseDao() {
        return byimStoreDao;
    }

    @Override
    public int findTerminalMarketUse(StoreRsParam storeRsParam) {
        return byimStoreDao.findTerminalMarketUse(storeRsParam);
    }

    @Override
    public int modifyStore(ByimStore store) {
        return byimStoreDao.modifyStore(store);
    }

    @Override
    public List<StoreRsParam> findList(StoreRsParam storeRsParam) {
        return byimStoreDao.findList(storeRsParam);
    }
}