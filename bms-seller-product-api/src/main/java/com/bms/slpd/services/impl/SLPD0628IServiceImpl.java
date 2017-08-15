package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdDifFedStd;
import com.bms.slpd.bean.param.SLPD0628IParam;
import com.bms.slpd.bean.param.field.SLPD0628IFedDifStdParam;
import com.bms.slpd.bean.result.SLPD0628IResult;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0628IDao;
import com.bms.slpd.services.SLPD0628IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SLPD0628IServiceImpl extends BaseServiceImpl implements SLPD0628IService {

    @Autowired
    private SLPD0628IDao slpd0628IDao;

    @Override
    public BaseDao getBaseDao() {
      return slpd0628IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public SLPD0628IResult addDifFedStds(List<SLPD0628IFedDifStdParam> insertList) {
        List<SlpdDifFedStd> difFedStdList = new ArrayList<>();
        List<Long> difFedStdIds = new ArrayList<>();
        Date now = DateUtils.getCurrent();

        for (SLPD0628IFedDifStdParam param : insertList) {
            SlpdDifFedStd difFedStd = BeanUtils.toBean(param, SlpdDifFedStd.class);
            difFedStd.setFedDifStdId(this.maxId(TableConstant.Name.SLPD_DIF_FED_STD));
            difFedStdIds.add(difFedStd.getFedDifStdId());

            difFedStd.setCrtTime(now);
            difFedStd.setUpdTime(now);
            difFedStd.setCrtId(super.getLoginUserId());
            difFedStd.setUpdId(super.getLoginUserId());
            difFedStdList.add(difFedStd);

        }

        int count = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(difFedStdList)) {
            count = slpd0628IDao.batchInsert(difFedStdList);
        }

        SLPD0628IResult result = new SLPD0628IResult();
        result.setCount(count);
        result.setFedDifStdIds(difFedStdIds);
        return result;
    }
}