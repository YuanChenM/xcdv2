package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BuyerBatchOrderEntity;
import com.bms.order.bean.entity.BuyerBatchOrderHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 买家分批订单Dao
* @author li_huiqian
*/
public interface BuyerBatchOrderDao extends BaseDao {
public int save(BuyerBatchOrderEntity entity);
public int batchSave(List<BuyerBatchOrderEntity> entities);
public int delete(BuyerBatchOrderEntity entity);
public int batchDelete(List<BuyerBatchOrderEntity> entities);
public int modify(BuyerBatchOrderEntity entity);
public int batchModify(List<BuyerBatchOrderEntity> entities);
public BuyerBatchOrderEntity findOne(BuyerBatchOrderEntity entity);
public List<BuyerBatchOrderEntity> findAll(Map<String, Object> map);
public int saveHistory(BuyerBatchOrderHistoryEntity historyEntity);
public int batchSaveHistory(List<BuyerBatchOrderHistoryEntity> historyEntities);
}
