package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD1901IParam;
import com.bms.slpd.bean.result.SLPD1901IResult;
import com.bms.slpd.bean.result.wrapper.SLPD1901INetWeightResult;
import com.bms.slpd.services.SLPD1901IService;
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
@Api(tags = "SLPD1901IRestController", description = "批量查询净重列表API")
public class SLPD1901IRestController extends BaseRestController {

    @Autowired
    private SLPD1901IService slpd1901IService;

    @ApiOperation(value = "批量查询净重列表URL",
            notes = "根据单品Id集合,净重编码集合,净重查询对应的净重列表")
    @RequestMapping(value = "/classes/machinings/breeds/items/nets/weights/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD1901IResult findItems(@RequestBody SLPD1901IParam slpd1901IParam) {
        BaseRestPaginationResult<SLPD1901INetWeightResult> restResult = this.slpd1901IService.findNetWeights(slpd1901IParam);
        SLPD1901IResult slpd1901IResult = new SLPD1901IResult();
        slpd1901IResult.setTotal(restResult.getTotal());
        slpd1901IResult.setData(restResult.getData());
        slpd1901IResult.setMessages(MessageUtils.getSuccessMessage());
        return slpd1901IResult;
    }

}
