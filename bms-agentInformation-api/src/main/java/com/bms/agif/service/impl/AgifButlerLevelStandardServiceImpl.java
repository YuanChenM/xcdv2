/*
 * 2017/05/02 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service.impl;

import com.bms.agif.bean.entity.AgifButlerLevelStandard;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerLevelStandardPageParam;
import com.bms.agif.bean.result.ButlerLevelStandardResult;
import com.bms.agif.dao.AgifButlerLevelStandardDao;
import com.bms.agif.service.AgifButlerLevelStandardService;
import com.bms.agif.util.RestCommUtil;
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
 * <p>AgifButlerLevelStandardService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class AgifButlerLevelStandardServiceImpl extends BaseServiceImpl implements AgifButlerLevelStandardService {

    @Autowired
    private AgifButlerLevelStandardDao agifButlerLevelStandardDao;

    @Override
    public BaseDao getBaseDao() {
        return agifButlerLevelStandardDao;
    }


    @Override
    public ButlerLevelStandardResult saveButlerLevelStandard(List<ButlerLevelStandardPageParam> param) {
        
        ButlerLevelStandardResult result = new ButlerLevelStandardResult();
        List<AgifButlerLevelStandard> entityList = new ArrayList<>();
        Date curTime = DateUtils.getCurrent();
        if (CollectionUtils.isNotEmpty(param)) {
            for (int i = 0; i < param.size(); i++) {
                AgifButlerLevelStandard entity = BeanUtils.toBean(param.get(i), AgifButlerLevelStandard.class);
                Long id = maxId("AGIF_BUTLER_LEVEL_STANDARD");
                entity.setLevelId(id);
                entity.setCrtId(this.getLoginUserId());
                entity.setUpdId(this.getLoginUserId());
                entity.setCrtTime(curTime);
                entity.setUpdTime(curTime);
                entity.setVersion(NumberConst.IntDef.INT_ONE);
                entity.setDelFlg(false);
                entityList.add(entity);
            }
        }
        int count = NumberConst.IntDef.INT_ZERO;
        List<List<AgifButlerLevelStandard>> toolList = RestCommUtil.insertRanking(entityList);
        if (CollectionUtils.isNotEmpty(toolList)) {
            for (int i = 0; i < toolList.size(); i++) {
                count += batchSave(toolList.get(i));
            }
        }
        result.setCount(count);
        result.setLevelStandardList(entityList);
        return result;
    }

    @Override
    public ButlerLevelStandardResult modifyButlerLevelStandard(List<BaseBean<ButlerLevelStandardPageParam, ButlerLevelStandardPageParam>> param) {
        ButlerLevelStandardResult result = new ButlerLevelStandardResult();
        int listSize = param.size();
        Date curTime = DateUtils.getCurrent();
        int resultLine = NumberConst.IntDef.INT_ZERO;
        BaseBean<AgifButlerLevelStandard, AgifButlerLevelStandard> beanEntity;

        List<AgifButlerLevelStandard> targetEntityList = new ArrayList<>();
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            beanEntity = new BaseBean<>();
            AgifButlerLevelStandard filterEntity = BeanUtils.toBean(param.get(i).getFilter(), AgifButlerLevelStandard.class);
            AgifButlerLevelStandard targetEntity = BeanUtils.toBean(param.get(i).getTarget(), AgifButlerLevelStandard.class);

            targetEntity.setUpdTime(curTime);
            targetEntity.setUpdId(getLoginUserId());
            beanEntity.setFilter(filterEntity);
            beanEntity.setTarget(targetEntity);

            targetEntityList.add(targetEntity);
            int line = this.modify(beanEntity);
            resultLine += line;
        }
        result.setLevelStandardList(targetEntityList);
        result.setCount(resultLine);
        return result;
    }
}