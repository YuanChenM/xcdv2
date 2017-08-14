package com.framework.authority.dao;

import java.util.List;

import com.framework.authority.bean.entity.TreeNodeDoc;
import com.framework.authority.bean.param.TreeNodeParam;

/**
 * Created by zhang_jian3 on 2016/12/7.
 */
public interface TreeNodeDao {
    List<TreeNodeDoc> findList(TreeNodeParam request);

    List<TreeNodeDoc> findAccurateList(TreeNodeParam request);

    Long findCount(TreeNodeParam request);

    void save(TreeNodeDoc entity);

    int update(TreeNodeDoc entity);

    int delete(List<String> entity);

    List<TreeNodeDoc> findTreeNodeDetail(List<String> nodeIds);
}
