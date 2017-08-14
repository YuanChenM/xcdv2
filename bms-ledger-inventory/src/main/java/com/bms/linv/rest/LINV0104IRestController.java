package com.bms.linv.rest;

import com.bms.linv.bean.param.LINV0104IParam;
import com.bms.linv.business.LinvAllocationBusinessService;
import com.bms.linv.validator.LINV0104IValidator;
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
 * Created by guan_zhongheng on 2017/4/17.
 */
@RestController
@Api(description = "产品库存占用取消", tags = "LINV0104IRestController", value = "LINV0104IRestController", position = 5)
public class LINV0104IRestController extends BaseRestController {

    @Autowired
    private LinvAllocationBusinessService linvAllocationBusinessService;

    @ApiOperation(value = "产品库存占用取消",
            notes = "产品库存占用取消")
    @RequestMapping(value = "/linv/loadInv/allocation/_cancel",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = LINV0104IValidator.class)
    public String allocatedProduct(@RequestBody List<LINV0104IParam> list) {
        linvAllocationBusinessService.cancelProcductAloc(list);
        return "占用取消成功!";
    }

}
