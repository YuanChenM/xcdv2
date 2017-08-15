package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestBean;

import java.math.BigDecimal;

/**
 * 买手订单明细合集Param
 * 
 * @author li_huiqian
 *
 */
public class ORDR060201IBeanParam extends RestBean {

    private static final long serialVersionUID = 7587739776851257898L;

    private Long bsOrderDetailId;//买手订单明细ID
    private BigDecimal  goodsQuantity;//商品数量
    private String  goodsUnit;//商品单位
    private String  goodsId;// 商品ID
    private Integer ver;//版本号

    public Long getBsOrderDetailId() {
        return bsOrderDetailId;
    }

    public void setBsOrderDetailId(Long bsOrderDetailId) {
        this.bsOrderDetailId = bsOrderDetailId;
    }

    public BigDecimal getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(BigDecimal goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }
}
