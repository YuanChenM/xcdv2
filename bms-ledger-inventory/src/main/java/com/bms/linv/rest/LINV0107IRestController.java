package com.bms.linv.rest;

import com.bms.linv.bean.param.LINV0103IParam;
import com.bms.linv.bean.param.LINV0107IParam;
import com.bms.linv.business.LinvAllocationBusinessService;
import com.bms.linv.validator.LINV0103IValidator;
import com.bms.linv.validator.LINV0107IValidator;
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
@Api(description = "货权人商品占用",
    tags = "LINV0107IRestController",
    value = "LINV0107IRestController")
public class LINV0107IRestController extends BaseRestController {
    @Autowired
    private LinvAllocationBusinessService linvAllocationBusinessService;

    @ApiOperation(value = "货权人商品占用",
        notes = "货权人商品占用")
    @RequestMapping(value = "/linv/comoinv/_allocate",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = LINV0107IValidator.class)
    public void allocatedComm(@RequestBody List<LINV0107IParam> list) {

        linvAllocationBusinessService.allocatedComm(list);
    }
}
