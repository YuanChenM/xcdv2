/*
 * 2017/02/22 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services.impl;


import com.bms.byim.bean.entity.ByimStandardGrade;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.StandardGradeRsParam;
import com.bms.byim.dao.ByimStandardGradeDao;
import com.bms.byim.services.ByimStandardGradeService;
import com.bms.byim.utils.RestCommUtil;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>ByimStandardGradeService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class ByimStandardGradeServiceImpl extends BaseServiceImpl implements ByimStandardGradeService {

    @Autowired
    private ByimStandardGradeDao byimStandardGradeDao;

    @Override
    public BaseDao getBaseDao() {
        return byimStandardGradeDao;
    }

    @Override
    public int updateStandardGrade(List<BaseBean<StandardGradeRsParam, StandardGradeRsParam>> param) {
        int listSize = param.size();
        Date curTime = DateUtils.getCurrent();
        int resultLine = NumberConst.IntDef.INT_ZERO;
        BaseBean<ByimStandardGrade, ByimStandardGrade> beanEntity;
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            beanEntity = new BaseBean<>();
            ByimStandardGrade filterEntity = BeanUtils.toBean(param.get(i).getFilter(), ByimStandardGrade.class);
            ByimStandardGrade targetEntity = BeanUtils.toBean(param.get(i).getTarget(), ByimStandardGrade.class);
            targetEntity.setUpdTime(curTime);
            targetEntity.setUpdId(getLoginUserId());
            beanEntity.setFilter(filterEntity);
            beanEntity.setTarget(targetEntity);
            int line = byimStandardGradeDao.modify(beanEntity);
            resultLine += line;
        }
        return resultLine;
    }

    @Override
    public int insertStandardGrade(List<StandardGradeRsParam> param) {
        List<ByimStandardGrade> entityList = new ArrayList<>();
        Date curTime = DateUtils.getCurrent();
        if (CollectionUtils.isNotEmpty(param)) {
            int size = param.size();
            for (int i = NumberConst.IntDef.INT_ZERO; i < size; i++) {
                ByimStandardGrade StandardGrade = BeanUtils.toBean(param.get(i), ByimStandardGrade.class);
                Long levelStandardId = this.maxId("BYIM_STANDARD_GRADE");
                StandardGrade.setGradeStandardId(levelStandardId);

                StandardGrade.setUpdTime(curTime);
                StandardGrade.setUpdId(getLoginUserId());
                StandardGrade.setCrtTime(curTime);
                StandardGrade.setCrtId(getLoginUserId());
                StandardGrade.setDelFlg(false);
                StandardGrade.setVersion(NumberConst.IntDef.INT_ZERO);

                entityList.add(StandardGrade);
            }
        }
        int count = NumberConst.IntDef.INT_ZERO;
        List<List<ByimStandardGrade>> utilList = RestCommUtil.insertRanking(entityList);
        if (CollectionUtils.isNotEmpty(utilList)) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < utilList.size(); i++) {
                count += this.batchSave(utilList.get(i));
            }
        }
        return count;
    }
}