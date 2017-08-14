/*
 * 2017/03/01 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.bms.agif.service;

import com.bms.agif.bean.entity.AgifAgentAccount;
import com.bms.agif.bean.param.AccountParam;
import com.bms.agif.bean.param.BaseBean;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * AgifAccountService接口。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface AgifAccountService extends BaseService {

    @Transactional
    long addAgifAccountInfo(AccountParam param);

    @Transactional
    int delete(AgifAgentAccount agifAgentAccount);

    @Transactional
    int updateAccount(BaseBean<AgifAgentAccount, AgifAgentAccount> baseBean);
}