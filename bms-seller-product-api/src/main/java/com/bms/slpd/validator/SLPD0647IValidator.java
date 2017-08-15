package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0647IParam;
import com.bms.slpd.bean.param.field.SLPD0646IPkgDifStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;


public class SLPD0647IValidator extends DefaultCustomValidator<SLPD0647IParam> {
    @Override
    public void validator(SLPD0647IParam request) {
        if (null == request || CollectionUtils.isEmpty(request.getPkgDifStdParams())) {
            return;
        }
        List<SLPD0646IPkgDifStdParam> pkgDifStdParams = request.getPkgDifStdParams();
        String[] targets = request.getTargets();
        super.validatorRequired("targets", targets);
        super.validatorRequired("pkgDifStdParams", pkgDifStdParams);

        for (SLPD0646IPkgDifStdParam param : pkgDifStdParams) {
            this.validatorRequired("pkgDifStdId", param.getPkgDifStdId());
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
