package com.framework.authority.dao;

import java.util.List;

import com.framework.authority.bean.entity.TreeDoc;
import com.framework.authority.bean.param.TreeParam;

/**
 * Created by zhang_jian3 on 2016/12/16.
 */
public interface TreeDao {
    List<TreeDoc> findList(TreeParam request);

    List<TreeDoc> findAccurateList(TreeParam request);

    Long findCount(TreeParam request);

    void save(TreeDoc entity);

    int update(TreeDoc entity);

    int delete(List<String> entity);
}
