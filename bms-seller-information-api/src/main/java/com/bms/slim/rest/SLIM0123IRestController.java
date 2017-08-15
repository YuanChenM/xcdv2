package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0123IParam;
import com.bms.slim.bean.result.SLIM0123IResult;
import com.bms.slim.bean.result.field.SLIM0123SellerResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0123IService;
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

@RestController
@Api(description = "查询卖家角色接口", tags = "SLIM0123IRestController")
public class SLIM0123IRestController extends BaseRestController {

    @Autowired
    private SLIM0123IService slim0123IService;

    @ApiOperation(value = "查询卖家角色",
            notes = "根据entitySellerIds,delFlg查询对应的卖家角色信息")
    @RequestMapping(value = "/sellers/role/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0123IResult findSellers(@RequestBody SLIM0123IParam slim0123IParam) {
        BaseRestPaginationResult<SLIM0123SellerResult> results = slim0123IService.findSellers(slim0123IParam);
        SLIM0123IResult slim0123IResult = BeanUtils.toBean(results, SLIM0123IResult.class);
        slim0123IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询卖家角色成功"});
        return slim0123IResult;
    }
}
