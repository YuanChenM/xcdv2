package com.bms.slpd.services;

import com.bms.slpd.bean.entity.SlpdBrandOwner;
import com.bms.slpd.bean.result.SLPD0404IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 新增品牌所有人信息
 */
public interface SLPD0404IService extends BaseService {

    /**
     * 新增品牌所有人信息
     */
    @Transactional
    SLPD0404IResult saveSlpdBrandOwners(List<SlpdBrandOwner> params);
}