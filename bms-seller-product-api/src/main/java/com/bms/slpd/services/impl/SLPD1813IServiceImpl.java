package com.bms.slpd.services.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.slpd.bean.param.SLIM0250IParam;
import com.bms.slpd.bean.param.SLPD1813IParam;
import com.bms.slpd.bean.result.field.SLPD1805IProductProducerResult;
import com.bms.slpd.constant.ApiUrlConstant;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.dao.SLPD1813IDao;
import com.bms.slpd.services.SLPD1813IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.bms.slpd.utils.RestApiUtils;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SLPD1813IServiceImpl extends BaseServiceImpl implements SLPD1813IService {

    @Autowired
    private CodeMasterUtils codeMasterUtils;
    @Autowired
    private SLPD1813IDao slpd1813iDao;
    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @Override
    public BaseDao getBaseDao() {
        return this.slpd1813iDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseRestPaginationResult<SLPD1805IProductProducerResult> findProductProducers(SLPD1813IParam slpd1813iParam) {
        BaseRestPaginationResult<SLPD1805IProductProducerResult> restResult = super.findPageList(slpd1813iParam);
        this.fillSpecifiedFields(restResult.getData());
        return restResult;
    }

    /**
     * 补充指定数据
     */
    private void fillSpecifiedFields(List<SLPD1805IProductProducerResult> products) {
        if (CollectionUtils.isNotEmpty(products)) {
            this.fillEntitySellers(products);
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

            product.setSourceTypeStr(productSourceTypeMap.get(product.getSourceType()));
            product.setQualityGradeTypeStr(qualityGradeTypeMap.get(product.getQualityGradeType()));
            product.setBrandTypeStr(brandTypeMap.get(product.getBrandType()));
        }
    }

}