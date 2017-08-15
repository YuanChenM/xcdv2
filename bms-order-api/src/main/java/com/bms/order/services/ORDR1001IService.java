package com.bms.order.services;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0104IBeanParam;
import com.bms.order.bean.param.ORDR1001IBeanParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * 行权接口Service
 * 
 * @author qiu_wenting
 */
public interface ORDR1001IService {
    /**
     * 买手货权库存行权，转换为实物库存，扣减相应数量的平台实物库存
     * 
     * @param operator
     *            操作者
     * @param bean
     *            ORDR1001IBeanParam
     */
    @Transactional
    public void  execute(Operator operator, ORDR1001IBeanParam bean);
}
