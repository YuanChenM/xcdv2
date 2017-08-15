package com.bms.order.validator;

import java.util.List;

import org.springframework.util.StringUtils;

import com.bms.order.bean.param.ORDR0102IBatchBean;
import com.bms.order.bean.param.ORDR0102IBean;
import com.bms.order.bean.param.ORDR0102IProductBean;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.param.RestOperator;
import com.bms.order.constant.OrderConst;
import com.bms.order.constant.i18n.FieldCode;
import com.framework.core.utils.DateUtils;
import com.framework.validator.utils.NumberValidator;

/**
 * 买家订单修改接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0102IRestValidator extends OrderCustomValidator<BusinessRestParam<ORDR0102IBean>> {

    @Override
    public void validator(BusinessRestParam<ORDR0102IBean> request) {
        // 验证Operator
        RestOperator operator = request.getOperator();
        this.validateOperator(operator);

        List<ORDR0102IBean> params = request.getBeans();
        for (ORDR0102IBean param : params) {
            // 验证订单数据
            validatorBuyerOrder(param);

            if (null != param.getBatchOrderList() && param.getBatchOrderList().size() > 0) {
                List<ORDR0102IBatchBean> batchList = param.getBatchOrderList();
                for (ORDR0102IBatchBean batchParam : batchList) {
                    // 验证分批订单数据
                    validatorBatchOrder(batchParam);

                    List<ORDR0102IProductBean> productList = batchParam.getProducts();
                    if (null != productList && productList.size() > 0) {
                        for (ORDR0102IProductBean productParam : productList) {
                            // 验证分批订单明细数据
                            validatorBatchOrderDetail(productParam);

                        }
                    }
                }
            }
        }
    }

    /**
     * 验证订单
     *
     * @param param
     */
    private void validatorBuyerOrder(ORDR0102IBean param) {
        // 验证买家订单ID，非必填
        this.validatorLong(FieldCode.BUYER_ORDER_ID, param.getBuyerOrderId(), false, OrderConst.MAX_VALUE_BIGINT_ID,
                OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
        // 验证订单：参考号
        this.validatorMaxLength(FieldCode.BACK_NO,param.getBackNo(),false,OrderConst.MAX_LENGTH_BACK_NO);
        // 是否开具发票，非必填

        // 是否使用账期，非必填

        // 优惠金额，非必填，(15,2)，非负数
        this.validatorDecimal(FieldCode.PREFERENTIAL_AMOUNT, param.getPreferentialAmount(), false,
                OrderConst.MAX_M_AMOUNT, OrderConst.MAX_D_AMOUNT, NumberValidator.NOT_NEGATIVE);

        // 定金应付金额，非必填，(15,2)，非负数
        this.validatorDecimal(FieldCode.EARNEST_AMOUNT, param.getEarnestAmount(), false, OrderConst.MAX_M_AMOUNT,
                OrderConst.MAX_D_AMOUNT, NumberValidator.NOT_NEGATIVE);

        // 预付应付金额，非必填，(15,2)，非负数
        this.validatorDecimal(FieldCode.ADVANCE_PAYMENT_PERCENT, param.getAdvancePaymentAmount(), false,
                OrderConst.MAX_M_AMOUNT, OrderConst.MAX_D_AMOUNT, NumberValidator.NOT_NEGATIVE);

        // 买家联系电话，非必填
        this.validatorPhone(FieldCode.BUYER_PHONE, param.getBuyerPhone(), false);

        // 买家微信号，非必填，最大长度20
        this.validatorMaxLength(FieldCode.BUYER_WECHAT, param.getBuyerWechat(), false, OrderConst.MAX_LENGTH_WECHAT);

        // 买家QQ号，非必填，最大长度16
        this.validatorMaxLength(FieldCode.BUYER_QQ, param.getBuyerQQ(), false, 16);

        // 买家邮箱，非必填
        this.validatorEmail(FieldCode.BUYER_MAIL, param.getBuyerMail(), false);
        // 版本号，必填，最大OrderConst.MAX_VALUE_VERSION，最小OrderConst.MIN_VALUE_VERSION，正数
        this.validatorInteger(FieldCode.VER, param.getVer(), true, OrderConst.MAX_VALUE_PAGE_SIZE,
                OrderConst.MIN_VALUE_VERSION, NumberValidator.POSITIVE);
    }

    /**
     * 验证分批订单数据
     *
     * @param batchParam
     */
    private void validatorBatchOrder(ORDR0102IBatchBean batchParam) {
        // 1.修改模式时，ID、版本号必须有值
        // 2.新建模式时，ID、版本号必须为空，收货人名称，收货人电话，收货地址省，收货地址市，收货地址区，收货详细地址，动检证要求必填
        // 尽量避免使用if，required字段的值和影响因素有关。如：validatorMaxLength("id", value, 是否是修改模式？true:false,max_length);

        // 分批订单Id，版本号之一有值，两者都必须有值
        boolean batchFlag = (!StringUtils.isEmpty(batchParam.getBuyerBatchOrderId())
                || !StringUtils.isEmpty(batchParam.getVer()));
        // 分批订单Id，修改模式必填，新建模式必须为空，最大OrderConst.MAX_VALUE_BIGINT_ID，最小OrderConst.MIN_VALUE_BIGINT_ID，正数
        this.validatorLong(FieldCode.BUYER_BATCH_ORDER_ID, batchParam.getBuyerBatchOrderId(), batchFlag,
                OrderConst.MAX_VALUE_BIGINT_ID, OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
        // 版本号，修改模式必填，新建模式必须为空，最大OrderConst.MAX_VALUE_VERSION，最小OrderConst.MIN_VALUE_VERSION，正数
        this.validatorInteger(FieldCode.VER, batchParam.getVer(), batchFlag, OrderConst.MAX_VALUE_PAGE_SIZE,
                OrderConst.MIN_VALUE_VERSION, NumberValidator.POSITIVE);
        // 收货人名称
        this.validatorMaxLength(FieldCode.RECEIVER_NAME, batchParam.getReceiverName(), !batchFlag,
                OrderConst.MAX_LENGTH_RECEIVER_NAME);
        // 收货人电话
        this.validatorPhone(FieldCode.RECEIVER_PHONE, batchParam.getReceiverPhone(), !batchFlag);
        // 收货地址省
        this.validatorMaxLength(FieldCode.RECEIVER_PROVINCE, batchParam.getReceiverProvince(), !batchFlag,
                OrderConst.MAX_LENGTH_PROVINCE);
        // 收货地址市
        this.validatorMaxLength(FieldCode.RECEIVER_CITY, batchParam.getReceiverCity(), !batchFlag,
                OrderConst.MAX_LENGTH_CITY);
        // 收货地址区
        this.validatorMaxLength(FieldCode.RECEIVER_DISTRICT, batchParam.getReceiverDistrict(), !batchFlag,
                OrderConst.MAX_LENGTH_DISTRICT);
        // 收货详细地址
        this.validatorMaxLength(FieldCode.RECEIVER_ADDRESS, batchParam.getReceiverAddress(), !batchFlag,
                OrderConst.MAX_LENGTH_ADDRESS);
        // 动检证要求必填
        this.validatorRequired(FieldCode.ANIMAL_QUARANTINE_CERTIFICATION_FLG,
                batchParam.getAnimalQuarantineCertificationFlg());

        // 期望配送日，非必填，日期
        this.validatorStrDate(FieldCode.REQUIRED_DISTRIBUTION_DATE, batchParam.getRequiredDistributionDate(), false,
                DateUtils.FORMAT_YYYY_MM_DD);

        // 预计发货时间，非必填，日期
        this.validatorStrDate(FieldCode.EXPECTED_SENDDATE_TIME, batchParam.getExpectedSendDateTime(), false,
                DateUtils.FORMAT_YYYY_MM_DD);

        // 预计到货时间，非必填，日期
        this.validatorStrDate(FieldCode.EXPECTED_ARRIVAL_DATE_TIME, batchParam.getExpectedArrivalDateTime(), false,
                DateUtils.FORMAT_YYYY_MM_DD);

        // 优惠金额，非必填，（15，2），非负数
        this.validatorDecimal(FieldCode.PREFERENTIAL_AMOUNT, batchParam.getPreferentialAmount(), false,
                OrderConst.MAX_M_AMOUNT, OrderConst.MAX_D_AMOUNT, NumberValidator.NOT_NEGATIVE);

        // 收货地址，辅助地址，非必填，最大长度128
        this.validatorMaxLength(FieldCode.RECEIVER_ASSIST_ADDRESS, batchParam.getReceiverAssistAddress(), false,
                OrderConst.MAX_LENGTH_ASSIST_ADDRESS);

        // 订单配送区域，非必填，最大长度16
        this.validatorMaxLength(FieldCode.DELIVERY_AREA, batchParam.getDeliveryArea(), false,
                OrderConst.MAX_LENGTH_DELIVERY_AREA);

        // 准入通行车型，非必填，最大长度16
        this.validatorMaxLength(FieldCode.PASS_TRAFFIC_MODEL, batchParam.getPassTrafficModel(), false,
                OrderConst.MAX_LENGTH_PASS_TRAFFIC_MODEL);

        // 收货时间段，非必填，最大长度32.
        this.validatorMaxLength(FieldCode.RECEIVE_PERIOD, batchParam.getReceivePeriod(), false,
                OrderConst.MAX_LENGTH_RECEIVE_PERIOD);
        // 最早时间要求，非必填，最大长度32
        this.validatorMaxLength(FieldCode.RECEIVE_EARLIEST, batchParam.getReceiveEarliest(), false,
                OrderConst.MAX_LENGTH_RECEIVE_EARLIEST);

        // 最晚时间要求，非必填，最大长度32
        this.validatorMaxLength(FieldCode.RECEIVE_LATEST, batchParam.getReceiveLatest(), false,
                OrderConst.MAX_LENGTH_RECEIVE_LATEST);

        // 收货等待时间，非必填，最大长度8
        this.validatorMaxLength(FieldCode.RECEIVE_WAIT_HOUR, batchParam.getReceiveWaitHour(), false,
                OrderConst.MAX_LENGTH_RECEIVE_WAIT_HOUR);

        // 提前通知时间，非必填，最大长度8
        this.validatorMaxLength(FieldCode.ADVANCE_NOTIFICATION_HOUR, batchParam.getAdvanceNotificationHour(), false,
                OrderConst.MAX_LENGTH_ADVANCE_NOTIFICATION_HOUR);

        // 装卸要求，非必填，最大长度256
        this.validatorMaxLength(FieldCode.STEVEDORE_REQUIREMENT, batchParam.getStevedoreRequirement(), false,
                OrderConst.MAX_LENGTH_STEVEDORE_REQUIREMENT);

        // 包装要求，非必填，最大长度256
        this.validatorMaxLength(FieldCode.PACKAGE_REQUIREMENT, batchParam.getPackageRequirement(), false,
                OrderConst.MAX_LENGTH_PACKAGE_REQUIREMENT);

        // 距离门店最近停车距离，非必填，最大值Integer.MAX_VALUE，最小值0，非负
        this.validatorInteger(FieldCode.NEAREST_PARKING_DISTANCE, batchParam.getNearestParkingDistance(), false,
                Integer.MAX_VALUE, Integer.MIN_VALUE, NumberValidator.NOT_NEGATIVE);

        // 备注，非必填，最大长度256
        this.validatorMaxLength(FieldCode.REMARK, batchParam.getRemark(), false, OrderConst.MAX_LENGTH_REMARK);
    }

    /**
     * 验证分批订单明细数据
     *
     * @param productParam
     */
    private void validatorBatchOrderDetail(ORDR0102IProductBean productParam) {
        // 1.修改模式时，ID、版本号必须有值
        // 2.新建模式时，ID、版本号必须为空，商品数量，商品单位，商品ID必填
        // 尽量避免使用if，required字段的值和影响因素有关。如：validatorMaxLength("id", value, 是否是修改模式？true:false,max_length);

        // 明细Id、版本号之一有值，两者都必须有值
        Boolean detailFlag = (!StringUtils.isEmpty(productParam.getBuyerBatchOrderDetailId())
                || !StringUtils.isEmpty(productParam.getVer()));
        // 买家分批订单ID，修改模式必填，新建模式必须为空，最大OrderConst.MAX_VALUE_BIGINT_ID，最小OrderConst.MIN_VALUE_BIGINT_ID，正数
        this.validatorLong(FieldCode.BUYER_BATCH_ORDER_DETAIL_ID, productParam.getBuyerBatchOrderDetailId(), detailFlag,
                OrderConst.MAX_VALUE_BIGINT_ID, OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
        // 版本号，修改模式必填，新建模式必须为空，最大OrderConst.MAX_VALUE_VERSION，最小OrderConst.MIN_VALUE_VERSION，正数
        this.validatorInteger(FieldCode.VER, productParam.getVer(), detailFlag, OrderConst.MAX_VALUE_VERSION,
                OrderConst.MIN_VALUE_VERSION, NumberValidator.POSITIVE);

        // 商品数量，新建模式必填，MAX_M 10，MAX_D 0，正数
        this.validatorDecimal(FieldCode.GOODS_QUANTITY, productParam.getGoodsQuantity(), !detailFlag,
                OrderConst.MAX_M_AMOUNT, OrderConst.MAX_D_AMOUNT, NumberValidator.POSITIVE);
        // 版本号，修改模式必填，新建模式必须为空，最大OrderConst.MAX_VALUE_VERSION，最小OrderConst.MIN_VALUE_VERSION，正数

        // 商品Id，新建模式必填，最大长度32位
        this.validatorMaxLength(FieldCode.GOODS_ID, productParam.getGoodsId(), !detailFlag,
                OrderConst.MAX_LENGTH_PRODUCT_ID);
    }

}
