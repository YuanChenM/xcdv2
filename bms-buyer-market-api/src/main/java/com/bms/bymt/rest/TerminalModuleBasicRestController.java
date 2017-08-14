package com.bms.bymt.rest;

import com.alibaba.fastjson.TypeReference;
import com.bms.bymt.bean.entity.BymtTerminalMarketBasic;
import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.StoreRsParam;
import com.bms.bymt.bean.param.TerminalMarketBasicRsParam;
import com.bms.bymt.constant.ApiUrlDef;
import com.bms.bymt.constant.MessageDef;
import com.bms.bymt.services.BymtTerminalMarketBasicService;
import com.bms.bymt.validator.TerminalModuleBasicAddValidator;
import com.bms.bymt.validator.TerminalModuleBasicSearchValidator;
import com.bms.bymt.validator.TerminalModuleBasicUpdateValidator;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.db.DbUtils;
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
 * Created by guan_zhongheng on 2016/12/14.
 */
@RestController
@Api(value = "bms-bymt-api",
        description = "批发市场基础信息",
        position = 1,
        tags = "TerminalModuleBasicRestController")
public class TerminalModuleBasicRestController extends BaseRestController {

    Logger logger = LoggerFactory.getLogger(TerminalModuleBasicRestController.class);
    @Autowired
    private BymtTerminalMarketBasicService bymtTerminalMarketBasicService;
    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @ApiOperation(value = "searchTerminalModuleBaseInfo",
            notes = "根据名称、编码等进行批发市场信息查询")
    @RequestMapping(value = "/buyerMarket/terminalModule/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = TerminalModuleBasicSearchValidator.class)
    public BaseRestPaginationResult<TerminalMarketBasicRsParam> searchTerminalModuleBaseInfo(
            @RequestBody TerminalMarketBasicRsParam marketBasicRsParam) {
        if (null != marketBasicRsParam) {
            if (StringUtils.isNotEmpty(marketBasicRsParam.getTermMarketName())) {
                marketBasicRsParam.setTermMarketName(DbUtils.buildLikeCondition(marketBasicRsParam.getTermMarketName(), DbUtils.LikeMode.PARTIAL));
            }
            if (StringUtils.isNotEmpty(marketBasicRsParam.getTermMarketCode())) {
                marketBasicRsParam.setTermMarketCode(DbUtils.buildLikeCondition(marketBasicRsParam.getTermMarketCode(), DbUtils.LikeMode.PARTIAL));
            }
        }
        BaseRestPaginationResult<TerminalMarketBasicRsParam> pageResult = bymtTerminalMarketBasicService.findPageList(marketBasicRsParam);
        return pageResult;
    }

    @ApiOperation(value = "新增批发市场信息",
            notes = "批发市场基础信息新增")
    @RequestMapping(value = "/buyerMarket/terminalModule/_add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = TerminalModuleBasicAddValidator.class)
    public Integer addTerminalModuleBaseInfo(@RequestBody List<TerminalMarketBasicRsParam> params) {
        logger.info("check参数");
        this.insertTerminalMarketParamCheck(params);
        return bymtTerminalMarketBasicService.addTerminalModuleBasic(params);
    }

    @ApiOperation(value = "批发市场主数据修改或删除", notes = "批发市场主数据修改或删除")
    @RequestMapping(value = "/buyerMarket/terminalModule/_update", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = TerminalModuleBasicUpdateValidator.class)
    public Integer updateRegnCity(
            @RequestBody List<BaseBean<TerminalMarketBasicRsParam, TerminalMarketBasicRsParam>> param) {
        logger.info("城市信息更新参数验证");
        ArrayList<StoreRsParam> storeRsParams = new ArrayList<>();
        StoreRsParam storeRsParam = new StoreRsParam();
        for (int i = NumberConst.IntDef.INT_ZERO; i < param.size(); i++) {
            BaseBean<TerminalMarketBasicRsParam, TerminalMarketBasicRsParam> baseBean = param.get(i);
            TerminalMarketBasicRsParam filter = baseBean.getFilter();
            TerminalMarketBasicRsParam target = baseBean.getTarget();
            if (target.isDelFlg()) {
                //判断要删除的批发市场是否已被买家使用
                storeRsParam.setMarketId(filter.getTermMarketId());
                storeRsParams.add(storeRsParam);
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
            this.updateTerminalMarketParamCheck(param);
            logger.info("数据库更新");
            return bymtTerminalMarketBasicService.updateTerminalMarketBasic(param);
        }
    }

    /**
     * 新增参数验证
     *
     * @param insertParams
     */
    public void insertTerminalMarketParamCheck(List<TerminalMarketBasicRsParam> insertParams) {
        int size = insertParams.size();
        for (int i = NumberConst.IntDef.INT_ZERO; i < size; i++) {
            int result = bymtTerminalMarketBasicService.getCount(insertParams.get(i));
            if (result > NumberConst.IntDef.INT_ZERO) {
                String[] args = new String[]{String.valueOf(i + 1), MessageManager.getMessage(MessageDef.Label.L00005)};
                throw new BusinessException("bymt","BYMT.E00007");

            }
        }
    }

    /**
     * 编辑参数验证
     *
     * @param param
     */
    public void updateTerminalMarketParamCheck(List<BaseBean<TerminalMarketBasicRsParam, TerminalMarketBasicRsParam>> param) {
        int size = param.size();
        for (int i = NumberConst.IntDef.INT_ZERO; i < size; i++) {
            TerminalMarketBasicRsParam target = param.get(i).getTarget();
            TerminalMarketBasicRsParam filter = param.get(i).getFilter();

            BymtTerminalMarketBasic terminalMarketBasic = bymtTerminalMarketBasicService.findOne(filter);
            if (terminalMarketBasic != null) {
                if (!terminalMarketBasic.getTermMarketId().equals(filter.getTermMarketId())) {
                    String[] args = new String[]{String.valueOf(i + 1), MessageManager.getMessage(MessageDef.Label.L00006)};
                    throw new BusinessException("bymt","BYMT.E00007");
                }
            }
        }
    }


}
