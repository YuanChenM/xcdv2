package com.batch.order.dao;

import com.batch.order.bean.entity.BuyerBatchOrderHistoryEntity;
import com.batch.order.bean.entity.DistributionNotificationDetailEntity;
import com.batch.order.bean.result.ORDR0301DistributionDetailResult;
import com.batch.order.bean.result.ORDR0301DistributionResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by liutao on 2017/1/4.
 */
public interface ORDR0301BDao extends BaseDao {
    List<ORDR0301DistributionResult> getBuyerOrderList();

    Integer getDistributionCount(ORDR0301DistributionResult order);

    List<ORDR0301DistributionResult> getOrderBatchList(ORDR0301DistributionResult order);

    void saveDistributionInfo(ORDR0301DistributionResult orderBatch);

    void saveDistributionDetailInfo(DistributionNotificationDetailEntity distributionDetailEntitie);

    void saveBuyerBatchOrderHistory(BuyerBatchOrderHistoryEntity buyerBatchOrderHistoryEntity);

    void modifyBuyerBatchInfo(ORDR0301DistributionDetailResult detailResult);

    BuyerBatchOrderHistoryEntity findHistory(ORDR0301DistributionDetailResult detailResult);
}
