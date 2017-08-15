package com.bms.order.fms.common;

import com.bms.order.fms.bean.FmsOrderParam;
import com.bms.order.fms.bean.FmsPushBean;
import com.bms.order.fms.constant.PushOrderType;
import org.springframework.stereotype.Service;

/**
 * Created by yuan_chen on 2017/5/17
 * <p>
 * push到fms共通类
 */
@Service
public class FmsCommon extends FmsCommonAbstract {

    /**
     * 根据不同订单类型进行推送
     * @param pushOrderType 订单类型
     * @param fmsOrderParam 推送参数
     * @return
     */
    public FmsPushBean pushOrderToFms(String pushOrderType, FmsOrderParam fmsOrderParam){
        return super.pushOrderToFms(pushOrderType, fmsOrderParam);
    }

    /**
     * 直接推送
     * @param xmlParam 推送字符串
     * @param fmsPushBean 推送内容
     * @return
     */
    public String doPush(String xmlParam, FmsPushBean fmsPushBean){
        return super.doPush(xmlParam, fmsPushBean);
    }

    /**
     * 推送买家分批订单
     * @param pushOrderId 订单ID
     * @param pushDistributionDetailIds 配送通知单明细ID
     */
    public void pushBuyerOrder(Long pushOrderId, Long[] pushDistributionDetailIds){
        FmsOrderParam fmsOrderParam = new FmsOrderParam();
        fmsOrderParam.setAsyncFlg("async");
        fmsOrderParam.setPushOrderId(pushOrderId);
        if(pushDistributionDetailIds != null && pushDistributionDetailIds.length>0){
            fmsOrderParam.setPushDistributionDetailIds(pushDistributionDetailIds);
        }
        FmsPushBean fmsPushBean = super.pushOrderToFms(PushOrderType.BUYER_ORDER, fmsOrderParam);
        writeLog(fmsPushBean);
    }

    /**
     * 推送买家退货订单
     * @param pushOrderId 推送买家退货订单的退货ID
     */
    public void pushBuyerReturnOrder(Long pushOrderId){
        FmsOrderParam fmsOrderParam = new FmsOrderParam();
        fmsOrderParam.setAsyncFlg("async");
        fmsOrderParam.setPushOrderId(pushOrderId);
        FmsPushBean fmsPushBean = super.pushOrderToFms(PushOrderType.BUYER_ORDER_RETURN, fmsOrderParam);
        writeLog(fmsPushBean);
    }

    /**
     * 推送买手囤货订单
     * @param pushOrderId 推送囤货订单ID
     */
    public void pushAgentOrder(Long pushOrderId){
        FmsOrderParam fmsOrderParam = new FmsOrderParam();
        fmsOrderParam.setAsyncFlg("async");
        fmsOrderParam.setPushOrderId(pushOrderId);
        FmsPushBean fmsPushBean = super.pushOrderToFms(PushOrderType.BUYER_AGENT_ORDER, fmsOrderParam);
        writeLog(fmsPushBean);
    }

    /**
     * 推送买手囤货退货订单
     * @param pushOrderId 推送囤货订单的退货ID
     */
    public void pushAgentReturnOrder(Long pushOrderId){
        FmsOrderParam fmsOrderParam = new FmsOrderParam();
        fmsOrderParam.setAsyncFlg("async");
        fmsOrderParam.setPushOrderId(pushOrderId);
        FmsPushBean fmsPushBean = super.pushOrderToFms(PushOrderType.BUYER_AGENT_ORDER_RETURN, fmsOrderParam);
        writeLog(fmsPushBean);
    }

    /**
     * 推送沽货订单
     * @param pushOrderId 推送订单ID
     */
    public void pushShortSellOrder(Long pushOrderId){
        FmsOrderParam fmsOrderParam = new FmsOrderParam();
        fmsOrderParam.setAsyncFlg("async");
        fmsOrderParam.setPushOrderId(pushOrderId);
        FmsPushBean fmsPushBean = super.pushOrderToFms(PushOrderType.SHORT_SELL_ORDER, fmsOrderParam);
        writeLog(fmsPushBean);
    }
}
