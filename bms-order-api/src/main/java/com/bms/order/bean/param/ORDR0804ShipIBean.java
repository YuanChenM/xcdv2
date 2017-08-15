package com.bms.order.bean.param;

import java.io.Serializable;
import java.util.List;

/**
 * 买家迟收退货数据接收接口Param
 * 发货单
 *
 * @author li_huiqian
 */
public class ORDR0804ShipIBean implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * WMS配送单号，传输WMS中配送单号信息，按现在的需求一张发货单可能分多车次发货；同收货时类似，提供WMS系统自己的配送单号
     */
    private String deliverCode;


    private List<ORDR0804ProductBean>productList;

    public String getDeliverCode() {
        return deliverCode;
    }

    public void setDeliverCode(String deliverCode) {
        this.deliverCode = deliverCode;
    }

    public List<ORDR0804ProductBean> getProductList() {
        return productList;
    }

    public void setProductList(List<ORDR0804ProductBean> productList) {
        this.productList = productList;
    }
}
