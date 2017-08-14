package com.bms.linv.rest;

import com.bms.linv.bean.param.LINV0106IParam;
import com.bms.linv.bean.result.LINV0106IResult;
import com.bms.linv.services.InvmComoInvReturnCompleteService;
import com.bms.linv.validator.LINV0106IValidator;
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
 * Created by wang_haichun on 2017/4/17.
 */
@RestController
@Api(description = "货权交易退货完成接口",tags = "LINV0106IRestController",value = "LINV0106IRestController")
public class LINV0106IRestController extends BaseRestController {

    @Autowired
    private InvmComoInvReturnCompleteService comoInvReturnCompleteService;


    @ApiOperation(value = "货权交易退货完成",
            notes = "货权交易退货完成")
    @RequestMapping(value = "/linv/comoInv/_return",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = LINV0106IValidator.class)
    public LINV0106IResult findComoInv(@RequestBody List<LINV0106IParam> param) {
        return comoInvReturnCompleteService.modifyComoInvReturnComplete(param);
    }
}



