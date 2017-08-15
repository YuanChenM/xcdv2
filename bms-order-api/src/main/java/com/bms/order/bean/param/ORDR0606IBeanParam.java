package com.bms.order.bean.param;

import com.bms.order.archive.impl.BsOrder;
import com.bms.order.archive.impl.BsOrderDetail;
import com.bms.order.bean.entity.BsOrderAttachedEntity;
import com.bms.order.bean.entity.BsOrderDetailAttachedEntity;
import com.bms.order.bean.entity.BsOrderDetailEntity;
import com.bms.order.bean.entity.BsOrderEntity;
import com.bms.order.common.rest.param.RestBean;
import com.framework.core.utils.DateUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * 买手订单创建接口Param
 *
 * @author li_huiqian
 */
public class ORDR0606IBeanParam extends RestBean {

    /**
     * 
     */
    private static final long serialVersionUID = -2030855117707241655L;

    public BsOrder getBsOrder() {
        BsOrderEntity bsOrderEntity = new BsOrderEntity();
        BsOrderAttachedEntity bsOrderAttachedEntity = new BsOrderAttachedEntity();

        bsOrderEntity.setOrderType(orderType);
        // TODO qiuwenting 暂未实装
//        bsOrderEntity.setSalePlatformType(salePlatformType);
//        bsOrderEntity.setOrderSourceType(orderSourceType);
//        bsOrderEntity.setOrderPlacerId(orderPlacerId);
//        bsOrderEntity.setOrderPlacerType(orderPlacerType);
//        bsOrderEntity.setOrderPlaceDatetime(DateUtils.parseDateTime(orderPlaceDatetime));
//        bsOrderEntity.setInvoiceFlg(invoiceFlg);
//        bsOrderEntity.setUseNetFlg(useNetFlg);
//        bsOrderEntity.setPreferentialAmount(preferentialAmount);
//        bsOrderEntity.setEarnestAmount(earnestAmount);
//        bsOrderEntity.setAdvancePaymentAmount(advancePaymentAmount);

        BsOrder bsOrder = BsOrder.build(null).forCreate(bsOrderEntity, bsOrderAttachedEntity);

        for (ORDR0606Product product : products) {
            product.generateBsOrderDetail(bsOrder);
        }
        bsOrder.bsOrderDetailsLinked();
        return bsOrder;
    }

    /**
     * 估货订单编号
     */
    private String backNo;


    /**
     * 卖方编码（买手/合伙人）
     */
    private String sellerCode;

    /**
     * 卖方名称（买手/合伙人）
     */
    private String sellerName;


    /**
     * 下单时间
     */
    private String orderPlaceDatetime;

    /**
     * 订单类型
     */
    private String orderType;

    /**
     * 买方编码（平台/买手/合伙人）
     */
    private String buyerCode;

    /**
     * 买方名称（平台/买手/合伙人）
     */
    private String buyerName;

    /**
     * 总价
     */
    private BigDecimal totalPrice;

    /**
     * 税率
     */
    private BigDecimal taxRate;

    /**
     * 币种（CNY）
     */
    private String currency;

    /**
     * 卖家交易手续费
     */
    private BigDecimal sellerFeeMoney;

    /**
     * 卖家交易保证金
     */
    private BigDecimal sellerDepositMoney;

    /**
     * 卖家交收手续费
     */
    private BigDecimal sellerDelMoney;

    /**
     * 买家交易手续费
     */
    private BigDecimal buyerFeeMoney;

    /**
     * 买家交易保证金
     */
    private BigDecimal buyerDepositMoney;

    /**
     * 买家交收手续费
     */
    private BigDecimal buyerDelMoney;

    /**
     * 交易时间
     */
    private String tradeTime;

    List<ORDR0606Product> products;

    public String getBackNo() {
        return backNo;
    }

    public void setBackNo(String backNo) {
        this.backNo = backNo;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getOrderPlaceDatetime() {
        return orderPlaceDatetime;
    }

    public void setOrderPlaceDatetime(String orderPlaceDatetime) {
        this.orderPlaceDatetime = orderPlaceDatetime;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getSellerFeeMoney() {
        return sellerFeeMoney;
    }

    public void setSellerFeeMoney(BigDecimal sellerFeeMoney) {
        this.sellerFeeMoney = sellerFeeMoney;
    }

    public BigDecimal getSellerDepositMoney() {
        return sellerDepositMoney;
    }

    public void setSellerDepositMoney(BigDecimal sellerDepositMoney) {
        this.sellerDepositMoney = sellerDepositMoney;
    }

    public BigDecimal getSellerDelMoney() {
        return sellerDelMoney;
    }

    public void setSellerDelMoney(BigDecimal sellerDelMoney) {
        this.sellerDelMoney = sellerDelMoney;
    }

    public BigDecimal getBuyerFeeMoney() {
        return buyerFeeMoney;
    }

    public void setBuyerFeeMoney(BigDecimal buyerFeeMoney) {
        this.buyerFeeMoney = buyerFeeMoney;
    }

    public BigDecimal getBuyerDepositMoney() {
        return buyerDepositMoney;
    }

    public void setBuyerDepositMoney(BigDecimal buyerDepositMoney) {
        this.buyerDepositMoney = buyerDepositMoney;
    }

    public BigDecimal getBuyerDelMoney() {
        return buyerDelMoney;
    }

    public void setBuyerDelMoney(BigDecimal buyerDelMoney) {
        this.buyerDelMoney = buyerDelMoney;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public List<ORDR0606Product> getProducts() {
        return products;
    }

    public void setProducts(List<ORDR0606Product> products) {
        this.products = products;
    }

    public static class ORDR0606Product extends RestBean {

        private static final long serialVersionUID = 7179003144290645785L;

        /** 交易数量（箱数）*/
        private BigDecimal orderCount;

        /** 商品编码 */
        private String commodityCode;

        /** 商品名称 */
        private String commodityName;

        /** 商品单位 */
        private String unit;

        /** 单价 */
        private BigDecimal orderPrice;

        public BigDecimal getOrderCount() {
            return orderCount;
        }

        public void setOrderCount(BigDecimal orderCount) {
            this.orderCount = orderCount;
        }

        public String getCommodityCode() {
            return commodityCode;
        }

        public void setCommodityCode(String commodityCode) {
            this.commodityCode = commodityCode;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public BigDecimal getOrderPrice() {
            return orderPrice;
        }

        public void setOrderPrice(BigDecimal orderPrice) {
            this.orderPrice = orderPrice;
        }

        public BsOrderDetailEntity generateBsOrderDetail(BsOrder bsOrder) {
            BsOrderDetailEntity bsOrderDetailEntity = new BsOrderDetailEntity();
            bsOrderDetailEntity.setGoodsUnit(unit);
            bsOrderDetailEntity.setGoodsQuantity(orderCount);

            BsOrderDetailAttachedEntity bsOrderDetailAttachedEntity = new BsOrderDetailAttachedEntity();

            BsOrderDetail bsOrderDetail = BsOrderDetail.build(null).forCreate(bsOrderDetailEntity,
                    bsOrderDetailAttachedEntity);
            bsOrder.link(bsOrderDetail);

            return bsOrderDetailEntity;
        }

    }

}
