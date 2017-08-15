package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0202IParam;
import com.bms.slpd.bean.param.wrapper.SlpdBreedParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0202IValidator extends DefaultCustomValidator<SLPD0202IParam> {
    @Override
    public void validator(SLPD0202IParam slpd0202IParam) {
        if (null != slpd0202IParam) {
            List<SlpdBreedParam> breedList = slpd0202IParam.getBreedList();
            this.validatorRequired("params", breedList);

            if (CollectionUtils.isNotEmpty(breedList)) {
                switch (slpd0202IParam.getInsertFlg()) {
                    case "1":
                        for (SlpdBreedParam param : breedList) {
                            this.validatorMaxLength("classesName", param.getClassesName(), true, 32);
                            this.validatorRequired("classesCode", param.getClassesCode());
                            if (StringUtils.isNotEmpty(param.getClassesCode()))
                                this.validatorLong("classesCode", Long.valueOf(param.getClassesCode()), true, Long.valueOf(999), Long.valueOf(1), 4);
                        }
                        break;
                    case "2":
                        for (SlpdBreedParam param : breedList) {
                            this.validatorRequired("classesId", param.getClassesId());
                            this.validatorMaxLength("machiningName", param.getMachiningName(), true, 32);
                            this.validatorRequired("machiningCode", param.getMachiningCode());
                            if (StringUtils.isNotEmpty(param.getMachiningCode()))
                                this.validatorLong("machiningCode", Long.valueOf(param.getMachiningCode()), true, Long.valueOf(999), Long.valueOf(1), 4);
                        }
                        break;
                    case "3":
                        for (SlpdBreedParam param : breedList) {
                            this.validatorRequired("classesId", param.getClassesId());
                            this.validatorRequired("machiningId", param.getMachiningId());
                            this.validatorMaxLength("breedSalesName", param.getBreedSalesName(), true, 32);
                            this.validatorMaxLength("breedLocalName", param.getBreedLocalName(), false, 32);
                            this.validatorMaxLength("breedScientificName", param.getBreedScientificName(), false, 32);
                            this.validatorRequired("breedCode", param.getBreedCode());
                            if (StringUtils.isNotEmpty(param.getBreedCode()))
                                this.validatorLong("breedCode", Long.valueOf(param.getBreedCode()), true, Long.valueOf(999), Long.valueOf(1), 4);
                        }
                        break;
                    case "4":
                        for (SlpdBreedParam param : breedList) {
                            this.validatorMaxLength("className", param.getClassesName(), true, 32);
                            this.validatorMaxLength("machiningName", param.getMachiningName(), true, 32);
                            this.validatorMaxLength("breedSalesName", param.getBreedSalesName(), true, 32);
                            this.validatorMaxLength("breedLocalName", param.getBreedLocalName(), false, 32);
                            this.validatorMaxLength("breedScientificName", param.getBreedScientificName(), false, 32);
                            this.validatorRequired("classesCode", param.getClassesCode());
                            this.validatorRequired("machiningCode", param.getMachiningCode());
                            this.validatorRequired("breedCode", param.getBreedCode());
                            if (StringUtils.isNotEmpty(param.getClassesCode())) {
                                this.validatorLong("classesCode", Long.valueOf(param.getClassesCode()), true, Long.valueOf(99), Long.valueOf(1), 4);
                            }
                            if (StringUtils.isNotEmpty(param.getMachiningCode())) {
                                this.validatorLong("machiningCode", Long.valueOf(param.getMachiningCode()), true, Long.valueOf(9), Long.valueOf(1), 4);
                            }
                            if (StringUtils.isNotEmpty(param.getBreedCode()))
                                this.validatorLong("breedCode", Long.valueOf(param.getBreedCode()), true, Long.valueOf(999), Long.valueOf(1), 4);
                        }
                        break;
                    default:
                        throw new BusinessException("SLPD", "insertFlg必须为1,2,3,4中的其一"); //校验insertFlg
                }
            }
        }
    }
}
