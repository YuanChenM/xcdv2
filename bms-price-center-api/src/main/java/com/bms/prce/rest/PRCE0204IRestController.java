package com.bms.prce.rest;

/**
 *
 * 价盘营销状态修改
 *
 * @author zhou_ling
 * @version 1.0
 *
 */

import com.bms.prce.bean.param.PRCE0204IParam;
import com.bms.prce.service.PrceMarketingStatusService;
import com.bms.prce.validator.PRCE0204IValidator;
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

@RestController
@Api(description = "价盘营销状态修改",
        tags = "PRCE0204IRestController", value = "PRCE0204I", position = 0)
public class PRCE0204IRestController extends BaseRestController{

    /** 价盘营销状态 */
    @Autowired
    private PrceMarketingStatusService prceMarketingStatusService;

    /**
     * 营销状态修改
     * @Param prce0204IParam
     * @return  修改结果
     *
     */
    @ApiOperation(value = "价盘营销状态修改接口", notes = "价盘营销状态修改")
    @RequestMapping(value = "/prce/marketing/_modify", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = PRCE0204IValidator.class)
    public int modifyMarketingStatus(@RequestBody PRCE0204IParam prce0204IParam){

        return prceMarketingStatusService.modifyMarketingStatus(prce0204IParam);
    }

}
