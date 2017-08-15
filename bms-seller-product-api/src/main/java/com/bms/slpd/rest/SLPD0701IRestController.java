package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0701IParam;
import com.bms.slpd.bean.result.SLPD0701IResult;
import com.bms.slpd.bean.result.field.SLPD0701IProducerProductResult;
import com.bms.slpd.services.SLPD0701IService;
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
@Api(tags = "SLPD0701IRestController", description = "批量查询单品品牌(规格)生产商API")
public class SLPD0701IRestController extends BaseRestController {

    @Autowired
    private SLPD0701IService slpd0701IService;

    @ApiOperation(value = "批量查询单品品牌(规格)生产商URL",
            notes = "批量查询单品品牌(规格)生产商")
    @RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/products/producers/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0701IResult findProducerProducts(@RequestBody SLPD0701IParam slpd0701IParam) {
        BaseRestPaginationResult<SLPD0701IProducerProductResult> restResult = this.slpd0701IService.findProducerProducts(slpd0701IParam);
        SLPD0701IResult slpd0701IResult = new SLPD0701IResult();
        slpd0701IResult.setTotal(restResult.getTotal());
        slpd0701IResult.setData(restResult.getData());
        slpd0701IResult.setMessages(MessageUtils.getSuccessMessage());
        return slpd0701IResult;
    }

}
