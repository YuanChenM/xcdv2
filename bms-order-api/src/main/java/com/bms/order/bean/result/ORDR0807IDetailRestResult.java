package com.bms.order.bean.result;

import com.bms.order.common.rest.result.RestSearchData;
import io.swagger.models.auth.In;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/8.
 */
public class ORDR0807IDetailRestResult extends RestSearchData {

    private static final long serialVersionUID = 1L;
    /**
     * 退货明细ID
     */
    private Long detailId;
    /**
     * 配送单ID
     */
    private Long distributionNotificationId;
    /**
     * 配送明细ID
     */
    private Long distributionNotificationDetailId;
    /**
     * 收货单ID
     */
    private Long receiveNotificationId;
    /**
     * 收货单明细ID
     */
    private Long receiveNotificationDetailId;
    /**
     * 商品ID
     */
    private String goodsId;
    /**
     * 销售单位
     */
    private String saleUnit;
    /**
     * 退货量
     */
    private BigDecimal returnQty;
    /**
     * 原因ID
     */
    private Long detailReasonId;

    /**
     * 原因ID
     */
    private String detailReasonName;

    /**
     * 入库批次
     */
    private String inboundBatch;
    /**
     * 入库量
     */
    private BigDecimal inboundQty;
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

    private Integer sortSeq;

    public Integer getSortSeq() {
        return sortSeq;
    }

    public void setSortSeq(Integer sortSeq) {
        this.sortSeq = sortSeq;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getDistributionNotificationId() {
        return distributionNotificationId;
    }

    public void setDistributionNotificationId(Long distributionNotificationId) {
        this.distributionNotificationId = distributionNotificationId;
    }

    public Long getDistributionNotificationDetailId() {
        return distributionNotificationDetailId;
    }

    public void setDistributionNotificationDetailId(Long distributionNotificationDetailId) {
        this.distributionNotificationDetailId = distributionNotificationDetailId;
    }

    public Long getReceiveNotificationId() {
        return receiveNotificationId;
    }

    public void setReceiveNotificationId(Long receiveNotificationId) {
        this.receiveNotificationId = receiveNotificationId;
    }

    public Long getReceiveNotificationDetailId() {
        return receiveNotificationDetailId;
    }

    public void setReceiveNotificationDetailId(Long receiveNotificationDetailId) {
        this.receiveNotificationDetailId = receiveNotificationDetailId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getSaleUnit() {
        return saleUnit;
    }

    public void setSaleUnit(String saleUnit) {
        this.saleUnit = saleUnit;
    }

    public BigDecimal getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(BigDecimal returnQty) {
        this.returnQty = returnQty;
    }

    public Long getDetailReasonId() {
        return detailReasonId;
    }

    public void setDetailReasonId(Long detailReasonId) {
        this.detailReasonId = detailReasonId;
    }

    public String getDetailReasonName() {
        return detailReasonName;
    }

    public void setDetailReasonName(String detailReasonName) {
        this.detailReasonName = detailReasonName;
    }

    public String getInboundBatch() {
        return inboundBatch;
    }

    public void setInboundBatch(String inboundBatch) {
        this.inboundBatch = inboundBatch;
    }

    public BigDecimal getInboundQty() {
        return inboundQty;
    }

    public void setInboundQty(BigDecimal inboundQty) {
        this.inboundQty = inboundQty;
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
}
