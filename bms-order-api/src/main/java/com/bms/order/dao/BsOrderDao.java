package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BsOrderEntity;
import com.bms.order.bean.entity.BsOrderHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 买手订单Dao
* @author li_huiqian
*/
public interface BsOrderDao extends BaseDao {
public int save(BsOrderEntity entity);
public int batchSave(List<BsOrderEntity> entities);
public int delete(BsOrderEntity entity);
public int batchDelete(List<BsOrderEntity> entities);
public int modify(BsOrderEntity entity);
public int batchModify(List<BsOrderEntity> entities);
public BsOrderEntity findOne(BsOrderEntity entity);
public List<BsOrderEntity> findAll(Map<String, Object> map);
public int saveHistory(BsOrderHistoryEntity historyEntity);
public int batchSaveHistory(List<BsOrderHistoryEntity> historyEntities);
}
