/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.PartnerRsParam;
import com.framework.base.rest.param.BaseRestPaginationParam;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * <p>AgifPartnerService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface AgifPartnerService extends BaseService {
    /**
     * @deprecated
     */
    @Deprecated
    @Transactional(readOnly = true)
    <O extends Serializable, T extends BaseRestPaginationParam> BaseRestPaginationResult<O> findAgentPageList(T var1);

    @Transactional
    String insertPartnerAndAddress(PartnerRsParam partnerRsParam);

    @Transactional
    int updateAgifPartner(BaseBean<PartnerRsParam, PartnerRsParam> baseBean);
}