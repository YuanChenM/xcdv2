package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0103IParam;
import com.bms.slim.bean.result.SLIM0103IResult;
import com.bms.slim.services.SLIM0103IService;
import com.bms.slim.utils.MessageUtils;
import com.bms.slim.validator.SLIM0103IValidator;
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

@Api(tags = "SLIM0103IRestController", description = "批量修改卖家API")
@RestController
public class SLIM0103IRestController extends BaseRestController {

    @Autowired
    private SLIM0103IService slim0103iService;

    @ApiOperation(value = "批量修改卖家URL",
            notes = "批量修改实体卖家、卖家联系人")
    @RequestMapping(value = "/sellers/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0103IValidator.class)
    public SLIM0103IResult modifySellers(@RequestBody SLIM0103IParam slim0103iParam) {
        int count = this.slim0103iService.modifySellers(slim0103iParam);
        SLIM0103IResult slim0103iResult = new SLIM0103IResult();
        slim0103iResult.setCount(count);
        slim0103iResult.setMessages(MessageUtils.getSuccessMessage());
        return slim0103iResult;
    }

}
