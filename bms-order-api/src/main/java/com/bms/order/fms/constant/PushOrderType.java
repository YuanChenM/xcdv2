package com.bms.order.fms.constant;

/**
 * Created by yuan_chen on 2017/4/19 0019.
 *
 * oms到fms的push订单类型
 */
public interface PushOrderType {

    //买家订单
    String BUYER_ORDER = "buyerorder";
    //买家订单取消
    String BUYER_ORDER_CANCEL = "buyerorder_cancel";
    //买家订单退货
    String BUYER_ORDER_RETURN = "buyerorder_return";
    //买手合伙人囤货订单
    String BUYER_AGENT_ORDER = "buyeragentorder";
    //买手合伙人囤货订单退货
    String BUYER_AGENT_ORDER_RETURN = "buyeragentorder_return";
    //买手合伙人竞价囤货订单
    String BUYER_AGENT_ORDER_BID = "buyeragentorder_bid";
    //沽货订单
    String SHORT_SELL_ORDER = "stockorder";
}
