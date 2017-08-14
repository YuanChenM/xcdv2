package com.bms.prce.validator;

import com.bms.prce.bean.param.PRCE0210IParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by sun_jiaju on 2017/01/17.
 */
public class PRCE0210IValidator extends DefaultCustomValidator<PRCE0210IParam> {

    /**
     * 验证PRCE0210I接口参数
     *
     * @param param
     */
    @Override
    public void validator(PRCE0210IParam param) {
        this.validatorRequired("PRCE0210.E00001", param.getMarketingWayConfigIds());
        if (param.getMarketingWayConfigIds() != null && param.getMarketingWayConfigIds().length > 0) {
            for (Long marketingWayConfigId : param.getMarketingWayConfigIds()) {
                this.validatorLong("PRCE0210.E00001", marketingWayConfigId, false,  Long.MAX_VALUE, Long.MIN_VALUE, 4);
            }
        }
    }
}
