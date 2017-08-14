package com.bms.linv.rest;

import com.bms.linv.bean.param.LINV0103IParam;
import com.bms.linv.business.LinvAllocationBusinessService;
import com.bms.linv.validator.LINV0103IValidator;
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
 * Created by zheng_xu on 2017/4/14.
 */
@RestController
@Api(description = "产品库存占用",
    tags = "LINV0103IRestController",
    value = "LINV0103IRestController")
public class LINV0103IRestController extends BaseRestController {
    @Autowired
    private LinvAllocationBusinessService linvAllocationBusinessService;

    @ApiOperation(value = "产品库存占用",
        notes = "产品库存占用")
    @RequestMapping(value = "/linv/loadInv/_allocate",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = LINV0103IValidator.class)
    public void allocatedProduct(@RequestBody List<LINV0103IParam> list) {

        linvAllocationBusinessService.allocatedProduct(list);
    }
}
