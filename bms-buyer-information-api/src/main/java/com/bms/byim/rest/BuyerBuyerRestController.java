package com.bms.byim.rest;

import com.alibaba.fastjson.TypeReference;
import com.bms.byim.bean.entity.ByimAccount;
import com.bms.byim.bean.param.*;
import com.bms.byim.bean.result.BuyerAllInfoRsResult;
import com.bms.byim.bean.result.BuyerButlerAgentRelationRsResult;
import com.bms.byim.bean.result.BuyerIsUpdateRsResult;
import com.bms.byim.constant.ApiUrlDef;
import com.bms.byim.services.ByimBuyerService;
import com.bms.byim.validator.BuyerBuyerAddValidator;
import com.bms.byim.validator.BuyerBuyerUpdateValidator;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.fms.notice.FmsNotice;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
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
import java.util.Date;
import java.util.List;

/**
 * @author zhou_yajun
 * @version 1.0
 */
@RestController
@Api(value = "bms-byim-api", description = "买家基本信息接口", position = 1, tags = "BuyerBasicRestController")
public class BuyerBuyerRestController extends BaseRestController {

    Logger logger = LoggerFactory.getLogger(DeliveryAreaRestController.class);

    @Autowired
    private ByimBuyerService byimBasicService;
    @Autowired
    private RestApiClientFactory restApiClientFactory;
    @Autowired
    private FmsNotice fmsNotice;

    @ApiOperation(value = "买家必要信息新增", notes = "买家必要信息新增")
    @RequestMapping(value = "/buyers/requisite/info/_add", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = BuyerBuyerAddValidator.class)
    public BuyerBasicRsParam add(@RequestBody BuyerBasicRsParam param) {
        BuyerBasicRsParam rsResult = new BuyerBasicRsParam();
        //查询账号是否已经存在
        int accountCount = byimBasicService.checkAccountIsExist(param);
        //查询账号是否和其他买家名称相同
        //int nameAccount = byimBasicService.checkNameIsExist(param);
        //查询手机号是否重复
        int telNoAccount = byimBasicService.checkTelNoIsExist(param);
        //查询买家名称是否重复
        int buyerNameCount = byimBasicService.checkBuyerNameIsExist(param);
        //查询买家名称是否和其他买家账号相同
        //int buyerAccountNoCount = byimBasicService.checkBuyerAccountNoIsExist(param);
        int existCount = NumberConst.IntDef.INT_ZERO;
        if (accountCount > NumberConst.IntDef.INT_ZERO) {
            //该买家账号不允许和其他买家帐号相同！
            existCount = NumberConst.IntDef.INT_N_ONE;
            throw new BusinessException("BYIM", "BYIM.E00021");
        }/* else if (nameAccount > NumberConst.IntDef.INT_ZERO) {
            //该买家账号不允许和其他买家名称相同！
            existCount = NumberConst.IntDef.INT_N_TWO;
        }*/ else if (telNoAccount > NumberConst.IntDef.INT_ZERO) {
            //该买家手机号已被注册过！
            existCount = NumberConst.IntDef.INT_N_THREE;
            throw new BusinessException("BYIM", "BYIM.E00020");
        } else if (buyerNameCount > NumberConst.IntDef.INT_ZERO) {
            //该买家名称已存在！
            existCount = -4;
            throw new BusinessException("BYIM", "BYIM.E00017");
        }/* else if (buyerAccountNoCount > NumberConst.IntDef.INT_ZERO) {
            //该买家名称不允许和其他买家账号相同！
            existCount = -5;
        }*/ else {
            rsResult = byimBasicService.insertBuyerBasic(param);
        }
        rsResult.setExistCount(existCount);
        String buyerId = rsResult.getBuyerId();
        if (!StringUtils.isEmpty(buyerId)) {
            fmsNotice.sendBuyer(buyerId);
        }
        return rsResult;
    }

    @ApiOperation(value = "买家其它信息更新", notes = "买家其它信息更新")
    @RequestMapping(value = "/buyers/other/info/_update", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = BuyerBuyerUpdateValidator.class)
    public Integer update(@RequestBody BaseBean<BuyerOtherRsParam, BuyerOtherRsParam> updateRsParam) {
        BuyerIsUpdateRsResult isUpdateRsResult = byimBasicService.updateBuyerBasic(updateRsParam);
        if (isUpdateRsResult.getIsUpdate()) {
            String buyerId = updateRsParam.getFilter().getBuyerId();
            if (!StringUtils.isEmpty(buyerId)) {
                fmsNotice.sendBuyer(buyerId);
            }
        }
        return isUpdateRsResult.getModifyResult();
    }

    @ApiOperation(value = "买家基本信息查询", notes = "买家基本信息查询")
    @RequestMapping(value = "/buyers/basic/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<BuyerAllRsParam> search(@RequestBody BuyerAllRsParam buyerAllRsParam) {
        buyerAllRsParam.setBuyerName(DbUtils.buildLikeCondition(buyerAllRsParam.getBuyerName(), DbUtils.LikeMode.PARTIAL));
        buyerAllRsParam.setBuyerCode(DbUtils.buildLikeCondition(buyerAllRsParam.getBuyerCode(), DbUtils.LikeMode.PARTIAL));
        buyerAllRsParam.setBossName(DbUtils.buildLikeCondition(buyerAllRsParam.getBossName(), DbUtils.LikeMode.PARTIAL));
        buyerAllRsParam.setTelNo(DbUtils.buildLikeCondition(buyerAllRsParam.getTelNo(), DbUtils.LikeMode.PARTIAL));
        buyerAllRsParam.setAccountName(DbUtils.buildLikeCondition(buyerAllRsParam.getAccountName(), DbUtils.LikeMode.PARTIAL));
        buyerAllRsParam.setMarketCode(DbUtils.buildLikeCondition(buyerAllRsParam.getMarketCode(), DbUtils.LikeMode.PARTIAL));
        buyerAllRsParam.setMarketName(DbUtils.buildLikeCondition(buyerAllRsParam.getMarketName(), DbUtils.LikeMode.PARTIAL));
        BaseRestPaginationResult<BuyerAllRsParam> basicRsResult = this.byimBasicService.findPageList(buyerAllRsParam);
        return basicRsResult;
    }

    @ApiOperation(value = "全体买家报表信息(含管家买手)查询", notes = "全体买家报表信息(含管家买手)查询")
    @RequestMapping(value = "/buyers/butlers/Agents/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<BuyerAllInfoRsResult> searchBuyerAllInfoList(@RequestBody BuyerAllInfoRsParam buyerAllRsParam) {
        buyerAllRsParam.setBuyerName(DbUtils.buildLikeCondition(buyerAllRsParam.getBuyerName(), DbUtils.LikeMode.PARTIAL));
        buyerAllRsParam.setBuyerCode(DbUtils.buildLikeCondition(buyerAllRsParam.getBuyerCode(), DbUtils.LikeMode.PARTIAL));
        buyerAllRsParam.setBossName(DbUtils.buildLikeCondition(buyerAllRsParam.getBossName(), DbUtils.LikeMode.PARTIAL));
        //buyerAllRsParam.setTelNo(DbUtils.buildLikeCondition(buyerAllRsParam.getTelNo(), DbUtils.LikeMode.PARTIAL));
        buyerAllRsParam.setAccountName(DbUtils.buildLikeCondition(buyerAllRsParam.getAccountName(), DbUtils.LikeMode.PARTIAL));
        /*buyerAllRsParam.setMarketCode(DbUtils.buildLikeCondition(buyerAllRsParam.getMarketCode(), DbUtils.LikeMode.PARTIAL));
        buyerAllRsParam.setMarketName(DbUtils.buildLikeCondition(buyerAllRsParam.getMarketName(), DbUtils.LikeMode.PARTIAL));*/
        buyerAllRsParam.setTermMarketCode(DbUtils.buildLikeCondition(buyerAllRsParam.getTermMarketCode(), DbUtils.LikeMode.PARTIAL));
        buyerAllRsParam.setTermMarketName(DbUtils.buildLikeCondition(buyerAllRsParam.getTermMarketName(), DbUtils.LikeMode.PARTIAL));
        buyerAllRsParam.setFoodMarketCode(DbUtils.buildLikeCondition(buyerAllRsParam.getFoodMarketCode(), DbUtils.LikeMode.PARTIAL));
        buyerAllRsParam.setFoodMarketName(DbUtils.buildLikeCondition(buyerAllRsParam.getFoodMarketName(), DbUtils.LikeMode.PARTIAL));
        BaseRestPaginationResult<BuyerAllInfoRsResult> allInfoList = this.byimBasicService.findBuyerAllInfoList(buyerAllRsParam);
        if (allInfoList != null && CollectionUtils.isNotEmpty(allInfoList.getData())) {
            //查询买家管家买手信息
            BuyerButlerAgentRelationRsPageParam rsPageParam = BeanUtils.toBean(buyerAllRsParam, BuyerButlerAgentRelationRsPageParam.class);
            //String url = "http://localhost:8095/oms-agif/" + ApiUrlDef.AGIF.buyerButlerAgentSearch;
            String url = ConfigServerUtils.getAPIUrl(ApiUrlDef.AGIF_MODULE, ApiUrlDef.AGIF.buyerButlerAgentSearch);
            RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
            BaseRestPaginationResult<BuyerButlerAgentRelationRsResult> rsResult = restApiClient.post(url, rsPageParam, new TypeReference<BaseRestPaginationResult<BuyerButlerAgentRelationRsResult>>() {
            });
            if (rsResult != null && CollectionUtils.isNotEmpty(rsResult.getData())) {
                allInfoList = this.completeParameter(allInfoList, rsResult);
            }
        }
        return allInfoList;
    }

    private BaseRestPaginationResult<BuyerAllInfoRsResult> completeParameter(BaseRestPaginationResult<BuyerAllInfoRsResult> allInfoList,
                                                                             BaseRestPaginationResult<BuyerButlerAgentRelationRsResult> rsResult) {
        for (BuyerButlerAgentRelationRsResult relationRsResult : rsResult.getData()) {
            for (BuyerAllInfoRsResult allInfoRsResult : allInfoList.getData()) {
                if (relationRsResult.getBuyerId().equals(allInfoRsResult.getBuyerId())) {
                    allInfoRsResult.setRelationId(relationRsResult.getRelationId());
                    allInfoRsResult.setButlerId(relationRsResult.getButlerId());
                    allInfoRsResult.setButlerCode(relationRsResult.getButlerCode());
                    allInfoRsResult.setButlerName(relationRsResult.getButlerName());
                    allInfoRsResult.setButlerAccount(relationRsResult.getButlerAccount());
                    allInfoRsResult.setButlerTelNo(relationRsResult.getButlerTelNo());
                    allInfoRsResult.setAgentId(relationRsResult.getAgentId());
                    allInfoRsResult.setAgentCode(relationRsResult.getAgentCode());
                    allInfoRsResult.setAgentName(relationRsResult.getAgentName());
                    allInfoRsResult.setAgentAccount(relationRsResult.getAgentAccount());
                    allInfoRsResult.setAgentTelNo(relationRsResult.getAgentTelNo());
                    break;
                } else {
                    continue;
                }
            }
        }
        return allInfoList;
    }

    @ApiOperation(value = "买家批量基本信息查询", notes = "买家基本信息查询")
    @RequestMapping(value = "/buyers/byBuyerIds/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<BuyerAllRsParam> searchBuyerIds(@RequestBody BuyerBasicBuyerIdsRsParam buyerIdsRsParam) {
        buyerIdsRsParam.setBuyerName(DbUtils.buildLikeCondition(buyerIdsRsParam.getBuyerName(), DbUtils.LikeMode.PARTIAL));
        buyerIdsRsParam.setBuyerCode(DbUtils.buildLikeCondition(buyerIdsRsParam.getBuyerCode(), DbUtils.LikeMode.PARTIAL));
        buyerIdsRsParam.setBuyerBossName(DbUtils.buildLikeCondition(buyerIdsRsParam.getBuyerBossName(), DbUtils.LikeMode.PARTIAL));
        buyerIdsRsParam.setBuyerAccount(DbUtils.buildLikeCondition(buyerIdsRsParam.getBuyerAccount(), DbUtils.LikeMode.PARTIAL));
        buyerIdsRsParam.setBuyerMarketName(DbUtils.buildLikeCondition(buyerIdsRsParam.getBuyerMarketName(), DbUtils.LikeMode.PARTIAL));
        buyerIdsRsParam.setBuyerTypeName(DbUtils.buildLikeCondition(buyerIdsRsParam.getBuyerTypeName(), DbUtils.LikeMode.PARTIAL));
        buyerIdsRsParam.setBuyerTelNo(DbUtils.buildLikeCondition(buyerIdsRsParam.getBuyerTelNo(), DbUtils.LikeMode.PARTIAL));
        buyerIdsRsParam.setBuyerStoreNo(DbUtils.buildLikeCondition(buyerIdsRsParam.getBuyerStoreNo(), DbUtils.LikeMode.PARTIAL));
        BaseRestPaginationResult<BuyerAllRsParam> basicRsResult = this.byimBasicService.findPageListToBuyerIds(buyerIdsRsParam);
        return basicRsResult;
    }

    @ApiOperation(value = "买家账号信息查询", notes = "买家账号信息查询")
    @RequestMapping(value = "/buyers/account/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BuyerAccountRsParam searchBuyerAccount(@RequestBody BuyerAccountRsParam accountRsParam) {
        if (StringUtils.isEmpty(accountRsParam.getBuyerId()) && StringUtils.isEmpty(accountRsParam.getBuyerCode())) {
            throw new BusinessException("BYIM", "BYIM.E00015");
        } else {
            if (StringUtils.isEmpty(accountRsParam.getBuyerId())) {
                //通过买家编码查询买家ID
                String buyerId = this.byimBasicService.findBuyerId(accountRsParam);
                accountRsParam.setBuyerId(buyerId);
            }
        }
        return this.byimBasicService.findBuyerAccount(accountRsParam);
    }

    @ApiOperation(value = "买家账号密码重置", notes = "买家账号密码重置")
    @RequestMapping(value = "/buyers/account/password/_modify", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer updateBuyerAccount(@RequestBody BuyerAccountRsParam accountRsParam) {
        BaseBean<ByimAccount, ByimAccount> baseBean = new BaseBean<>();
        ByimAccount accountTarget = new ByimAccount();
        ByimAccount accountFilter = new ByimAccount();
        String loginUserId = this.byimBasicService.getLoginUserId();
        Date currentDate = DateUtils.getCurrent();
        accountTarget.setUpdId(loginUserId);
        accountTarget.setUpdTime(currentDate);
        accountFilter.setAccountId(accountRsParam.getAccountId());
        baseBean.setFilter(accountFilter);
        baseBean.setTarget(accountTarget);
        return this.byimBasicService.updateBuyerAccount(baseBean);
    }

    @ApiOperation(value = "买家批量新增", notes = "买家批量新增")
    @RequestMapping(value = "/buyers/batchSave", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List batchInsert(@RequestBody List<BuyerBasicRsParam> buyerBasicRsParamList) {
        List list = new ArrayList();
        for (BuyerBasicRsParam basicRsParam : buyerBasicRsParamList) {
            try {
                add(basicRsParam);
            } catch (Exception e) {
                list.add(basicRsParam.getAccountNo());
            } finally {
                continue;
            }

        }
        return list;
    }

}

