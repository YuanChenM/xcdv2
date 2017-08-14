/*
 * 2017/01/10 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.prce.service.impl;

import com.bms.prce.bean.entity.PrceMarketingWayConfig;
import com.bms.prce.bean.entity.PrceWayConfig;
import com.bms.prce.bean.param.PRCE0206IParam;
import com.bms.prce.bean.param.PRCE0206IWayConfigParam;
import com.bms.prce.bean.result.PRCE0205IWayConfigResult;
import com.bms.prce.constant.PrceCenterCodeMaster;
import com.bms.prce.dao.PrceMarketingWayConfigDao;
import com.bms.prce.dao.PrceWayConfigDao;
import com.bms.prce.service.PrceWayConfigService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>PrceWayConfigService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class PrceWayConfigServiceImpl extends BaseServiceImpl implements PrceWayConfigService {

    @Autowired
    private PrceWayConfigDao prceWayConfigDao;

    @Autowired
    private PrceMarketingWayConfigDao prceMarketingWayConfigDao;

    @Autowired
    private BaseRedisDao baseRedisDao;

    /**
     * 修改营销通道配置、通道配置
     *
     * @param param
     */
    public List<Long> modifyWayConfig(List<PRCE0206IParam> param) {
        List<Long> marketingWayConfigIds = new ArrayList<>();
        for (PRCE0206IParam mwcParam : param) {
            // 设定营销通道ID
            Long marketingWayConfigId = this.getMarketingWayConfigId(mwcParam);
            marketingWayConfigIds.add(marketingWayConfigId);
            this.modifyWayConfig(mwcParam, marketingWayConfigId);
            // 验证通道数量正确性
            this.checkQty(marketingWayConfigId);
        }
        return marketingWayConfigIds;
    }

    /**
     * 获取营销通道ID
     *
     * @param param
     */
    public Long getMarketingWayConfigId(PRCE0206IParam param) {
        PrceMarketingWayConfig prceMarketingWayConfig = prceMarketingWayConfigDao.findOne(param);
        if (prceMarketingWayConfig == null) {
            // 新增营销通道配置
            PrceMarketingWayConfig newPrceMarketingWayConfig = new PrceMarketingWayConfig();
            BeanUtils.copyProperties(param, newPrceMarketingWayConfig);
            newPrceMarketingWayConfig.setMarketingWayConfigId(baseRedisDao.getTablePrimaryKey("PRCE_MARKETING_WAY_CONFIG", 1));
            newPrceMarketingWayConfig.setCrtTime(DateUtils.getCurrent());
            newPrceMarketingWayConfig.setCrtId(super.getLoginUserId());
            prceMarketingWayConfigDao.save(newPrceMarketingWayConfig);
            return newPrceMarketingWayConfig.getMarketingWayConfigId();
        }
        return prceMarketingWayConfig.getMarketingWayConfigId();
    }

    /**
     * 验证通道数量正确性
     *
     * @param marketingWayConfigId
     */
    public void checkQty(Long marketingWayConfigId) {
        PrceWayConfig prceWayConfig = new PrceWayConfig();
        prceWayConfig.setMarketingWayConfigId(marketingWayConfigId);
        // 更新后数据库中通道
        List<PRCE0205IWayConfigResult> wayConfigResult = prceWayConfigDao.findAll(prceWayConfig);
        if (CollectionUtils.isNotEmpty(wayConfigResult)) {
            for (int i = 0; i < wayConfigResult.size(); i++) {
                PRCE0205IWayConfigResult compareWayConfig = wayConfigResult.get(i);
                if (i > 0) {
                    if (compareWayConfig.getEndQty() == null || compareWayConfig.getEndQty().compareTo(wayConfigResult.get(i - 1).getStartQty()) >= 0) {
                        throw new BusinessException("PRCE0206", "PRCE0206.E00014", String.valueOf(wayConfigResult.get(i - 1).getStartQty()), String.valueOf(compareWayConfig.getEndQty()));
                    }
                }
            }
        }
    }

    /**
     * 修改通道配置
     *
     * @param param
     * @param marketingWayConfigId
     */
    public int modifyWayConfig(PRCE0206IParam param, Long marketingWayConfigId) {
        int res = 0;
        Date nowDate = DateUtils.getCurrent();
        List<PrceWayConfig> prceWayConfigs = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(param.getWayConfigList())){
            for (PRCE0206IWayConfigParam wayConfigParam : param.getWayConfigList()) {
                PrceWayConfig prceWayConfig = new PrceWayConfig();
                BeanUtils.copyProperties(wayConfigParam, prceWayConfig);
                prceWayConfig.setMarketingWayConfigId(marketingWayConfigId);
                // 账期用户计算账期总平衡系数
                if (PrceCenterCodeMaster.USER_TYPE.ACCOUNT_BUYER.equals(param.getUserType())) {
                    prceWayConfig.setSumBalanceRatio(DecimalUtils.add(prceWayConfig.getSaBalanceRatio(),
                            DecimalUtils.add(prceWayConfig.getBalanceRatio(), prceWayConfig.getPlatBalanceRatio())));
                }
                // 修改或新增
                if (wayConfigParam.getWayConfigId() == null) {
                    prceWayConfig.setWayConfigId(baseRedisDao.getTablePrimaryKey("PRCE_WAY_CONFIG", 1));
                    prceWayConfig.setCrtTime(nowDate);
                    prceWayConfig.setCrtId(super.getLoginUserId());
                    prceWayConfigs.add(prceWayConfig);
                } else {
                    super.updateVersion("PRCE_WAY_CONFIG", new String[]{"WAY_CONFIG_ID"}, new Object[]{prceWayConfig.getWayConfigId()}, prceWayConfig.getVersion());
                    prceWayConfig.setUpdId(super.getLoginUserId());
                    prceWayConfig.setUpdTime(nowDate);
                    res += prceWayConfigDao.modify(prceWayConfig);
                }
            }
            // 批量新增
            if (CollectionUtils.isNotEmpty(prceWayConfigs)) {
                res += prceWayConfigDao.batchInsert(prceWayConfigs);
            }
        } else {
            PrceWayConfig prceWayConfig = new PrceWayConfig();
            prceWayConfig.setMarketingWayConfigId(marketingWayConfigId);
            res += prceWayConfigDao.deleteModify(prceWayConfig);
        }
        return res;
    }

    @Override
    public BaseDao getBaseDao() {
        return prceWayConfigDao;
    }
}