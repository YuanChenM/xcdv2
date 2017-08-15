package com.bms.order.services;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0805IBeanParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * 买家退货入库数据接收接口Service
 * 
 * @author ni_shaotang
 */
public interface ORDR0805IService {
    /**
     * 接收WMS系统退货入库信息，系统内仓库待处理库存增加
     * 
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0805IBeanParam
     */
    @Transactional
    public void execute(Operator operator, ORDR0805IBeanParam bean);
}
