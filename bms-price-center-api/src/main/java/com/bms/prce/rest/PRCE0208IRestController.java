package com.bms.prce.rest;

import com.bms.prce.bean.param.PRCE0208IParam;
import com.bms.prce.bean.result.PRCE0208IResult;
import com.bms.prce.service.PrcePricePlateDetailService;
import com.bms.prce.service.PrcePricePlateService;
import com.bms.prce.validator.PRCE0208IValidator;
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
 * Created by sun_jiaju on 2017/01/17.
 */
@RestController
@Api(description = "价盘详细查询",
        tags = "PRCE0208IRestController", value = "PRCE0208I", position = 0)
public class PRCE0208IRestController extends BaseRestController {
    @Autowired
    private PrcePricePlateDetailService pricePlateDetailService;

    @ApiOperation(value = "价盘详细查询", notes = "价盘详细查询")
    @RequestMapping(value = "/prce/pricePlateDetail/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = PRCE0208IValidator.class)
    public List<PRCE0208IResult> searchPricePlateDetail(@RequestBody PRCE0208IParam param) {
        List<PRCE0208IResult> res = pricePlateDetailService.findList(param);
        if (CollectionUtils.isNotEmpty(res)) {
            pricePlateDetailService.dealPlateDetail(res);
        }
        return res;
    }
}
