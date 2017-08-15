package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdDifOrgStd;
import com.bms.slpd.bean.param.SLPD0625IParam;
import com.bms.slpd.bean.param.field.SLPD0625IOrgDifStdParam;
import com.bms.slpd.bean.result.SLPD0625IResult;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0625IDao;
import com.bms.slpd.services.SLPD0625IService;
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
public class SLPD0625IServiceImpl extends BaseServiceImpl implements SLPD0625IService {

    @Autowired
    private SLPD0625IDao slpd0625IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0625IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0625IResult saveOrgDifStds(List<SLPD0625IOrgDifStdParam> insertList) {
        Date crtTime = DateUtils.getCurrent();
        List<SlpdDifOrgStd> orgDifStdList = new ArrayList<>();
        List<Long> orgDifStdIds = new ArrayList<>();

        for (SLPD0625IOrgDifStdParam param : insertList) {
            SlpdDifOrgStd orgDifStd = BeanUtils.toBean(param, SlpdDifOrgStd.class);
            orgDifStd.setOrgDifStdId(this.maxId(TableConstant.Name.SLPD_DIF_ORG_STD));
            orgDifStd.setCrtTime(crtTime);
            orgDifStd.setUpdTime(crtTime);
            orgDifStd.setCrtId(super.getLoginUserId());
            orgDifStd.setUpdId(super.getLoginUserId());
            orgDifStdList.add(orgDifStd);
            orgDifStdIds.add(orgDifStd.getOrgDifStdId());
        }
        int count = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(orgDifStdList)) {
            count = slpd0625IDao.saveOrgDifStds(orgDifStdList);
        }

        SLPD0625IResult result = new SLPD0625IResult();
        result.setCount(count);
        result.setOrgDifStdIds(orgDifStdIds);
        return result;
    }
}