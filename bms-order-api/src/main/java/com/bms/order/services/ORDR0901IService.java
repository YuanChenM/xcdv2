package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;
import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0901IBean;

/**
 * 买手退货单创建接口Service
 *
 * @author li_huiqian
 */
public interface ORDR0901IService {
    /**
     * 接收买手退货信息，创建买手退货订单
     *
     * @param operator 操作者
     * @param bean     ORDR0901IBean
     */
    @Transactional
    public Long execute(Operator operator, ORDR0901IBean bean,String returnType);
}
