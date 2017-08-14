package com.bms.prce.rest;

import com.bms.prce.bean.param.PRCE0210IParam;
import com.bms.prce.service.PrcePricePlateRefreshService;
import com.bms.prce.validator.PRCE0208IValidator;
import com.bms.prce.validator.PRCE0210IValidator;
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
 * Created by sun_jiaju on 2017/01/17.
 */
@RestController
@Api(description = "价盘刷新",
        tags = "PRCE0210IRestController", value = "PRCE0210I", position = 0)
public class PRCE0210IRestController extends BaseRestController {
    @Autowired
    private PrcePricePlateRefreshService prcePricePlateRefreshService;

    @ApiOperation(value = "价盘刷新", notes = "价盘刷新")
    @RequestMapping(value = "/prce/pricePlate/_refresh", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = PRCE0210IValidator.class)
    public void refreshPricePlate(@RequestBody PRCE0210IParam param) {
        prcePricePlateRefreshService.refreshPricePlate(param);
    }
}
