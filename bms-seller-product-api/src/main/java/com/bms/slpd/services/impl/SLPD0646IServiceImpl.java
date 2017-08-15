package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdDifPkgStd;
import com.bms.slpd.bean.param.field.SLPD0646IPkgDifStdParam;
import com.bms.slpd.bean.result.SLPD0646IResult;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0646IDao;
import com.bms.slpd.services.SLPD0646IService;
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
public class SLPD0646IServiceImpl extends BaseServiceImpl implements SLPD0646IService {

    @Autowired
    private SLPD0646IDao slpd0646IDao;

    @Override
    public BaseDao getBaseDao() {
      return slpd0646IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public SLPD0646IResult addDifPkgStds(List<SLPD0646IPkgDifStdParam> insertList) {
        String userId = super.getLoginUserId();
        Date now = DateUtils.getCurrent();

        List<SlpdDifPkgStd> difPkgStdList = new ArrayList<>();
        List<Long> difPkgStdIds = new ArrayList<>();
        for (SLPD0646IPkgDifStdParam param : insertList) {
            SlpdDifPkgStd difPkgStd = BeanUtils.toBean(param, SlpdDifPkgStd.class);
            difPkgStd.setPkgDifStdId(this.maxId(TableConstant.Name.SLPD_DIF_PKG_STD));
            difPkgStd.setCrtId(userId);
            difPkgStd.setCrtTime(now);
            difPkgStd.setUpdId(userId);
            difPkgStd.setUpdTime(now);
            difPkgStdList.add(difPkgStd);
            difPkgStdIds.add(difPkgStd.getPkgDifStdId());
        }

        int count = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(difPkgStdList)) {
            count = slpd0646IDao.batchInsert(difPkgStdList);
        }

        SLPD0646IResult result = new SLPD0646IResult();
        result.setCount(count);
        result.setPkgDifStdIds(difPkgStdIds);
        return result;
    }
}