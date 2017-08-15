package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdTspStd;
import com.bms.slpd.bean.param.field.SLPD0619ITspStdParam;
import com.bms.slpd.bean.result.SLPD0619IResult;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0619IDao;
import com.bms.slpd.services.SLPD0619IService;
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
public class SLPD0619IServiceImpl extends BaseServiceImpl implements SLPD0619IService {

    @Autowired
    private SLPD0619IDao slpd0619IDao;

    @Override
    public BaseDao getBaseDao() {
      return slpd0619IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public SLPD0619IResult addTspStds(List<SLPD0619ITspStdParam> insertList) {
        List<SlpdTspStd> tspStdList = new ArrayList<>();
        List<Long> tspStdIds = new ArrayList<>();
        Date now = DateUtils.getCurrent();

        for (SLPD0619ITspStdParam param : insertList) {
            SlpdTspStd tspStd = BeanUtils.toBean(param, SlpdTspStd.class);
            tspStd.setTspStdId(this.maxId(TableConstant.Name.SLPD_TSP_STD));
            tspStdIds.add(tspStd.getTspStdId());

            tspStd.setCrtTime(now);
            tspStd.setUpdTime(now);
            tspStd.setCrtId(super.getLoginUserId());
            tspStd.setUpdId(super.getLoginUserId());
            tspStdList.add(tspStd);
        }

        int count = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(tspStdList)) {
            count = slpd0619IDao.batchInsert(tspStdList);
        }

        SLPD0619IResult result = new SLPD0619IResult();
        result.setCount(count);
        result.setTspStdIds(tspStdIds);

        return result;
    }
}