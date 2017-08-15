package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0301IParam;
import com.bms.slpd.bean.result.SLPD0301IResult;
import com.bms.slpd.bean.result.field.SLPD0301IItemResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.services.SLPD0301IService;
import com.bms.slpd.utils.MessageUtils;
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


@RestController
@Api(tags = "SLPD0301IRestController", description = "批量查询单品API")
public class SLPD0301IRestController extends BaseRestController {

    @Autowired
    private SLPD0301IService slpd0301IService;

    @ApiOperation(value = "批量查询单品URL",
            notes = "批量查询单品")
    @RequestMapping(value = "/classes/machinings/breeds/items/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0301IResult findItems(@RequestBody SLPD0301IParam slpd0301IParam) {
        BaseRestPaginationResult<SLPD0301IItemResult> restResult = this.slpd0301IService.findItems(slpd0301IParam);
        SLPD0301IResult slpd0301IResult = new SLPD0301IResult();
        slpd0301IResult.setTotal(restResult.getTotal());
        slpd0301IResult.setData(restResult.getData());
        slpd0301IResult.setMessages(MessageUtils.getSuccessMessage());
        return slpd0301IResult;
    }

}
