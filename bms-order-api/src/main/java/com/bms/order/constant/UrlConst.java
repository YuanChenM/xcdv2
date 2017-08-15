package com.bms.order.constant;

import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;
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
    public static final String API_BYIM_NAME = ConfigServerPropertyLoad.getModelName("byim-api");
    public static final String API_BYIM_URL = /*"http://10.30.10.51:8091/bms-byim-api/api";*/ConfigServerUtils.getAPIUrl(API_BYIM_NAME,"api");
    /**
     * 卖家产品基础信息URL
     */
    public static final String API_SLPD_NAME = ConfigServerPropertyLoad.getModelName("slpd-api");
    public static final String API_SLPD_URL = /*"http://10.30.10.51:8091/bms-slpd-api/api";*/ConfigServerUtils.getAPIUrl(API_SLPD_NAME,"api");

    /**
     * 卖家产品基础信息URL
     */
    public static final String API_COMO_NAME = ConfigServerPropertyLoad.getModelName("como-api");
    public static final String API_COMO_URL = /*"http://10.30.10.51:8091/oms-como/api";*/ConfigServerUtils.getAPIUrl(API_COMO_NAME,"api");
    /**
     * 卖家基础信息URL
     */
    public static final String API_SLIM_NAME = ConfigServerPropertyLoad.getModelName("slim-api");
    public static final String API_SLIM_URL = /*"http://10.30.10.51:8091/bms-slpd-api/api";*/ConfigServerUtils.getAPIUrl(API_SLIM_NAME,"api");
    /**
     * 价盘URL
     */
    public static final String API_PRCE_NAME = ConfigServerPropertyLoad.getModelName("prce-api");
    public static final String API_PRCE_URL = /*"http://10.30.10.51:8091/bms-prce-api/api";*/ConfigServerUtils.getAPIUrl(API_PRCE_NAME,"api");
    /**
     * 库存URL
     */
    public static final String API_LINV_NAME = ConfigServerPropertyLoad.getModelName("linv-api");
    public static final String API_LINV_URL = /*"http://10.30.10.51:8091/bms-linv-api/api";*/ConfigServerUtils.getAPIUrl(API_LINV_NAME,"api");
    /**
     * 买手URL
     */
    public static final String API_AGIF_NAME = ConfigServerPropertyLoad.getModelName("agif-api");
    public static final String API_AGIF_URL = /*"http://10.30.10.51:8091/bms-agif-api/api";*/ConfigServerUtils.getAPIUrl(API_AGIF_NAME,"api");

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
     *   查询销售商品数据接口
     */
    public static final String ACTION_COMO307I = "/commodity/salelist/_search";

    /**
     *   商品信息查询接口
     */
    public static final String ACTION_COMO203I = "/commodity/info/_search";

    /**
     * 批量查询卖家
     */
    public static final String ACTION_SLIM0102I = "/sellers/_find";
    /**
     * 批量查询卖方单位
     */
    public static final String ACTION_SLIM0250I = "/sellers/entity/_find";
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
    public static final String ACTION_LINV0002I = "/linv/_dispatchLoad";

    /**
     * 平台商品占用
     */
    public static final String ACTION_LINV0006I = "/linv/_allocateCommInv";
    /**
     * 实货囤货
     */
    public static final String ACTION_LINV0009I = "/linv/store/_obtain";
    /**
     * 实货囤货释放
     */
    public static final String ACTION_LINV0010I = "/linv/store/_realease";
    /**
     * 生产商库存查询
     */
    public static final String ACTION_LINV0013I = "/linv/_queryPdrsInv";

    /**
     * 货主商品占用
     */
    public static final String ACTION_LINV0015I = "/linv/_allocateOwCommInv";
    /**
     * 货主商品库存查询
     */
    public static final String ACTION_LINV0016I = "/linv/_queryOwCommInv";
    /**
     * 普通库存占用
     */
    public static final String ACTION_LINV0007I = "/linv/_allocateInv";
    /**
     * 占用取消
     */
    public static final String ACTION_LINV0008I = "/linv/_releaseAllocation";
    /**
     * 买手信息查询
     */
    public static final String ACTION_AGIF0201I = "/agent/basic/_search";
    /**
     * 买手资格信息查询操作(包含买手、销售合伙人)
     */
    public static final String ACTION_AGIF0209I = "/agent/partner/qualification/_search";

    /**
     * 买手资格信息查询操作(包含买手、销售合伙人)
     */
    public static final String ACTION_AGIF0212I = "/agent/relation/_search";

    /**
     * 查询买家所属的买手和管家信息
     */
    public static final String ACTION_AGIF0401I = "/agent/byBuyer/_search";
    /**
     * 买手领地列表查询
     */
    public static final String ACTION_AGIF0205I = "/agent/demesne/_search";

    /**
     * 销售发货接口
     */
    public static final String ACTION_LINV0102I = "/linv/_outbound";

    /**
     * 商品交易完成接口
     */
    public static final String ACTION_LINV0105I = "/linv/comoInv/_deal";


    /**
     * 仓库信息查询接口
     */
    public static final String ACTION_LINV0014I = "/linv/wh/_search";

    /**
     * 货主商品占用
     */
    public static final String ACTION_LINV0107I = "/linv/comoinv/_allocate";

    /**
     * sku查询产品ID信息
     */
    public static final String PRODUCT_SEARCH ="/classes/machinings/breeds/brands/items/properties/manufacturer/_find";

    /**
     * 产品ID查询商品信息
     */
    public static final String ACTION_LINV0113I = "/linv/comoInv/_search";
	
	
    /**
     * 产品ID查询商品信息
     */
    public static final String COMMODITY_INFO ="/commodity/info/_search";

    /**
     * 产品ID查询商品信息
     */
    public static final String COMOINV_SEARCH ="/linv/comoInv/_search";

	
    /**
     * 产品ID查询商品信息
     */
    public static final String COMOINV_DEAL ="/linv/comoInv/_deal";

    /**
     * 货权交易退货完成接口
     */
    public static final String ACTION_LINV0106I = "/linv/comoInv/_return";

    /**
     * 云冻品url
     */
    public static final String YDP = "ydp01";

    /**
     * 买家配送地址的区域环标码查询
     */
    public static final String ACTION_BYIM0125I = "/buyers/delivery/areaCode/_search";

    /**
     * 产品库存占用取消
     */
    public static final String ACTION_LINV0104I = "/linv/loadInv/allocation/_cancel";

    /**
     * 商品占用取消接口
     */
    public static final String ACTION_LINV0108I = "/linv/comoInv/allocation/_cancel";

    public static final String API_ISSUE_NAME = ConfigServerPropertyLoad.getModelName("issue-api");
    public static final String API_ISSUE_URL = ConfigServerUtils.getAPIUrl(API_ISSUE_NAME,"api");
    /**
     * 问题订单查询接口
     */
    public static final String ACTION_ISSUE0105I = "/issue/_search";

    /**
     * 产品库存占用记录信息查询
     */
    public static final String ACTION_LINV0116I = "/linv/loadInv/allocation/_search";

    public static final String API_REGION_NAME = ConfigServerPropertyLoad.getModelName("region-api");
    public static final String API_REGION_URL = ConfigServerUtils.getAPIUrl(API_REGION_NAME,"api");
    public static final String ACTION_REGN0102I = "/region/logistics/_search";
}
