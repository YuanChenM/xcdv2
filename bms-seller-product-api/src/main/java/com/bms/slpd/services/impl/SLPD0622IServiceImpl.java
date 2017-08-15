package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdPkgStd;
import com.bms.slpd.bean.entity.SlpdTspStd;
import com.bms.slpd.bean.param.field.SLPD0619ITspStdParam;
import com.bms.slpd.bean.param.field.SLPD0622IPkgStdParam;
import com.bms.slpd.bean.result.SLPD0619IResult;
import com.bms.slpd.bean.result.SLPD0622IResult;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0619IDao;
import com.bms.slpd.dao.SLPD0622IDao;
import com.bms.slpd.services.SLPD0619IService;
import com.bms.slpd.services.SLPD0622IService;
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
public class SLPD0622IServiceImpl extends BaseServiceImpl implements SLPD0622IService {

    @Autowired
    private SLPD0622IDao slpd0622IDao;

    @Override
    public BaseDao getBaseDao() {
      return slpd0622IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public SLPD0622IResult addPkgStds(List<SLPD0622IPkgStdParam> insertList) {
        List<SlpdPkgStd> pkgStdList = new ArrayList<>();
        List<Long> pkgStdIds = new ArrayList<>();
        Date now = DateUtils.getCurrent();

        for (SLPD0622IPkgStdParam param : insertList) {
            SlpdPkgStd pkgStd = BeanUtils.toBean(param, SlpdPkgStd.class);
            pkgStd.setPkgStdId(this.maxId(TableConstant.Name.SLPD_PKG_STD));
            pkgStd.setCrtTime(now);
            pkgStd.setUpdTime(now);
            pkgStd.setCrtId(super.getLoginUserId());
            pkgStd.setUpdId(super.getLoginUserId());

            pkgStdList.add(pkgStd);
            pkgStdIds.add(pkgStd.getPkgStdId());
        }

        int count = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(pkgStdList)) {
            count = slpd0622IDao.batchInsert(pkgStdList);
        }

        SLPD0622IResult result = new SLPD0622IResult();
        result.setCount(count);
        result.setPkgStdIds(pkgStdIds);
        return result;
    }
}