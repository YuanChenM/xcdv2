package com.bms.issue.dao;

import java.util.List;
import java.util.Map;
import com.bms.issue.bean.entity.QuestionItemEntity;
import com.framework.boot.base.BaseDao;

/**
* 问题订单问题表明细问题点Dao
* @author li_huiqian
*/
public interface QuestionItemDao extends BaseDao {
public int save(QuestionItemEntity entity);
public int batchSave(List<QuestionItemEntity> entities);
public int delete(QuestionItemEntity entity);
public int batchDelete(List<QuestionItemEntity> entities);
public int modify(QuestionItemEntity entity);
public int batchModify(List<QuestionItemEntity> entities);
public QuestionItemEntity findOne(QuestionItemEntity entity);
public List<QuestionItemEntity> findAll(Map<String, Object> map);
}
