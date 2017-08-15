package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0502IFilterParam;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.constant.OrderConst;
import com.bms.order.constant.i18n.FieldCode;
import com.bms.order.constant.i18n.ValidatorCode;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.ValidatorExceptionMessage;
import com.framework.validator.DefaultCustomValidator;
import com.framework.validator.utils.NumberValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang_jianzhou on 2017/1/23.
 */
public class ORDR0502IRestValidator extends OrderCustomValidator<SearchRestParam<ORDR0502IFilterParam>> {


    @Override
    public void validator(SearchRestParam<ORDR0502IFilterParam> param) {
        this.validateOperator(param.getOperator());
        if(null != param.getPagination()){
            int startPos = param.getPagination().getStartPos();
            int pageSize = param.getPagination().getPageSize();
            validatorInteger(FieldCode.START_POS,startPos,true,
                    OrderConst.MAX_VALUE_START_POS, OrderConst.MIN_VALUE_START_POS, NumberValidator.POSITIVE);
            validatorInteger(FieldCode.PAGE_SIZE,pageSize,true,
                    OrderConst.MAX_VALUE_PAGE_SIZE, OrderConst.MIN_VALUE_PAGE_SIZE, NumberValidator.POSITIVE);
        }
    }
}
