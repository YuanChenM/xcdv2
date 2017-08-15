package com.bms.order.services.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.entity.OrdrShortsell;
import com.bms.order.bean.entity.OrdrShortsellDetail;
import com.bms.order.bean.param.*;
import com.bms.order.bean.result.LINV0113IResult;
import com.bms.order.constant.UrlConst;
import com.bms.order.dao.OrdrShortsellDao;
import com.bms.order.dao.OrdrShortsellDetailDao;
import com.bms.order.services.ORDR1101IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.*;
import com.framework.exception.BusinessException;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by guan_zhongheng on 2017/4/26.
 */
@Service
public class ORDR1101IServiceImpl extends BaseServiceImpl implements ORDR1101IService {
    private static final String ORDER_STU_SUCCESS = "001";
    private static final String ORDER_STU_FAIL = "099";

    @Autowired
    private OrdrShortsellDao ordrShortsellDao;

    @Autowired
    private OrdrShortsellDetailDao ordrShortsellDetailDao;

    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @Override
    public BaseDao getBaseDao() {
        return ordrShortsellDao;
    }

    @Override
    public Long execute(ORDR1101IBeanParam beanParam, Operator operator) {
        List<OrdrShortsellDetail> allDetails = new ArrayList<>(); // 记录沽货成功的信息
        List<OrdrShortsellDetail> errDetails = new ArrayList<>(); // 记录沽货失败的信息

        String tradeTime = beanParam.getTradeTime();
        beanParam.setTradeTime(null);
        OrdrShortsell shortsellBean = BeanUtils.toBean(beanParam, OrdrShortsell.class);
        shortsellBean.setOrderId(this.maxId("ORDR_SHORTSELL"));
        // 取CODE编码
        String orderCode = ordrShortsellDao.findMaxMarketCode();
        shortsellBean.setOrderCode(orderCode);
        shortsellBean.setTotalAmount(beanParam.getTotalPrice());
        shortsellBean.setOrderSourceType("001"); // 冻期所
        shortsellBean.setPaymentStu("001"); // 支付状态： 未支付
        shortsellBean.setReceiveAmount(BigDecimal.ZERO);
        shortsellBean.setPlaceTime(DateUtils.parseDateTime(beanParam.getOrderPlaceDatetime()));
        shortsellBean.setTradeTime(DateUtils.parseDateTime(tradeTime));

        shortsellBean.setCrtId(this.getLoginUserId());
        shortsellBean.setCrtTime(DateUtils.getCurrent());
        shortsellBean.setUpdId(this.getLoginUserId());
        shortsellBean.setUpdTime(DateUtils.getCurrent());
        try {
            // 通过卖方编码补全卖方信息 优先调用买手信息 物流区信息（如果买手系统获取到直接用  如果是卖家系统 需要通过库存最大所对应的物流区）
            this.getSellerInfo(shortsellBean);
            // 通过买房编码补全买方信息
            this.getBuyerInfo(shortsellBean);
            // 开始沽货 卖方作为货权人 必须要有  不然不能查询库存
            if (StringUtils.isNotEmpty(shortsellBean.getSellerId())) {
                List<ORDR110101IBeanParam> productList = beanParam.getProducts();
                // 针对每一批进行一次沽货 有一个失败 全部失败
                for (ORDR110101IBeanParam product : productList) {
                    List<OrdrShortsellDetail> detailBeans = this.getSellerDetails(product, shortsellBean);
                    if (CollectionUtils.isNotEmpty(detailBeans)) {
                        allDetails.addAll(detailBeans);
                        // 调用库存接口
                        shortsellBean.setOrderStu(ORDER_STU_SUCCESS); // 沽货成功
                    } else {
                        // 失败也记录详情信息
                        shortsellBean.setOrderStu(ORDER_STU_FAIL); // 沽货失败
                        break;
                    }
                }
                if (ORDER_STU_FAIL.equals(shortsellBean.getOrderStu())) {
                    long newLen = this.maxIds("ORDR_SHORTSELL_DETAIL", productList.size());
                    for (ORDR110101IBeanParam errProduct : productList) {
                        OrdrShortsellDetail errDe = new OrdrShortsellDetail();
                        errDe.setOrderId(shortsellBean.getOrderId());
                        errDe.setDetailId(newLen);
                        errDe.setMaterialCode(errProduct.getCommodityCode());
                        errDe.setMaterialName(errProduct.getCommodityName());
                        errDe.setUom(errProduct.getUnit());
                        errDe.setTradeQty(errProduct.getOrderCount());
                        errDe.setTradePrice(divide(errProduct.getOrderPrice()));
                        errDe.setCrtId(this.getLoginUserId());
                        errDe.setCrtTime(DateUtils.getCurrent());
                        errDe.setUpdId(this.getLoginUserId());
                        errDe.setUpdTime(DateUtils.getCurrent());
                        newLen--;
                        errDetails.add(errDe);
                    }
                }
            } else {
                throw new BusinessException("ORDR", "卖方信息不完全");
            }
            // 保存沽货主数据
            this.save(shortsellBean);
            // 保存沽货失败详情数据
            if (CollectionUtils.isNotEmpty(errDetails) && ORDER_STU_FAIL.equals(shortsellBean.getOrderStu())) {
                ordrShortsellDetailDao.batchInsert(errDetails);
            }
            // 保存沽货成功详情数据
            if (CollectionUtils.isNotEmpty(allDetails) && ORDER_STU_SUCCESS.equals(shortsellBean.getOrderStu())) {
                ordrShortsellDetailDao.batchInsert(allDetails);
                ArrayList<LINV0105IParam> linv0105IParamList = new ArrayList<>();
                for (OrdrShortsellDetail detail : allDetails) {
                    LINV0105IParam param = new LINV0105IParam();
                    LINV0105IDealParam dealParam = new LINV0105IDealParam();
                    dealParam.setDeductSrcInv(true);
                    dealParam.setAddTargetInv(true);
                    dealParam.setTransactionId(shortsellBean.getOrderId());
                    if(StringUtils.isEmpty(orderCode)){
                        dealParam.setTransactionNo(shortsellBean.getBackNo());
                    }else {
                        dealParam.setTransactionNo(orderCode);
                    }
                    dealParam.setTransactionSource("ORDR");
                    dealParam.setTransactionDetailId(detail.getDetailId());
                    dealParam.setTransactionSequence(1);
                    dealParam.setTargetId(shortsellBean.getBuyerId());
                    dealParam.setTargetCode(shortsellBean.getBuyerCode());
                    dealParam.setTargetType(shortsellBean.getBuyerType());
                    dealParam.setTargetName(shortsellBean.getBuyerName());
                    dealParam.setReleaseQty(BigDecimal.ZERO);
                    dealParam.setDealQty(detail.getTradeQty());
                    dealParam.setBizType("007");

                    LINV0105ISourceParam sourceParam = new LINV0105ISourceParam();
                    sourceParam.setLogicAreaId(shortsellBean.getLogisticsId());
                    //TODO 销售平台
                    sourceParam.setSalePlatform("001");
                    sourceParam.setOwnerId(shortsellBean.getSellerId());
                    sourceParam.setOwnerCode(shortsellBean.getSellerCode());
                    sourceParam.setOwnerType(shortsellBean.getSellerType());
                    sourceParam.setCommodityId(StringUtils.toString(detail.getCommodityId()));
                    //TODO 库存类型
                    sourceParam.setIvType("001");
                    sourceParam.setComoIvType("001");
                    sourceParam.setUom(detail.getUom());
                    param.setDeal(dealParam);
                    param.setSource(sourceParam);
                    linv0105IParamList.add(param);
                }
                RestApiClient restClient = restApiClientFactory.newApiRestClient();
                String linvDeParam = UrlConst.API_LINV_URL + UrlConst.COMOINV_DEAL;
                restClient.post(linvDeParam, linv0105IParamList, new TypeReference<String>() {
                });
            }
        } catch (Exception e) {
            throw new BusinessException("ORDR",e.getMessage());
        }
        return shortsellBean.getOrderId();
    }

    /**
     * 货主对应 卖方
     * 1、若该产品的默认商品库存充足，则直接用默认商品进行沽货
     * 2、若该产品的默认商品库存不足，则查看其它商品的库存，优先采用可用库存最大的商品进行沽货
     * 3、若该产品下所有单个商品的库存均不充足，则优先采用默认的商品库存 + 其它库存量较大的商品进行沽货，尽量减少沽货商品的商品数
     * 4、若该产品下所有商品的可用库存合计量不足，则沽货失败
     */
    public List<OrdrShortsellDetail> getSellerDetails(ORDR110101IBeanParam param, OrdrShortsell shortsellBean) {
        List<OrdrShortsellDetail> details = new ArrayList<>();
        String materialDataType;
        // 1、根据传入的沽货物料编码，查询SKU（制造商产品SKU）对应的产品信息，若能查询到即传入的物料属于SKU编码；
        // 查询产品信息 获取产品ID
        HashMap<String, Object> requestMap = new HashMap<>();
        requestMap.put("manufacturerProductSku", param.getCommodityCode());
        RestApiClient restClient = restApiClientFactory.newApiRestClient();
        String url = UrlConst.API_SLPD_URL + UrlConst.PRODUCT_SEARCH;
        HashMap<String, Object> sellerMap = restClient.post(url, requestMap, new TypeReference<HashMap<String, Object>>() {
        });
        HashMap<String, String> comoMap = new HashMap<>(); // 商品请求参数
        if (sellerMap != null && sellerMap.get("data") != null) {
            // 走产品查商品逻辑
            List<HashMap<String, Object>> sellerBeList = this.handleJSONArray((JSONArray) sellerMap.get("data"));
            String productId = StringUtils.toString(sellerBeList.get(0).get("productId"));
            comoMap.put("productId", productId);
            materialDataType = "001";
        } else {
            // 2、若传入物料编码在制造商产品SKU中匹配不到，则根据该编码查询商品信息，若能匹配到对应的商品信息，则传入的编码属于商品编码
            // 直接把commodityCode 作为商品CODE 进商品接口查询商品信息
            comoMap.put("commodityCode", param.getCommodityCode());
            materialDataType = "002";
        }
        String comoCodeUrl = UrlConst.API_COMO_URL + UrlConst.COMMODITY_INFO;
        HashMap<String, Object> comoResult = restClient.post(comoCodeUrl, comoMap, new TypeReference<HashMap<String, Object>>() {
        });
        if (comoResult != null && comoResult.get("data") != null) {
            List<HashMap<String, Object>> comoList = this.handleJSONArray((JSONArray) comoResult.get("data"));
            // 查询库存 根据货权人ID(卖方ID) 商品ID 单位
            List<String> ownerIds = new ArrayList<>();
            List<String> commodityIds = new ArrayList<>();
            List<String> ownerTypes = new ArrayList<>();
            List<String> uoms = new ArrayList<>();
            ownerIds.add(shortsellBean.getSellerId());
            ownerTypes.add(shortsellBean.getSellerType());
            uoms.add(param.getUnit());

            for (int i = 0; i < comoList.size(); i++) {
                Map<String, Object> como = comoList.get(i);
                commodityIds.add(StringUtils.toString(como.get("commodityId")));
            }
            // 调用库存查询接口
            String linvUrl = UrlConst.API_LINV_URL + UrlConst.COMOINV_SEARCH;
            HashMap<String, Object> linvMap = new HashMap<>();
            linvMap.put("ownerId", ownerIds);
            linvMap.put("commodityId", commodityIds);
            linvMap.put("ownerType", ownerTypes);
            linvMap.put("uom", uoms);
            BaseRestPaginationResult<LINV0113IResult> linvResult = restClient.post(linvUrl, linvMap, new TypeReference<BaseRestPaginationResult<LINV0113IResult>>() {
            });
            if (linvResult != null && linvResult.getData() != null) {

                List<LINV0113IResult> linv0113IResultList = linvResult.getData();

                List<Map<String, Object>> remeberCommList = new ArrayList<>(); // 记录满足库存条件的商品

                List<Map<String, Object>> remeberMosaicCommList = new ArrayList<>(); // 记录满足库存条件的商品

                BigDecimal defaultComo = BigDecimal.ZERO; // 记录默认库存

                List<Map<String, Object>> remeberSuccessCommList = new ArrayList<>(); // 用于记录全部商品计算时候数量统计

                BigDecimal allNum = BigDecimal.ZERO; // 该产品下所有商品相加总库存
                for (int i = 0; i < comoList.size(); i++) {
                    Map<String, Object> como = comoList.get(i);
                    String commodityId = StringUtils.toString(como.get("commodityId"));
                    // 计算单个商品下所有坤库存 先取所有总和是否满足
                    BigDecimal num = BigDecimal.ZERO; // 商品下的库存数量
                    String logcsAreaId = "";
                    String logcsAreaCode = "";
                    String logcsAreaName = "";
                    for (LINV0113IResult par : linv0113IResultList) {
                        if (commodityId.equals(par.getCommodityId())) {
                            num = num.add(par.getTotalQty());
                            if (StringUtils.isEmpty(logcsAreaId)) {
                                logcsAreaId = par.getLogisticsId();
                                logcsAreaCode = par.getLogisticsCode();
                                logcsAreaName = par.getLogisticsName();
                            }
                        }
                    }
                    como.put("total", num); // 记录该商品下库存数量
                    como.put("logcsAreaId", logcsAreaId);
                    como.put("logcsAreaCode", logcsAreaCode);
                    como.put("logcsAreaName", logcsAreaName);
                    if (num.compareTo(param.getOrderCount()) == 1 || num.compareTo(param.getOrderCount()) == 0) { // -1 bigD的比较方式  -1 为小于 0 为等于 1为大于
                        remeberCommList.add(como);
                    } else {
                        // 该单个商品不能完整提供要求数量 记录下商品数量信息
                        allNum = allNum.add(num);
                        if (como.get("isDefault") != null && (Boolean) como.get("isDefault") == true) {
                            defaultComo = num;
                            remeberMosaicCommList.add(como);
                        } else {
                            remeberMosaicCommList.add(como);
                        }
                    }
                }

                if (remeberCommList.size() > NumberUtils.INTEGER_ZERO) {
                    // 表示存在单个满足要求库存数量条件商品 对应注释逻辑 1、2
                    OrdrShortsellDetail detail = new OrdrShortsellDetail();
                    detail.setOrderId(shortsellBean.getOrderId());
                    detail.setDetailId(this.maxId("ORDR_SHORTSELL_DETAIL"));
                    detail.setMaterialCode(param.getCommodityCode());
                    detail.setMaterialName(param.getCommodityName());
                    detail.setMaterialDataType(materialDataType);
                    detail.setUom(param.getUnit());
                    detail.setTradeQty(param.getOrderCount());
                    detail.setTradePrice(divide(param.getOrderPrice()));
                    detail.setCrtId(this.getLoginUserId());
                    detail.setCrtTime(DateUtils.getCurrent());
                    detail.setUpdId(this.getLoginUserId());
                    detail.setUpdTime(DateUtils.getCurrent());
                    Map<String, Object> remeberComoMax = new HashedMap();
                    for (int i = 0; i < remeberCommList.size(); i++) {
                        Map<String, Object> remeberComo = remeberCommList.get(i);
                        if (remeberComo.get("isDefault") != null && (Boolean) remeberComo.get("isDefault") == true) {
                            // 存在默认商品满足库存数量 优先取用
                            detail.setCommodityId(checkNull(remeberComo.get("commodityId")));
                            detail.setCommodityCode(StringUtils.toString(remeberComo.get("commodityCode")));
                            detail.setCommodityName(StringUtils.toString(remeberComo.get("commodityName")));
                            shortsellBean.setLogisticsId(checkNull(remeberComo.get("logcsAreaId")));
                            shortsellBean.setLogisticsCode(StringUtils.toString(remeberComo.get("logcsAreaCode")));
                            shortsellBean.setLogisticsName(StringUtils.toString(remeberComo.get("logcsAreaName")));
                            details.add(detail);
                            break;
                        } else {
                            if (remeberComoMax.size() == 0) {
                                remeberComoMax.putAll(remeberCommList.get(i));
                            } else {
                                if (remeberComoMax.get("total") != null
                                        && ((BigDecimal) remeberComoMax.get("total")).compareTo((BigDecimal) remeberComoMax.get("total")) == -1) {
                                    remeberComoMax.putAll(remeberComo);
                                }
                            }
                        }
                    }
                    if (detail.getCommodityId() == null || detail.getCommodityId() == 0L) {
                        detail.setCommodityId(checkNull(remeberComoMax.get("commodityId")));
                        detail.setCommodityCode(StringUtils.toString(remeberComoMax.get("commodityCode")));
                        detail.setCommodityName(StringUtils.toString(remeberComoMax.get("commodityName")));
                        details.add(detail);
                        shortsellBean.setLogisticsId(checkNull(remeberComoMax.get("logcsAreaId")));
                        shortsellBean.setLogisticsCode(StringUtils.toString(remeberComoMax.get("logcsAreaCode")));
                        shortsellBean.setLogisticsName(StringUtils.toString(remeberComoMax.get("logcsAreaName")));
                    }

                } else if (allNum.compareTo(param.getOrderCount()) == 1) {
                    // 满足一个产品下面 商品总和超过 进行产品分解 升序排序
                    Collections.sort(remeberMosaicCommList, new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Map<String, Object> map1 = (Map<String, Object>) o1;
                            Map<String, Object> map2 = (Map<String, Object>) o2;
                            if (DecimalUtils.ge(DecimalUtils.getBigDecimal(map1.get("total")), DecimalUtils.getBigDecimal(map2.get("total")))) {
                                return 1;
                            } else {
                                return -1;
                            }
                        }
                    });
                    BigDecimal resultNum = param.getOrderCount().subtract(defaultComo);
                    for (int i = remeberMosaicCommList.size() - 1; i >= 0; i--) {
                        BigDecimal commoNum = (BigDecimal) remeberMosaicCommList.get(0).get("total");
                        remeberSuccessCommList.add(remeberMosaicCommList.get(0));
                        if (resultNum.compareTo(commoNum) == 1) {
                            resultNum = resultNum.subtract(commoNum);
                        } else {
                            break;
                        }
                    }
                    long alen = this.maxIds("ORDR_SHORTSELL_DETAIL", remeberSuccessCommList.size());
                    for (Map<String, Object> coMap : remeberSuccessCommList) {
                        OrdrShortsellDetail detail = new OrdrShortsellDetail();
                        detail.setOrderId(shortsellBean.getOrderId());
                        detail.setDetailId(alen);
                        detail.setMaterialCode(param.getCommodityCode());
                        detail.setMaterialName(param.getCommodityName());
                        detail.setMaterialDataType(materialDataType);
                        detail.setUom(param.getUnit());
                        detail.setTradeQty(param.getOrderCount());
                        detail.setTradePrice(param.getOrderCount());
                        detail.setCrtId(this.getLoginUserId());
                        detail.setCrtTime(DateUtils.getCurrent());
                        detail.setUpdId(this.getLoginUserId());
                        detail.setUpdTime(DateUtils.getCurrent());
                        detail.setCommodityId(checkNull(coMap.get("commodityId")));
                        detail.setCommodityCode(StringUtils.toString(coMap.get("commodityCode")));
                        detail.setCommodityName(StringUtils.toString(coMap.get("commodityName")));
                        details.add(detail);
                        if (shortsellBean.getLogisticsId() == null || shortsellBean.getLogisticsId() == 0) {
                            shortsellBean.setLogisticsId(checkNull(coMap.get("logcsAreaId")));
                            shortsellBean.setLogisticsCode(StringUtils.toString(coMap.get("logcsAreaCode")));
                            shortsellBean.setLogisticsName(StringUtils.toString(coMap.get("logcsAreaName")));
                        }
                        alen--;
                    }
                } else {
                    // 满足注释逻辑4  总库存不能达标
                    return null;
                }
            } else {
                // 所有商品库存信息都未能获取
                return null;
            }
        } else {
            // 商品信息获取失败
            return null;
        }
        return details;
    }

    /**
     * 获取卖方信息
     *
     * @param shortsellBean
     */
    public void getSellerInfo(OrdrShortsell shortsellBean) {
        RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
        HashMap<String, String> agentMap = new HashMap<>();
        agentMap.put("agentCode", shortsellBean.getSellerCode());
        String agentUrl = UrlConst.API_AGIF_URL + UrlConst.ACTION_AGIF0209I;
        HashMap<String, Object> agentResult = restApiClient.post(agentUrl, agentMap, new TypeReference<HashMap<String, Object>>() {
        });
        if (agentResult != null && agentResult.get("data") != null) {
            List<HashMap<String, Object>> agifBeanList = this.handleJSONArray((JSONArray) agentResult.get("data"));
            HashMap<String, Object> agifBean = agifBeanList.get(0);
            shortsellBean.setLogisticsId(NumberUtils.toLong(StringUtils.toString(agifBean.get("lgcsAreaId"))));
            shortsellBean.setLogisticsCode(StringUtils.toString(agifBean.get("lgcsAreaCode")));
            shortsellBean.setLogisticsName(StringUtils.toString(agifBean.get("lgcsAreaName")));
            shortsellBean.setSellerId(StringUtils.toString(agifBean.get("agentId")));
            shortsellBean.setSellerType("002");
        } else {
            String slimUrl = UrlConst.API_SLIM_URL + UrlConst.ACTION_SLIM0250I;
            HashMap<String, String> slimMap = new HashMap<>();
            slimMap.put("entitySellerCode", shortsellBean.getSellerCode());
            HashMap<String, Object> slimSellerResult = restApiClient.post(slimUrl, slimMap, new TypeReference<HashMap<String, Object>>() {
            });
            if (slimSellerResult != null && slimSellerResult.get("data") != null) {
                List<HashMap<String, Object>> slimSellerBeanList = this.handleJSONArray((JSONArray) slimSellerResult.get("data"));
                HashMap<String, Object> slimBean = slimSellerBeanList.get(0);
                shortsellBean.setSellerId(StringUtils.toString(slimBean.get("entitySellerId")));
                shortsellBean.setSellerType("001"); // 平台卖家
            }
        }
    }

    /**
     * 获取买方信息
     *
     * @param shortsellBean
     */
    public void getBuyerInfo(OrdrShortsell shortsellBean) {
        RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
        HashMap<String, String> agentMap = new HashMap<>();
        agentMap.put("agentCode", shortsellBean.getBuyerCode());
        String agentUrl = UrlConst.API_AGIF_URL + UrlConst.ACTION_AGIF0209I;
        HashMap<String, Object> agentResult = restApiClient.post(agentUrl, agentMap, new TypeReference<HashMap<String, Object>>() {
        });
        if (agentResult != null && agentResult.get("data") != null) {
            List<HashMap<String, Object>> agifBeanList = this.handleJSONArray((JSONArray) agentResult.get("data"));
            HashMap<String, Object> agifBean = agifBeanList.get(0);
            shortsellBean.setBuyerId(StringUtils.toString(agifBean.get("agentId")));
            shortsellBean.setBuyerType("002");
        } else {
            String slimUrl = UrlConst.API_SLIM_URL + UrlConst.ACTION_SLIM0250I;
            HashMap<String, String> slimMap = new HashMap<>();
            slimMap.put("entitySellerCode", shortsellBean.getBuyerCode());
            HashMap<String, Object> slimResult = restApiClient.post(slimUrl, slimMap, new TypeReference<HashMap<String, Object>>() {
            });
            if (slimResult != null && slimResult.get("data") != null) {
                List<HashMap<String, Object>> slimBeanList = this.handleJSONArray((JSONArray) slimResult.get("data"));
                HashMap<String, Object> slimBean = slimBeanList.get(0);
                shortsellBean.setBuyerId(StringUtils.toString(slimBean.get("entitySellerId")));
                shortsellBean.setBuyerType("001"); // 平台卖家
            }
        }
    }

    /**
     * 用于解决fastjson 转List<Map>
     *
     * @param jsonArray
     * @return
     */
    private List<HashMap<String, Object>> handleJSONArray(JSONArray jsonArray) {
        List list = new ArrayList();
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            HashMap map = new HashMap<String, Object>();
            for (Map.Entry entry : jsonObject.entrySet()) {
                if (entry.getValue() instanceof JSONArray) {
                    map.put((String) entry.getKey(), handleJSONArray((JSONArray) entry.getValue()));
                } else {
                    map.put((String) entry.getKey(), entry.getValue());
                }
            }
            list.add(map);
        }
        return list;
    }


    private Long checkNull(Object obj) {
        if (null == obj || StringUtils.isEmpty(String.valueOf(obj)))
            return null;

        return Long.valueOf(String.valueOf(obj));
    }

    /**
     * 转换金额精度
     * @param source
     * @return
     */
    private static BigDecimal divide(BigDecimal source){
        BigDecimal b1 = new BigDecimal("100");
        BigDecimal b3 = source.divide(b1,2,BigDecimal.ROUND_HALF_EVEN);
        return b3;
    }
}
