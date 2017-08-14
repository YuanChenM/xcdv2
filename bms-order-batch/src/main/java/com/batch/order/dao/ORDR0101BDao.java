package com.batch.order.dao;

import com.batch.order.bean.entity.*;
import com.batch.order.bean.result.*;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by liutao on 2017/1/4.
 */
public interface ORDR0101BDao extends BaseDao {
    List<ORDR0101BOrderResult> getConfirmOrder();

    List<ORDR0201BOrderBatchResult> getOrderBatchResults(ORDR0201BOrderGoodsResult orderResult);

    List<ORDR0201BOrderBatchResult> getNewOrderBatchResults(ORDR0201BOrderGoodsResult orderResult);

    List<ORDR0201BOrderBatchResult> getNewOrderBatchResult(ORDR0201BOrderGoodsResult orderResult);

    List<ORDR0201BOrderGoodsResult> getOrderGoodsResults(ORDR0201BOrderResult orderResult);

    List<ORDR0201BManufacturerResult> getOrderManufacturer(ORDR0201BOrderGoodsResult orderResult);

    List<ORDR0201BOrderBatchDetailResult> getOrderBatchDetails(ORDR0201BOrderGoodsResult orderResult);

    Integer getOtherOrderCount(ORDR0201BOrderResult orderResult);

    void saveBuyerForcastDeliverDetail(BuyerForcastDeliverDetailEntity buyerForcastDeliverDetailEntity);

    void saveBuyerForcastDeliverDetailAttached(BuyerForcastDeliverDetailAttachedEntity buyerForcastDeliverDetailAttachedEntity);

    void modifyBatchOrderStu(ORDR0201BOrderBatchResult orderResult);

    void modifyBuyerOrderStu(ORDR0201BOrderResult orderResult);

    void modifyBatchOrderDetail(ORDR0201BOrderBatchDetailResult orderResult);

    Integer getNoSplitCount(ORDR0201BOrderResult orderResult);

    BuyerBatchOrderHistoryEntity getBuyerBatchOrderHistory(ORDR0201BOrderBatchResult orderBatchResult);

    BuyerOrderHistoryEntity getBuyerOrderHistory(ORDR0201BOrderResult orderResult);

    void saveBuyerBatchOrderHistory(BuyerBatchOrderHistoryEntity buyerBatchOrderHistoryEntity);

    void saveBuyerOrderHistory(BuyerOrderHistoryEntity buyerOrderHistoryEntity);

    Integer getReturnCount(ORDR0201BOrderGoodsResult orderGoodsResult);

    List<BsStockpileSaleDetailResult> getBsStockpilingOrder(ORDR0201BOrderGoodsResult goodsResult);

    void saveBsStockpileSaleDetail(BsStockpileSaleDetailEntity bsStockpileSaleDetailEntity);

    List<String> findEmailAddress();

    List<BuyerOrderHistoryEntity> getOrderEmialResults();

    Integer modifyMailedFlg(List<BuyerOrderHistoryEntity> orderResults);
}
