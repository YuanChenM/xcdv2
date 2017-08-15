package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BuyerOrderEntity;
import com.bms.order.bean.entity.BuyerOrderHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 买家订单Dao
* @author li_huiqian
*/
public interface BuyerOrderDao extends BaseDao {
public int save(BuyerOrderEntity entity);
public int batchSave(List<BuyerOrderEntity> entities);
public int delete(BuyerOrderEntity entity);
public int batchDelete(List<BuyerOrderEntity> entities);
public int modify(BuyerOrderEntity entity);
public int batchModify(List<BuyerOrderEntity> entities);
public BuyerOrderEntity findOne(BuyerOrderEntity entity);
public List<BuyerOrderEntity> findAll(Map<String, Object> map);
public int saveHistory(BuyerOrderHistoryEntity historyEntity);
public int batchSaveHistory(List<BuyerOrderHistoryEntity> historyEntities);
}
