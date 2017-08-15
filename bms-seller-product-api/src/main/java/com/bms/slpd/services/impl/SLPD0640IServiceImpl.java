package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdDifSftStd;
import com.bms.slpd.bean.param.field.SLPD0640ISftDifStdParam;
import com.bms.slpd.bean.result.SLPD0640IResult;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0640IDao;
import com.bms.slpd.services.SLPD0640IService;
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

/**
 * <p>新增安全标准指标差异卡</p>
 */
@Service
public class SLPD0640IServiceImpl extends BaseServiceImpl implements SLPD0640IService {

    @Autowired
    private SLPD0640IDao slpd0640IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0640IDao;
    }

    /**
     * <p>新增安全标准指标差异卡</p>
     */
    @Override
    public SLPD0640IResult saveDifSftStandards(List<SLPD0640ISftDifStdParam> params) {
        Date now = DateUtils.getCurrent();
        String userId = super.getLoginUserId();

        List<SlpdDifSftStd> difSftStds = new ArrayList<>();
        List<Long> difSftStdIds = new ArrayList<>();
        for (SLPD0640ISftDifStdParam std : params) {
            SlpdDifSftStd difSftStd = BeanUtils.toBean(std, SlpdDifSftStd.class);
            Long maxId = super.maxId(TableConstant.Name.SLPD_DIF_SFT_STD);
            difSftStd.setSftDifStdId(maxId);
            difSftStd.setCrtId(super.getLoginUserId());
            difSftStd.setCrtTime(now);
            difSftStd.setUpdId(super.getLoginUserId());
            difSftStd.setUpdTime(now);
            difSftStds.add(difSftStd);
            difSftStdIds.add(maxId);
        }
        int count = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(difSftStds)) {
            count = slpd0640IDao.batchInsert(difSftStds);
        }

        SLPD0640IResult slpdResult = new SLPD0640IResult();
        slpdResult.setCount(count);
        slpdResult.setSftDifStdIds(difSftStdIds);
        return slpdResult;
    }
}