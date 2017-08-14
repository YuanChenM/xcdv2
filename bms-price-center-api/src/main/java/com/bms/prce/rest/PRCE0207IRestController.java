package com.bms.prce.rest;

import com.bms.prce.bean.param.PRCE0207IParam;
import com.bms.prce.bean.param.PRCE0208IParam;
import com.bms.prce.bean.result.PRCE0207IResult;
import com.bms.prce.bean.result.PRCE0208IResult;
import com.bms.prce.service.PrcePricePlateService;
import com.bms.prce.validator.PRCE0208IValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * 价盘一览查询
 *
 * @author zhou_ling
 * @version 1.0
 *
 */
@RestController
@Api(description = "价盘一览查询",
        tags = "PRCE0207IRestController", value = "PRCE0207I", position = 0)
public class PRCE0207IRestController extends BaseRestController {

    /** 价盘一览 */
    @Autowired
    private PrcePricePlateService prcePricePlateService;

    /**
     * 价盘一览查询
     * @Param prce0204IParam
     * @return  修改结果
     *
     */
    @ApiOperation(value = "价盘一览查询", notes = "价盘一览查询")
    @RequestMapping(value = "/prce/pricePlateList/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<PRCE0207IResult> searchPriceList(@RequestBody PRCE0207IParam param) {
        param.setLgcsAreaName(DbUtils.buildLikeCondition(param.getLgcsAreaName()));
        param.setClassesName(DbUtils.buildLikeCondition(param.getClassesName()));
        param.setMachiningName(DbUtils.buildLikeCondition(param.getMachiningName()));
        param.setBrandName(DbUtils.buildLikeCondition(param.getBrandName()));
        param.setBreedSalesName(DbUtils.buildLikeCondition(param.getBreedSalesName()));
        param.setPackageSpecification(DbUtils.buildLikeCondition(param.getPackageSpecification()));
        param.setSaleStatusName(DbUtils.buildLikeCondition(param.getSaleStatusName()));
        param.setCommodityCode(DbUtils.buildLikeCondition(param.getCommodityCode()));
        param.setItemName(DbUtils.buildLikeCondition(param.getItemName()));
        BaseRestPaginationResult<PRCE0207IResult> results = prcePricePlateService.findPageList(param);
        return results;
    }
}
