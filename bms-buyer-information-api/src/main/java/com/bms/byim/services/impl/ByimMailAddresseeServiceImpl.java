/*
 * 2017/02/10 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.byim.services.impl;

import com.bms.byim.services.ByimMailAddresseeService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 /**
 * <p>ByimMailAddresseeService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 @Service
 public class ByimMailAddresseeServiceImpl extends BaseServiceImpl implements ByimMailAddresseeService{

    @Autowired
    private com.bms.byim.dao.ByimMailAddresseeDao ByimMailAddresseeDao;

    @Override
    public BaseDao getBaseDao() {
      return ByimMailAddresseeDao;
    }
 }