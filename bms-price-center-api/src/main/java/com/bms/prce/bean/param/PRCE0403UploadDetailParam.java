package com.bms.prce.bean.param;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by memorykai on 2017/5/7.
 */
public class PRCE0403UploadDetailParam implements Serializable{
    private static final long serialVersionUID = 1L;
    //通道配置描述
    private String wayConfigName;
    private Long wayConfigId;
    //实际价格
    private BigDecimal factPrice;

    public String getWayConfigName() {
        return wayConfigName;
    }

    public void setWayConfigName(String wayConfigName) {
        this.wayConfigName = wayConfigName;
    }

    public Long getWayConfigId() {
        return wayConfigId;
    }

    public void setWayConfigId(Long wayConfigId) {
        this.wayConfigId = wayConfigId;
    }

    public BigDecimal getFactPrice() {
        return factPrice;
    }

    public void setFactPrice(BigDecimal factPrice) {
        this.factPrice = factPrice;
    }
}
