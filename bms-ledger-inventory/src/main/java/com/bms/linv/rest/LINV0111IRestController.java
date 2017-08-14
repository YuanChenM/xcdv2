package com.bms.linv.rest;

import com.bms.linv.bean.param.LINV0111IParam;
import com.bms.linv.bean.result.LINV0111IInvResult;
import com.bms.linv.services.InvmLotNoLoadService;
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
 * Created by zhang_jian4 on 2017/4/18.
 */
@RestController
@Api(description = "产品批次库存查询", tags = "LINV0111IRestController", value = "LINV0111IRestController", position = 5)
public class LINV0111IRestController extends BaseRestController {

    @Autowired
    private InvmLotNoLoadService lotNoLoadService;

    @ApiOperation(value = "产品批次库存查询", notes = "提供SKU、批次层次的产品库存汇总数量")
    @RequestMapping(value = "/linv/loadInv/lotInv/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<LINV0111IInvResult> search(@RequestBody LINV0111IParam param) {
        BaseRestPaginationResult<LINV0111IInvResult> basicRsResult = lotNoLoadService.findPageList(param);
        return basicRsResult;
    }
}
