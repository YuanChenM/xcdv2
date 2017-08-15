package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdDifMctStd;
import com.bms.slpd.bean.param.field.SLPD0631IMctDifStdParam;
import com.bms.slpd.bean.result.SLPD0631IResult;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0631IDao;
import com.bms.slpd.services.SLPD0631IService;
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
 *<p>新增加工技术标准指标差异卡</p>
 */
@Service
public class SLPD0631IServiceImpl extends BaseServiceImpl implements SLPD0631IService {

    @Autowired
    private SLPD0631IDao slpd0631IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0631IDao;
    }

    /**
     *<p>新增加工技术标准指标差异卡</p>
     */
    @Override
    public SLPD0631IResult saveDifMctStandards(List<SLPD0631IMctDifStdParam> params) {

        Date now = DateUtils.getCurrent();
        List<Long> difMctStdIds = new ArrayList<>();
        List<SlpdDifMctStd> difMctStdList = new ArrayList<>();
        SlpdDifMctStd difMctStd = null;
        for (SLPD0631IMctDifStdParam std : params) {
            Long maxId = super.maxId(TableConstant.Name.SLPD_DIF_MCT_STD);
            difMctStdIds.add(maxId);
            difMctStd = BeanUtils.toBean(std,SlpdDifMctStd.class);
            difMctStd.setMctDifStdId(maxId);
            difMctStd.setCrtTime(now);
            difMctStd.setUpdTime(now);
            difMctStd.setCrtId(super.getLoginUserId());
            difMctStd.setUpdId(super.getLoginUserId());
            difMctStdList.add(difMctStd);
        }
        int count = slpd0631IDao.batchInsert(difMctStdList);

        SLPD0631IResult slpdResult = new SLPD0631IResult();
        slpdResult.setCount(count);
        slpdResult.setMctDifStdIds(difMctStdIds);
        return slpdResult;
    }

}