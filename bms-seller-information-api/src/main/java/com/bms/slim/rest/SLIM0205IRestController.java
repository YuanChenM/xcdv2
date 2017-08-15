package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0205IParam;
import com.bms.slim.bean.result.SLIM0205IResult;
import com.bms.slim.bean.result.field.SLIM0205AnimalEpidemicPreventionConditionCertificateResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0205IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "批量查询生产商生产资质-动物防疫条件合格证接口", tags = "SLIM0205IRestController")
public class SLIM0205IRestController extends BaseRestController {

    @Autowired
    private SLIM0205IService slim0205IService;

    @ApiOperation(value = "批量查询生产商生产资质-动物防疫条件合格证",
            notes = "aepccIds,producerIds,delFlg查询对应的生产商生产资质-动物防疫条件合格证信息")
    @RequestMapping(value = "/producers/production/qualifications/animal/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0205IResult findAnimalEpidemicPreventionConditionCertificate(@RequestBody SLIM0205IParam slim0205IParam) {
        BaseRestPaginationResult<SLIM0205AnimalEpidemicPreventionConditionCertificateResult> results = slim0205IService.findAnimalEpidemicPreventionConditionCertificate(slim0205IParam);
        SLIM0205IResult slim0205IResult = BeanUtils.toBean(results, SLIM0205IResult.class);
        slim0205IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询生产商生产资质-动物防疫条件合格证成功"});
        return slim0205IResult;
    }
}
