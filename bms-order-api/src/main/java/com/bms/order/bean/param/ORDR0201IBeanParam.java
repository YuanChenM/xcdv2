package com.bms.order.bean.param;

import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BuyerForcastDeliverDetailAttachedEntity;
import com.bms.order.bean.entity.BuyerForcastDeliverDetailEntity;
import com.bms.order.common.rest.param.RestBean;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.util.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.exception.BusinessException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单分拆单创建接口Param
 *
 * @author li_huiqian
 */
public class ORDR0201IBeanParam extends RestBean {
    /**
     *
     */
    private static final long serialVersionUID = -7271738160675390488L;


    List<ORDR0201SpiltDetail> spiltDetails;

    public List<ORDR0201SpiltDetail> getSpiltDetails() {
        return spiltDetails;
    }

    public void setSpiltDetails(List<ORDR0201SpiltDetail> spiltDetails) {
        this.spiltDetails = spiltDetails;
    }

    public List<ORDR0201SpiltDetail> getSpiltDetails(Long buyerBatchOrderDetailId) {
        List<ORDR0201SpiltDetail> resSpiltDetails = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(spiltDetails)) {
            for (ORDR0201SpiltDetail ordr0201SpiltDetail : spiltDetails) {
                if (ordr0201SpiltDetail.getBuyerBatchOrderDetailId().equals(buyerBatchOrderDetailId)) {
                    resSpiltDetails.add(ordr0201SpiltDetail);
                }
            }
        }
        return resSpiltDetails;
    }


    public List<BuyerBatchOrderDetail> getBuyerBatchOrderDetails(Blackboard blackboard) {
        Map<Long, BuyerBatchOrderDetail> map = new HashMap<>();
        if (CollectionUtils.isNotEmpty(spiltDetails)) {
            for (ORDR0201SpiltDetail ordr0201SpiltDetail : spiltDetails) {
                Long buyerBatchOrderDetailId = ordr0201SpiltDetail.getBuyerBatchOrderDetailId();
                BuyerBatchOrderDetail buyerBatchOrderDetail = new BuyerBatchOrderDetail(buyerBatchOrderDetailId);
                buyerBatchOrderDetail.setBlackboard(blackboard);
                buyerBatchOrderDetail.complete(false);
                if (!buyerBatchOrderDetail.isDataSynced()) {
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020106);
                }
                List<BuyerForcastDeliverDetail> buyerForcastDeliverDetailList = buyerBatchOrderDetail.getBuyerForcastDeliverDetails();
                if (CollectionUtils.isNotEmpty(buyerForcastDeliverDetailList)) {
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020103);
                }
                map.put(buyerBatchOrderDetailId, buyerBatchOrderDetail);
            }
        }
        return new ArrayList<BuyerBatchOrderDetail>(map.values());
    }

    /**
     * 获取BuyerForcastDeliverDetail
     *
     * @return
     */
    public List<BuyerForcastDeliverDetail> getBuyerForcastDeliverDetailList(Long buyerBatchOrderDetailId) {
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetailList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(spiltDetails)) {
            for (ORDR0201SpiltDetail ordr0201SpiltDetail : spiltDetails) {
                if (ordr0201SpiltDetail.getBuyerBatchOrderDetailId().equals(buyerBatchOrderDetailId)) {
                    BuyerForcastDeliverDetailEntity entity = new BuyerForcastDeliverDetailEntity();
                    BuyerForcastDeliverDetailAttachedEntity attachedEntity = new BuyerForcastDeliverDetailAttachedEntity();
                    BeanUtils.copyProperties(ordr0201SpiltDetail, entity);
                    BeanUtils.copyProperties(ordr0201SpiltDetail, attachedEntity);
                    BuyerForcastDeliverDetail buyerForcastDeliverDetail = new BuyerForcastDeliverDetail(entity, attachedEntity);
                    buyerForcastDeliverDetailList.add(buyerForcastDeliverDetail);
                }
            }
        }
        return buyerForcastDeliverDetailList;
    }


    public static class ORDR0201SpiltDetail {
        /**
         * 明细：买家分批订单ID
         */
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

        /**
         * 明细：买家分批订单明细ID
         */
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

        /**
         * 销售方：供货主体 [CodeMaster 平台，买手]
         */
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
         * 销售方：销售方ID [实际的销售方(平台，买手等) 云冻品为平台， B2B第三方就是第三方卖家， 若为买手销售订单则为买手ID]
         */
        private String sellSideId;

        /**
         * 获取销售方：销售方ID [实际的销售方(平台，买手等) 云冻品为平台， B2B第三方就是第三方卖家， 若为买手销售订单则为买手ID]
         *
         * @return 销售方：销售方ID [实际的销售方(平台，买手等) 云冻品为平台， B2B第三方就是第三方卖家， 若为买手销售订单则为买手ID]
         */
        public String getSellSideId() {
            return this.sellSideId;
        }

        /**
         * 设置销售方：销售方ID [实际的销售方(平台，买手等) 云冻品为平台， B2B第三方就是第三方卖家， 若为买手销售订单则为买手ID]
         *
         * @param sellSideId
         */
        public void setSellSideId(String sellSideId) {
            this.sellSideId = sellSideId;
        }

        /**
         * 商品：商品ID [任意一级可销售层级+销售标签]
         */
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

        /**
         * 商品：产品ID [【需要确认类型】]
         */
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

        /**
         * 商品：生产商ID
         */
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

        /**
         * 商品：卖家ID
         */
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

        /**
         * 商品：商品SKU [【精确到生产商和卖家的SKU】]
         */
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

        /**
         * 商品：批次ID [【产品处无批次】]
         */
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

        /**
         * 商品：销售标签ID [【需要和产品确认】]
         */
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

        /**
         * 分拆数量
         *
         * @param qty
         */

        private BigDecimal planSendQuantity;

        public BigDecimal getPlanSendQuantity() {
            return planSendQuantity;
        }

        public void setPlanSendQuantity(BigDecimal planSendQuantity) {
            this.planSendQuantity = planSendQuantity;
        }
    }
}
