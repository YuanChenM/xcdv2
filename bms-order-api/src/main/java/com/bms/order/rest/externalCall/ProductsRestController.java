package com.bms.order.rest.externalCall;

import com.bms.order.archive.impl.externalCall.products.Products;
import com.bms.order.bean.externalCall.products.param.ManufacturerRestParam;
import com.bms.order.bean.externalCall.products.param.ProductsRestParam;
import com.bms.order.bean.externalCall.products.param.SellerRestParam;
import com.bms.order.bean.externalCall.products.result.ManufacturerRestResult;
import com.bms.order.bean.externalCall.products.result.ProductsRestResult;
import com.bms.order.bean.externalCall.products.result.SellerRestResult;
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
@Api(tags = {"ProductsRestController"}, description = "商品查询")
public class ProductsRestController extends BaseRestController {

    @ApiOperation(value = "商品查询", notes = "商品查询")
    @RequestMapping(value = "/products/_find", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResponse<ProductsRestResult> execute(@RequestBody SearchRestRequest<ProductsRestParam> request) {
        RestResponse restResponse = new RestResponse();
        ProductsRestResult restResult = new Products().getFindProductsByGoodsIds(request.getFilter());
        restResponse.setResult(restResult);
        return restResponse;
    }


    @ApiOperation(value = "生产商查询", notes = "生产商查询")
    @RequestMapping(value = "/manufacture/_find", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResponse<ManufacturerRestResult> execute2(@RequestBody SearchRestRequest<ManufacturerRestParam> request) {
        RestResponse restResponse = new RestResponse();
        ManufacturerRestResult restResult = new Products().getFindManufactures(request.getFilter());
        restResponse.setResult(restResult);
        return restResponse;
    }

    @ApiOperation(value = "卖家查询", notes = "卖家查询")
    @RequestMapping(value = "/seller/_find", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResponse<SellerRestResult> execute3(@RequestBody SearchRestRequest<SellerRestParam> request) {
        RestResponse restResponse = new RestResponse();
        SellerRestResult restResult = new Products().getFindSellers(request.getFilter());
        restResponse.setResult(restResult);
        return restResponse;
    }

}
