package com.bms.linv.rest;

import java.util.List;

import com.bms.linv.bean.param.LINV0101IParam;
import com.bms.linv.validator.LINV0101IValidator;
import com.framework.validator.annotation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.linv.business.LinvInboundBusinessService;
import com.framework.boot.base.BaseRestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 采购入库接口
 * Created by wang_fan on 2017/4/14.
 */
@RestController
@Api(description = "采购入库",
    tags = "LINV0101IRestController",
    value = "LINV0101IRestController",
    position = 0)
public class LINV0101IRestController extends BaseRestController {

    @Autowired
    private LinvInboundBusinessService inboundService;

    @ApiOperation(value = "采购入库",
        notes = "采购入库接口，增加产品、商品库存")
    @RequestMapping(value = "/linv/_inbound",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = LINV0101IValidator.class)
    public void receiveLoads(@RequestBody List<LINV0101IParam> list) {
        inboundService.receiveLoads(list);
    }
}
