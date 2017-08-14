package com.bms.prce.rest;

import com.bms.prce.bean.param.PRCE0211IParam;
import com.bms.prce.bean.result.PRCE0211IResult;
import com.bms.prce.service.PrcePricePlateCompareService;
import com.bms.prce.validator.PRCE0211IValidator;
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

import java.util.List;

/**
 * Created by sun_jiaju on 2017/01/19.
 */
@RestController
@Api(description = "价盘比较查询",
        tags = "PRCE0211IRestController", value = "PRCE0211I", position = 0)
public class PRCE0211IRestController extends BaseRestController {
    @Autowired
    private PrcePricePlateCompareService pricePlateCompareService;

    @ApiOperation(value = "价盘比较查询", notes = "价盘比较查询")
    @RequestMapping(value = "/prce/pricePlate/_compare", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = PRCE0211IValidator.class)
    public List<PRCE0211IResult> comparePricePlates(@RequestBody List<PRCE0211IParam> param) {
        return pricePlateCompareService.comparePricePlates(param);
    }
}
