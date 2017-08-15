package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestBean;

import java.util.Date;
import java.util.List;

/**
 * Created by liutao on 2017/1/17.
 */
public class ORDR0501IShipRestParam extends RestBean {
    private String deliverCode;

    private String actualReceiveDate;

    private List<ORDR0501IProductRestParam> productList;

    public String getDeliverCode() {
        return deliverCode;
    }

    public void setDeliverCode(String deliverCode) {
        this.deliverCode = deliverCode;
    }

    public String getActualReceiveDate() {
        return actualReceiveDate;
    }

    public void setActualReceiveDate(String actualReceiveDate) {
        this.actualReceiveDate = actualReceiveDate;
    }

    public List<ORDR0501IProductRestParam> getProductList() {
        return productList;
    }

    public void setProductList(List<ORDR0501IProductRestParam> productList) {
        this.productList = productList;
    }
}
