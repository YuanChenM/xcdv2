package com.bms.order.validator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.bms.order.common.rest.param.RestBean;
import com.bms.order.constant.ValidatorConst;
import com.bms.order.constant.i18n.FieldCode;
import com.framework.validator.utils.NumberValidator;

/**
 * Created by Administrator on 2017/2/27.
 */
public abstract class OrderValidator<T extends Serializable> extends  OrderValidatorGenerated<T> {
    protected <B extends RestBean> void validateBeans(List<B> beans) {
        this.validatorRequired(FieldCode.BEANS, beans);
    }
    protected <B extends RestBean> void validateProductList(List<B> productList) {
        this.validatorRequired(FieldCode.PRODUCT_LIST, productList);
    }

    /**
     * 验证收货明细ID
     *
     * @param receiveNotificationDetailId 收货明细ID
     *
     */
    protected void validateReceiveNotificationDetailId(Long receiveNotificationDetailId, boolean required) {
        validatorLong(FieldCode.RECEIVE_NOTIFICATION_DETAIL_ID, receiveNotificationDetailId, required, null,
                null, NumberValidator.POSITIVE);
    }


    /**
     * 验证原始订单编号
     *
     * @param orderCode
     *            原始订单编号
     */
    protected void validateBuyerOrderCode(String orderCode, boolean required) {
        this.validatorMaxLength(FieldCode.BUYER_ORDER_CODE, orderCode, required, ValidatorConst.MAX_LENGTH_BUYER_ORDER_CODE);
    }

    /**
     * 发货单编号
     *
     * @param sendNotificationCode 发货单编号
     */
    protected void validateSendNotificationCode(String sendNotificationCode, boolean required) {
        this.validatorMaxLength(FieldCode.SEND_NOTIFICATION_CODE, sendNotificationCode, required, ValidatorConst.MAX_LENGTH_SEND_NOTIFICATION_CODE);
    }


    /**
     * 发货单编号
     *
     * @param deliverCode 发货单编号
     */
    protected void validateDeliverCode(String deliverCode, boolean required) {
        this.validatorMaxLength(FieldCode.DELIVER_CODE, deliverCode, required, ValidatorConst.MAX_LENGTH_SEND_NOTIFICATION_CODE);
    }
    /**
     * 配送单编号
     *
     * @param distributionNotificationCode 配送单编号
     */
    protected void validateDistributionNotificationCode(String distributionNotificationCode, boolean required) {
        this.validatorMaxLength(FieldCode.DISTRIBUTION_NOTIFICATION_CODE, distributionNotificationCode, required, ValidatorConst.MAX_LENGTH_DISTRIBUTION_NOTIFICATION_CODE);
    }

    /**
     * 配送人名称
     *
     * @param distributionPersonName 配送人名称
     */
    protected void validateDistributionPersonName(String distributionPersonName, boolean required) {
        this.validatorMaxLength(FieldCode.DISTRIBUTION_PERSON_NAME, distributionPersonName, required, ValidatorConst.MAX_LENGTH_DISTRIBUTION_PERSON_NAME);
    }

    /**
     * 配送人电话
     *
     * @param distributionPersonPhone 配送人电话
     */
    protected void validateDistributionPersonPhone(String distributionPersonPhone, boolean required) {
        this.validatorMaxLength(FieldCode.DISTRIBUTION_PERSON_PHONE, distributionPersonPhone, required, ValidatorConst.MAX_LENGTH_DISTRIBUTION_PERSON_PHONE);
    }

    /**
     * 配送方式
     *
     * @param distributionType 配送方式
     */
    protected void validateDistributionType(String distributionType, boolean required) {
        this.validatorMaxLength(FieldCode.DISTRIBUTION_TYPE, distributionType, required, ValidatorConst.MAX_LENGTH_DISTRIBUTION_TYPE);
    }

    /**
     * 配送车辆
     *
     * @param distributionVehicle 配送车辆
     */
    protected void validateDistributionVehicle(String distributionVehicle, boolean required) {
        this.validatorMaxLength(FieldCode.DISTRIBUTION_VEHICLE, distributionVehicle, required, ValidatorConst.MAX_LENGTH_DISTRIBUTION_VEHICLE);
    }

    /**
     * 实际发车时间
     *
     * @param realDepartDatetime 实际发车时间
     *
     */
    protected void validateRealDepartDatetime(Date realDepartDatetime, boolean required) {
        validatorDate(FieldCode.REAL_DEPART_DATETIME, realDepartDatetime, required);

    }

    /**
     * 预计到达时间
     *
     * @param expectedArrivalDatetime 预计到达时间
     *
     */
    protected void validateExpectedArrivalDatetime(Date expectedArrivalDatetime, boolean required) {
        validatorDate(FieldCode.EXPECTED_ARRIVAL_DATETIME, expectedArrivalDatetime, required);

    }

    /**
     * 备注
     *
     * @param remarks 备注
     */
    protected void validateSendNotificationRemarks(String remarks, boolean required) {
        this.validatorMaxLength(FieldCode.SEND_NOTIFICATION_REMARKS, remarks, required, ValidatorConst.MAX_LENGTH_SEND_NOTIFICATION_REMARKS);
    }


    /**
     * 实际发货数量
     *
     * @param realSendQuantity 实际发货数量
     *
     */
    protected void validateRealSendQuantity(BigDecimal realSendQuantity, boolean required) {
        validatorDecimal(FieldCode.REAL_SEND_QUANTITY, realSendQuantity, required, ValidatorConst.MAX_M_RETURN_QTY,
                ValidatorConst.MAX_D_RETURN_QTY, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证买手订单编号
     *
     * @param orderCode
     *            买手订单编号
     */
    protected void validateBsOrderCode(String orderCode, boolean required) {
        this.validatorMaxLength(FieldCode.BS_ORDER_CODE, orderCode, required, ValidatorConst.MAX_LENGTH_BUYER_ORDER_CODE);
    }

    /**
     * 验证区域：物流区ID
     *
     * @param logisticsZoneId
     *            区域：物流区ID
     */
    protected void validateLogisticsZoneId(Long logisticsZoneId, boolean required) {
        validatorLong(FieldCode.LOGISTICS_ZONE_ID, logisticsZoneId, required, null, null, NumberValidator.POSITIVE);
    }

    /**
     * 验证区域：物流区编码
     *
     * @param logisticsZoneCode
     *            区域：物流区编码
     */
    protected void validateLogisticsZoneCode(String logisticsZoneCode, boolean required) {
        this.validatorMaxLength(FieldCode.LOGISTICS_ZONE_CODE, logisticsZoneCode, required,
                ValidatorConst.MAX_LENGTH_LOGISTICS_ZONE_CODE);
    }

    /**
     * 验证申请开始时间
     *
     * @param applyTimeFrom 申请开始时间
     *
     */
    protected void validateApplyTimeFrom(String applyTimeFrom, boolean required) {
        validatorStrDate(FieldCode.APPLY_TIME_FROM, applyTimeFrom, required,
                ValidatorConst.FORMAT_TIME_FROM);
    }

    /**
     * 申请截止时间
     *
     * @param applyTimeTo 申请截止时间
     *
     */
    protected void validateApplyTimeTo(String applyTimeTo, boolean required) {
        validatorStrDate(FieldCode.APPLY_TIME_TO, applyTimeTo, required,
                ValidatorConst.FORMAT_TIME_TO);
    }

}
