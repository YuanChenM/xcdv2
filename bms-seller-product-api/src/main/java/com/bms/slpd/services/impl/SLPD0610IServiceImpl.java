package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdTncStd;
import com.bms.slpd.bean.param.SLPD0610IParam;
import com.bms.slpd.bean.param.field.SLPD0610ITncStdParam;
import com.bms.slpd.bean.result.SLPD0610IResult;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0610IDao;
import com.bms.slpd.services.SLPD0610IService;
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
public class SLPD0610IServiceImpl extends BaseServiceImpl implements SLPD0610IService {

    @Autowired
    private SLPD0610IDao slpd0610IDao;

    @Override
    public BaseDao getBaseDao() {
      return slpd0610IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public SLPD0610IResult addTncStds(List<SLPD0610ITncStdParam> insertList) {
        List<SlpdTncStd> tncStdList = new ArrayList<>();
        List<Long> tncStdIds = new ArrayList<>();
        Date now = DateUtils.getCurrent();

        for (SLPD0610ITncStdParam param : insertList) {
            SlpdTncStd tncStd = BeanUtils.toBean(param, SlpdTncStd.class);
            tncStd.setTncStdId(this.maxId(TableConstant.Name.SLPD_TNC_STD));
            tncStdIds.add(tncStd.getTncStdId());

            tncStd.setCrtTime(now);
            tncStd.setUpdTime(now);
            tncStd.setCrtId(super.getLoginUserId());
            tncStd.setUpdId(super.getLoginUserId());

            tncStdList.add(tncStd);
        }

        int count = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(tncStdList)) {
            count = slpd0610IDao.batchInsert(tncStdList);
        }

        SLPD0610IResult result = new SLPD0610IResult();
        result.setCount(count);
        result.setTncStdIds(tncStdIds);
        return result;
    }
}