package com.bms.order.rest.externalCall;

import com.bms.order.archive.impl.externalCall.price.Price;
import com.bms.order.bean.externalCall.price.param.PriceListRestParam;
import com.bms.order.bean.externalCall.price.result.PriceListRestResult;
import com.framework.base.rest.RestResponse;
import com.framework.base.rest.SearchRestRequest;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhang_qiang1 on 2017/1/9.
 */

@RestController
@Api(tags = {"PriceRestController"}, description = "价盘查询")
public class PriceRestController  extends BaseRestController {

    @ApiOperation(value = "价盘查询", notes = "价盘查询")
    @RequestMapping(value = "/price/_find", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResponse<PriceListRestResult> execute(@RequestBody SearchRestRequest<PriceListRestParam> request) {
        RestResponse restResponse = new RestResponse();
        PriceListRestResult priceListRestResult = new Price().getPriceListRestResult(request.getFilter());
        restResponse.setResult(priceListRestResult);
        return restResponse;
    }


}
