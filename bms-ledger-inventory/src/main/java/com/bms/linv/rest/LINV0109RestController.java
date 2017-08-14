package com.bms.linv.rest;

import com.bms.linv.bean.param.LINV0109IParam;
import com.bms.linv.business.LinvAllocationBusinessService;
import com.bms.linv.validator.LINV0109IValidator;
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
 * Created by zheng_xu on 2017/4/17.
 */
@RestController
@Api(description = "货权人商品占用修改",
        tags = "LINV0109RestController",
        value = "LINV0109RestController")
public class LINV0109RestController extends BaseRestController {
    @Autowired
    private LinvAllocationBusinessService linvAllocationBusinessService;

    @ApiOperation(value = "货权人商品占用修改",
            notes = "货权人商品占用修改")
    @RequestMapping(value = "/linv/comoInv/allocation/_mod",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = LINV0109IValidator.class)
    public void modifyCommAloc(@RequestBody List<LINV0109IParam> list) {

        linvAllocationBusinessService.modifyCommAloc(list);
    }
}
