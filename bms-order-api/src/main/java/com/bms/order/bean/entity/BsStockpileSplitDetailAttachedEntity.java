package com.bms.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;
public class BsStockpileSplitDetailAttachedEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 明细：买手囤货分拆单明细ID */
private Long bsStockpileSplitDetailId;
/**
* 获取明细：买手囤货分拆单明细ID
* @return 明细：买手囤货分拆单明细ID
*/
public Long getBsStockpileSplitDetailId() {
return this.bsStockpileSplitDetailId;
}
/**
* 设置明细：买手囤货分拆单明细ID
* @param bsStockpileSplitDetailId
*/
public void setBsStockpileSplitDetailId(Long bsStockpileSplitDetailId) {
this.bsStockpileSplitDetailId=bsStockpileSplitDetailId;
}
/** 销售方：销售方名称 */
private String sellSideName;
/**
* 获取销售方：销售方名称
* @return 销售方：销售方名称
*/
public String getSellSideName() {
return this.sellSideName;
}
/**
* 设置销售方：销售方名称
* @param sellSideName
*/
public void setSellSideName(String sellSideName) {
this.sellSideName=sellSideName;
}
/** 销售方：销售方编码 */
private String sellSideCode;
/**
* 获取销售方：销售方编码
* @return 销售方：销售方编码
*/
public String getSellSideCode() {
return this.sellSideCode;
}
/**
* 设置销售方：销售方编码
* @param sellSideCode
*/
public void setSellSideCode(String sellSideCode) {
this.sellSideCode=sellSideCode;
}
/** 商品：单品编码 [单品SKU] */
private String itemCode;
/**
* 获取商品：单品编码 [单品SKU]
* @return 商品：单品编码 [单品SKU]
*/
public String getItemCode() {
return this.itemCode;
}
/**
* 设置商品：单品编码 [单品SKU]
* @param itemCode
*/
public void setItemCode(String itemCode) {
this.itemCode=itemCode;
}
/** 商品：单品名称 [单品特征名称] */
private String itemName;
/**
* 获取商品：单品名称 [单品特征名称]
* @return 商品：单品名称 [单品特征名称]
*/
public String getItemName() {
return this.itemName;
}
/**
* 设置商品：单品名称 [单品特征名称]
* @param itemName
*/
public void setItemName(String itemName) {
this.itemName=itemName;
}
/** 商品：品牌编码 */
private String brandCode;
/**
* 获取商品：品牌编码
* @return 商品：品牌编码
*/
public String getBrandCode() {
return this.brandCode;
}
/**
* 设置商品：品牌编码
* @param brandCode
*/
public void setBrandCode(String brandCode) {
this.brandCode=brandCode;
}
/** 商品：品牌名称 */
private String brandName;
/**
* 获取商品：品牌名称
* @return 商品：品牌名称
*/
public String getBrandName() {
return this.brandName;
}
/**
* 设置商品：品牌名称
* @param brandName
*/
public void setBrandName(String brandName) {
this.brandName=brandName;
}
/** 商品：单品品牌编码 [品牌单品SKU] */
private String itemBrandCode;
/**
* 获取商品：单品品牌编码 [品牌单品SKU]
* @return 商品：单品品牌编码 [品牌单品SKU]
*/
public String getItemBrandCode() {
return this.itemBrandCode;
}
/**
* 设置商品：单品品牌编码 [品牌单品SKU]
* @param itemBrandCode
*/
public void setItemBrandCode(String itemBrandCode) {
this.itemBrandCode=itemBrandCode;
}
/** 商品：生产商编码 */
private String manufacturerCode;
/**
* 获取商品：生产商编码
* @return 商品：生产商编码
*/
public String getManufacturerCode() {
return this.manufacturerCode;
}
/**
* 设置商品：生产商编码
* @param manufacturerCode
*/
public void setManufacturerCode(String manufacturerCode) {
this.manufacturerCode=manufacturerCode;
}
/** 商品：生产商名称 */
private String manufacturerName;
/**
* 获取商品：生产商名称
* @return 商品：生产商名称
*/
public String getManufacturerName() {
return this.manufacturerName;
}
/**
* 设置商品：生产商名称
* @param manufacturerName
*/
public void setManufacturerName(String manufacturerName) {
this.manufacturerName=manufacturerName;
}
/** 商品：卖家编码 */
private String sellerCode;
/**
* 获取商品：卖家编码
* @return 商品：卖家编码
*/
public String getSellerCode() {
return this.sellerCode;
}
/**
* 设置商品：卖家编码
* @param sellerCode
*/
public void setSellerCode(String sellerCode) {
this.sellerCode=sellerCode;
}
/** 商品：卖家名称 */
private String sellerName;
/**
* 获取商品：卖家名称
* @return 商品：卖家名称
*/
public String getSellerName() {
return this.sellerName;
}
/**
* 设置商品：卖家名称
* @param sellerName
*/
public void setSellerName(String sellerName) {
this.sellerName=sellerName;
}
/** 商品：批次编码 [【产品处无批次】] */
private String batchCode;
/**
* 获取商品：批次编码 [【产品处无批次】]
* @return 商品：批次编码 [【产品处无批次】]
*/
public String getBatchCode() {
return this.batchCode;
}
/**
* 设置商品：批次编码 [【产品处无批次】]
* @param batchCode
*/
public void setBatchCode(String batchCode) {
this.batchCode=batchCode;
}
/** 商品：销售标签编码 [【需要和产品确认】] */
private String saleLabelCode;
/**
* 获取商品：销售标签编码 [【需要和产品确认】]
* @return 商品：销售标签编码 [【需要和产品确认】]
*/
public String getSaleLabelCode() {
return this.saleLabelCode;
}
/**
* 设置商品：销售标签编码 [【需要和产品确认】]
* @param saleLabelCode
*/
public void setSaleLabelCode(String saleLabelCode) {
this.saleLabelCode=saleLabelCode;
}
/** 商品：销售标签名称 [【需要和产品确认】] */
private String saleLabelName;
/**
* 获取商品：销售标签名称 [【需要和产品确认】]
* @return 商品：销售标签名称 [【需要和产品确认】]
*/
public String getSaleLabelName() {
return this.saleLabelName;
}
/**
* 设置商品：销售标签名称 [【需要和产品确认】]
* @param saleLabelName
*/
public void setSaleLabelName(String saleLabelName) {
this.saleLabelName=saleLabelName;
}
/** SKU：小包装特征 [【产品处无此字段】] */
private String smallPackageFeature;
/**
* 获取SKU：小包装特征 [【产品处无此字段】]
* @return SKU：小包装特征 [【产品处无此字段】]
*/
public String getSmallPackageFeature() {
return this.smallPackageFeature;
}
/**
* 设置SKU：小包装特征 [【产品处无此字段】]
* @param smallPackageFeature
*/
public void setSmallPackageFeature(String smallPackageFeature) {
this.smallPackageFeature=smallPackageFeature;
}
/** SKU：小包装件数/大包装个数 [【产品处无此字段】] */
private Integer quantityPerPackage;
/**
* 获取SKU：小包装件数/大包装个数 [【产品处无此字段】]
* @return SKU：小包装件数/大包装个数 [【产品处无此字段】]
*/
public Integer getQuantityPerPackage() {
return this.quantityPerPackage;
}
/**
* 设置SKU：小包装件数/大包装个数 [【产品处无此字段】]
* @param quantityPerPackage
*/
public void setQuantityPerPackage(Integer quantityPerPackage) {
this.quantityPerPackage=quantityPerPackage;
}
/** SKU：净重（克） */
private BigDecimal netWeight;
/**
* 获取SKU：净重（克）
* @return SKU：净重（克）
*/
public BigDecimal getNetWeight() {
return this.netWeight;
}
/**
* 设置SKU：净重（克）
* @param netWeight
*/
public void setNetWeight(BigDecimal netWeight) {
this.netWeight=netWeight;
}
/** SKU：毛重（克） */
private BigDecimal grossWeight;
/**
* 获取SKU：毛重（克）
* @return SKU：毛重（克）
*/
public BigDecimal getGrossWeight() {
return this.grossWeight;
}
/**
* 设置SKU：毛重（克）
* @param grossWeight
*/
public void setGrossWeight(BigDecimal grossWeight) {
this.grossWeight=grossWeight;
}
/** SKU：纸箱尺寸 [【类型待定】] */
private String cartonSize;
/**
* 获取SKU：纸箱尺寸 [【类型待定】]
* @return SKU：纸箱尺寸 [【类型待定】]
*/
public String getCartonSize() {
return this.cartonSize;
}
/**
* 设置SKU：纸箱尺寸 [【类型待定】]
* @param cartonSize
*/
public void setCartonSize(String cartonSize) {
this.cartonSize=cartonSize;
}
/** SKU：产品等级 [【类型待定】] */
private String productLevel;
/**
* 获取SKU：产品等级 [【类型待定】]
* @return SKU：产品等级 [【类型待定】]
*/
public String getProductLevel() {
return this.productLevel;
}
/**
* 设置SKU：产品等级 [【类型待定】]
* @param productLevel
*/
public void setProductLevel(String productLevel) {
this.productLevel=productLevel;
}
/** SKU：托盘标准堆码数（箱） [【类型待定】] */
private Integer palletStandardStackQuantity;
/**
* 获取SKU：托盘标准堆码数（箱） [【类型待定】]
* @return SKU：托盘标准堆码数（箱） [【类型待定】]
*/
public Integer getPalletStandardStackQuantity() {
return this.palletStandardStackQuantity;
}
/**
* 设置SKU：托盘标准堆码数（箱） [【类型待定】]
* @param palletStandardStackQuantity
*/
public void setPalletStandardStackQuantity(Integer palletStandardStackQuantity) {
this.palletStandardStackQuantity=palletStandardStackQuantity;
}
/** 商品编码 */
private String goodsCode;
/**
* 获取商品编码
* @return 商品编码
*/
public String getGoodsCode() {
return this.goodsCode;
}
/**
* 设置商品编码
* @param goodsCode
*/
public void setGoodsCode(String goodsCode) {
this.goodsCode=goodsCode;
}
/** 商品名称 */
private String goodsName;
/**
* 获取商品名称
* @return 商品名称
*/
public String getGoodsName() {
return this.goodsName;
}
/**
* 设置商品名称
* @param goodsName
*/
public void setGoodsName(String goodsName) {
this.goodsName=goodsName;
}
/** 制造商编码 */
private String makerCode;
/**
* 获取制造商编码
* @return 制造商编码
*/
public String getMakerCode() {
return this.makerCode;
}
/**
* 设置制造商编码
* @param makerCode
*/
public void setMakerCode(String makerCode) {
this.makerCode=makerCode;
}
/** 制造商名称 */
private String makerName;
/**
* 获取制造商名称
* @return 制造商名称
*/
public String getMakerName() {
return this.makerName;
}
/**
* 设置制造商名称
* @param makerName
*/
public void setMakerName(String makerName) {
this.makerName=makerName;
}
}
