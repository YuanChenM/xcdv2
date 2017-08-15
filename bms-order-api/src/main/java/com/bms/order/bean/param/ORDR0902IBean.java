package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestBean;

/**
 * 买手退货单确认接口Param
 *
 * @author li_huiqian
 */
public class ORDR0902IBean extends RestBean {
    private static final long serialVersionUID = 1L;


    private Long returnId;

    private String confirmUid;

    private String confirmUname;

    private String confirmTime;

    private String confirmRemark;


    private Integer ver;


    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
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
}
