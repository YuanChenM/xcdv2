package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0607IFilterParam;

/**
 * 买手订单查询接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0607IService {
    /**
     * 买手/冻品管家/平台订单人员查询自己权限可以访问的买手订单
     * 
     * @param operator
     *            操作者
     * @param param
     *            ORDR0605IRestParam
     */
    @Transactional
    public void execute(Operator operator, ORDR0607IFilterParam bean);
}
