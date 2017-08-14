package com.bms.issue.service;

import org.springframework.transaction.annotation.Transactional;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0201IBean;

/**
 * 问题订单问题新增接口Service
 *
 * @author li_huiqian
 */
public interface ISSU0201IService {
    /**
     * 接收问题信息，创建问题
     *
     * @param operator 操作者
     * @param bean     ISSU0201IBean
     */
    @Transactional
    public Long execute(Operator operator, ISSU0201IBean bean);
}
