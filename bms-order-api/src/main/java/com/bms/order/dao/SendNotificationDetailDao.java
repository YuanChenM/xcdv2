package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.SendNotificationDetailEntity;
import com.bms.order.bean.entity.SendNotificationDetailHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 发货通知单明细Dao
* @author li_huiqian
*/
public interface SendNotificationDetailDao extends BaseDao {
public int save(SendNotificationDetailEntity entity);
public int batchSave(List<SendNotificationDetailEntity> entities);
public int delete(SendNotificationDetailEntity entity);
public int batchDelete(List<SendNotificationDetailEntity> entities);
public int modify(SendNotificationDetailEntity entity);
public int batchModify(List<SendNotificationDetailEntity> entities);
public SendNotificationDetailEntity findOne(SendNotificationDetailEntity entity);
public List<SendNotificationDetailEntity> findAll(Map<String, Object> map);
public int saveHistory(SendNotificationDetailHistoryEntity historyEntity);
public int batchSaveHistory(List<SendNotificationDetailHistoryEntity> historyEntities);
}
