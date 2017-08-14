package com.bms.prce.rest;

import com.bms.prce.bean.param.PRCE0201IParam;
import com.bms.prce.bean.param.PRCE0202IParam;
import com.bms.prce.bean.result.PRCE0201IResult;
import com.bms.prce.service.PrceWayTypeService;
import com.bms.prce.validator.PRCE0202IValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
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
 * Created by sun_jiaju on 2017/01/11.
 */
@RestController
@Api(description = "价盘通道分类修改",
        tags = "PRCE0202IRestController", value = "PRCE0201I", position = 0)
public class PRCE0202IRestController extends BaseRestController {
    @Autowired
    private PrceWayTypeService prceWayTypeService;

    @ApiOperation(value = "价盘通道分类修改", notes = "价盘通道分类修改")
    @RequestMapping(value = "/prce/way/_modify", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = PRCE0202IValidator.class)
    public int modifyWayType(@RequestBody PRCE0202IParam param) {
        return prceWayTypeService.modifyWayType(param);
    }
}
