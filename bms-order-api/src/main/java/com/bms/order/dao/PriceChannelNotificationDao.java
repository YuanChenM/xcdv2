package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.PriceChannelNotificationEntity;
import com.framework.boot.base.BaseDao;

/**
* 价格通道通知单Dao
* @author li_huiqian
*/
public interface PriceChannelNotificationDao extends BaseDao {
public int save(PriceChannelNotificationEntity entity);
public int batchSave(List<PriceChannelNotificationEntity> entities);
public int delete(PriceChannelNotificationEntity entity);
public int batchDelete(List<PriceChannelNotificationEntity> entities);
public int modify(PriceChannelNotificationEntity entity);
public int batchModify(List<PriceChannelNotificationEntity> entities);
public PriceChannelNotificationEntity findOne(PriceChannelNotificationEntity entity);
public List<PriceChannelNotificationEntity> findAll(Map<String, Object> map);
}
