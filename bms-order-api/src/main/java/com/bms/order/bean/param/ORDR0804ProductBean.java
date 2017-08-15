package com.bms.order.bean.param;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 买家迟收退货数据接收接口Param
 * 发货单中的商品
 *
 * @author li_huiqian
 */
public class ORDR0804ProductBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long shipDetailId;
    private String skuCode;
    private BigDecimal returnQty;
    private Long detailReasonID;
    private String detailReasonName;

    public Long getShipDetailId() {
        return shipDetailId;
    }

    public void setShipDetailId(Long shipDetailId) {
        this.shipDetailId = shipDetailId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public BigDecimal getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(BigDecimal returnQty) {
        this.returnQty = returnQty;
    }

    public Long getDetailReasonID() {
        return detailReasonID;
    }

    public void setDetailReasonID(Long detailReasonID) {
        this.detailReasonID = detailReasonID;
    }

    public String getDetailReasonName() {
        return detailReasonName;
    }

    public void setDetailReasonName(String detailReasonName) {
        this.detailReasonName = detailReasonName;
    }
}
