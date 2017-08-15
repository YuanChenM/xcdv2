package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;
import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0801IBean;

/**
 * 买家退货单创建接口Service
 *
 * @author li_huiqian
 */
public interface ORDR0801IService {
    /**
     * 接收买家平台退货信息，创建退货订单
     *
     * @param operator 操作者
     * @param bean     ORDR0801IBean
     */
    @Transactional
    public Long execute(Operator operator, ORDR0801IBean bean);
}
