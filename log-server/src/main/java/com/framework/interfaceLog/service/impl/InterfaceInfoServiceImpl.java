package com.framework.interfaceLog.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.interfaceLog.bean.entity.LogHistoryDoc;
import com.framework.interfaceLog.bean.entity.LogInterfaceDoc;
import com.framework.interfaceLog.bean.param.LogInterfaceParam;
import com.framework.interfaceLog.dao.InterfaceInfoDao;
import com.framework.interfaceLog.service.InterfaceInfoService;

/**
 * Created by 健 on 2017/4/27.
 */
@Service
public class InterfaceInfoServiceImpl implements InterfaceInfoService {

    public static final Logger logger = LoggerFactory.getLogger(InterfaceInfoServiceImpl.class);

    @Autowired
    InterfaceInfoDao interfaceInfoDao;

    @Override
    public BaseRestPaginationResult<LogInterfaceDoc> findList(LogInterfaceParam request) throws Exception {
        BaseRestPaginationResult<LogInterfaceDoc> result = new BaseRestPaginationResult<>();
        result.setData(interfaceInfoDao.findList(request));
        result.setTotal(interfaceInfoDao.findCount(request));
        return result;
    }

    @Override
    public LogInterfaceDoc findOne(LogInterfaceDoc entity) {
        return interfaceInfoDao.findOne(entity);
    }

    @Override
    public boolean save(LogInterfaceDoc entity) {
        return interfaceInfoDao.save(entity);
    }

    @Override
    public boolean saveHistory(LogHistoryDoc entity) {
        return interfaceInfoDao.saveHistory(entity);
    }

    @Override
    public int update(LogInterfaceDoc entity) {
        return interfaceInfoDao.update(entity);
    }

    @Override
    public int delete(List<String> entity) {
        return interfaceInfoDao.delete(entity);
    }
}
