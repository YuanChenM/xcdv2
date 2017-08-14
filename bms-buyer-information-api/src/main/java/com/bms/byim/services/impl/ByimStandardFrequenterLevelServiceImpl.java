/*
 * 2017/02/22 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services.impl;

import com.bms.byim.bean.entity.ByimStandardFrequenterLevel;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.StandardFrequenterLevelRsParam;
import com.bms.byim.dao.ByimStandardFrequenterLevelDao;
import com.bms.byim.services.ByimStandardFrequenterLevelService;
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
 * <p>ByimStandardFrequenterLevelService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class ByimStandardFrequenterLevelServiceImpl extends BaseServiceImpl implements ByimStandardFrequenterLevelService {

    @Autowired
    private ByimStandardFrequenterLevelDao byimStandardFrequenterLevelDao;

    @Override
    public BaseDao getBaseDao() {
        return byimStandardFrequenterLevelDao;
    }

    @Override
    public int updateFrequenterLevel(List<BaseBean<StandardFrequenterLevelRsParam, StandardFrequenterLevelRsParam>> param) {
        int listSize = param.size();
        Date curTime = DateUtils.getCurrent();
        int resultLine = NumberConst.IntDef.INT_ZERO;
        BaseBean<ByimStandardFrequenterLevel, ByimStandardFrequenterLevel> beanEntity;
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            beanEntity = new BaseBean<>();
            ByimStandardFrequenterLevel filterEntity = BeanUtils.toBean(param.get(i).getFilter(), ByimStandardFrequenterLevel.class);
            ByimStandardFrequenterLevel targetEntity = BeanUtils.toBean(param.get(i).getTarget(), ByimStandardFrequenterLevel.class);
            targetEntity.setUpdTime(curTime);
            targetEntity.setUpdId(getLoginUserId());
            beanEntity.setFilter(filterEntity);
            beanEntity.setTarget(targetEntity);

            int line = byimStandardFrequenterLevelDao.modify(beanEntity);
            resultLine += line;

        }
        return resultLine;
    }

    @Override
    public int insertFrequenterLevel(List<StandardFrequenterLevelRsParam> param) {

        List<ByimStandardFrequenterLevel> entityList = new ArrayList<>();
        Date curTime = DateUtils.getCurrent();
        if (CollectionUtils.isNotEmpty(param)) {
            int size = param.size();
            for (int i = NumberConst.IntDef.INT_ZERO; i < size; i++) {
                ByimStandardFrequenterLevel standardFrequenterLevel = BeanUtils.toBean(param.get(i), ByimStandardFrequenterLevel.class);
                Long levelStandardId = this.maxId("BYIM_STANDARD_FREQUENTER_LEVEL");
                standardFrequenterLevel.setLevelStandardId(levelStandardId);
                standardFrequenterLevel.setUpdTime(curTime);
                standardFrequenterLevel.setUpdId(getLoginUserId());
                standardFrequenterLevel.setCrtTime(curTime);
                standardFrequenterLevel.setCrtId(getLoginUserId());
                standardFrequenterLevel.setDelFlg(false);
                standardFrequenterLevel.setVersion(NumberConst.IntDef.INT_ZERO);
                entityList.add(standardFrequenterLevel);
            }
        }
        int count = NumberConst.IntDef.INT_ZERO;
        List<List<ByimStandardFrequenterLevel>> utilList = RestCommUtil.insertRanking(entityList);
        if (CollectionUtils.isNotEmpty(utilList)) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < utilList.size(); i++) {
                count += this.batchSave(utilList.get(i));
            }
        }
        return count;
    }
}