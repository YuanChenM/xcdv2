package com.bms.issue.dao;

import java.util.List;
import java.util.Map;
import com.bms.issue.bean.entity.QuestionAccessoryEntity;
import com.framework.boot.base.BaseDao;

/**
* 问题附件Dao
* @author li_huiqian
*/
public interface QuestionAccessoryDao extends BaseDao {
public int save(QuestionAccessoryEntity entity);
public int batchSave(List<QuestionAccessoryEntity> entities);
public int delete(QuestionAccessoryEntity entity);
public int batchDelete(List<QuestionAccessoryEntity> entities);
public int modify(QuestionAccessoryEntity entity);
public int batchModify(List<QuestionAccessoryEntity> entities);
public QuestionAccessoryEntity findOne(QuestionAccessoryEntity entity);
public List<QuestionAccessoryEntity> findAll(Map<String, Object> map);
}
