package com.bms.slpd.services.impl;


import com.bms.slpd.bean.entity.SlpdSftStd;
import com.bms.slpd.bean.param.SLPD0616IParam;
import com.bms.slpd.bean.param.field.SLPD0616ISftStdParam;
import com.bms.slpd.bean.result.SLPD0616IResult;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0616IDao;
import com.bms.slpd.services.SLPD0616IService;
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
public class SLPD0616IServiceImpl extends BaseServiceImpl implements SLPD0616IService {
    @Autowired
    private SLPD0616IDao slpd0616IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0616IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0616IResult saveSftStds(List<SLPD0616ISftStdParam> insertList) {
        Date crtTime = DateUtils.getCurrent();
        List<SlpdSftStd> sftStdList = new ArrayList<>();
        List<Long> sftStdIds = new ArrayList<>();
        SlpdSftStd sftStd = null;

        for (SLPD0616ISftStdParam param : insertList) {
            sftStd = BeanUtils.toBean(param, SlpdSftStd.class);
            sftStd.setSftStdId(this.maxId(TableConstant.Name.SLPD_SFT_STD));
            sftStd.setCrtId(super.getLoginUserId());
            sftStd.setCrtTime(crtTime);
            sftStd.setUpdId(super.getLoginUserId());
            sftStd.setUpdTime(crtTime);
            sftStdList.add(sftStd);
            sftStdIds.add(sftStd.getSftStdId());
            // TODO 新增数据排他
        }
        int count = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(sftStdList)) {
            count = slpd0616IDao.saveSftStds(sftStdList);
        }

        SLPD0616IResult result = new SLPD0616IResult();
        result.setCount(count);
        result.setSftStdIds(sftStdIds);
        return result;
    }
}