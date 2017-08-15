package com.bms.slim.validator;

import com.alibaba.fastjson.JSON;
import com.bms.slim.bean.param.SLIM0103IParam;
import com.bms.slim.bean.param.field.SLIM0103IContactParam;
import com.bms.slim.bean.param.field.SLIM0103IEntitySellerParam;
import com.bms.slim.constant.CodeMasterConstant;
import com.bms.slim.constant.MessageConstant;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.validator.DefaultCustomValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SLIM0103IValidator extends DefaultCustomValidator<SLIM0103IParam> {
    private static final Logger logger = LoggerFactory.getLogger(SLIM0103IValidator.class);

    @Override
    public void validator(SLIM0103IParam slim0103iParam) {
        //super.validatorRequired("targets", slim0103iParam.getTargets());
        this.validateEntitySellerParams(slim0103iParam.getEntitySellerParams());
    }

    /**
     * 校验实体卖家参数
     */
    private void validateEntitySellerParams(List<SLIM0103IEntitySellerParam> entitySellerParams) {
        super.validatorRequired("entitySellerParams", entitySellerParams);
        if (CollectionUtils.isEmpty(entitySellerParams)) {
            return;
        }

        final int i512 = NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX << 1;
        for (SLIM0103IEntitySellerParam entitySellerParam : entitySellerParams) {
            super.validatorRequired("entitySellerId", entitySellerParam.getEntitySellerId());
            super.validatorRequired("version", entitySellerParam.getVersion());

            super.validatorMaxLength("fullName", entitySellerParam.getFullName(), false, NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX);
            super.validatorMaxLength("shortName", entitySellerParam.getShortName(), false, NumberConst.IntDef.INT_EIGHT);
            super.validatorMaxLength("password", entitySellerParam.getPassword(), false, NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX);
            super.validatorMaxLength("countryCode", entitySellerParam.getCountryCode(), false, NumberConst.IntDef.INT_EIGHT);
            super.validatorMaxLength("provinceCode", entitySellerParam.getProvinceCode(), false, NumberConst.IntDef.INT_TWO);
            super.validatorMaxLength("cityCode", entitySellerParam.getCityCode(), false, NumberConst.IntDef.INT_FOUR);
            if (StringUtils.isNotEmpty(entitySellerParam.getCountryCode())) {
                super.validatorMaxLength("countryName", entitySellerParam.getCountryName(), true, NumberConst.IntDef.INT_EIGHT);
            }
            if (StringUtils.isNotEmpty(entitySellerParam.getCityCode())) {
                super.validatorMaxLength("cityName", entitySellerParam.getCityName(), true, NumberConst.IntDef.INT_EIGHT);
            }
            if (StringUtils.isNotEmpty(entitySellerParam.getProvinceCode())) {
                super.validatorMaxLength("provinceName", entitySellerParam.getProvinceName(), true, NumberConst.IntDef.INT_EIGHT);
            }
            super.validatorMaxLength("tel", entitySellerParam.getTel(), false, NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX);
            super.validatorMaxLength("fax", entitySellerParam.getFax(), false, NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX);
            super.validatorMaxLength("mediaPlatform", entitySellerParam.getMediaPlatform(), false, i512);
            super.validatorMaxLength("address", entitySellerParam.getAddress(), false, i512);

            this.validateContactParams(entitySellerParam.getContactParams());
        }
        this.validateFullNames(entitySellerParams);
    }

    /**
     * 校验卖家全称
     */
    private void validateFullNames(List<SLIM0103IEntitySellerParam> entitySellerParams) {
        Set<String> fullNameSet = new HashSet<>();
        for (SLIM0103IEntitySellerParam entitySellerParam : entitySellerParams) {
            fullNameSet.add(entitySellerParam.getFullName());
        }

        if (fullNameSet.size() != entitySellerParams.size()) {
            String builder = new StringBuilder()
                    .append("批量修改卖家失败，fullName参数值")
                    .append(JSON.toJSONString(fullNameSet))
                    .append("，有重复数据。")
                    .toString();
            logger.info(builder);
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "批量修改卖家失败，卖家全称有重复数据。");
        }
    }

    /**
     * 校验销售类型
     */
    private void validateSaleTypes(List<String> saleTypes) {
        boolean flag = false;
        int size = CollectionUtils.isEmpty(saleTypes) ? NumberConst.IntDef.INT_ZERO: saleTypes.size();
        if (size == NumberConst.IntDef.INT_ONE || size == NumberConst.IntDef.INT_TWO) {
            flag = true;
        }

        if (flag) {
            for (String saleType : saleTypes) {
                if (!CodeMasterConstant.SaleType.CENTRALIZED_PRICING.equals(saleType)
                        && !CodeMasterConstant.SaleType.INDEPENDENT_PRICING.equals(saleType)) {
                    flag = false;
                    break;
                }
            }
        }

        if (!flag) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "批量修改卖家失败，saleTypes参数值只能为“1”、“2”。");
        }
    }

    /**
     * 校验卖家联系人参数
     */
    private void validateContactParams(List<SLIM0103IContactParam> contactParams) {
        super.validatorRequired("contactParams", contactParams);
        if (CollectionUtils.isEmpty(contactParams)) {
            return;
        }

        for (SLIM0103IContactParam contactParam : contactParams) {
            super.validatorRequired("contactId", contactParam.getContactId());
            super.validatorMaxLength("contactName", contactParam.getContactName(), true, NumberConst.IntDef.INT_THIRTY_TWO);
            super.validatorMaxLength("mobile", contactParam.getMobile(), true, NumberConst.IntDef.INT_SIXTEEN);
            super.validatorMaxLength("wechat", contactParam.getWechat(), true, NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX);
            super.validatorMaxLength("qq", contactParam.getQq(), true, NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX);
            super.validatorMaxLength("email", contactParam.getEmail(), true, NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX);
        }
    }

}
