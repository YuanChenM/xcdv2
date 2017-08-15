package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0218IParam;
import com.bms.slim.bean.result.SLIM0218IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0218IService;
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
@Api(description = "批量修改生产商生产资质-食品生产许可证接口", tags = "SLIM0218IRestController")
public class SLIM0218IRestController extends BaseRestController {

    @Autowired
    private SLIM0218IService slim0218IService;

    @ApiOperation(value = "批量修改生产商生产资质-食品生产许可证",
            notes = "传入参数:beans!批量修改生产商生产资质-食品生产许可证")
    @RequestMapping(value = "/producers/production/qualifications/food/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0218IValidator.class)
    public SLIM0218IResult modifyFoodProductionLicense(@RequestBody SLIM0218IParam slim0218IParam) {
        SLIM0218IResult slim0218IResult = slim0218IService.updateFoodProductionLicense(slim0218IParam);
        slim0218IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改生产商生产资质-食品生产许可证成功"});
        return slim0218IResult;
    }

}
