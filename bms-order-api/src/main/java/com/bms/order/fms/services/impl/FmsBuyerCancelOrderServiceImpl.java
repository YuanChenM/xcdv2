package com.bms.order.fms.services.impl;

import com.bms.order.fms.bean.FmsBuyerCancelOrderBean;
import com.bms.order.fms.bean.FmsBuyerCancelOrderDetail;
import com.bms.order.fms.bean.FmsOrderParam;
import com.bms.order.fms.dao.FmsBuyerCancelOrderDao;
import com.bms.order.fms.services.FmsBuyerCancelOrderService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/22 0012.
 *
 * 买家取消订单ServiceImpl
 */
@Service
public class FmsBuyerCancelOrderServiceImpl extends BaseServiceImpl implements FmsBuyerCancelOrderService {

    @Autowired
    private FmsBuyerCancelOrderDao fmsBuyerCancelOrderDao;

    @Override
    public BaseDao getBaseDao() {
        return fmsBuyerCancelOrderDao;
    }

    @Override
    public List<FmsBuyerCancelOrderBean> getBuyerCancelOrder(FmsOrderParam param){
        List<FmsBuyerCancelOrderBean> fmsBuyerOrderBeans = fmsBuyerCancelOrderDao.findBuyerCancelOrder(param);
        for (FmsBuyerCancelOrderBean buyerOrder: fmsBuyerOrderBeans) {
            if(buyerOrder != null){
                setBuyerCancelOrderDetail(buyerOrder);
                setConstantAndMasterData(buyerOrder);
            }
        }
        return fmsBuyerOrderBeans;
    }

    /**
     * 设置买家取消订单的常量和基础数据
     */
    private void setConstantAndMasterData(FmsBuyerCancelOrderBean buyerOrder){
        //FMS MasterData
        //buyerOrder.setOrderType("A1类囤货订单");
        buyerOrder.setOmsStatus("已输入");
    }

    private void setBuyerCancelOrderDetail(FmsBuyerCancelOrderBean buyerOrder){
        if (buyerOrder.getOmsOrderId() != null){
            List<FmsBuyerCancelOrderDetail> details = fmsBuyerCancelOrderDao.findBuyerCancelOrderDetail(buyerOrder);
            if(!CollectionUtils.isEmpty(details)){
                buyerOrder.setLine(details);
                return;
            }
        }
        buyerOrder.setLine(new ArrayList<FmsBuyerCancelOrderDetail>());
    }
}

