package com.bms.order.constant;

/**
 * 订单常量
 * 
 * @author li_huiqian
 *
 */
public class OrderConst {

     /*-------------------------------------------------------------------------------------------------------------------*/
    /* 订单用全局常量 */

    /** 销售方：平台销售方ID */
    public static final String PLATFORM_ID = "0000000";

    /** 销售方：平台销售方编码 */
    public static final String PLATFORM_CODE = "0000000";

    /** 销售方：平台销售方 名称 */
    public static final String PLATFORM_NAME = "鲜驰达平台";

    /*-------------------------------------------------------------------------------------------------------------------*/
    /* MAX_LENGTH */

    /** 订单：参考号最大长度 */
    public static final int MAX_LENGTH_BACK_NO = 32;

    /** 操作人ID最大长度 */
    public static final int MAX_LENGTH_OPERATOR_ID = 64;

    /** 买家ID最大长度 */
    public static final int MAX_LENGTH_BUYER_ID = 36;

    /** 买家类型编码最大长度 */
    public static final int MAX_LENGTH_BUYER_TYPE = 4;

    /** 买家类型名称最大长度 */
    public static final int MAX_LENGTH_BUYER_TYPE_NAME = 16;

    /** 微信号最大长度 */
    public static final int MAX_LENGTH_WECHAT = 16;

    /** QQ号最大长度 */
    public static final int MAX_LENGTH_QQ = 16;

    /** 收货人名称最大长度 */
    public static final int MAX_LENGTH_RECEIVER_NAME = 32;

    /** 省名最大长度 */
    public static final int MAX_LENGTH_PROVINCE = 8;

    /** 市名最大长度 */
    public static final int MAX_LENGTH_CITY = 8;

    /** 区县名最大长度 */
    public static final int MAX_LENGTH_DISTRICT = 8;

    /** 详细地址最大长度 */
    public static final int MAX_LENGTH_ADDRESS = 512;

    /** 辅助地址最大长度 */
    public static final int MAX_LENGTH_ASSIST_ADDRESS = 512;

    /** 订单配送区域 */
    public static final int MAX_LENGTH_DELIVERY_AREA = 16;

    /** 通行区域说明 */
    public static final int MAX_LENGTH_PASS_TRAFFIC_MODEL = 16;

    /** 收货时间段最大长度 */
    public static final int MAX_LENGTH_RECEIVE_PERIOD = 32;

    /** 最早时间要求最大长度 */
    public static final int MAX_LENGTH_RECEIVE_EARLIEST = 32;

    /** 最晚时间要求最大长度 */
    public static final int MAX_LENGTH_RECEIVE_LATEST = 32;

    /** 收货等待时间最大长度 */
    public static final int MAX_LENGTH_RECEIVE_WAIT_HOUR = 8;

    /** 提前通知时间最大长度 */
    public static final int MAX_LENGTH_ADVANCE_NOTIFICATION_HOUR = 8;

    /** 装卸要求最大长度 */
    public static final int MAX_LENGTH_STEVEDORE_REQUIREMENT = 256;

    /** 包装要求最大长度 */
    public static final int MAX_LENGTH_PACKAGE_REQUIREMENT = 256;

    /** 备注最大长度 */
    public static final int MAX_LENGTH_REMARK = 256;

    /** 批次最大长度 */
    public static final int MAX_LENGTH_BATCH = 10;

    /** 商品Id最大长度 */
    public static final int MAX_LENGTH_GOODS_ID = 32;

    /** 产品Id最大长度 */
    public static final int MAX_LENGTH_PRODUCT_ID = 32;

    /** 下单员Id最大长度 */
    public static final int MAX_LENGTH_ORDER_PLACER_ID = 64;

    /** 买手Id最大长度 */
    public static final int MAX_LENGTH_BS_ID = 36;

    /** 买手编码最大长度 */
    public static final int MAX_LENGTH_BS_CODE = 16;

    /** 买手名称最大长度 */
    public static final int MAX_LENGTH_BS_NAME = 32;

    /** 买家订单编码长度 */
    public static final int MAX_LENGTH_BUYER_ORDER_CODE = 64;

    /** 下单员编码长度 */
    public static final int MAX_LENGTH_ORDER_PLACER_CODE = 16;

    /** 下单员名称 */
    public static final int MAX_LENGTH_ORDER_PLACER_NAME = 32;

    /** 物流区编码最大长度 */
    public static final int MAX_LENGTH_LOGISTICS_ZONE_CODE = 2;

    /** 物流区名称最大长度 */
    public static final int MAX_LENGTH_LOGISTICS_ZONE_NAME = 8;

    /** 分批订单编码最大长度 */
    public static final int MAX_LENGTH_BUYER_BATCH_ORDER_CODE = 64;

    /** 买家编码最大长度 */
    public static final int MAX_LENGTH_BUYER_CODE = 32;

    /** 买家名称最大长度 */
    public static final int MAX_LENGTH_BUYER_NAME = 32;

    /** 管家名称最大长度 */
    public static final int MAX_LENGTH_SA_NAME = 16;

    /** 管家编码最大长度 */
    public static final int MAX_LENGTH_SA_CODE = 32;

    /** 销售方ID最大长度 */
    public static final int MAX_LENGTH_SELL_SIDE_ID = 32;

    /** 销售方编码最大长度 */
    public static final int MAX_LENGTH_SELL_SIDE_CODE = 16;

    /** 销售方名称最大长度 */
    public static final int MAX_LENGTH_SELL_SIDE_NAME = 32;

    /** 生产商编码最大长度 */
    public static final int MAX_LENGTH_MANUFACTURER_CODE = 16;

    /** 生产商名称最大长度 */
    public static final int MAX_LENGTH_MANUFACTURER_NAME = 256;

    /** 卖家编码最大长度 */
    public static final int MAX_LENGTH_SELLER_CODE = 16;

    /** 卖家名称最大长度 */
    public static final int MAX_LENGTH_SELLER_NAME = 32;

    /** 区域配送站编码最大长度 */
    public static final int MAX_LENGTH_REGIONAL_DISTRIBUTION_STATION_CODE = 16;

    /** 区域配送站名称最大长度 */
    public static final int MAX_LENGTH_REGIONAL_DISTRIBUTION_STATION_NAME = 32;

    /** 配送通知单号最大长度 */
    public static final int MAX_LENGTH_DISTRIBUTION_NOTIFICATION_CODE = 64;

    /** 买手订单编码 */
    public static final int MAX_LENGTH_BS_ORDER_CODE = 64;

    /** 销售标签编码最大长度 */
    public static final int MAX_LENGTH_SALE_LABEL_CODE = 16;

    /** 销售标签名称最大长度 */
    public static final int MAX_LENGTH_SALE_LABEL_NAME = 32;

    /** SKU最大长度 */
    public static final int MAX_LENGTH_SKU = 32;

    /** 取消类型 */
    public static final int MAX_LENGTH_CANCEL_TYPE = 3;

    /** 取消人类型 */
    public static final int MAX_LENGTH_CANCEL_PERSON_TYPE = 3;

    /** 取消人编码 */
    public static final int MAX_LENGTH_CANCEL_PERSON_CODE = 32;

    /** 取消人名称 */
    public static final int MAX_LENGTH_CANCEL_PERSON_NAME = 32;

    /** 取消原因 */
    public static final int MAX_LENGTH_CANCEL_REASON = 256;

    /*-------------------------------------------------------------------------------------------------------------------*/
    /* MAX_VALUE MIN_VALUE */
    /** 页码最大值 */
    public static final int MAX_VALUE_START_POS = Integer.MAX_VALUE;
    /** 页码最小值 */
    public static final int MIN_VALUE_START_POS = 1;

    /** Bigint类型ID最大值 */
    public static final long MAX_VALUE_BIGINT_ID = Long.MAX_VALUE;

    /** Bigint类型ID最小值 */
    public static final long MIN_VALUE_BIGINT_ID = 1L;

    /** Version最大值 */
    public static final int MAX_VALUE_VERSION = Integer.MAX_VALUE;

    /** Version最小值 */
    public static final int MIN_VALUE_VERSION = 1;

    /** 距离门店最近停车距离最大值 */
    public static final int MAX_VALUE_NEAREST_PARKING_DISTANCE = Integer.MAX_VALUE;

    /** 距离门店最近停车距离最小值 */
    public static final int MIN_VALUE_NEAREST_PARKING_DISTANCE = 0;

    /** 分页单页最大查询条数，默认是10 */
    public static final int MAX_VALUE_PAGE_SIZE = Integer.MAX_VALUE;

    /** 分页单页最小查询条数，默认是1 */
    public static final int MIN_VALUE_PAGE_SIZE = 1;

    /** 买手订单列表查询分页层级最大值，4 */
    public static final int MAX_VALUE_ORDR0105I_PAGING_LEVEL = 5;

    /** 分页单页最小查询条数，默认是1 */
    public static final int MIN_VALUE_ORDR0105I_PAGING_LEVEL = 1;

    /** 配送通知单列表查询分页层级最大值，2 */
    public static final int MAX_VALUE_ORDR0303I_PAGING_LEVEL = 2;

    /** 配送通知单最小查询条数，默认是1 */
    public static final int MIN_VALUE_ORDR0303I_PAGING_LEVEL = 1;

    /** 买手订单列表查询分页层级最大值，3 */
    public static final int MAX_VALUE_ORDR0605I_PAGING_LEVEL = 3;

    /** 买手订单最小查询条数，默认是1 */
    public static final int MIN_VALUE_ORDR0605I_PAGING_LEVEL = 1;

    /*-------------------------------------------------------------------------------------------------------------------*/
    /* MAX_M MIN_M */

    /** 金额数字部分最大长度（MaxM） */
    public static final int MAX_M_AMOUNT = 15;

    /** 金额小数部分最大长度（MaxD） */
    public static final int MAX_D_AMOUNT = 2;

    /** 商品数量数字部分最大长度（MaxM） */
    public static final int MAX_M_GOODS_QUANTITY = 10;

    /** 商品数量数字部分最大长度（MaxD） */
    public static final int MAX_D_GOODS_QUANTITY = 0;

    /** 百分比数字部分最大长度（MaxM） */
    public static final int MAX_M_PERCENT = 5;

    /** 百分比小数部分最大长度（MaxD） */
    public static final int MAX_D_PERCENT = 2;

}
