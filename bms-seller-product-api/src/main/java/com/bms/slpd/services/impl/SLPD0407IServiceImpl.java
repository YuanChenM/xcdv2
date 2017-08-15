package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdBrandOwnerRelation;
import com.bms.slpd.bean.result.SLPD0407IResult;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0407IDao;
import com.bms.slpd.services.SLPD0407IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 新增品牌绑定关旭
 */
@Service
public class SLPD0407IServiceImpl extends BaseServiceImpl implements SLPD0407IService {
    @Autowired
    private SLPD0407IDao slpd0407IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0407IDao;
    }

    /**
     * 新增品牌绑定关旭
     */
    @Override
    public SLPD0407IResult saveBrandOwnerRelation(List<SlpdBrandOwnerRelation> params) {
        //生成ID
        List<Long> boRelationIds = new ArrayList<>();
        Date now = DateUtils.getCurrent();
        for (SlpdBrandOwnerRelation slpd : params) {
            Long brandOwnerId = super.maxId(TableConstant.Name.SLPD_BRAND_OWNER_RELATION);
            slpd.setBoRelationId(brandOwnerId);
            slpd.setUpdTime(now);
            slpd.setCrtTime(now);
            slpd.setUpdId(super.getLoginUserId());
            slpd.setCrtId(super.getLoginUserId());
            boRelationIds.add(brandOwnerId);
        }

        //插入数据
        int count = 0;
        count = slpd0407IDao.batchInsert(params);

        //返回结果
        SLPD0407IResult slpdResult = new SLPD0407IResult();
        slpdResult.setCount(count);
        slpdResult.setBoRelationIds(boRelationIds);
        return slpdResult;
    }
}