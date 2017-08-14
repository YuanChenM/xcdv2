package com.bms.linv.rest;

import com.bms.linv.bean.param.LINV0114IParam;
import com.bms.linv.bean.result.LINV0114IResult;
import com.bms.linv.services.InvmWhInfoService;
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

/**
 * 仓库信息查询接口
 * Created by zhang_jian4 on 2017/4/17.
 */
@RestController
@Api(description = "仓库信息查询",
    tags = "LINV0114IRestController",
    value = "LINV0114IRestController",
    position = 0)
public class LINV0114IRestController extends BaseRestController {

    @Autowired
    private InvmWhInfoService whInfoService;

    @ApiOperation(value = "仓库信息查询",
        notes = "仓库信息查询")
    @RequestMapping(value = "/linv/wh/_search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseRestPaginationResult<LINV0114IResult> searchWhInfo(@RequestBody LINV0114IParam linv0114IParam) {
        return whInfoService.findWhInfo(linv0114IParam);
    }

}
