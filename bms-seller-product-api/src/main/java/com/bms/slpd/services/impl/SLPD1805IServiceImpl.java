package com.bms.slpd.services.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.slpd.bean.entity.SlpdBrandOwner;
import com.bms.slpd.bean.param.SLIM0250IParam;
import com.bms.slpd.bean.param.SLPD1805IParam;
import com.bms.slpd.bean.result.field.SLPD0501IBrandResult;
import com.bms.slpd.bean.result.field.SLPD0501IProductResult;
import com.bms.slpd.bean.result.field.SLPD1805IProductProducerResult;
import com.bms.slpd.constant.ApiUrlConstant;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.dao.SLPD1805IDao;
import com.bms.slpd.services.SLPD1805IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.bms.slpd.utils.RestApiUtils;
import com.framework.base.consts.NumberConst;
import com.framework.base.consts.StringConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SLPD1805IServiceImpl extends BaseServiceImpl implements SLPD1805IService {

    @Autowired
    private CodeMasterUtils codeMasterUtils;
    @Autowired
    private SLPD1805IDao slpd1805iDao;
    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @Override
    public BaseDao getBaseDao() {
        return this.slpd1805iDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseRestPaginationResult<SLPD1805IProductProducerResult> findProductProducers(SLPD1805IParam slpd1805iParam) {
        BaseRestPaginationResult<SLPD1805IProductProducerResult> restResult = super.findPageList(slpd1805iParam);
        this.fillSpecifiedFields(restResult.getData());
        return restResult;
    }

    /**
     * 补充指定数据
     */
    private void fillSpecifiedFields(List<SLPD1805IProductProducerResult> products) {
        if (CollectionUtils.isNotEmpty(products)) {
            this.fillEntitySellers(products);
            this.fillBrandOwners(products);
            this.fillCodeMasters(products);
        }
    }

    /**
     * 产品生产商添加卖家实体信息
     */
    private void fillEntitySellers(List<SLPD1805IProductProducerResult> products) {
        List<Long> entitySellerIds = new ArrayList<>();

        for (SLPD1805IProductProducerResult product : products) {
            entitySellerIds.add(product.getEntitySellerId());
        }

        SLIM0250IParam param = new SLIM0250IParam();
        param.setDelFlg(false);
        param.setPagination(null);
        param.setRoleId(CodeMasterConstant.SellerRoleType.PRODUCER);
        param.setEntitySellerIds(entitySellerIds);

        //API调API
        String url = RestApiUtils.getUrl(ApiUrlConstant.SLIM.CONTEXT_PATH,ApiUrlConstant.SLIM.API0250,ApiUrlConstant.SLIM.LOCAL_FLAG,ApiUrlConstant.SLIM.LOCALHOST);
        TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {};

        HashMap<String, Object> data = this.restApiClientFactory.newApiRestClient().post(url, param, typeReference);
        if (null == data || data.size() <= NumberConst.IntDef.INT_ZERO || null == data.get("data")) {
            return;
        }
        JSONArray jsonArray = (JSONArray) data.get("data");
        String entitySellerCode = null;
        String fullName = null;
        for (SLPD1805IProductProducerResult product : products) {
            for (Object object : jsonArray) {
                Map<String, Object> map = (Map) object;
                if (product.getEntitySellerId().equals(Long.valueOf(map.get("entitySellerId").toString()))) {
                    entitySellerCode = String.valueOf(map.get("entitySellerCode"));
                    fullName = String.valueOf(map.get("fullName"));
                }
            }
            product.setEntitySellerCode(entitySellerCode);
            product.setFullName(fullName);
        }
    }

    /**
     * 生产商产品对象添加品牌所有人
     */
    @SuppressWarnings("unchecked")
    private void fillBrandOwners(List<SLPD1805IProductProducerResult> products) {
        Map<Long, List<SlpdBrandOwner>> bidOwnersMap = this.mappingBrandIdToBrandOwners(products);
        if (bidOwnersMap == null || bidOwnersMap.size() == NumberConst.IntDef.INT_ZERO) {
            return;
        }

        Long brandId = null;
        List<SlpdBrandOwner> brandOwners = null;

        for (SLPD1805IProductProducerResult product : products) {
            brandId = product.getBrandId();
            brandOwners = bidOwnersMap.get(brandId);
            product.setBrandOwnerList(brandOwners);
            product.setOwnersName(this.appendBrandOwnerNames(brandOwners));
        }
    }

    /**
     * 品牌ID映射品牌所有人
     */
    @SuppressWarnings({"Duplicates", "unchecked"})
    private Map<Long, List<SlpdBrandOwner>> mappingBrandIdToBrandOwners(List<SLPD1805IProductProducerResult> products) {
        List<Map<String, Object>> bidOwnerMaps = this.findBrandOwnersByBrandIds(products);
        if (CollectionUtils.isEmpty(bidOwnerMaps)) {
            return null;
        }

        Map<Long, List<SlpdBrandOwner>> bidOwnersMap = new HashMap<>();
        List<SlpdBrandOwner> brandOwners = null;
        Long brandId = null;
        SlpdBrandOwner brandOwner = null;

        for (Map<String, Object> bidOwnerMap : bidOwnerMaps) {
            brandId = Long.valueOf(String.valueOf(bidOwnerMap.get("brandId")));
            brandOwner = (SlpdBrandOwner) bidOwnerMap.get("brandOwner");

            if (bidOwnersMap.containsKey(brandId)) {
                brandOwners = bidOwnersMap.get(brandId);
                brandOwners.add(brandOwner);
            } else {
                brandOwners = new LinkedList<>();
                brandOwners.add(brandOwner);
                bidOwnersMap.put(brandId, brandOwners);
            }
        }
        return bidOwnersMap;
    }

    /**
     * 根据品牌ID，批量查询品牌所有人
     */
    private List<Map<String, Object>> findBrandOwnersByBrandIds(List<SLPD1805IProductProducerResult> products) {
        Set<Long> brandIdSet = new HashSet<>();
        for (SLPD1805IProductProducerResult product : products) {
            brandIdSet.add(product.getBrandId());
        }

        if (CollectionUtils.isEmpty(brandIdSet)) {
            return null;
        }
        List<Long> brandIdList = new LinkedList<>(brandIdSet);
        return this.slpd1805iDao.findBrandOwnersByBrandIds(brandIdList);
    }

    /**
     * 拼接品牌所有人名称
     */
    private String appendBrandOwnerNames(List<SlpdBrandOwner> brandOwners) {
        if (CollectionUtils.isEmpty(brandOwners)) {
            return StringConst.EMPTY;
        }

        StringBuilder ownersName = new StringBuilder();
        for (SlpdBrandOwner brandOwner : brandOwners) {
            ownersName.append(brandOwner.getOwnerName()).append(StringConst.COMMA);
        }
        return ownersName.substring(NumberConst.IntDef.INT_ZERO, ownersName.lastIndexOf(StringConst.COMMA));
    }

    /**
     * 产品生产商添加中文常量
     */
    private void fillCodeMasters(List<SLPD1805IProductProducerResult> products) {
        Map<String, String> qualityGradeTypeMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.QualityGradeType.NODE);
        Map<String, String> auditStuMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.AuditStu.NODE);
        Map<String, String> productSourceTypeMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.ProductSourceType.NODE);
        Map<String, String> brandTypeMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.BrandType.NODE);

        for (SLPD1805IProductProducerResult product : products) {
            product.setQualityGradeTypeStr(qualityGradeTypeMap.get(product.getQualityGradeType()));
            product.setAuditStuStr(auditStuMap.get(product.getAuditStu()));
            product.setProductAuditStuStr(auditStuMap.get(product.getProductAuditStu()));
            product.setSourceTypeStr(productSourceTypeMap.get(product.getSourceType()));
            product.setQualityGradeTypeStr(qualityGradeTypeMap.get(product.getQualityGradeType()));
            product.setBrandTypeStr(brandTypeMap.get(product.getBrandType()));
        }
    }

}