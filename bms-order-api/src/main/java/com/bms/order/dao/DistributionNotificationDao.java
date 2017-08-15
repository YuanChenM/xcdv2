package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.DistributionNotificationEntity;
import com.bms.order.bean.entity.DistributionNotificationHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 配送通知单Dao
* @author li_huiqian
*/
public interface DistributionNotificationDao extends BaseDao {
public int save(DistributionNotificationEntity entity);
public int batchSave(List<DistributionNotificationEntity> entities);
public int delete(DistributionNotificationEntity entity);
public int batchDelete(List<DistributionNotificationEntity> entities);
public int modify(DistributionNotificationEntity entity);
public int batchModify(List<DistributionNotificationEntity> entities);
public DistributionNotificationEntity findOne(DistributionNotificationEntity entity);
public List<DistributionNotificationEntity> findAll(Map<String, Object> map);
public int saveHistory(DistributionNotificationHistoryEntity historyEntity);
public int batchSaveHistory(List<DistributionNotificationHistoryEntity> historyEntities);
public int I0305modify(DistributionNotificationEntity entity);
}
