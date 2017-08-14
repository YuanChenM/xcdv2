package com.bms.linv.rest;

import com.bms.linv.bean.param.LINV0115IParam;
import com.bms.linv.bean.result.LINV0115IResult;
import com.bms.linv.services.InvmComoInvTransferCompleteService;
import com.bms.linv.validator.LINV0115IValidator;
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
 * Created by zhang_jian4 on 2017/4/21.
 */
@RestController
@Api(description = "库存划拨完成",
        tags = "LINV0115RestController",
        value = "LINV0115RestController")
public class LINV0115RestController extends BaseRestController {
    @Autowired
    private InvmComoInvTransferCompleteService transferCompleteService;

    @ApiOperation(value = "库存划拨完成",
            notes = "库存划拨完成")
    @RequestMapping(value = "/linv/comoInv/transfer/_complete",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
//    @Validator(validatorClass = LINV0115IValidator.class)
    public LINV0115IResult modifyCommAloc(@RequestBody List<LINV0115IParam> linv0115IParams) {
        return transferCompleteService.modifyComoInvTransferComplete(linv0115IParams);
    }

}
