/*
 * 2017/01/10 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.prce.service.impl;

import com.bms.prce.bean.entity.PrceMarketingStatus;
import com.bms.prce.bean.param.EffectiveWayConfigParam;
import com.bms.prce.bean.param.PRCE0204IParam;
import com.bms.prce.constant.PrceCenterCodeMaster;
import com.bms.prce.constant.PrceStringConst;
import com.bms.prce.dao.PrceEffectiveWayConfigDao;
import com.bms.prce.dao.PrceMarketingStatusDao;
import com.bms.prce.service.PrceMarketingStatusService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>PrceMarketingStatusService接口实现类。</p>
 *
 * @author zhouling
 * @version 1.00
 */
@Service
public class PrceMarketingStatusServiceImpl extends BaseServiceImpl implements PrceMarketingStatusService {

    @Autowired
    private PrceMarketingStatusDao prceMarketingStatusDao;

    @Autowired
    private PrceEffectiveWayConfigDao effectiveWayConfigDao;

    @Autowired
    private BaseRedisDao baseRedisDao;

    @Override
    public BaseDao getBaseDao() {
        return prceMarketingStatusDao;
    }

    @Override
    public int modifyMarketingStatus(PRCE0204IParam param) {
        int modifyCount = 0;
        PrceMarketingStatus prceMarketingStatus = new PrceMarketingStatus();
        if (param.getOwnerId() == null && StringUtils.isEmpty(param.getOwnerName()) && StringUtils.isEmpty(param.getOwnerType())) {
            param.setOwnerId(new Long(PrceStringConst.PLATFORM_CODE));
            param.setOwnerName(PrceStringConst.PLATFORM_NAME);
            param.setOwnerType(PrceCenterCodeMaster.OWNER_TYPE.PLATFORM);
        }
        if (param.getOwnerId() == null || StringUtils.isEmpty(param.getOwnerName()) || StringUtils.isEmpty(param.getOwnerType())) {
            // 所有人字段check
            throw new BusinessException("PRCE0203", "PRCE0203.E00005");
        }
        BeanUtils.copyProperties(param, prceMarketingStatus);
        if (param.getMarketingStatusId() == null) {
            if (prceMarketingStatusDao.count(param) > 0) {
                // 营销状态名称重复
                throw new BusinessException("PRCE0203", "PRCE0203.E00001", param.getMarketingStatusName());
            }
            // 营销状态新增
            prceMarketingStatus.setMarketingStatusId(baseRedisDao.getTablePrimaryKey("MARKETING_STATUS_ID", 1));
            prceMarketingStatus.setCrtId(super.getLoginUserId());
            prceMarketingStatus.setCrtTime(DateUtils.getCurrent());
            modifyCount = prceMarketingStatusDao.save(prceMarketingStatus);
        } else {
            if (param.getDelFlg() != null && param.getDelFlg()) {
                EffectiveWayConfigParam wayConfigParam = new EffectiveWayConfigParam();
                wayConfigParam.setMarketingStatusId(param.getMarketingStatusId());
                if (effectiveWayConfigDao.count(wayConfigParam) > 0) {
                    throw new BusinessException("PRCE0203", "PRCE0203.E00007");
                }
            }
            // 版本号check
            super.updateVersion("PRCE_MARKETING_STATUS", new String[]{"MARKETING_STATUS_ID"}, new Object[]{prceMarketingStatus.getMarketingStatusId()}, prceMarketingStatus.getVersion());

            // 营销状态更新和逻辑删除
            prceMarketingStatus.setUpdId(super.getLoginUserId());
            prceMarketingStatus.setUpdTime(DateUtils.getCurrent());
            modifyCount = prceMarketingStatusDao.modify(prceMarketingStatus);
        }
        return modifyCount;
    }
}