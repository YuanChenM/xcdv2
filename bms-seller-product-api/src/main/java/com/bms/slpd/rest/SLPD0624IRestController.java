package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0624IParam;
import com.bms.slpd.bean.result.SLPD0624IResult;
import com.bms.slpd.services.SLPD0624IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.bms.slpd.utils.MessageUtils;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "查询包装标准指标",tags = "SLPD0624IRestController")
public class SLPD0624IRestController extends BaseRestController {

    @Autowired
    private SLPD0624IService slpd0624IService;

    @Autowired
    private CodeMasterUtils codeMasterUtils;

    @ApiOperation(value = "查询包装标准指标",
            notes = "查询包装标准指标")
    @RequestMapping(value = "/products/package/standard/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0624IResult findPkgStds(@RequestBody SLPD0624IParam slpd0624IParam) {
        SLPD0624IResult slpd = slpd0624IService.findPkgStdsAndDifStds(slpd0624IParam);
        slpd.setMessage(MessageUtils.getSuccessMessage());
        return slpd;
    }



}
