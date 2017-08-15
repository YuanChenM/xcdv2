package com.bms.order.validator;

import com.bms.order.bean.param.ORDR1102IRestParam;

/**
 * Created by wang_haichun on 2017/4/27.
 */
public class ORDR1102IRestValidator extends OrderValidator<ORDR1102IRestParam> {


    @Override
    public void validator(ORDR1102IRestParam ordr1102IRestParam) {
        this.validatorRequired("pagingLevel",ordr1102IRestParam.getPagingLevel());
    }
}
