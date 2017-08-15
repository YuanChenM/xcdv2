package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BsReturnDetailEntity;
import com.framework.boot.base.BaseDao;

/**
* 买手退货明细表Dao
* @author li_huiqian
*/
public interface BsReturnDetailDao extends BaseDao {
public int save(BsReturnDetailEntity entity);
public int batchSave(List<BsReturnDetailEntity> entities);
public int delete(BsReturnDetailEntity entity);
public int batchDelete(List<BsReturnDetailEntity> entities);
public int modify(BsReturnDetailEntity entity);
public int batchModify(List<BsReturnDetailEntity> entities);
public BsReturnDetailEntity findOne(BsReturnDetailEntity entity);
public List<BsReturnDetailEntity> findAll(Map<String, Object> map);
}
