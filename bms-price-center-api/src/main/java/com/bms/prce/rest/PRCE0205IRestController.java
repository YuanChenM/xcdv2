package com.bms.prce.rest;

import com.bms.prce.bean.param.PRCE0205IParam;
import com.bms.prce.bean.result.PRCE0205IResult;
import com.bms.prce.service.PrceMarketingWayConfigService;
import com.bms.prce.validator.PRCE0205IValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
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
@Api(description = "价盘营销状态通道查询",
        tags = "PRCE0205IRestController", value = "PRCE0205I", position = 0)
public class PRCE0205IRestController extends BaseRestController {
    @Autowired
    private PrceMarketingWayConfigService prceMarketingWayConfigService;

    @ApiOperation(value = "价盘营销状态通道查询", notes = "价盘营销状态通道查询")
    @RequestMapping(value = "/prce/marketingWay/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = PRCE0205IValidator.class)
    public List<PRCE0205IResult> searchMarketingWay(@RequestBody PRCE0205IParam param) {
        List<PRCE0205IResult> res = prceMarketingWayConfigService.findList(param);
        if (CollectionUtils.isNotEmpty(res)) {
            prceMarketingWayConfigService.dealWayConfig(res);
        }
        return res;
    }
}
