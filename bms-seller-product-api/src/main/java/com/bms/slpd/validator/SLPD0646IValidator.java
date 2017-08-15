package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0646IParam;
import com.bms.slpd.bean.param.field.SLPD0646IPkgDifStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

/**
 * 新增包装标准指标差异Validator
 */
public class SLPD0646IValidator extends DefaultCustomValidator<SLPD0646IParam> {

    @Override
    public void validator(SLPD0646IParam slpd0646IParam) {
        if (null == slpd0646IParam || CollectionUtils.isEmpty(slpd0646IParam.getPkgDifStdParams())) {
            return;
        }
        List<SLPD0646IPkgDifStdParam> pkgDifStdParams = slpd0646IParam.getPkgDifStdParams();
        super.validatorRequired("pkgDifStdParams", pkgDifStdParams);

        for (SLPD0646IPkgDifStdParam param : pkgDifStdParams) {
            this.validatorRequired("itemId", param.getItemId());
            this.validatorRequired("productId", param.getProductId());
            super.validatorMaxLength("pkgDifInSuttle", param.getPkgDifInSuttle(), false, 256);
            super.validatorMaxLength("pkgDifInError", param.getPkgDifInError(), false, 256);
            super.validatorMaxLength("pkgDifInNumber", param.getPkgDifInNumber(), false, 256);
            super.validatorMaxLength("pkgDifInSize", param.getPkgDifInSize(), false, 256);
            super.validatorMaxLength("pkgDifInTexture", param.getPkgDifInTexture(), false, 256);
            super.validatorMaxLength("pkgDifOutError", param.getPkgDifOutError(), false, 256);
            super.validatorMaxLength("pkgDifOutNumber", param.getPkgDifOutNumber(), false, 256);
            super.validatorMaxLength("pkgDifOutSize", param.getPkgDifOutSize(), false, 256);
            super.validatorMaxLength("pkgDifOutTexture", param.getPkgDifOutTexture(), false, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }

    }
}
