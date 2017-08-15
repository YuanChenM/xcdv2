package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.DistributionNotificationDetailEntity;
import com.bms.order.bean.entity.DistributionNotificationDetailHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 配送通知单明细Dao
* @author li_huiqian
*/
public interface DistributionNotificationDetailDao extends BaseDao {
public int save(DistributionNotificationDetailEntity entity);
public int batchSave(List<DistributionNotificationDetailEntity> entities);
public int delete(DistributionNotificationDetailEntity entity);
public int batchDelete(List<DistributionNotificationDetailEntity> entities);
public int modify(DistributionNotificationDetailEntity entity);
public int batchModify(List<DistributionNotificationDetailEntity> entities);
public DistributionNotificationDetailEntity findOne(DistributionNotificationDetailEntity entity);
public List<DistributionNotificationDetailEntity> findAll(Map<String, Object> map);
public int saveHistory(DistributionNotificationDetailHistoryEntity historyEntity);
public int batchSaveHistory(List<DistributionNotificationDetailHistoryEntity> historyEntities);
}
