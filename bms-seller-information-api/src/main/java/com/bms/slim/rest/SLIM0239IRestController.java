package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0239IParam;
import com.bms.slim.bean.result.SLIM0239IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0239IService;
import com.bms.slim.validator.SLIM0239IValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "批量修改生产商检测设备接口", tags = "SLIM0239IRestController")
public class SLIM0239IRestController extends BaseRestController {

    @Autowired
    private SLIM0239IService slim0239IService;

    @ApiOperation(value = "批量修改生产商检测设备",
            notes = "传入参数:beans!批量修改生产商检测设备")
    @RequestMapping(value = "/producers/test/equipments/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0239IValidator.class)
    public SLIM0239IResult modifyProducerTestEquipments(@RequestBody SLIM0239IParam slim0239IParam) {
        SLIM0239IResult slim0239IResult = slim0239IService.updateProducerTestEquipments(slim0239IParam);
        slim0239IResult.setMessage(new String[]{MessageConstant.SUCCESS, "修改生产商检测设备成功"});
        return slim0239IResult;
    }

}
