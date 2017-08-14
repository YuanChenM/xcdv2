package com.framework.authority.dao;

import java.util.List;

import com.framework.authority.bean.entity.GroupDoc;
import com.framework.authority.bean.entity.TreeNodeBean;
import com.framework.authority.bean.param.GroupParam;

/**
 * Created by zhang_jian3 on 2016/12/7.
 */
public interface GroupDao {

    List<GroupDoc> findList(GroupParam request);

    List<GroupDoc> findAccurateList(GroupParam request);

    Long findCount(GroupParam request);

    boolean save(GroupDoc entity);

    int update(GroupDoc entity);

    int delete(List<String> entity);

    List<TreeNodeBean> findTreeNode(List<String> groupIds);

}
