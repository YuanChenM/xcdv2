package com.batch.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;
public class BuyerSellerDetailEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 供货明细ID [供货明细ID] */
private Long sellerDetailId;
/**
* 获取供货明细ID [供货明细ID]
* @return 供货明细ID [供货明细ID]
*/
public Long getSellerDetailId() {
return this.sellerDetailId;
}
/**
* 设置供货明细ID [供货明细ID]
* @param sellerDetailId
*/
public void setSellerDetailId(Long sellerDetailId) {
this.sellerDetailId=sellerDetailId;
}
/** 明细：买家分批订单明细ID */
private Long buyerBatchOrderDetailId;
/**
* 获取明细：买家分批订单明细ID
* @return 明细：买家分批订单明细ID
*/
public Long getBuyerBatchOrderDetailId() {
return this.buyerBatchOrderDetailId;
}
/**
* 设置明细：买家分批订单明细ID
* @param buyerBatchOrderDetailId
*/
public void setBuyerBatchOrderDetailId(Long buyerBatchOrderDetailId) {
this.buyerBatchOrderDetailId=buyerBatchOrderDetailId;
}
/** 平台卖家ID [平台卖家ID] */
private Long sellerId;
/**
* 获取平台卖家ID [平台卖家ID]
* @return 平台卖家ID [平台卖家ID]
*/
public Long getSellerId() {
return this.sellerId;
}
/**
* 设置平台卖家ID [平台卖家ID]
* @param sellerId
*/
public void setSellerId(Long sellerId) {
this.sellerId=sellerId;
}
/** 平台卖家编码 [平台卖家编码，默认00000001] */
private String sellerCode;
/**
* 获取平台卖家编码 [平台卖家编码，默认00000001]
* @return 平台卖家编码 [平台卖家编码，默认00000001]
*/
public String getSellerCode() {
return this.sellerCode;
}
/**
* 设置平台卖家编码 [平台卖家编码，默认00000001]
* @param sellerCode
*/
public void setSellerCode(String sellerCode) {
this.sellerCode=sellerCode;
}
/** 供货主体类型 [CodeMaster ，同货权人类型] */
private String sellSideType;
/**
* 获取供货主体类型 [CodeMaster ，同货权人类型]
* @return 供货主体类型 [CodeMaster ，同货权人类型]
*/
public String getSellSideType() {
return this.sellSideType;
}
/**
* 设置供货主体类型 [CodeMaster ，同货权人类型]
* @param sellSideType
*/
public void setSellSideType(String sellSideType) {
this.sellSideType=sellSideType;
}
/** 供货主体ID [实际的销售方(平台，买手，合伙人等)
云冻品为平台，
B2B第三方就是第三方卖家，
若为买手销售订单则为买手ID] */
private String sellSideId;
/**
* 获取供货主体ID [实际的销售方(平台，买手，合伙人等)
云冻品为平台，
B2B第三方就是第三方卖家，
若为买手销售订单则为买手ID]
* @return 供货主体ID [实际的销售方(平台，买手，合伙人等)
云冻品为平台，
B2B第三方就是第三方卖家，
若为买手销售订单则为买手ID]
*/
public String getSellSideId() {
return this.sellSideId;
}
/**
* 设置供货主体ID [实际的销售方(平台，买手，合伙人等)
云冻品为平台，
B2B第三方就是第三方卖家，
若为买手销售订单则为买手ID]
* @param sellSideId
*/
public void setSellSideId(String sellSideId) {
this.sellSideId=sellSideId;
}
/** 占用库存商品ID [需要占用库存的商品ID，实物库存时与销售商品一致，货权供货时是货权商品ID] */
private Long allocateGoodsId;
/**
* 获取占用库存商品ID [需要占用库存的商品ID，实物库存时与销售商品一致，货权供货时是货权商品ID]
* @return 占用库存商品ID [需要占用库存的商品ID，实物库存时与销售商品一致，货权供货时是货权商品ID]
*/
public Long getAllocateGoodsId() {
return this.allocateGoodsId;
}
/**
* 设置占用库存商品ID [需要占用库存的商品ID，实物库存时与销售商品一致，货权供货时是货权商品ID]
* @param allocateGoodsId
*/
public void setAllocateGoodsId(Long allocateGoodsId) {
this.allocateGoodsId=allocateGoodsId;
}
/** 供货库存类型 [商品库存类型，codemaster] */
private String comoIvType;
/**
* 获取供货库存类型 [商品库存类型，codemaster]
* @return 供货库存类型 [商品库存类型，codemaster]
*/
public String getComoIvType() {
return this.comoIvType;
}
/**
* 设置供货库存类型 [商品库存类型，codemaster]
* @param comoIvType
*/
public void setComoIvType(String comoIvType) {
this.comoIvType=comoIvType;
}
/** 供货库存数量 [供货库存数量] */
private BigDecimal sellQty;
/**
* 获取供货库存数量 [供货库存数量]
* @return 供货库存数量 [供货库存数量]
*/
public BigDecimal getSellQty() {
return this.sellQty;
}
/**
* 设置供货库存数量 [供货库存数量]
* @param sellQty
*/
public void setSellQty(BigDecimal sellQty) {
this.sellQty=sellQty;
}
}
