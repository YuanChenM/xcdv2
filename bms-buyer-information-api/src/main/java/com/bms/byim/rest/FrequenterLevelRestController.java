package com.bms.byim.rest;

import com.bms.byim.bean.param.BuyerAccountRsParam;
import com.bms.byim.bean.param.FrequenterLevelRsParam;
import com.bms.byim.services.ByimBuyerService;
import com.bms.byim.services.ByimFrequenterLevelService;
import com.bms.byim.validator.FrequenterLevelAddValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yuan_zhifei on 2016/3/21.
 */
@RestController
@Api(value = "bms-byim-api",
        description = "常客买家定级信息",
        position = 1,
        tags = "FrequenterLevelRestController")
public class FrequenterLevelRestController extends BaseRestController {
    @Autowired
    private ByimFrequenterLevelService frequenterLevelService;
    @Autowired
    private ByimBuyerService byimBuyerService;

    @ApiOperation(value = "常客买家定级信息新增", notes = "常客买家定级信息新增", position = 1)
    @RequestMapping(value = "/buyers/frequenterLevel/_add", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = FrequenterLevelAddValidator.class)
    public Integer addFrequenterLevel(@RequestBody FrequenterLevelRsParam levelRsParam) {
        return this.frequenterLevelService.saveFrequenterLevel(levelRsParam);
    }

    @ApiOperation(value = "常客买家定级信息查询", notes = "常客买家定级信息查询", position = 2)
    @RequestMapping(value = "/buyers/frequenterLevel/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<FrequenterLevelRsParam> search(@RequestBody FrequenterLevelRsParam levelRsParam) {
        levelRsParam.setFrequenterLevelF(DbUtils.buildLikeCondition(levelRsParam.getFrequenterLevelF(), DbUtils.LikeMode.PARTIAL));
        levelRsParam.setFrequenterLevelA(DbUtils.buildLikeCondition(levelRsParam.getFrequenterLevelA(), DbUtils.LikeMode.PARTIAL));
        if (StringUtils.isEmpty(levelRsParam.getBuyerId()) && StringUtils.isNotEmpty(levelRsParam.getBuyerCode())) {
            //通过买家编码查询买家ID
            BuyerAccountRsParam accountRsParam = new BuyerAccountRsParam();
            accountRsParam.setBuyerCode(levelRsParam.getBuyerCode());
            String buyerId = byimBuyerService.findBuyerId(accountRsParam);
            levelRsParam.setBuyerId(buyerId);
        }
        return this.frequenterLevelService.findPageList(levelRsParam);
    }
}
