package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0610IParam;
import com.bms.slpd.bean.param.field.SLPD0610ITncStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

/**
 * 新增加工质量标准Validator
 */
public class SLPD0610IValidator extends DefaultCustomValidator<SLPD0610IParam> {

    @Override
    public void validator(SLPD0610IParam slpd0610IParam) {
        if (null == slpd0610IParam || CollectionUtils.isEmpty(slpd0610IParam.getTncStdParams())) {
            return;
        }
        List<SLPD0610ITncStdParam> tncStdParams = slpd0610IParam.getTncStdParams();
        super.validatorRequired("tncStdParams", tncStdParams);

        for (SLPD0610ITncStdParam param : tncStdParams) {
            this.validatorRequired("tncStdType", param.getTncStdType());
            this.validatorRequired("breedId", param.getBreedId());
            super.validatorMaxLength("tncStdValA", param.getTncStdValA(), true, 256);
            super.validatorMaxLength("tncStdValB", param.getTncStdValB(), true, 256);
            super.validatorMaxLength("tncStdValC", param.getTncStdValC(), true, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }

    }
}
