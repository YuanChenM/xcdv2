/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.agif.service.impl;

import com.bms.agif.bean.entity.AgifAccount;
import com.bms.agif.bean.entity.AgifAgentAccount;
import com.bms.agif.bean.param.AccountParam;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.dao.AgifAccountDao;
import com.bms.agif.service.AgifAccountService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 /**
 * <p>AgifAccountService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 @Service
 public class AgifAccountServiceImpl extends BaseServiceImpl implements AgifAccountService{

    @Autowired
    private AgifAccountDao AgifAccountDao;

    @Override
    public BaseDao getBaseDao() {
      return AgifAccountDao;
    }

     @Override
     public long addAgifAccountInfo(AccountParam param) {
         int count = this.getCount(param);
         if(count != NumberUtils.INTEGER_ZERO){
             return -1; //账号已经存在
         }
         AgifAccount bean = BeanUtils.toBean(param, AgifAccount.class);
         Long accountId = this.maxId("AGIF_ACCOUNT");
         bean.setAccountId(accountId);
         bean.setCrtId(this.getLoginUserId());
         bean.setUpdId(this.getLoginUserId());
         bean.setCrtTime(DateUtils.getCurrent());
         bean.setUpdTime(DateUtils.getCurrent());
         this.save(bean);
         return accountId;
     }

     @Override
     public int delete(AgifAgentAccount butlerAccount) {
         return AgifAccountDao.delete(butlerAccount);
     }

     @Override
     public int updateAccount(BaseBean<AgifAgentAccount, AgifAgentAccount> baseBean) {
         return AgifAccountDao.updateAccount(baseBean);
     }
 }