package com.batch.bybatch.bean.result;

import java.util.List;

/**
 * Created by guan_zhongheng on 2017/2/23.
 * 分批订单
 */
public class BuyerOrderBatchResutl{

    /** 分批订单：买家分批订单ID */
    private Long buyerBatchOrderId;

    /** 分批订单：买家分批订单编号 */
    private String buyerBatchOrderCode;

    /** 状态：买家分批单状态 [CodeMaster] */
    private String buyerBatchOrderStu;

    /** 分批订单明细 */
    private List<BuyerOrderBatchDetailResult> batchOrderDetails;

    public Long getBuyerBatchOrderId() {
        return buyerBatchOrderId;
    }

    public void setBuyerBatchOrderId(Long buyerBatchOrderId) {
        this.buyerBatchOrderId = buyerBatchOrderId;
    }

    public String getBuyerBatchOrderCode() {
        return buyerBatchOrderCode;
    }

    public void setBuyerBatchOrderCode(String buyerBatchOrderCode) {
        this.buyerBatchOrderCode = buyerBatchOrderCode;
    }

    public String getBuyerBatchOrderStu() {
        return buyerBatchOrderStu;
    }

    public void setBuyerBatchOrderStu(String buyerBatchOrderStu) {
        this.buyerBatchOrderStu = buyerBatchOrderStu;
    }

    public List<BuyerOrderBatchDetailResult> getBatchOrderDetails() {
        return batchOrderDetails;
    }

    public void setBatchOrderDetails(List<BuyerOrderBatchDetailResult> batchOrderDetails) {
        this.batchOrderDetails = batchOrderDetails;
    }
}
