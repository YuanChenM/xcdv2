package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0203IParam;
import com.bms.slpd.bean.param.wrapper.SlpdBreedParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.exception.BusinessException;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0203IValidator extends DefaultCustomValidator<SLPD0203IParam> {
    @Override
    public void validator(SLPD0203IParam slpd0203IParam) {
        this.validatorRequired("targets", slpd0203IParam.getTargets());  //校验targets
        this.validatorRequired("params", slpd0203IParam); //校验入参

        if (null != slpd0203IParam) {
            List<SlpdBreedParam> breedList = slpd0203IParam.getBreedList();
            this.validatorRequired("breedList", breedList);

            if (CollectionUtils.isNotEmpty(breedList)) {
                for (SlpdBreedParam param : breedList) {
                    this.validatorRequired("version", param.getVersion());
                }
                switch (slpd0203IParam.getUpdateFlg()) {
                    case "1":
                        for (SlpdBreedParam param : breedList) {
                            this.validatorRequired("classesId", param.getClassesId());
                            this.validatorMaxLength("classesName", param.getClassesName(), false, 32);
                            this.validatorMaxLength("classesCode", param.getClassesCode(), false, 3);
                        }
                        break;
                    case "2":
                        for (SlpdBreedParam param : breedList) {
                            this.validatorRequired("machiningId", param.getMachiningId());
                            this.validatorMaxLength("machiningName", param.getMachiningName(), false, 32);
                            this.validatorMaxLength("machiningCode", param.getMachiningCode(), false, 3);
                        }
                        break;
                    case "3":
                        for (SlpdBreedParam param : breedList) {
                            this.validatorRequired("breedId", param.getBreedId());
                            this.validatorMaxLength("breedSalesName", param.getBreedSalesName(), false, 32);
                            this.validatorMaxLength("breedCode", param.getBreedCode(), false, 3);
                        }
                        break;
                    default:
                        throw new BusinessException("SLPD", "updateFlg必须是1,2,3其一");
                }
            }
        }
    }
}
