package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.ConstantEntity;
import com.framework.boot.base.BaseDao;

/**
* 订单常量表Dao
* @author li_huiqian
*/
public interface ConstantDao extends BaseDao {
public int save(ConstantEntity entity);
public int batchSave(List<ConstantEntity> entities);
public int delete(ConstantEntity entity);
public int batchDelete(List<ConstantEntity> entities);
public int modify(ConstantEntity entity);
public int batchModify(List<ConstantEntity> entities);
public ConstantEntity findOne(ConstantEntity entity);
public List<ConstantEntity> findAll(Map<String, Object> map);
}
