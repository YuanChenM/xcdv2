package com.batch.order.constant;

import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;

/**
 * URL常量类
 * 
 * @author li_huiqian
 *
 */
public class UrlConst {

    /**
     * 买家基础信息URL
     */
    public static final String API_BYIM_URL = /*"http://10.30.10.51:8091/bms-byim-api/api";*/ConfigServerUtils.getAPIUrl("oms-byim-api","api");
    /**
     * 卖家基础信息URL
     */
    public static final String API_SLPD_URL = /*"http://10.30.10.51:8091/bms-slpd-api/api";*/ConfigServerUtils.getAPIUrl("oms-slpd","api");
    /**
     * 价盘URL
     */
    public static final String API_PRCE_URL = /*"http://10.30.10.51:8091/bms-prce-api/api";*/ConfigServerUtils.getAPIUrl("oms-prce","api");
    /**
     * 库存URL
     */
    public static final String API_LINV_URL = /*"http://10.30.10.51:8091/bms-linv-api/api";*/ConfigServerUtils.getAPIUrl("oms-linv","api");
    /**
     * 卖家产品
     */
    public static final String API_SLIM_URL = /*"http://10.30.10.51:8091/bms-linv-api/api";*/ConfigServerUtils.getAPIUrl("oms-slim","api");
    /**
     * 买手URL
     */
    public static final String API_AGIF_URL = ConfigServerUtils.getAPIUrl("oms-agif","api");


    /**
     * 买家基本信息检索接口
     */
    public static final String ACTION_BYIM0107I = "/buyers/basic/_search";

    /**
     * 买家配送地址信息查询接口
     */
    public static final String ACTION_BYIM0113I = "/buyers/delivery/_search";


    /**
     * 批量查询商品清单
     */
    public static final String ACTION_SLPD0805I = "/commodities/_find";
    /**
     * 价盘比较查询
     */
    public static final String ACTION_PRCE0211I = "/prce/pricePlate/_compare";
    /**
     * 平台商品总库存查询
     */
    public static final String ACTION_LINV0012I = "/linv/_queryCommInv";
    /**
     * 平台商品占用
     */
    public static final String ACTION_LINV0006I = "/linv/_allocateCommInv";
    /**
     * 生产商库存查询
     */
    public static final String ACTION_LINV0013I = "/linv/_queryPdrsInv";

    /**
     * 货主商品库存查询
     */
    public static final String ACTION_LINV0016I = "/linv/_queryOwCommInv";
    /**
     * 普通库存占用
     */
    public static final String ACTION_LINV0007I = "/linv/_allocateInv";

    /**
     * 批量查询卖方单位
     */
    public static final String ACTION_SLIM0250I = "/sellers/entity/_find";

    /**
     * 批量查询卖家
     */
    public static final String ACTION_SLIM0102I = "/sellers/_find";
    /**
     * 买家买手上级角色查询
     */
    public static final String ACTION_AGIF0212I = "/agent/relation/_search";

    /**
     * 产品库存查询
     */
    public static final String ACTION_LINV0110I = "/linv/loadInv/_search";

    /**
     * 产品库存占用
     */
    public static final String ACTION_LINV0103I = "/linv/loadInv/_allocate";

}
