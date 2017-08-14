package com.bms.bymt.rest;

import com.bms.bymt.bean.param.TermGradeInfoParam;
import com.bms.bymt.bean.param.TermGradeResultParam;
import com.bms.bymt.bean.result.TerminalModuleDefGradeResult;
import com.bms.bymt.services.BymtTermGradeInfoService;
import com.bms.bymt.services.BymtTermGradeResultService;
import com.bms.bymt.validator.TermGradeInfoAddValidator;
import com.bms.bymt.validator.TermGradeInfoSearchValidator;
import com.bms.bymt.validator.TermGradeResultAddValidator;
import com.framework.boot.base.BaseRestController;
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

/**
 * Created by guan_zhongheng on 2016/12/15.
 */
@RestController
@Api(value = "bms-bymt-api",
        description = "批发定性定级信息操作",
        position = 1,
        tags = "TerminalModuleDefGradeRestController")
public class TerminalModuleDefGradeRestController extends BaseRestController {

    Logger logger = LoggerFactory.getLogger(TerminalModuleDefGradeRestController.class);

    @Autowired
    private BymtTermGradeInfoService bymtTermGradeInfoService; // 批发市场详情

    @Autowired
    private BymtTermGradeResultService bymtTermGradeResultService; // 批发市场结果

    @ApiOperation(value = "批发市场定性定级详情结果查询",
            notes = "批发市场定性定级详情结果查询")
    @RequestMapping(value = "/buyerMarket/terminalModule/defineGrade/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = TermGradeInfoSearchValidator.class)
    public TerminalModuleDefGradeResult searchBuyerMarketTerminalDefineGrade(@RequestBody TermGradeInfoParam paramRequest) {
        return bymtTermGradeInfoService.findBuyerMarketTerminalDefineGrade(paramRequest);
    }


    @ApiOperation(value = "termGradeInfoParam",
            notes = "批发定性定级详情信息新增")
    @RequestMapping(value = "/buyerMarket/terminalModule/defineGrade/details/_add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = TermGradeInfoAddValidator.class)
    public Long addTermGradeInfo(@RequestBody TermGradeInfoParam termGradeInfoParam) {
        // 批发市场定性定级原由其特殊性 只存在新增所以 先删除后新增
        long result = bymtTermGradeInfoService.addTermGradeInfo(termGradeInfoParam);
        return result;
    }

    @ApiOperation(value = "termGradeResultParam",
            notes = "批发定性定级结果信息新增")
    @RequestMapping(value = "/buyerMarket/terminalModule/defineGrade/result/_add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = TermGradeResultAddValidator.class)
    public Long addTermGradeResult(@RequestBody TermGradeResultParam termGradeResultParam) {
        long result = bymtTermGradeResultService.addTermGradeResult(termGradeResultParam);
        return result;
    }

}
