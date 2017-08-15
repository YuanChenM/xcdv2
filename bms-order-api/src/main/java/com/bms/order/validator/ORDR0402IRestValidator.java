package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0402IFilterParam;
import com.bms.order.common.rest.BaseSearchRestParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.RestRequest;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.param.RestOperator;
import com.bms.order.constant.i18n.FieldCode;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

/**
 * 订单信息及对应价盘查询接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0402IRestValidator extends OrderCustomValidator<RestRequest<ORDR0402IFilterParam>> {
    @Override
    public void validator(RestRequest<ORDR0402IFilterParam> request) {
        ORDR0402IFilterParam params = request.getParam();
        //todo
        //ORDR.Field.DistributionNotificationId
        this.validatorRequired(FieldCode.DISTRIBUTION_NOTIFICATION_ID,params);
        if (null != params){
            this.validatorRequired(FieldCode.DISTRIBUTION_NOTIFICATION_ID,params.getOrderList());
        }
    }
}
