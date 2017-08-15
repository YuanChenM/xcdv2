package com.bms.order.fms.services;

import com.bms.order.fms.bean.FmsBuyerOrderStock;
import com.bms.order.fms.bean.FmsBuyerReturnOrderStock;
import com.bms.order.fms.bean.OmsOrderOrigin;
import com.framework.boot.base.BaseService;

import java.util.List;

/**
 * Created by yuan_chen on 2017/5/6
 *
 * OMS买家订单溯源services
 */
public interface OmsOrderOriginService extends BaseService {
    List<FmsBuyerOrderStock> getFmsBuyerOrderStocks(OmsOrderOrigin param);
    List<FmsBuyerReturnOrderStock> getFmsBuyerReturnOrderStocks(OmsOrderOrigin param);
    OmsOrderOrigin setOrderSellerDetail(OmsOrderOrigin omsOrderOrigin);
}
