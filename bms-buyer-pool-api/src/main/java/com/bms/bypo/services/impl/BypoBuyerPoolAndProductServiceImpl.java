/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.bypo.services.impl;

import com.bms.bypo.dao.BuyerPoolAndProductDao;
import com.bms.bypo.services.BypoBuyerPoolAndProductService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>BypoBuyerPoolService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class BypoBuyerPoolAndProductServiceImpl extends BaseServiceImpl implements BypoBuyerPoolAndProductService {

    @Autowired
    private BuyerPoolAndProductDao buyerPoolAndProductDao;

    @Override
    public BaseDao getBaseDao() {
        return buyerPoolAndProductDao;
    }


}