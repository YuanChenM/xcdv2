package com.bms.prce.rest;

import com.bms.prce.bean.param.PRCE0206IParam;
import com.bms.prce.service.PrceWayConfigService;
import com.bms.prce.validator.PRCE0206IValidator;
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
 * Created by sun_jiaju on 2017/01/12.
 */
@RestController
@Api(description = "价盘营销状态通道修改",
        tags = "PRCE0206IRestController", value = "PRCE0206I", position = 0)
public class PRCE0206IRestController extends BaseRestController {
    @Autowired
    private PrceWayConfigService prceWayConfigService;

    @ApiOperation(value = "价盘营销状态通道修改", notes = "价盘营销状态通道修改")
    @RequestMapping(value = "/prce/marketingWay/_modify", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = PRCE0206IValidator.class)
    public List<Long> modifyWayConfig(@RequestBody List<PRCE0206IParam> param) {
        return prceWayConfigService.modifyWayConfig(param);
    }
}
