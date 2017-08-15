package com.bms.slpd.services.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.slpd.bean.entity.SlpdProducerProduct;
import com.bms.slpd.bean.param.SLIM0250IParam;
import com.bms.slpd.bean.param.SLPD1804IParam;
import com.bms.slpd.bean.param.SLPD1805IParam;
import com.bms.slpd.bean.param.wrapper.SlpdProductProducerParam;
import com.bms.slpd.bean.result.SLPD0702IResult;
import com.bms.slpd.bean.result.field.SLPD1804IProductResult;
import com.bms.slpd.bean.result.field.SLPD1805IProductProducerResult;
import com.bms.slpd.bean.result.field.SLPDRoleSkuResult;
import com.bms.slpd.constant.ApiUrlConstant;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0702IDao;
import com.bms.slpd.services.CodeGenerateService;
import com.bms.slpd.services.SLPD0702IService;
import com.bms.slpd.services.SLPD1804IService;
import com.bms.slpd.services.SLPD1805IService;
import com.bms.slpd.utils.RestApiUtils;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service
public class SLPD0702IServiceImpl extends BaseServiceImpl implements SLPD0702IService {

    @Autowired
    private SLPD1804IService slpd1804IService;

    @Autowired
    private SLPD1805IService slpd1805IService;

    @Autowired
    private SLPD0702IDao slpd0702IDao;

    @Autowired
    private CodeGenerateService codeGenerateService;

    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @Override
    public BaseDao getBaseDao() {
        return slpd0702IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0702IResult saveProducerProducts(List<SlpdProductProducerParam> insertList) {
        String userId = super.getLoginUserId();
        Date now = DateUtils.getCurrent();

        List<SlpdProducerProduct> producerProductList = new ArrayList<>();
        List<Long> producerProductIds = new ArrayList<>();
        SlpdProducerProduct producerProduct = null;

        //判他
        List<String> productIds = new ArrayList<>();
        List<Long> entitySellerIds = new ArrayList<>();
        for (SlpdProductProducerParam param : insertList) {
            productIds.add(param.getProductId());
            entitySellerIds.add(param.getEntitySellerId());
        }
        SLPD1805IParam slpd1805IParam = new SLPD1805IParam();
        slpd1805IParam.setProductIds(productIds);
        slpd1805IParam.setEntitySellerIds(entitySellerIds);
        BaseRestPaginationResult<SLPD1805IProductProducerResult> producerProducts = slpd1805IService.findProductProducers(slpd1805IParam);
        StringBuilder producerProductStr = new StringBuilder();
        if (CollectionUtils.isNotEmpty(producerProducts.getData())) {
            for (SLPD1805IProductProducerResult producerProductResult : producerProducts.getData()) {
                producerProductStr.append(producerProductResult.getEntitySellerId()).append("--").append(producerProductResult.getProductId()).append(",");
            }
        }
        if (!ObjectUtils.isEmpty(producerProductStr)) {
            //throw new BusinessException(MessageConstant.MODULE_SHORT_NAME_EN, producerProductStr.append("entitySellerId--productId已存在,保存失败").toString());
            throw new BusinessException(MessageConstant.MODULE_SHORT_NAME_EN, "选择的产品和生产商已建立关系");
        }

        //获取code
        Map<String, Object> map = this.getProducerProductMap(insertList);

        SLPD1804IProductResult productResult = (SLPD1804IProductResult) map.get("productData");
        JSONArray jsonArray = (JSONArray) map.get("sellerData");

        List<SLPDRoleSkuResult> skuResults = codeGenerateService.getRoleSku(entitySellerIds);

        String brandItemPropertySku = null;
        String entitySellerCode = null;
        String producerProductCode = null;
        String producerProductSku = null;
        Map<Long, Object> skuMap = new HashMap<>();

        for (SlpdProductProducerParam param : insertList) {
            producerProduct = BeanUtils.toBean(param, SlpdProducerProduct.class);
            producerProduct.setProducerProductId(this.maxId(TableConstant.Name.SLPD_PRODUCER_PRODUCT));

            //单品品牌规格生产商Code（26位）：单品品牌规格Sku（18位）+ 实体卖家Code(8位)
            if (param.getProductId().equals(productResult.getProductId())) {
                brandItemPropertySku = productResult.getBrandItemPropertySku();
            }

            for (Object object : jsonArray) {
                Map<String, Object> sellerMap = (Map) object;
                if (param.getEntitySellerId().equals(Long.valueOf(sellerMap.get("entitySellerId").toString()))) {
                    entitySellerCode = String.valueOf(sellerMap.get("entitySellerCode"));
                }
            }
            producerProductCode = brandItemPropertySku + entitySellerCode;
            producerProduct.setProducerProductCode(producerProductCode);

            //获取Sku
            if (skuMap.get(param.getEntitySellerId()) != null) {
                producerProductSku = (String) skuMap.get(param.getEntitySellerId());
            } else {
                for (SLPDRoleSkuResult roleResult : skuResults) {
                    if (roleResult.getEntitySellerId().equals(param.getEntitySellerId())) {
                        producerProductSku = roleResult.getSku();
                    }
                }
            }
            Long intSku = Long.valueOf(producerProductSku) + 1;
            producerProductSku = String.format("%013d", intSku);
            skuMap.put(param.getEntitySellerId(), producerProductSku);

            producerProduct.setProducerProductSku(producerProductSku);
            producerProduct.setAuditStu(CodeMasterConstant.ProducerProductAuditStu.UNREGISTERED);
            producerProduct.setCrtId(userId);
            producerProduct.setCrtTime(now);
            producerProduct.setUpdId(userId);
            producerProduct.setUpdTime(now);
            producerProduct.setAuditHistory("auditHistory");
            producerProductList.add(producerProduct);
            producerProductIds.add(producerProduct.getProducerProductId());
        }

        int count = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(producerProductList)) {
            count = slpd0702IDao.saveProducerProducts(producerProductList);
        }

        SLPD0702IResult result = new SLPD0702IResult();
        result.setCount(count);
        result.setProducerProductIds(producerProductIds);
        return result;
    }

    /**
     * 获取单品品牌规格生产商Code
     *
     * @return producerProductCode
     */
    private Map<String, Object> getProducerProductMap(List<SlpdProductProducerParam> insertList) {
        Map<String, Object> map = new HashMap<>();

        List<String> productIds = new ArrayList<>();
        List<Long> entitySellerIds = new ArrayList<>();
        for (SlpdProductProducerParam param : insertList) {
            productIds.add(param.getProductId());
            entitySellerIds.add(param.getEntitySellerId());
        }

        SLPD1804IParam slpd1804iParam = new SLPD1804IParam();
        slpd1804iParam.setProductIds(productIds);

        BaseRestPaginationResult<SLPD1804IProductResult> productData = slpd1804IService.findProducts(slpd1804iParam);

        map.put("productData", productData.getData().get(NumberConst.IntDef.INT_ZERO));

        SLIM0250IParam param = new SLIM0250IParam();
        param.setDelFlg(false);
        param.setPagination(null);
        param.setRoleId(CodeMasterConstant.SellerRoleType.PRODUCER);
        param.setEntitySellerIds(entitySellerIds);

        //API调API
        String url = RestApiUtils.getUrl(ApiUrlConstant.SLIM.CONTEXT_PATH, ApiUrlConstant.SLIM.API0250, ApiUrlConstant.SLIM.LOCAL_FLAG, ApiUrlConstant.SLIM.LOCALHOST);
        TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {
        };

        HashMap<String, Object> sellerData = this.restApiClientFactory.newApiRestClient().post(url, param, typeReference);

        map.put("sellerData", sellerData.get("data"));

        return map;
    }

}
