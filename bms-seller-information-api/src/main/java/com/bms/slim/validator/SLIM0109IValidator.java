package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0109IParam;
import com.bms.slim.bean.param.field.SLIM0109SellerManagementTeamParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0109IValidator extends DefaultCustomValidator<SLIM0109IParam> {

    @Override
    public void validator(SLIM0109IParam slim0109IParam) {
        List<SLIM0109SellerManagementTeamParam> paramList = slim0109IParam.getManagementTeamParams();
        this.validatorRequired("(请求参数)beans", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLIM0109SellerManagementTeamParam param : paramList) {
                this.validatorRequired("smtId", param.getSmtId());
                this.validatorRequired("version", param.getVersion());
            }
        }
    }

}
