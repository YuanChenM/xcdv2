package com.bms.order.bean.result;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.bms.order.common.rest.result.RestSearchData;

/**
 * 分批订单明细
 *
 * @author li_huiqian
 */
public class ORDR0105IL3RestResult extends RestSearchData {

    /**
     * 
     */
    private static final long serialVersionUID = 4215649877744518028L;
    private List<ORDR0105IL4RestResult> ordrBuyerForcastDeliverDetails;

    /**
     * @return the ordrBuyerForcastDeliverDetails
     */
    public List<ORDR0105IL4RestResult> getOrdrBuyerForcastDeliverDetails() {
        return ordrBuyerForcastDeliverDetails;
    }

    /**
     * @param ordrBuyerForcastDeliverDetails
     *            the ordrBuyerForcastDeliverDetails to set
     */
    public void setOrdrBuyerForcastDeliverDetails(List<ORDR0105IL4RestResult> ordrBuyerForcastDeliverDetails) {
        this.ordrBuyerForcastDeliverDetails = ordrBuyerForcastDeliverDetails;
    }

    /** 明细：买家分批订单明细ID */
    private Long buyerBatchOrderDetailId;

    /**
     * 获取明细：买家分批订单明细ID
     * 
     * @return 明细：买家分批订单明细ID
     */
    public Long getBuyerBatchOrderDetailId() {
        return this.buyerBatchOrderDetailId;
    }

    /**
     * 设置明细：买家分批订单明细ID
     * 
     * @param buyerBatchOrderDetailId
     */
    public void setBuyerBatchOrderDetailId(Long buyerBatchOrderDetailId) {
        this.buyerBatchOrderDetailId = buyerBatchOrderDetailId;
    }

    /** 明细：买家订单ID */
    private Long buyerOrderId;

    /**
     * 获取明细：买家订单ID
     * 
     * @return 明细：买家订单ID
     */
    public Long getBuyerOrderId() {
        return this.buyerOrderId;
    }

    /**
     * 设置明细：买家订单ID
     * 
     * @param buyerOrderId
     */
    public void setBuyerOrderId(Long buyerOrderId) {
        this.buyerOrderId = buyerOrderId;
    }

    /** 明细：买家分批订单ID */
    private Long buyerBatchOrderId;

    /**
     * 获取明细：买家分批订单ID
     * 
     * @return 明细：买家分批订单ID
     */
    public Long getBuyerBatchOrderId() {
        return this.buyerBatchOrderId;
    }

    /**
     * 设置明细：买家分批订单ID
     * 
     * @param buyerBatchOrderId
     */
    public void setBuyerBatchOrderId(Long buyerBatchOrderId) {
        this.buyerBatchOrderId = buyerBatchOrderId;
    }

    /** 明细：商品单位 [CodeMaster KG/箱] */
    private String goodsUnit;

    /**
     * 获取明细：商品单位 [CodeMaster KG/箱]
     * 
     * @return 明细：商品单位 [CodeMaster KG/箱]
     */
    public String getGoodsUnit() {
        return this.goodsUnit;
    }

    /**
     * 设置明细：商品单位 [CodeMaster KG/箱]
     * 
     * @param goodsUnit
     */
    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    /** 明细：商品数量 */
    private BigDecimal goodsQuantity;

    /**
     * 获取明细：商品数量
     * 
     * @return 明细：商品数量
     */
    public BigDecimal getGoodsQuantity() {
        return this.goodsQuantity;
    }

    /**
     * 设置明细：商品数量
     * 
     * @param goodsQuantity
     */
    public void setGoodsQuantity(BigDecimal goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    /** 明细：取消数量 */
    private BigDecimal cancelQuantity;

    /**
     * 获取明细：取消数量
     * 
     * @return 明细：取消数量
     */
    public BigDecimal getCancelQuantity() {
        return this.cancelQuantity;
    }

    /**
     * 设置明细：取消数量
     * 
     * @param cancelQuantity
     */
    public void setCancelQuantity(BigDecimal cancelQuantity) {
        this.cancelQuantity = cancelQuantity;
    }

    /** 价盘：下单时千克价格 */
    private BigDecimal orderCreateKgPrice;

    /**
     * 获取价盘：下单时千克价格
     *
     * @return 价盘：下单时千克价格
     */
    public BigDecimal getOrderCreateKgPrice() {
        return this.orderCreateKgPrice;
    }

    /**
     * 设置价盘：下单时千克价格
     *
     * @param orderCreateKgPrice
     */
    public void setOrderCreateKgPrice(BigDecimal orderCreateKgPrice) {
        this.orderCreateKgPrice = orderCreateKgPrice;
    }

    /** 价盘：下单时单位价格 */
    private BigDecimal orderCreateUnitPrice;

    /**
     * 获取价盘：下单时单位价格
     *
     * @return 价盘：下单时单位价格
     */
    public BigDecimal getOrderCreateUnitPrice() {
        return this.orderCreateUnitPrice;
    }

    /**
     * 设置价盘：下单时单位价格
     *
     * @param orderCreateUnitPrice
     */
    public void setOrderCreateUnitPrice(BigDecimal orderCreateUnitPrice) {
        this.orderCreateUnitPrice = orderCreateUnitPrice;
    }


    /** 价盘：实际千克价格 */
    private BigDecimal realKgPrice;

    /**
     * 获取价盘：实际千克价格
     * 
     * @return 价盘：实际千克价格
     */
    public BigDecimal getRealKgPrice() {
        return this.realKgPrice;
    }

    /**
     * 设置价盘：实际千克价格
     * 
     * @param realKgPrice
     */
    public void setRealKgPrice(BigDecimal realKgPrice) {
        this.realKgPrice = realKgPrice;
    }

    /** 价盘：实际单价 */
    private BigDecimal realUnitPrice;

    /**
     * 获取价盘：实际单价
     * 
     * @return 价盘：实际单价
     */
    public BigDecimal getRealUnitPrice() {
        return this.realUnitPrice;
    }

    /**
     * 设置价盘：实际单价
     * 
     * @param realUnitPrice
     */
    public void setRealUnitPrice(BigDecimal realUnitPrice) {
        this.realUnitPrice = realUnitPrice;
    }

    /**
     * 价格创建时间
     */
    private Date priceCreateTime;

    public Date getPriceCreateTime() {
        return priceCreateTime;
    }

    public void setPriceCreateTime(Date priceCreateTime) {
        this.priceCreateTime = priceCreateTime;
    }

    /** 商品：商品ID [任意一级可销售层级+销售标签] */
    private String goodsId;

    /**
     * 获取商品：商品ID [任意一级可销售层级+销售标签]
     * 
     * @return 商品：商品ID [任意一级可销售层级+销售标签]
     */
    public String getGoodsId() {
        return this.goodsId;
    }

    /**
     * 设置商品：商品ID [任意一级可销售层级+销售标签]
     * 
     * @param goodsId
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    /** 价盘：价格通道 */
    private String priceWay;

    /**
     * 获取价盘：价格通道
     *
     * @return 价盘：价格通道
     */
    public String getPriceWay() {
        return this.priceWay;
    }

    /**
     * 设置价盘：价格通道
     *
     * @param priceWay
     */
    public void setPriceWay(String priceWay) {
        this.priceWay = priceWay;
    }

    /** 商品：产品ID [【需要确认类型】] */
    private String productId;

    /**
     * 获取商品：产品ID [【需要确认类型】]
     * 
     * @return 商品：产品ID [【需要确认类型】]
     */
    public String getProductId() {
        return this.productId;
    }

    /**
     * 设置商品：产品ID [【需要确认类型】]
     * 
     * @param productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /** 商品：生产商ID */
    private Long manufacturerId;

    /**
     * 获取商品：生产商ID
     * 
     * @return 商品：生产商ID
     */
    public Long getManufacturerId() {
        return this.manufacturerId;
    }

    /**
     * 设置商品：生产商ID
     * 
     * @param manufacturerId
     */
    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    /** 商品：卖家ID */
    private String sellerId;

    /**
     * 获取商品：卖家ID
     * 
     * @return 商品：卖家ID
     */
    public String getSellerId() {
        return this.sellerId;
    }

    /**
     * 设置商品：卖家ID
     * 
     * @param sellerId
     */
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    /** 商品：批次ID [【产品处无批次】] */
    private Long batchId;

    /**
     * 获取商品：批次ID [【产品处无批次】]
     * 
     * @return 商品：批次ID [【产品处无批次】]
     */
    public Long getBatchId() {
        return this.batchId;
    }

    /**
     * 设置商品：批次ID [【产品处无批次】]
     * 
     * @param batchId
     */
    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    /** 商品：销售标签ID [【需要和产品确认】] */
    private Long saleLabelId;

    /**
     * 获取商品：销售标签ID [【需要和产品确认】]
     * 
     * @return 商品：销售标签ID [【需要和产品确认】]
     */
    public Long getSaleLabelId() {
        return this.saleLabelId;
    }

    /**
     * 设置商品：销售标签ID [【需要和产品确认】]
     * 
     * @param saleLabelId
     */
    public void setSaleLabelId(Long saleLabelId) {
        this.saleLabelId = saleLabelId;
    }

    /** 分批订单：是否分拆完成 */
    private Boolean splitFlg;

    /**
     * 获取分批订单：是否分拆完成
     * 
     * @return 分批订单：是否分拆完成
     */
    public Boolean getSplitFlg() {
        return this.splitFlg;
    }

    /**
     * 设置分批订单：是否分拆完成
     * 
     * @param splitFlg
     */
    public void setSplitFlg(Boolean splitFlg) {
        this.splitFlg = splitFlg;
    }

    /** 分批订单：是否手动分拆 */
    private Boolean manualSplitFlg;

    /**
     * 获取分批订单：是否手动分拆
     * 
     * @return 分批订单：是否手动分拆
     */
    public Boolean getManualSplitFlg() {
        return this.manualSplitFlg;
    }

    /**
     * 设置分批订单：是否手动分拆
     * 
     * @param manualSplitFlg
     */
    public void setManualSplitFlg(Boolean manualSplitFlg) {
        this.manualSplitFlg = manualSplitFlg;
    }

    /** 商品：单品编码 [单品SKU] */
    private String itemCode;

    /**
     * 获取商品：单品编码 [单品SKU]
     * 
     * @return 商品：单品编码 [单品SKU]
     */
    public String getItemCode() {
        return this.itemCode;
    }

    /**
     * 设置商品：单品编码 [单品SKU]
     * 
     * @param itemCode
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /** 商品：单品名称 [单品特征名称] */
    private String itemName;

    /**
     * 获取商品：单品名称 [单品特征名称]
     * 
     * @return 商品：单品名称 [单品特征名称]
     */
    public String getItemName() {
        return this.itemName;
    }

    /**
     * 设置商品：单品名称 [单品特征名称]
     * 
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /** 商品：品牌编码 */
    private String brandCode;

    /**
     * 获取商品：品牌编码
     * 
     * @return 商品：品牌编码
     */
    public String getBrandCode() {
        return this.brandCode;
    }

    /**
     * 设置商品：品牌编码
     * 
     * @param brandCode
     */
    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    /** 商品：品牌名称 */
    private String brandName;

    /**
     * 获取商品：品牌名称
     * 
     * @return 商品：品牌名称
     */
    public String getBrandName() {
        return this.brandName;
    }

    /**
     * 设置商品：品牌名称
     * 
     * @param brandName
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /** 商品：单品品牌编码 [品牌单品SKU] */
    private String itemBrandCode;

    /**
     * 获取商品：单品品牌编码 [品牌单品SKU]
     * 
     * @return 商品：单品品牌编码 [品牌单品SKU]
     */
    public String getItemBrandCode() {
        return this.itemBrandCode;
    }

    /**
     * 设置商品：单品品牌编码 [品牌单品SKU]
     * 
     * @param itemBrandCode
     */
    public void setItemBrandCode(String itemBrandCode) {
        this.itemBrandCode = itemBrandCode;
    }

    /** 商品：生产商编码 */
    private String manufacturerCode;

    /**
     * 获取商品：生产商编码
     * 
     * @return 商品：生产商编码
     */
    public String getManufacturerCode() {
        return this.manufacturerCode;
    }

    /**
     * 设置商品：生产商编码
     * 
     * @param manufacturerCode
     */
    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    /** 商品：生产商名称 */
    private String manufacturerName;

    /**
     * 获取商品：生产商名称
     * 
     * @return 商品：生产商名称
     */
    public String getManufacturerName() {
        return this.manufacturerName;
    }

    /**
     * 设置商品：生产商名称
     * 
     * @param manufacturerName
     */
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    /** 商品：卖家编码 */
    private String sellerCode;

    /**
     * 获取商品：卖家编码
     * 
     * @return 商品：卖家编码
     */
    public String getSellerCode() {
        return this.sellerCode;
    }

    /**
     * 设置商品：卖家编码
     * 
     * @param sellerCode
     */
    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    /** 商品：卖家名称 */
    private String sellerName;

    /**
     * 获取商品：卖家名称
     * 
     * @return 商品：卖家名称
     */
    public String getSellerName() {
        return this.sellerName;
    }

    /**
     * 设置商品：卖家名称
     * 
     * @param sellerName
     */
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    /** 商品：批次编码 [【产品处无批次】] */
    private String batchCode;

    /**
     * 获取商品：批次编码 [【产品处无批次】]
     * 
     * @return 商品：批次编码 [【产品处无批次】]
     */
    public String getBatchCode() {
        return this.batchCode;
    }

    /**
     * 设置商品：批次编码 [【产品处无批次】]
     * 
     * @param batchCode
     */
    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    private String goodsCode;

    private String goodsName;

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /** 商品：销售标签编码 [【需要和产品确认】] */
    private String saleLabelCode;

    /**
     * 获取商品：销售标签编码 [【需要和产品确认】]
     * 
     * @return 商品：销售标签编码 [【需要和产品确认】]
     */
    public String getSaleLabelCode() {
        return this.saleLabelCode;
    }

    /**
     * 设置商品：销售标签编码 [【需要和产品确认】]
     * 
     * @param saleLabelCode
     */
    public void setSaleLabelCode(String saleLabelCode) {
        this.saleLabelCode = saleLabelCode;
    }

    /** 商品：销售标签名称 [【需要和产品确认】] */
    private String saleLabelName;

    /**
     * 获取商品：销售标签名称 [【需要和产品确认】]
     * 
     * @return 商品：销售标签名称 [【需要和产品确认】]
     */
    public String getSaleLabelName() {
        return this.saleLabelName;
    }

    /**
     * 设置商品：销售标签名称 [【需要和产品确认】]
     * 
     * @param saleLabelName
     */
    public void setSaleLabelName(String saleLabelName) {
        this.saleLabelName = saleLabelName;
    }

    /** SKU：小包装特征 [【产品处无此字段】] */
    private String smallPackageFeature;

    /**
     * 获取SKU：小包装特征 [【产品处无此字段】]
     * 
     * @return SKU：小包装特征 [【产品处无此字段】]
     */
    public String getSmallPackageFeature() {
        return this.smallPackageFeature;
    }

    /**
     * 设置SKU：小包装特征 [【产品处无此字段】]
     * 
     * @param smallPackageFeature
     */
    public void setSmallPackageFeature(String smallPackageFeature) {
        this.smallPackageFeature = smallPackageFeature;
    }

    /** SKU：小包装件数/大包装个数 [【产品处无此字段】] */
    private Integer quantityPerPackage;

    /**
     * 获取SKU：小包装件数/大包装个数 [【产品处无此字段】]
     * 
     * @return SKU：小包装件数/大包装个数 [【产品处无此字段】]
     */
    public Integer getQuantityPerPackage() {
        return this.quantityPerPackage;
    }

    /**
     * 设置SKU：小包装件数/大包装个数 [【产品处无此字段】]
     * 
     * @param quantityPerPackage
     */
    public void setQuantityPerPackage(Integer quantityPerPackage) {
        this.quantityPerPackage = quantityPerPackage;
    }

    /** SKU：净重（克） */
    private BigDecimal netWeight;

    /**
     * 获取SKU：净重（克）
     * 
     * @return SKU：净重（克）
     */
    public BigDecimal getNetWeight() {
        return this.netWeight;
    }

    /**
     * 设置SKU：净重（克）
     * 
     * @param netWeight
     */
    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    /** SKU：毛重（克） */
    private BigDecimal grossWeight;

    /**
     * 获取SKU：毛重（克）
     * 
     * @return SKU：毛重（克）
     */
    public BigDecimal getGrossWeight() {
        return this.grossWeight;
    }

    /**
     * 设置SKU：毛重（克）
     * 
     * @param grossWeight
     */
    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    /** SKU：纸箱尺寸 [【类型待定】] */
    private String cartonSize;

    /**
     * 获取SKU：纸箱尺寸 [【类型待定】]
     * 
     * @return SKU：纸箱尺寸 [【类型待定】]
     */
    public String getCartonSize() {
        return this.cartonSize;
    }

    /**
     * 设置SKU：纸箱尺寸 [【类型待定】]
     * 
     * @param cartonSize
     */
    public void setCartonSize(String cartonSize) {
        this.cartonSize = cartonSize;
    }

    /** SKU：产品等级 [【类型待定】] */
    private String productLevel;

    /**
     * 获取SKU：产品等级 [【类型待定】]
     * 
     * @return SKU：产品等级 [【类型待定】]
     */
    public String getProductLevel() {
        return this.productLevel;
    }

    /**
     * 设置SKU：产品等级 [【类型待定】]
     * 
     * @param productLevel
     */
    public void setProductLevel(String productLevel) {
        this.productLevel = productLevel;
    }

    /** SKU：托盘标准堆码数（箱） [【类型待定】] */
    private Integer palletStandardStackQuantity;

    /**
     * 获取SKU：托盘标准堆码数（箱） [【类型待定】]
     * 
     * @return SKU：托盘标准堆码数（箱） [【类型待定】]
     */
    public Integer getPalletStandardStackQuantity() {
        return this.palletStandardStackQuantity;
    }

    /**
     * 设置SKU：托盘标准堆码数（箱） [【类型待定】]
     * 
     * @param palletStandardStackQuantity
     */
    public void setPalletStandardStackQuantity(Integer palletStandardStackQuantity) {
        this.palletStandardStackQuantity = palletStandardStackQuantity;
    }

    private Integer sortSeq;

    public Integer getSortSeq() {
        return sortSeq;
    }

    public void setSortSeq(Integer sortSeq) {
        this.sortSeq = sortSeq;
    }

    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
