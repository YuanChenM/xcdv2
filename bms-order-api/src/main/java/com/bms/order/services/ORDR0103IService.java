package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0103IBeanParam;

/**
 * 买家订单取消接口Service
 *
 * @author li_huiqian
 */
public interface ORDR0103IService {
    /**
     * 收货之前都允许买家订单整单取消，但可能会取消失败，需要后续拒收或者退货
     *
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0103IBeanParam
     */

    @Transactional
    public void execute(Operator operator, ORDR0103IBeanParam bean);
}
