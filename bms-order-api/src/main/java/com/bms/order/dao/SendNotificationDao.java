package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.SendNotificationEntity;
import com.bms.order.bean.entity.SendNotificationHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 发货通知单Dao
* @author li_huiqian
*/
public interface SendNotificationDao extends BaseDao {
public int save(SendNotificationEntity entity);
public int batchSave(List<SendNotificationEntity> entities);
public int delete(SendNotificationEntity entity);
public int batchDelete(List<SendNotificationEntity> entities);
public int modify(SendNotificationEntity entity);
public int batchModify(List<SendNotificationEntity> entities);
public SendNotificationEntity findOne(SendNotificationEntity entity);
public List<SendNotificationEntity> findAll(Map<String, Object> map);
public int saveHistory(SendNotificationHistoryEntity historyEntity);
public int batchSaveHistory(List<SendNotificationHistoryEntity> historyEntities);
}
