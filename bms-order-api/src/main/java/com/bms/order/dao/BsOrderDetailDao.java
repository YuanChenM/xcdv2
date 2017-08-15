package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BsOrderDetailEntity;
import com.bms.order.bean.entity.BsOrderDetailHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 买手订单明细Dao
* @author li_huiqian
*/
public interface BsOrderDetailDao extends BaseDao {
public int save(BsOrderDetailEntity entity);
public int batchSave(List<BsOrderDetailEntity> entities);
public int delete(BsOrderDetailEntity entity);
public int batchDelete(List<BsOrderDetailEntity> entities);
public int modify(BsOrderDetailEntity entity);
public int batchModify(List<BsOrderDetailEntity> entities);
public BsOrderDetailEntity findOne(BsOrderDetailEntity entity);
public List<BsOrderDetailEntity> findAll(Map<String, Object> map);
public int saveHistory(BsOrderDetailHistoryEntity historyEntity);
public int batchSaveHistory(List<BsOrderDetailHistoryEntity> historyEntities);
}
