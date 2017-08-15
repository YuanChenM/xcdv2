package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0405IParam;
import com.bms.slpd.bean.result.field.SLPD0403IBrandResult;
import com.bms.slpd.bean.result.wrapper.SlpdBrandOwnerResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 查询品牌所有人信息
 */
public interface SLPD0405IService extends BaseService {

    /**
     * 根据品牌Id查询品牌所有人信息
     */
    @Transactional(readOnly = true)
    List<SLPD0403IBrandResult> findBrandOwner(List<Long> list);

    /**
     * 查询品牌所有人信息
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SlpdBrandOwnerResult> findBrandOwenList(SLPD0405IParam param);


    /**
     * 查询最大code的数据
     */
    @Transactional(readOnly = true)
    SlpdBrandOwnerResult findBrandOwnerByCode();

}