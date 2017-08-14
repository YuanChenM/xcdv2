/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.agif.service.impl;

import com.bms.agif.dao.AgifButlerIntroduceDao;
import com.bms.agif.service.AgifButlerIntroduceService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 /**
 * <p>AgifButlerIntroduceService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 @Service
 public class AgifButlerIntroduceServiceImpl extends BaseServiceImpl implements AgifButlerIntroduceService{

    @Autowired
    private AgifButlerIntroduceDao AgifButlerIntroduceDao;

    @Override
    public BaseDao getBaseDao() {
      return AgifButlerIntroduceDao;
    }
 }