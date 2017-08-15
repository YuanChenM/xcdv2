package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0245IParam;
import com.bms.slim.bean.result.SLIM0245IResult;
import com.bms.slim.bean.result.field.SLIM0245IContactResult;
import com.bms.slim.services.SLIM0245IService;
import com.bms.slim.utils.MessageUtils;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "SLIM0245IRestController", description = "批量查询联系人信息API")
@RestController
public class SLIM0245IRestController extends BaseRestController {

    @Autowired
    private SLIM0245IService slim0245iService;

    @ApiOperation(value = "批量查询联系人信息",
            notes = "批量查询联系人信息")
    @RequestMapping(value = "/contacts/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0245IResult addSellers(@RequestBody SLIM0245IParam slim0245iParam) {
        BaseRestPaginationResult<SLIM0245IContactResult> restResult = this.slim0245iService.findContacts(slim0245iParam);
        SLIM0245IResult slim0245iResult = new SLIM0245IResult();
        slim0245iResult.setData(restResult.getData());
        slim0245iResult.setTotal(restResult.getTotal());
        slim0245iResult.setMessages(MessageUtils.getSuccessMessage());
        return slim0245iResult;
    }
}
