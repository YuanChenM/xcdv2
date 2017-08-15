package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0302IParam;
import com.bms.slim.bean.param.wrapper.SlimSellerBrandParam;
import com.bms.slim.bean.result.wrapper.SlimSellerBrandResult;
import com.bms.slim.dao.SLIM0302IDao;
import com.bms.slim.services.SLIM0302IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wang_haichun on 2017/1/13.
 *
 * 查询卖家品牌
 */
@Service
public class SLIM0302IServiceImpl extends BaseServiceImpl implements SLIM0302IService {

    @Autowired
    private SLIM0302IDao slim0302IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0302IDao;
    }


    @Override
    public BaseRestPaginationResult<SlimSellerBrandResult> findSellerBrandList(SLIM0302IParam slim0302IParam) {
        return findPageList(slim0302IParam);
    }


    @Override
    public List<SlimSellerBrandResult> findListById(List<SlimSellerBrandParam> sellerBrandParams) {
        return slim0302IDao.findListById(sellerBrandParams);
    }
}
