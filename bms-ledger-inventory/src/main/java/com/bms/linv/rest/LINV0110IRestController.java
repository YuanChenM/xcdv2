package com.bms.linv.rest;

import com.bms.linv.bean.param.LINV0110IParam;
import com.bms.linv.bean.result.LINV0110IInvResult;
import com.bms.linv.services.InvmLoadService;
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
 * Created by guan_zhongheng on 2017/4/17.
 */
@RestController
@Api(description = "产品库存查询", tags = "LINV0110IRestController", value = "LINV0110IRestController", position = 5)
public class LINV0110IRestController extends BaseRestController{

    @Autowired
    private InvmLoadService invmLoadService;

    @ApiOperation(value = "产品库存查询", notes = "提供SKU层次的产品库存汇总数量")
    @RequestMapping(value = "/linv/loadInv/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<LINV0110IInvResult> search(@RequestBody LINV0110IParam param) {
        BaseRestPaginationResult<LINV0110IInvResult> basicRsResult = invmLoadService.findPageList(param);
        return basicRsResult;
    }
}
