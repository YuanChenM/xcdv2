package com.bms.bymt.rest;

import com.bms.bymt.bean.entity.BymtFoodMarketTarget;
import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.FoodMarketTargetRsParam;
import com.bms.bymt.bean.result.BasePageResult;
import com.bms.bymt.services.BymtFoodMarketTargetService;
import com.bms.bymt.validator.FoodMarketTargetAddValidator;
import com.bms.bymt.validator.FoodMarketTargetUpdateValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tao_zhifa on 2016/12/16.
 */
@RestController
@Api(value = "bms-bymt-api", description = "菜场目标买家汇总信息", position = 1, tags = "FoodMarketTargeRstController")
public class FoodMarketTargetRestController extends BaseRestController {

    @Autowired
    private BymtFoodMarketTargetService bymtFoodMarketTargetService;

    @ApiOperation(value = "菜场目标买家汇总新增", notes = "菜场目标买家汇总新增", position = 5)
    @RequestMapping(value = "/buyerMarket/foodModule/target/buyer/_add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = FoodMarketTargetAddValidator.class)
    public Integer addBuyerMarketFoodModule(@RequestBody List<FoodMarketTargetRsParam> rsParam) {
        int count;
        count = bymtFoodMarketTargetService.executeInsert(rsParam);
        return count;
    }


    @ApiOperation(value = "菜场目标买家汇总修改", notes = "菜场目标买家汇总修改", position = 5)
    @RequestMapping(value = "/buyerMarket/foodModule/target/buyer/_modify", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = FoodMarketTargetUpdateValidator.class)
    public Integer modifyBuyerMarketFoodModule(@RequestBody List<BaseBean<FoodMarketTargetRsParam, FoodMarketTargetRsParam>> raParam) {
        int count;
        count = bymtFoodMarketTargetService.executeModify(raParam);
        return count;
    }


    @ApiOperation(value = "菜场目标买家汇总查询", notes = "菜场目标买家汇总查询", position = 5)
    @RequestMapping(value = "/buyerMarket/foodModule/target/buyer/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BasePageResult<BymtFoodMarketTarget> searchBuyerMarketFoodModule(@RequestBody FoodMarketTargetRsParam param) {
        if (param != null) {
            if (!StringUtils.isEmpty(param.getBuyerName())) {

                param.setBuyerName(DbUtils.buildLikeCondition(param.getBuyerName(), DbUtils.LikeMode.PARTIAL));
            }
            if (!StringUtils.isEmpty(param.getProName())) {
                param.setProName(DbUtils.buildLikeCondition(param.getProName(), DbUtils.LikeMode.PARTIAL));
            }
        }
        BaseRestPaginationResult<BymtFoodMarketTarget> list = bymtFoodMarketTargetService.findPageList(param);

        FoodMarketTargetRsParam totalCount = bymtFoodMarketTargetService.findTotal(param);
        BasePageResult<BymtFoodMarketTarget> basePageResult = new BasePageResult<>();
        if (list != null && !CollectionUtils.isEmpty(list.getData())) {
            basePageResult.setData(list.getData());
            if(totalCount != null && totalCount.getTradeAmountAllCount() != null){
                basePageResult.setTradeAmountCount(totalCount.getTradeAmountAllCount());
            }
            if(totalCount != null && totalCount.getBuyerNumAllCount() != null){
                basePageResult.setBuyerNumCount(totalCount.getBuyerNumAllCount());
            }
            basePageResult.setTotal(list.getTotal());
        }
        return basePageResult;
    }
}
