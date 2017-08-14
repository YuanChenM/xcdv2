package com.bms.region.services.impl;

import com.bms.region.bean.param.RegnRelationParam;
import com.bms.region.bean.result.RegnRelationResult;
import com.bms.region.dao.RegnProvinceToStreetDao;
import com.bms.region.services.RegnProvinceToStreetService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guan_zhongheng on 2017/2/15.
 */
@Service
public class RegnProvinceToStreetServiceImpl  extends BaseServiceImpl implements RegnProvinceToStreetService{

    @Autowired
    private RegnProvinceToStreetDao regnProvinceToStreetDao;

    @Override
    public BaseDao getBaseDao() {
        return regnProvinceToStreetDao;
    }

    @Override
    public BaseRestPaginationResult<RegnRelationResult> findProvincePageList(RegnRelationParam param) {
        BaseRestPaginationResult<RegnRelationResult> result = new BaseRestPaginationResult<RegnRelationResult>();
        List<RegnRelationResult> list = regnProvinceToStreetDao.findProvincePageList(param);
        int count = regnProvinceToStreetDao.countProvinceAll(param);
        result.setData(list);
        result.setTotal(count);
        return result;
    }
}
