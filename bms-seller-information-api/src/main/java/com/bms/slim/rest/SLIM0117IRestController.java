package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0117IParam;
import com.bms.slim.bean.result.SLIM0117IResult;
import com.bms.slim.bean.result.field.SLIM0117ISellerContractPermissionResult;
import com.bms.slim.services.SLIM0117IService;
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

@Api(tags = "SLIM0117IRestController", description = "批量查询卖家合同信息准入API")
@RestController
public class SLIM0117IRestController extends BaseRestController {

    @Autowired
    private SLIM0117IService slim0117iService;

    @ApiOperation(value = "批量查询卖家合同信息准入",
            notes = "批量查询卖家合同信息")
    @RequestMapping(value = "/sellers/contacts/permissions/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0117IResult addSellers(@RequestBody SLIM0117IParam slim0117iParam) {
        BaseRestPaginationResult<SLIM0117ISellerContractPermissionResult> restResult = this.slim0117iService.findSCPs(slim0117iParam);
        SLIM0117IResult slim0117iResult = new SLIM0117IResult();
        slim0117iResult.setData(restResult.getData());
        slim0117iResult.setTotal(restResult.getTotal());
        slim0117iResult.setMessages(MessageUtils.getSuccessMessage());
        return slim0117iResult;
    }
}
