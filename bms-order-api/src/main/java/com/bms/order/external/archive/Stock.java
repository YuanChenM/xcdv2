package com.bms.order.external.archive;

import com.alibaba.fastjson.TypeReference;
import com.bms.order.bean.param.LINV0104IParam;
import com.bms.order.constant.UrlConst;
import com.bms.order.constant.enumeration.*;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.external.bean.entity.StockEntity;
import com.bms.order.external.bean.param.*;
import com.bms.order.external.bean.result.*;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.*;

/**
 * 库存 Created by ni_shaotang on 2017/3/2.
 */
public class Stock extends AbstractExternalArchive {
    private StockEntity entity;

    public StockEntity getEntity() {
        return entity;
    }

    private Stock() {
    }

    /** 销售平台 P01:云冻品平台 */
    public static final String SALE_PLATFORM_YDP = "P01";
    /** 库存类型 I01：正常库存 */
    public static final String IV_TYPE_NORMAL = "I01";
    /** 业务源 ORDR：订单 */
    public static final String TRANSACTION_SOURCE_ORDR = "ORDR";
    /** 占用类型 001：销售占用 */
    public static final String ALLOCATE_TYPE_SALE = "001";
    /** 占用类型 002：实货囤货占用 */
    public static final String ALLOCATE_TYPE_STORE = "002";
    /** 仓库Id 目前固定：1 */
    public static final Long WH_ID = 1l;
    /** 货主类型 H01：平台卖家 */
    public static final String OWNER_TYPE_SELLER = "H01";
    /**占用类型 L01 : 平台库存占用*/
    public static final String ALOC_TYPE_PLATFORM = "L01";
    /** 占用类型 L02 : 普通占用 */
    public static final String ALOC_TYPE_NORMAL = "L05";
    /** 占用类型 L03 : 货主商品占用 */
    public static final String ALOC_TYPE_OWNER = "L06";

    /**
     * 下单时，查询商品库存
     *
     * @param logisticsId
     * @param goodsIds
     * @return
     */
    public static List<StockEntity> QueryCommInv(String logisticsId, String[] goodsIds, String bsId) {
        Assert.hasText(logisticsId);
        Assert.isTrue(goodsIds.length > 0);
        List<StockEntity> list = new ArrayList<>();
        StockEntity entity = new StockEntity();
        // 获取URL
        String url = UrlConst.API_LINV_URL + UrlConst.ACTION_LINV0012I;
        LINV0012IRestParam param = new LINV0012IRestParam();
        param.setLogisticsId(new String[]{logisticsId});
        param.setCommodityId(goodsIds);
        if (StringUtils.isNotEmpty(bsId)) {
            param.setSaleId(new String[]{bsId});
        }
        TypeReference<BaseRestPaginationResult<LINV0012IRestResult>> typeReference = new TypeReference<BaseRestPaginationResult<LINV0012IRestResult>>() {
        };
        Stock stock = new Stock();
        BaseRestPaginationResult<LINV0012IRestResult> result = stock.getRestClient().post(url, param, typeReference);
        if (null == result) {
            return list;
        }
        if (null == result.getData() || result.getTotal() == 0) {
            return list;
        }
        for (LINV0012IRestResult inv : result.getData()) {
            entity = new StockEntity();
            entity.setGoodsId(inv.getCommodityId());
            entity.setAvailableQty(inv.getAvailableQty());
            entity.setLogisticsZoneId(Long.valueOf(inv.getLogisticsId()));
            list.add(entity);
        }
        return list;
    }

    /**
     * 生产商库存查询
     *
     * @param logisticsId
     * @param goodsIds
     * @return
     */
    public static List<StockEntity> QueryPdrsInv(String logisticsId, String[] goodsIds) {
        Assert.hasText(logisticsId);
        Assert.isTrue(goodsIds.length > 0);
        List<StockEntity> list = new ArrayList<>();
        StockEntity entity = new StockEntity();
        // 获取URL
        String url = UrlConst.API_LINV_URL + UrlConst.ACTION_LINV0013I;
        LINV0013IRestParam param = new LINV0013IRestParam();
        param.setLogisticsId(new String[]{logisticsId});
        param.setCommodityId(goodsIds);
        param.setIvType(new String[]{IV_TYPE_NORMAL});
        param.setSalesPlatform(new String[]{SALE_PLATFORM_YDP});
        TypeReference<BaseRestPaginationResult<LINV0013IRestResult>> typeReference = new TypeReference<BaseRestPaginationResult<LINV0013IRestResult>>() {
        };
        Stock stock = new Stock();
        BaseRestPaginationResult<LINV0013IRestResult> result = stock.getRestClient().post(url, param, typeReference);
        if (null == result) {
            return list;
        }
        if (null == result.getData() || result.getTotal() == 0) {
            return list;
        }
        for (LINV0013IRestResult inv : result.getData()) {
            entity = new StockEntity();
            entity.setGoodsId(inv.getCommodityId());
            entity.setAvailableQty(inv.getAvailableQty());
            entity.setLogisticsZoneId(Long.valueOf(inv.getLogisticsId()));
            list.add(entity);
        }
        return list;
    }

    /**
     * 发货
     *
     * @param paramList
     * @return
     */
    public static void DispatchLoad(ArrayList<LinvRestParam> paramList) {
        Assert.isTrue(paramList.size() > 0);
        ArrayList<LINV0102IInvParam> params = convertStockTo0102(paramList);
        String url = UrlConst.API_LINV_URL + UrlConst.ACTION_LINV0102I;
        TypeReference<String> typeReference = new TypeReference<String>() {
        };
        Stock stock = new Stock();
        stock.getRestClient().post(url, params, typeReference);
    }

    /**
     * 平台商品占用
     *
     * @param paramList
     * @return
     */
    public static void AllocateCommInv(ArrayList<StockRestParam> paramList) {
        Assert.isTrue(paramList.size() > 0);
        ArrayList<LINV0006IRestParam> params = convertStockTo006(paramList);
        String url = UrlConst.API_LINV_URL + UrlConst.ACTION_LINV0006I;
        TypeReference<ArrayList<LINV0006IRestResult>> typeReference = new TypeReference<ArrayList<LINV0006IRestResult>>() {
        };
        Stock stock = new Stock();
        stock.getRestClient().post(url, params, typeReference);
    }

    /**
     * 普通库存占用
     *
     * @param paramList
     * @return
     */
    public static String AllocateInv(ArrayList<StockRestParam> paramList) {
        Assert.isTrue(paramList.size() > 0);
        String message = "";
        ArrayList<LINV0007IRestParam> params = convertStockTo007(paramList);
        String url = UrlConst.API_LINV_URL + UrlConst.ACTION_LINV0007I;
        TypeReference<ArrayList<LINV0007IRestResult>> typeReference = new TypeReference<ArrayList<LINV0007IRestResult>>() {
        };
        Stock stock = new Stock();
        List<LINV0007IRestResult> resultList = stock.getRestClient().post(url, params, typeReference);
        for (LINV0007IRestResult result : resultList) {
            String[] messages = result.getMessage();
            message = messages[0];
        }
        return message;
    }

    /**
     * 占用取消
     *
     * @param paramList
     * @return
     */
    public static void ReleaseAllocation(List<StockRestParam> paramList) {
        Assert.isTrue(paramList.size() > 0);
        ArrayList<LINV0008IRestParam> params = convertStockTo008(paramList);
        String url = UrlConst.API_LINV_URL + UrlConst.ACTION_LINV0008I;
        TypeReference<String> typeReference = new TypeReference<String>() {
        };
        Stock stock = new Stock();
        stock.getRestClient().post(url, params, typeReference);
    }

    /**
     * 实货囤货释放
     *
     * @param paramList
     * @return
     */
    public static void StoreRelease(ArrayList<LinvRestParam> paramList) {
        Assert.isTrue(paramList.size() > 0);
        ArrayList<LINV0106IParam> params = convertStockTo0106(paramList);
        String url = UrlConst.API_LINV_URL + UrlConst.ACTION_LINV0106I;
        TypeReference<String> typeReference = new TypeReference<String>() {
        };
        Stock stock = new Stock();
        stock.getRestClient().post(url, params, typeReference);
    }

    /**
     * 实货囤货释放
     *
     * @param paramList
     * @return
     */
    public static void BuyerReturn(ArrayList<LinvRestParam> paramList) {
        Assert.isTrue(paramList.size() > 0);
        ArrayList<LINV0106IParam> params = convertBuyerReturnTo0106(paramList);
        String url = UrlConst.API_LINV_URL + UrlConst.ACTION_LINV0106I;

        TypeReference<String> typeReference = new TypeReference<String>() {
        };
        Stock stock = new Stock();
        stock.getRestClient().post(url, params, typeReference);
    }

    /**
     * 货权人商品交易完成
     *
     * @param paramList
     * @return
     */
    public static void StoreObtain(ArrayList<LinvRestParam> paramList) {
        Assert.isTrue(paramList.size() > 0);
        ArrayList<LINV0105IInvParam> params = new ArrayList<>();
        for (LinvRestParam linvRestParam : paramList) {
            LINV0105IInvParam param = convertStockTo0105(linvRestParam);
            params.add(param);
        }
        String url = UrlConst.API_LINV_URL + UrlConst.ACTION_LINV0105I;
        TypeReference<String> typeReference = new TypeReference<String>() {
        };
        Stock stock = new Stock();
        stock.getRestClient().post(url, params, typeReference);
    }

    /**
     * 货主商品占用
     *
     * @param paramList
     * @return
     */
    public static void AllocateOwCommInv(ArrayList<LinvRestParam> paramList) {
        Assert.isTrue(paramList.size() > 0);
        ArrayList<LINV0107IParam> params = convertStockTo0107(paramList);
        String url = UrlConst.API_LINV_URL + UrlConst.ACTION_LINV0107I;
        TypeReference<String> typeReference = new TypeReference<String>() {
        };
        Stock stock = new Stock();
        stock.getRestClient().post(url, params, typeReference);
    }

    /**
     * 转义发货参数
     *
     * @param paramList
     * @return
     */
    private static ArrayList<LINV0102IInvParam> convertStockTo0102(ArrayList<LinvRestParam> paramList) {
        ArrayList<LINV0102IInvParam> params = new ArrayList<>();
        for (LinvRestParam linvRestParam : paramList) {
            LINV0102IInvParam param = new LINV0102IInvParam();
            param.getSource().setLogicAreaId(linvRestParam.getLogicAreaId());
            param.getSource().setSalePlatform(SalePlatformType.YDP.getCode());
            param.getSource().setOwnerId(linvRestParam.getOwnerId());
            param.getSource().setOwnerType(linvRestParam.getOwnerType());
            param.getSource().setWhId(linvRestParam.getWhId());
            param.getSource().setSkuCode(linvRestParam.getSkuCode());
            param.getSource().setLotNo(linvRestParam.getLotNo());
            param.getSource().setIvType(IvType.Normal.getCode());
            param.getSource().setCommodityId(linvRestParam.getCommodityId());
            param.getSource().setUom(LinvUom.Box.getCode());

            param.getDeal().setRefNo(linvRestParam.getRefNo());
            param.getDeal().setTransactionId(linvRestParam.getTransactionId());
            param.getDeal().setTransactionNo(linvRestParam.getTransactionNo());
            param.getDeal().setTransactionSource(TRANSACTION_SOURCE_ORDR);
            param.getDeal().setTransactionDetailId(linvRestParam.getTransactionDetailId());
            param.getDeal().setTransactionSequence(linvRestParam.getTransactionSequence());
            param.getDeal().setTargetId(linvRestParam.getTargetId());
            param.getDeal().setTargetCode(linvRestParam.getTargetCode());
            param.getDeal().setTargetType(linvRestParam.getTargetType());
            param.getDeal().setSellPrice(linvRestParam.getSellPrice());
            param.getDeal().setReleaseQty(linvRestParam.getReleaseQty());
            param.getDeal().setDispatchedQty(linvRestParam.getDispatchedQty());
            param.getDeal().setBizType(linvRestParam.getBizType());
            param.getDeal().setReleaseTransactionId(linvRestParam.getReleaseTransactionId());
            param.getDeal().setReleaseTransactionNo(linvRestParam.getReleaseTransactionNo());
            param.getDeal().setReleaseTransactionDetailId(linvRestParam.getReleaseTransactionDetailId());
            params.add(param);
        }
        return params;
    }

    /**
     * 转义平台商品占用参数
     *
     * @param paramList
     * @return
     */
    private static ArrayList<LINV0006IRestParam> convertStockTo006(ArrayList<StockRestParam> paramList) {
        ArrayList<LINV0006IRestParam> params = new ArrayList<>();
        LINV0006IRestParam param = new LINV0006IRestParam();
        for (StockRestParam stockRestParam : paramList) {
            param = new LINV0006IRestParam();
            param.getSource().setSalePlatform(SALE_PLATFORM_YDP);
            param.getSource().setIvType(IV_TYPE_NORMAL);
            param.getAllocation().setTransactionSource(TRANSACTION_SOURCE_ORDR);
            param.getAllocation().setAllocatedType(ALLOCATE_TYPE_SALE);
            param.getSource().setLogicAreaId(stockRestParam.getLogicAreaId());
            param.getSource().setCommodityId(stockRestParam.getGoodsId());
            param.getAllocation().setRefNo(stockRestParam.getRefNo());
            param.getAllocation().setTransactionId(stockRestParam.getTransactionId());
            param.getAllocation().setTransactionNo(stockRestParam.getTransactionNo());
            param.getAllocation().setTransactionDetailId(stockRestParam.getTransactionDetailId());
            param.getAllocation().setTransactionSequence(stockRestParam.getTransactionSequence());
            param.getAllocation().setTargetId(stockRestParam.getTargetId());
            param.getAllocation().setAllocatedQty(stockRestParam.getAllocatedQty());
            // param.getAllocation().setAllocatedType(stockRestParam.getAllocatedType());
            param.getAllocation().setTargetCode(stockRestParam.getTargetCode());
            param.getAllocation().setTargetType(stockRestParam.getTargetType());
            params.add(param);
        }
        return params;
    }

    /**
     * 转义普通占用参数
     *
     * @param paramList
     * @return
     */
    private static ArrayList<LINV0007IRestParam> convertStockTo007(ArrayList<StockRestParam> paramList) {
        ArrayList<LINV0007IRestParam> params = new ArrayList<>();
        LINV0007IRestParam param = new LINV0007IRestParam();
        for (StockRestParam stockRestParam : paramList) {
            param = new LINV0007IRestParam();
            param.getSource().setSalePlatform(SALE_PLATFORM_YDP);
            param.getSource().setIvType(IV_TYPE_NORMAL);
            param.getAllocation().setTransactionSource(TRANSACTION_SOURCE_ORDR);
            param.getAllocation().setAllocatedType(ALLOCATE_TYPE_SALE);
            param.getSource().setPartId(stockRestParam.getPartId());
            param.getSource().setLogicAreaId(stockRestParam.getLogicAreaId());
            param.getSource().setOwnerId(stockRestParam.getOwnerId());
            param.getSource().setOwnerType(stockRestParam.getOwnerType());
            param.getSource().setOwnerdType(stockRestParam.getOwnerdType());
            param.getSource().setBrandId(stockRestParam.getBrandId());
            param.getSource().setProducerId(stockRestParam.getProducerId());
            param.getSource().setSupplierId(stockRestParam.getSupplierId());
            param.getSource().setCommodityId(stockRestParam.getGoodsId());
            param.getSource().setProductId(stockRestParam.getProductId());
            param.getAllocation().setRefNo(stockRestParam.getRefNo());
            param.getAllocation().setTransactionId(stockRestParam.getTransactionId());
            param.getAllocation().setTransactionNo(stockRestParam.getTransactionNo());
            param.getAllocation().setTransactionDetailId(stockRestParam.getTransactionDetailId());
            param.getAllocation().setTransactionSequence(stockRestParam.getTransactionSequence());
            param.getAllocation().setTargetId(stockRestParam.getTargetId());
            param.getAllocation().setAllocatedQty(stockRestParam.getAllocatedQty());
            param.getAllocation().setAllocatedType(stockRestParam.getAllocatedType());
            param.getAllocation().setTargetCode(stockRestParam.getTargetCode());
            param.getAllocation().setTargetType(stockRestParam.getTargetType());
            params.add(param);
        }
        return params;
    }

    /**
     * 转义普通占用参数
     *
     * @param paramList
     * @return
     */
    private static ArrayList<LINV0008IRestParam> convertStockTo008(List<StockRestParam> paramList) {
        ArrayList<LINV0008IRestParam> params = new ArrayList<>();
        LINV0008IRestParam param = new LINV0008IRestParam();
        for (StockRestParam stockRestParam : paramList) {
            param = new LINV0008IRestParam();
            param.setTransactionId(stockRestParam.getTransactionId());
            param.setTransactionNo(stockRestParam.getTransactionNo());
            param.setTransactionDetailId(stockRestParam.getTransactionDetailId());
            param.setTransactionSequence(stockRestParam.getTransactionSequence());//和数据库统一
            param.setCancelQty(stockRestParam.getCancelQty());
            param.setAlocType(stockRestParam.getAlocType());
            params.add(param);
        }
        return params;
    }

    /**
     * 转义实货囤货参数
     *
     * @param linvRestParam
     * @return
     */
    private static LINV0105IInvParam convertStockTo0105(LinvRestParam linvRestParam) {
        LINV0105IInvParam param = new LINV0105IInvParam();
        param.getSource().setLogicAreaId(linvRestParam.getLogicAreaId());
        param.getSource().setSalePlatform(SalePlatformType.YDP.getCode());
        param.getSource().setOwnerId(linvRestParam.getOwnerId());
        param.getSource().setOwnerCode(linvRestParam.getOwnerCode());
        param.getSource().setOwnerType(linvRestParam.getOwnerType());
        param.getSource().setCommodityId(linvRestParam.getCommodityId());
        param.getSource().setIvType(IvType.Normal.getCode());
        param.getSource().setComoIvType(linvRestParam.getComoIvType());
        param.getSource().setUom(LinvUom.Box.getCode());

        param.getDeal().setDeductSrcInv(linvRestParam.getDeductSrcInv());
        param.getDeal().setAddTargetInv(linvRestParam.getAddTargetInv());
        param.getDeal().setRefNo(linvRestParam.getRefNo());
        param.getDeal().setTransactionId(linvRestParam.getTransactionId());
        param.getDeal().setTransactionNo(linvRestParam.getTransactionNo());
        param.getDeal().setTransactionSource(TRANSACTION_SOURCE_ORDR);
        param.getDeal().setTransactionDetailId(linvRestParam.getTransactionDetailId());
        param.getDeal().setTransactionSequence(NumberUtils.INTEGER_ONE);
        param.getDeal().setTargetId(linvRestParam.getTargetId());
        param.getDeal().setTargetCode(linvRestParam.getTargetCode());
        param.getDeal().setTargetName(linvRestParam.getTargetName());
        param.getDeal().setTargetType(linvRestParam.getTargetType());
        param.getDeal().setReleaseQty(linvRestParam.getReleaseQty());
        param.getDeal().setDealPrice(linvRestParam.getBuyPrice());
        param.getDeal().setDealQty(linvRestParam.getDealQty());
        param.getDeal().setBizType(linvRestParam.getBizType());
        return param;
    }

    /**
     * 转义买家退货参数
     *
     * @param paramList
     * @return
     */
    private static ArrayList<LINV0106IParam> convertBuyerReturnTo0106(ArrayList<LinvRestParam> paramList) {
        ArrayList<LINV0106IParam> params = new ArrayList<>();
        LINV0106IParam param = new LINV0106IParam();
        for (LinvRestParam linvRestParam : paramList) {
            param = new LINV0106IParam();
            param.getSource().setLogicAreaId(linvRestParam.getLogicAreaId());
            param.getSource().setSalePlatform(SalePlatformType.YDP.getCode());
            param.getSource().setOwnerId(linvRestParam.getOwnerId());
            param.getSource().setOwnerCode(linvRestParam.getOwnerCode());
            param.getSource().setOwnerType(linvRestParam.getOwnerType());
            param.getSource().setCommodityId(Long.valueOf(linvRestParam.getCommodityId()));
            param.getSource().setIvType(IvType.Normal.getCode());
            param.getSource().setComoIvType(linvRestParam.getComoIvType());
            param.getSource().setUom(LinvUom.Box.getCode());

            param.getDeal().setAddTargetInv(linvRestParam.getAddTargetInv());
            param.getDeal().setDeductSrcInv(linvRestParam.getDeductSrcInv());
            param.getDeal().setRefNo(linvRestParam.getRefNo());
            param.getDeal().setTransactionId(linvRestParam.getTransactionId());
            param.getDeal().setTransactionNo(linvRestParam.getTransactionNo());
            param.getDeal().setTransactionSource(TRANSACTION_SOURCE_ORDR);
            param.getDeal().setTransactionDetailId(linvRestParam.getTransactionDetailId());
            param.getDeal().setTransactionSequence(linvRestParam.getTransactionSequence());
            param.getDeal().setTargetId(linvRestParam.getTargetId());
            param.getDeal().setTargetCode(linvRestParam.getTargetCode());
            param.getDeal().setTargetType(linvRestParam.getTargetType());
            param.getDeal().setReleaseQty(new BigDecimal(0));
            param.getDeal().setReturnQty(linvRestParam.getReleaseQty());
            param.getDeal().setBizType(linvRestParam.getBizType());
            param.getDeal().setSrcTransactionId(linvRestParam.getSrcTransactionId());
            param.getDeal().setSrcTransactionNo(linvRestParam.getSrcTransactionNo());
            param.getDeal().setSrcTransactionDetailId(linvRestParam.getSrcTransactionDetailId());
            params.add(param);
        }
        return params;
    }

    /**
     * 转义实货囤货参数
     *
     * @param paramList
     * @return
     */
    private static ArrayList<LINV0106IParam> convertStockTo0106(ArrayList<LinvRestParam> paramList) {
        ArrayList<LINV0106IParam> params = new ArrayList<>();
        LINV0106IParam param = new LINV0106IParam();
        for (LinvRestParam linvRestParam : paramList) {
            param = new LINV0106IParam();
            param.getSource().setLogicAreaId(linvRestParam.getLogicAreaId());
            param.getSource().setSalePlatform(SalePlatformType.YDP.getCode());
            param.getSource().setOwnerId(linvRestParam.getOwnerId());
            param.getSource().setOwnerCode(linvRestParam.getOwnerCode());
            param.getSource().setOwnerType(linvRestParam.getOwnerType());
            param.getSource().setCommodityId(Long.valueOf(linvRestParam.getCommodityId()));
            param.getSource().setIvType(IvType.Normal.getCode());
            param.getSource().setComoIvType(linvRestParam.getComoIvType());
            param.getSource().setUom(LinvUom.Box.getCode());

            param.getDeal().setAddTargetInv(linvRestParam.getAddTargetInv());
            param.getDeal().setDeductSrcInv(true);
            param.getDeal().setRefNo(linvRestParam.getRefNo());
            param.getDeal().setTransactionId(linvRestParam.getTransactionId());
            param.getDeal().setTransactionNo(linvRestParam.getTransactionNo());
            param.getDeal().setTransactionSource(TRANSACTION_SOURCE_ORDR);
            param.getDeal().setTransactionDetailId(linvRestParam.getTransactionDetailId());
            param.getDeal().setTransactionSequence(linvRestParam.getTransactionSequence());
            Seller seller =  Seller.getSellerByCode(Seller.SELLER_CODE);
            param.getDeal().setTargetId(seller.getEntity().getSellerId().toString());
            param.getDeal().setTargetCode(Seller.SELLER_CODE);
            param.getDeal().setTargetType(OwnerType.Seller.getCode());
            param.getDeal().setReleaseQty(BigDecimal.ZERO);
            param.getDeal().setReturnQty(linvRestParam.getReleaseQty());
            param.getDeal().setBizType(linvRestParam.getBizType());
            params.add(param);
        }
        return params;
    }

    /**
     * 转义普通占用参数
     *
     * @param paramList
     * @return
     */
    private static ArrayList<LINV0107IParam> convertStockTo0107(ArrayList<LinvRestParam> paramList) {
        ArrayList<LINV0107IParam> params = new ArrayList<>();
        for (LinvRestParam linvRestParam : paramList) {
            LINV0107IParam param = new LINV0107IParam();
            param.getSource().setLogicAreaId(linvRestParam.getLogicAreaId());
            param.getSource().setSalePlatform(SalePlatformType.YDP.getCode());
            param.getSource().setOwnerId(linvRestParam.getOwnerId());
            param.getSource().setOwnerCode(linvRestParam.getOwnerCode());
            param.getSource().setOwnerType(linvRestParam.getOwnerType());
            param.getSource().setCommodityId(linvRestParam.getCommodityId());
            param.getSource().setIvType(IvType.Normal.getCode());
            param.getSource().setComoIvType(linvRestParam.getComoIvType());
            param.getSource().setUom(LinvUom.Box.getCode());

            param.getAllocation().setRefNo(linvRestParam.getRefNo());
            param.getAllocation().setTransactionId(linvRestParam.getTransactionId());
            param.getAllocation().setTransactionNo(linvRestParam.getTransactionNo());
            param.getAllocation().setTransactionDetailId(linvRestParam.getTransactionDetailId());
            param.getAllocation().setTransactionSource(TRANSACTION_SOURCE_ORDR);
            param.getAllocation().setTransactionSequence(linvRestParam.getTransactionSequence());
            param.getAllocation().setTargetId(linvRestParam.getTargetId());
            param.getAllocation().setTargetCode(linvRestParam.getTargetCode());
            param.getAllocation().setTargetType(linvRestParam.getTargetType());
            param.getAllocation().setAlocQty(linvRestParam.getAllocatedQty());
            param.getAllocation().setBizType(linvRestParam.getBizType());
            params.add(param);
        }
        return params;
    }

    /**
     * 获取仓库ID
     *
     * @return
     */
    public static Long getWareHouseId(String whCode) {
        Long whId = null;
        // 获取URL
        String url = UrlConst.API_LINV_URL + UrlConst.ACTION_LINV0014I;
        LINV0114IParam param = new LINV0114IParam();
        param.getWhCode().add(whCode);
        TypeReference<BaseRestPaginationResult<LINV0114IResult>> typeReference = new TypeReference<BaseRestPaginationResult<LINV0114IResult>>() {
        };
        Stock stock = new Stock();
        BaseRestPaginationResult<LINV0114IResult> searchDataResult = stock.getRestClient().post(url, param, typeReference);
        if(null!= searchDataResult && CollectionUtils.isNotEmpty(searchDataResult.getData())){
            whId = searchDataResult.getData().get(0).getWhId();
        }
        return whId;
    }

    /**
     * 获取货权人商品库存
     *
     * @return
     */
    public static Map<String, List<Stock>> getComonInv(LINV0113IRestParam param) {
        Map<String, List<Stock>> stockMap = new HashMap<>();
        // 获取URL
        String url = UrlConst.API_LINV_URL + UrlConst.ACTION_LINV0113I;
        TypeReference<BaseRestPaginationResult<LINV0113IRestResult>> typeReference = new TypeReference<BaseRestPaginationResult<LINV0113IRestResult>>() {
        };
        Stock stock = new Stock();
        BaseRestPaginationResult<LINV0113IRestResult> searchDataResult = stock.getRestClient().post(url, param, typeReference);
        if(null!= searchDataResult && CollectionUtils.isNotEmpty(searchDataResult.getData())){
            List<LINV0113IRestResult> results = searchDataResult.getData();
            for(LINV0113IRestResult result : results) {
                stock = new Stock();
                stock.entity = convertLinv0113(result);

                String goodsId = stock.getEntity().getGoodsId();

                if (stockMap.containsKey(goodsId)) {
                    stockMap.get(goodsId).add(stock);
                } else {
                    List<Stock> stockList = new ArrayList<>();
                    stockList.add(stock);
                    stockMap.put(goodsId, stockList);
                }
            }
        }
        return stockMap;
    }

    /**
     *
     * @param result
     * @return
     */
    public static StockEntity convertLinv0113(LINV0113IRestResult result) {
        StockEntity entity = new StockEntity();

        entity.setGoodsId(result.getCommodityId());
        entity.setAvailableQty(result.getAvailableQty());
        entity.setLogisticsZoneId(NumberUtils.createLong(result.getLogisticsId()));
        entity.setOwnerId(result.getOwnerId());
        entity.setOwnerCode(result.getOwnerCode());
        entity.setOwnerName(result.getOwnerName());
        entity.setComoIvType(result.getComoIvType());
        entity.setIvType(result.getIvType());

        return entity;
    }

    /**
     * 产品库存占用取消
     *
     * @param paramList
     * @return
     */
    public static void CancelLinvAllocate(ArrayList<LINV0104IParam> paramList) {
        Assert.isTrue(paramList.size() > 0);
        String url = UrlConst.API_LINV_URL + UrlConst.ACTION_LINV0104I;
        TypeReference<String> typeReference = new TypeReference<String>() {
        };
        Stock stock = new Stock();
        stock.getRestClient().post(url, paramList, typeReference);
    }

    /**
     * 商品库存占用取消
     *
     * @param paramList
     * @return
     */
    public static void CancelComoAllocate(ArrayList<LINV0104IParam> paramList) {
        Assert.isTrue(paramList.size() > 0);
        String url = UrlConst.API_LINV_URL + UrlConst.ACTION_LINV0108I;
        TypeReference<String> typeReference = new TypeReference<String>() {
        };
        Stock stock = new Stock();
        stock.getRestClient().post(url, paramList, typeReference);
    }

    /**
     * 库存溯源接口
     *
     * @param params
     * @return
     */
    public static List<LINV0116IResult> AllocationSearch(ArrayList<LINV0116IParam> params) {
        String url = UrlConst.API_LINV_URL + UrlConst.ACTION_LINV0116I;
        TypeReference<BaseRestPaginationResult<LINV0116IResult>> typeReference = new TypeReference<BaseRestPaginationResult<LINV0116IResult>>() {
        };
        Stock stock = new Stock();
        BaseRestPaginationResult<LINV0116IResult> searchDataResult = stock.getRestClient().post(url, params, typeReference);
        if (null!= searchDataResult && CollectionUtils.isNotEmpty(searchDataResult.getData())){
            return searchDataResult.getData();
        }
        return null;
    }
}