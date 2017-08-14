package com.bms.issue.dao;

import java.util.List;
import java.util.Map;

import com.bms.issue.bean.entity.IssueEntity;
import com.framework.boot.base.BaseDao;

/**
 * 问题订单总表Dao
 *
 * @author li_huiqian
 */
public interface IssueDao extends BaseDao {
    public int save(IssueEntity entity);

    public int batchSave(List<IssueEntity> entities);

    public int delete(IssueEntity entity);

    public int batchDelete(List<IssueEntity> entities);

    public int modify(IssueEntity entity);

    public int batchModify(List<IssueEntity> entities);

    public IssueEntity findOne(IssueEntity entity);

    public List<IssueEntity> findAll(Map<String, Object> map);
}
