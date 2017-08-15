package com.bms.order.bean.param;

import com.bms.order.archive.impl.BuyerReturn;
import com.bms.order.common.rest.param.RestBean;

/**
 * Created by Administrator on 2017/3/6.
 */
public class ORDR0808IBean extends RestBean {

    private static final long serialVersionUID = 1L;
    //退货单ID
    private Long returnId;
    //退货确认人身份
    private String confirmUserType;
    //买家退货确认方式
    private String confirmType;
    //确认人ID
    private String confirmUid;
    //确认人名称
    private String confirmUname;
    //确认时间（yyyy-MM-dd HH:mm:ss）
    private String confirmTime;
    //确认时填写的备注
    private String confirmRemark;
    //问题订单版本
    private Integer ver;

    public String getConfirmType() {
        return confirmType;
    }

    public void setConfirmType(String confirmType) {
        this.confirmType = confirmType;
    }

    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }

    public String getConfirmUserType() {
        return confirmUserType;
    }

    public void setConfirmUserType(String confirmUserType) {
        this.confirmUserType = confirmUserType;
    }

    public String getConfirmUid() {
        return confirmUid;
    }

    public void setConfirmUid(String confirmUid) {
        this.confirmUid = confirmUid;
    }

    public String getConfirmUname() {
        return confirmUname;
    }

    public void setConfirmUname(String confirmUname) {
        this.confirmUname = confirmUname;
    }

    public String getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(String confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getConfirmRemark() {
        return confirmRemark;
    }

    public void setConfirmRemark(String confirmRemark) {
        this.confirmRemark = confirmRemark;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public BuyerReturn findBuyerReturnById(){
        BuyerReturn buyerReturn = BuyerReturn.build(null).forComplete(returnId);
        return buyerReturn;
    }
}
