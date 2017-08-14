/*
 * 2017/03/09 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.agif.service.impl;

import com.bms.agif.dao.AgifButlerDemesneDao;
import com.bms.agif.service.AgifButlerDemesneService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 /**
 * <p>AgifButlerDemesneService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 @Service
 public class AgifButlerDemesneServiceImpl extends BaseServiceImpl implements AgifButlerDemesneService {

    @Autowired
    private AgifButlerDemesneDao agifButlerDemesneDao;

    @Override
    public BaseDao getBaseDao() {
      return agifButlerDemesneDao;
    }
 }