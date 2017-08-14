package com.framework.authority.validator;

import com.framework.authority.bean.param.ValidatorParam;
import com.framework.base.bean.RestRequest;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by liutao on 2016/11/1.
 */
public class ValidatorDemo extends DefaultCustomValidator<RestRequest<ValidatorParam>> {

    @Override
    public void validator(RestRequest<ValidatorParam> param) {
//        this.validatorDate("日期",new Date(),false);
//        this.validatorStrDate("日期","2015-04-25",false, DateFormatDef.FORMAT_DATE_YYYYMMDD);
//        this.validatorRequired("日期","");
//        this.validatorDecimal("金额",BigDecimal.ZERO,false,4,2,6);
//        this.validatorInteger("正整数",1,false,20,0,4);
//        this.validatorLong("Long整数",Long.valueOf(0),false,Long.valueOf(20),Long.valueOf(0),4);
    }
}
