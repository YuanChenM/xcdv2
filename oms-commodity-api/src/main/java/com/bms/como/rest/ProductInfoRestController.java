package com.bms.como.rest;

import com.bms.como.bean.entity.ComoProductInfo;
import com.bms.como.bean.param.BaseBean;
import com.bms.como.bean.param.ProductInfoCreateRsParam;
import com.bms.como.bean.param.ProductInfoRsParam;
import com.bms.como.bean.result.ComoProductInfoResult;
import com.bms.como.bean.result.ProductInfoResult;
import com.bms.como.service.ComoProductInfoService;
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
 * Created by wang_haichun on 2017/3/28.
 */
@RestController
@Api(value = "bms-commodity-api", description = "产品信息", tags = "ProductInfoRestController")
public class ProductInfoRestController extends BaseRestController {
    @Autowired
    private ComoProductInfoService comoProductInfoService;


    @ApiOperation(value = "查询产品信息接口", notes = "查询产品信息接口", position = 1)
    @RequestMapping(value = "/product/info/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<ProductInfoResult> searchProductInfo(@RequestBody ProductInfoRsParam productInfoRsPara) {
       return comoProductInfoService.searchProductInfo(productInfoRsPara);
    }


    @ApiOperation(value = "新增产品信息接口", notes = "新增产品信息接口", position = 2)
    @RequestMapping(value = "/product/info/_create", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ComoProductInfoResult createProductInfo(@RequestBody ProductInfoCreateRsParam productInfoCreateRsParam) {
        return comoProductInfoService.createProductInfo(productInfoCreateRsParam);
    }


    @ApiOperation(value = "修改产品信息接口", notes = "修改产品信息接口", position = 3)
    @RequestMapping(value = "/product/info/_modify", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ComoProductInfoResult modifyProductInfo(@RequestBody BaseBean<ComoProductInfo, ComoProductInfo> comoProductInfo) {
        return comoProductInfoService.modityProductInfo(comoProductInfo);
    }

}
