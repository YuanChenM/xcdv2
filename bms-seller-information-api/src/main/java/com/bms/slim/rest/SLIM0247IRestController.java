package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0247IParam;
import com.bms.slim.bean.result.SLIM0247IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0247IService;
import com.bms.slim.validator.SLIM0247IValidator;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "新增卖方单位角色接口", tags = "SLIM0247IRestController")
public class SLIM0247IRestController extends BaseRestController {

    @Autowired
    private SLIM0247IService slim0247IService;

    @ApiOperation(value = "新增卖方单位角色",
            notes = "传入参数:beans!新增卖方单位角色")
    @RequestMapping(value = "/sellers/roles/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0247IValidator.class)
    public SLIM0247IResult addSellerRoles(@RequestBody SLIM0247IParam slim0247IParam) {
        SLIM0247IResult slim0247IResult = slim0247IService.saveSellerRoles(slim0247IParam);
        if (slim0247IResult.getCount() != NumberConst.IntDef.INT_ZERO) {
            slim0247IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增卖方单位角色成功"});
        }
        return slim0247IResult;
    }

}
