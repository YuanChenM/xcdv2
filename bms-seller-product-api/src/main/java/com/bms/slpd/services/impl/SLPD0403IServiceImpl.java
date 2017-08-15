package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdBrand;
import com.bms.slpd.bean.param.SLPD0403IParam;
import com.bms.slpd.bean.result.field.SLPD0403IBrandResult;
import com.bms.slpd.bean.result.wrapper.SlpdBrandResult;
import com.bms.slpd.dao.SLPD0403IDao;
import com.bms.slpd.services.SLPD0403IService;
import com.bms.slpd.services.SLPD0405IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * 查询品牌信息
 */
@Service
public class SLPD0403IServiceImpl extends BaseServiceImpl implements SLPD0403IService {
    @Autowired
    private SLPD0405IService slpd0405IService;

    @Autowired
    private SLPD0403IDao slpd0403IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0403IDao;
    }

    /**
     * 查询品牌与品牌所有人信息
     */
    @Override
    public BaseRestPaginationResult<SlpdBrandResult> findBrandList(SLPD0403IParam param) {
        //查询品牌信息
        BaseRestPaginationResult<SlpdBrandResult> pagingResult = findPageList(param);
        //查询实际总条数
        pagingResult.setTotal(getCount(param));

        //去除联表产生的重复品牌信息
        LinkedHashMap<Long, SlpdBrandResult> brandMap = new LinkedHashMap<>();
        for (SlpdBrandResult slpdBrandResult : pagingResult.getData()) {
            brandMap.put(slpdBrandResult.getBrandId(), slpdBrandResult);
        }

        //查询品牌所有人信息
        List<Long> ids = new ArrayList<>();
        for (SlpdBrandResult slpdBrandOwners : pagingResult.getData()) {
            ids.add(slpdBrandOwners.getBrandId());
        }
        if (ids.size() > 0) {
            List<SLPD0403IBrandResult> slpd040301IResults = slpd0405IService.findBrandOwner(ids);
            for (SLPD0403IBrandResult s : slpd040301IResults) {
                SlpdBrandResult slpdResult = brandMap.get(s.getBrandId());
                slpdResult.setBrandOwnerList(s.getSlpdBrandOwnerList());
            }
        }
        //关联品牌与品牌所有人信息
        List<SlpdBrandResult> slpdBrandResultList = new ArrayList<>();
        Iterator iterator = brandMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            slpdBrandResultList.add((SlpdBrandResult) entry.getValue());
        }
        pagingResult.setData(slpdBrandResultList);
        return pagingResult;
    }

    /**
     * 根据品牌名称  查询品牌信息
     */
    @Override
    public List<SlpdBrandResult> findListByName(List<SlpdBrand> params) {
        return slpd0403IDao.findListByName(params);
    }


    /**
     * 查询品牌最大code
     */
    @Override
    public SlpdBrandResult findBrandByCode() {
        return slpd0403IDao.findBrandByCode();
    }

}