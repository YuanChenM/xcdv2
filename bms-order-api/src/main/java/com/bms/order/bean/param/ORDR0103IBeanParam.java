package com.bms.order.bean.param;

import java.util.Date;

import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.archive.impl.Cancel;
import com.bms.order.bean.entity.CancelEntity;
import com.bms.order.common.rest.param.RestBean;
import com.bms.order.constant.enumeration.BuyerOrderCancelType;
import com.bms.order.constant.enumeration.CancelModeType;

/**
 * 买家订单取消接口Param
 * 
 * @author li_huiqian
 */
public class ORDR0103IBeanParam extends RestBean {

    /**
     * 
     */
    private static final long serialVersionUID = 4457548106164448049L;

    private Long buyerOrderId;

    private String backNo;

    private String cancelType;

    private String cancelPersonType;

    private String cancelPersonId;

    private String cancelPersonCode;

    private String cancelPersonName;

    private Date cancelDateTime;

    private String cancelReason;

    private Integer ver;

    public Long getBuyerOrderId() {
        return buyerOrderId;
    }

    public void setBuyerOrderId(Long buyerOrderId) {
        this.buyerOrderId = buyerOrderId;
    }

    public String getCancelType() {
        return cancelType;
    }

    public void setCancelType(String cancelType) {
        this.cancelType = cancelType;
    }

    public String getCancelPersonType() {
        return cancelPersonType;
    }

    public void setCancelPersonType(String cancelPersonType) {
        this.cancelPersonType = cancelPersonType;
    }

    public String getCancelPersonId() {
        return cancelPersonId;
    }

    public void setCancelPersonId(String cancelPersonId) {
        this.cancelPersonId = cancelPersonId;
    }

    public String getCancelPersonCode() {
        return cancelPersonCode;
    }

    public void setCancelPersonCode(String cancelPersonCode) {
        this.cancelPersonCode = cancelPersonCode;
    }

    public String getCancelPersonName() {
        return cancelPersonName;
    }

    public void setCancelPersonName(String cancelPersonName) {
        this.cancelPersonName = cancelPersonName;
    }

    public Date getCancelDateTime() {
        return cancelDateTime;
    }

    public void setCancelDateTime(Date cancelDateTime) {
        this.cancelDateTime = cancelDateTime;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public String getBackNo() {
        return backNo;
    }

    public void setBackNo(String backNo) {
        this.backNo = backNo;
    }

    public BuyerOrder generateBuyerOrder() {
        BuyerOrder buyerOrder = BuyerOrder.build(null).forComplete(buyerOrderId);
        return buyerOrder;
    }

    public Cancel generateCancel() {
        CancelEntity entity = new CancelEntity();
        entity.setCancelModelType(CancelModeType.BUYER_ORDER_CANCEL.getCode());
        entity.setCancelModelId(buyerOrderId);
        entity.setCancelType(BuyerOrderCancelType.ALL_CANCEL.getCode());
        entity.setCancelPersonType(cancelPersonType);
        entity.setCancelPersonId(cancelPersonId);
        entity.setCancelPersonName(cancelPersonName);
        entity.setCancelPersonCode(cancelPersonCode);
        entity.setCancelDatetime(cancelDateTime);
        entity.setCancelReason(cancelReason);
        Cancel cancel = Cancel.build(null).forCreate(entity);
        return cancel;
    }
}
