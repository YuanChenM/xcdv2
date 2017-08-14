package com.bms.issue.archive.impl;

import com.bms.issue.archive.AbstractArchive;
import com.bms.issue.archive.Completable;
import com.bms.issue.common.rest.param.RestOperator;
import com.bms.issue.constant.enumeration.OperatorType;

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
        OperatorType type = OperatorType.getInstance(operatorType);
        return type == OperatorType.BUYER;
    }

    /**
     * 是否是买手
     * 
     * @return
     */
    public boolean isBs() {
        OperatorType type = OperatorType.getInstance(operatorType);
        return type == OperatorType.BS;
    }

    /**
     * 是否是卖家
     * 
     * @return
     */
    public boolean isSeller() {
        OperatorType type = OperatorType.getInstance(operatorType);
        return type == OperatorType.SELLER;
    }

    /**
     * 是否是冻品管家
     * 
     * @return
     */
    public boolean isSa() {
        OperatorType type = OperatorType.getInstance(operatorType);
        return type == OperatorType.SA;
    }

    /**
     * 是否是平台订单人员
     * 
     * @return
     */
    public boolean isStaff() {
        OperatorType type = OperatorType.getInstance(operatorType);
        return type == OperatorType.MANAGER;
    }

    /**
     * 是否是订单系统
     * 
     * @return
     */
    public boolean isOrderSystem() {
        OperatorType type = OperatorType.getInstance(operatorType);
        return type == OperatorType.ORDER_SYSTEM;
    }

    /**
     * 是否是运输者
     * 
     * @return
     */
    public boolean isCarrier() {
        OperatorType type = OperatorType.getInstance(operatorType);
        return type == OperatorType.MADE_4_NET;
    }

    // GETTER & SETTER

    /**
     * 是否是资金池
     * 
     * @return
     */
    public boolean isCashPool() {
        OperatorType type = OperatorType.getInstance(operatorType);
        return type == OperatorType.CASH_POOL;
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
