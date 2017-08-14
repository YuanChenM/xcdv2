package com.bms.byim.validator;

import com.bms.byim.bean.param.EmployeeRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by tao_zhifa on 2016/12/30.
 */
public class EmployeeSearchValidator extends DefaultCustomValidator<EmployeeRsParam> {

    @Override
    public void validator(EmployeeRsParam employeeRsParam) {
        if (employeeRsParam != null) {
            if(StringUtils.isEmpty(employeeRsParam.getBuyerId()) && StringUtils.isEmpty(employeeRsParam.getBuyerCode())){
                throw new BusinessException("BYIM", "BYIM.E00015");
            }
        } else {
            this.validatorRequired("BYIM.E00009", null);
        }
    }
}
