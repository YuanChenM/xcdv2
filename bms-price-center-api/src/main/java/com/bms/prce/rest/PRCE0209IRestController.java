package com.bms.prce.rest;

import com.bms.prce.bean.param.PRCE0209IParam;
import com.bms.prce.service.PrcePricePlateDetailService;
import com.bms.prce.validator.PRCE0209IValidator;
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
 * Created by sun_jiaju on 2017/01/23.
 */
@RestController
@Api(description = "价盘修改",
        tags = "PRCE0209IRestController", value = "PRCE0209I", position = 0)
public class PRCE0209IRestController extends BaseRestController {
    @Autowired
    private PrcePricePlateDetailService pricePlateDetailService;

    @ApiOperation(value = "价盘修改", notes = "价盘修改")
    @RequestMapping(value = "/prce/pricePlate/_modify", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = PRCE0209IValidator.class)
    public int modifyPricePlate(@RequestBody List<PRCE0209IParam> param) {
        return pricePlateDetailService.modifyPricePlate(param);
    }
}
