package com.bms.order.bean.param;

import java.math.BigDecimal;
import java.util.List;

import com.bms.order.archive.impl.BsOrder;
import com.bms.order.archive.impl.BsOrderDetail;
import com.bms.order.bean.entity.BsOrderAttachedEntity;
import com.bms.order.bean.entity.BsOrderDetailAttachedEntity;
import com.bms.order.bean.entity.BsOrderDetailEntity;
import com.bms.order.bean.entity.BsOrderEntity;
import com.bms.order.common.rest.param.RestBean;
import com.framework.core.utils.DateUtils;

/**
 * 买手订单创建接口Param
 *
 * @author li_huiqian
 */
public class ORDR0601IBeanParam extends RestBean {

    /**
     * 
     */
    private static final long serialVersionUID = -2030855117707241655L;

    public BsOrder getBsOrder() {
        BsOrderEntity bsOrderEntity = new BsOrderEntity();
        BsOrderAttachedEntity bsOrderAttachedEntity = new BsOrderAttachedEntity();

        bsOrderEntity.setOrderType(orderType);
        bsOrderEntity.setBackNo(backNo);
        bsOrderEntity.setSalePlatformType(salePlatformType);
        bsOrderEntity.setOrderSourceType(orderSourceType);
        bsOrderEntity.setOrderPlacerId(orderPlacerId);
        bsOrderEntity.setOrderPlacerType(orderPlacerType);
        bsOrderEntity.setOrderPlaceDatetime(DateUtils.parseDateTime(orderPlaceDatetime));
        bsOrderEntity.setBsId(bsId);
        bsOrderEntity.setInvoiceFlg(invoiceFlg);
        bsOrderEntity.setUseNetFlg(useNetFlg);
        bsOrderEntity.setPreferentialAmount(preferentialAmount);
        bsOrderEntity.setEarnestAmount(earnestAmount);
        bsOrderEntity.setAdvancePaymentAmount(advancePaymentAmount);

        BsOrder bsOrder = BsOrder.build(null).forCreate(bsOrderEntity, bsOrderAttachedEntity);

        for (ORDR0601Product product : products) {
            product.generateBsOrderDetail(bsOrder);
        }
        bsOrder.bsOrderDetailsLinked();
        return bsOrder;
    }

    /**
     * 订单类型
     */
    private String orderType;

    private String lgcsAreaCode;
    /**
     * 订单：参考号
     */
    private String backNo;

    /**
     * 销售平台
     */
    private String salePlatformType;

    /**
     * 订单来源
     */
    private String orderSourceType;

    /**
     * 下单员ID
     */
    private String orderPlacerId;

    /**
     * 下单员类型（买手/平台）
     */
    private String orderPlacerType;

    /**
     * 下单时间
     */
    private String orderPlaceDatetime;

    /**
     * 买手ID
     */
    private String bsId;

    /**
     * 是否开具发票
     */
    private Boolean invoiceFlg;

    /**
     * 是否使用账期
     */
    private Boolean useNetFlg;

    /**
     * 优惠金额
     */
    private BigDecimal preferentialAmount;

    /**
     * 定金应付金额
     */
    private BigDecimal advancePaymentAmount;
    /**
     * 预付应付金额
     */

    private BigDecimal earnestAmount;

    List<ORDR0601Product> products;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getBackNo() {
        return backNo;
    }

    public void setBackNo(String backNo) {
        this.backNo = backNo;
    }

    public String getSalePlatformType() {
        return salePlatformType;
    }

    public void setSalePlatformType(String salePlatformType) {
        this.salePlatformType = salePlatformType;
    }

    public String getOrderSourceType() {
        return orderSourceType;
    }

    public void setOrderSourceType(String orderSourceType) {
        this.orderSourceType = orderSourceType;
    }

    public String getOrderPlacerId() {
        return orderPlacerId;
    }

    public void setOrderPlacerId(String orderPlacerId) {
        this.orderPlacerId = orderPlacerId;
    }

    public String getOrderPlacerType() {
        return orderPlacerType;
    }

    public void setOrderPlacerType(String orderPlacerType) {
        this.orderPlacerType = orderPlacerType;
    }

    public String getOrderPlaceDatetime() {
        return orderPlaceDatetime;
    }

    public void setOrderPlaceDatetime(String orderPlaceDatetime) {
        this.orderPlaceDatetime = orderPlaceDatetime;
    }

    public String getBsId() {
        return bsId;
    }

    public void setBsId(String bsId) {
        this.bsId = bsId;
    }

    public Boolean getInvoiceFlg() {
        return invoiceFlg;
    }

    public void setInvoiceFlg(Boolean invoiceFlg) {
        this.invoiceFlg = invoiceFlg;
    }

    public Boolean getUseNetFlg() {
        return useNetFlg;
    }

    public void setUseNetFlg(Boolean useNetFlg) {
        this.useNetFlg = useNetFlg;
    }

    public BigDecimal getPreferentialAmount() {
        return preferentialAmount;
    }

    public void setPreferentialAmount(BigDecimal preferentialAmount) {
        this.preferentialAmount = preferentialAmount;
    }

    public BigDecimal getAdvancePaymentAmount() {
        return advancePaymentAmount;
    }

    public void setAdvancePaymentAmount(BigDecimal advancePaymentAmount) {
        this.advancePaymentAmount = advancePaymentAmount;
    }

    public BigDecimal getEarnestAmount() {
        return earnestAmount;
    }

    public void setEarnestAmount(BigDecimal earnestAmount) {
        this.earnestAmount = earnestAmount;
    }

    public List<ORDR0601Product> getProducts() {
        return products;
    }

    public void setProducts(List<ORDR0601Product> products) {
        this.products = products;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public static class ORDR0601Product extends RestBean {

        private static final long serialVersionUID = 7179003144290645785L;

        private BigDecimal goodsQuantity;// 商品数量

        private String goodsUnit;// 商品单位

        private String goodsId;// 商品id

        private BigDecimal priceUnit;

        private BigDecimal priceKg;

        private String wayDesc;

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

        public BsOrderDetailEntity generateBsOrderDetail(BsOrder bsOrder) {
            BsOrderDetailEntity bsOrderDetailEntity = new BsOrderDetailEntity();
            bsOrderDetailEntity.setGoodsId(goodsId);
            bsOrderDetailEntity.setGoodsUnit(goodsUnit);
            bsOrderDetailEntity.setGoodsQuantity(goodsQuantity);
            bsOrderDetailEntity.setRealUnitPrice(priceUnit);
            bsOrderDetailEntity.setRealKgPrice(priceKg);
            bsOrderDetailEntity.setPriceWay(wayDesc);

            BsOrderDetailAttachedEntity bsOrderDetailAttachedEntity = new BsOrderDetailAttachedEntity();

            BsOrderDetail bsOrderDetail = BsOrderDetail.build(null).forCreate(bsOrderDetailEntity,
                    bsOrderDetailAttachedEntity);
            bsOrder.link(bsOrderDetail);

            return bsOrderDetailEntity;
        }

        public BigDecimal getPriceUnit() {
            return priceUnit;
        }

        public void setPriceUnit(BigDecimal priceUnit) {
            this.priceUnit = priceUnit;
        }

        public BigDecimal getPriceKg() {
            return priceKg;
        }

        public void setPriceKg(BigDecimal priceKg) {
            this.priceKg = priceKg;
        }

        public String getWayDesc() {
            return wayDesc;
        }

        public void setWayDesc(String wayDesc) {
            this.wayDesc = wayDesc;
        }
    }

}
