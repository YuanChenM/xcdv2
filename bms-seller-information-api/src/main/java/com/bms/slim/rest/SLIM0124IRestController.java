package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0124IParam;
import com.bms.slim.bean.result.SLIM0124IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0124IService;
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
@Api(description = "修改卖家角色接口", tags = "SLIM0124IRestController")
public class SLIM0124IRestController extends BaseRestController {

    @Autowired
    private SLIM0124IService slim0124IService;

    @ApiOperation(value = "修改卖家角色",
            notes = "传入参数:beans!修改卖家角色")
    @RequestMapping(value = "/sellers/role/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0124IValidator.class)
    public SLIM0124IResult modifySellers(@RequestBody SLIM0124IParam slim0124IParam) {
        SLIM0124IResult slim0124IResult = slim0124IService.updateSellers(slim0124IParam);
        slim0124IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改卖家角色成功"});
        return slim0124IResult;
    }

}
