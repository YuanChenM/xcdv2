/*
 * 2017/04/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.linv.services.impl;
import com.bms.linv.dao.InvmComoBalanceDealDetailDao;
import com.bms.linv.services.InvmComoBalanceDealDetailService;
import com.framework.boot.base.BaseDao;
 import com.framework.boot.base.BaseServiceImpl;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 /**
 * <p>InvmComoBalanceDealDetailService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 @Service
 public class InvmComoBalanceDealDetailServiceImpl extends BaseServiceImpl implements InvmComoBalanceDealDetailService {

    @Autowired
    private InvmComoBalanceDealDetailDao invmComoBalanceDealDetailDao;

    @Override
    public BaseDao getBaseDao() {
      return invmComoBalanceDealDetailDao;
    }
 }