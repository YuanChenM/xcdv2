package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0209IParam;
import com.bms.slim.bean.result.SLIM0209IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0209IService;
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
@Api(description = "批量修改生产商生产资质-定点屠宰许可证接口", tags = "SLIM0209IRestController")
public class SLIM0209IRestController extends BaseRestController {

    @Autowired
    private SLIM0209IService slim0209IService;

    @ApiOperation(value = "批量修改生产商生产资质-定点屠宰许可证",
            notes = "传入参数:beans!批量修改生产商生产资质-定点屠宰许可证")
    @RequestMapping(value = "/producers/production/qualifications/designat/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0209IValidator.class)
    public SLIM0209IResult modifyDesignatSlaughterPermit(@RequestBody SLIM0209IParam slim0209IParam) {
        SLIM0209IResult slim0209IResult = slim0209IService.updateDesignatSlaughterPermit(slim0209IParam);
        slim0209IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改生产商生产资质-定点屠宰许可证成功"});
        return slim0209IResult;
    }

}
