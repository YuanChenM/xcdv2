package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BsStockpileSplitDetailEntity;
import com.bms.order.bean.entity.BsStockpileSplitDetailHistoryEntity;
import com.bms.order.bean.result.ORDR1001IBsOrderDetailCountResult;
import com.framework.boot.base.BaseDao;

/**
* 买手囤货分拆单明细Dao
* @author li_huiqian
*/
public interface BsStockpileSplitDetailDao extends BaseDao {
public int save(BsStockpileSplitDetailEntity entity);
public int batchSave(List<BsStockpileSplitDetailEntity> entities);
public int delete(BsStockpileSplitDetailEntity entity);
public int batchDelete(List<BsStockpileSplitDetailEntity> entities);
public int modify(BsStockpileSplitDetailEntity entity);
public int batchModify(List<BsStockpileSplitDetailEntity> entities);
public BsStockpileSplitDetailEntity findOne(BsStockpileSplitDetailEntity entity);
public List<BsStockpileSplitDetailEntity> findAll(Map<String, Object> map);
public int saveHistory(BsStockpileSplitDetailHistoryEntity historyEntity);
public int batchSaveHistory(List<BsStockpileSplitDetailHistoryEntity> historyEntities);

}
