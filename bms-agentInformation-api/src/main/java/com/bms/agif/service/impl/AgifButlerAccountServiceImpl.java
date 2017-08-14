/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service.impl;

import com.bms.agif.bean.entity.AgifButlerAccount;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.dao.AgifButlerAccountDao;
import com.bms.agif.service.AgifButlerAccountService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>AgifButlerAccountService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class AgifButlerAccountServiceImpl extends BaseServiceImpl implements AgifButlerAccountService {

    @Autowired
    private AgifButlerAccountDao AgifButlerAccountDao;

    @Override
    public BaseDao getBaseDao() {
        return AgifButlerAccountDao;
    }

    @Override
    public int delete(AgifButlerAccount butlerAccount) {
        return AgifButlerAccountDao.delete(butlerAccount);
    }

    @Override
    public int updateAccount(BaseBean<AgifButlerAccount, AgifButlerAccount> butlerAccountAgifButlerAccountBaseBean) {
        return AgifButlerAccountDao.updateAccount(butlerAccountAgifButlerAccountBaseBean);
    }
}