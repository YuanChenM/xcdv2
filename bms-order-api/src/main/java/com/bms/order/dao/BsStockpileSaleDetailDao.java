package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BsStockpileSaleDetailEntity;
import com.bms.order.bean.entity.BsStockpileSaleDetailHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 买手囤货销售明细Dao
* @author li_huiqian
*/
public interface BsStockpileSaleDetailDao extends BaseDao {
public int save(BsStockpileSaleDetailEntity entity);
public int batchSave(List<BsStockpileSaleDetailEntity> entities);
public int delete(BsStockpileSaleDetailEntity entity);
public int batchDelete(List<BsStockpileSaleDetailEntity> entities);
public int modify(BsStockpileSaleDetailEntity entity);
public int batchModify(List<BsStockpileSaleDetailEntity> entities);
public BsStockpileSaleDetailEntity findOne(BsStockpileSaleDetailEntity entity);
public List<BsStockpileSaleDetailEntity> findAll(Map<String, Object> map);
public int saveHistory(BsStockpileSaleDetailHistoryEntity historyEntity);
public int batchSaveHistory(List<BsStockpileSaleDetailHistoryEntity> historyEntities);
}
