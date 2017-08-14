package com.bms.byim.rest;

import com.bms.byim.bean.entity.ByimEmployee;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.BuyerAccountRsParam;
import com.bms.byim.bean.param.EmployeeRsParam;
import com.bms.byim.bean.result.EmployeeRsResult;
import com.bms.byim.services.ByimBuyerService;
import com.bms.byim.services.ByimEmployeeService;
import com.bms.byim.validator.EmployeeAddValidator;
import com.bms.byim.validator.EmployeeSearchValidator;
import com.bms.byim.validator.EmployeeUpdateValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tao_zhifa on 2016/12/30.
 */

@RestController
@Api(value = "bms-byim-api", description = "买家雇员信息", position = 1, tags = "EmployeeRestController")
public class EmployeeRestController extends BaseRestController {
    @Autowired
    private ByimEmployeeService byimEmployeeService;

    @Autowired
    private ByimBuyerService byimBuyerService;

    @ApiOperation(value = "买家雇员信息新增", notes = "买家雇员信息新增", position = 5)
    @RequestMapping(value = "/buyers/employee/_add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = EmployeeAddValidator.class)
    public EmployeeRsResult addEmployee(@RequestBody List<EmployeeRsParam> employeeRsParams) {
        List<ByimEmployee> list = BeanUtils.toList(employeeRsParams, ByimEmployee.class);
        EmployeeRsResult rsResult = new EmployeeRsResult();
        rsResult = byimEmployeeService.executeBatchSave(list);
        return rsResult;
    }

    @ApiOperation(value = "买家雇员信息修改", notes = "买家雇员信息修改", position = 5)
    @RequestMapping(value = "/buyers/employee/_update", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = EmployeeUpdateValidator.class)
    public Integer modifyEmployee(@RequestBody BaseBean<EmployeeRsParam, EmployeeRsParam> baseBean) {

        int result;
        result = byimEmployeeService.executeUpdate(baseBean);
        return result;
    }


    @ApiOperation(value = "买家雇员信息查询", notes = "买家雇员信息查询", position = 5)
    @RequestMapping(value = "/buyers/employee/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = EmployeeSearchValidator.class)
    public BaseRestPaginationResult<EmployeeRsParam> modifyEmployee(@RequestBody EmployeeRsParam employeeRsParam) {
        if (!StringUtils.isEmpty(employeeRsParam.getEmployeeName())) {
            employeeRsParam.setEmployeeName(DbUtils.buildLikeCondition(employeeRsParam.getEmployeeName(), DbUtils.LikeMode.PARTIAL));
        }
        if (!StringUtils.isEmpty(employeeRsParam.getEmployeeTel())) {
            employeeRsParam.setEmployeeTel(DbUtils.buildLikeCondition(employeeRsParam.getEmployeeTel(), DbUtils.LikeMode.PARTIAL));
        }
        if (!StringUtils.isEmpty(employeeRsParam.getEmployeeQq())) {
            employeeRsParam.setEmployeeQq(DbUtils.buildLikeCondition(employeeRsParam.getEmployeeQq(), DbUtils.LikeMode.PARTIAL));
        }
        if (!StringUtils.isEmpty(employeeRsParam.getEmployeeWechat())) {
            employeeRsParam.setEmployeeWechat(DbUtils.buildLikeCondition(employeeRsParam.getEmployeeWechat(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isEmpty(employeeRsParam.getBuyerId()) && StringUtils.isNotEmpty(employeeRsParam.getBuyerCode())) {
            //通过买家编码查询买家ID
            BuyerAccountRsParam accountRsParam = new BuyerAccountRsParam();
            accountRsParam.setBuyerCode(employeeRsParam.getBuyerCode());
            String buyerId = byimBuyerService.findBuyerId(accountRsParam);
            employeeRsParam.setBuyerId(buyerId);
        }
        BaseRestPaginationResult<EmployeeRsParam> paramList;
        paramList = byimEmployeeService.findPageList(employeeRsParam);
        return paramList;
    }
}
