package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0116IParam;
import com.bms.slim.bean.result.SLIM0116IResult;
import com.bms.slim.services.SLIM0116IService;
import com.bms.slim.utils.MessageUtils;
import com.bms.slim.validator.SLIM0116IValidator;
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

@Api(tags = "SLIM0116IRestController", description = "批量新增卖家合同信息准入API")
@RestController
public class SLIM0116IRestController extends BaseRestController {

    @Autowired
    private SLIM0116IService slim0116iService;

    @ApiOperation(value = "批量新增卖家合同信息准入",
            notes = "批量新增卖家合同信息、卖家合同信息联系人，返回卖家合同信息ID集合")
    @RequestMapping(value = "/sellers/contacts/permissions/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0116IValidator.class)
    public SLIM0116IResult addSellers(@RequestBody SLIM0116IParam slim0116iParam) {
        List<Long> entitySellerIds = this.slim0116iService.addSCPsAndContacts(slim0116iParam);
        SLIM0116IResult slim0116iResult = new SLIM0116IResult();
        slim0116iResult.setCount(entitySellerIds.size());
        slim0116iResult.setScpIds(entitySellerIds);
        slim0116iResult.setMessages(MessageUtils.getSuccessMessage());
        return slim0116iResult;
    }
}
