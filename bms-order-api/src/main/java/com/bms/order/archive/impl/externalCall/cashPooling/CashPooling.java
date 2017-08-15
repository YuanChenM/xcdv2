package com.bms.order.archive.impl.externalCall.cashPooling;

import com.bms.order.archive.impl.BsOrder;
import com.bms.order.archive.impl.BuyerOrder;

/**
 * Created by zhang_qiang1 on 2017/1/6.
 */
public class CashPooling {


    /**
     * 传输业务单据  买家订单
     *
     * @param buyerOrder
     * @return
     */
    public Boolean deliveryBuyerOrder(BuyerOrder buyerOrder) {
        return true;
    }


    /**
     * 传输业务单据  买手订单
     *
     * @param bsOrder
     * @return
     */
    public Boolean deliveryBsOrder(BsOrder bsOrder) {
        return true;
    }


    /**
     * 应收应付 买家订单
     *
     * @param buyerOrder
     * @return
     */
    public Boolean aPAPByBuyerOrder(BuyerOrder buyerOrder) {
        return true;
    }


    /**
     * 应收应付  买手订单
     *
     * @param bsOrder
     * @return
     */
    public Boolean aPAPByBsOrder(BsOrder bsOrder) {
        return true;
    }


}
