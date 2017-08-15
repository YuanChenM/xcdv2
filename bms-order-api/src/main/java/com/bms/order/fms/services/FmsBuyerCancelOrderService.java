package com.bms.order.fms.services;

import com.bms.order.fms.bean.FmsBuyerCancelOrderBean;
import com.bms.order.fms.bean.FmsOrderParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yuan_chen on 2017/4/22 0012.
 *
 * 买家取消订单Service
 */
public interface FmsBuyerCancelOrderService extends BaseService {
    @Transactional
    List<FmsBuyerCancelOrderBean> getBuyerCancelOrder(FmsOrderParam param);
}
