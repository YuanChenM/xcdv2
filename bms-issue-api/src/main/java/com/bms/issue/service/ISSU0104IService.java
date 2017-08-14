package com.bms.issue.service;

import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0104IBean;

/**
 * 问题订单修改接口Service
 *
 * @author li_huiqian
 */
public interface ISSU0104IService extends BaseService{
    /**
     * 接收问题订单基本信息、问题信息，修改问题订单
     *
     * @param operator 操作者
     * @param bean     ISSU0104IBean
     */
    @Transactional
    void execute(Operator operator, ISSU0104IBean bean);
}
