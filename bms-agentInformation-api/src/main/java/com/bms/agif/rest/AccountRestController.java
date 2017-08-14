package com.bms.agif.rest;

import com.bms.agif.bean.entity.AgifAccount;
import com.bms.agif.bean.param.AccountParam;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.service.AgifAccountService;
import com.bms.agif.validator.AccountAddValidator;
import com.bms.agif.validator.AccountModifyValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by guan_zhongheng on 2017/3/2.
 */
@RestController
@Api(value = "bms-agif-api",
        description = "买手账号信息操作",
        position = 1,
        tags = "AgifAgentAccountRestController")
public class AccountRestController extends BaseRestController {

    @Autowired
    private AgifAccountService agifAccountService;

    @ApiOperation(value = "买手账号新增操作",
            notes = "买手账号新增操作",
            position = 5)
    @RequestMapping(value = "/agent/account/_add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = AccountAddValidator.class)
    public Long add(@RequestBody AccountParam param) {
        return agifAccountService.addAgifAccountInfo(param);
    }


    @ApiOperation(value = "买手账号修改重置接口", notes = "买手账号修改重置接口")
    @RequestMapping(value = "/agent/account/password/_modify", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = AccountModifyValidator.class)
    public Integer passwordModify(@RequestBody BaseBean<AccountParam, AccountParam> baseParam) {
        String loginUser = agifAccountService.getLoginUserId();
        Date currentDate = DateUtils.getCurrent();
        BaseBean<AgifAccount, AgifAccount> baseBean = new BaseBean<>();
        AgifAccount target = BeanUtils.toBean(baseParam.getTarget(), AgifAccount.class);
        AgifAccount filter = BeanUtils.toBean(baseParam.getFilter(), AgifAccount.class);
        target.setUpdId(loginUser);
        target.setUpdTime(currentDate);
        baseBean.setFilter(filter);
        baseBean.setTarget(target);
        return agifAccountService.modify(baseBean);
    }

    @ApiOperation(value = "买手账号查询接口", notes = "买手账号查询接口")
    @RequestMapping(value = "/agent/account/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public AccountParam search(@RequestBody AccountParam accountParam) {
        return agifAccountService.findOne(accountParam);
    }
}
