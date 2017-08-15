package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestBean;

import java.math.BigDecimal;

/**
 * 退货产品
 * Created by ni_shaotang on 2017/2/27.
 */
public class ORDR0805ILotParam extends RestBean {
    //退货明细ID，对应退货XML文件中的RETURNLINE
    private String unit;
    //SKU编码
    private String lotNo;

    private Integer inboundQty;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }


    public Integer getInboundQty() {
        return inboundQty;
    }

    public void setInboundQty(Integer inboundQty) {
        this.inboundQty = inboundQty;
    }
}
