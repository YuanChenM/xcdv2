/*
 * 2017/04/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.linv.services.impl;
import com.bms.linv.dao.InvmProductInfoDao;
import com.bms.linv.services.InvmProductInfoService;
import com.framework.boot.base.BaseDao;
 import com.framework.boot.base.BaseServiceImpl;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 /**
 * <p>InvmProductInfoService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 @Service
 public class InvmProductInfoServiceImpl extends BaseServiceImpl implements InvmProductInfoService {

    @Autowired
    private InvmProductInfoDao invmProductInfoDao;

    @Override
    public BaseDao getBaseDao() {
      return invmProductInfoDao;
    }
 }