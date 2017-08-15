package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0202IParam;
import com.bms.slim.bean.result.SLIM0202IResult;
import com.bms.slim.bean.result.wrapper.SlimProducerResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0202IService;
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
@Api(description = "查询卖家生产商接口", tags = "SLIM0202IRestController")
public class SLIM0202IRestController extends BaseRestController {

    @Autowired
    private SLIM0202IService slim0202IService;

    @ApiOperation(value = "查询卖家生产商",
            notes = "根据producerIds,producerCode,entitySellerIds,delFlg,fullName查询对应的卖家生产商信息")
    @RequestMapping(value = "/sellers/producers/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0202IResult findSellerProducers(@RequestBody SLIM0202IParam slim0202IParam) {
        BaseRestPaginationResult<SlimProducerResult> results = slim0202IService.findSellerProducers(slim0202IParam);
        SLIM0202IResult slim0202IResult = BeanUtils.toBean(results, SLIM0202IResult.class);
        slim0202IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询卖家生产商成功"});
        return slim0202IResult;
    }
}
