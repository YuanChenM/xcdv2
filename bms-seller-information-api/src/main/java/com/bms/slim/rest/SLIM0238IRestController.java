package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0238IParam;
import com.bms.slim.bean.result.SLIM0238IResult;
import com.bms.slim.bean.result.field.SLIM0238ProducerTestEquipmentyResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0238IService;
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
@Api(description = "批量查询生产商检测设备接口", tags = "SLIM0238IRestController")
public class SLIM0238IRestController extends BaseRestController {

    @Autowired
    private SLIM0238IService slim0238IService;

    @ApiOperation(value = "批量查询生产商检测设备",
            notes = "根据testEqpIds,producerIds,testEqpName,testEqpUse,delFlg查询对应的生产商检测设备信息")
    @RequestMapping(value = "/producers/test/equipments/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0238IResult findProducerTestEquipments(@RequestBody SLIM0238IParam slim0238IParam) {
        BaseRestPaginationResult<SLIM0238ProducerTestEquipmentyResult> results = slim0238IService.findProducerTestEquipments(slim0238IParam);
        SLIM0238IResult slim0238IResult = BeanUtils.toBean(results, SLIM0238IResult.class);
        slim0238IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询生产商检测设备成功"});
        return slim0238IResult;
    }
}
