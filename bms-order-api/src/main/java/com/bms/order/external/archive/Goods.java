package com.bms.order.external.archive;

import com.alibaba.fastjson.TypeReference;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.constant.UrlConst;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.external.bean.entity.GoodsEntity;
import com.bms.order.external.bean.param.COMO0203IRestParam;
import com.bms.order.external.bean.param.COMO0307IRestParam;
import com.bms.order.external.bean.result.COMO0203IRestResult;
import com.bms.order.external.bean.result.COMO0307ProductDetailIRestResult;
import com.bms.order.external.bean.result.COMO0307ProductIRestResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品
 *
 * @author li_huiqian
 */
public class Goods extends AbstractExternalArchive {

    /**
     * 商品Entity
     */
    private GoodsEntity entity;

    public GoodsEntity getEntity() {
        return entity;
    }

    private Goods() {
    }

    /**
     * 根据商品ID，卖家ID，生产商ID唯一确定一个商品
     *
     * @param goodsId
     * @param sellerId
     * @param manufacturerId
     * @return
     */
    public static Goods findBy3Id(String goodsId, String sellerId, Long manufacturerId) {
        return Goods.findGoodsBy3Id(goodsId, sellerId, manufacturerId);
    }

    /**
     * 根据商品ID，卖家ID，生产商ID唯一确定一个商品
     *
     * @param goodsId
     * @param sellerId
     * @param manufacturerId
     * @return
     */
    private static Goods findGoodsBy3Id(String goodsId, String sellerId, Long manufacturerId) {
        Assert.hasText(goodsId);
        Assert.hasText(sellerId);
        Assert.isTrue(manufacturerId > 0);
        // 获取URL
        String url = UrlConst.API_COMO_URL + UrlConst.ACTION_COMO307I;
        COMO0307IRestParam param = new COMO0307IRestParam();
        param.setCommodityId(new String[]{goodsId});
        param.setOwnerId(new Long[]{new Long(sellerId)});
        param.setProducerId(new Long[]{manufacturerId});
        //  param.setOwnerTypeId();// 卖家id  todo  确定的卖家id
        TypeReference<BaseRestPaginationResult<COMO0307ProductIRestResult>> typeReference = new TypeReference<BaseRestPaginationResult<COMO0307ProductIRestResult>>() {
        };
        Goods goods = new Goods();
        // 调用接口（使用关联对象的rest client）
        BaseRestPaginationResult<COMO0307ProductIRestResult> paginationResult = goods.getRestClient().post(url, param,
                typeReference);
        // 判断检索结果
        if (paginationResult.getTotal() == 0) {
            return null;
        } else if (paginationResult.getTotal() > 1) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "通过一个商品ID，卖家ID，生产商ID查找到多个商品");
        }
        COMO0307ProductIRestResult result = paginationResult.getData().get(0);
        goods.entity = Goods.convert0307(result);
        goods.setDataSynced(true);
        return goods;
    }

    /**
     * 根据商品ID查询商品信息列表
     *
     * @param goodsIds
     * @return
     */
    private static List<Goods> findByGoodsIds(List<String> goodsIds, Long lgcsAreaId) {
        Assert.notEmpty(goodsIds);
        // 获取URL
        String url = UrlConst.API_COMO_URL + UrlConst.ACTION_COMO307I;
        COMO0307IRestParam param = new COMO0307IRestParam();
        param.setCommodityId(goodsIds.toArray(new String[goodsIds.size()]));
        TypeReference<SearchRestResult<COMO0307ProductIRestResult>> typeReference = new TypeReference<SearchRestResult<COMO0307ProductIRestResult>>() {
        };
        Goods goods = new Goods();
        // 调用接口（使用关联对象的rest client）
        SearchRestResult<COMO0307ProductIRestResult> paginationResult = goods.getRestClient().post(url, param, typeReference);

        List<Goods> list = new ArrayList<>();
        // 判断检索结果
        if (paginationResult.getTotal() != 0) {
            List<COMO0307ProductIRestResult> results = paginationResult.getData();
            for (COMO0307ProductIRestResult result : results) {
                goods = new Goods();
                goods.entity = Goods.convert0307(result);
                goods.setDataSynced(true);
                list.add(goods);
            }
        }

        return list;
    }


    /**
     * 根据商品ID查询商品信息列表
     *
     * @param goodsIds
     * @return
     */
    public static List<Goods> findByIds(List<String> goodsIds, Long lgcsAreaId) {
        return Goods.findByGoodsIds(goodsIds, lgcsAreaId);
    }


    /**
     * goodsId:COMO0307ProductIRestResult=1:1
     *
     * @param goods
     * @return
     */

    private static GoodsEntity convert0307(COMO0307ProductIRestResult goods) {
        GoodsEntity entity = new GoodsEntity();

        entity.setGoodsId(StringUtils.toStr(goods.getCommodityId()));
        entity.setItemBrandCode(goods.getBrandItemPropertySku());
        entity.setCartonSize(goods.getCartonDimension());
        entity.setProductLevel(goods.getQualityGradeTypeCode());
        entity.setProductLevelName(goods.getQualityGradeTypeName());
        entity.setProductId(goods.getProductId());
        entity.setItemId(goods.getItemId());
        entity.setItemCode(goods.getItemCode());
        entity.setItemName(goods.getItemName());
        entity.setBrandCode(goods.getBrandCode());
        entity.setBrandName(goods.getBrandName());
        if (CollectionUtils.isNotEmpty(goods.getDetailList())) {
            Map producerMap = new HashMap<>();
            for (COMO0307ProductDetailIRestResult detailIRestResult :goods.getDetailList()) {
                producerMap.put(detailIRestResult.getProducerId(),detailIRestResult);
            }

            if (producerMap.size() == 1) {
                entity.setManufacturerId(Long.parseLong(goods.getDetailList().get(0).getProducerId()));
                entity.setManufacturerCode(goods.getDetailList().get(0).getProducerCode());
                entity.setManufacturerName(goods.getDetailList().get(0).getProducerName());
            }
        }
        entity.setQuantityPerPackage(goods.getPackageQuantity());
        entity.setNetWeight(goods.getNetWeight());
        entity.setGrossWeight(goods.getGrossWeight());
        entity.setPalletStandardStackQuantity(goods.getPalletStackingLimit());
        String sku = null;
        List<COMO0307ProductDetailIRestResult> detailList = goods.getDetailList();
        if (CollectionUtils.isNotEmpty(detailList)) {
            if (detailList.size() == 1) {
                COMO0307ProductDetailIRestResult detail = detailList.get(0);
                sku = detail.getSkuCode();
            }
        }
        entity.setSku(sku);

        entity.setGoodsCode(goods.getCommodityCode());
        entity.setGoodsName(goods.getCommodityName());
        entity.setSaleLabelId(goods.getSaleStatusId());
        entity.setSaleLabelCode(goods.getSaleStatusCode());
        entity.setSaleLabelName(goods.getSaleStatusName());
        entity.setSmallPackageFeature(goods.getPackageSpecification());

        entity.setSellerId(null);
        entity.setSellerCode(null);
        entity.setSellerName(null);
        entity.setBatchCode(null);
        entity.setBatchId(null);
        entity.setSellSideId(null);
        entity.setSellSideCode(null);
        entity.setSellSideName(null);
        return entity;
    }


    /**
     * 根据单品ID查询品牌不同的商品信息列表（行权用）
     *
     * @param itemIds
     * @return
     */
    public static List<Goods> findByItemIds(List<String> itemIds) {
        Assert.notEmpty(itemIds);
        // 获取URL
        String url = UrlConst.API_COMO_URL + UrlConst.ACTION_COMO203I;
        COMO0203IRestParam param = new COMO0203IRestParam();
        param.setItemIds(itemIds);
        TypeReference<SearchRestResult<COMO0203IRestResult>> typeReference = new TypeReference<SearchRestResult<COMO0203IRestResult>>() {
        };
        Goods goods = new Goods();
        // 调用接口（使用关联对象的rest client）
        SearchRestResult<COMO0203IRestResult> paginationResult = goods.getRestClient().post(url, param, typeReference);

        List<Goods> list = new ArrayList<>();
        // 判断检索结果
        if (paginationResult.getTotal() != 0) {
            List<COMO0203IRestResult> results = paginationResult.getData();
            for (COMO0203IRestResult result : results) {
                goods = new Goods();
                GoodsEntity entity = new GoodsEntity();
                entity.setGoodsId(StringUtils.toStr(result.getCommodityId()));
                entity.setItemId(result.getItemId());
                goods.entity = entity;
//                goods.entity = Goods.convert0307(result);
//                goods.setDataSynced(true);
                goods.setDataSynced(true);
                list.add(goods);
            }
        }
        return list;
    }
}
