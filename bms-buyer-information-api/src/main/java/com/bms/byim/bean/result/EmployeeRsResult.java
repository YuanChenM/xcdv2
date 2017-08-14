package com.bms.byim.bean.result;

import com.bms.byim.bean.param.EmployeeRsParam;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tao_zhifa on 2016/12/30.
 */
@ApiModel(value = "EmployeeRsResult", description = "买家雇员信息")
public class EmployeeRsResult implements Serializable {
    private List<EmployeeRsParam> employeeList;

    public List<EmployeeRsParam> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<EmployeeRsParam> employeeList) {
        this.employeeList = employeeList;
    }
}
