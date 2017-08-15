package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.CancelEntity;
import com.framework.boot.base.BaseDao;

/**
* 取消Dao
* @author li_huiqian
*/
public interface CancelDao extends BaseDao {
public int save(CancelEntity entity);
public int batchSave(List<CancelEntity> entities);
public int delete(CancelEntity entity);
public int batchDelete(List<CancelEntity> entities);
public int modify(CancelEntity entity);
public int batchModify(List<CancelEntity> entities);
public CancelEntity findOne(CancelEntity entity);
public List<CancelEntity> findAll(Map<String, Object> map);
}
