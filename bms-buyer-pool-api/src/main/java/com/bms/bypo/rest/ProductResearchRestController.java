package com.bms.bypo.rest;

import com.bms.bypo.bean.entity.BypoProductResearch;
import com.bms.bypo.bean.param.BaseBean;
import com.bms.bypo.bean.param.ProductResearchRsParam;
import com.bms.bypo.services.BypoProductResearchService;
import com.bms.bypo.validator.ProductResearchAddValidator;
import com.bms.bypo.validator.ProductResearchModifyValidator;
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
 * Created by zhang_jian4 on 2017/01/05.
 */
@RestController
@Api(value = "bms-bypo-api",
        description = "买家产品销售调研产品信息",
        position = 1,
        tags = "ProductResearchRestController")
public class ProductResearchRestController extends BaseRestController {
    Logger logger = LoggerFactory.getLogger(ProductResearchRestController.class);
    @Autowired
    private BypoProductResearchService productResearchService;

    @ApiOperation(value = "买家产品销售调研产品信息查询", notes = "买家产品销售调研产品信息查询")
    @RequestMapping(value = "/buyerPool/research/products/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<ProductResearchRsParam> searchStandardProduct(@RequestBody ProductResearchRsParam paramRequest){
        BaseRestPaginationResult<ProductResearchRsParam>  pageList = this.productResearchService.findPageList(paramRequest);
        return pageList;
    }


    @ApiOperation(value = "买家产品销售调研产品信息新增", notes = "买家产品销售调研产品信息新增")
    @RequestMapping(value = "/buyerPool/research/products/_add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ProductResearchAddValidator.class)
    public Integer  addStandardProduct(@RequestBody ProductResearchRsParam paramRequest) {

        BypoProductResearch productResearch =BeanUtils.toBean(paramRequest, BypoProductResearch.class);
        Long researchProductId = this.productResearchService.maxId("BYPO_PRODUCT_RESEARCH");
        productResearch.setResearchProductId(researchProductId);
        productResearch.setDelFlg(false);
        productResearch.setUpdId(productResearchService.getLoginUserId());
        productResearch.setUpdTime(DateUtils.getCurrent());
        productResearch.setCrtId(productResearchService.getLoginUserId());
        productResearch.setCrtTime(DateUtils.getCurrent());
        productResearch.setVersion(NumberConst.IntDef.INT_ONE);
        logger.info("买家产品销售调研产品信息新增开始");
        Integer count = this.productResearchService.save(productResearch);
        return count;
    }

    @ApiOperation(value = "买家产品销售调研产品信息修改", notes = "买家产品销售调研产品信息修改")
    @RequestMapping(value = "/buyerPool/research/products/_update",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ProductResearchModifyValidator.class)
    public Integer modifyProductResearch(@RequestBody BaseBean<ProductResearchRsParam, ProductResearchRsParam> paramRequest) {
        ProductResearchRsParam productResearchRsParamFilter = paramRequest.getFilter();
        ProductResearchRsParam productResearchRsParamTarget = paramRequest.getTarget();
        BypoProductResearch productResearchFilter = BeanUtils.toBean(productResearchRsParamFilter, BypoProductResearch.class);
        BypoProductResearch productResearchTarget = BeanUtils.toBean(productResearchRsParamTarget, BypoProductResearch.class);
        // 判断是否存在(更新、逻辑删除不需要)
        BaseBean<BypoProductResearch, BypoProductResearch> bypoProductResearchBaseBean = new BaseBean<>();
        Date currentDate = DateUtils.getCurrent();
        productResearchTarget.setUpdId(productResearchService.getLoginUserId());
        productResearchTarget.setUpdTime(currentDate);
        bypoProductResearchBaseBean.setFilter(productResearchFilter);
        bypoProductResearchBaseBean.setTarget(productResearchTarget);
        logger.info("买家产品销售调研产品信息修改开始");
        int result = this.productResearchService.modify(bypoProductResearchBaseBean);
        return result;
    }
}
