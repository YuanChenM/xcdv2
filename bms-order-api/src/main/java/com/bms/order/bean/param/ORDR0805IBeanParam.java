package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestBean;

import java.util.List;

/**
 * 买家退货入库数据接收接口Param
 *
 * @author ni_shaotang
 */
public class ORDR0805IBeanParam extends RestBean {
    //退货单ID
    private String returnId;
    //退货入库时间(yyyy-MM-dd HH:mm:ss)
    private String inboundTime;
    //入库操作人名称
    private String inboundPerson;

    //退货产品列表
    private List<ORDR0805IProductParam> productList;

    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId;
    }

    public String getInboundTime() {
        return inboundTime;
    }

    public void setInboundTime(String inboundTime) {
        this.inboundTime = inboundTime;
    }


    public List<ORDR0805IProductParam> getProductList() {
        return productList;
    }

    public void setProductList(List<ORDR0805IProductParam> productList) {
        this.productList = productList;
    }

    public String getInboundPerson() {
        return inboundPerson;
    }

    public void setInboundPerson(String inboundPerson) {
        this.inboundPerson = inboundPerson;
    }
}
