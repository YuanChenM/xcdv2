package com.bms.order.validator;

import java.util.List;

import com.bms.order.bean.param.ORDR0205IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.param.RestOperator;
import com.framework.validator.DefaultCustomValidator;

/**
 * 订单手动分拆阈值设定接口Validator
 * 
 * @author li_huiqian
 */
public class ORDR0205IRestValidator extends OrderCustomValidator<BusinessRestParam<ORDR0205IBeanParam>> {
    @Override
    public void validator(BusinessRestParam<ORDR0205IBeanParam> param) {

        RestOperator operator = param.getOperator();
        this.validateOperator(operator);

        List<ORDR0205IBeanParam> beans = param.getBeans();
        int index = 1;
        for (ORDR0205IBeanParam bean : beans) {
            this.validatorRequired(index, "buyerBatchOrderDetailId", bean.getBuyerBatchOrderDetailId());
            this.validatorRequired(index, "manualSplitFlg", bean.getManualSplitFlg());
            index++;
        }
    }
}
