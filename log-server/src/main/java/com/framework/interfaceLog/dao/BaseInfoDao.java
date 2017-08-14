package com.framework.interfaceLog.dao;

import java.util.List;

import com.framework.interfaceLog.bean.entity.LogMstDoc;
import com.framework.interfaceLog.bean.param.LogMstParam;

/**
 * Created by 健 on 2017/4/24.
 */
public interface BaseInfoDao {
    List<LogMstDoc> findList(LogMstParam request);

    Long findCount(LogMstParam request);

    boolean save(LogMstDoc entity);

    int update(LogMstDoc entity);

    int delete(List<String> entity);
}
