package com.bms.order.bean.result;

import com.bms.order.common.rest.result.RestSearchData;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/9.
 */
public class ORDR0904IDetailRestResult extends RestSearchData {

    private static final long serialVersionUID = 1L;

    /**
     * 退货明细ID
     */
    private Long detailId;
    /**
     * 买手囤货分拆单明细ID
     */
    private Long bsStockpileSplitDetailId;
    /**
     * 商品ID
     */
    private String goodsId;
    /**
     * 销售单位
     */
    private String goodsUnit;
    /**
     * 退货量
     */
    private BigDecimal returnQty;
    /**
     * 明细退货原因ID
     */
    private Long detailReasonId;
    /**
     * 明细退货原因名称
     */
    private String detailReasonName;
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

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getBsStockpileSplitDetailId() {
        return bsStockpileSplitDetailId;
    }

    public void setBsStockpileSplitDetailId(Long bsStockpileSplitDetailId) {
        this.bsStockpileSplitDetailId = bsStockpileSplitDetailId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
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
