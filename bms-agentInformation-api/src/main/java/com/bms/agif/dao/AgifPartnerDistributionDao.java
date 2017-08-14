/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.dao;

import com.bms.agif.bean.param.PartnerDistributionRsParam;
import com.framework.boot.base.BaseDao;

/**
 * <p>AgifPartnerDistributionDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface AgifPartnerDistributionDao extends BaseDao {
    int findLgcsAreaIsExist(PartnerDistributionRsParam distributionRsParam);

    int findDistributionIsExist(PartnerDistributionRsParam distributionRsParam);
}