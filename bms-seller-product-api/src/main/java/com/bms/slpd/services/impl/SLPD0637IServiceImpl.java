package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdDifGnqStd;
import com.bms.slpd.bean.param.field.SLPD0637IGnqDifStdParam;
import com.bms.slpd.bean.result.SLPD0637IResult;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0637IDao;
import com.bms.slpd.services.SLPD0637IService;
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
public class SLPD0637IServiceImpl extends BaseServiceImpl implements SLPD0637IService {

    @Autowired
    private SLPD0637IDao slpd0637IDao;

    @Override
    public BaseDao getBaseDao() {
      return slpd0637IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public SLPD0637IResult addDifGnqStds(List<SLPD0637IGnqDifStdParam> insertList) {
        List<SlpdDifGnqStd> difGnqStdList = new ArrayList<>();
        List<Long> difGnqStdIds = new ArrayList<>();
        Date now = DateUtils.getCurrent();

        for (SLPD0637IGnqDifStdParam param : insertList) {
            SlpdDifGnqStd difGnqStd = BeanUtils.toBean(param, SlpdDifGnqStd.class);
            difGnqStd.setGnqDifStdId(this.maxId(TableConstant.Name.SLPD_DIF_GNQ_STD));
            difGnqStdIds.add(difGnqStd.getGnqDifStdId());

            difGnqStd.setCrtTime(now);
            difGnqStd.setUpdTime(now);
            difGnqStd.setCrtId(super.getLoginUserId());
            difGnqStd.setUpdId(super.getLoginUserId());
            difGnqStdList.add(difGnqStd);
        }

        int count = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(difGnqStdList)) {
            count = slpd0637IDao.batchInsert(difGnqStdList);
        }

        SLPD0637IResult result = new SLPD0637IResult();
        result.setCount(count);
        result.setGnqDifStdIds(difGnqStdIds);
        return result;
    }
}