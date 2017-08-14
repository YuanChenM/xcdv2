/*
 * 2016/12/29 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services;

import com.bms.byim.bean.entity.ByimDeliveryAddr;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.DeliveryAddrRsParam;
import com.bms.byim.bean.result.DeliveryAddrRsResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>ByimDeliveryAddrService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ByimDeliveryAddrService extends BaseService {

    @Transactional
    DeliveryAddrRsResult addDeliveryAddr(ByimDeliveryAddr addrEntity);

    @Transactional
    int updateDeliveryAddr(BaseBean<DeliveryAddrRsParam, DeliveryAddrRsParam> param);

}