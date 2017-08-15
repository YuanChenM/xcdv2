package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BuyerBatchOrderDetailEntity;
import com.bms.order.bean.entity.BuyerBatchOrderDetailHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 买家分批订单明细Dao
* @author li_huiqian
*/
public interface BuyerBatchOrderDetailDao extends BaseDao {
public int save(BuyerBatchOrderDetailEntity entity);
public int batchSave(List<BuyerBatchOrderDetailEntity> entities);
public int delete(BuyerBatchOrderDetailEntity entity);
public int batchDelete(List<BuyerBatchOrderDetailEntity> entities);
public int modify(BuyerBatchOrderDetailEntity entity);
public int batchModify(List<BuyerBatchOrderDetailEntity> entities);
public BuyerBatchOrderDetailEntity findOne(BuyerBatchOrderDetailEntity entity);
public List<BuyerBatchOrderDetailEntity> findAll(Map<String, Object> map);
public int saveHistory(BuyerBatchOrderDetailHistoryEntity historyEntity);
public int batchSaveHistory(List<BuyerBatchOrderDetailHistoryEntity> historyEntities);
}
