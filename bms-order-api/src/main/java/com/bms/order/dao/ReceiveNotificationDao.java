package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.ReceiveNotificationEntity;
import com.bms.order.bean.entity.ReceiveNotificationHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 收货通知单Dao
* @author li_huiqian
*/
public interface ReceiveNotificationDao extends BaseDao {
public int save(ReceiveNotificationEntity entity);
public int batchSave(List<ReceiveNotificationEntity> entities);
public int delete(ReceiveNotificationEntity entity);
public int batchDelete(List<ReceiveNotificationEntity> entities);
public int modify(ReceiveNotificationEntity entity);
public int batchModify(List<ReceiveNotificationEntity> entities);
public ReceiveNotificationEntity findOne(ReceiveNotificationEntity entity);
public List<ReceiveNotificationEntity> findAll(Map<String, Object> map);
public int saveHistory(ReceiveNotificationHistoryEntity historyEntity);
public int batchSaveHistory(List<ReceiveNotificationHistoryEntity> historyEntities);
}
