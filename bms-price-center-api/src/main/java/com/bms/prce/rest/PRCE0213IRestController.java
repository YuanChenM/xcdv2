package com.bms.prce.rest;

import com.bms.prce.bean.param.PRCE0213IParam;
import com.bms.prce.bean.result.PRCE0213IResult;
import com.bms.prce.service.PrcePricePlateService;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(description = "价盘信息查询",
        tags = "PRCE0213IRestController", value = "PRCE0213I", position = 0)
public class PRCE0213IRestController extends BaseRestController {

    @Autowired
    private PrcePricePlateService prcePricePlateService;

    /**
     * 价盘信息查询
     * @Param prce0207IParam
     * @return  修改结果
     *
     */
    @ApiOperation(value = "价盘信息查询", notes = "价盘信息查询")
    @RequestMapping(value = "/prce/pricePlateInfoList/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PRCE0213IResult> searchPriceList(@RequestBody PRCE0213IParam param) {
        param.setLgcsAreaName(DbUtils.buildLikeCondition(param.getLgcsAreaName()));
        param.setClassesName(DbUtils.buildLikeCondition(param.getClassesName()));
        param.setMachiningName(DbUtils.buildLikeCondition(param.getMachiningName()));
        param.setBrandName(DbUtils.buildLikeCondition(param.getBrandName()));
        param.setBreedSalesName(DbUtils.buildLikeCondition(param.getBreedSalesName()));
        param.setPackageSpecification(DbUtils.buildLikeCondition(param.getPackageSpecification()));
        param.setSaleStatusName(DbUtils.buildLikeCondition(param.getSaleStatusName()));
        List<PRCE0213IResult> results = prcePricePlateService.findPrcePricePlateList(param);
        return results;
    }
}
