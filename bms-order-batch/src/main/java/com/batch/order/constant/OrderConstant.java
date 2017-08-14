package com.batch.order.constant;

/**
 * 订单基本codemaster常量类
 *
 * @author liu_tao2
 * @version 1.0
 */
public interface OrderConstant {
    /**
     * 买家订单类型
     */
    interface BuyerOrderType {
        /**
         * 买家A类标准订单
         */
        String BUYER_A_STANDARD_ORDER = "001";

        /**
         * 买家B类标准订单
         */
        String BUYER_B_STANDARD_ORDER = "002";

        /**
         * 买家A类分批订单
         */
        String BUYER_A_BATCH_ORDER = "003";

        /**
         * 买家B类分批订单
         */
        String BUYER_B_BATCH_ORDER = "004";
    }

    /**
     * 销售平台
     */
    interface SalePlatformType {
        /**
         * 云冻品平台
         */
        String YDP = "001";
    }

    /**
     * 订单来源
     */
    interface OrderSourceType {
        /**
         * 云冻品
         */
        String YDP = "001";

        /**
         * 微商城
         */
        String WSC = "002";

        /**
         * 新微商城
         */
        String NEW_WSC = "003";

        /**
         * 买手APP
         */
        String BS_APP = "004";

        /**
         * 买家APP
         */
        String BUYER_APP = "005";
    }

    /**
     * 下单员类型
     */
    interface OrderPlacerType {
        /**
         * 买家
         */
        String BUYER = "001";

        /**
         * 卖家
         */
        String SELLER = "002";

        /**
         * 买手
         */
        String BS = "003";

        /**
         * 冻品管家
         */
        String SA = "004";

        /**
         * 平台管理人员
         */
        String MANAGER = "005";
    }

    /**
     * 下单类型
     */
    interface OrderPlaceType {
        /**
         * A类
         */
        String A_TYPE = "001";

        /**
         * B类
         */
        String B_TYPE = "002";
    }

    /**
     * 专属买手类型
     */
    interface BsType {
        /**
         * 区域买手
         */
        String REGIONAL_BS = "001";

        /**
         * 非区域买手
         */
        String NON_REGIONAL_BS = "002";

        /**
         * 区域分销买手
         */
        String REGIONAL_DISTRIBUTION_BS = "003";

        /**
         * 账期用户买手
         */
        String NET_USER_BS = "004";
    }

    /**
     * 付款类型
     */
    interface PaymentType {
        /**
         * 线上支付
         */
        String PAYING_ONLINE = "001";

        /**
         * 线下付款
         */
        String CASH_ON_DELIVERY = "002";
    }

    /**
     * 预配送类型
     */
    interface ForcastType {
        /**
         * 正常分拆预配送
         */
        String STANDARD_SPLIT_DISTRIBUTION = "001";

        /**
         * 迟收再配送
         */
        String LATE_DISTRIBUTION = "002";
    }
    /**
     * 配送方式
     */
    interface DistributionType {
        /**
         * 陆运
         */
        String LAND_TRANSPORTATION = "001";

        /**
         * 海运
         */
        String OCEAN_SHIPPING = "002";
        /**
         * 空运
         */
        String AIR_TRANSPORT = "003";
    }

    /**
     * 配送通知单取消类型
     */
    interface DistributionCacelType {
        /**
         * 订单取消
         */
        String ORDER_CANCEL = "001";

        /**
         * 配送通知单取消
         */
        String DISTRIBUTION_CANCEL = "002";
    }

    /**
     * 买手订单类型
     */
    interface BsOrderType {
        /**
         * 买手A类囤货订单
         */
        String BS_A_STOCKPILING_ORDER = "001";

        /**
         * 买手B类囤货订单
         */
        String BS_B_STOCKPILING_ORDER = "002";
    }

    interface OperatorType {

        /**
         * 买家
         */
        String BUYER = "001";

        /**
         * 卖家
         */
        String SELLER = "002";

        /**
         * 买手
         */
        String BS = "003";

        /**
         * 冻品管家
         */
        String SA = "004";

        /**
         * 平台管理人员
         */
        String MANAGER = "005";

        /**
         * 订单系统
         */
        String ORDER_SYSTEM = "011";

        /**
         * 美迪福系统
         */
        String MADE_4_NET = "012";

        /**
         * 资金池系统
         */
        String CASH_POOL = "013";
    }

    /**
     * 供货主体类型
     */
    interface SellSideType {
        /**
         * 平台
         */
        String PLATFORM_TYPE = "001";
        /**
         * 买手
         */
        String SELL_TYPE = "002";
    }



    interface  PlatformInfo{
        String  PLATFORM_ID="0000000";

        String PLATFORM_CODE="0000000";

        String  PLATFORM_NAME="鲜驰达平台";

    }

    /**
     * 商品单位
     */
    interface GoodsUint{
        /**
         * 箱
         */
        String PACKAGE = "001";
        /**
         * 千克
         */
        String KG = "002";
    }

    /**
     * 买家订单取消类型
     */
    interface BuyerOrderCancelType{

        /**
         * 整单取消
         */
        String ALL_CANCEL = "001";

        /**
         * 部分取消
         */
        String PART_CANCEL = "002";
    }

    /**
     * 买手订单取消类型
     */
    interface BsOrderCancelType{

        /**
         * 整单取消
         */
        String ALL_CANCEL = "001";

        /**
         * 部分取消
         */
        String PART_CANCEL = "002";
    }

    /**
     * 取消对象类型
     */
    interface CancelModeType{

        /**
         * 买家订单取消
         */
        String BUYER_ORDER_CANCEL = "001";

        /**
         * 买手订单取消
         */
        String BS_ORDER_CANCEL = "002";

    }

    /**
     * 订单分类
     */
    interface OrderType{
        /**
         * 买家订单
         */
        String BUYER_ORDER = "001";

        /**
         * 买手订单
         */
        String BS_ORDER = "002";
    }

    /**
     * emailAddress
     */
    interface EmailAddress{
        /**
         * emailAddress
         */
        String EMAIL_ADDRESS = "qiu_wenting@hoperun.com,wang_wei4@hoperun.com,ying_wangui@hoperun.com,shen_cb@hoperun.com";
    }
}
