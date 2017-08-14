package com.bms.issue.dao;

import java.util.List;
import java.util.Map;
import com.bms.issue.bean.entity.QuestionEntity;
import com.framework.boot.base.BaseDao;

/**
* 问题订单问题表Dao
* @author li_huiqian
*/
public interface QuestionDao extends BaseDao {
public int save(QuestionEntity entity);
public int batchSave(List<QuestionEntity> entities);
public int delete(QuestionEntity entity);
public int batchDelete(List<QuestionEntity> entities);
public int modify(QuestionEntity entity);
public int batchModify(List<QuestionEntity> entities);
public QuestionEntity findOne(QuestionEntity entity);
public List<QuestionEntity> findAll(Map<String, Object> map);
}
