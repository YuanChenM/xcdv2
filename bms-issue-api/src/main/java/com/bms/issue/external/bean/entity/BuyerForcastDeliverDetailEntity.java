package com.bms.issue.external.bean.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 买家预配送明细Entity
 * 
 * @author li_huiqian
 *
 */
public class BuyerForcastDeliverDetailEntity {
    /** 明细：买家订单预配送明细ID */
    private Long buyerForcastDeliverDetailId;

    /**
     * 获取明细：买家订单预配送明细ID
     * 
     * @return 明细：买家订单预配送明细ID
     */
    public Long getBuyerForcastDeliverDetailId() {
        return this.buyerForcastDeliverDetailId;
    }

    /**
     * 设置明细：买家订单预配送明细ID
     * 
     * @param buyerForcastDeliverDetailId
     */
    public void setBuyerForcastDeliverDetailId(Long buyerForcastDeliverDetailId) {
        this.buyerForcastDeliverDetailId = buyerForcastDeliverDetailId;
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

    /** 明细：预配送类型 */
    private String forcastType;

    /**
     * 获取明细：预配送类型
     * 
     * @return 明细：预配送类型
     */
    public String getForcastType() {
        return this.forcastType;
    }

    /**
     * 设置明细：预配送类型
     * 
     * @param forcastType
     */
    public void setForcastType(String forcastType) {
        this.forcastType = forcastType;
    }

    /** 销售方：供货主体 [CodeMaster 平台，买手] */
    private String sellSideType;

    /**
     * 获取销售方：供货主体 [CodeMaster 平台，买手]
     * 
     * @return 销售方：供货主体 [CodeMaster 平台，买手]
     */
    public String getSellSideType() {
        return this.sellSideType;
    }

    /**
     * 设置销售方：供货主体 [CodeMaster 平台，买手]
     * 
     * @param sellSideType
     */
    public void setSellSideType(String sellSideType) {
        this.sellSideType = sellSideType;
    }

    /**
     * 销售方：供货主体ID [实际的销售方(平台，买手等) 云冻品为平台， B2B第三方就是第三方卖家， 若为买手销售订单则为买手ID]
     */
    private String sellSideId;

    /**
     * 获取销售方：供货主体ID [实际的销售方(平台，买手等) 云冻品为平台， B2B第三方就是第三方卖家， 若为买手销售订单则为买手ID]
     * 
     * @return 销售方：供货主体ID [实际的销售方(平台，买手等) 云冻品为平台， B2B第三方就是第三方卖家， 若为买手销售订单则为买手ID]
     */
    public String getSellSideId() {
        return this.sellSideId;
    }

    /**
     * 设置销售方：供货主体ID [实际的销售方(平台，买手等) 云冻品为平台， B2B第三方就是第三方卖家， 若为买手销售订单则为买手ID]
     * 
     * @param sellSideId
     */
    public void setSellSideId(String sellSideId) {
        this.sellSideId = sellSideId;
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

    /** 商品：商品SKU [【精确到生产商和卖家的SKU】] */
    private String sku;

    /**
     * 获取商品：商品SKU [【精确到生产商和卖家的SKU】]
     * 
     * @return 商品：商品SKU [【精确到生产商和卖家的SKU】]
     */
    public String getSku() {
        return this.sku;
    }

    /**
     * 设置商品：商品SKU [【精确到生产商和卖家的SKU】]
     * 
     * @param sku
     */
    public void setSku(String sku) {
        this.sku = sku;
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

    /** 配送：应该发货数量 */
    private BigDecimal planSendQuantity;

    /**
     * 获取配送：应该发货数量
     * 
     * @return 配送：应该发货数量
     */
    public BigDecimal getPlanSendQuantity() {
        return this.planSendQuantity;
    }

    /**
     * 设置配送：应该发货数量
     * 
     * @param planSendQuantity
     */
    public void setPlanSendQuantity(BigDecimal planSendQuantity) {
        this.planSendQuantity = planSendQuantity;
    }

    /** 配送：实际发货数量 */
    private BigDecimal realSendQuantity;

    /**
     * 获取配送：实际发货数量
     * 
     * @return 配送：实际发货数量
     */
    public BigDecimal getRealSendQuantity() {
        return this.realSendQuantity;
    }

    /**
     * 设置配送：实际发货数量
     * 
     * @param realSendQuantity
     */
    public void setRealSendQuantity(BigDecimal realSendQuantity) {
        this.realSendQuantity = realSendQuantity;
    }

    /** 配送：收货数量 */
    private BigDecimal receiveQuantity;

    /**
     * 获取配送：收货数量
     * 
     * @return 配送：收货数量
     */
    public BigDecimal getReceiveQuantity() {
        return this.receiveQuantity;
    }

    /**
     * 设置配送：收货数量
     * 
     * @param receiveQuantity
     */
    public void setReceiveQuantity(BigDecimal receiveQuantity) {
        this.receiveQuantity = receiveQuantity;
    }

    /** 配送：拒收退货数量 */
    private BigDecimal rejectQuantity;

    /**
     * 获取配送：拒收退货数量
     * 
     * @return 配送：拒收退货数量
     */
    public BigDecimal getRejectQuantity() {
        return this.rejectQuantity;
    }

    /**
     * 设置配送：拒收退货数量
     * 
     * @param rejectQuantity
     */
    public void setRejectQuantity(BigDecimal rejectQuantity) {
        this.rejectQuantity = rejectQuantity;
    }

    /** 配送：迟收退货数量 */
    private BigDecimal delayQuantity;

    /**
     * 获取配送：迟收退货数量
     * 
     * @return 配送：迟收退货数量
     */
    public BigDecimal getDelayQuantity() {
        return this.delayQuantity;
    }

    /**
     * 设置配送：迟收退货数量
     * 
     * @param delayQuantity
     */
    public void setDelayQuantity(BigDecimal delayQuantity) {
        this.delayQuantity = delayQuantity;
    }

    /** 配送：再配送日 */
    private Date redistributionDate;

    /**
     * 获取配送：再配送日
     * 
     * @return 配送：再配送日
     */
    public Date getRedistributionDate() {
        return this.redistributionDate;
    }

    /**
     * 设置配送：再配送日
     * 
     * @param redistributionDate
     */
    public void setRedistributionDate(Date redistributionDate) {
        this.redistributionDate = redistributionDate;
    }

    /** 售后：退货数量 */
    private BigDecimal returnQuantity;

    /**
     * 获取售后：退货数量
     * 
     * @return 售后：退货数量
     */
    public BigDecimal getReturnQuantity() {
        return this.returnQuantity;
    }

    /**
     * 设置售后：退货数量
     * 
     * @param returnQuantity
     */
    public void setReturnQuantity(BigDecimal returnQuantity) {
        this.returnQuantity = returnQuantity;
    }

    /** 销售方：销售方编码 */
    private String sellSideCode;

    /**
     * 获取销售方：销售方编码
     * 
     * @return 销售方：销售方编码
     */
    public String getSellSideCode() {
        return this.sellSideCode;
    }

    /**
     * 设置销售方：销售方编码
     * 
     * @param sellSideCode
     */
    public void setSellSideCode(String sellSideCode) {
        this.sellSideCode = sellSideCode;
    }

    /** 销售方：销售方名称 */
    private String sellSideName;

    /**
     * 获取销售方：销售方名称
     * 
     * @return 销售方：销售方名称
     */
    public String getSellSideName() {
        return this.sellSideName;
    }

    /**
     * 设置销售方：销售方名称
     * 
     * @param sellSideName
     */
    public void setSellSideName(String sellSideName) {
        this.sellSideName = sellSideName;
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
