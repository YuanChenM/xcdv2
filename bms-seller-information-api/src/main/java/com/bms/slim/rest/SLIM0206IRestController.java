package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0206IParam;
import com.bms.slim.bean.result.SLIM0206IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0206IService;
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
@Api(description = "批量修改生产商生产资质-动物防疫条件合格证接口", tags = "SLIM0206IRestController")
public class SLIM0206IRestController extends BaseRestController {

    @Autowired
    private SLIM0206IService slim0206IService;

    @ApiOperation(value = "批量修改生产商生产资质-动物防疫条件合格证",
            notes = "传入参数:beans!批量修改生产商生产资质-动物防疫条件合格证")
    @RequestMapping(value = "/producers/production/qualifications/animal/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Validator(validatorClass = SLIM0206IValidator.class)
    public SLIM0206IResult modifyAnimalEpidemicPreventionConditionCertificate(@RequestBody SLIM0206IParam slim0206IParam) {
        SLIM0206IResult slim0206IResult = slim0206IService.updateAnimalEpidemicPreventionConditionCertificate(slim0206IParam);
        slim0206IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改生产商生产资质-动物防疫条件合格证成功"});
        return slim0206IResult;
    }

}
