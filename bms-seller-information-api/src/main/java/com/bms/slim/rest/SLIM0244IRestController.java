package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0244IParam;
import com.bms.slim.bean.result.SLIM0244IResult;
import com.bms.slim.services.SLIM0244IService;
import com.bms.slim.utils.MessageUtils;
import com.bms.slim.validator.SLIM0244IValidator;
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

@Api(tags = "SLIM0244IRestController", description = "批量新增联系人API")
@RestController
public class SLIM0244IRestController extends BaseRestController {

    @Autowired
    private SLIM0244IService slim0244iService;

    @ApiOperation(value = "批量新增联系人",
            notes = "批量新增联系人")
    @RequestMapping(value = "/contacts/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0244IValidator.class)
    public SLIM0244IResult addSellers(@RequestBody SLIM0244IParam slim0244iParam) {
        List<Long> contactIds = this.slim0244iService.addContacts(slim0244iParam);
        SLIM0244IResult slim0244iResult = new SLIM0244IResult();
        slim0244iResult.setCount(contactIds.size());
        slim0244iResult.setContactIds(contactIds);
        slim0244iResult.setMessages(MessageUtils.getSuccessMessage());
        return slim0244iResult;
    }
}
