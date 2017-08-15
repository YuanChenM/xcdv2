package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0229IParam;
import com.bms.slim.bean.result.SLIM0229IResult;
import com.bms.slim.bean.result.field.SLIM0229ProducerWorkShopResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0229IService;
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
@Api(description = "批量查询生产商车间接口", tags = "SLIM0229IRestController")
public class SLIM0229IRestController extends BaseRestController {

    @Autowired
    private SLIM0229IService slim0229IService;

    @ApiOperation(value = "批量查询生产商车间",
            notes = "根据workshopIds,producerIds,workshopName,productionProduct,proccessFlowCharacter,delFlg查询对应的生产商车间信息")
    @RequestMapping(value = "/producers/workshops/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0229IResult findProducerWorkShops(@RequestBody SLIM0229IParam slim0229IParam) {
        BaseRestPaginationResult<SLIM0229ProducerWorkShopResult> results = slim0229IService.findProducerWorkShops(slim0229IParam);
        SLIM0229IResult slim0229IResult = BeanUtils.toBean(results, SLIM0229IResult.class);
        slim0229IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询生产商车间成功"});
        return slim0229IResult;
    }
}
