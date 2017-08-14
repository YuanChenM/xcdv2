package com.bms.issue.service;

import com.bms.issue.bean.entity.IssueEntity;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0101IBean;

/**
 * 问题订单创建接口Service
 *
 * @author li_huiqian
 */
public interface ISSU0101IService extends BaseService{
    /**
     * 接收问题订单基本信息、问题信息，创建问题订单
     *
     * @param operator 操作者
     * @param bean     ISSU0101IBean
     */
    @Transactional
    IssueEntity execute(Operator operator, ISSU0101IBean bean);
}
