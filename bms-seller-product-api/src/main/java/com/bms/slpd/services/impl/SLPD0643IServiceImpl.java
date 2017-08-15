package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdDifTspStd;
import com.bms.slpd.bean.param.field.SLPD0643ITspDifStdParam;
import com.bms.slpd.bean.result.SLPD0643IResult;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0643IDao;
import com.bms.slpd.services.SLPD0643IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SLPD0643IServiceImpl extends BaseServiceImpl implements SLPD0643IService {

    @Autowired
    private SLPD0643IDao slpd0643IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0643IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0643IResult saveTspDifStds(List<SLPD0643ITspDifStdParam> insertList) {
        Date now = DateUtils.getCurrent();
        String userId = super.getLoginUserId();

        List<SlpdDifTspStd> tspDifStdList = new ArrayList<>();
        List<Long> tspDifStdIds = new ArrayList<>();
        for (SLPD0643ITspDifStdParam param : insertList) {
            SlpdDifTspStd tspDifStd = BeanUtils.toBean(param, SlpdDifTspStd.class);
            tspDifStd.setTspDifStdId(this.maxId(TableConstant.Name.SLPD_DIF_TSP_STD));
            tspDifStd.setCrtId(userId);
            tspDifStd.setCrtTime(now);
            tspDifStd.setUpdId(userId);
            tspDifStd.setUpdTime(now);
            tspDifStdList.add(tspDifStd);
            tspDifStdIds.add(tspDifStd.getTspDifStdId());
        }
        int count = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(tspDifStdList)) {
            count = slpd0643IDao.saveTspDifStds(tspDifStdList);
        }

        SLPD0643IResult result = new SLPD0643IResult();
        result.setCount(count);
        result.setTspDifStdIds(tspDifStdIds);
        return result;
    }
}