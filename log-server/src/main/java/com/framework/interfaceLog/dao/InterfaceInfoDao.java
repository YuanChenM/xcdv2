package com.framework.interfaceLog.dao;

import java.util.List;

import com.framework.interfaceLog.bean.entity.LogHistoryDoc;
import com.framework.interfaceLog.bean.entity.LogInterfaceDoc;
import com.framework.interfaceLog.bean.param.LogInterfaceParam;

/**
 * Created by 健 on 2017/4/26.
 */
public interface InterfaceInfoDao {
    List<LogInterfaceDoc> findList(LogInterfaceParam request);

    Long findCount(LogInterfaceParam request);
    
    LogInterfaceDoc findOne(LogInterfaceDoc entity);

    boolean save(LogInterfaceDoc entity);

    boolean saveHistory(LogHistoryDoc entity);

    int update(LogInterfaceDoc entity);

    int delete(List<String> entity);
}
