package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0208IParam;
import com.bms.slim.bean.result.SLIM0208IResult;
import com.bms.slim.bean.result.field.SLIM0208DesignatSlaughterPermitResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0208IService;
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
@Api(description = "批量查询生产商生产资质-定点屠宰许可证接口", tags = "SLIM0208IRestController")
public class SLIM0208IRestController extends BaseRestController {

    @Autowired
    private SLIM0208IService slim0208IService;

    @ApiOperation(value = "批量查询生产商生产资质-定点屠宰许可证",
            notes = "dspIds,producerIds,delFlg查询对应的生产商生产资质-定点屠宰许可证信息")
    @RequestMapping(value = "/producers/production/qualifications/designat/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0208IResult findAnimalEpidemicPreventionConditionCertificate(@RequestBody SLIM0208IParam slim0208IParam) {
        BaseRestPaginationResult<SLIM0208DesignatSlaughterPermitResult> results = slim0208IService.findDesignatSlaughterPermit(slim0208IParam);
        SLIM0208IResult slim0208IResult = BeanUtils.toBean(results, SLIM0208IResult.class);
        slim0208IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询生产商生产资质-定点屠宰许可证成功"});
        return slim0208IResult;
    }
}
