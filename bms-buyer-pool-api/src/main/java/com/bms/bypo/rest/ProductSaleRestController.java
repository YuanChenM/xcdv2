package com.bms.bypo.rest;

import com.bms.bypo.bean.entity.BypoProductSale;
import com.bms.bypo.bean.param.BaseBean;
import com.bms.bypo.bean.param.ProductSaleRsParam;
import com.bms.bypo.services.BypoProductSaleService;
import com.bms.bypo.validator.ProductSaleAddValidator;
import com.bms.bypo.validator.ProductSaleModifyValidator;
import com.bms.bypo.validator.ProductSaleSearchValidator;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.validator.annotation.Validator;
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

import java.util.Date;

/**
 * Created by zhang_jian4 on 2017/01/06.
 */
@RestController
@Api(value = "bms-bypo-api",
        description = "产品销售信息",
        position = 1,
        tags = "ProductSaleRestController")
public class ProductSaleRestController extends BaseRestController {
    Logger logger = LoggerFactory.getLogger(ProductSaleRestController.class);
    @Autowired
    private BypoProductSaleService productSaleService;

    @ApiOperation(value = "产品销售信息查询", notes = "产品销售信息查询")
    @RequestMapping(value = "/buyerPool/research/products/sale/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ProductSaleSearchValidator.class)
    public BaseRestPaginationResult<ProductSaleRsParam> searchSaleProduct(@RequestBody ProductSaleRsParam paramRequest) {
        logger.info("产品销售信息查询开始");
        BaseRestPaginationResult<ProductSaleRsParam> response = this.productSaleService.findPageList(paramRequest);
        return response;
    }


    @ApiOperation(value = "产品销售信息新增", notes = "产品销售信息新增")
    @RequestMapping(value = "/buyerPool/research/products/sale/_add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ProductSaleAddValidator.class)
    public Integer addStandardProduct(@RequestBody ProductSaleRsParam paramRequest) {
        logger.info("产品销售信息新增");
        Date currentDate = DateUtils.getCurrent();
        BypoProductSale productSale = BeanUtils.toBean(paramRequest, BypoProductSale.class);
        Long productSaleId = this.productSaleService.maxId("BYPO_PRODUCT_SALE");
        productSale.setProductSaleId(productSaleId);
        productSale.setDelFlg(false);
        productSale.setUpdId(productSaleService.getLoginUserId());
        productSale.setUpdTime(currentDate);
        productSale.setCrtId(productSaleService.getLoginUserId());
        productSale.setCrtTime(currentDate);
        productSale.setVersion(NumberConst.IntDef.INT_ONE);
        logger.info("产品销售信息新增开始");
        int result = this.productSaleService.save(productSale);
        return result;
    }

    @ApiOperation(value = "产品销售信息修改", notes = "产品销售信息修改")
    @RequestMapping(value = "/buyerPool/research/products/sale/_update",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ProductSaleModifyValidator.class)
    public Integer modifyProductSale(@RequestBody BaseBean<ProductSaleRsParam, ProductSaleRsParam> paramRequest) {
        ProductSaleRsParam productSaleRsParamFilter = paramRequest.getFilter();
        ProductSaleRsParam productSaleRsParamTarget = paramRequest.getTarget();

        BypoProductSale productSaleFilter = BeanUtils.toBean(productSaleRsParamFilter, BypoProductSale.class);
        BypoProductSale productSaleTarget = BeanUtils.toBean(productSaleRsParamTarget, BypoProductSale.class);
        // 判断是否存在(更新、逻辑删除不需要)

        BaseBean<BypoProductSale, BypoProductSale> bypoProductSaleBaseBean = new BaseBean<>();
        Date currentDate = DateUtils.getCurrent();
        productSaleTarget.setUpdId(productSaleService.getLoginUserId());
        productSaleTarget.setUpdTime(currentDate);
        bypoProductSaleBaseBean.setFilter(productSaleFilter);
        bypoProductSaleBaseBean.setTarget(productSaleTarget);
        logger.info("产品销售信息修改开始");
        int result = this.productSaleService.modify(bypoProductSaleBaseBean);
        return result;
    }
}
