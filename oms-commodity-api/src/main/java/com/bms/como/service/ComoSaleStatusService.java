/*
 * 2017/03/27 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.como.service;

import com.bms.como.bean.param.BaseBean;
import com.bms.como.bean.param.SaleStatusRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>ComoSaleStatusService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ComoSaleStatusService extends BaseService {
    @Transactional(readOnly = true)
    int checkCode(SaleStatusRsParam saleStatusRsParam);

    @Transactional(readOnly = true)
    int checkName(SaleStatusRsParam saleStatusRsParam);

    @Transactional
    SaleStatusRsParam saveSaleStatus(SaleStatusRsParam saleStatusRsParam);

    @Transactional
    int modifySaleStatus(BaseBean<SaleStatusRsParam, SaleStatusRsParam> saleStatusRsParam);
}