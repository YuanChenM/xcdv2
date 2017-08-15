package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0244IParam;
import com.bms.slim.bean.param.field.SLIM0244IContactParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0244IValidator extends DefaultCustomValidator<SLIM0244IParam> {


    @Override
    public void validator(SLIM0244IParam slim0244IParam) {

        List<SLIM0244IContactParam> contactParams = slim0244IParam.getContactParams();
        this.validatorRequired("contactParams", contactParams);

        if (CollectionUtils.isNotEmpty(contactParams)) {
            for (SLIM0244IContactParam contactParam : contactParams) {
                this.validatorMaxLength("contactName", contactParam.getContactName(), true, 32);
                this.validatorMaxLength("mobile", contactParam.getMobile(), true, 16);
                this.validatorMaxLength("wechat", contactParam.getWechat(), true, 256);
                this.validatorMaxLength("qq", contactParam.getQq(), true, 256);
                this.validatorMaxLength("email", contactParam.getEmail(), true, 256);
                this.validatorRequired("workunitId", contactParam.getWorkunitId());
                this.validatorMaxLength("workunitType", contactParam.getWorkunitType(), true, 1);
                if (StringUtils.toString(NumberConst.IntDef.INT_THREE).equals(contactParam.getContactType())) {
                    this.validatorMaxLength("contactType", contactParam.getContactType(), true, 2);
                } else {
                    this.validatorMaxLength("contactType", contactParam.getContactType(), false, 2);
                }
            }
        }
    }
}
