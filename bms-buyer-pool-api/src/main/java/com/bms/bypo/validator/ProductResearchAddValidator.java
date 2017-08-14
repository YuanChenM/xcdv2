package com.bms.bypo.validator;

import com.bms.bypo.bean.param.ProductResearchRsParam;
import com.bms.bypo.constant.MessageDef;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by zhang_jian4 on 2017/01/06.
 */
public class ProductResearchAddValidator extends DefaultCustomValidator<ProductResearchRsParam> {
    @Override
    public void validator(ProductResearchRsParam param) {

        if (null != param) {

            this.validatorRequired(MessageDef.Label.L00018, param.getResearchId());
            this.validatorRequired(MessageDef.Label.L00039, param.getDemandLevel());
            this.validatorRequired(MessageDef.Label.L00026, param.getBreedCode());
            this.validatorRequired(MessageDef.Label.L00027, param.getBreedSalesName());
            this.validatorRequired(MessageDef.Label.L00028, param.getBreedScientificName());
            this.validatorRequired(MessageDef.Label.L00029, param.getBreedLocalName());
            this.validatorRequired(MessageDef.Label.L00031, param.getFeatureCode());
            this.validatorRequired(MessageDef.Label.L00032, param.getFeatureName());
            this.validatorRequired(MessageDef.Label.L00034, param.getBrandCode());
            this.validatorRequired(MessageDef.Label.L00035, param.getBrandName());
            this.validatorRequired(MessageDef.Label.L00042, param.getBrandOwnerCode());
            this.validatorRequired(MessageDef.Label.L00043, param.getOwnerName());
            this.validatorRequired(MessageDef.Label.L00037, param.getProducerCode());
            this.validatorRequired(MessageDef.Label.L00038, param.getProducerName());
            this.validatorRequired(MessageDef.Label.L00044, param.getPackageSpecification());
            this.validatorRequired(MessageDef.Label.L00045, param.getPackageQuantity());
            this.validatorRequired(MessageDef.Label.L00046, param.getNetWeight());
            this.validatorRequired(MessageDef.Label.L00047, param.getGrossWeight());
            this.validatorRequired(MessageDef.Label.L00048, param.getCartonDimension());
            this.validatorRequired(MessageDef.Label.L00049, param.getProductLevel());
            this.validatorRequired(MessageDef.Label.L00050, param.getPallerNo());
            this.validatorRequired(MessageDef.Label.L00051, param.isStandardFlg());

            if (param.getResearchId() != null) {
                this.validatorLong(MessageDef.Label.L00018, param.getResearchId(), true, 9223372036854775807L, 0L, 5);
            }
            if (StringUtils.isNotEmpty(param.getDemandLevel())) {
                this.validatorMaxLength(MessageDef.Label.L00039, param.getDemandLevel(), true, 1);
            }
            if (StringUtils.isNotEmpty(param.getBreedCode())) {
                this.validatorMaxLength(MessageDef.Label.L00026, param.getBreedCode(), true, 8);
            }
            if (StringUtils.isNotEmpty(param.getBreedSalesName())) {
                this.validatorMaxLength(MessageDef.Label.L00027, param.getBreedSalesName(), true, 32);
            }
            if (StringUtils.isNotEmpty(param.getBreedScientificName())) {
                this.validatorMaxLength(MessageDef.Label.L00028, param.getBreedScientificName(), true, 32);
            }
            if (StringUtils.isNotEmpty(param.getBreedLocalName())) {
                this.validatorMaxLength(MessageDef.Label.L00029, param.getBreedLocalName(), true, 32);
            }
            if (StringUtils.isNotEmpty(param.getFeatureCode())) {
                this.validatorMaxLength(MessageDef.Label.L00031, param.getFeatureCode(), true, 8);
            }
            if (StringUtils.isNotEmpty(param.getFeatureName())) {
                this.validatorMaxLength(MessageDef.Label.L00032, param.getFeatureName(), true, 256);
            }
            if (StringUtils.isNotEmpty(param.getBrandCode())) {
                this.validatorMaxLength(MessageDef.Label.L00034, param.getBrandCode(), true, 8);
            }
            if (StringUtils.isNotEmpty(param.getBrandName())) {
                this.validatorMaxLength(MessageDef.Label.L00035, param.getBrandName(), true, 32);
            }
            if (StringUtils.isNotEmpty(param.getBrandOwnerCode())) {
                this.validatorMaxLength(MessageDef.Label.L00042, param.getBrandOwnerCode(), true, 16);
            }
            if (StringUtils.isNotEmpty(param.getOwnerName())) {
                this.validatorMaxLength(MessageDef.Label.L00043, param.getOwnerName(), true, 256);
            }
            if (StringUtils.isNotEmpty(param.getProducerCode())) {
                this.validatorMaxLength(MessageDef.Label.L00037, param.getProducerCode(), true, 16);
            }
            if (StringUtils.isNotEmpty(param.getProducerName())) {
                this.validatorMaxLength(MessageDef.Label.L00038, param.getProducerName(), true, 256);
            }
            if (StringUtils.isNotEmpty(param.getPackageSpecification())) {
                this.validatorMaxLength(MessageDef.Label.L00044, param.getPackageSpecification(), true, 256);
            }
            if (param.getPackageQuantity() != null) {
                this.validatorInteger(MessageDef.Label.L00045, param.getPackageQuantity(), true, 2147483647, 0, 5);
            }
            if (param.getNetWeight() != null) {
                this.validatorDecimal(MessageDef.Label.L00046, param.getNetWeight(), true, 12, 2, 5);
            }
            if (param.getGrossWeight() != null) {
                this.validatorDecimal(MessageDef.Label.L00047, param.getGrossWeight(), true, 12, 2, 5);
            }
            if (StringUtils.isNotEmpty(param.getCartonDimension())) {
                this.validatorMaxLength(MessageDef.Label.L00048, param.getCartonDimension(), true, 256);
            }
            if (StringUtils.isNotEmpty(param.getProductLevel())) {
                this.validatorMaxLength(MessageDef.Label.L00049, param.getProductLevel(), true, 2);
            }
            if (param.getPallerNo() != null) {
                this.validatorInteger(MessageDef.Label.L00050, param.getPallerNo(), true, 2147483647, 0, 5);
            }

        } else {
            this.validatorRequired(MessageDef.Label.L00002, null);
        }
    }
}
