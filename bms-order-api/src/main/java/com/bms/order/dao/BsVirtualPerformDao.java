package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BsVirtualPerformEntity;
import com.framework.boot.base.BaseDao;

/**
* 买手囤货行权单主表Dao
* @author li_huiqian
*/
public interface BsVirtualPerformDao extends BaseDao {
public int save(BsVirtualPerformEntity entity);
public int batchSave(List<BsVirtualPerformEntity> entities);
public int delete(BsVirtualPerformEntity entity);
public int batchDelete(List<BsVirtualPerformEntity> entities);
public int modify(BsVirtualPerformEntity entity);
public int batchModify(List<BsVirtualPerformEntity> entities);
public BsVirtualPerformEntity findOne(BsVirtualPerformEntity entity);
public List<BsVirtualPerformEntity> findAll(Map<String, Object> map);
}
