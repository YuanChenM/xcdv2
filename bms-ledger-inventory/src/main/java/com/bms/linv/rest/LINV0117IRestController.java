package com.bms.linv.rest;

import java.util.List;

import com.bms.linv.bean.param.LINV0117IParam;
import com.bms.linv.bean.result.LINV0117IReslut;
import com.bms.linv.bean.result.LINV0117IResultParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.linv.bean.param.LINV0101IParam;
import com.bms.linv.business.LinvInboundBusinessService;
import com.bms.linv.validator.LINV0101IValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * OMS指定产品列表信息，向wms查询对应的库存信息
 * Created by wang_fan on 2017/4/28.
 */
@RestController
@Api(description = "OMS指定产品列表信息入库",
    tags = "LINV0117IRestController",
    value = "LINV0117IRestController",
    position = 0)
public class LINV0117IRestController extends BaseRestController {

    @Autowired
    private LinvInboundBusinessService inboundService;

    @ApiOperation(value = "OMS指定产品列表信息入库",
        notes = "OMS指定产品列表信息，向wms查询对应的库存信息")
    @RequestMapping(value = "/linv/_omsInbound",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public  List<LINV0117IResultParam> omsInbounds(@RequestBody LINV0117IParam param) {
        List<LINV0117IResultParam> linv0117IResluts= inboundService.omsInbounds(param);
        return  linv0117IResluts;
    }
}
