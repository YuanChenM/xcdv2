package com.bms.order.rest;

import com.bms.order.bean.param.ORDR1102IRestParam;
import com.bms.order.bean.result.ORDR1102IRestResult;
import com.bms.order.services.ORDR1102IService;
import com.bms.order.validator.ORDR1102IRestValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
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

/**
 * Created by wang_haichun on 2017/4/26.
 */
@RestController
@Api( tags = {"ORDR1102IRestController"}, description = "沽货订单查询接口")
public class ORDR1102IRestController extends BaseRestController {

    @Autowired
    private ORDR1102IService ordr1102IService;



    @ApiOperation(value = "沽货订单查询接口", notes = "查询沽货订单信息")
    @RequestMapping(value = "/order/shortsell/_search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Validator(validatorClass = ORDR1102IRestValidator.class)
    public BaseRestPaginationResult<ORDR1102IRestResult> searchShortSell(@RequestBody ORDR1102IRestParam param) {
        return ordr1102IService.findOrdrShortsell(param);
    }
}
