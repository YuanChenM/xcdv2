package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestFilter;

/**
 * Created by wang_jianzhou on 2017/1/18.
 */
public class ORDR0502IDetailFilterParam extends RestFilter {

    private Long receiveNotificationId;

    public Long getReceiveNotificationId() {
        return receiveNotificationId;
    }

    public void setReceiveNotificationId(Long receiveNotificationId) {
        this.receiveNotificationId = receiveNotificationId;
    }
}
