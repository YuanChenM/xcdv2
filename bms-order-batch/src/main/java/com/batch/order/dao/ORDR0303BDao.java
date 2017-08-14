package com.batch.order.dao;

import com.batch.order.bean.entity.DistributionNotificationEntity;
import com.batch.order.bean.entity.DistributionNotificationHistoryEntity;
import com.batch.order.bean.result.ORDR0302DistributionResult;
import com.batch.order.bean.result.ORDR0303BDistributionResult;
import com.batch.order.bean.result.ORDR0303BResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by liutao on 2017/1/4.
 */
public interface ORDR0303BDao extends BaseDao {

    List<ORDR0303BResult> getXmlList();

    Integer getDistributionCount(ORDR0303BResult order);

    Integer getReceiveCount(ORDR0303BResult order);

    List<ORDR0303BDistributionResult> getDetailList(ORDR0303BResult param);

    DistributionNotificationHistoryEntity findHistory(DistributionNotificationEntity param);

    void saveHistory(DistributionNotificationHistoryEntity param);

    void modifyDisStatus(DistributionNotificationEntity param);
}
