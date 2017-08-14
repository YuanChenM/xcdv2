/*
 * 2017/01/10 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.prce.service.impl;

import com.bms.prce.bean.entity.PrceWayType;
import com.bms.prce.bean.param.EffectiveWayConfigParam;
import com.bms.prce.bean.param.PRCE0202IParam;
import com.bms.prce.dao.PrceEffectiveWayConfigDao;
import com.bms.prce.dao.PrceWayTypeDao;
import com.bms.prce.service.PrceWayTypeService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>PrceWayTypeService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class PrceWayTypeServiceImpl extends BaseServiceImpl implements PrceWayTypeService {

    @Autowired
    private PrceWayTypeDao prceWayTypeDao;

    @Autowired
    private PrceEffectiveWayConfigDao effectiveWayConfigDao;

    @Autowired
    private BaseRedisDao baseRedisDao;

    /**
     * 修改通道分类
     *
     * @param param
     */
    @Override
    public int modifyWayType(PRCE0202IParam param) {
        // 验证通道分类名称、排序不重复
        this.validator(param);
        int res = 0;
        PrceWayType prceWayType = new PrceWayType();
        BeanUtils.copyProperties(param, prceWayType);
        if (param.getWayTypeId() == null) {
            prceWayType.setWayTypeId(baseRedisDao.getTablePrimaryKey("PRCE_WAY_TYPE", 1));
            prceWayType.setCrtTime(DateUtils.getCurrent());
            prceWayType.setCrtId(super.getLoginUserId());
            res = prceWayTypeDao.save(prceWayType);
        } else {
            if (param.getDelFlg() != null && param.getDelFlg()) {
                EffectiveWayConfigParam wayConfigParam = new EffectiveWayConfigParam();
                wayConfigParam.setWayTypeId(param.getWayTypeId());
                if (effectiveWayConfigDao.count(wayConfigParam) > 0) {
                    throw new BusinessException("PRCE0202", "PRCE0203.E00007");
                }
            }
            super.updateVersion("PRCE_WAY_TYPE", new String[]{"WAY_TYPE_ID"}, new Object[]{prceWayType.getWayTypeId()}, prceWayType.getVersion());
            prceWayType.setUpdId(super.getLoginUserId());
            prceWayType.setUpdTime(DateUtils.getCurrent());
            res = prceWayTypeDao.modify(prceWayType);
        }
        return res;
    }

    /**
     * 验证通道分类名称不重复
     *
     * @param param
     */
    public void validator(PRCE0202IParam param) {
        if (param.getDelFlg() == null || !param.getDelFlg()) {
            PrceWayType prceWayType = new PrceWayType();
            prceWayType.setWayTypeName(param.getWayTypeName());
            prceWayType.setWayTypeId(param.getWayTypeId());
            if (prceWayTypeDao.count(prceWayType) > 0) {
                throw new BusinessException("PRCE0202", "PRCE0202.E00006", prceWayType.getWayTypeName());
            }
        }
    }

    @Override
    public BaseDao getBaseDao() {
        return prceWayTypeDao;
    }
}