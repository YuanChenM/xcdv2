/*
 * 2017/02/16 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.bms.region.services.impl;

import com.bms.region.bean.entity.RegnRelation;
import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.RegnLogisticsRelationParam;
import com.bms.region.dao.RegnRelationDao;
import com.bms.region.services.RegnRelationService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * RegnRelationService接口实现类。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class RegnRelationServiceImpl extends BaseServiceImpl implements RegnRelationService {

    @Autowired
    private RegnRelationDao regnRelationDao;

    @Override
    public BaseDao getBaseDao() {
        return regnRelationDao;
    }

    @Override
    public int add(RegnLogisticsRelationParam param) {
        RegnRelation relation = BeanUtils.toBean(param, RegnRelation.class);
        relation.setRelaId(this.maxId("REGN_RELATION"));
        relation.setCrtId(this.getLoginUserId());
        relation.setUpdId(this.getLoginUserId());
//        relation.setCrtId("admin");
//        relation.setUpdId("admin");
        relation.setCrtTime(DateUtils.getCurrent());
        relation.setUpdTime(DateUtils.getCurrent());
        relation.setVersion(NumberConst.IntDef.INT_ONE);
        int res = this.save(relation);
        return res;
    }

    @Override
    public void update(BaseBean<RegnLogisticsRelationParam, RegnLogisticsRelationParam> requestParam) {
        BaseBean<RegnRelation,RegnRelation> bean = new BaseBean<>();
        RegnRelation filterEntity = BeanUtils.toBean(requestParam.getFilter(), RegnRelation.class);
        RegnRelation targetEntity = BeanUtils.toBean(requestParam.getTarget(), RegnRelation.class);
        targetEntity.setUpdTime(DateUtils.getCurrent());
//        targetEntity.setUpdId(this.getLoginUserId());
        targetEntity.setUpdId(this.getLoginUserId());
        bean.setFilter(filterEntity);
        bean.setTarget(targetEntity);
        regnRelationDao.modify(bean);
    }

    @Override
    public Map<String,Object> checkMaxCode(Map<String, Object> codeType){
        return regnRelationDao.checkMaxCode(codeType);
    };
}