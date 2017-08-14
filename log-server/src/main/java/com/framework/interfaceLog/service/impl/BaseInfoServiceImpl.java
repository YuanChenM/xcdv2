package com.framework.interfaceLog.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.interfaceLog.bean.entity.LogMstDoc;
import com.framework.interfaceLog.bean.param.LogMstParam;
import com.framework.interfaceLog.dao.BaseInfoDao;
import com.framework.interfaceLog.service.BaseInfoService;

/**
 * Created by 健 on 2017/4/24.
 */
@Service
public class BaseInfoServiceImpl implements BaseInfoService {

    public static final Logger logger = LoggerFactory.getLogger(BaseInfoServiceImpl.class);

    @Autowired
    BaseInfoDao baseInfoDao;

    @Override
    public BaseRestPaginationResult<LogMstDoc> findList(LogMstParam request) throws Exception {
        BaseRestPaginationResult<LogMstDoc> result = new BaseRestPaginationResult<>();
        result.setData(baseInfoDao.findList(request));
        result.setTotal(baseInfoDao.findCount(request));
        return result;
    }

    @Override
    public boolean save(LogMstDoc entity) {
        return baseInfoDao.save(entity);
    }

    @Override
    public int update(LogMstDoc entity) {
        return baseInfoDao.update(entity);
    }

    @Override
    public int delete(List<String> entity) {
        return baseInfoDao.delete(entity);
    }
}
