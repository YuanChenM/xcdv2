package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0623IParam;
import com.bms.slpd.bean.param.field.SLPD0622IPkgStdParam;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

/**
 * 修改储存运输标准指标Validator
 */
public class SLPD0623IValidator extends DefaultCustomValidator<SLPD0623IParam> {

    @Override
    public void validator(SLPD0623IParam slpd0623IParam) {
        if (null == slpd0623IParam) {
            return;
        }
        List<SLPD0622IPkgStdParam> pkgStdParams = slpd0623IParam.getPkgStdParams();
        String[] targets = slpd0623IParam.getTargets();
        super.validatorRequired("pkgStdParams", pkgStdParams);
        super.validatorRequired("targets", targets);

        for (SLPD0622IPkgStdParam param : pkgStdParams) {
            this.validatorRequired("pkgStdId", param.getPkgStdId());
            this.validatorRequired("itemId", param.getItemId());
//            this.validatorDecimal("pkgInSuttle",param.getPkgInSuttle(),true,10,2,0);
            this.validatorRequired("pkgInSuttle", param.getPkgInSuttle());
            this.validatorMaxLength("pkgInError", param.getPkgInError(), true, 32);
            this.validatorMaxLength("pkgInNumber", param.getPkgInNumber(), true, 32);
            this.validatorMaxLength("pkgInSize", param.getPkgInSize(), true, 32);
            this.validatorMaxLength("pkgInTexture", param.getPkgInTexture(), true, 160);
            this.validatorMaxLength("pkgOutError", param.getPkgOutError(), true, 32);
            this.validatorMaxLength("pkgOutNumber", param.getPkgOutNumber(), true, 32);
            this.validatorMaxLength("pkgOutSize", param.getPkgOutSize(), true, 32);
            this.validatorMaxLength("pkgOutTexture", param.getPkgOutTexture(), true, 160);
            this.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}
