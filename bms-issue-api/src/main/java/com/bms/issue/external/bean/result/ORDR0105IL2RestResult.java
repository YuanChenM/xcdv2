package com.bms.issue.external.bean.result;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.bms.issue.common.rest.result.RestSearchData;


/**
 * 买家分批订单
 *
 * @author li_huiqian
 */
public class ORDR0105IL2RestResult extends RestSearchData {

    /**
     * 
     */
    private static final long serialVersionUID = -8062919692164986417L;
    /**
     * 分批订单明细
     */
    private List<ORDR0105IL3RestResult> batchOrderDetails;

    /**
     * @return the batchOrderDetails
     */
    public List<ORDR0105IL3RestResult> getBatchOrderDetails() {
        return batchOrderDetails;
    }

    /**
     * @param batchOrderDetails
     *            the batchOrderDetails to set
     */
    public void setBatchOrderDetails(List<ORDR0105IL3RestResult> batchOrderDetails) {
        this.batchOrderDetails = batchOrderDetails;
    }

    /** 分批订单：买家分批订单ID */
    private Long buyerBatchOrderId;

    /**
     * 获取分批订单：买家分批订单ID
     * 
     * @return 分批订单：买家分批订单ID
     */
    public Long getBuyerBatchOrderId() {
        return this.buyerBatchOrderId;
    }

    /**
     * 设置分批订单：买家分批订单ID
     * 
     * @param buyerBatchOrderId
     */
    public void setBuyerBatchOrderId(Long buyerBatchOrderId) {
        this.buyerBatchOrderId = buyerBatchOrderId;
    }

    /** 分批订单：买家分批订单编号 */
    private String buyerBatchOrderCode;

    /**
     * 获取分批订单：买家分批订单编号
     * 
     * @return 分批订单：买家分批订单编号
     */
    public String getBuyerBatchOrderCode() {
        return this.buyerBatchOrderCode;
    }

    /**
     * 设置分批订单：买家分批订单编号
     * 
     * @param buyerBatchOrderCode
     */
    public void setBuyerBatchOrderCode(String buyerBatchOrderCode) {
        this.buyerBatchOrderCode = buyerBatchOrderCode;
    }

    /** 分批订单：买家订单ID */
    private Long buyerOrderId;

    /**
     * 获取分批订单：买家订单ID
     * 
     * @return 分批订单：买家订单ID
     */
    public Long getBuyerOrderId() {
        return this.buyerOrderId;
    }

    /**
     * 设置分批订单：买家订单ID
     * 
     * @param buyerOrderId
     */
    public void setBuyerOrderId(Long buyerOrderId) {
        this.buyerOrderId = buyerOrderId;
    }

    /** 分批订单：期望配送日 */
    private Date requiredDistributionDate;

    /**
     * 获取分批订单：期望配送日
     * 
     * @return 分批订单：期望配送日
     */
    public Date getRequiredDistributionDate() {
        return this.requiredDistributionDate;
    }

    /**
     * 设置分批订单：期望配送日
     * 
     * @param requiredDistributionDate
     */
    public void setRequiredDistributionDate(Date requiredDistributionDate) {
        this.requiredDistributionDate = requiredDistributionDate;
    }

    /** 收货要求：预计发货时间 */
    private Date expectedSendDatetime;

    /**
     * 获取收货要求：预计发货时间
     * 
     * @return 收货要求：预计发货时间
     */
    public Date getExpectedSendDatetime() {
        return this.expectedSendDatetime;
    }

    /**
     * 设置收货要求：预计发货时间
     * 
     * @param expectedSendDatetime
     */
    public void setExpectedSendDatetime(Date expectedSendDatetime) {
        this.expectedSendDatetime = expectedSendDatetime;
    }

    /** 收货要求：预计到货时间 */
    private Date expectedArrivalDatetime;

    /**
     * 获取收货要求：预计到货时间
     * 
     * @return 收货要求：预计到货时间
     */
    public Date getExpectedArrivalDatetime() {
        return this.expectedArrivalDatetime;
    }

    /**
     * 设置收货要求：预计到货时间
     * 
     * @param expectedArrivalDatetime
     */
    public void setExpectedArrivalDatetime(Date expectedArrivalDatetime) {
        this.expectedArrivalDatetime = expectedArrivalDatetime;
    }

    /** 支付：订单金额 [订单金额+运费金额-优惠金额=订单总额] */
    private BigDecimal orderAmount;

    /**
     * 获取支付：订单金额 [订单金额+运费金额-优惠金额=订单总额]
     * 
     * @return 支付：订单金额 [订单金额+运费金额-优惠金额=订单总额]
     */
    public BigDecimal getOrderAmount() {
        return this.orderAmount;
    }

    /**
     * 设置支付：订单金额 [订单金额+运费金额-优惠金额=订单总额]
     * 
     * @param orderAmount
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /** 支付：运费金额（预留字段） */
    private BigDecimal freight;

    /**
     * 获取支付：运费金额（预留字段）
     * 
     * @return 支付：运费金额（预留字段）
     */
    public BigDecimal getFreight() {
        return this.freight;
    }

    /**
     * 设置支付：运费金额（预留字段）
     * 
     * @param freight
     */
    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    /** 支付：优惠金额（预留字段） */
    private BigDecimal preferentialAmount;

    /**
     * 获取支付：优惠金额（预留字段）
     * 
     * @return 支付：优惠金额（预留字段）
     */
    public BigDecimal getPreferentialAmount() {
        return this.preferentialAmount;
    }

    /**
     * 设置支付：优惠金额（预留字段）
     * 
     * @param preferentialAmount
     */
    public void setPreferentialAmount(BigDecimal preferentialAmount) {
        this.preferentialAmount = preferentialAmount;
    }

    /** 支付：已收金额（预留字段） [订单总额-已收金额=尾款金额] */
    private BigDecimal receiveAmount;

    /**
     * 获取支付：已收金额（预留字段） [订单总额-已收金额=尾款金额]
     * 
     * @return 支付：已收金额（预留字段） [订单总额-已收金额=尾款金额]
     */
    public BigDecimal getReceiveAmount() {
        return this.receiveAmount;
    }

    /**
     * 设置支付：已收金额（预留字段） [订单总额-已收金额=尾款金额]
     * 
     * @param receiveAmount
     */
    public void setReceiveAmount(BigDecimal receiveAmount) {
        this.receiveAmount = receiveAmount;
    }

    /** 支付：定金应付比例（预留字段） */
    private BigDecimal earnestPercent;

    /**
     * 获取支付：定金应付比例（预留字段）
     * 
     * @return 支付：定金应付比例（预留字段）
     */
    public BigDecimal getEarnestPercent() {
        return this.earnestPercent;
    }

    /**
     * 设置支付：定金应付比例（预留字段）
     * 
     * @param earnestPercent
     */
    public void setEarnestPercent(BigDecimal earnestPercent) {
        this.earnestPercent = earnestPercent;
    }

    /** 支付：定金应付金额（预留字段） */
    private BigDecimal earnestAmount;

    /**
     * 获取支付：定金应付金额（预留字段）
     * 
     * @return 支付：定金应付金额（预留字段）
     */
    public BigDecimal getEarnestAmount() {
        return this.earnestAmount;
    }

    /**
     * 设置支付：定金应付金额（预留字段）
     * 
     * @param earnestAmount
     */
    public void setEarnestAmount(BigDecimal earnestAmount) {
        this.earnestAmount = earnestAmount;
    }

    /** 支付：应预付比例（预留字段） */
    private BigDecimal advancePaymentPercent;

    /**
     * 获取支付：应预付比例（预留字段）
     * 
     * @return 支付：应预付比例（预留字段）
     */
    public BigDecimal getAdvancePaymentPercent() {
        return this.advancePaymentPercent;
    }

    /**
     * 设置支付：应预付比例（预留字段）
     * 
     * @param advancePaymentPercent
     */
    public void setAdvancePaymentPercent(BigDecimal advancePaymentPercent) {
        this.advancePaymentPercent = advancePaymentPercent;
    }

    /** 支付：应预付金额（预留字段） */
    private BigDecimal advancePaymentAmount;

    /**
     * 获取支付：应预付金额（预留字段）
     * 
     * @return 支付：应预付金额（预留字段）
     */
    public BigDecimal getAdvancePaymentAmount() {
        return this.advancePaymentAmount;
    }

    /**
     * 设置支付：应预付金额（预留字段）
     * 
     * @param advancePaymentAmount
     */
    public void setAdvancePaymentAmount(BigDecimal advancePaymentAmount) {
        this.advancePaymentAmount = advancePaymentAmount;
    }

    /** 状态：买家分批单状态 [CodeMaster] */
    private String buyerBatchOrderStu;

    /**
     * 获取状态：买家分批单状态 [CodeMaster]
     * 
     * @return 状态：买家分批单状态 [CodeMaster]
     */
    public String getBuyerBatchOrderStu() {
        return this.buyerBatchOrderStu;
    }

    /**
     * 设置状态：买家分批单状态 [CodeMaster]
     * 
     * @param buyerBatchOrderStu
     */
    public void setBuyerBatchOrderStu(String buyerBatchOrderStu) {
        this.buyerBatchOrderStu = buyerBatchOrderStu;
    }

    /** 收货人：收货人名称 */
    private String receiverName;

    /**
     * 获取收货人：收货人名称
     * 
     * @return 收货人：收货人名称
     */
    public String getReceiverName() {
        return this.receiverName;
    }

    /**
     * 设置收货人：收货人名称
     * 
     * @param receiverName
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /** 收货人：收货人电话 */
    private String receiverPhone;

    /**
     * 获取收货人：收货人电话
     * 
     * @return 收货人：收货人电话
     */
    public String getReceiverPhone() {
        return this.receiverPhone;
    }

    /**
     * 设置收货人：收货人电话
     * 
     * @param receiverPhone
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    /** 收货人：收货人QQ */
    private String receiverQq;

    /**
     * 获取收货人：收货人QQ
     * 
     * @return 收货人：收货人QQ
     */
    public String getReceiverQq() {
        return this.receiverQq;
    }

    /**
     * 设置收货人：收货人QQ
     * 
     * @param receiverQq
     */
    public void setReceiverQq(String receiverQq) {
        this.receiverQq = receiverQq;
    }

    /** 收货人：收货人微信 */
    private String receiverWechat;

    /**
     * 获取收货人：收货人微信
     * 
     * @return 收货人：收货人微信
     */
    public String getReceiverWechat() {
        return this.receiverWechat;
    }

    /**
     * 设置收货人：收货人微信
     * 
     * @param receiverWechat
     */
    public void setReceiverWechat(String receiverWechat) {
        this.receiverWechat = receiverWechat;
    }

    /** 收货人：收货人邮箱 */
    private String receiverMail;

    /**
     * 获取收货人：收货人邮箱
     * 
     * @return 收货人：收货人邮箱
     */
    public String getReceiverMail() {
        return this.receiverMail;
    }

    /**
     * 设置收货人：收货人邮箱
     * 
     * @param receiverMail
     */
    public void setReceiverMail(String receiverMail) {
        this.receiverMail = receiverMail;
    }

    /** 收货地址：收货地址省 */
    private String receiverProvince;

    /**
     * 获取收货地址：收货地址省
     * 
     * @return 收货地址：收货地址省
     */
    public String getReceiverProvince() {
        return this.receiverProvince;
    }

    /**
     * 设置收货地址：收货地址省
     * 
     * @param receiverProvince
     */
    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    /** 收货地址：收货地址市 */
    private String receiverCity;

    /**
     * 获取收货地址：收货地址市
     * 
     * @return 收货地址：收货地址市
     */
    public String getReceiverCity() {
        return this.receiverCity;
    }

    /**
     * 设置收货地址：收货地址市
     * 
     * @param receiverCity
     */
    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    /** 收货地址：收货地址区 */
    private String receiverDistrict;

    /**
     * 获取收货地址：收货地址区
     * 
     * @return 收货地址：收货地址区
     */
    public String getReceiverDistrict() {
        return this.receiverDistrict;
    }

    /**
     * 设置收货地址：收货地址区
     * 
     * @param receiverDistrict
     */
    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    /** 收货地址：收货地址详细地址 */
    private String receiverAddress;

    /**
     * 获取收货地址：收货地址详细地址
     * 
     * @return 收货地址：收货地址详细地址
     */
    public String getReceiverAddress() {
        return this.receiverAddress;
    }

    /**
     * 设置收货地址：收货地址详细地址
     * 
     * @param receiverAddress
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    /** 收货地址：辅助地址项目 [收货人详细地址管理Key] */
    private String receiverAssistAddress;

    /**
     * 获取收货地址：辅助地址项目 [收货人详细地址管理Key]
     * 
     * @return 收货地址：辅助地址项目 [收货人详细地址管理Key]
     */
    public String getReceiverAssistAddress() {
        return this.receiverAssistAddress;
    }

    /**
     * 设置收货地址：辅助地址项目 [收货人详细地址管理Key]
     * 
     * @param receiverAssistAddress
     */
    public void setReceiverAssistAddress(String receiverAssistAddress) {
        this.receiverAssistAddress = receiverAssistAddress;
    }

    /** 收货地址：订单配送区域 */
    private String deliveryArea;

    /**
     * 获取收货地址：订单配送区域
     * 
     * @return 收货地址：订单配送区域
     */
    public String getDeliveryArea() {
        return this.deliveryArea;
    }

    /**
     * 设置收货地址：订单配送区域
     * 
     * @param deliveryArea
     */
    public void setDeliveryArea(String deliveryArea) {
        this.deliveryArea = deliveryArea;
    }

    /** 收货地址：准入通行车型 */
    private String passTrafficModel;

    /**
     * 获取收货地址：准入通行车型
     * 
     * @return 收货地址：准入通行车型
     */
    public String getPassTrafficModel() {
        return this.passTrafficModel;
    }

    /**
     * 设置收货地址：准入通行车型
     * 
     * @param passTrafficModel
     */
    public void setPassTrafficModel(String passTrafficModel) {
        this.passTrafficModel = passTrafficModel;
    }

    /** 收货要求：配送方式 [CodeMaster 海陆空 （预留字段，目前都是陆运）] */
    private String distributionType;

    /**
     * 获取收货要求：配送方式 [CodeMaster 海陆空 （预留字段，目前都是陆运）]
     * 
     * @return 收货要求：配送方式 [CodeMaster 海陆空 （预留字段，目前都是陆运）]
     */
    public String getDistributionType() {
        return this.distributionType;
    }

    /**
     * 设置收货要求：配送方式 [CodeMaster 海陆空 （预留字段，目前都是陆运）]
     * 
     * @param distributionType
     */
    public void setDistributionType(String distributionType) {
        this.distributionType = distributionType;
    }

    /** 收货要求：收货时间段 [CodeMaster] */
    private String receivePeriod;

    /**
     * 获取收货要求：收货时间段 [CodeMaster]
     * 
     * @return 收货要求：收货时间段 [CodeMaster]
     */
    public String getReceivePeriod() {
        return this.receivePeriod;
    }

    /**
     * 设置收货要求：收货时间段 [CodeMaster]
     * 
     * @param receivePeriod
     */
    public void setReceivePeriod(String receivePeriod) {
        this.receivePeriod = receivePeriod;
    }

    /** 收货要求：最早时间要求 */
    private String receiveEarliest;

    /**
     * 获取收货要求：最早时间要求
     * 
     * @return 收货要求：最早时间要求
     */
    public String getReceiveEarliest() {
        return this.receiveEarliest;
    }

    /**
     * 设置收货要求：最早时间要求
     * 
     * @param receiveEarliest
     */
    public void setReceiveEarliest(String receiveEarliest) {
        this.receiveEarliest = receiveEarliest;
    }

    /** 收货要求：最晚时间要求 */
    private String receiveLatest;

    /**
     * 获取收货要求：最晚时间要求
     * 
     * @return 收货要求：最晚时间要求
     */
    public String getReceiveLatest() {
        return this.receiveLatest;
    }

    /**
     * 设置收货要求：最晚时间要求
     * 
     * @param receiveLatest
     */
    public void setReceiveLatest(String receiveLatest) {
        this.receiveLatest = receiveLatest;
    }

    /** 收货要求：收货等待时间 */
    private String receiveWaitHour;

    /**
     * 获取收货要求：收货等待时间
     * 
     * @return 收货要求：收货等待时间
     */
    public String getReceiveWaitHour() {
        return this.receiveWaitHour;
    }

    /**
     * 设置收货要求：收货等待时间
     * 
     * @param receiveWaitHour
     */
    public void setReceiveWaitHour(String receiveWaitHour) {
        this.receiveWaitHour = receiveWaitHour;
    }

    /** 收货要求：提前通知时间 */
    private String advancedNotificationHour;

    /**
     * 获取收货要求：提前通知时间
     * 
     * @return 收货要求：提前通知时间
     */
    public String getAdvancedNotificationHour() {
        return this.advancedNotificationHour;
    }

    /**
     * 设置收货要求：提前通知时间
     * 
     * @param advancedNotificationHour
     */
    public void setAdvancedNotificationHour(String advancedNotificationHour) {
        this.advancedNotificationHour = advancedNotificationHour;
    }

    /** 收货要求：动检证要求 */
    private Boolean animalQuarantineCertificationFlg;

    /**
     * 获取收货要求：动检证要求
     * 
     * @return 收货要求：动检证要求
     */
    public Boolean getAnimalQuarantineCertificationFlg() {
        return this.animalQuarantineCertificationFlg;
    }

    /**
     * 设置收货要求：动检证要求
     * 
     * @param animalQuarantineCertificationFlg
     */
    public void setAnimalQuarantineCertificationFlg(Boolean animalQuarantineCertificationFlg) {
        this.animalQuarantineCertificationFlg = animalQuarantineCertificationFlg;
    }

    /** 收货要求：装卸要求 */
    private String stevedoreRequirement;

    /**
     * 获取收货要求：装卸要求
     * 
     * @return 收货要求：装卸要求
     */
    public String getStevedoreRequirement() {
        return this.stevedoreRequirement;
    }

    /**
     * 设置收货要求：装卸要求
     * 
     * @param stevedoreRequirement
     */
    public void setStevedoreRequirement(String stevedoreRequirement) {
        this.stevedoreRequirement = stevedoreRequirement;
    }

    /** 收货要求：包装要求 */
    private String packageRequirement;

    /**
     * 获取收货要求：包装要求
     * 
     * @return 收货要求：包装要求
     */
    public String getPackageRequirement() {
        return this.packageRequirement;
    }

    /**
     * 设置收货要求：包装要求
     * 
     * @param packageRequirement
     */
    public void setPackageRequirement(String packageRequirement) {
        this.packageRequirement = packageRequirement;
    }

    /** 收货要求：距离门店最近停车距离（米） */
    private Integer nearestParkingDistance;

    /**
     * 获取收货要求：距离门店最近停车距离（米）
     * 
     * @return 收货要求：距离门店最近停车距离（米）
     */
    public Integer getNearestParkingDistance() {
        return this.nearestParkingDistance;
    }

    /**
     * 设置收货要求：距离门店最近停车距离（米）
     * 
     * @param nearestParkingDistance
     */
    public void setNearestParkingDistance(Integer nearestParkingDistance) {
        this.nearestParkingDistance = nearestParkingDistance;
    }

    /** 收货要求：备注 */
    private String remark;

    /**
     * 获取收货要求：备注
     * 
     * @return 收货要求：备注
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * 设置收货要求：备注
     * 
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
