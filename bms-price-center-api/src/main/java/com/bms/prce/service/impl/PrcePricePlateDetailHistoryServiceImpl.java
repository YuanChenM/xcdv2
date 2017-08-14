/*
 * 2017/01/10 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.prce.service.impl;

 import com.bms.prce.dao.PrcePricePlateDetailHistoryDao;
 import com.bms.prce.service.PrcePricePlateDetailHistoryService;
 import com.framework.boot.base.BaseDao;
 import com.framework.boot.base.BaseServiceImpl;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 /**
 * <p>PrcePricePlateDetailHistoryService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 @Service
 public class PrcePricePlateDetailHistoryServiceImpl extends BaseServiceImpl implements PrcePricePlateDetailHistoryService {

    @Autowired
    private PrcePricePlateDetailHistoryDao prcePricePlateDetailHistoryDao;

    @Override
    public BaseDao getBaseDao() {
      return prcePricePlateDetailHistoryDao;
    }
 }