package com.bms.order.services;

import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0201IBeanParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单分拆单创建接口Service
 *
 * @author li_huiqian
 */
public interface ORDR0201IService {
    /**
     * 订单系统/平台订单人员对已确认的订单的分批订单进行分拆
     *
     * @param operator 操作者
     * @param bean     ORDR0201IBeanParam
     */
    @Transactional
    public List<Long> execute(Operator operator, ORDR0201IBeanParam bean);
}
