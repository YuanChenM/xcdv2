package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0633IParam;
import com.bms.slpd.bean.param.field.SLPD0631IMctDifStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

/*
 * 修改加工技术差异卡
 */
public class SLPD0633IValidator extends DefaultCustomValidator<SLPD0633IParam> {
    @Override
    public void validator(SLPD0633IParam request) {
        if (null == request || CollectionUtils.isEmpty(request.getMctDifStdParams())) {
            return;
        }
        List<SLPD0631IMctDifStdParam> mctDifStdParams = request.getMctDifStdParams();
        String[] targets = request.getTargets();
        super.validatorRequired("mctDifStdParams", mctDifStdParams);
        super.validatorRequired("targets", targets);

        for (SLPD0631IMctDifStdParam param : mctDifStdParams) {
            this.validatorRequired("mctDifStdId", param.getMctDifStdId());
            this.validatorRequired("mctStdType", param.getMctStdType());
            this.validatorRequired("breedId", param.getBreedId());
            this.validatorRequired("productId", param.getProductId());
            super.validatorMaxLength("mctOkDifVal", param.getMctOkDifVal(), false, 256);
            super.validatorMaxLength("mctNgDifVal", param.getMctNgDifVal(), false, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}
