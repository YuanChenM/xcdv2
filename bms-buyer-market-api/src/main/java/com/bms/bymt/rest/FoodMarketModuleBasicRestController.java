package com.bms.bymt.rest;

import com.alibaba.fastjson.TypeReference;
import com.bms.bymt.bean.entity.BymtFoodMarketBasic;
import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.MarketFoodModuleBasicRsParam;
import com.bms.bymt.bean.param.StoreRsParam;
import com.bms.bymt.constant.ApiUrlDef;
import com.bms.bymt.constant.MessageDef;
import com.bms.bymt.services.BymtFoodMarketBasicService;
import com.bms.bymt.validator.FoodMarketModuleBasicAddValidator;
import com.bms.bymt.validator.FoodMarketModuleBasicSearchValidator;
import com.bms.bymt.validator.FoodMarketModuleBasicUpdateValidator;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao_chen on 2016/12/14.
 */
@RestController
@Api(value = "bms-bymt-api", description = "菜场基础信息", position = 1, tags = "MarketFoodModuleBasicRestController")
public class FoodMarketModuleBasicRestController extends BaseRestController {

    Logger logger = LoggerFactory.getLogger(FoodMarketModuleBasicRestController.class);

    @Autowired
    private BymtFoodMarketBasicService bymtFoodMarketBasicService;
    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @ApiOperation(value = "查询菜场信息", notes = "根据名称、编码等进行物流区菜场信息查询")
    @RequestMapping(value = "/buyerMarket/foodModule/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = FoodMarketModuleBasicSearchValidator.class)
    public BaseRestPaginationResult<MarketFoodModuleBasicRsParam> searchFoodModuleBaseInfo(
            @RequestBody MarketFoodModuleBasicRsParam param) {
        if (null != param) {
            if (StringUtils.isNotEmpty(param.getFoodMarketName())) {
                param.setFoodMarketName(DbUtils.buildLikeCondition(param.getFoodMarketName(), DbUtils.LikeMode.PARTIAL));
            }

            if (StringUtils.isNotEmpty(param.getFoodMarketCode())) {
                param.setFoodMarketCode(DbUtils.buildLikeCondition(param.getFoodMarketCode(), DbUtils.LikeMode.PARTIAL));
            }

        }
        BaseRestPaginationResult<MarketFoodModuleBasicRsParam> pageResult = bymtFoodMarketBasicService.findPageList(param);
        return pageResult;
    }

    @ApiOperation(value = "查询物流区菜场信息", notes = "物流区菜场信息新增接口")
    @RequestMapping(value = "/buyerMarket/foodModule/_add", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = FoodMarketModuleBasicAddValidator.class)
    public Integer addFoodModuleBaseInfo(@RequestBody List<MarketFoodModuleBasicRsParam> params) {
        logger.info("check参数");
        this.insertFoodMarketParamCheck(params);
        int resultNumber = bymtFoodMarketBasicService.addFoodMarketBasic(params);
        return resultNumber;
    }

    @ApiOperation(value = "物流区菜场买家信息修改或删除", notes = "物流区菜场买家信息修改或删除")
    @RequestMapping(value = "/buyerMarket/foodModule/_update", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = FoodMarketModuleBasicUpdateValidator.class)
    public Integer updateFoodModule(
            @RequestBody List<BaseBean<MarketFoodModuleBasicRsParam, MarketFoodModuleBasicRsParam>> param) {
        logger.info("城市信息更新参数验证");
        ArrayList<StoreRsParam> storeRsParams = new ArrayList<>();
        StoreRsParam storeRsParam = new StoreRsParam();
        if (CollectionUtils.isNotEmpty(param)) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < param.size(); i++) {
                BaseBean<MarketFoodModuleBasicRsParam, MarketFoodModuleBasicRsParam> baseBean = param.get(i);
                MarketFoodModuleBasicRsParam filter = baseBean.getFilter();
                MarketFoodModuleBasicRsParam target = baseBean.getTarget();
                if (target.isDelFlg()) {
                    //判断要删除的菜场是否已被买家使用
                    storeRsParam.setMarketId(filter.getFoodMarketId());
                    storeRsParams.add(storeRsParam);
                }
            }
        }
        String url = ConfigServerUtils.getAPIUrl(ApiUrlDef.BYIM_MODULE, ApiUrlDef.STORE.storeSearch);
        //String url = "http://localhost:8093/bms-byim-api/api/buyers/Store/_search";
        RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
        Integer result = restApiClient.post(url, storeRsParams, new TypeReference<Integer>() {
        });
        if (result > NumberConst.IntDef.INT_ZERO) {
            return NumberConst.IntDef.INT_N_ONE;
        } else {
            this.updateFoodMarketParamCheck(param);
            logger.info("数据库更新");
            int resultCount = bymtFoodMarketBasicService.updateFoodMarketBasic(param);
            return resultCount;
        }
    }

    /**
     * 编辑参数与DB数据验证
     *
     * @param param
     */
    public void updateFoodMarketParamCheck(List<BaseBean<MarketFoodModuleBasicRsParam, MarketFoodModuleBasicRsParam>> param) {
        int size = param.size();
        for (int i = NumberConst.IntDef.INT_ZERO; i < size; i++) {
            MarketFoodModuleBasicRsParam target = param.get(i).getTarget();
            MarketFoodModuleBasicRsParam filter = param.get(i).getFilter();
            BymtFoodMarketBasic foodMarketBasic = bymtFoodMarketBasicService.findOne(filter);
            if (foodMarketBasic != null) {
                //需要确认
                if (!foodMarketBasic.getFoodMarketId().equals(filter.getFoodMarketId())) {
                    String[] args = new String[]{String.valueOf(i + 1), MessageManager.getMessage(MessageDef.Label.L00006)};
                    throw new BusinessException("bymt", "BYMT.E00007");
                }
            }
        }
    }

    /**
     * 新增数与DB数据验证
     *
     * @param params
     */
    public void insertFoodMarketParamCheck(List<MarketFoodModuleBasicRsParam> params) {
        int size = params.size();
        for (int i = NumberConst.IntDef.INT_ZERO; i < size; i++) {
            int line = bymtFoodMarketBasicService.getCount(params.get(i));
            if (line > 0) {
                String[] args = new String[]{String.valueOf(i + 1), MessageManager.getMessage(MessageDef.Label.L00005)};
                throw new BusinessException("bymt","BYMT.E00007");
            }
        }
    }


}
