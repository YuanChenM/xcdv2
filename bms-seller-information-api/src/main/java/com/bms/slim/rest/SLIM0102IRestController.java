package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0102IParam;
import com.bms.slim.bean.result.SLIM0102IResult;
import com.bms.slim.bean.result.field.SLIM0102IEntitySellerResult;
import com.bms.slim.services.SLIM0102IService;
import com.bms.slim.utils.MessageUtils;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "SLIM0102IController", description = "批量查询卖家API")
@RestController
public class SLIM0102IRestController extends BaseRestController {

    @Autowired
    private SLIM0102IService slim0102iService;

    @ApiOperation(value = "批量查询卖家URL",
            notes = "批量查询实体卖家、卖家联系人，可分页查询；默认查询所有数据，包括已/未删除")
    @RequestMapping(value = "/sellers/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0102IResult findEntitySellers(@RequestBody SLIM0102IParam slim0102iParam) {
        BaseRestPaginationResult<SLIM0102IEntitySellerResult> restResult = this.slim0102iService.findEntitySellers(slim0102iParam);
        SLIM0102IResult slim0102iResult = BeanUtils.toBean(restResult, SLIM0102IResult.class);
        slim0102iResult.setMessages(MessageUtils.getSuccessMessage());
        return slim0102iResult;
    }

}
