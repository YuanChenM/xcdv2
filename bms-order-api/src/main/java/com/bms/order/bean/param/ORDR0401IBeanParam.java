package com.bms.order.bean.param;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bms.order.archive.impl.DistributionNotification;
import com.bms.order.archive.impl.DistributionNotificationDetail;
import com.bms.order.archive.impl.SendNotification;
import com.bms.order.archive.impl.SendNotificationDetail;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.SendNotificationDetailEntity;
import com.bms.order.bean.entity.SendNotificationEntity;
import com.bms.order.common.rest.param.RestBean;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;

/**
 * 发货通知回传接口Param
 * 
 * @author li_huiqian
 */
public class ORDR0401IBeanParam extends RestBean {

    /**
     * 
     */
    private static final long serialVersionUID = 565066011723173525L;

    /**
     * 销售订单id
     */
    private Long orderId;
    /**
     * 配送单id
     */
    private Long shipId;
    /**
     * 实际发货仓库Code
     */
    private String whCode;
    /**
     * 实际发货仓库Name
     */
    private String whName;
    /**
     * 发货通知单明细
     */
    private List<ORDR0401IDetail> shipList;

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public List<ORDR0401IDetail> getShipList() {
        return shipList;
    }

    public void setShipList(List<ORDR0401IDetail> shipList) {
        this.shipList = shipList;
    }

    //获得配送通知单表
    public DistributionNotification generateDistributionNotification(){
        DistributionNotification distributionNotification=DistributionNotification.build(null).forComplete(shipId);
        return distributionNotification;
    }

    public static class ORDR0401IDetail extends RestBean {
        /**
         * 配送单号
         */

        private String deliverCode;
        /**
         * 配送人
         */

        private String deliverPerson;
        /**
         * 配送人电话
         */

        private String personMobile;

        /**
         * 配送时间
         */
        private String deliverDate;

        /**
         * 配送方式
         */
        private String deliverMode;
        /**
         * 备注
         */
        private String remarks;
        /**
         * 预计送达时间
         */
        private String expectReceiveDate;

        private List<ORDR0401IProductList> productList;

        public List<ORDR0401IProductList> getProductList() {
            return productList;
        }

        public void setProductList(List<ORDR0401IProductList> productList) {
            this.productList = productList;
        }
        public String getDeliverCode() {
            return deliverCode;
        }

        public void setDeliverCode(String deliverCode) {
            this.deliverCode = deliverCode;
        }

        public String getDeliverPerson() {
            return deliverPerson;
        }

        public void setDeliverPerson(String deliverPerson) {
            this.deliverPerson = deliverPerson;
        }

        public String getPersonMobile() {
            return personMobile;
        }

        public void setPersonMobile(String personMobile) {
            this.personMobile = personMobile;
        }

        public String getDeliverDate() {
            return deliverDate;
        }

        public void setDeliverDate(String deliverDate) {
            this.deliverDate = deliverDate;
        }

        public String getDeliverMode() {
            return deliverMode;
        }

        public void setDeliverMode(String deliverMode) {
            this.deliverMode = deliverMode;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getExpectReceiveDate() {
            return expectReceiveDate;
        }

        public void setExpectReceiveDate(String expectReceiveDate) {
            this.expectReceiveDate = expectReceiveDate;
        }

        //创建发货通知单
        public SendNotification generateSendNotificationForCreat(){
            SendNotificationEntity entity = new SendNotificationEntity();
            entity.setSendNotificationCode(deliverCode);
            entity.setDistributionPersonName(deliverPerson);
            entity.setDistributionPersonPhone(personMobile);
            entity.setDistributionType(deliverMode);
            entity.setRealDepartDatetime(DateUtils.parseDateTime(deliverDate));
            entity.setExpectedArrivalDatetime(DateUtils.parseDateTime(expectReceiveDate));
            entity.setRemarks(remarks);
            SendNotification sendNotification = SendNotification.build(null).forCreate(entity);
            return sendNotification;
        }

        public List<DistributionNotificationDetail> disDetails(Blackboard blackboard){
            List<DistributionNotificationDetail> distributionNotificationDetailList = new ArrayList<>();
            for(ORDR0401IProductList detail : productList){
                distributionNotificationDetailList.add(detail.generateDistributionDetail(blackboard));
            }
            return distributionNotificationDetailList;
        }

        public static class ORDR0401IProductList extends RestBean {

            private Long shipDetailId;

            private String skuCode;

            private String unit;

            private List<ORDR0401ILotList> lotList;

            public List<ORDR0401ILotList> getLotList() {
                return lotList;
            }

            public void setLotList(List<ORDR0401ILotList> lotList) {
                this.lotList = lotList;
            }
            public Long getShipDetailId() {
                return shipDetailId;
            }

            public void setShipDetailId(Long shipDetailId) {
                this.shipDetailId = shipDetailId;
            }

            public String getSkuCode() {
                return skuCode;
            }

            public void setSkuCode(String skuCode) {
                this.skuCode = skuCode;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public DistributionNotificationDetail generateDistributionDetail(Blackboard blackboard){
                DistributionNotificationDetail distributionNotificationDetail = DistributionNotificationDetail.build(blackboard).forComplete(shipDetailId);
                distributionNotificationDetail.complete(false);
                if (!distributionNotificationDetail.isDataSynced()) {
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E040104, distributionNotificationDetail.getEntity().getDistributionNotificationDetailId().toString());
                }
                return distributionNotificationDetail;
            }

            public static class ORDR0401ILotList extends RestBean {
                private BigDecimal sendQty;
                private String lotNo;
                private String supplierCode;


                public BigDecimal getSendQty() {
                    return sendQty;
                }

                public void setSendQty(BigDecimal sendQty) {
                    this.sendQty = sendQty;
                }

                public String getLotNo() {
                    return lotNo;
                }

                public void setLotNo(String lotNo) {
                    this.lotNo = lotNo;
                }

                public String getSupplierCode() {
                    return supplierCode;
                }

                public void setSupplierCode(String supplierCode) {
                    this.supplierCode = supplierCode;
                }

                public SendNotificationDetail generateSendNotificationDetail(){
                    SendNotificationDetailEntity entity = new SendNotificationDetailEntity();
                    entity.setBatch(lotNo);
                    entity.setRealSendQuantity(sendQty);
                    SendNotificationDetail sendNotificationDetail= SendNotificationDetail.build(null).forCreate(entity);
                    return sendNotificationDetail;
                }
            }
        }
    }
}