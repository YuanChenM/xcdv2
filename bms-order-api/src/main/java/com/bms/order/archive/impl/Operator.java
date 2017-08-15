package com.bms.order.archive.impl;

import com.bms.order.archive.AbstractArchive;
import com.bms.order.archive.Completable;
import com.bms.order.common.rest.param.RestOperator;
import com.bms.order.constant.enumeration.OperatorType;

/**
 * 操作者
 * 
 * @author li_huiqian
 *
 */
public class Operator extends AbstractArchive implements Completable {

    /**
     * 操作者ID
     */
    private String operatorId;

    /**
     * 操作者类型（买家、卖家、买手、管家、平台订单人员、系统）
     */
    private String operatorType;

    @Override
    public void complete(boolean allowDelete) {
        // TODO Auto-generated method stub
    }

    /**
     * 是否是买家
     * 
     * @return
     */
    public boolean isBuyer() {
        return OperatorType.BUYER.getCode().equals(operatorType);
    }

    /**
     * 是否是买手
     * 
     * @return
     */
    public boolean isBs() {
        return OperatorType.BS.getCode().equals(operatorType);
    }

    /**
     * 是否是卖家
     * 
     * @return
     */
    public boolean isSeller() {
        return OperatorType.SELLER.getCode().equals(operatorType);
    }

    /**
     * 是否是冻品管家
     * 
     * @return
     */
    public boolean isSa() {
        return OperatorType.SA.getCode().equals(operatorType);
    }

    /**
     * 是否是平台订单人员
     * 
     * @return
     */
    public boolean isStaff() {
        return OperatorType.MANAGER.getCode().equals(operatorType);
    }

    /**
     * 是否是订单系统
     * 
     * @return
     */
    public boolean isOrderSystem() {
        return OperatorType.ORDER_SYSTEM.getCode().equals(operatorType);
    }

    /**
     * 是否是运输者
     * 
     * @return
     */
    public boolean isCarrier() {
        return OperatorType.MADE_4_NET.getCode().equals(operatorType);
    }

    // GETTER & SETTER

    /**
     * 是否是资金池
     * 
     * @return
     */
    public boolean isCashPool() {
        return OperatorType.CASH_POOL.getCode().equals(operatorType);
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public static class Builder {

        public static Operator build(RestOperator param) {
            Operator operator = new Operator();
            operator.setOperatorId(param.getOperatorId());
            operator.setOperatorType(param.getOperatorType());
            return operator;
        }
    }

}
