package com.bms.bypo.rest;

import com.bms.bypo.bean.param.BaseBean;
import com.bms.bypo.bean.param.ProductSaleResearchRsParam;
import com.bms.bypo.services.BypoProductSaleResearchService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhang_jian4 on 2016/12/21.
 */
@RestController
@Api(value = "bms-bypo-api",
        description = "买家产品销售调研信息表",
        position = 1,
        tags = "ProductSaleResarchRestController")
public class ProductSaleResarchRestController extends BaseRestController {
    Logger logger = LoggerFactory.getLogger(ProductSaleResarchRestController.class);
    @Autowired
    private BypoProductSaleResearchService productSaleResearchService;

    @ApiOperation(value = "买家产品销售调研信息查询", notes = "买家产品销售调研信息查询")
    @RequestMapping(value = "/buyerPool/research/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<ProductSaleResearchRsParam> searchProductSaleResearch(@RequestBody ProductSaleResearchRsParam param){
        BaseRestPaginationResult<ProductSaleResearchRsParam> result;
        logger.info("买家产品销售调研信息查询开始");
        result = productSaleResearchService.findPageList(param);
        return result;
    }

    @ApiOperation(value = "买家产品销售调研信息新增", notes = "买家产品销售调研信息新增")
    @RequestMapping(value = "/buyerPool/research/_add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    //@Validator(validatorClass = ProductSaleResearchAddValidator.class)
    public int addProductSaleResearch(@RequestBody ProductSaleResearchRsParam param){
        return productSaleResearchService.insert(param);
    }
    @ApiOperation(value = "买家产品销售调研信息修改", notes = "买家产品销售调研信息修改")
    @RequestMapping(value = "/buyerPool/research/_update",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
   // @Validator(validatorClass = ProductSaleResearchModifyValidator.class)
    public Integer modifyProductSaleResearch(@RequestBody BaseBean<ProductSaleResearchRsParam, ProductSaleResearchRsParam> param) {
        logger.info("编辑开始");
        return  productSaleResearchService.update(param);
    }
}
