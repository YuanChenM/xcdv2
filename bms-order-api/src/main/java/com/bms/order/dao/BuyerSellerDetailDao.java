package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BuyerSellerDetailEntity;
import com.framework.boot.base.BaseDao;

/**
* 买家分批订单供货信息表Dao
* @author li_huiqian
*/
public interface BuyerSellerDetailDao extends BaseDao {
public int save(BuyerSellerDetailEntity entity);
public int batchSave(List<BuyerSellerDetailEntity> entities);
public int delete(BuyerSellerDetailEntity entity);
public int batchDelete(List<BuyerSellerDetailEntity> entities);
public int modify(BuyerSellerDetailEntity entity);
public int batchModify(List<BuyerSellerDetailEntity> entities);
public BuyerSellerDetailEntity findOne(BuyerSellerDetailEntity entity);
public List<BuyerSellerDetailEntity> findAll(Map<String, Object> map);
}
