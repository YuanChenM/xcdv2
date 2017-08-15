package com.bms.slpd.services;

import com.bms.slpd.bean.entity.SlpdBrandOwnerRelation;
import com.bms.slpd.bean.result.SLPD0407IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 新增品牌绑定关旭
 */
public interface SLPD0407IService extends BaseService {
    /**
     * 新增品牌绑定关旭
     */
    @Transactional
    SLPD0407IResult saveBrandOwnerRelation(List<SlpdBrandOwnerRelation> params);
}