package com.bms.order.bean.result;

import com.bms.order.common.rest.result.RestSearchData;

import java.math.BigDecimal;
import java.util.List;

/**
 * 买家退货信息查询接口Result
 *
 * @author li_huiqian
 */
public class ORDR0807IRestResult extends RestSearchData {

    private static final long serialVersionUID = 1L;

    /**
     * 退货单ID
     */
    private Long returnId;
    /**
     * 退货单编码
     */
    private String returnCode;
    /**
     * 订单ID
     */
    private Long orderId;

       /**
     * 买家ID
     */
    private String buyerId;
    /**
     * 买家编码
     */
    private String buyerCode;
    /**
     * 买家名称
     */
    private String buyerName;
    /**
     * 退货单来源
     */
    private String returnSource;
    /**
     * 退货类型
     */
    private String returnType;
    /**
     * 退货总金额
     */
    private BigDecimal returnAmount;
    /**
     * 退货原因ID
     */
    private Long returnReasonId;
    /**
     * 退货原因名称
     */
    private String returnReasonName;
    /**
     * 申请人类型
     */
    private String applyUserType;
    /**
     * 申请人ID
     */
    private String applyUid;
    /**
     * 申请人名称
     */
    private String applyUname;
    /**
     * 申请时间
     */
    private String applyTime;
    /**
     * 申请备注
     */
    private String applyRemark;
    /**
     * 退货确认人类型
     */
    private String confirmUserType;
    /**
     * 退货确认人ID
     */
    private String confirmUid;
    /**
     * 退货确认人名称
     */
    private String confirmUname;
    /**
     * 退货确认时间
     */
    private String confirmTime;
    /**
     * 退货确认类型
     */
    private String confirmType;
    /**
     * 退货确认备注
     */
    private String confirmRemark;
    /**
     * 入库人ID
     */
    private String inboundUid;
    /**
     * 入库人名称
     */
    private String inboundUname;
    /**
     * 入库时间(yyyy-MM-dd HH:mm:ss)
     */
    private String inboundTime;
    /**
     * 退货单状态
     */
    private String returnStatus;
    /**
     * 退货原因照片1
     */
    private String image1;
    /**
     * 退货原因照片2
     */
    private String image2;
    /**
     * 退货原因照片3
     */
    private String image3;
    /**
     * 退货原因照片4
     */
    private String image4;
    /**
     * 退货原因照片5
     */
    private String image5;
    /**
     * 删除标记
     */
    private Boolean delFlg;
    /**
     * 创建者ID
     */
    private String crtId;
    /**
     * 创建时间(yyyy-MM-dd HH:mm:ss)
     */
    private String crtTime;
    /**
     * 更新者ID
     */
    private String updId;
    /**
     * 更新时间(yyyy-MM-dd HH:mm:ss)
     */
    private String updTime;
    /**
     * 版本
     */
    private Integer ver;

    private List<ORDR0807IDetailRestResult> details;

    private Integer sortSeq;



    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getReturnSource() {
        return returnSource;
    }

    public void setReturnSource(String returnSource) {
        this.returnSource = returnSource;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    public Long getReturnReasonId() {
        return returnReasonId;
    }

    public void setReturnReasonId(Long returnReasonId) {
        this.returnReasonId = returnReasonId;
    }

    public String getReturnReasonName() {
        return returnReasonName;
    }

    public void setReturnReasonName(String returnReasonName) {
        this.returnReasonName = returnReasonName;
    }

    public String getApplyUserType() {
        return applyUserType;
    }

    public void setApplyUserType(String applyUserType) {
        this.applyUserType = applyUserType;
    }

    public String getApplyUid() {
        return applyUid;
    }

    public void setApplyUid(String applyUid) {
        this.applyUid = applyUid;
    }

    public String getApplyUname() {
        return applyUname;
    }

    public void setApplyUname(String applyUname) {
        this.applyUname = applyUname;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyRemark() {
        return applyRemark;
    }

    public void setApplyRemark(String applyRemark) {
        this.applyRemark = applyRemark;
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

    public String getConfirmType() {
        return confirmType;
    }

    public void setConfirmType(String confirmType) {
        this.confirmType = confirmType;
    }

    public String getConfirmRemark() {
        return confirmRemark;
    }

    public void setConfirmRemark(String confirmRemark) {
        this.confirmRemark = confirmRemark;
    }

    public String getInboundUid() {
        return inboundUid;
    }

    public void setInboundUid(String inboundUid) {
        this.inboundUid = inboundUid;
    }

    public String getInboundUname() {
        return inboundUname;
    }

    public void setInboundUname(String inboundUname) {
        this.inboundUname = inboundUname;
    }

    public String getInboundTime() {
        return inboundTime;
    }

    public void setInboundTime(String inboundTime) {
        this.inboundTime = inboundTime;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public String getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(String crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public String getUpdTime() {
        return updTime;
    }

    public void setUpdTime(String updTime) {
        this.updTime = updTime;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public List<ORDR0807IDetailRestResult> getDetails() {
        return details;
    }

    public void setDetails(List<ORDR0807IDetailRestResult> details) {
        this.details = details;
    }

    public Integer getSortSeq() {
        return sortSeq;
    }

    public void setSortSeq(Integer sortSeq) {
        this.sortSeq = sortSeq;
    }
}
