package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0223IParam;
import com.bms.slim.bean.param.SLIM0226IParam;
import com.bms.slim.bean.result.SLIM0223IResult;
import com.bms.slim.bean.result.SLIM0226IResult;
import com.bms.slim.bean.result.field.SLIM0223ProducerHonorCertificateResult;
import com.bms.slim.bean.result.field.SLIM0226ProducerFactoryResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0223IService;
import com.bms.slim.services.SLIM0226IService;
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
@Api(description = "批量查询生产商工厂接口", tags = "SLIM0226IRestController")
public class SLIM0226IRestController extends BaseRestController {

    @Autowired
    private SLIM0226IService slim0226IService;

    @ApiOperation(value = "批量查询生产商工厂",
            notes = "factoryIds,producerIds,totalAsset,delFlg查询对应的生产商工厂信息")
    @RequestMapping(value = "/producers/factories/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0226IResult findProducerFactory(@RequestBody SLIM0226IParam slim0226IParam) {
        BaseRestPaginationResult<SLIM0226ProducerFactoryResult> results = slim0226IService.findProducerFactory(slim0226IParam);
        SLIM0226IResult slim0226IResult = BeanUtils.toBean(results, SLIM0226IResult.class);
        slim0226IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询生产商库容成功"});
        return slim0226IResult;
    }
}
