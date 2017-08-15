package com.bms.slpd.services.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.slpd.bean.entity.SlpdItemProperty;
import com.bms.slpd.bean.entity.SlpdManufacturerProduct;
import com.bms.slpd.bean.entity.SlpdProducerProduct;
import com.bms.slpd.bean.entity.SlpdProduct;
import com.bms.slpd.bean.param.CodeGenerateParam;
import com.bms.slpd.bean.param.SLIM0250IParam;
import com.bms.slpd.bean.result.field.SLPDRoleSkuResult;
import com.bms.slpd.bean.result.wrapper.SlpdBrandItemResult;
import com.bms.slpd.bean.result.wrapper.SlpdBrandResult;
import com.bms.slpd.constant.ApiUrlConstant;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.CodeGenerateDao;
import com.bms.slpd.services.CodeGenerateService;
import com.bms.slpd.utils.RestApiUtils;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by memorykai on 2017/3/20.
 */
@Service
public class CodeGenerateServiceImpl extends BaseServiceImpl implements CodeGenerateService {

    @Autowired
    private CodeGenerateDao codeGenerateDao;
    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @Override
    public BaseDao getBaseDao() {
        return codeGenerateDao;
    }


    @Override
    public String getClassesCode(Long classesId) {
        return null;
    }

    @Override
    public String getMachiningCode(Long machiningId) {
        return null;
    }

    @Override
    public String getBreedCode(Long breedId) {
        return null;
    }


    /**
     * 获取品牌的Code
     */
    @Override
    public List<SlpdBrandResult> getBrandCode(List<Long> brandIds) {
        return codeGenerateDao.getBrandCode(brandIds);
    }

    /*@Override
    public List<SlpdBrandItemProperty> getNetWeightCode(CodeGenerateParam param) {
        return codeGenerateDao.getNetWeightCode(param);
    }*/

    @Override
    public List<SlpdProduct> getProductNetWeightCode(CodeGenerateParam param) {
        return codeGenerateDao.getProductNetWeightCode(param);
    }

    /**
     * 获取单品品牌Sku
     */
    @Override
    public Map<Long, String> getBrandItemSku(CodeGenerateParam brandItemIds) {
        List<Long> brandItemIdList = brandItemIds.getBrandItemIds();
        Map<Long, String> map = new HashMap<>();
        if (CollectionUtils.isNotEmpty(brandItemIdList)) {
            List<SlpdBrandItemResult> brandItemResults = codeGenerateDao.getBrandItemSku(brandItemIds);
            for (Long brandItemId : brandItemIdList) {
                boolean flag = true;
                for (SlpdBrandItemResult brandItem : brandItemResults) {
                    if (brandItemId.equals(brandItem.getBrandItemId())) {
                        flag = false;
                        map.put(brandItemId, brandItem.getBrandItemSku());
                    }
                }
                if (flag) {
                    map.put(brandItemId, null);
                }
            }
        }
        return map;
    }


    /*@Override
    public Map<String, Map<Long, String>> getMaxNetWeightAndPropertyCode(CodeGenerateParam brandItemIdParam) {
        List<Long> brandItemIds = brandItemIdParam.getBrandItemIds();
        List<SlpdBrandItemProperty> results = this.codeGenerateDao.maxNetWeightAndPropertyCode(brandItemIdParam);
        Map<Long, String> netWeightCodeResult = new HashMap();
        Map<Long, String> propertyCodeResult = new HashMap();
        for (SlpdBrandItemProperty slpdBrandItemProperty : results) {
//            netWeightCodeResult.put(slpdBrandItemProperty.getBrandItemId(), slpdBrandItemProperty.getNetWeightCode());
//            propertyCodeResult.put(slpdBrandItemProperty.getBrandItemId(), slpdBrandItemProperty.getBrandItemPropertyCode());
        }
        for (Long brandItemId : brandItemIds) {
            //初始化净重编码
            if (StringUtils.isEmpty(netWeightCodeResult.get(brandItemId))) {
                netWeightCodeResult.put(brandItemId, "00");
            }

            //初始化规格编码
            if (StringUtils.isEmpty(propertyCodeResult.get(brandItemId))) {
                propertyCodeResult.put(brandItemId, "00");
            }
        }

        Map<String, Map<Long, String>> result = new HashMap<>();
        result.put("netWeightCodeMap", netWeightCodeResult);
        result.put("propertyCodeMap", propertyCodeResult);
        return result;
    }*/

    @Override
    public Map<String, Map<Long, String>> getMaxNetWeightCode(CodeGenerateParam param) {
        List<Long> itemIds = param.getItemIds();
        List<SlpdProduct> results = this.codeGenerateDao.maxNetWeightCode(param);
        Map<Long, String> netWeightCodeResult = new HashMap();
        for (SlpdProduct slpdBrandItemProperty : results) {
            netWeightCodeResult.put(slpdBrandItemProperty.getItemId(), slpdBrandItemProperty.getNetWeightCode());
        }
        for (Long itemId : itemIds) {
            //初始化净重编码
            if (StringUtils.isEmpty(netWeightCodeResult.get(itemId))) {
                netWeightCodeResult.put(itemId, "00");
            }
        }

        Map<String, Map<Long, String>> result = new HashMap<>();
        result.put("netWeightCodeMap", netWeightCodeResult);
        return result;
    }

    @Override
    public Map<String, Map<Long, String>> getMaxPropertyCode(CodeGenerateParam itemIdParam) {
        List<Long> itemIds = itemIdParam.getItemIds();
        List<SlpdItemProperty> results = this.codeGenerateDao.maxPropertyCode(itemIdParam);
        Map<Long, String> propertyCodeResult = new HashMap();
        for (SlpdItemProperty slpdItemProperty : results) {
            propertyCodeResult.put(slpdItemProperty.getItemId(), slpdItemProperty.getItemPropertyCode());
        }
        for (Long itemId : itemIds) {

            //初始化规格编码
            if (StringUtils.isEmpty(propertyCodeResult.get(itemId))) {
                propertyCodeResult.put(itemId, "00");
            }
        }

        Map<String, Map<Long, String>> result = new HashMap<>();
        result.put("propertyCodeMap", propertyCodeResult);
        return result;
    }

    @Override
    public String getMaxItemCode() {
        String itemCode = this.codeGenerateDao.getMaxItemCode();
        if (StringUtils.isEmpty(itemCode))
            itemCode = "000000";
        return itemCode;
    }


    /**
     * 获取产品生产商、制造商、代理商的最大SKU
     *
     * @param entitySellerIds
     * @return
     */
    @Override
    public List<SLPDRoleSkuResult> getRoleSku(List<Long> entitySellerIds) {
        if (CollectionUtils.isNotEmpty(entitySellerIds)) {
            Set set = new HashSet();
            set.addAll(entitySellerIds);
            entitySellerIds = new ArrayList<>(set);
            List<SLPDRoleSkuResult> result = codeGenerateDao.getRoleSku(entitySellerIds);
            List<Long> sellerIds = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(result)) {
                //取出没有查询到的实体卖家ID
                if (result.size() != entitySellerIds.size()) {
                    for (Long sellerId : entitySellerIds) {
                        //判断结果集中是否有entitySellerId
                        boolean flag = true;
                        for (SLPDRoleSkuResult roleSku : result) {
                            if (sellerId.equals(Long.valueOf(roleSku.getEntitySellerId()))) {
                                flag = false;
                            }
                        }
                        if (flag) {
                            sellerIds.add(sellerId);
                        }
                    }
                    if (CollectionUtils.isNotEmpty(sellerIds)) {
                        List<SLPDRoleSkuResult> roleSkuResultList = this.getInitRoleSku(sellerIds);
                        if (CollectionUtils.isNotEmpty(roleSkuResultList)) {
                            result.addAll(roleSkuResultList);
                        }
                    }
                }
            } else {
                List<SLPDRoleSkuResult> roleSkuResultList = this.getInitRoleSku(entitySellerIds);
                if (CollectionUtils.isNotEmpty(roleSkuResultList)) {
                    result.addAll(roleSkuResultList);
                }
            }
            return result;
        }
        return null;
    }

    /**
     * 根据产品生产商Ids获取对应的产品生产商Sku
     *
     * @param codeGenerateParam
     * @return
     */
    @Override
    public Map<Long, String> getProducerProductSkusByIds(CodeGenerateParam codeGenerateParam) {
        List<SlpdProducerProduct> producerProducts = this.codeGenerateDao.getProducerProductsByIds(codeGenerateParam);
        Map<Long, String> resultMap = new HashMap<>();
        for (SlpdProducerProduct slpdProducerProduct : producerProducts) {
            resultMap.put(slpdProducerProduct.getProducerProductId(), slpdProducerProduct.getProducerProductSku());
        }
        return resultMap;
    }

    /**
     * 根据产品生产商Ids获取对应的产品生产商Code
     *
     * @param codeGenerateParam
     * @return
     */
    @Override
    public Map<Long, String> getProducerProductCodesByIds(CodeGenerateParam codeGenerateParam) {
        List<SlpdProducerProduct> producerProducts = this.codeGenerateDao.getProducerProductsByIds(codeGenerateParam);
        Map<Long, String> resultMap = new HashMap<>();
        for (SlpdProducerProduct slpdProducerProduct : producerProducts) {
            resultMap.put(slpdProducerProduct.getProducerProductId(), slpdProducerProduct.getProducerProductCode());
        }
        return resultMap;
    }

    /**
     * 根据制造商产品Ids获取对应的制造商产品Code
     *
     * @param codeGenerateParam
     * @return
     */
    @Override
    public Map<Long, String> getManufacturerProductCodesByIds(CodeGenerateParam codeGenerateParam) {
        List<SlpdManufacturerProduct> manufacturerProducts = this.codeGenerateDao.getManufacturerProductsByIds(codeGenerateParam);
        Map<Long, String> resultMap = new HashMap<>();
        for (SlpdManufacturerProduct manufacturerProduct : manufacturerProducts) {
            resultMap.put(manufacturerProduct.getManufacturerProductId(), manufacturerProduct.getManufacturerProductCode());
        }
        return resultMap;
    }

    /**
     * 根据entitySellerIds获取对应的entitySellerCode
     */
    @Override
    public Map<Long, String> getEntitySellerCodeByIds(CodeGenerateParam codeGenerateParam) {
        List<Long> entitySellerIds = codeGenerateParam.getEntitySellerIds();
        Map<String, Object> entitySellerMap = this.getEntitySellerCode(entitySellerIds);
        Map<Long, String> codeMap = new HashMap<>();
        if (null != entitySellerMap && null != entitySellerMap.get("data") && CollectionUtils.isNotEmpty((List<Map<String, Object>>) entitySellerMap.get("data"))) {
            List<Map<String, Object>> dataMap = (List<Map<String, Object>>) entitySellerMap.get("data");
            Long entitySellerIdResult = null;
            for (Long entitySellerId : entitySellerIds) {
                boolean flg = false;
                for (Map<String, Object> map : dataMap) {
                    entitySellerIdResult = Long.valueOf((Integer) map.get("entitySellerId"));
                    if (entitySellerId.longValue() == entitySellerIdResult.longValue()) {
                        codeMap.put(entitySellerId, (String) map.get("entitySellerCode"));
                        flg = true;
                    }
                }

                if (!flg) {
                    throw new BusinessException(MessageConstant.MODULE_NAME_EN, "无法为该卖方分类获取到对应的code");
                }
            }
        }
        return codeMap;
    }

    /**
     * 查询实体卖家信息
     *
     * @param entitySellerIds
     * @return
     */
    private Map<String, Object> getEntitySellerCode(List<Long> entitySellerIds) {
        SLIM0250IParam param = new SLIM0250IParam();
        param.setDelFlg(false);
        param.setPagination(null);
        param.setEntitySellerIds(entitySellerIds);
        //API调API
        String url = RestApiUtils.getUrl(ApiUrlConstant.SLIM.CONTEXT_PATH, ApiUrlConstant.SLIM.API0250, ApiUrlConstant.SLIM.LOCAL_FLAG, ApiUrlConstant.SLIM.LOCALHOST);
        TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {
        };

        HashMap<String, Object> result = this.restApiClientFactory.newApiRestClient().post(url, param, typeReference);
        return result;
    }


    /**
     * 获取初始SKU
     *
     * @param entitySellerIds
     * @return
     */
    private List<SLPDRoleSkuResult> getInitRoleSku(List<Long> entitySellerIds) {
        Map<String, Object> result = this.getEntitySellerCode(entitySellerIds);
        if (null != result && result.containsKey("data") && CollectionUtils.isNotEmpty((List<Map<String, Object>>) result.get("data"))) {
            List<Map<String, Object>> dataMap = (List<Map<String, Object>>) result.get("data");
            List<SLPDRoleSkuResult> skuResults = new ArrayList<>();
            SLPDRoleSkuResult roleSku = null;
            StringBuilder builder;
            for (Long entitySellerId : entitySellerIds) {
                String entitySellerCode = null;
                for (Map<String, Object> map : dataMap) {
                    if (null != map.get("entitySellerId") && entitySellerId.equals(Long.valueOf(map.get("entitySellerId").toString()))) {
                        entitySellerCode = map.get("entitySellerCode") == null ? null : String.valueOf(map.get("entitySellerCode"));
                        break;
                    }
                }
                if (StringUtils.isNotEmpty(entitySellerCode)) {
                    roleSku = new SLPDRoleSkuResult();
                    builder = new StringBuilder();
                    roleSku.setEntitySellerId(entitySellerId);
                    roleSku.setSku(builder.append(entitySellerCode).append("00000").toString());
                    skuResults.add(roleSku);
                }
            }
            return skuResults;
        }
        return null;
    }
}
