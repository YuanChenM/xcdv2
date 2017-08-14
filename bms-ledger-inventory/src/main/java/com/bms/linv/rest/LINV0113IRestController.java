package com.bms.linv.rest;

import com.bms.linv.bean.param.LINV0113IParam;
import com.bms.linv.bean.result.LINV0113IResult;
import com.bms.linv.services.InvmComoInventoryService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wang_haichun on 2017/4/17.
 */
@RestController
@Api(description = "货权人商品库存查询",tags = "LINV0113IRestController",value = "LINV0113IRestController")
public class LINV0113IRestController extends BaseRestController {

    @Autowired
    private InvmComoInventoryService invmComoInventoryService;


    @ApiOperation(value = "货权人商品库存查询",
            notes = "货权人商品库存查询")
    @RequestMapping(value = "/linv/comoInv/_search",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseRestPaginationResult<LINV0113IResult> findComoInv(@RequestBody LINV0113IParam param) {
        return invmComoInventoryService.findComoInv(param);
    }
}



