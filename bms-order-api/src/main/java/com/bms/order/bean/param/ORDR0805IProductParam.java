package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestBean;

import java.util.List;

/**
 * 退货产品
 * Created by ni_shaotang on 2017/2/27.
 */
public class ORDR0805IProductParam extends RestBean {
    //退货明细ID，对应退货XML文件中的RETURNLINE
    private String returnDetailId;
    //SKU编码
    private String skuCode;
    private List<ORDR0805ILotParam> lotList;
    public String getReturnDetailId() {
        return returnDetailId;
    }

    public void setReturnDetailId(String returnDetailId) {
        this.returnDetailId = returnDetailId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public List<ORDR0805ILotParam> getLotList() {
        return lotList;
    }

    public void setLotList(List<ORDR0805ILotParam> lotList) {
        this.lotList = lotList;
    }
}
