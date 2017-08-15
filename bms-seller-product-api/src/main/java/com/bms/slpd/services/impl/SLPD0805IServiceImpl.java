package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdSellerCommodity;
import com.bms.slpd.bean.param.SLPD0501IParam;
import com.bms.slpd.bean.param.SLPD0701IParam;
import com.bms.slpd.bean.param.SLPD0805IParam;
import com.bms.slpd.bean.param.SLPD1202IParam;
import com.bms.slpd.bean.result.field.*;
import com.bms.slpd.dao.SLPD0805IDao;
import com.bms.slpd.services.SLPD0501IService;
import com.bms.slpd.services.SLPD0701IService;
import com.bms.slpd.services.SLPD0805IService;
import com.bms.slpd.services.SLPD1202IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SLPD0805IServiceImpl extends BaseServiceImpl implements SLPD0805IService {

    @Autowired
    private CodeMasterUtils codeMasterUtils;
    @Autowired
    private SLPD0701IService slpd0701IService;
    @Autowired
    private SLPD0501IService slpd0501IService;
    @Autowired
    private SLPD1202IService slpd1202IService;
    @Autowired
    private SLPD0805IDao slpd0805IDao;

    @Override
    public BaseDao getBaseDao() {
        return this.slpd0805IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseRestPaginationResult<SLPD0805ICommodityResult> findSellerCommodities(SLPD0805IParam slpd0805IParam) {
        BaseRestPaginationResult<SlpdSellerCommodity> commodityIdResult = super.findPageList(slpd0805IParam);
        List<SlpdSellerCommodity> commodityIdList = commodityIdResult.getData();
        BaseRestPaginationResult<SLPD0805ICommodityResult> result = new BaseRestPaginationResult<>();
        if (CollectionUtils.isNotEmpty(commodityIdList)) {
            List<String> commodityIds = new ArrayList<>();
            for (SlpdSellerCommodity slpdSellerCommodity : commodityIdList) {
                commodityIds.add(slpdSellerCommodity.getCommodityId());
            }
            slpd0805IParam.setCommodityIds(commodityIds);
            List<SlpdSellerCommodity> restResult = this.slpd0805IDao.findCommoditiesById(slpd0805IParam);

            if (CollectionUtils.isNotEmpty(restResult)) {
                result = this.mappingRestResult(restResult);
                result.setTotal(commodityIdResult.getTotal());
            }
        }
        return result;
    }

    /**
     * 制作返回结果
     */
    private BaseRestPaginationResult<SLPD0805ICommodityResult> mappingRestResult(List<SlpdSellerCommodity> restDataList) {
        BaseRestPaginationResult<SLPD0805ICommodityResult> result = new BaseRestPaginationResult<>();
        Map<String, SLPD0805IProductResult> productMap = this.mappingProductResult(restDataList);
        Map<String, List<SLPD0805ILgcsResult>> lgcsMap = this.mappingLgcsResult(restDataList);

        SLPD0805ICommodityResult data = null;
        String commodityId = null;
//        String productId = null;
//        List<String> productIds = new ArrayList<>();
        List<SLPD0805ICommodityResult> dataList = new ArrayList<>();
//        int count = NumberConst.IntDef.INT_ZERO;
        List<String> commodityIds = new ArrayList<>();
        for (SlpdSellerCommodity commodity : restDataList) {
            commodityId = commodity.getCommodityId();
//            productId = commodity.getProductId();
            if (!commodityIds.contains(commodityId)) {
                data = new SLPD0805ICommodityResult();
                data.setCommodityId(commodityId);
                data.setSaleTitle(commodity.getSaleTitle());
                data.setLgcs(lgcsMap.get(commodityId));
                data.setProduct(productMap.get(commodity.getProductId()));
                dataList.add(data);
                commodityIds.add(commodityId);
//                productIds.add(productId);
//                ++count;
            }
        }
        //重新制作分页参数
//        result.setTotal(count);
        result.setData(dataList);
        return result;
    }

    /**
     * 制作物流区信息(map)
     */
    private Map<String, List<SLPD0805ILgcsResult>> mappingLgcsResult(List<SlpdSellerCommodity> resourceList) {
        //制作查询参数
        String commodityIdParam = null;
        List<String> commodityIds = new ArrayList<>();
        for (SlpdSellerCommodity commodity : resourceList) {
            commodityIdParam = commodity.getCommodityId();
            commodityIds.add(commodityIdParam);
        }
        SLPD1202IParam lgcsParam = new SLPD1202IParam();
        lgcsParam.setProductIds(commodityIds);
        lgcsParam.setPagination(null);

        //调用查询物流区商品接口
        BaseRestPaginationResult<SLPD1202ILgcsAreaCommodityResult> lgcsRestResult = slpd1202IService.findLgcsCommodities(lgcsParam);
        List<SLPD1202ILgcsAreaCommodityResult> lgcsResultList = lgcsRestResult.getData();

        //根据商品Id制作物流区商品map
        Map<String, List<SLPD0805ILgcsResult>> lgcsMap = new HashMap<>();
        List<SLPD0805ILgcsResult> lgcsList = null;
        SLPD0805ILgcsResult lgcsResult = null;
        String commodityId = null;
        for (SLPD1202ILgcsAreaCommodityResult lgcsAreaCommodityResult : lgcsResultList) {
            commodityId = lgcsAreaCommodityResult.getProductId();
//            lgcsResult = BeanUtils.toBean(lgcsAreaCommodityResult, SLPD0805ILgcsResult.class);
            lgcsResult = new SLPD0805ILgcsResult();
            lgcsResult.setLacId(lgcsAreaCommodityResult.getLacId());
            lgcsResult.setLgcsAreaCode(lgcsAreaCommodityResult.getLgcsAreaCode());
            lgcsResult.setLgcsAreaName(lgcsAreaCommodityResult.getLgcsAreaName());
            lgcsResult.setShelfStu(lgcsAreaCommodityResult.getShelfStu());
            if (!lgcsMap.containsKey(commodityId)) {
                lgcsList = new ArrayList<>();
                lgcsList.add(lgcsResult);
                lgcsMap.put(commodityId, lgcsList);
            } else {
                lgcsMap.get(commodityId).add(lgcsResult);
            }
        }

        return lgcsMap;
    }

    /**
     * 制作卖家单品品牌规格生产商基础信息(Map)
     */
    private Map<Long, List<SLPD0805ISellerResult>> mappingSellerResult(List<SlpdSellerCommodity> resourceList) {
        Map<Long, List<SLPD0805ISellerResult>> sellerMap = new HashMap<>();
        List<SLPD0805ISellerResult> sellerList = null;
        SLPD0805ISellerResult sellerResult = null;
        Long producerProductId = null;
        for (SlpdSellerCommodity slpdSellerCommodity : resourceList) {
            producerProductId = slpdSellerCommodity.getProducerProductId();
            sellerResult = BeanUtils.toBean(slpdSellerCommodity, SLPD0805ISellerResult.class);
            if (!sellerMap.containsKey(producerProductId)) {
                sellerList = new ArrayList<>();
                sellerList.add(sellerResult);
                sellerMap.put(producerProductId, sellerList);
            } else {
                sellerMap.get(producerProductId).add(sellerResult);
            }
        }
        return sellerMap;
    }

    /**
     * 制作产品基础信息(Map)
     */
    private Map<String, SLPD0805IProductResult> mappingProductResult(List<SlpdSellerCommodity> resourceList) {
        //制作查询产品的param
        List<String> productIds = new ArrayList<>();
        String productId = null;
        for (SlpdSellerCommodity slpdSellerCommodity : resourceList) {
            productId = slpdSellerCommodity.getProductId();
            //去重复productId
            if (!productIds.contains(productId)) {
                productIds.add(productId);
            }
        }
        SLPD0501IParam slpd0501IParam = new SLPD0501IParam();
        slpd0501IParam.setProductIds(productIds);

        //调用查询产品接口
        BaseRestPaginationResult<SLPD0501IProductResult> restResult = this.slpd0501IService.findProducts(slpd0501IParam);
        List<SLPD0501IProductResult> resultData = restResult.getData();

        //填充产品生产商信息,并制作产品map
        Map<String, List<SLPD0805IProducerProductResult>> producerProductMap = this.mappingProducerProductResult(resourceList);
        Map<String, SLPD0805IProductResult> productMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(resultData)) {
            List<SLPD0805IProducerProductResult> producerProductList = null;
            SLPD0805IProductResult productResult = null;
            for (SLPD0501IProductResult product : resultData) {
                //mapping产品的数据model
                productResult = BeanUtils.toBean(product, SLPD0805IProductResult.class);

                producerProductList = producerProductMap.get(product.getProductId());
                productResult.setProducerProduct(producerProductList);
                productMap.put(product.getProductId(), productResult);
            }
        }
        return productMap;
    }

    /**
     * 制作单品品牌规格生产商基础信息(Map)
     */
    private Map<String, List<SLPD0805IProducerProductResult>> mappingProducerProductResult(List<SlpdSellerCommodity> resourceList) {
        Map<Long, List<SLPD0805ISellerResult>> sellerMap = this.mappingSellerResult(resourceList);

        //制作查询产品生产商参数
        List<Long> producerProductIds = new ArrayList<>();
        Long producerProductId = null;
        for (SlpdSellerCommodity slpdSellerCommodity : resourceList) {
            producerProductId = slpdSellerCommodity.getProducerProductId();
            //去重复producerProductId
            if (!producerProductIds.contains(producerProductId)) {
                producerProductIds.add(producerProductId);
            }
        }
        SLPD0701IParam slpd0701IParam = new SLPD0701IParam();
        slpd0701IParam.setProducerProductIds(producerProductIds);

        //调用查询产品生产商接口
        BaseRestPaginationResult<SLPD0701IProducerProductResult> restResult = this.slpd0701IService.findProducerProducts(slpd0701IParam);
        List<SLPD0701IProducerProductResult> resultData = restResult.getData();

        //填充卖家信息,并制作产品生产商map
        Map<String, List<SLPD0805IProducerProductResult>> producerProductMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(resultData)) {
            SLPD0805IProducerProductResult producerProductResult = null;
            List<SLPD0805IProducerProductResult> dataList = null;
            List<SLPD0805ISellerResult> seller = null;
            SLPD0501IProductResult product = null;
            String productId = null;
            Long sellerKey = null;

            for (SLPD0701IProducerProductResult producerProduct : resultData) {
                //填充卖家
                sellerKey = producerProduct.getProducerProductId();
                seller = sellerMap.get(sellerKey);
                producerProductResult = BeanUtils.toBean(producerProduct, SLPD0805IProducerProductResult.class);
                producerProductResult.setSellerList(seller);

                product = producerProduct.getProduct();
                if (null != product && StringUtils.isNotEmpty(product.getProductId())) {
                    productId = product.getProductId();
                    if (!producerProductMap.containsKey(productId)) {
                        dataList = new ArrayList<>();
                        dataList.add(producerProductResult);
                        producerProductMap.put(productId, dataList);
                    } else {
                        producerProductMap.get(productId).add(producerProductResult);
                    }
                }
            }
        }
        return producerProductMap;
    }


    /**
     * 卖家单品品牌(规格)生产商添加中文常量
     *//*
    private void fillCodeMasters(List<SLPD0805ICommodityResult> sellerCommodities) {
        Map<String, String> auditStuMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.SellerCommodityAuditStu.NODE);
        Map<String, String> saleTypeMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.SaleType.NODE);

        for (SLPD0805ICommodityResult sellerCommodity : sellerCommodities) {
            sellerCommodity.setAuditStuStr(auditStuMap.get(sellerCommodity.getAuditStu()));
            sellerCommodity.setSaleTypeStr(saleTypeMap.get(sellerCommodity.getSaleType()));
        }
    }*/

}