/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service;

import com.bms.agif.bean.entity.AgifPartnerAccount;
import com.bms.agif.bean.param.BaseBean;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>AgifPartnerAccountService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface AgifPartnerAccountService extends BaseService {

    @Transactional
    int delete(AgifPartnerAccount partnerAccount);

    @Transactional
    int updateAccount(BaseBean<AgifPartnerAccount,AgifPartnerAccount> baseBean);
}