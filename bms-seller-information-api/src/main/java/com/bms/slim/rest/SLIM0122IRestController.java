package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0122IParam;
import com.bms.slim.bean.result.SLIM0122IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0122IService;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "批量新增卖家角色接口", tags = "SLIM0122IRestController")
public class SLIM0122IRestController extends BaseRestController {

    @Autowired
    private SLIM0122IService slim0122IService;

    @ApiOperation(value = "批量新增卖家角色",
            notes = "传入参数:beans!批量新增卖家角色")
    @RequestMapping(value = "/sellers/role/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0122IValidator.class)
    public SLIM0122IResult addSellers(@RequestBody SLIM0122IParam slim0122IParam) {
        SLIM0122IResult slim0122IResult = slim0122IService.addSellers(slim0122IParam);
        slim0122IResult.setMessage(new String[]{MessageConstant.SUCCESS, "新增卖家角色成功"});
        return slim0122IResult;
    }
}
