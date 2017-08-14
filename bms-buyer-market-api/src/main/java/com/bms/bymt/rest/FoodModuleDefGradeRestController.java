package com.bms.bymt.rest;

import com.bms.bymt.bean.param.FoodGradeInfoParam;
import com.bms.bymt.bean.param.FoodGradeResultParam;
import com.bms.bymt.bean.result.FoodGradeRsResult;
import com.bms.bymt.constant.MessageDef;
import com.bms.bymt.services.BymtFoodGradeInfoService;
import com.bms.bymt.services.BymtFoodGradeResultService;
import com.bms.bymt.validator.FoodGradeInfoAddValidator;
import com.bms.bymt.validator.FoodGradeInfoSearchValidator;
import com.bms.bymt.validator.FoodGradeResultAddValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.i18n.util.MessageManager;
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
 * Created by guan_zhongheng on 2016/12/16.
 */
@RestController
@Api(value = "bms-bymt-api",
        description = "菜场定性信息操作",
        position = 1,
        tags = "FoodModuleDefGradeRestController")
public class FoodModuleDefGradeRestController extends BaseRestController {

    Logger logger = LoggerFactory.getLogger(FoodModuleDefGradeRestController.class);

    @Autowired
    private BymtFoodGradeInfoService bymtFoodGradeInfoService; // 菜场定性详情

    @Autowired
    private BymtFoodGradeResultService bymtFoodGradeResultService; // 菜场定性结果

    @ApiOperation(value = "菜场定性详情查询",
            notes = "菜场定性详情查询")
    @RequestMapping(value = "/buyerMarket/foodModule/defineGrade/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = FoodGradeInfoSearchValidator.class)
    public FoodGradeRsResult searchBuyerMarketFoodDefineGrade(@RequestBody FoodGradeInfoParam paramRequest) {
        FoodGradeRsResult result;
        result = this.bymtFoodGradeInfoService.findBuyerMarketFoodDefineGrade(paramRequest);
        return result;
    }

    @ApiOperation(value = "addFoodGradeInfo",
            notes = "菜场定性详情信息新增")
    @RequestMapping(value = "/buyerMarket/foodModule/defineGrade/details/_add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = FoodGradeInfoAddValidator.class)
    public Long addFoodGradeInfo(@RequestBody FoodGradeInfoParam foodGradeInfoParam) {
        logger.info("菜场定性详情信息新增调用");
        String message = "";
        String[] args = new String[]{MessageManager.getMessage(MessageDef.Label.L00004)};
        FoodGradeInfoParam reqParam;
        reqParam = foodGradeInfoParam;
        // 批发市场定性定级原由其特殊性 只存在新增所以 先删除后新增
        long gradeInfoId;
        gradeInfoId = bymtFoodGradeInfoService.addFoodGradeInfo(reqParam);
        if (gradeInfoId > 0) {
            // 成功
            message = MessageManager.getMessage(MessageDef.Info.I00002, args);
        } else if (message.isEmpty()) {
            // 失败
            message = MessageManager.getMessage(MessageDef.Error.E00003, args);
        }
        logger.info("菜场定性结果调用结果:" + message);
        return gradeInfoId;
    }

    @ApiOperation(value = "addFoodGradeResult",
            notes = "菜场定性结果信息新增")
    @RequestMapping(value = "/buyerMarket/foodModule/defineGrade/result/_add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = FoodGradeResultAddValidator.class)
    public Long addFoodGradeResult(@RequestBody FoodGradeResultParam foodGradeResultParam) {
        logger.info("菜场定性结果信息新增调用");
        FoodGradeResultParam reqParam;
        reqParam = foodGradeResultParam;
        // 批发市场定性定级原由其特殊性 只存在新增所以 先删除后新增
        String[] args = new String[]{MessageManager.getMessage(MessageDef.Label.L00004)};
        String message = "";
        long gradeResultId = bymtFoodGradeResultService.addFoodGradeResult(reqParam);
        if (gradeResultId > 0) {
            // 成功
            message = MessageManager.getMessage(MessageDef.Info.I00002, args);
        } else if (message.isEmpty()) {
            // 失败
            message = MessageManager.getMessage(MessageDef.Error.E00003, args);
        }
        logger.info("菜场定性结果调用结果:" + message);

        return gradeResultId;
    }
}
