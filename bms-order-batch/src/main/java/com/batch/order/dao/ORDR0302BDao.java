package com.batch.order.dao;

import com.batch.order.bean.entity.BuyerBatchOrderHistoryEntity;
import com.batch.order.bean.entity.DistributionNotificationDetailEntity;
import com.batch.order.bean.result.ORDR0302DistributionDetailResult;
import com.batch.order.bean.result.ORDR0302DistributionResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by liutao on 2017/1/4.
 */
public interface ORDR0302BDao extends BaseDao {
    List<ORDR0302DistributionResult> getBuyerOrderList();

    List<ORDR0302DistributionResult> getOrderBatchList(ORDR0302DistributionResult order);

    void saveDistributionInfo(ORDR0302DistributionResult orderBatch);

    void saveDistributionDetailInfo(DistributionNotificationDetailEntity distributionDetailEntitie);

    void saveBuyerBatchOrderHistory(BuyerBatchOrderHistoryEntity buyerBatchOrderHistoryEntity);

    void modifyBuyerBatchInfo(ORDR0302DistributionDetailResult detailResult);

    BuyerBatchOrderHistoryEntity findHistory(ORDR0302DistributionDetailResult detailResult);
}
