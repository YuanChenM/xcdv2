package com.bms.byim.validator;

import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.EmployeeRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by tao_zhifa on 2016/12/30.
 */
public class EmployeeUpdateValidator extends DefaultCustomValidator<BaseBean<EmployeeRsParam, EmployeeRsParam>> {
    @Override
    public void validator(BaseBean<EmployeeRsParam, EmployeeRsParam> baseBean) {
        if (baseBean != null && baseBean != null) {
            if (!StringUtils.isEmpty(baseBean.getFilter().getEmployeeName())) {
                this.validatorMaxLength("BYIM.L00093", baseBean.getFilter().getEmployeeName(), true, 8);
            }
            if (!StringUtils.isEmpty(baseBean.getTarget().getEmployeeName())) {
                this.validatorMaxLength("BYIM.L00093", baseBean.getTarget().getEmployeeName(), true, 8);
            }

            if (!StringUtils.isEmpty(baseBean.getFilter().getEmployeeType())) {
                this.validatorMaxLength("BYIM.L00094", baseBean.getFilter().getEmployeeType(), true, 1);
            }
            if (!StringUtils.isEmpty(baseBean.getTarget().getEmployeeType())) {
                this.validatorMaxLength("BYIM.L00094", baseBean.getTarget().getEmployeeType(), true, 1);
            }

            if (!StringUtils.isEmpty(baseBean.getFilter().getEmployeeTel())) {
                this.validatorMaxLength("BYIM.L00095", baseBean.getFilter().getEmployeeTel(), true, 16);
            }
            if (!StringUtils.isEmpty(baseBean.getTarget().getEmployeeTel())) {
                this.validatorMaxLength("BYIM.L00095", baseBean.getTarget().getEmployeeTel(), true, 16);
            }

            if (!StringUtils.isEmpty(baseBean.getFilter().getEmployeeQq())) {
                this.validatorMaxLength("BYIM.L00096", baseBean.getFilter().getEmployeeQq(), true, 16);
            }
            if (!StringUtils.isEmpty(baseBean.getTarget().getEmployeeQq())) {
                this.validatorMaxLength("BYIM.L00096", baseBean.getTarget().getEmployeeQq(), true, 16);
            }

            if (!StringUtils.isEmpty(baseBean.getFilter().getEmployeeWechat())) {
                this.validatorMaxLength("BYIM.L00097", baseBean.getFilter().getEmployeeWechat(), true, 16);
            }
            if (!StringUtils.isEmpty(baseBean.getTarget().getEmployeeWechat())) {
                this.validatorMaxLength("BYIM.L00097", baseBean.getTarget().getEmployeeWechat(), true, 16);
            }


            if (!StringUtils.isEmpty(baseBean.getTarget().getEmployeeCardPic())) {
                this.validatorMaxLength("BYIM.L00099", baseBean.getTarget().getEmployeeCardPic(), true, 16);
            }
        } else {
            this.validatorRequired("BYIM.E00009", null);
        }
    }
}
