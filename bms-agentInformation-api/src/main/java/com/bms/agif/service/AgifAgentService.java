/*
 * 2017/03/01 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.bms.agif.service;

import com.bms.agif.bean.param.AccountParam;
import com.bms.agif.bean.param.BaseBean;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * AgifAgentService接口。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface AgifAgentService extends BaseService {

    @Transactional
    void updateAgifAgentInfo(BaseBean<AccountParam,AccountParam> param);

    @Transactional
    String addAgifAgentInfo(AccountParam param);

}