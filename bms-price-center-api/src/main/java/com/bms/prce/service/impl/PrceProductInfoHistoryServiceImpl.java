/*
 * 2017/01/10 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.prce.service.impl;

 import com.bms.prce.dao.PrceProductInfoHistoryDao;
 import com.bms.prce.service.PrceProductInfoHistoryService;
 import com.framework.boot.base.BaseDao;
 import com.framework.boot.base.BaseServiceImpl;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 /**
 * <p>PrceProductInfoHistoryService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 @Service
 public class PrceProductInfoHistoryServiceImpl extends BaseServiceImpl implements PrceProductInfoHistoryService {

    @Autowired
    private PrceProductInfoHistoryDao prceProductInfoHistoryDao;

    @Override
    public BaseDao getBaseDao() {
      return prceProductInfoHistoryDao;
    }
 }