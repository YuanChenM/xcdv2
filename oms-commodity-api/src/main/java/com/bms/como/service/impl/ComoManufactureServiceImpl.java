package com.bms.como.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.como.bean.param.ComoManufactureRsParam;
import com.bms.como.bean.param.ComoProductRsParam;
import com.bms.como.bean.result.ComoManufactureRsResult;
import com.bms.como.bean.result.ComoProductResult;
import com.bms.como.constant.ApiUrlConstant;
import com.bms.como.constant.MessageConstant;
import com.bms.como.dao.ComoManufactureDao;
import com.bms.como.service.ComoInfoService;
import com.bms.como.service.ComoManufactureService;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by wang_haichun on 2017/3/29.
 */
@Service
public class ComoManufactureServiceImpl extends BaseServiceImpl implements ComoManufactureService {
    private final String MANUFACTUREDATE = "见外包装";
    private final String STORAGECONDITION = "-18度冷藏";
    private final String SHELFLIFE = "12个月";
    private final String MANUFACTURE_ROLE = "1";

    @Autowired
    private ComoManufactureDao comoManufactureDao;
    @Autowired
    private ComoInfoService comoInfoService;
    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @Override
    public BaseDao getBaseDao() {
        return comoManufactureDao;
    }


    /**
     * 查询商品生产商信息
     */
    @Override
    public BaseRestPaginationResult<ComoManufactureRsResult> searchComoManufacture(ComoManufactureRsParam comoManufactureRsParam) {
        BaseRestPaginationResult<ComoManufactureRsResult> result = new BaseRestPaginationResult<>();
        List<ComoManufactureRsResult> resultList = new ArrayList<>();
        /** 查询商品信息 */
        ComoProductRsParam comoProductRsParam = new ComoProductRsParam();
        List<Long> comoIds = new ArrayList<>();
        comoIds.add(comoManufactureRsParam.getCommodityId());
        comoProductRsParam.setCommodityIds(comoIds);
        BaseRestPaginationResult<ComoProductResult> restResult = comoInfoService.findPageList(comoProductRsParam);
        if(null == restResult || CollectionUtils.isEmpty(restResult.getData())){
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH,"未查询到商品信息");
        }
        ComoProductResult comoProductResult = restResult.getData().get(NumberConst.IntDef.INT_ZERO);
        //查询产品生产商
        Map<String, Object> producerProductMap = this.getProducerProduct(comoProductResult.getProductId());
        if(null == producerProductMap || !producerProductMap.containsKey("data") || CollectionUtils.isEmpty((List<Map<String, Object>>) producerProductMap.get("data"))){
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH,"未查询到产品生产商信息");
        }
        List<Map<String,Object>> producerProductList = (List<Map<String, Object>>) producerProductMap.get("data");
        Set<Long> entitySellerIds = new HashSet<>();
        ComoManufactureRsResult comoManufacture = null;
        for(Map<String,Object> map : producerProductList){
            if(null != map.get("entitySellerId")){
                entitySellerIds.add(this.objectToLong(map.get("entitySellerId")));

                comoManufacture = new ComoManufactureRsResult();
                comoManufacture.setProducerId(this.objectToString(map.get("entitySellerId")));
                comoManufacture.setProducerCode(this.objectToString(map.get("entitySellerCode")));
                comoManufacture.setProducerName(this.objectToString(map.get("fullName")));
                comoManufacture.setQualityGradeTypeName(this.objectToString(map.get("qualityGradeTypeStr")));
                comoManufacture.setBrandName(this.objectToString(map.get("brandName")));

                comoManufacture.setManufactureDate(MANUFACTUREDATE);
                comoManufacture.setStorageCondition(STORAGECONDITION);
                comoManufacture.setShelfLife(SHELFLIFE);
                resultList.add(comoManufacture);
            }
        }
        //查询生产商信息
        Map<String, Object> entitySellerMap = this.getEntitySeller(new ArrayList<Long>(entitySellerIds));
        if(null == entitySellerMap || !entitySellerMap.containsKey("data") || CollectionUtils.isEmpty((List<Map<String, Object>>) entitySellerMap.get("data"))){
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH,"未查询到生产商信息");
        }
        List<Map<String, Object>> entitySellerList = (List<Map<String, Object>>) entitySellerMap.get("data");
        for(Map<String, Object> map : entitySellerList){
            for(ComoManufactureRsResult como : resultList){
                if(this.objectToString(map.get("entitySellerId")).equals(como.getProducerId())){
                    como.setProvinceName(this.objectToString(map.get("provinceName")));
                    como.setCityName(this.objectToString(map.get("cityName")));
                    como.setAddressName(this.objectToString(map.get("address")));
                    List<Map<String,Object>> contactList = (List<Map<String, Object>>) map.get("contactList");
                    if(CollectionUtils.isNotEmpty(contactList)){
                        como.setTelephone(this.objectToString(contactList.get(NumberConst.IntDef.INT_ZERO).get("mobile")));
                    }
                }
            }
        }
        //查询 ISO9001质量管理体系认证证书认证标准
        //查询生产商角色ID
        List<String> roleIds = new ArrayList<>();
        roleIds.add(MANUFACTURE_ROLE);
        Map<String, Object> roleMap = this.getEntitySellerRole(new ArrayList<>(entitySellerIds),roleIds);
        if(null == roleMap || !roleMap.containsKey("data") || CollectionUtils.isEmpty((List<Map<String, Object>>) roleMap.get("data"))){
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH,"未查询到生产商信息");
        }
        List<Map<String, Object>> entitySellerRoleList = (List<Map<String, Object>>) roleMap.get("data");
        Set<Long> sellerRoleIds = new HashSet<>();
        for(Map<String, Object> map : entitySellerRoleList){
            for(ComoManufactureRsResult como : resultList){
                if(this.objectToString(map.get("entitySellerId")).equals(como.getProducerId())){
                    sellerRoleIds.add(this.objectToLong(map.get("sellerRoleId")));
                }
            }
        }
        //查询生产商生成资质
        Map<String, Object> qualityGradeMap = this.getQualityGradeTypeName(new ArrayList<>(sellerRoleIds));
        if(null != qualityGradeMap && qualityGradeMap.containsKey("data") && CollectionUtils.isNotEmpty((List<Map<String, Object>>) qualityGradeMap.get("data"))){
            List<Map<String, Object>> qualityGradeList = (List<Map<String, Object>>) qualityGradeMap.get("data");
            for(Map<String, Object> map : qualityGradeList){
                for(Map<String, Object> role : entitySellerRoleList){
                    if(this.objectToString(map.get("sellerRoleId")).equals(this.objectToString(role.get("sellerRoleId")))){
                        if(null == role.get("ISO")){
                            role.put("ISO",map.get("certificationStandard"));
                        }
                    }
                }
            }
            for(Map<String, Object> map : entitySellerRoleList){
                for(ComoManufactureRsResult como : resultList){
                    if(this.objectToString(map.get("entitySellerId")).equals(como.getProducerId())){
                        como.setQltCertificate(this.objectToString(map.get("ISO")));
                    }
                }
            }
        }
        result.setData(resultList);
        result.setTotal(resultList.size());
        return result;
    }


    /**
     * 查询产品生产商
     */
    private Map<String, Object> getProducerProduct(String productId){
        List<String> productIds = new ArrayList<>();
        productIds.add(productId);
        HashMap<String,Object> param = new HashMap<>();
        param.put("productIds",productIds);
        //API调API
        String url = ConfigServerUtils.getAPIUrl(ApiUrlConstant.SLPD.CONTEXT_PATH, ApiUrlConstant.SLPD.API1805);
        TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {
        };
        HashMap<String, Object> data = this.restApiClientFactory.newApiRestClient().post(url, param, typeReference);
        return data;
    }

    /**
     * 查询生产商信息
     */
    private Map<String, Object> getEntitySeller(List<Long> entitySellerIds){
        HashMap<String,Object> param = new HashMap<>();
        param.put("entitySellerIds",entitySellerIds);
        //API调API
        String url = ConfigServerUtils.getAPIUrl(ApiUrlConstant.SLIM.CONTEXT_PATH, ApiUrlConstant.SLIM.API0250);
        TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {
        };
        HashMap<String, Object> data = this.restApiClientFactory.newApiRestClient().post(url, param, typeReference);
        return data;
    }


    /**
     *查询生产商生产资质
     */
    private Map<String, Object> getQualityGradeTypeName(List<Long> sellerRoleIds){
        HashMap<String,Object> param = new HashMap<>();
        param.put("sellerRoleIds",sellerRoleIds);
        //API调API
        String url = ConfigServerUtils.getAPIUrl(ApiUrlConstant.SLIM.CONTEXT_PATH, ApiUrlConstant.SLIM.API0220);
        TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {
        };
        HashMap<String, Object> data = this.restApiClientFactory.newApiRestClient().post(url, param, typeReference);
        return data;

    }


    /**
     *查询生产商角色
     */
    private Map<String, Object> getEntitySellerRole(List<Long> entitySellerIds,List<String> roleIds){
        HashMap<String,Object> param = new HashMap<>();
        param.put("entitySellerIds",entitySellerIds);
        param.put("roleIds",roleIds);
        //API调API
        String url = ConfigServerUtils.getAPIUrl(ApiUrlConstant.SLIM.CONTEXT_PATH, ApiUrlConstant.SLIM.API0248);
        TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {
        };
        HashMap<String, Object> data = this.restApiClientFactory.newApiRestClient().post(url, param, typeReference);
        return data;
    }


    private String objectToString(Object obj){
        return obj == null ? null : obj.toString();
    }

    private Long objectToLong(Object obj){
        return obj == null ? null : Long.valueOf(String.valueOf(obj));
    }
}
