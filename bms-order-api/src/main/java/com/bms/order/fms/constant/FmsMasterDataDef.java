package com.bms.order.fms.constant;

/**
 * Created by yuan_chen on 2017/05/08
 *
 * fms接口用常量定义
 */
public interface FmsMasterDataDef {
    //退货原因
    interface RETURN_REASON{
        String DEFAULT = "平台原因";
    }
    //币种
    interface MONEY_UNIT{
        String CNY = "CNY";
    }

    //订单来源
    interface ORDER_SOUCE{
        String OMS = "OMS";
    }

    interface FMS_UNIT_TYPE{
        //包
        String U_BA = "BA";
        //箱
        String U_BOX = "BOX";
        //克
        String U_G = "G";
        //千克
        String U_KG = "KG";
        //吨
        String U_T = "T";
    }
    interface FMS_STATUS{
        //已输入
        String ORDER_ALREADY = "已输入";
        //已取消
        String ORDER_CANCEL = "已取消";
    }
    interface SHIP_SIDE_TYPE{
        //买手
        String AGENT = "买手";
        //合伙人
        String PARTNER = "合伙人";
        //平台
        String PLATFORM = "平台";
    }
    interface FMS_ORDER_TYPE{
        //A2类囤货订单
        String AGENT_BID_ORDER = "A2类囤货订单";
        //买家销售订单
        String BUYER_ORDER = "买家销售订单";
        //买家销售订单退货
        String BUYER_RETURN_ORDER = "买家销售订单退货";
        //B类囤货订单
        String AGENT_ORDER = "B类囤货订单";
        //B类囤货订单退货
        String AGENT_RETURN_ORDER = "B类囤货订单退货";
        //沽货订单
        String SELL_SHORT_ORDER = "沽货订单";
    }
}
