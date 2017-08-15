package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.BsVirtualPerformDetailEntity;
import com.bms.order.bean.result.ORDR1001IBsOrderDetailCountResult;
import com.framework.boot.base.BaseDao;

/**
* 买手囤货订单行权单明细表Dao
* @author li_huiqian
*/
public interface BsVirtualPerformDetailDao extends BaseDao {
public int save(BsVirtualPerformDetailEntity entity);
public int batchSave(List<BsVirtualPerformDetailEntity> entities);
public int delete(BsVirtualPerformDetailEntity entity);
public int batchDelete(List<BsVirtualPerformDetailEntity> entities);
public int modify(BsVirtualPerformDetailEntity entity);
public int batchModify(List<BsVirtualPerformDetailEntity> entities);
public BsVirtualPerformDetailEntity findOne(BsVirtualPerformDetailEntity entity);
public List<BsVirtualPerformDetailEntity> findAll(Map<String, Object> map);
    public List<ORDR1001IBsOrderDetailCountResult> getBsVirtualPerforming(ORDR1001IBsOrderDetailCountResult param);
}
