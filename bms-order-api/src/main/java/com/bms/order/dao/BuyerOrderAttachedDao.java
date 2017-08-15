package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BuyerOrderAttachedEntity;
import com.bms.order.bean.entity.BuyerOrderAttachedHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 买家订单附表Dao
* @author li_huiqian
*/
public interface BuyerOrderAttachedDao extends BaseDao {
public int save(BuyerOrderAttachedEntity entity);
public int batchSave(List<BuyerOrderAttachedEntity> entities);
public int delete(BuyerOrderAttachedEntity entity);
public int batchDelete(List<BuyerOrderAttachedEntity> entities);
public int modify(BuyerOrderAttachedEntity entity);
public int batchModify(List<BuyerOrderAttachedEntity> entities);
public BuyerOrderAttachedEntity findOne(BuyerOrderAttachedEntity entity);
public List<BuyerOrderAttachedEntity> findAll(Map<String, Object> map);
public int saveHistory(BuyerOrderAttachedHistoryEntity historyEntity);
public int batchSaveHistory(List<BuyerOrderAttachedHistoryEntity> historyEntities);
}
