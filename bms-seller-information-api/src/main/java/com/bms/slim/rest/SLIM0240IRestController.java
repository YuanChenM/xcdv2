package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0240IParam;
import com.bms.slim.bean.result.SLIM0240IResult;
import com.bms.slim.bean.result.wrapper.SlimProducerResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0240IService;
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
@Api(description = "查询平台生产商接口", tags = "SLIM0240IRestController")
public class SLIM0240IRestController extends BaseRestController {

    @Autowired
    private SLIM0240IService slim0240IService;

    @ApiOperation(value = "批量查询平台生产商",
            notes = "根据producerIds,producerCode,producerName,delFlg查询对应的卖家生产商信息")
    @RequestMapping(value = "/producers/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0240IResult findSellerProducers(@RequestBody SLIM0240IParam slim0240IParam) {
        BaseRestPaginationResult<SlimProducerResult> results = slim0240IService.findProducers(slim0240IParam);
        SLIM0240IResult slim0240IResult = BeanUtils.toBean(results, SLIM0240IResult.class);
        slim0240IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询平台生产商成功"});
        return slim0240IResult;
    }
}
