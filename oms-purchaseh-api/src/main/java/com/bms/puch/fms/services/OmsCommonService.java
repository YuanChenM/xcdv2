package com.bms.puch.fms.services;

import com.bms.puch.fms.bean.OmsAgent;
import com.bms.puch.fms.bean.OmsPartner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yuan_zhifei on 2017/5/4
 * <p>
 * oms内部系统间接口调用共通services
 */
public interface OmsCommonService {
    @Transactional
    OmsAgent getAgent(OmsAgent param);

    @Transactional
    OmsPartner getPartner(OmsPartner omsPartner);
}
