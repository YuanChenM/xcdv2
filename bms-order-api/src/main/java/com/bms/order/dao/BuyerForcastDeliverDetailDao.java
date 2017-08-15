package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BuyerForcastDeliverDetailEntity;
import com.bms.order.bean.entity.BuyerForcastDeliverDetailHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 买家订单预配送明细表Dao
* @author li_huiqian
*/
public interface BuyerForcastDeliverDetailDao extends BaseDao {
public int save(BuyerForcastDeliverDetailEntity entity);
public int batchSave(List<BuyerForcastDeliverDetailEntity> entities);
public int delete(BuyerForcastDeliverDetailEntity entity);
public int batchDelete(List<BuyerForcastDeliverDetailEntity> entities);
public int modify(BuyerForcastDeliverDetailEntity entity);
public int batchModify(List<BuyerForcastDeliverDetailEntity> entities);
public BuyerForcastDeliverDetailEntity findOne(BuyerForcastDeliverDetailEntity entity);
public List<BuyerForcastDeliverDetailEntity> findAll(Map<String, Object> map);
public int saveHistory(BuyerForcastDeliverDetailHistoryEntity historyEntity);
public int batchSaveHistory(List<BuyerForcastDeliverDetailHistoryEntity> historyEntities);
}
