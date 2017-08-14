package com.bms.prce.validator;

import com.bms.prce.bean.param.PRCE0202IParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by sun_jiaju on 2017/01/11.
 */
public class PRCE0202IValidator extends DefaultCustomValidator<PRCE0202IParam> {

    /**
     * 验证PRCE0202I接口参数
     *
     * @param param
     */
    @Override
    public void validator(PRCE0202IParam param) {
        this.validatorLong("PRCE0202.E00001", param.getWayTypeId(), false, Long.MAX_VALUE, Long.MIN_VALUE, 4);
        this.validatorMaxLength("PRCE0202.E00002", param.getWayTypeName(), false, 64);
        this.validatorDecimal("PRCE0202.E00003", param.getPriceMarginPlateRatio(), false, 12, 2, 5);
        this.validatorDecimal("PRCE0202.E00004", param.getPriceMarginSaRatio(), false, 12, 2, 5);
        if (param.getWayTypeId() != null) {
            this.validatorRequired("PRCE0202.E00008", param.getVersion());
        }
    }
}
