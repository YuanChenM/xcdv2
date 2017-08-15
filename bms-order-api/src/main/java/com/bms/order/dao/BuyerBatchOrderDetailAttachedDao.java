package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BuyerBatchOrderDetailAttachedEntity;
import com.bms.order.bean.entity.BuyerBatchOrderDetailAttachedHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 买家分批订单明细附表Dao
* @author li_huiqian
*/
public interface BuyerBatchOrderDetailAttachedDao extends BaseDao {
public int save(BuyerBatchOrderDetailAttachedEntity entity);
public int batchSave(List<BuyerBatchOrderDetailAttachedEntity> entities);
public int delete(BuyerBatchOrderDetailAttachedEntity entity);
public int batchDelete(List<BuyerBatchOrderDetailAttachedEntity> entities);
public int modify(BuyerBatchOrderDetailAttachedEntity entity);
public int batchModify(List<BuyerBatchOrderDetailAttachedEntity> entities);
public BuyerBatchOrderDetailAttachedEntity findOne(BuyerBatchOrderDetailAttachedEntity entity);
public List<BuyerBatchOrderDetailAttachedEntity> findAll(Map<String, Object> map);
public int saveHistory(BuyerBatchOrderDetailAttachedHistoryEntity historyEntity);
public int batchSaveHistory(List<BuyerBatchOrderDetailAttachedHistoryEntity> historyEntities);
}
