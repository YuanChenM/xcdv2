package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0232IParam;
import com.bms.slim.bean.result.SLIM0232IResult;
import com.bms.slim.bean.result.field.SLIM0232ProducerStorageCapacityResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0232IService;
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
@Api(description = "批量查询生产商库容接口", tags = "SLIM0232IRestController")
public class SLIM0232IRestController extends BaseRestController {

    @Autowired
    private SLIM0232IService slim0232IService;

    @ApiOperation(value = "批量查询生产商库容",
            notes = "根据storageCapacityIds,producerIds,materialCapacity,productCapacity,delFlg查询对应的生产商库容信息")
    @RequestMapping(value = "/producers/storage/capacities/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0232IResult findProducerStorageCapacities(@RequestBody SLIM0232IParam slim0232IParam) {
        BaseRestPaginationResult<SLIM0232ProducerStorageCapacityResult> results = slim0232IService.findProducerStorageCapacities(slim0232IParam);
        SLIM0232IResult slim0232IResult = BeanUtils.toBean(results, SLIM0232IResult.class);
        slim0232IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询生产商库容成功"});
        return slim0232IResult;
    }
}
