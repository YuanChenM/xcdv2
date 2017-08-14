package com.bms.prce.validator;

import com.bms.prce.bean.param.PRCE0205IParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by sun_jiaju on 2017/01/16.
 */
public class PRCE0205IValidator extends DefaultCustomValidator<PRCE0205IParam> {

    /**
     * 验证PRCE0205I接口参数
     *
     * @param param
     */
    @Override
    public void validator(PRCE0205IParam param) {
        this.validatorRequired("PRCE0205.E00001", param.getEffectiveFlg());
    }
}
