package com.bms.bypo.validator;

import com.bms.bypo.bean.param.BaseBean;
import com.bms.bypo.bean.param.StandardProductRsParam;
import com.bms.bypo.constant.MessageDef;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by zhang_jian4 on 2017/01/04.
 */
public class StandardProductModifyValidator extends DefaultCustomValidator<BaseBean<StandardProductRsParam, StandardProductRsParam>> {
    @Override
    public void validator(BaseBean<StandardProductRsParam, StandardProductRsParam> baseBean) {
        if (baseBean != null) {
            StandardProductRsParam filter = baseBean.getFilter();
            StandardProductRsParam target = baseBean.getTarget();
            this.validatorRequired(MessageDef.Label.L00041, filter.getStandardProductId());
            // 根据delFlg 判断是更新还是删除
            if (!target.isDelFlg()) {
                // 判断查询参数的长度
                if (filter.getClassesId() != null) {
                    this.validatorLong(MessageDef.Label.L00019, filter.getClassesId(), true, 9223372036854775807L, 0L, 5);
                }
                if (StringUtils.isNotEmpty(filter.getClassesCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00020, filter.getClassesCode(), true, 32);
                }
                if (StringUtils.isNotEmpty(filter.getClassesName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00021, filter.getClassesName(), true, 32);
                }
                if (filter.getMachiningId() != null) {
                    this.validatorLong(MessageDef.Label.L00022, filter.getMachiningId(), true, 9223372036854775807L, 0L, 5);
                }
                if (StringUtils.isNotEmpty(filter.getMachiningCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00023, filter.getMachiningCode(), true, 32);
                }
                if (StringUtils.isNotEmpty(filter.getMachiningName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00024, filter.getMachiningName(), true, 32);
                }
                if (filter.getBreedId() != null) {
                    this.validatorLong(MessageDef.Label.L00025, filter.getBreedId(), true, 9223372036854775807L, 0l, 5);
                }
                if (StringUtils.isNotEmpty(filter.getBreedCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00026, filter.getBreedCode(), true, 8);
                }
                if (StringUtils.isNotEmpty(filter.getBreedSalesName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00027, filter.getBreedSalesName(), true, 32);
                }
                if (StringUtils.isNotEmpty(filter.getBreedScientificName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00028, filter.getBreedScientificName(), true, 32);
                }
                if (StringUtils.isNotEmpty(filter.getBreedLocalName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00029, filter.getBreedLocalName(), true, 32);
                }
                if (filter.getFeatureId() != null) {
                    this.validatorLong(MessageDef.Label.L00030, filter.getFeatureId(), true, 9223372036854775807L, 0l, 5);
                }
                if (StringUtils.isNotEmpty(filter.getFeatureCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00031, filter.getFeatureCode(), true, 8);
                }
                if (StringUtils.isNotEmpty(filter.getFeatureName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00032, filter.getFeatureName(), true, 256);
                }
                if (StringUtils.isNotEmpty(filter.getDemandLevel())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00039, filter.getDemandLevel(), true, 1);
                }
                if (filter.getBrandId() != null) {
                    this.validatorLong(MessageDef.Label.L00033, filter.getBrandId(), true, 9223372036854775807L, 0l, 5);
                }
                if (StringUtils.isNotEmpty(filter.getBrandCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00034, filter.getBrandCode(), true, 8);
                }
                if (StringUtils.isNotEmpty(filter.getBrandName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00035, filter.getBrandName(), true, 32);
                }
                if (filter.getProducerId() != null) {
                    this.validatorLong(MessageDef.Label.L00036, filter.getProducerId(), true, 9223372036854775807L, 0l, 5);
                }
                if (StringUtils.isNotEmpty(filter.getProducerCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00037, filter.getProducerCode(), true, 16);
                }
                if (StringUtils.isNotEmpty(filter.getProducerName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00038, filter.getProducerName(), true, 256);
                }
                // 判断修改参数的长度
                if (target.getClassesId() != null) {
                    this.validatorLong(MessageDef.Label.L00019, target.getClassesId(), true, 9223372036854775807L, 0L, 5);
                }
                if (StringUtils.isNotEmpty(target.getClassesCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00020, target.getClassesCode(), true, 2);
                }
                if (StringUtils.isNotEmpty(target.getClassesName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00021, target.getClassesName(), true, 8);
                }
                if (target.getMachiningId() != null) {
                    this.validatorLong(MessageDef.Label.L00022, target.getMachiningId(), true, 9223372036854775807L, 0L, 5);
                }
                if (StringUtils.isNotEmpty(target.getMachiningCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00023, target.getMachiningCode(), true, 1);
                }
                if (StringUtils.isNotEmpty(target.getMachiningName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00024, target.getMachiningName(), true, 8);
                }
                if (target.getBreedId() != null) {
                    this.validatorLong(MessageDef.Label.L00025, target.getBreedId(), true, 9223372036854775807L, 0l, 5);
                }
                if (StringUtils.isNotEmpty(target.getBreedCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00026, target.getBreedCode(), true, 8);
                }
                if (StringUtils.isNotEmpty(target.getBreedSalesName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00027, target.getBreedSalesName(), true, 32);
                }
                if (StringUtils.isNotEmpty(target.getBreedScientificName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00028, target.getBreedScientificName(), true, 32);
                }
                if (StringUtils.isNotEmpty(target.getBreedLocalName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00029, target.getBreedLocalName(), true, 32);
                }
                if (target.getFeatureId() != null) {
                    this.validatorLong(MessageDef.Label.L00030, target.getFeatureId(), true, 9223372036854775807L, 0l, 5);
                }
                if (StringUtils.isNotEmpty(target.getFeatureCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00031, target.getFeatureCode(), true, 8);
                }
                if (StringUtils.isNotEmpty(target.getFeatureName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00032, target.getFeatureName(), true, 256);
                }
                if (StringUtils.isNotEmpty(target.getDemandLevel())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00039, target.getDemandLevel(), true, 1);
                }
                if (target.getBrandId() != null) {
                    this.validatorLong(MessageDef.Label.L00033, target.getBrandId(), true, 9223372036854775807L, 0l, 5);
                }
                if (StringUtils.isNotEmpty(target.getBrandCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00034, target.getBrandCode(), true, 8);
                }
                if (StringUtils.isNotEmpty(target.getBrandName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00035, target.getBrandName(), true, 32);
                }
                if (target.getProducerId() != null) {
                    this.validatorLong(MessageDef.Label.L00036, target.getProducerId(), true, 9223372036854775807L, 0l, 5);
                }
                if (StringUtils.isNotEmpty(target.getProducerCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00037, target.getProducerCode(), true, 16);
                }
                if (StringUtils.isNotEmpty(target.getProducerName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00038, target.getProducerName(), true, 256);
                }
            }
        } else {
            this.validatorRequired(MessageDef.Label.L00018, null);
        }
    }


//        List<StandardProductRsParam> standardProductRsParamList = standardProductRequest.getBeans();
//        if (CollectionUtils.isNotEmpty(standardProductRsParamList)) {
//            int listSize = standardProductRsParamList.size();
//            StandardProductRsParam param = null;
//            for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
//                param = standardProductRsParamList.get(i);
//                this.validatorRequired(MessageDef.Label.L00003, param.getLgcsAreaCode());
//                this.validatorRequired(MessageDef.Label.L00005, param.getBuyerType());
//                this.validatorRequired(MessageDef.Label.L00006, param.getBuyerFirstCategory());
//                this.validatorRequired(MessageDef.Label.L00008, param.getBuyerSubCategory());
//                this.validatorRequired(MessageDef.Label.L00011, param.getBuyerPoolName());
//                this.validatorRequired(MessageDef.Label.L00010, param.getBuyerPoolCode());


//                this.validatorRequired(MessageDef.Label.L00025, param.getBreedId());
//                this.validatorRequired(MessageDef.Label.L00026, param.getBreedCode());
//                this.validatorRequired(MessageDef.Label.L00027, param.getBreedSalesName());
//                this.validatorRequired(MessageDef.Label.L00028, param.getBreedScientificName());
//                this.validatorRequired(MessageDef.Label.L00029, param.getBreedLocalName());
//                this.validatorRequired(MessageDef.Label.L00030, param.getFeatureId());
//                this.validatorRequired(MessageDef.Label.L00031, param.getFeatureCode());
//                this.validatorRequired(MessageDef.Label.L00032, param.getFeatureName());
//                this.validatorRequired(MessageDef.Label.L00039, param.getDemandLevel());
//
//                if (StringUtils.isNotEmpty(param.getLgcsAreaCode())) {
//                    this.validatorMaxLength(i, MessageDef.Label.L00003, param.getLgcsAreaCode(), true, 2);
//                }
//                if (StringUtils.isNotEmpty(param.getBuyerType())) {
//                    this.validatorMaxLength(i, MessageDef.Label.L00005, param.getBuyerType(), true, 8);
//                }
//                if (StringUtils.isNotEmpty(param.getBuyerFirstCategory())) {
//                    this.validatorMaxLength(i, MessageDef.Label.L00006, param.getBuyerFirstCategory(), true, 2);
//                }
//                if (StringUtils.isNotEmpty(param.getBuyerSubCategory())) {
//                    this.validatorMaxLength(i, MessageDef.Label.L00008, param.getBuyerSubCategory(), true, 1);
//                }
//                if (StringUtils.isNotEmpty(param.getBuyerPoolName())) {
//                    this.validatorMaxLength(i, MessageDef.Label.L00011, param.getBuyerPoolName(), true, 16);
//                }
//                if (StringUtils.isNotEmpty(param.getBuyerPoolCode())) {
//                    this.validatorMaxLength(i, MessageDef.Label.L00010, param.getBuyerPoolCode(), true, 8);
//                }
//
//            }
//        } else {
//            this.validatorRequired(MessageDef.Label.L00002,null);
//        }
}
