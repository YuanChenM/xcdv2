package com.framework.resource.dao;

import java.util.List;

import com.framework.resource.bean.entity.SysResourceDoc;
import com.framework.resource.bean.param.SysResourceParam;

/**
 * Created by dai_youcheng on 2016-12-7.
 */
public interface SysResourceDao {

    List<SysResourceDoc> findList(SysResourceParam request);

    int delete(List<String> sysResourceParam);

    boolean insert(SysResourceDoc sysResourceDoc);

    int update(SysResourceParam sysResourceParam);

    Long findCount(SysResourceParam request);
}
