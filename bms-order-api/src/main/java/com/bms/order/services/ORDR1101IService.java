package com.bms.order.services;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR1101IBeanParam;
import com.framework.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by guan_zhongheng on 2017/4/26.
 */
public interface ORDR1101IService {

    @Transactional
    Long execute(ORDR1101IBeanParam beanParam, Operator operator) throws BusinessException;
}
