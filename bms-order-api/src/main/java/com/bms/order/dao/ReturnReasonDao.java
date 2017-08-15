package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.ReturnReasonEntity;
import com.framework.boot.base.BaseDao;

/**
* 退货原因信息表Dao
* @author li_huiqian
*/
public interface ReturnReasonDao extends BaseDao {
public int save(ReturnReasonEntity entity);
public int batchSave(List<ReturnReasonEntity> entities);
public int delete(ReturnReasonEntity entity);
public int batchDelete(List<ReturnReasonEntity> entities);
public int modify(ReturnReasonEntity entity);
public int batchModify(List<ReturnReasonEntity> entities);
public ReturnReasonEntity findOne(ReturnReasonEntity entity);
public List<ReturnReasonEntity> findAll(Map<String, Object> map);
}
