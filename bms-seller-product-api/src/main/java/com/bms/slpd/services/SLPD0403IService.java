package com.bms.slpd.services;

import com.bms.slpd.bean.entity.SlpdBrand;
import com.bms.slpd.bean.param.SLPD0403IParam;
import com.bms.slpd.bean.result.wrapper.SlpdBrandResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 查询品牌与品牌所有人信息
 */
public interface SLPD0403IService extends BaseService {
    /**
     * 查询品牌与品牌所有人信息
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SlpdBrandResult> findBrandList(SLPD0403IParam requestParam);


    /**
     * 根据品牌名称  查询品牌信息
     */
    @Transactional(readOnly = true)
    List<SlpdBrandResult> findListByName(List<SlpdBrand> params);

    /**
     * 查询品牌最大code
     */
    @Transactional(readOnly = true)
    SlpdBrandResult findBrandByCode();


}