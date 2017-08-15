package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0235IParam;
import com.bms.slim.bean.result.SLIM0235IResult;
import com.bms.slim.bean.result.field.SLIM0235ProducerLaboratoryResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0235IService;
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
@Api(description = "批量查询生产商实验室接口", tags = "SLIM0235IRestController")
public class SLIM0235IRestController extends BaseRestController {

    @Autowired
    private SLIM0235IService slim0235IService;

    @ApiOperation(value = "批量查询生产商实验室",
            notes = "根据laboratoryIds,producerIds,delFlg查询对应的生产商实验室信息")
    @RequestMapping(value = "/producers/laboratories/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0235IResult findProducerLaboratories(@RequestBody SLIM0235IParam slim0235IParam) {
        BaseRestPaginationResult<SLIM0235ProducerLaboratoryResult> results = slim0235IService.findProducerLaboratories(slim0235IParam);
        SLIM0235IResult slim0235IResult = BeanUtils.toBean(results, SLIM0235IResult.class);
        slim0235IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询生产商实验室成功"});
        return slim0235IResult;
    }
}
