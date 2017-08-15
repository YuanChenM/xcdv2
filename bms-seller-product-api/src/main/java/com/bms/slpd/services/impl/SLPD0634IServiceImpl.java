package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdDifTncStd;
import com.bms.slpd.bean.param.field.SLPD0634ITncDifStdParam;
import com.bms.slpd.bean.result.SLPD0634IResult;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0634IDao;
import com.bms.slpd.services.SLPD0634IService;
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
public class SLPD0634IServiceImpl extends BaseServiceImpl implements SLPD0634IService {

    @Autowired
    private SLPD0634IDao slpd0634IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0634IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0634IResult saveTncDifStds(List<SLPD0634ITncDifStdParam> insertList) {
        Date crtTime = DateUtils.getCurrent();
        List<SlpdDifTncStd> tncDifStdList = new ArrayList<>();
        List<Long> tncDifStdIds = new ArrayList<>();
        SlpdDifTncStd tncDifStd = null;

        for (SLPD0634ITncDifStdParam param : insertList) {
            tncDifStd = BeanUtils.toBean(param, SlpdDifTncStd.class);
            tncDifStd.setTncDifStdId(this.maxId(TableConstant.Name.SLPD_DIF_TNC_STD));
            tncDifStd.setCrtId(super.getLoginUserId());
            tncDifStd.setCrtTime(crtTime);
            tncDifStd.setUpdId(super.getLoginUserId());
            tncDifStd.setUpdTime(crtTime);
            tncDifStdList.add(tncDifStd);
            tncDifStdIds.add(tncDifStd.getTncDifStdId());
        }
        int count = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(tncDifStdList)) {
            count = slpd0634IDao.saveTncDifStds(tncDifStdList);
        }

        SLPD0634IResult result = new SLPD0634IResult();
        result.setCount(count);
        result.setTncDifStdIds(tncDifStdIds);
        return result;
    }
}