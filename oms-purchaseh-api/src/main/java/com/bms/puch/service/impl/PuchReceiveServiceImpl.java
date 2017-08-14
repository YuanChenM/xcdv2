/*
 * 2017/03/16 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.puch.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.puch.bean.entity.ComoProductInfo;
import com.bms.puch.bean.entity.PuchDetail;
import com.bms.puch.bean.entity.PuchReceive;
import com.bms.puch.bean.param.*;
import com.bms.puch.bean.result.LINV0114IResult;
import com.bms.puch.bean.result.PuchReceiveXmlResult;
import com.bms.puch.constant.ApiUrlDef;
import com.bms.puch.dao.PuchDetailDao;
import com.bms.puch.dao.PuchReceiveDao;
import com.bms.puch.service.PuchReceiveService;
import com.bms.puch.util.CodeMasterUtils;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.*;
import com.framework.exception.BusinessException;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>PuchReceiveService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class PuchReceiveServiceImpl extends BaseServiceImpl implements PuchReceiveService {

    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @Autowired
    private PuchReceiveDao puchReceiveDao;

    @Autowired
    private PuchDetailDao puchDetailDao;

    @Autowired
    private CodeMasterUtils codeMasterUtils;

    private ArrayList<LINV0101IParam> linv0101IParamList;

    @Override
    public BaseDao getBaseDao() {
        return puchReceiveDao;
    }

    @Override
    public PuchReceiveXmlResult exceutePuchInfo(PuchReceiveParam param) {
        PuchReceiveXmlResult receiveXmlResult = new PuchReceiveXmlResult();
        linv0101IParamList = new ArrayList<>();

        // 获取入库主表
        PuchReceive bean = BeanUtils.toBean(param, PuchReceive.class);
        Long deliverId = this.maxId("PUCH_RECEIVE");
        bean.setDeliverId(deliverId);
        //入库主数据信息补全
        this.puchReceiveCompletion(bean);
        // 补全物流区ID
        this.getLogisticsId(bean);
        bean.setCrtId(this.getLoginUserId());
        bean.setCrtTime(DateUtils.getCurrent());
        bean.setUpdId(this.getLoginUserId());
        bean.setUpdTime(DateUtils.getCurrent());
        this.save(bean);
        List<PuchDetail> puchDetailList = new ArrayList<>();
        // 获取详情表数据
        for (OrderParam orderParam : param.getOrderList()) {
            if (CollectionUtils.isNotEmpty(orderParam.getScheduleList())) {
                for (ScheduleParam scheduleParam : orderParam.getScheduleList()) {
                    if (CollectionUtils.isNotEmpty(scheduleParam.getDetailList())) {
                        for (PuchDetailParam detailParam : scheduleParam.getDetailList()) {
                            PuchDetail detail = BeanUtils.toBean(detailParam, PuchDetail.class);
                            Long deliverDetailId = this.maxId("PUCH_DETAIL");
                            detail.setDeliverDetailId(deliverDetailId);
                            detail.setDeliverId(deliverId);
                            detail.setOrderCode(orderParam.getOrderCode());
                            detail.setOrderType(orderParam.getOrderType());
                            detail.setScheduleCode(scheduleParam.getScheduleCode());
                            detail.setScheduleDate(scheduleParam.getScheduleDate());
                            detail.setCrtTime(DateUtils.getCurrent());
                            detail.setCrtId(this.getLoginUserId());
                            detail.setUpdTime(DateUtils.getCurrent());
                            detail.setUpdId(this.getLoginUserId());
                            if (StringUtils.isEmpty(detailParam.getInventoryStatus())) {
                                detail.setInventoryStatus("正常品");
                            }
                            // 补全商品信息(调用卖家接口) 对外提供期间因为卖家表变动
                            this.getDefectInfo(detail);
                            // 补全仓库ID信息(调用库存接口)
                            this.getWhInfo(bean.getLgcsAreaId(), detail);
                            puchDetailList.add(detail);
                            // 调用虚拟库存 收货接口进行通知操作 2017-4-25 基于库存接口 暂时屏蔽
                            this.saveLinvOrderInfo(bean, detail);
                        }
                    }
                }
            }
        }
        if (CollectionUtils.isNotEmpty(puchDetailList)) {
            puchDetailDao.batchInsert(puchDetailList);
        }
        // 调用虚拟库存 收货接口进行通知操作 2017-4-25 基于库存接口
        if (CollectionUtils.isNotEmpty(linv0101IParamList)) {
            RestApiClient restClient = restApiClientFactory.newApiRestClient();
            String linvUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.LINV_MODEL, ApiUrlDef.LINV.receiveLoad);
            Integer result = restClient.post(linvUrl, linv0101IParamList, new TypeReference<Integer>() {
            });
        }
        receiveXmlResult.setResult(puchDetailList.size());
        receiveXmlResult.setDeliverId(deliverId);
        if(StringUtils.equals(param.getOwnerType(), "002")){
            receiveXmlResult.setPushFlg(Boolean.TRUE);
        }else{
            receiveXmlResult.setPushFlg(Boolean.FALSE);
        }
        return receiveXmlResult;
    }

    /**
     * 采购订单入库
     */
    public void saveLinvOrderInfo(PuchReceive bean, PuchDetail detail) {
        LINV0101IParam param = new LINV0101IParam();
        LINV0101ISourceParam sourceParam = BeanUtils.toBean(bean, LINV0101ISourceParam.class);
        sourceParam.setLogicAreaId(bean.getLgcsAreaId());
        sourceParam.setLogicAreaCode(bean.getLgcsAreaCode());
        sourceParam.setLogicAreaName(bean.getLgcsAreaName());
        sourceParam.setSalePlatform("001");
        sourceParam.setWhId(detail.getWhId());
        sourceParam.setWhCode(detail.getWhCode());
        sourceParam.setWhName(detail.getWhName());
        sourceParam.setSkuCode(detail.getMaterialCode());
        if (StringUtils.isEmpty(detail.getUnit()) || StringUtils.equals("箱", detail.getUnit())) {
            sourceParam.setUom("001");
        } else {
            sourceParam.setUom(detail.getUnit());
        }

        LINV0101IDealParam dealParam = new LINV0101IDealParam();
        dealParam.setTransactionId(bean.getDeliverId());
        dealParam.setTransactionNo(bean.getDeliverCode());
        dealParam.setTransactionDetailId(detail.getDeliverDetailId());
        dealParam.setTransactionSource("PUCH");
        dealParam.setTransactionSequence(1);
        dealParam.setSupplierId(StringUtils.toString(bean.getSupplierId()));
        dealParam.setSupplierCode(bean.getSupplierCode());
        dealParam.setSupplierName(bean.getSupplierName());
        dealParam.setLotNo(detail.getLotNo());
        dealParam.setBuyPrice(detail.getReceivePrice());
        dealParam.setRecvQty(detail.getReceiveQty());
        dealParam.setIvType("001");
        if ("001".equals(bean.getOwnerType())) {
            // 调用卖家接口数据补全
            dealParam.setBizType("001");
        } else if ("002".equals(bean.getOwnerType())) {
            // 调用买手接口数据补全
            dealParam.setBizType("002");
        }
        param.setSource(sourceParam);
        param.setDeal(dealParam);
        linv0101IParamList.add(param);
    }

    /**
     * 入库主表数据补全
     */
    public void puchReceiveCompletion(PuchReceive bean) {
        RestApiClient restClient = restApiClientFactory.newApiRestClient();
        bean.setCrtId(this.getLoginUserId());
        bean.setCrtTime(DateUtils.getCurrent());
        bean.setUpdId(this.getLoginUserId());
        bean.setUpdTime(DateUtils.getCurrent());
        //  调用卖家接口补全数据(根据货权人编码 获取货权人信息 根据货权人类型 区分调用 001-卖家，002-买手（现状SRM无买手，固定001即可）)
        HashMap<String, Object> requestMap = new HashMap<>();
        String entitySellerCodes[] = null;
        if ("001".equals(bean.getOwnerType())) {
            // 调用卖家接口数据补全
            entitySellerCodes = new String[]{bean.getOwnerCode(), bean.getSupplierCode()};
        } else if ("002".equals(bean.getOwnerType())) {
            // 调用买手接口数据补全
            entitySellerCodes = new String[]{bean.getSupplierCode()};
            // 调用买手获取信息
            HashMap<String, String> agifRequestMap = new HashMap<>();
            agifRequestMap.put("agentCode", bean.getOwnerCode());
            // TODO 修改为查询买手销售合伙人联合接口 20170428
            String agifUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.AGIF_MODEL, ApiUrlDef.AGIF.agentPartnerSearch);
            HashMap<String, Object> agifResMap = restClient.post(agifUrl, agifRequestMap, new TypeReference<HashMap<String, Object>>() {
            });
            if (agifResMap != null && agifResMap.get("data") != null) {
                Map<String, String> agifResultList = ((List<Map<String, String>>) agifResMap.get("data")).get(0);
                bean.setOwnerId(agifResultList.get("agentId"));
                bean.setOwnerName(agifResultList.get("agentName"));
            }
        }
        requestMap.put("entitySellerCodes", entitySellerCodes);
        String url = ConfigServerUtils.getAPIUrl(ApiUrlDef.SLIM_MODEL, ApiUrlDef.SLIM.sellerSearch);
        try {
            HashMap<String, Object> sellerMap = restClient.post(url, requestMap, new TypeReference<HashMap<String, Object>>() {
            });
            if (sellerMap != null && sellerMap.get("data") != null) {
                List<Map<String, String>> resultList = (List<Map<String, String>>) sellerMap.get("data");
                for (int i = 0; i < resultList.size(); i++) {
                    Map<String, String> map = resultList.get(i);
                    if (bean.getSupplierCode().equals(map.get("entitySellerCode"))) {
                        bean.setSupplierId(NumberUtils.toLong(StringUtils.toString(map.get("entitySellerId"))));
                        bean.setSupplierName(StringUtils.toString(map.get("fullName")));
                    }
                    if (bean.getOwnerCode().equals(map.get("entitySellerCode")) && "001".equals(bean.getOwnerType())) {
                        bean.setOwnerId(StringUtils.toString(map.get("entitySellerId")));
                        bean.setOwnerName(map.get("fullName"));
                    }
                }
            }
        } catch (Exception e) {
            throw new BusinessException("SLIM", "供应商、货权人信息获取失败!");
        }
    }

    public void getDefectInfo(PuchDetail detail) {
        HashMap<String, Object> requestMap = new HashMap<>();
        requestMap.put("manufacturerProductSku", detail.getMaterialCode());
        RestApiClient restClient = restApiClientFactory.newApiRestClient();
        String url = ConfigServerUtils.getAPIUrl(ApiUrlDef.SLPD_MODEL, ApiUrlDef.SLPD.productSearch);
        try {
            HashMap<String, Object> sellerMap = restClient.post(url, requestMap, new TypeReference<HashMap<String, Object>>() {
            });
            if (sellerMap != null && sellerMap.get("data") != null) {
                List<Map<String, Object>> resultList = (List<Map<String, Object>>) sellerMap.get("data");
                if (CollectionUtils.isNotEmpty(resultList)) {
                    List<Map<String, String>> maps = (List<Map<String, String>>) resultList.get(0).get("producerProducts");
                    Map<String, String> map = maps.get(0);
                    // 获取产品ID  查询商品信息
                    String productId = StringUtils.toString(map.get("productId"));
                    if (StringUtils.isNotEmpty(productId)) {
                        String comoUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.COMO_MODEL, ApiUrlDef.COMO.commodityInfo);
                        HashMap<String, String> comoMap = new HashMap<>();
                        comoMap.put("productId", productId);
                        int commCheck = this.getCommodityInfo(comoMap, restClient, comoUrl, detail);
                        if (commCheck >= 1) {
                                // 查不到优先同步产品
                            String prodAddUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.COMO_MODEL, ApiUrlDef.COMO.productInfoCreate);

                            ComoProductInfo productInfo = BeanUtils.toBean(map,ComoProductInfo.class);
                            if(StringUtils.isNotEmpty(productInfo.getQualityGradeType())){
                                Map<String,String> gradeType = codeMasterUtils.getCodeMaster("SLPD_QualityGradeType");
                                productInfo.setQualityGradeTypeCode(gradeType.get(productInfo.getQualityGradeType()));
                            }

                            List<ComoProductInfo> comoProductEntities = new ArrayList<>();
                            comoProductEntities.add(productInfo);

                            ProductInfoCreateRsParam prodParam = new ProductInfoCreateRsParam();
                            prodParam.setProductInfos(comoProductEntities);
                            restClient.post(prodAddUrl,prodParam,new TypeReference<HashMap<String, Object>>() {});

                            //没有查到数据信息  新增默认商品
                            String comoAddUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.COMO_MODEL, ApiUrlDef.COMO.commodityInfoCreate);
                            HashMap<String, Object> comoAddMap = new HashMap<>();
                            comoAddMap.put("productId", productId);
                            List<Map<String, Object>> uomList = new ArrayList<>();
                            Map<String, Object> uom = new HashedMap();
                            uom.put("uom", "001");
                            uom.put("isDefault", true);
                            uomList.add(uom);
                            comoAddMap.put("uomList", uomList);
                            restClient.post(comoAddUrl, comoAddMap, new TypeReference<HashMap<String, Object>>() {
                            });

                            // 新增成功后  查询该商品信息
                            this.getCommodityInfo(comoMap, restClient, comoUrl, detail);
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new BusinessException("SLPDorCOMO", "商品信息获取操作失败!");
        }
    }

    public int getCommodityInfo(HashMap<String, String> comoMap, RestApiClient restClient, String comoUrl, PuchDetail detail) {
        HashMap<String, Object> comoResult = restClient.post(comoUrl, comoMap, new TypeReference<HashMap<String, Object>>() {
        });
        List<Map<String, Object>> comoList = (List<Map<String, Object>>) comoResult.get("data");
        if (CollectionUtils.isNotEmpty(comoList)) {
            for (int i = 0; i < comoList.size(); i++) {
                Map<String, Object> como = comoList.get(i);
                if (como.get("isDefault") == true) {
                    detail.setCommodityId(Long.parseLong(StringUtils.toString(como.get("commodityId"))));
                    detail.setCommodityCode(StringUtils.toString(como.get("commodityCode")));
                    detail.setCommodityName(StringUtils.toString(como.get("commodityName")));
                    break;
                }
            }
        } else {
            return 1;
        }
        return 0;
    }

    /**
     * 补全仓库ID
     *
     * @param lgcsAreaId
     */
    public void getWhInfo(Long lgcsAreaId, PuchDetail detail) {
        RestApiClient restClient = restApiClientFactory.newApiRestClient();
        String whUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.LINV_MODEL, ApiUrlDef.LINV.whSearch);
        LINV0114IParam param = new LINV0114IParam();
        param.setPagination(null);
        List<Long> logcs = new ArrayList<>();
        logcs.add(lgcsAreaId);
        param.setLogisticsId(logcs);
        List<String> whCodes = new ArrayList<>();
        whCodes.add(detail.getWhCode());
        param.setWhCode(whCodes);
        BaseRestPaginationResult<LINV0114IResult> whList = restClient.post(whUrl, param, new TypeReference<BaseRestPaginationResult<LINV0114IResult>>() {
        });
        if (whList != null && CollectionUtils.isNotEmpty(whList.getData())) {
            detail.setWhId(whList.getData().get(0).getWhId());
        }
    }

    public void getLogisticsId(PuchReceive bean) {
        LogisticsAreaParam param = new LogisticsAreaParam();
        param.setLgcsAreaCode(bean.getLgcsAreaCode());
        RestApiClient restClient = restApiClientFactory.newApiRestClient();
        String url = ConfigServerUtils.getAPIUrl(ApiUrlDef.REGION_MODEL, ApiUrlDef.REGION.logisticsSearch);
        List<LogisticsAreaParam> result = restClient.post(url, param, new TypeReference<ArrayList<LogisticsAreaParam>>() {
        });
        if (CollectionUtils.isNotEmpty(result)) {
            LogisticsAreaParam resArea = result.get(0);
            bean.setLgcsAreaId(resArea.getLgcsAreaId());
            bean.setLgcsAreaName(resArea.getLgcsAreaName());
        }
    }

}