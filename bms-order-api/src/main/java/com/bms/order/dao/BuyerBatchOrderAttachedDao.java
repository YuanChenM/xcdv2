package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BuyerBatchOrderAttachedEntity;
import com.bms.order.bean.entity.BuyerBatchOrderAttachedHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 买家分批订单附表Dao
* @author li_huiqian
*/
public interface BuyerBatchOrderAttachedDao extends BaseDao {
public int save(BuyerBatchOrderAttachedEntity entity);
public int batchSave(List<BuyerBatchOrderAttachedEntity> entities);
public int delete(BuyerBatchOrderAttachedEntity entity);
public int batchDelete(List<BuyerBatchOrderAttachedEntity> entities);
public int modify(BuyerBatchOrderAttachedEntity entity);
public int batchModify(List<BuyerBatchOrderAttachedEntity> entities);
public BuyerBatchOrderAttachedEntity findOne(BuyerBatchOrderAttachedEntity entity);
public List<BuyerBatchOrderAttachedEntity> findAll(Map<String, Object> map);
public int saveHistory(BuyerBatchOrderAttachedHistoryEntity historyEntity);
public int batchSaveHistory(List<BuyerBatchOrderAttachedHistoryEntity> historyEntities);
}
