package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestBean;

import java.util.List;

/**
 * 买家迟收退货数据接收接口Param
 *
 * @author li_huiqian
 */
public class ORDR0803IBean extends RestBean {
    private static final long serialVersionUID = 1L;
    /**
     * 配送通知单ID，对应配送通知XML中的ORDERID
     */
    private String shipId;
    /**
     * 迟收再发送日期(yyyy-MM-dd)
     */
    private String receiptDate;
    /**
     * 迟收模式：1-全部，整单发货单SHIPID全部迟收，无需关注ShipList部分【2016/10/11】，2-部分
     */
    private Integer returnMode;
    /**
     * 申请人名称
     */
    private String applyMan;
    /**
     *申请时间(yyyy-MM-dd HH:mm:ss)
     */
    private String applyTime;
    /**
     * 申请备注
     */
    private String applyRemark;
    /**
     * 退货退货原因ID，退货原因查询接口提供原因标准信息，根据实际的情况选择原因，在此处提交给OMS系统
     */
    private Long returnReasonID;
    /**
     * 迟收原因名称
     */
    private String returnReasonName;
    /**
     * 迟收原因照片1文件ID（调用方上传文件到文件服务器得到文件服务器返回的文件ID，调用方将文件文件ID传入OMS）
     */
    private String image1;
    /**
     * 迟收原因照片2文件
     */
    private String image2;
    private String image3;
    private String image4;
    private String image5;
    /**
     * 买家ID，发货XML中BUYERSID
     */
    private String buyerId;
    /**
     * 买家编码，发货XML中CONSIGNEE
     */
    private String buyerCode;
    /**
     *
     */
    private Integer isPaid;


    private List<ORDR0803ShipIBean> shipList;


    public String getShipId() {
        return shipId;
    }

    public void setShipId(String shipId) {
        this.shipId = shipId;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Integer getReturnMode() {
        return returnMode;
    }

    public void setReturnMode(Integer returnMode) {
        this.returnMode = returnMode;
    }

    public String getApplyMan() {
        return applyMan;
    }

    public void setApplyMan(String applyMan) {
        this.applyMan = applyMan;
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

    public Long getReturnReasonID() {
        return returnReasonID;
    }

    public void setReturnReasonID(Long returnReasonID) {
        this.returnReasonID = returnReasonID;
    }

    public String getReturnReasonName() {
        return returnReasonName;
    }

    public void setReturnReasonName(String returnReasonName) {
        this.returnReasonName = returnReasonName;
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

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
    }

    public List<ORDR0803ShipIBean> getShipList() {
        return shipList;
    }

    public void setShipList(List<ORDR0803ShipIBean> shipList) {
        this.shipList = shipList;
    }
}
