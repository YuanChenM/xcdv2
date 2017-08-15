package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;
import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0802IBean;

/**
 * 买家退货单确认接口Service
 *
 * @author li_huiqian
 */
public interface ORDR0802IService {
    /**
     * 接收买家平台退货的确认信息，更改退货单状态
     *
     * @param operator 操作者
     * @param bean     ORDR0802IBean
     */
    @Transactional
    public void execute(Operator operator, ORDR0802IBean bean);
}
