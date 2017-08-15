package com.bms.slim.services;


import com.bms.slim.bean.entity.SlimSellerBusinessQualification;
import com.bms.slim.bean.param.SLIM0105IParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0105IService extends BaseService {

    /**
     * 根据entitySellerId查询卖家经营资质
     */
    @Transactional
    SlimSellerBusinessQualification findSBQ(SLIM0105IParam entitySellerId);
}
