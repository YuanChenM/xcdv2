package com.bms.slim.validator;

import com.alibaba.fastjson.JSON;
import com.bms.slim.bean.param.SLIM0101IParam;
import com.bms.slim.bean.param.field.SLIM0101IContactParam;
import com.bms.slim.bean.param.field.SLIM0101IEntitySellerParam;
import com.bms.slim.constant.MessageConstant;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.exception.BusinessException;
import com.framework.validator.DefaultCustomValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SLIM0101IValidator extends DefaultCustomValidator<SLIM0101IParam> {
    private static final Logger logger = LoggerFactory.getLogger(SLIM0101IValidator.class);

    @Override
    public void validator(SLIM0101IParam slim0101iParam) {
        this.validateEntitySellerParams(slim0101iParam.getEntitySellerParams());
    }

    /**
     * 校验实体卖家参数
     */
    private void validateEntitySellerParams(List<SLIM0101IEntitySellerParam> entitySellerParams) {
        super.validatorRequired("entitySellerParams", entitySellerParams);
        if (CollectionUtils.isEmpty(entitySellerParams)) {
            return;
        }

        final int i128 = NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX >> 1;
        final int i512 = NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX << 1;

        for (SLIM0101IEntitySellerParam entitySellerParam : entitySellerParams) {
            super.validatorMaxLength("fullName", entitySellerParam.getFullName(), true, NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX);
            super.validatorMaxLength("shortName", entitySellerParam.getShortName(), true, NumberConst.IntDef.INT_EIGHT);
            super.validatorMaxLength("countryCode", entitySellerParam.getCountryCode(), true, NumberConst.IntDef.INT_EIGHT);
            super.validatorMaxLength("countryName", entitySellerParam.getCountryName(), true, NumberConst.IntDef.INT_SIXTEEN);
            super.validatorMaxLength("provinceCode", entitySellerParam.getProvinceCode(), true, NumberConst.IntDef.INT_TWO);
            super.validatorMaxLength("provinceName", entitySellerParam.getProvinceName(), true, NumberConst.IntDef.INT_SIXTEEN);
            super.validatorMaxLength("cityCode", entitySellerParam.getCityCode(), true, NumberConst.IntDef.INT_FOUR);
            super.validatorMaxLength("cityName", entitySellerParam.getCityName(), true, NumberConst.IntDef.INT_EIGHT);
            super.validatorMaxLength("tel", entitySellerParam.getTel(), false, NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX);
            super.validatorMaxLength("fax", entitySellerParam.getFax(), false, NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX);
            super.validatorMaxLength("mediaPlatform", entitySellerParam.getMediaPlatform(), false, i512);
            super.validatorMaxLength("address", entitySellerParam.getAddress(), true, i512);

            this.validateContactParams(entitySellerParam.getContactParams());
        }

        this.validateFullNames(entitySellerParams);
        this.validateAccounts(entitySellerParams);
    }

    /**
     * 校验卖家全称
     */
    private void validateFullNames(List<SLIM0101IEntitySellerParam> entitySellerParams) {
        Set<String> fullNameSet = new HashSet<>();
        for (SLIM0101IEntitySellerParam entitySellerParam : entitySellerParams) {
            fullNameSet.add(entitySellerParam.getFullName());
        }

        if (fullNameSet.size() != entitySellerParams.size()) {
            String builder = new StringBuilder()
                    .append("批量新增卖家失败，fullName参数值")
                    .append(JSON.toJSONString(fullNameSet))
                    .append("，有重复数据。")
                    .toString();
            logger.info(builder);
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "批量新增卖家失败，卖家全称有重复数据。");
        }
    }

    /**
     * 校验卖家账号
     */
    private void validateAccounts(List<SLIM0101IEntitySellerParam> entitySellerParams) {

    }

    /**
     * 校验卖家联系人参数
     */
    private void validateContactParams(List<SLIM0101IContactParam> contactParams) {
        super.validatorRequired("contactParams", contactParams);
        if (CollectionUtils.isEmpty(contactParams)) {
            return;
        }

        for (SLIM0101IContactParam contactParam : contactParams) {
            super.validatorMaxLength("contactName", contactParam.getContactName(), true, NumberConst.IntDef.INT_THIRTY_TWO);
            super.validatorMaxLength("mobile", contactParam.getMobile(), true, NumberConst.IntDef.INT_SIXTEEN);
            super.validatorMaxLength("wechat", contactParam.getWechat(), true, NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX);
            super.validatorMaxLength("qq", contactParam.getQq(), true, NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX);
            super.validatorMaxLength("email", contactParam.getEmail(), true, NumberConst.IntDef.INT_TWO_HUNDRED_FIFTY_SIX);
        }
    }

}
