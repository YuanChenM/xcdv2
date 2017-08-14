package com.bms.prce.validator;

import com.bms.prce.bean.param.PRCE0214IParam;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by sun_jiaju on 2017/01/17.
 */
public class PRCE0214IValidator extends DefaultCustomValidator<ArrayList<PRCE0214IParam>> {

    /**
     * 验证PRCE0214I接口参数
     *
     * @param params
     */
    @Override
    public void validator(ArrayList<PRCE0214IParam> params) {
        this.validatorRequired("PRCE0214.E00001", params);
        for (PRCE0214IParam param : params){
            this.validatorRequired("PRCE0214.E00002", param.getGoodId());
        }
    }
}
