package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0250IParam;
import com.bms.slim.bean.result.SLIM0250IResult;
import com.bms.slim.bean.result.field.SLIM0250IEntitySellerResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0250IService;
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
@Api(description = "查询卖方单位接口", tags = "SLIM0250IRestController")
public class SLIM0250IRestController extends BaseRestController {

    @Autowired
    private SLIM0250IService slim0250IService;

    @ApiOperation(value = "批量查询卖方单位",
            notes = "批量查询实体卖家、角色、卖家、卖家联系人，可分页查询；默认查询所有数据，包括已/未删除")
    @RequestMapping(value = "/sellers/entity/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0250IResult findSellerRoles(@RequestBody SLIM0250IParam slim0250IParam) {
        BaseRestPaginationResult<SLIM0250IEntitySellerResult> results = slim0250IService.findEntitySellers(slim0250IParam);
        SLIM0250IResult slim0250IResult = BeanUtils.toBean(results, SLIM0250IResult.class);
        slim0250IResult.setMessages(new String[]{MessageConstant.SUCCESS, "查询卖方单位成功"});
        return slim0250IResult;
    }

}
