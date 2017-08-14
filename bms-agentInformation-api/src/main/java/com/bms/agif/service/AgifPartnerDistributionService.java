/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service;

import com.bms.agif.bean.param.PartnerDistributionRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>AgifPartnerDistributionService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface AgifPartnerDistributionService extends BaseService {
    @Transactional(readOnly = true)
    int findLgcsAreaIsExist(PartnerDistributionRsParam distributionRsParam);

    @Transactional
    int saveDistribution(PartnerDistributionRsParam distributionRsParam);

    @Transactional(readOnly = true)
    int findDistributionIsExist(PartnerDistributionRsParam distributionRsParam);

    /*@Transactional
    int deletePartnerDistribution(PartnerDistributionRsParam distributionRsParam);*/
}