/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.bymt.services.impl;

import com.bms.bymt.dao.BymtMarketStationRelationDao;
import com.bms.bymt.services.BymtMarketStationRelationService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 /**
 * <p>BymtMarketStationRelationService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 @Service
 public class BymtMarketStationRelationServiceImpl extends BaseServiceImpl implements BymtMarketStationRelationService{

    @Autowired
    private BymtMarketStationRelationDao bymtMarketStationRelationDao;

    @Override
    public BaseDao getBaseDao() {
      return bymtMarketStationRelationDao;
    }
 }