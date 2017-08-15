package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0101IParam;
import com.bms.slim.bean.result.SLIM0101IResult;
import com.bms.slim.services.SLIM0101IService;
import com.bms.slim.utils.MessageUtils;
import com.bms.slim.validator.SLIM0101IValidator;
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

@Api(tags = "SLIM0101IRestController", description = "批量新增卖家API")
@RestController
public class SLIM0101IRestController extends BaseRestController {

    @Autowired
    private SLIM0101IService slim0101iService;

    @ApiOperation(value = "批量新增卖家URL",
            notes = "批量实体卖家、卖家联系人，返回实体卖家ID")
    @RequestMapping(value = "/sellers/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0101IValidator.class)
    public SLIM0101IResult addSellers(@RequestBody SLIM0101IParam slim0101iParam) {
        List<Long> entitySellerIds = this.slim0101iService.addSellers(slim0101iParam);
        SLIM0101IResult slim0101iResult = new SLIM0101IResult();
        slim0101iResult.setCount(entitySellerIds.size());
        slim0101iResult.setEntitySellerIds(entitySellerIds);
        slim0101iResult.setMessages(MessageUtils.getSuccessMessage());
        return slim0101iResult;
    }

}
