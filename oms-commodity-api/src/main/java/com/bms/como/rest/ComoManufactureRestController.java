package com.bms.como.rest;

import com.bms.como.bean.param.ComoManufactureRsParam;
import com.bms.como.bean.result.ComoManufactureRsResult;
import com.bms.como.service.ComoManufactureService;
import com.bms.como.validator.ComoManufactureValidator;
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
 * Created by wang_haichun on 2017/3/28.
 */
@RestController
@Api(value = "bms-commodity-api", description = "商品对应生产商信息", tags = "ComoManufactureRestController")
public class ComoManufactureRestController extends BaseRestController {
    @Autowired
    private ComoManufactureService comoManufactureService;


    @ApiOperation(value = "查询商品对应生产商信息接口", notes = "商品对应生产商信息接口", position = 1)
    @RequestMapping(value = "/commodity/manufacturelist/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ComoManufactureValidator.class)
    public BaseRestPaginationResult<ComoManufactureRsResult> saveComoInfo(@RequestBody ComoManufactureRsParam comoManufactureRsParam) {
       return comoManufactureService.searchComoManufacture(comoManufactureRsParam);
    }



}
