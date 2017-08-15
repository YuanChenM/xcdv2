package com.bms.order.services;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0304IBeanParam;
import com.bms.order.bean.param.ORDR0602IBeanParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 配送通知单取消回传接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0304IService{
    /**
     * 配送通知单取消取消通知WMS后收到的是否成功的回传信息
     * 
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0304IBeanParam
     */
    @Transactional
    public void execute(Operator operator, ORDR0304IBeanParam bean);
}
