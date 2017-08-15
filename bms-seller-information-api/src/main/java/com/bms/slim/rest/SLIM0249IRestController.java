package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0249IParam;
import com.bms.slim.bean.result.SLIM0249IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0249IService;
import com.bms.slim.validator.SLIM0249IValidator;
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
@Api(description = "修改卖方单位角色接口", tags = "SLIM0249IRestController")
public class SLIM0249IRestController extends BaseRestController {

    @Autowired
    private SLIM0249IService slim0249IService;

    @ApiOperation(value = "修改卖方单位角色",
            notes = "传入参数:beans!修改卖方单位角色")
    @RequestMapping(value = "/sellers/roles/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0249IValidator.class)
    public SLIM0249IResult modifySellerRoles(@RequestBody SLIM0249IParam slim0249IParam) {
        SLIM0249IResult slim0249IResult = slim0249IService.updateSellerRoles(slim0249IParam);
        if (slim0249IResult.getCount() != NumberConst.IntDef.INT_ZERO) {
            slim0249IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改卖方单位角色成功"});
        }
        return slim0249IResult;
    }

}
