package com.bms.issue.dao;

import java.util.List;
import java.util.Map;
import com.bms.issue.bean.entity.QuestionHandlingEntity;
import com.framework.boot.base.BaseDao;

/**
* 问题订单问题表管理信息Dao
* @author li_huiqian
*/
public interface QuestionHandlingDao extends BaseDao {
public int save(QuestionHandlingEntity entity);
public int batchSave(List<QuestionHandlingEntity> entities);
public int delete(QuestionHandlingEntity entity);
public int batchDelete(List<QuestionHandlingEntity> entities);
public int modify(QuestionHandlingEntity entity);
public int batchModify(List<QuestionHandlingEntity> entities);
public QuestionHandlingEntity findOne(QuestionHandlingEntity entity);
public List<QuestionHandlingEntity> findAll(Map<String, Object> map);
}
