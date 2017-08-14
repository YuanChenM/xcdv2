package com.bms.issue.service;

import org.springframework.transaction.annotation.Transactional;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0103IBean;

/**
 * 问题订单结案提交接口Service
 *
 * @author li_huiqian
 */
public interface ISSU0103IService {
    /**
     * 接收问题订单结案信息，问题订单结案
     *
     * @param operator 操作者
     * @param bean     ISSU0103IBean
     */
    @Transactional
    public void execute(Operator operator, ISSU0103IBean bean);
}
