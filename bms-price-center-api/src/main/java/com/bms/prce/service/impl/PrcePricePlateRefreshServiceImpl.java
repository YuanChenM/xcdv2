/*
 * 2017/01/10 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.prce.service.impl;

import com.bms.prce.bean.entity.PrceEffectiveWayConfig;
import com.bms.prce.bean.param.PRCE0210IDealParam;
import com.bms.prce.bean.param.PRCE0210IParam;
import com.bms.prce.dao.PrceEffectiveWayConfigDao;
import com.bms.prce.dao.PrcePricePlateDao;
import com.bms.prce.dao.PrcePricePlateDetailDao;
import com.bms.prce.service.PrcePricePlateHistoryService;
import com.bms.prce.service.PrcePricePlateRefreshService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import com.framework.redis.dao.BaseRedisDao;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>PrcePricePlateRefreshServiceImpl接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class PrcePricePlateRefreshServiceImpl extends BaseServiceImpl implements PrcePricePlateRefreshService {

    @Autowired
    private PrceEffectiveWayConfigDao effectiveWayConfigDao;

    @Autowired
    private PrcePricePlateDao pricePlateDao;

    @Autowired
    private PrcePricePlateDetailDao pricePlateDetailDao;

    @Autowired
    private BaseRedisDao baseRedisDao;

    @Autowired
    private PrcePricePlateHistoryService pricePlateHistoryService;

    /**
     * 刷新价盘
     *
     * @param param
     */
    public void refreshPricePlate(PRCE0210IParam param) {
        PRCE0210IDealParam dealParam = new PRCE0210IDealParam();
        BeanUtils.copyProperties(param, dealParam);
        dealParam.setUpdTime(DateUtils.getCurrent());
        dealParam.setUpdTimeStr(DateUtils.formatDateTime(dealParam.getUpdTime()));
        dealParam.setUpdId(super.getLoginUserId());
        // 处理通道
        if (this.dealMarketingWay(dealParam)) {
            // 通道信息全部删除情况
            // 删除未生效价盘
            pricePlateDao.deleteModify(dealParam);
            // 查询开始时间大于等于当前时间的价盘
            dealParam.setSearchFlg(2);
            pricePlateDao.modifyByTime(dealParam);
        } else {
            // 删除未生效价盘
            pricePlateDao.deleteModify(dealParam);
            // 更新开始时间等于当前的价盘
            this.modifyStartNowPlate(dealParam);
            // 更新当前价盘结束时间，生成新加盘
            this.insertNewPlate(dealParam);
        }
        // 保存履历
        pricePlateHistoryService.saveHistory(dealParam);
    }

    /**
     * 处理通道
     *
     * @param param
     */
    public Boolean dealMarketingWay(PRCE0210IDealParam param) {
        // 逻辑删除旧生效通道
        effectiveWayConfigDao.modify(param);
        // 插入新生效通道
        List<PrceEffectiveWayConfig> prceEffectiveWayConfigs = effectiveWayConfigDao.findAll(param);
        if (CollectionUtils.isNotEmpty(prceEffectiveWayConfigs)) {
            Long maxId = baseRedisDao.getTablePrimaryKey("PRCE_EFFECTIVE_WAY_CONFIG", prceEffectiveWayConfigs.size());
            for (PrceEffectiveWayConfig prceEffectiveWayConfig : prceEffectiveWayConfigs) {
                prceEffectiveWayConfig.setWayEffectiveConfigId(maxId--);
                prceEffectiveWayConfig.setCrtId(param.getUpdId());
                prceEffectiveWayConfig.setCrtTime(param.getUpdTime());
            }
            effectiveWayConfigDao.batchInsert(prceEffectiveWayConfigs);
            return false;
        } else {
            return true;
        }
    }

    /**
     * 更新开始时间等于当前的价盘
     *
     * @param param
     */
    public void modifyStartNowPlate(PRCE0210IDealParam param) {
        param.setSearchFlg(0);
        // 查询开始时间为当前时间的价盘
        if (pricePlateDao.modifyByTime(param) > 0) {
            pricePlateDetailDao.batchDelete(param);
            pricePlateDetailDao.save(param);
        }
    }

    /**
     * 更新现价盘结束时间，生成新价盘
     *
     * @param param
     */
    public void insertNewPlate(PRCE0210IDealParam param) {
        param.setSearchFlg(1);
        // 插入新价盘
        pricePlateDao.saveByTime(param);
        // 更新现价盘结束时间为当前时间
        pricePlateDao.modifyByTime(param);
        // 插入新价盘详细
        pricePlateDetailDao.save(param);
    }

    @Override
    public BaseDao getBaseDao() {
        return effectiveWayConfigDao;
    }
}