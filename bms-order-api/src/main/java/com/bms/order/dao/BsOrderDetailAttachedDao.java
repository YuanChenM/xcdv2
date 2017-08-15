package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BsOrderDetailAttachedEntity;
import com.bms.order.bean.entity.BsOrderDetailAttachedHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 买手订单明细附表Dao
* @author li_huiqian
*/
public interface BsOrderDetailAttachedDao extends BaseDao {
public int save(BsOrderDetailAttachedEntity entity);
public int batchSave(List<BsOrderDetailAttachedEntity> entities);
public int delete(BsOrderDetailAttachedEntity entity);
public int batchDelete(List<BsOrderDetailAttachedEntity> entities);
public int modify(BsOrderDetailAttachedEntity entity);
public int batchModify(List<BsOrderDetailAttachedEntity> entities);
public BsOrderDetailAttachedEntity findOne(BsOrderDetailAttachedEntity entity);
public List<BsOrderDetailAttachedEntity> findAll(Map<String, Object> map);
public int saveHistory(BsOrderDetailAttachedHistoryEntity historyEntity);
public int batchSaveHistory(List<BsOrderDetailAttachedHistoryEntity> historyEntities);
}
