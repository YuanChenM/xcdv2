package com.bms.slpd.services.impl;

import com.bms.slpd.bean.param.SLPD0405IParam;
import com.bms.slpd.bean.result.field.SLPD0403IBrandResult;
import com.bms.slpd.bean.result.wrapper.SlpdBrandOwnerResult;
import com.bms.slpd.dao.SLPD0405IDao;
import com.bms.slpd.services.SLPD0405IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 查询品牌所有人信息
 */
@Service
public class SLPD0405IServiceImpl extends BaseServiceImpl implements SLPD0405IService {

    @Autowired
    private SLPD0405IDao slpd0405IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0405IDao;
    }

    /**
     * 根据品牌Id查询品牌所有人信息
     */
    @Override
    public List<SLPD0403IBrandResult> findBrandOwner(List<Long> list) {
        return slpd0405IDao.findBrandOwner(list);
    }

    /**
     * 查询品牌所有人信息
     */
    @Override
    public BaseRestPaginationResult<SlpdBrandOwnerResult> findBrandOwenList(SLPD0405IParam param) {
        BaseRestPaginationResult<SlpdBrandOwnerResult> brandOwnerBaseRestPagingResult = findPageList(param);
        return brandOwnerBaseRestPagingResult;
    }

    @Override
    public SlpdBrandOwnerResult findBrandOwnerByCode() {
        return slpd0405IDao.findBrandOwnerByCode();
    }
}