package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0212IParam;
import com.bms.slim.bean.result.SLIM0212IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0212IService;
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
@Api(description = "批量修改生产商生产资质-清真食品生产经营许可证接口", tags = "SLIM0212IRestController")
public class SLIM0212IRestController extends BaseRestController {

    @Autowired
    private SLIM0212IService slim0212IService;

    @ApiOperation(value = "批量修改生产商生产资质-清真食品生产经营许可证",
            notes = "传入参数:beans!批量修改生产商生产资质-清真食品生产经营许可证")
    @RequestMapping(value = "/producers/production/qualifications/halal/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0212IValidator.class)
    public SLIM0212IResult modifyHalalFoodProductionOperationLicenses(@RequestBody SLIM0212IParam slim0212IParam) {
        SLIM0212IResult slim0212IResult = slim0212IService.updateHalalFoodProductionOperationLicenses(slim0212IParam);
        slim0212IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改生产商生产资质-清真食品生产经营许可证成功"});
        return slim0212IResult;
    }

}
