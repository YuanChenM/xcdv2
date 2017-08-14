package com.bms.bypo.validator;

import com.bms.bypo.bean.param.BaseBean;
import com.bms.bypo.bean.param.ProductResearchRsParam;
import com.bms.bypo.constant.MessageDef;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by zhang_jian4 on 2017/01/06
 */
public class ProductResearchModifyValidator extends DefaultCustomValidator<BaseBean<ProductResearchRsParam, ProductResearchRsParam>> {
    @Override
    public void validator(BaseBean<ProductResearchRsParam, ProductResearchRsParam> param) {

        if (param != null) {

            ProductResearchRsParam filter = param.getFilter();
            ProductResearchRsParam target = param.getTarget();

            this.validatorRequired(MessageDef.Label.L00053, filter.getResearchProductId());
            // 根据delFlg 判断是更新还是删除
            if (!target.isDelFlg()) {
                // 判断查询参数的长度
                if (filter.getResearchId() != null) {
                    this.validatorLong(MessageDef.Label.L00018, filter.getResearchId(), true, 9223372036854775807L, 0L, 5);
                }
                if (StringUtils.isNotEmpty(filter.getDemandLevel())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00039, filter.getDemandLevel(), true, 1);
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
                if (StringUtils.isNotEmpty(filter.getFeatureCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00031, filter.getFeatureCode(), true, 8);
                }
                if (StringUtils.isNotEmpty(filter.getFeatureName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00032, filter.getFeatureName(), true, 256);
                }
                if (StringUtils.isNotEmpty(filter.getBrandCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00034, filter.getBrandCode(), true, 8);
                }
                if (StringUtils.isNotEmpty(filter.getBrandName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00035, filter.getBrandName(), true, 32);
                }
                if (StringUtils.isNotEmpty(filter.getBrandOwnerCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00042, filter.getBrandOwnerCode(), true, 16);
                }
                if (StringUtils.isNotEmpty(filter.getOwnerName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00043, filter.getOwnerName(), true, 256);
                }
                if (StringUtils.isNotEmpty(filter.getProducerCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00037, filter.getProducerCode(), true, 16);
                }
                if (StringUtils.isNotEmpty(filter.getProducerName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00038, filter.getProducerName(), true, 256);
                }
                if (StringUtils.isNotEmpty(filter.getPackageSpecification())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00044, filter.getPackageSpecification(), true, 256);
                }
                if (filter.getPackageQuantity() != null) {
                    this.validatorInteger(MessageDef.Label.L00045, filter.getPackageQuantity(), true, 2147483647, 0, 5);
                }
                if (filter.getNetWeight() != null) {
                    this.validatorDecimal(MessageDef.Label.L00046, filter.getNetWeight(), true, 12, 2, 5);
                }
                if (filter.getGrossWeight() != null) {
                    this.validatorDecimal(MessageDef.Label.L00047, filter.getGrossWeight(), true, 12, 2, 5);
                }
                if (StringUtils.isNotEmpty(filter.getCartonDimension())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00048, filter.getCartonDimension(), true, 256);
                }
                if (StringUtils.isNotEmpty(filter.getProductLevel())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00049, filter.getProductLevel(), true, 2);
                }
                if (filter.getPallerNo() != null) {
                    this.validatorInteger(MessageDef.Label.L00050, filter.getPallerNo(), true, 2147483647, 0, 5);
                }

                //
                if (target.getResearchId() != null) {
                    this.validatorLong(MessageDef.Label.L00018, target.getResearchId(), true, 9223372036854775807L, 0L, 5);
                }
                if (StringUtils.isNotEmpty(target.getDemandLevel())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00039, target.getDemandLevel(), true, 1);
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
                if (StringUtils.isNotEmpty(target.getFeatureCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00031, target.getFeatureCode(), true, 8);
                }
                if (StringUtils.isNotEmpty(target.getFeatureName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00032, target.getFeatureName(), true, 256);
                }
                if (StringUtils.isNotEmpty(target.getBrandCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00034, target.getBrandCode(), true, 8);
                }
                if (StringUtils.isNotEmpty(target.getBrandName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00035, target.getBrandName(), true, 32);
                }
                if (StringUtils.isNotEmpty(target.getBrandOwnerCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00042, target.getBrandOwnerCode(), true, 16);
                }
                if (StringUtils.isNotEmpty(target.getOwnerName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00043, target.getOwnerName(), true, 256);
                }
                if (StringUtils.isNotEmpty(target.getProducerCode())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00037, target.getProducerCode(), true, 16);
                }
                if (StringUtils.isNotEmpty(target.getProducerName())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00038, target.getProducerName(), true, 256);
                }
                if (StringUtils.isNotEmpty(target.getPackageSpecification())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00044, target.getPackageSpecification(), true, 256);
                }
                if (target.getPackageQuantity() != null) {
                    this.validatorInteger(MessageDef.Label.L00045, target.getPackageQuantity(), true, 2147483647, 0, 5);
                }
                if (target.getNetWeight() != null) {
                    this.validatorDecimal(MessageDef.Label.L00046, target.getNetWeight(), true, 12, 2, 5);
                }
                if (target.getGrossWeight() != null) {
                    this.validatorDecimal(MessageDef.Label.L00047, target.getGrossWeight(), true, 12, 2, 5);
                }
                if (StringUtils.isNotEmpty(target.getCartonDimension())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00048, target.getCartonDimension(), true, 256);
                }
                if (StringUtils.isNotEmpty(target.getProductLevel())) {
                    this.validatorMaxLength(1, MessageDef.Label.L00049, target.getProductLevel(), true, 2);
                }
                if (target.getPallerNo() != null) {
                    this.validatorInteger(MessageDef.Label.L00050, target.getPallerNo(), true, 2147483647, 0, 5);
                }
            }

        } else {
            this.validatorRequired(MessageDef.Label.L00018, null);
        }


    }
}
