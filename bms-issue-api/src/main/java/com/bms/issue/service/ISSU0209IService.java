package com.bms.issue.service;

import org.springframework.transaction.annotation.Transactional;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0209IBean;

/**
 * 问题处理/结案建议编辑接口Service
 *
 * @author li_huiqian
 */
public interface ISSU0209IService {
    /**
     * 问题处理/结案建议编辑接口
     *
     * @param operator 操作者
     * @param bean     ISSU0209IBean
     */
    @Transactional
    void execute(Operator operator, ISSU0209IBean bean);
}
