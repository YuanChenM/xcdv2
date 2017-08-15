package com.bms.slpd.services;

import com.bms.slpd.bean.entity.SlpdBrand;
import com.bms.slpd.bean.result.SLPD0401IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *新增品牌
 */
public interface SLPD0401IService extends BaseService {
    /**
     * 新增品牌
     */
    @Transactional
    SLPD0401IResult saveBrandStandards(List<SlpdBrand> params);
}