package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.ReceiveNotificationDetailEntity;
import com.bms.order.bean.entity.ReceiveNotificationDetailHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 收货通知单明细Dao
* @author li_huiqian
*/
public interface ReceiveNotificationDetailDao extends BaseDao {
public int save(ReceiveNotificationDetailEntity entity);
public int batchSave(List<ReceiveNotificationDetailEntity> entities);
public int delete(ReceiveNotificationDetailEntity entity);
public int batchDelete(List<ReceiveNotificationDetailEntity> entities);
public int modify(ReceiveNotificationDetailEntity entity);
public int batchModify(List<ReceiveNotificationDetailEntity> entities);
public ReceiveNotificationDetailEntity findOne(ReceiveNotificationDetailEntity entity);
public List<ReceiveNotificationDetailEntity> findAll(Map<String, Object> map);
public int saveHistory(ReceiveNotificationDetailHistoryEntity historyEntity);
public int batchSaveHistory(List<ReceiveNotificationDetailHistoryEntity> historyEntities);
}
