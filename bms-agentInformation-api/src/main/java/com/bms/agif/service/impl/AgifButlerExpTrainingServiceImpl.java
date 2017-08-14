/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service.impl;

import com.bms.agif.bean.entity.AgifButlerExpTraining;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerExpTrainingRsParam;
import com.bms.agif.dao.AgifButlerExpTrainingDao;
import com.bms.agif.service.AgifButlerExpTrainingService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>AgifButlerExpTrainingService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class AgifButlerExpTrainingServiceImpl extends BaseServiceImpl implements AgifButlerExpTrainingService {

    @Autowired
    private AgifButlerExpTrainingDao AgifButlerExpTrainingDao;

    @Override
    public BaseDao getBaseDao() {
        return AgifButlerExpTrainingDao;
    }

    @Override
    public Integer saveExpTraining(ButlerExpTrainingRsParam param) {
        AgifButlerExpTraining entity = BeanUtils.toBean(param, AgifButlerExpTraining.class);
        Date currentDate = DateUtils.getCurrent();
        Long id = this.maxId("AGIF_BUTLER_EXP_TRAINING");
        entity.setTrainingExpId(id);
        entity.setDelFlg(false);
        entity.setCrtTime(currentDate);
        entity.setUpdTime(currentDate);
        entity.setCrtId(getLoginUserId());
        entity.setUpdId(getLoginUserId());
        entity.setVersion(NumberConst.IntDef.INT_ONE);
        int count = this.save(entity);
        return count;
    }

    @Override
    public Integer updateExpTraining(BaseBean<ButlerExpTrainingRsParam, ButlerExpTrainingRsParam> param) {

        Date currentDate = DateUtils.getCurrent();
        AgifButlerExpTraining filter = BeanUtils.toBean(param.getFilter(), AgifButlerExpTraining.class);
        AgifButlerExpTraining target = BeanUtils.toBean(param.getTarget(), AgifButlerExpTraining.class);
        target.setUpdTime(currentDate);
        target.setUpdId(getLoginUserId());
        BaseBean<AgifButlerExpTraining, AgifButlerExpTraining> entity = new BaseBean();
        entity.setFilter(filter);
        entity.setTarget(target);
        int count = this.modify(entity);
        return count;
    }
}