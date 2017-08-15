package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.DistributionCancelNotificationEntity;
import com.bms.order.bean.entity.DistributionCancelNotificationHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 配送取消通知单Dao
* @author li_huiqian
*/
public interface DistributionCancelNotificationDao extends BaseDao {
public int save(DistributionCancelNotificationEntity entity);
public int batchSave(List<DistributionCancelNotificationEntity> entities);
public int delete(DistributionCancelNotificationEntity entity);
public int batchDelete(List<DistributionCancelNotificationEntity> entities);
public int modify(DistributionCancelNotificationEntity entity);
public int batchModify(List<DistributionCancelNotificationEntity> entities);
public DistributionCancelNotificationEntity findOne(DistributionCancelNotificationEntity entity);
public List<DistributionCancelNotificationEntity> findAll(Map<String, Object> map);
public int saveHistory(DistributionCancelNotificationHistoryEntity historyEntity);
public int batchSaveHistory(List<DistributionCancelNotificationHistoryEntity> historyEntities);
}
