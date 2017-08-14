package com.framework.resource.dao;

import java.util.List;

import com.framework.resource.bean.entity.ActionResourceDoc;
import com.framework.resource.bean.param.ActionResourceParam;

/**
 * Created by dai_youcheng on 2016-12-7.
 */
public interface ActionResourceDao {
    List<ActionResourceDoc> findList(ActionResourceParam request);

    Long findCount(ActionResourceParam request);

    boolean save(ActionResourceDoc entity);

    int update(ActionResourceDoc entity);

    int delete(List<String> entity);
}
