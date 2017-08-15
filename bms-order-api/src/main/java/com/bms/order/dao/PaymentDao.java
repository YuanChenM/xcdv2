package com.bms.order.dao;

import java.util.List;
import java.util.Map;
import com.bms.order.bean.entity.PaymentEntity;
import com.framework.boot.base.BaseDao;

/**
* 支付记录Dao
* @author li_huiqian
*/
public interface PaymentDao extends BaseDao {
public int save(PaymentEntity entity);
public int batchSave(List<PaymentEntity> entities);
public int delete(PaymentEntity entity);
public int batchDelete(List<PaymentEntity> entities);
public int modify(PaymentEntity entity);
public int batchModify(List<PaymentEntity> entities);
public PaymentEntity findOne(PaymentEntity entity);
public List<PaymentEntity> findAll(Map<String, Object> map);
}
