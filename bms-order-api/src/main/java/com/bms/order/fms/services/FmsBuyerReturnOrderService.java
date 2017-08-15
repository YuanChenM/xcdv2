package com.bms.order.fms.services;

import com.bms.order.fms.bean.FmsBuyerReturnOrderBean;
import com.bms.order.fms.bean.FmsOrderParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yuan_chen on 2017/4/22 0012.
 *
 * 买家退货订单Service
 */
public interface FmsBuyerReturnOrderService extends BaseService {
    @Transactional
    List<FmsBuyerReturnOrderBean> getBuyerReturnOrder(FmsOrderParam param);
}
