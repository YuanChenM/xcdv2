package com.bms.linv.rest;

import com.bms.linv.bean.param.LINV0108IParam;
import com.bms.linv.business.LinvAllocationBusinessService;
import com.bms.linv.validator.LINV0108IValidator;
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
@Api(description = "商品占用取消接口",
    tags = "LINV0108IRestController",
    value = "LINV0108IRestController",
    position = 0)
public class LINV0108IRestController extends BaseRestController {

    @Autowired
    private LinvAllocationBusinessService linvAllocationBusinessService;

    @ApiOperation(value = "商品占用取消",
        notes = "商品占用减少")
    @RequestMapping(value = "/linv/comoInv/allocation/_cancel",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = LINV0108IValidator.class)
    public void dispatchLoads(@RequestBody List<LINV0108IParam> list) {
        linvAllocationBusinessService.cancelOwComAloc(list);
    }

}
