package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BsOrderAttachedEntity;
import com.bms.order.bean.entity.BsOrderAttachedHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 买手订单附表Dao
* @author li_huiqian
*/
public interface BsOrderAttachedDao extends BaseDao {
public int save(BsOrderAttachedEntity entity);
public int batchSave(List<BsOrderAttachedEntity> entities);
public int delete(BsOrderAttachedEntity entity);
public int batchDelete(List<BsOrderAttachedEntity> entities);
public int modify(BsOrderAttachedEntity entity);
public int batchModify(List<BsOrderAttachedEntity> entities);
public BsOrderAttachedEntity findOne(BsOrderAttachedEntity entity);
public List<BsOrderAttachedEntity> findAll(Map<String, Object> map);
public int saveHistory(BsOrderAttachedHistoryEntity historyEntity);
public int batchSaveHistory(List<BsOrderAttachedHistoryEntity> historyEntities);
}
