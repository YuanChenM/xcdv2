package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdMctStd;
import com.bms.slpd.bean.param.field.SLPD0607IMctStdParam;
import com.bms.slpd.bean.result.SLPD0607IResult;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0607IDao;
import com.bms.slpd.services.SLPD0607IService;
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
public class SLPD0607IServiceImpl extends BaseServiceImpl implements SLPD0607IService {

    @Autowired
    private SLPD0607IDao slpd0607IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0607IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0607IResult saveMctStds(List<SLPD0607IMctStdParam> insertList) {
        Date crtTime = DateUtils.getCurrent();
        List<SlpdMctStd> mctStdList = new ArrayList<>();
        List<Long> mctStdIds = new ArrayList<>();
        SlpdMctStd mctStd = null;

        for (SLPD0607IMctStdParam param : insertList) {
            mctStd = BeanUtils.toBean(param, SlpdMctStd.class);
            mctStd.setMctStdId(this.maxId(TableConstant.Name.SLPD_MCT_STD));
            mctStd.setCrtId(super.getLoginUserId());
            mctStd.setCrtTime(crtTime);
            mctStd.setUpdId(super.getLoginUserId());
            mctStd.setUpdTime(crtTime);
            mctStdList.add(mctStd);
            mctStdIds.add(mctStd.getMctStdId());
            // TODO 新增数据排他
        }
        int count = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(mctStdList)) {
            count = slpd0607IDao.saveMctStds(mctStdList);
        }

        SLPD0607IResult result = new SLPD0607IResult();
        result.setCount(count);
        result.setMctStdIds(mctStdIds);
        return result;
    }
}