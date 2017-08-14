package com.bms.issue.service;

import org.springframework.transaction.annotation.Transactional;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0102IBean;

/**
 * 问题订单发起提交接口Service
 *
 * @author li_huiqian
 */
public interface ISSU0102IService {
    /**
     * 接收问题订单基本信息、问题信息，提交发起问题订单
     *
     * @param operator 操作者
     * @param bean     ISSU0102IBean
     */
    @Transactional
    void execute(Operator operator, ISSU0102IBean bean);
}
