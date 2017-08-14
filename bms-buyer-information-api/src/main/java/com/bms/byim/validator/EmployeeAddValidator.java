package com.bms.byim.validator;

import com.bms.byim.bean.param.EmployeeRsParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by tao_zhifa on 2016/12/30.
 */
public class EmployeeAddValidator extends DefaultCustomValidator<ArrayList<EmployeeRsParam>> {

    @Override
    public void validator(ArrayList<EmployeeRsParam> employeeRsParams) {
        if (CollectionUtils.isNotEmpty(employeeRsParams)) {
            for (int i = 0, lengths = employeeRsParams.size(); i < lengths; i++) {
                this.validatorMaxLength("BYIM.L00051", employeeRsParams.get(i).getBuyerId(), true, 36);
                this.validatorMaxLength("BYIM.L00093", employeeRsParams.get(i).getEmployeeName(), true, 8);
                this.validatorMaxLength("BYIM.L00094", employeeRsParams.get(i).getEmployeeType(), true, 1);
                this.validatorMaxLength("BYIM.L00095", employeeRsParams.get(i).getEmployeeTel(), true, 16);


                this.validatorRequired("BYIM.L00098", employeeRsParams.get(i).getIsContactPerson());
                this.validatorRequired("BYIM.L00102", employeeRsParams.get(i).getEmployeeCardFlg());
                this.validatorRequired("BYIM.L00101", employeeRsParams.get(i).getIsPurchase());
                this.validatorRequired("BYIM.L00100", employeeRsParams.get(i).getIsReceivePerson());

                if (!StringUtils.isEmpty(employeeRsParams.get(i).getEmployeeQq())) {
                    this.validatorMaxLength("BYIM.L00096", employeeRsParams.get(i).getEmployeeQq(), true, 16);
                }
                if (!StringUtils.isEmpty(employeeRsParams.get(i).getEmployeeWechat())) {
                    this.validatorMaxLength("BYIM.L00097", employeeRsParams.get(i).getEmployeeWechat(), true, 16);
                }
                if (!StringUtils.isEmpty(employeeRsParams.get(i).getEmployeeCardPic())) {
                    this.validatorMaxLength("BYIM.L00099", employeeRsParams.get(i).getEmployeeCardPic(), true, 16);
                }
            }
        } else {
            this.validatorRequired("BYIM.E00009", null);
        }
    }
}
