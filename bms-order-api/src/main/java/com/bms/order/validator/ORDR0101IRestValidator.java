package com.bms.order.validator;

import com.bms.order.bean.param.ORDR010101IRestParam;
import com.bms.order.bean.param.ORDR010102IRestParam;
import com.bms.order.bean.param.ORDR0101IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.param.RestOperator;
import com.bms.order.constant.OrderConst;
import com.bms.order.constant.enumeration.OrderPlacerType;
import com.bms.order.constant.enumeration.OrderSourceType;
import com.bms.order.constant.enumeration.PaymentType;
import com.bms.order.constant.enumeration.SalePlatformType;
import com.bms.order.constant.i18n.FieldCode;
import com.bms.order.constant.i18n.ValidatorCode;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.bean.ValidatorExceptionMessage;
import com.framework.validator.utils.NumberValidator;

import java.util.List;

/**
 * 买家订单修改接口Validator
 * 
 * @author li_huiqian
 */
public class ORDR0101IRestValidator extends OrderCustomValidator<BusinessRestParam<ORDR0101IBeanParam>> {

    @Override
    public void validator(BusinessRestParam<ORDR0101IBeanParam> param) {
        // 验证Operator
        RestOperator operator = param.getOperator();
        this.validateOperator(operator);

        List<ORDR0101IBeanParam> beans = param.getBeans();
        // beans必填
        validatorRequired(FieldCode.BEANS, beans);
        if (beans == null || beans.size() == 0)
            return;

        for (ORDR0101IBeanParam bean : beans) {
            // 验证订单数据
            validatorBuyerOrder(bean);
            Boolean flg = false;
            if (!StringUtils.isEmpty(bean.getLgcsAreaCode())){
                flg = true;
            }

            List<ORDR010101IRestParam> subOrderList = bean.getDetails();
            this.validatorRequired(FieldCode.SUB_ORDER_LIST, subOrderList);
            if (subOrderList == null || subOrderList.size() == 0)
                continue;

            for (ORDR010101IRestParam batchBean : subOrderList) {
                // 验证分批订单数据
                validatorBatchOrder(batchBean);

                List<ORDR010102IRestParam> productList = batchBean.getProducts();
                this.validatorRequired(FieldCode.PRODUCT_LIST, productList);
                if (productList == null || productList.size() == 0)
                    continue;

                for (ORDR010102IRestParam detailBean : productList) {
                    // 验证分批订单明细数据
                    validatorDetail(detailBean, flg);
                }
            }
        }
    }

    /**
     * 验证买家订单
     * 
     * @param bean
     */
    private void validatorBuyerOrder(ORDR0101IBeanParam bean) {
        // 买家Id，必填
        this.validatorMaxLength(FieldCode.BUYER_ID, bean.getBuyerId(), true, OrderConst.MAX_LENGTH_BUYER_ID);

        this.validatorMaxLength(FieldCode.LGCS_AREA_CODE, bean.getLgcsAreaCode(), false, 2);

        // 参考号，非必填
        validatorMaxLength(FieldCode.BACK_NO, bean.getBackNo(), false,
                OrderConst.MAX_LENGTH_BACK_NO);

        // 是否开具发票，必填
        this.validatorRequired(FieldCode.INVOICE_FLG, bean.getInvoiceFlg());

        // 是否使用账期，必填
        this.validatorRequired(FieldCode.USE_NET_FLG, bean.getUseNetFlg());

        // 下单时间，必填
        this.validatorStrDate(FieldCode.ORDER_PLACE_DATETIME, bean.getOrderPlaceDatetime(), true, DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS);

        // 销售平台，必填
        if (SalePlatformType.getInstance(bean.getSalePlatform()) == null) {
            // {0}中没有Code为"{1}"的值
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.SALE_PLATFORM, "SalePlatform", bean.getSalePlatform()));
        }

        // 订单来源，必填
        if (OrderSourceType.getInstance(bean.getOrderSource()) == null) {
            // {0}中没有Code为"{1}"的值
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.ORDER_SOURCE, "OrderSource", bean.getOrderSource()));
        }

        // 是否分批，必填
        this.validatorRequired(FieldCode.BATCH_FLG, bean.getBatchFlg());

        // 下单员Id，必填
        this.validatorMaxLength(FieldCode.ORDER_PLACER_ID, bean.getOrderPlacerId(), true,
                OrderConst.MAX_LENGTH_ORDER_PLACER_ID);

        // 下单员类型，必填
        if (OrderPlacerType.getInstance(bean.getOrderPlacerType()) == null) {
            // {0}中没有Code为"{1}"的值
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.ORDER_PLACER_TYPE, "OrderPlacerType", bean.getOrderPlacerType()));
        }

        // 付款类型，必填
        if (PaymentType.getInstance(bean.getPaymentType()) == null) {
            // {0}中没有Code为"{1}"的值
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.PAYMENT_TYPE, "PaymentType", bean.getPaymentType()));
        }

        // 运费金额，非必填
        this.validatorDecimal(FieldCode.FREIGHT, bean.getFreight(), false, OrderConst.MAX_M_AMOUNT,
                OrderConst.MAX_D_AMOUNT, NumberValidator.NOT_NEGATIVE);

        // 优惠金额
        this.validatorDecimal(FieldCode.PREFERENTIAL_AMOUNT, bean.getPreferentialAmount(), false,
                OrderConst.MAX_M_AMOUNT, OrderConst.MAX_D_AMOUNT, NumberValidator.NOT_NEGATIVE);

        // 定金应付金额
        this.validatorDecimal(FieldCode.EARNEST_AMOUNT, bean.getEarnestAmount(), false, OrderConst.MAX_M_AMOUNT,
                OrderConst.MAX_D_AMOUNT, NumberValidator.NOT_NEGATIVE);

        // 预付金应付金额
        this.validatorDecimal(FieldCode.ADVANCE_PAYMENT_AMOUNT, bean.getAdvancePaymentAmount(), false,
                OrderConst.MAX_M_AMOUNT, OrderConst.MAX_D_AMOUNT, NumberValidator.NOT_NEGATIVE);
    }

    /**
     * 验证买家分批订单信息
     * 
     * @param batchBean
     */
    private void validatorBatchOrder(ORDR010101IRestParam batchBean) {
        // 期望配送日，非必填
        this.validatorStrDate(FieldCode.REQUIRED_DISTRIBUTION_DATE, batchBean.getRequiredDistributionDate(), false,
                "yyyy-MM-dd");

        // 收货人名称，必填
        this.validatorMaxLength(FieldCode.RECEIVER_NAME, batchBean.getReceiverName(), true,
                OrderConst.MAX_LENGTH_RECEIVER_NAME);

        // 收货人电话，必填
        this.validatorPhone(FieldCode.RECEIVER_PHONE, batchBean.getReceiverPhone(), true);

        // 收货人QQ，非必填
        this.validatorMaxLength(FieldCode.RECEIVER_QQ, batchBean.getReceiverQq(), false, OrderConst.MAX_LENGTH_QQ);

        // 收货人微信，非必填
        this.validatorMaxLength(FieldCode.RECEIVER_WECHAT, batchBean.getReceiverWechat(), false,
                OrderConst.MAX_LENGTH_WECHAT);

        // 收货人邮箱，非必填
        this.validatorEmail(FieldCode.RECEIVER_MAIL, batchBean.getReceiverMail(), false);

        // 收货地址省，必填
        this.validatorMaxLength(FieldCode.RECEIVER_PROVINCE, batchBean.getReceiverProvince(), true,
                OrderConst.MAX_LENGTH_PROVINCE);

        // 收货地址市，必填
        this.validatorMaxLength(FieldCode.RECEIVER_CITY, batchBean.getReceiverCity(), true, OrderConst.MAX_LENGTH_CITY);

        // 收货地址区县，必填
        this.validatorMaxLength(FieldCode.RECEIVER_DISTRICT, batchBean.getReceiverDistrict(), true,
                OrderConst.MAX_LENGTH_DISTRICT);

        // 收货地址详细地址，必填
        this.validatorMaxLength(FieldCode.RECEIVER_ADDRESS, batchBean.getReceiverAddress(), true,
                OrderConst.MAX_LENGTH_ADDRESS);

        // 收货地址，辅助地址，非必填，最大长度128
        this.validatorMaxLength(FieldCode.RECEIVER_ASSIST_ADDRESS, batchBean.getReceiverAssistAddress(), false,
                OrderConst.MAX_LENGTH_ASSIST_ADDRESS);

        // 订单配送区域，非必填，最大长度16
        this.validatorMaxLength(FieldCode.DELIVERY_AREA, batchBean.getDeliveryArea(), false,
                OrderConst.MAX_LENGTH_DELIVERY_AREA);

        // 准入通行车型，非必填，最大长度16
        this.validatorMaxLength(FieldCode.PASS_TRAFFIC_MODEL, batchBean.getPassTrafficModel(), false,
                OrderConst.MAX_LENGTH_PASS_TRAFFIC_MODEL);

        // 收货时间段，非必填，最大长度32.
        this.validatorMaxLength(FieldCode.RECEIVE_PERIOD, batchBean.getReceivePeriod(), false,
                OrderConst.MAX_LENGTH_RECEIVE_PERIOD);

        // 最早时间要求，非必填，最大长度32
        this.validatorMaxLength(FieldCode.RECEIVE_EARLIEST, batchBean.getReceiveEarliest(), false,
                OrderConst.MAX_LENGTH_RECEIVE_EARLIEST);

        // 最晚时间要求，非必填，最大长度32
        this.validatorMaxLength(FieldCode.RECEIVE_LATEST, batchBean.getReceiveLatest(), false,
                OrderConst.MAX_LENGTH_RECEIVE_LATEST);

        // 收货等待时间，非必填，最大长度8
        this.validatorMaxLength(FieldCode.RECEIVE_WAIT_HOUR, batchBean.getReceiveWaitHour(), false,
                OrderConst.MAX_LENGTH_RECEIVE_WAIT_HOUR);

        // 提前通知时间，非必填，最大长度8
        this.validatorMaxLength(FieldCode.ADVANCE_NOTIFICATION_HOUR, batchBean.getAdvancedNotificationHour(), false,
                OrderConst.MAX_LENGTH_ADVANCE_NOTIFICATION_HOUR);

        // 动检证要求，必填
        this.validatorRequired(FieldCode.ANIMAL_QUARANTINE_CERTIFICATION_FLG,
                batchBean.getAnimalQuarantineCertificationFlg());

        // 装卸要求，非必填，最大长度256
        this.validatorMaxLength(FieldCode.STEVEDORE_REQUIREMENT, batchBean.getStevedoreRequirement(), false,
                OrderConst.MAX_LENGTH_STEVEDORE_REQUIREMENT);

        // 包装要求，非必填，最大长度256
        this.validatorMaxLength(FieldCode.PACKAGE_REQUIREMENT, batchBean.getPackageRequirement(), false,
                OrderConst.MAX_LENGTH_PACKAGE_REQUIREMENT);

        // 距离门店最近停车距离，非必填，最大值Integer.MAX_VALUE，最小值0，非负
        this.validatorInteger(FieldCode.NEAREST_PARKING_DISTANCE, batchBean.getNearestParkingDistance(), false,
                OrderConst.MAX_VALUE_PAGE_SIZE, OrderConst.MAX_D_GOODS_QUANTITY, NumberValidator.POSITIVE);

        // 备注，非必填，最大长度256
        this.validatorMaxLength(FieldCode.REMARK, batchBean.getRemark(), false, OrderConst.MAX_LENGTH_REMARK);

        // 预计发货时间，非必填，日期
        this.validatorStrDate(FieldCode.EXPECTED_SENDDATE_TIME, batchBean.getExpectedSendDateTime(), false,
                "yyyy-MM-dd HH:mm:ss");

        // 预计到货时间，非必填，日期
        this.validatorStrDate(FieldCode.EXPECTED_ARRIVAL_DATE_TIME, batchBean.getExpectedArrivalDateTime(), false,
                "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 验证买家分批明细信息
     * 
     * @param detailBean
     */
    private void validatorDetail(ORDR010102IRestParam detailBean, Boolean flg) {
        // 商品数量，必填
        this.validatorDecimal(FieldCode.GOODS_QUANTITY, detailBean.getGoodsQuantity(), true,
                OrderConst.MAX_M_GOODS_QUANTITY, OrderConst.MAX_D_GOODS_QUANTITY, NumberValidator.POSITIVE);

        // 商品ID，必填
        this.validatorMaxLength(FieldCode.GOODS_ID, detailBean.getGoodsId(), true, OrderConst.MAX_LENGTH_PRODUCT_ID);
        if (flg){
            this.validatorDecimal(FieldCode.PRICE_KG, detailBean.getPriceKg(), true, 15, 4, NumberValidator.POSITIVE);
            this.validatorDecimal(FieldCode.PRICE_UNIT, detailBean.getPriceUnit(), true, 15, 4, NumberValidator.POSITIVE);
            this.validatorMaxLength(FieldCode.WAY_DESC, detailBean.getWayDesc(), true, 64);
        }

    }

}
