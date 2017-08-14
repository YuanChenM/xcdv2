/*
 * 2016/12/20 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.bypo.services.impl;

import com.bms.bypo.dao.BypoProductResearchDao;
import com.bms.bypo.services.BypoProductResearchService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 /**
 * <p>BypoProductResearchService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 @Service
 public class BypoProductResearchServiceImpl extends BaseServiceImpl implements BypoProductResearchService{

    @Autowired
    private BypoProductResearchDao bypoProductResearchDao;

    @Override
    public BaseDao getBaseDao() {
      return bypoProductResearchDao;
    }
 }