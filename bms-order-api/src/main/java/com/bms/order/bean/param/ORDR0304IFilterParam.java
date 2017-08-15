package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestFilter;

/**
 * 配送通知单查询接口Param
 * 
 * @author li_huiqian
 */
public class ORDR0304IFilterParam extends RestFilter {

    private static final long serialVersionUID = 4483103637320823108L;

    // 配送单id
    private Long distributionNotificationId;

    public Long getDistributionNotificationId() {
        return distributionNotificationId;
    }

    public void setDistributionNotificationId(Long distributionNotificationId) {
        this.distributionNotificationId = distributionNotificationId;
    }
}
