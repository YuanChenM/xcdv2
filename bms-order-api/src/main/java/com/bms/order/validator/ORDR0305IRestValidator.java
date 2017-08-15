package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0305IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.param.RestOperator;
import com.bms.order.constant.OrderConst;
import com.bms.order.constant.i18n.FieldCode;
import com.framework.validator.utils.NumberValidator;

import java.util.List;

/**
 * 买手订单修改接口Validator
 * 
 * @author li_huiqian
 */
public class ORDR0305IRestValidator extends OrderCustomValidator<BusinessRestParam<ORDR0305IBeanParam>> {
    @Override
    public void validator(BusinessRestParam<ORDR0305IBeanParam> param) {

        // 验证Operator
        RestOperator operator = param.getOperator();
        this.validateOperator(operator);

        List<ORDR0305IBeanParam> beans = param.getBeans();
        // beans必填
        validatorRequired(FieldCode.BEANS, beans);
        if (beans == null || beans.size() == 0)
            return;

        for (ORDR0305IBeanParam bean : beans) {
            // 验证配送通知单
            validatorDistributionNotifcation(bean);
        }
    }

    /**
     * 验证配送通知单
     */
    private void validatorDistributionNotifcation(ORDR0305IBeanParam bean) {

        // 配送单id
        this.validatorLong(FieldCode.DISTRIBUTION_NOTIFICATION_ID, bean.getDistributionNotificationId(), true,
                OrderConst.MAX_VALUE_BIGINT_ID, OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
        // 仓库编码
        this.validatorMaxLength(FieldCode.WH_CODE, bean.getWhCode(), false, 20);
        // 仓库名称
        this.validatorMaxLength(FieldCode.WH_NAME, bean.getWhName(), false, 30);
    }

}
