package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0304IBeanParam;
import com.bms.order.common.rest.RestRequest;
import com.bms.order.constant.OrderConst;
import com.bms.order.constant.i18n.FieldCode;
import com.framework.validator.utils.NumberValidator;

/**
 * 买手订单修改接口Validator
 * 
 * @author li_huiqian
 */
public class ORDR0304IRestValidator extends OrderCustomValidator<RestRequest<ORDR0304IBeanParam>> {
    @Override
    public void validator(RestRequest<ORDR0304IBeanParam> request) {
        // 验证配送通知单
        validatorDistributionNotifcation(request.getParam());
    }

    /**
     * 验证配送通知单
     */
    private void validatorDistributionNotifcation(ORDR0304IBeanParam bean) {
        this.validatorLong("orderId", bean.getOrderId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
        // 配送单id
        this.validatorLong(FieldCode.DISTRIBUTION_NOTIFICATION_ID, bean.getShipId(), true,
                OrderConst.MAX_VALUE_BIGINT_ID, OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);


        // 实际取消时间
        this.validatorStrDate(FieldCode.CANCEL_DATETIME, bean.getCancelTime(), true, "yyyy-MM-dd HH:mm:ss");
    }

}
