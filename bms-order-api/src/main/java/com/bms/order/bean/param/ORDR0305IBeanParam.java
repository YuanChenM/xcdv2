package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestBean;

/**
 * 买手订单修改接口Param
 *
 * @author li_huiqian
 */
public class ORDR0305IBeanParam extends RestBean {

    /**
     *
     */
    private static final long serialVersionUID = 7587739776851257898L;

    private Long distributionNotificationId;// 配送单Id

    private Long whId;// 仓库ID

    private String whCode;// 仓库编码

    private String whName;// 仓库名称


    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public Long getDistributionNotificationId() {
        return distributionNotificationId;
    }

    public void setDistributionNotificationId(Long distributionNotificationId) {
        this.distributionNotificationId = distributionNotificationId;
    }

    public Long getWhId() {
        return whId;
    }

    public void setWhId(Long whId) {
        this.whId = whId;
    }
}
