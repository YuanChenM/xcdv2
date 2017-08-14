/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service.impl;

import com.bms.agif.bean.entity.AgifButlerExpWork;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerExpWorkRsParam;
import com.bms.agif.dao.AgifButlerExpWorkDao;
import com.bms.agif.service.AgifButlerExpWorkService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>AgifButlerExpWorkService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class AgifButlerExpWorkServiceImpl extends BaseServiceImpl implements AgifButlerExpWorkService {

    @Autowired
    private AgifButlerExpWorkDao AgifButlerExpWorkDao;

    @Override
    public BaseDao getBaseDao() {
        return AgifButlerExpWorkDao;
    }

    @Override
    public Integer saveExpWork(ButlerExpWorkRsParam param) {
        AgifButlerExpWork entity = BeanUtils.toBean(param, AgifButlerExpWork.class);
        Date currentDate = DateUtils.getCurrent();
        Long id = this.maxId("AGIF_BUTLER_EXP_EDUCATION");
        entity.setWorkExpId(id);
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
    public Integer updateExpWork(BaseBean<ButlerExpWorkRsParam, ButlerExpWorkRsParam> param) {
        Date currentDate = DateUtils.getCurrent();
        AgifButlerExpWork filter = BeanUtils.toBean(param.getFilter(), AgifButlerExpWork.class);
        AgifButlerExpWork target = BeanUtils.toBean(param.getTarget(), AgifButlerExpWork.class);
        target.setUpdTime(currentDate);
        target.setUpdId(getLoginUserId());
        BaseBean<AgifButlerExpWork, AgifButlerExpWork> entity = new BaseBean();
        entity.setFilter(filter);
        entity.setTarget(target);
        int count = this.modify(entity);
        return count;
    }
}