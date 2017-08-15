package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdOrgStd;
import com.bms.slpd.bean.param.field.SLPD0601IOrgStdParam;
import com.bms.slpd.bean.result.SLPD0601IResult;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0601IDao;
import com.bms.slpd.services.SLPD0601IService;
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
public class SLPD0601IServiceImpl extends BaseServiceImpl implements SLPD0601IService {

    @Autowired
    private SLPD0601IDao slpd0601IDao;

    @Override
    public BaseDao getBaseDao() {
      return slpd0601IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public SLPD0601IResult addOrgStds(List<SLPD0601IOrgStdParam> insertList) {
        List<SlpdOrgStd> orgStdList = new ArrayList<>();
        List<Long> orgStdIds = new ArrayList<>();
        Date now = DateUtils.getCurrent();

        for (SLPD0601IOrgStdParam param : insertList) {
            SlpdOrgStd orgStd = BeanUtils.toBean(param, SlpdOrgStd.class);
            orgStd.setOrgStdId(this.maxId(TableConstant.Name.SLPD_ORG_STD));
            orgStdIds.add(orgStd.getOrgStdId());

            orgStd.setCrtTime(now);
            orgStd.setUpdTime(now);
            orgStd.setCrtId(super.getLoginUserId());
            orgStd.setUpdId(super.getLoginUserId());
            orgStdList.add(orgStd);

        }

        int count = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(orgStdList)) {
            count = slpd0601IDao.batchInsert(orgStdList);
        }

        SLPD0601IResult result = new SLPD0601IResult();
        result.setCount(count);
        result.setOrgStdIds(orgStdIds);
        return result;
    }
}