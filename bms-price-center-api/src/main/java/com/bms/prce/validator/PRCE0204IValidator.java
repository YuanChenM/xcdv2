package com.bms.prce.validator;

import com.bms.prce.bean.param.PRCE0204IParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * 营销状态修改接口
 * @author zhou_ling
 * @Time 2017/1/11
 * @version 1.0
 */
public class PRCE0204IValidator extends DefaultCustomValidator<PRCE0204IParam>{

    /**
     * 验证营销状态接口参数
     * @param prce0204IParam
     */
    @Override
    public void validator (PRCE0204IParam prce0204IParam){

        this.validatorRequired("PRCE0203.E00008", prce0204IParam);
        this.validatorLong("PRCE0203.E00002", prce0204IParam.getMarketingStatusId(), false,  Long.MAX_VALUE, Long.MIN_VALUE, 4);
        this.validatorMaxLength( "PRCE0203.E00003", prce0204IParam.getMarketingStatusName(), true, 64);
        this.validatorMaxLength("PRCE0203.E00004", prce0204IParam.getUom(), true, 8);
        if (prce0204IParam.getMarketingStatusId() != null) {
            this.validatorRequired("PRCE0203.E00006", prce0204IParam.getVersion());
        }
    }

}
