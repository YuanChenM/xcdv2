package com.bms.order.fms.services;

import com.bms.order.fms.bean.FmsBuyerOrderBean;
import com.bms.order.fms.bean.FmsOrderParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 *
 * 买家订单Service
 */
public interface FmsBuyerOrderService extends BaseService {
    @Transactional
    List<FmsBuyerOrderBean> getBuyerOrder(FmsOrderParam param);
}
