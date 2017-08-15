package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BsReturnEntity;
import com.bms.order.bean.entity.BsReturnHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 买手退货主表Dao
* @author li_huiqian
*/
public interface BsReturnDao extends BaseDao {
public int save(BsReturnEntity entity);
public int batchSave(List<BsReturnEntity> entities);
public int delete(BsReturnEntity entity);
public int batchDelete(List<BsReturnEntity> entities);
public int modify(BsReturnEntity entity);
public int batchModify(List<BsReturnEntity> entities);
public BsReturnEntity findOne(BsReturnEntity entity);
public List<BsReturnEntity> findAll(Map<String, Object> map);
public int saveHistory(BsReturnHistoryEntity historyEntity);
public int batchSaveHistory(List<BsReturnHistoryEntity> historyEntities);
}
