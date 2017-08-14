/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service.impl;

import com.bms.agif.bean.entity.AgifButlerExpEducation;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerExpEducationRsParam;
import com.bms.agif.dao.AgifButlerExpEducationDao;
import com.bms.agif.service.AgifButlerExpEducationService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>AgifButlerExpEducationService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class AgifButlerExpEducationServiceImpl extends BaseServiceImpl implements AgifButlerExpEducationService {

    @Autowired
    private AgifButlerExpEducationDao AgifButlerExpEducationDao;

    @Override
    public BaseDao getBaseDao() {
        return AgifButlerExpEducationDao;
    }

    @Override
    public Integer saveExpEducation(ButlerExpEducationRsParam param) {
        AgifButlerExpEducation entity = BeanUtils.toBean(param, AgifButlerExpEducation.class);
        Date currentDate = DateUtils.getCurrent();
        Long id = this.maxId("AGIF_BUTLER_EXP_EDUCATION");
        entity.setEducationExpId(id);
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
    public Integer updateExpEducation(BaseBean<ButlerExpEducationRsParam, ButlerExpEducationRsParam> param) {
        Date currentDate = DateUtils.getCurrent();
        AgifButlerExpEducation filter = BeanUtils.toBean(param.getFilter(), AgifButlerExpEducation.class);
        AgifButlerExpEducation target = BeanUtils.toBean(param.getTarget(), AgifButlerExpEducation.class);
        target.setUpdId(getLoginUserId());
        target.setUpdTime(currentDate);
        BaseBean<AgifButlerExpEducation, AgifButlerExpEducation> entity = new BaseBean();
        entity.setFilter(filter);
        entity.setTarget(target);
        int count = this.modify(entity);
        return count;

    }
}