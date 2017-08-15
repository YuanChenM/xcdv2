package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.PriceChannelNotificationDetailEntity;
import com.framework.boot.base.BaseDao;

/**
* 价格通道通知单明细Dao
* @author li_huiqian
*/
public interface PriceChannelNotificationDetailDao extends BaseDao {
public int save(PriceChannelNotificationDetailEntity entity);
public int batchSave(List<PriceChannelNotificationDetailEntity> entities);
public int delete(PriceChannelNotificationDetailEntity entity);
public int batchDelete(List<PriceChannelNotificationDetailEntity> entities);
public int modify(PriceChannelNotificationDetailEntity entity);
public int batchModify(List<PriceChannelNotificationDetailEntity> entities);
public PriceChannelNotificationDetailEntity findOne(PriceChannelNotificationDetailEntity entity);
public List<PriceChannelNotificationDetailEntity> findAll(Map<String, Object> map);
}
