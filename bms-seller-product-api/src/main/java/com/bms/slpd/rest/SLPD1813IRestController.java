package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD1813IParam;
import com.bms.slpd.bean.result.SLPD1813IResult;
import com.bms.slpd.bean.result.field.SLPD1805IProductProducerResult;
import com.bms.slpd.services.SLPD1813IService;
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
@Api(tags = "SLPD1813IRestController", description = "查询制造商未绑定的产品生产商API（内部）")
public class SLPD1813IRestController extends BaseRestController {

    @Autowired
    private SLPD1813IService slpd1813IService;

    @ApiOperation(value = "查询制造商未绑定的产品生产商",
            notes = "根据生产商实体entitySellerId，查询制造商未绑定的产品生产商，可分页查询；")
    @RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/producers/for/manufacturer/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD1813IResult findProducts(@RequestBody SLPD1813IParam slpd1813IParam) {
        BaseRestPaginationResult<SLPD1805IProductProducerResult> restResult = this.slpd1813IService.findProductProducers(slpd1813IParam);
        SLPD1813IResult slpd1813iResult = new SLPD1813IResult();
        slpd1813iResult.setTotal(restResult.getTotal());
        slpd1813iResult.setData(restResult.getData());
        slpd1813iResult.setMessages(MessageUtils.getSuccessMessage());
        return slpd1813iResult;
    }

}
