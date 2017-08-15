package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BuyerReturnDetailEntity;
import com.framework.boot.base.BaseDao;

/**
* 买家退货订单明细Dao
* @author li_huiqian
*/
public interface BuyerReturnDetailDao extends BaseDao {
public int save(BuyerReturnDetailEntity entity);
public int batchSave(List<BuyerReturnDetailEntity> entities);
public int delete(BuyerReturnDetailEntity entity);
public int batchDelete(List<BuyerReturnDetailEntity> entities);
public int modify(BuyerReturnDetailEntity entity);
public int batchModify(List<BuyerReturnDetailEntity> entities);
public BuyerReturnDetailEntity findOne(BuyerReturnDetailEntity entity);
public List<BuyerReturnDetailEntity> findAll(Map<String, Object> map);
}
