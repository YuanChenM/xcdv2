package com.bms.linv.rest;

import com.bms.linv.bean.param.LINV0105IParam;
import com.bms.linv.business.LinvDealBusinessService;
import com.bms.linv.validator.LINV0105IValidator;
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
 * 商品交易接口
 * Created by wang_fan on 2017/4/18.
 */
@RestController
@Api(description = "商品交易",
    tags = "LINV0105IRestController",
    value = "LINV0105IRestController",
    position = 0)
public class LINV0105IRestController extends BaseRestController {

    @Autowired
    private LinvDealBusinessService dealBusinessService;

    @ApiOperation(value = "商品交易",
        notes = "完成商品货权交易")
    @RequestMapping(value = "/linv/comoInv/_deal",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = LINV0105IValidator.class)
    public void dealStore(@RequestBody List<LINV0105IParam> list) {
        dealBusinessService.dealStore(list);
    }

}
