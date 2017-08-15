package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0248IParam;
import com.bms.slim.bean.result.SLIM0248IResult;
import com.bms.slim.bean.result.field.SLIM0248SellerRoleResult;
import com.bms.slim.bean.result.wrapper.SlimProducerResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0248IService;
import com.framework.base.consts.NumberConst;
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
@Api(description = "查询卖方单位角色接口", tags = "SLIM0248IRestController")
public class SLIM0248IRestController extends BaseRestController {

    @Autowired
    private SLIM0248IService slim0248IService;

    @ApiOperation(value = "批量查询卖方单位角色",
            notes = "根据sellerRoleIds,entitySellerIds,roleIds,roleName,delFlg查询对应的卖方单位角色信息")
    @RequestMapping(value = "/sellers/roles/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0248IResult findSellerRoles(@RequestBody SLIM0248IParam slim0248IParam) {
        BaseRestPaginationResult<SLIM0248SellerRoleResult> results = slim0248IService.findSellerRoles(slim0248IParam);
        SLIM0248IResult slim0248IResult = BeanUtils.toBean(results, SLIM0248IResult.class);
        slim0248IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询卖方单位角色成功"});
        return slim0248IResult;
    }
}
