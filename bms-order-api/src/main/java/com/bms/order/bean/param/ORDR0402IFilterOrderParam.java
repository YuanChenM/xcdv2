package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestBean;

import java.io.Serializable;

/**
 * 订单信息及对应价盘查询接口Param
 * 
 * @author li_huiqian
 */
public class ORDR0402IFilterOrderParam extends RestBean {
        private Long shipId;

        public Long getShipId() {
            return shipId;
        }

        public void setShipId(Long shipId) {
            this.shipId = shipId;
        }
}
