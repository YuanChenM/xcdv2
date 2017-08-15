package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD1814IParam;
import com.bms.slpd.bean.result.SLPD1814IResult;
import com.bms.slpd.bean.result.field.SLPD1806IManufacturerProducerProductResult;
import com.bms.slpd.services.SLPD1814IService;
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
@Api(tags = "SLPD1814IRestController", description = "查询代理商未绑定的制造商产品生产商API（内部）")
public class SLPD1814IRestController extends BaseRestController {

    @Autowired
    private SLPD1814IService slpd1814IService;

    @ApiOperation(value = "查询代理商未绑定的制造商产品生产商",
            notes = "根据制造商实体entitySellerId，查询代理商未绑定的制造商产品生产商，可分页查询")
    @RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/producers/for/agent/supply/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD1814IResult findProducts(@RequestBody SLPD1814IParam slpd1814IParam) {
        BaseRestPaginationResult<SLPD1806IManufacturerProducerProductResult> restResult = slpd1814IService.findManufacturerProducts(slpd1814IParam);
        SLPD1814IResult slpd1814IResult = new SLPD1814IResult();
        slpd1814IResult.setTotal(restResult.getTotal());
        slpd1814IResult.setData(restResult.getData());
        slpd1814IResult.setMessages(MessageUtils.getSuccessMessage());
        return slpd1814IResult;
    }

}
