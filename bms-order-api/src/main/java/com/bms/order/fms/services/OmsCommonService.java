package com.bms.order.fms.services;

import com.bms.order.fms.bean.*;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 *
 * oms内部系统间接口调用共通services
 */
public interface OmsCommonService {
    OmsBuyer getBuyer(OmsBuyer param);
    OmsAgent getAgent(OmsAgent param);
    OmsAgentDistribution getAgentDistribution(OmsAgentDistribution param);
    OmsProductInventoryBean getOrderStock(OmsProductInventoryParam param);
    OmsManufacturerProduct getManufacturer(OmsManufacturerSkuParam param);
}
