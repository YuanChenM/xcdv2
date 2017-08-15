package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BuyerForcastDeliverDetailAttachedEntity;
import com.bms.order.bean.entity.BuyerForcastDeliverDetailAttachedHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 买家订单预配送明细附表Dao
* @author li_huiqian
*/
public interface BuyerForcastDeliverDetailAttachedDao extends BaseDao {
public int save(BuyerForcastDeliverDetailAttachedEntity entity);
public int batchSave(List<BuyerForcastDeliverDetailAttachedEntity> entities);
public int delete(BuyerForcastDeliverDetailAttachedEntity entity);
public int batchDelete(List<BuyerForcastDeliverDetailAttachedEntity> entities);
public int modify(BuyerForcastDeliverDetailAttachedEntity entity);
public int batchModify(List<BuyerForcastDeliverDetailAttachedEntity> entities);
public BuyerForcastDeliverDetailAttachedEntity findOne(BuyerForcastDeliverDetailAttachedEntity entity);
public List<BuyerForcastDeliverDetailAttachedEntity> findAll(Map<String, Object> map);
public int saveHistory(BuyerForcastDeliverDetailAttachedHistoryEntity historyEntity);
public int batchSaveHistory(List<BuyerForcastDeliverDetailAttachedHistoryEntity> historyEntities);
}
