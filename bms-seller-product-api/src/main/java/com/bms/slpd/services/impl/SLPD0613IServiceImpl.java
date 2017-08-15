package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdGnqStd;
import com.bms.slpd.bean.param.field.SLPD0613IGnqStdParam;
import com.bms.slpd.bean.result.SLPD0613IResult;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0613IDao;
import com.bms.slpd.services.SLPD0613IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *新增通用质量标准指标档案卡
 */
@Service
public class SLPD0613IServiceImpl extends BaseServiceImpl implements SLPD0613IService {

    @Autowired
    private SLPD0613IDao slpd0613IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0613IDao;
    }

    /**
     *新增通用质量标准指标档案卡
     */
    @Override
    public SLPD0613IResult saveGnqStandards(List<SLPD0613IGnqStdParam> params) {
        Date now = DateUtils.getCurrent();
        List<Long> gnqStdIds = new ArrayList<>();
        List<SlpdGnqStd> gnqStdList = new ArrayList<>();
        SlpdGnqStd gnqStd = null;
        for (SLPD0613IGnqStdParam std : params) {
            Long maxId = super.maxId(TableConstant.Name.SLPD_GNQ_STD);
            gnqStdIds.add(maxId);
            gnqStd = BeanUtils.toBean(std,SlpdGnqStd.class);
            gnqStd.setGnqStdId(maxId);
            gnqStd.setCrtTime(now);
            gnqStd.setUpdTime(now);
            gnqStd.setUpdId(super.getLoginUserId());
            gnqStd.setCrtId(super.getLoginUserId());
            gnqStdList.add(gnqStd);
        }

        int count = slpd0613IDao.batchInsert(gnqStdList);

        SLPD0613IResult slpdResult = new SLPD0613IResult();
        slpdResult.setCount(count);
        slpdResult.setGnqStdIds(gnqStdIds);
        return slpdResult;
    }
}