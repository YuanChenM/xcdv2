package com.bms.slpd.services.impl;


import com.bms.slpd.bean.entity.SlpdFedStd;
import com.bms.slpd.bean.param.field.SLPD0601IFedStdParam;
import com.bms.slpd.bean.result.SLPD0604IResult;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0604IDao;
import com.bms.slpd.services.SLPD0604IService;
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
 * 新增饲养指标档案卡
 */
@Service
public class SLPD0604IServiceImpl extends BaseServiceImpl implements SLPD0604IService {

    @Autowired
    private SLPD0604IDao slpd0604IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0604IDao;
    }

    /**
     * 新增饲养指标档案卡
     */
    @Override
    public SLPD0604IResult saveFedStandards(List<SLPD0601IFedStdParam> fedStdParams) {
        Date now = DateUtils.getCurrent();
        List<Long> fedStdIds = new ArrayList<>();
        SlpdFedStd slpdFedStd = null;
        List<SlpdFedStd> saveList = new ArrayList<>();
        for (SLPD0601IFedStdParam std : fedStdParams) {
            slpdFedStd = BeanUtils.toBean(std, SlpdFedStd.class);
            Long maxId = super.maxId(TableConstant.Name.SLPD_FED_STD);
            fedStdIds.add(maxId);
            slpdFedStd.setFedStdId(maxId);
            slpdFedStd.setUpdTime(now);
            slpdFedStd.setCrtTime(now);
            slpdFedStd.setCrtId(super.getLoginUserId());
            slpdFedStd.setUpdId(super.getLoginUserId());
            saveList.add(slpdFedStd);
        }
        int count = slpd0604IDao.batchInsert(saveList);

        SLPD0604IResult slpdResult = new SLPD0604IResult();
        slpdResult.setCount(count);
        slpdResult.setFedStdIds(fedStdIds);
        return slpdResult;
    }
}