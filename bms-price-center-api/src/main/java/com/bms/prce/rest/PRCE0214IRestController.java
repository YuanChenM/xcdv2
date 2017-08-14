package com.bms.prce.rest;

import com.bms.prce.bean.param.PRCE0214IParam;
import com.bms.prce.service.PrceProductInfoService;
import com.bms.prce.validator.PRCE0214IValidator;
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
 *
 * 商品同步接口
 *
 * @author zhou_ling
 * @version 1.0
 *
 */
@RestController
@Api(description = "价盘删除",
        tags = "PRCE0214IRestController", value = "PRCE0214I", position = 0)
public class PRCE0214IRestController extends BaseRestController {

    @Autowired
    private PrceProductInfoService prceProductInfoService;

    /**
     * 价盘删除接口
     * @Param prce0214IParam
     * @return  修改结果
     *
     */
    @ApiOperation(value = "价盘删除", notes = "价盘删除接口")
    @RequestMapping(value = "/prce/plate/_delete", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = PRCE0214IValidator.class)
    public Integer plateDelete(@RequestBody List<PRCE0214IParam> param) {
        // 价盘删除
        int count = prceProductInfoService.plateDelete(param);
        Integer integer = count;
       return integer;
    }
}
