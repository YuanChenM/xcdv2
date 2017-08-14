package com.bms.linv.rest;

import com.bms.linv.bean.param.LINV0102IParam;
import com.bms.linv.business.LinvOutboundBusinessService;
import com.bms.linv.validator.LINV0102IValidator;
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
 * 销售出库接口
 * Created by wang_fan on 2017/4/18.
 */
@RestController
@Api(description = "销售出库接口",
    tags = "LINV0102IRestController",
    value = "LINV0102IRestController",
    position = 0)
public class LINV0102IRestController extends BaseRestController {

    @Autowired
    private LinvOutboundBusinessService outboundBusinessService;

    @ApiOperation(value = "销售出库",
        notes = "减少产品、商品库存")
    @RequestMapping(value = "/linv/_outbound",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = LINV0102IValidator.class)
    public void dispatchLoads(@RequestBody List<LINV0102IParam> list) {
        outboundBusinessService.dispatchLoads(list);
    }

}
