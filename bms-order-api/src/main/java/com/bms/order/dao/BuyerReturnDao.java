package com.bms.order.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.bms.order.archive.impl.BuyerReturnDetail;
import com.bms.order.bean.entity.BuyerReturnDetailEntity;
import com.bms.order.bean.entity.BuyerReturnEntity;
import com.bms.order.bean.entity.BuyerReturnHistoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 买家退货主表Dao
* @author li_huiqian
*/
public interface BuyerReturnDao extends BaseDao {
public int save(BuyerReturnEntity entity);
public int batchSave(List<BuyerReturnEntity> entities);
public int delete(BuyerReturnEntity entity);
public int batchDelete(List<BuyerReturnEntity> entities);
public int modify(BuyerReturnEntity entity);
public int batchModify(List<BuyerReturnEntity> entities);
public BuyerReturnEntity findOne(BuyerReturnEntity entity);
public List<BuyerReturnEntity> findAll(Map<String, Object> map);
public int saveHistory(BuyerReturnHistoryEntity historyEntity);
public int batchSaveHistory(List<BuyerReturnHistoryEntity> historyEntities);
public BigDecimal findAlreadyReturn(BuyerReturnDetailEntity entity);
}
