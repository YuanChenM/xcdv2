/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.agif.service.impl;

import com.bms.agif.bean.entity.AgifPartnerAccount;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.dao.AgifPartnerAccountDao;
import com.bms.agif.service.AgifPartnerAccountService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 /**
 * <p>AgifPartnerAccountService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 @Service
 public class AgifPartnerAccountServiceImpl extends BaseServiceImpl implements AgifPartnerAccountService{

    @Autowired
    private AgifPartnerAccountDao AgifPartnerAccountDao;

    @Override
    public BaseDao getBaseDao() {
      return AgifPartnerAccountDao;
    }

     @Override
     public int delete(AgifPartnerAccount partnerAccount) {
         return AgifPartnerAccountDao.delete(partnerAccount);
     }

     @Override
     public int updateAccount(BaseBean<AgifPartnerAccount, AgifPartnerAccount> baseBean) {
         return AgifPartnerAccountDao.updateAccount(baseBean);
     }
 }