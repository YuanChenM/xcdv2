package com.bms.linv.constant;

/**
 * Created by duan_kai on 2016/12/26.
 */
public class LinvTypeCodeMaster {
    /**
     * 业务标识码前缀
     */
    public static class NUMBER_GENERATE{
        public static String LOAD ="LI";//产品库存身份前缀
        public static String COMMODITY = "CI";//商品库存身份前缀
        public static String PRODUCT_ALLOCATION = "LA";//产品占用身份前缀
        public static String COMM_ALLOCATION = "CA";//商品占用身份前缀
        public static String LOAD_ADJUSTMENT = "LD";// 产品库存调整身份前缀
        public static String COMM_ADJUSTMENT = "AD";// 商品库存调整身份前缀
    }

    /**
     * 名称信息表中的名称code
     */
    public static class NAME_INFO{
        public static String OWNER = "003";//货权人
        public static String LOGICAREA = "001";//物流区
        public static String SUPPLIER = "002";//供应商
    }

    /**
     * 名称信息表中的名称code
     */
    public static class OWNER_TYPE{
        public static String SELLER = "001";//平台卖家
        public static String AGENT = "002";//买手
        public static String BUYER = "004";//买家
    }

    /**
     * 商品库存类型
     */
    public static class COMO_INENTORY_TYPE {
        public static String Actual = "001";// 实物
        public static String Virtual = "002";// 货权
    }

    /**
     * 商品库存调整
     */
    public static class COMO_ADJUSTMENT {
        public static String ComoInvAdjust = "015";
    }
}
