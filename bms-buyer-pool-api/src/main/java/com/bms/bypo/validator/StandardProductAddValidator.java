package com.bms.bypo.validator;

import com.bms.bypo.bean.param.StandardProductRsParam;
import com.bms.bypo.constant.MessageDef;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

/**
 * Created by zhang_jian4 on 2017/01/04.
 */
public class StandardProductAddValidator extends DefaultCustomValidator<ArrayList<StandardProductRsParam>> {
    @Override
    public void validator(ArrayList<StandardProductRsParam> standardProductRsParamList) {
        if (CollectionUtils.isNotEmpty(standardProductRsParamList)) {
            int listSize = standardProductRsParamList.size();
            StandardProductRsParam param = null;
            for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
                param = standardProductRsParamList.get(i);
                this.validatorRequired(MessageDef.Label.L00014, param.getBuyerPoolId());
                this.validatorRequired(MessageDef.Label.L00019, param.getClassesId());
                this.validatorRequired(MessageDef.Label.L00020, param.getClassesCode());
                this.validatorRequired(MessageDef.Label.L00021, param.getClassesName());
                this.validatorRequired(MessageDef.Label.L00022, param.getMachiningId());
                this.validatorRequired(MessageDef.Label.L00023, param.getMachiningCode());
                this.validatorRequired(MessageDef.Label.L00024, param.getMachiningName());
                this.validatorRequired(MessageDef.Label.L00025, param.getBreedId());
                this.validatorRequired(MessageDef.Label.L00026, param.getBreedCode());
                this.validatorRequired(MessageDef.Label.L00027, param.getBreedSalesName());
                this.validatorRequired(MessageDef.Label.L00030, param.getFeatureId());
                this.validatorRequired(MessageDef.Label.L00031, param.getFeatureCode());
                this.validatorRequired(MessageDef.Label.L00032, param.getFeatureName());
                if (param.getClassesId() != null) {
                    this.validatorLong(MessageDef.Label.L00019, param.getClassesId(), true, 9223372036854775807L, 0L, 5);
                }
                if (StringUtils.isNotEmpty(param.getClassesCode())) {
                    this.validatorMaxLength(i, MessageDef.Label.L00020, param.getClassesCode(), true, 32);
                }
                if (StringUtils.isNotEmpty(param.getClassesName())) {
                    this.validatorMaxLength(i, MessageDef.Label.L00021, param.getClassesName(), true, 32);
                }
                if (param.getMachiningId() != null) {
                    this.validatorLong(MessageDef.Label.L00022, param.getMachiningId(), true, 9223372036854775807L, 0L, 5);
                }
                if (StringUtils.isNotEmpty(param.getMachiningCode())) {
                    this.validatorMaxLength(i, MessageDef.Label.L00023, param.getMachiningCode(), true, 32);
                }
                if (StringUtils.isNotEmpty(param.getMachiningName())) {
                    this.validatorMaxLength(i, MessageDef.Label.L00024, param.getMachiningName(), true, 32);
                }
                if (param.getBreedId() != null) {
                    this.validatorLong(MessageDef.Label.L00025, param.getBreedId(), true, 9223372036854775807L, 0l, 5);
                }
                if (StringUtils.isNotEmpty(param.getBreedCode())) {
                    this.validatorMaxLength(i, MessageDef.Label.L00026, param.getBreedCode(), true, 8);
                }
                if (StringUtils.isNotEmpty(param.getBreedSalesName())) {
                    this.validatorMaxLength(i, MessageDef.Label.L00027, param.getBreedSalesName(), true, 32);
                }
                if (StringUtils.isNotEmpty(param.getBreedScientificName())) {
                    this.validatorMaxLength(i, MessageDef.Label.L00028, param.getBreedScientificName(), true, 32);
                }
                if (StringUtils.isNotEmpty(param.getBreedLocalName())) {
                    this.validatorMaxLength(i, MessageDef.Label.L00029, param.getBreedLocalName(), true, 32);
                }
                if (param.getFeatureId() != null) {
                    this.validatorLong(MessageDef.Label.L00030, param.getFeatureId(), true, 9223372036854775807L, 0l, 5);
                }
                if (StringUtils.isNotEmpty(param.getFeatureCode())) {
                    this.validatorMaxLength(i, MessageDef.Label.L00031, param.getFeatureCode(), true, 8);
                }
                if (StringUtils.isNotEmpty(param.getFeatureName())) {
                    this.validatorMaxLength(i, MessageDef.Label.L00032, param.getFeatureName(), true, 256);
                }
                if (param.getBrandId() != null) {
                    this.validatorLong(MessageDef.Label.L00033, param.getBrandId(), true, 9223372036854775807L, 0l, 5);
                }
                if (StringUtils.isNotEmpty(param.getBrandCode())) {
                    this.validatorMaxLength(i, MessageDef.Label.L00034, param.getBrandCode(), true, 8);
                }
                if (StringUtils.isNotEmpty(param.getBrandName())) {
                    this.validatorMaxLength(i, MessageDef.Label.L00035, param.getBrandName(), true, 32);
                }
                if (param.getProducerId() != null) {
                    this.validatorLong(MessageDef.Label.L00036, param.getProducerId(), true, 9223372036854775807L, 0l, 5);
                }
                if (StringUtils.isNotEmpty(param.getProducerCode())) {
                    this.validatorMaxLength(i, MessageDef.Label.L00037, param.getProducerCode(), true, 16);
                }
                if (StringUtils.isNotEmpty(param.getProducerName())) {
                    this.validatorMaxLength(i, MessageDef.Label.L00038, param.getProducerName(), true, 256);
                }
            }
        } else {
            this.validatorRequired(MessageDef.Label.L00002, null);
        }
    }
}
