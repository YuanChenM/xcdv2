package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BsStockpileSplitDetailAttachedEntity;
import com.bms.order.bean.entity.BsStockpileSplitDetailAttachedHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 买手囤货分拆单明细附表Dao
* @author li_huiqian
*/
public interface BsStockpileSplitDetailAttachedDao extends BaseDao {
public int save(BsStockpileSplitDetailAttachedEntity entity);
public int batchSave(List<BsStockpileSplitDetailAttachedEntity> entities);
public int delete(BsStockpileSplitDetailAttachedEntity entity);
public int batchDelete(List<BsStockpileSplitDetailAttachedEntity> entities);
public int modify(BsStockpileSplitDetailAttachedEntity entity);
public int batchModify(List<BsStockpileSplitDetailAttachedEntity> entities);
public BsStockpileSplitDetailAttachedEntity findOne(BsStockpileSplitDetailAttachedEntity entity);
public List<BsStockpileSplitDetailAttachedEntity> findAll(Map<String, Object> map);
public int saveHistory(BsStockpileSplitDetailAttachedHistoryEntity historyEntity);
public int batchSaveHistory(List<BsStockpileSplitDetailAttachedHistoryEntity> historyEntities);
}
