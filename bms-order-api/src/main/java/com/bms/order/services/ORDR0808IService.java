package com.bms.order.services;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0808IBean;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/3/6.
 */
public interface ORDR0808IService {

    @Transactional
    public void execute(Operator operator, ORDR0808IBean bean);
}

