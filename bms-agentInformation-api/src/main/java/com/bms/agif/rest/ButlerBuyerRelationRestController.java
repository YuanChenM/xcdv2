package com.bms.agif.rest;

import com.alibaba.fastjson.TypeReference;
import com.bms.agif.bean.entity.AgifButlerBuyerRelation;
import com.bms.agif.bean.param.*;
import com.bms.agif.bean.result.AgentRelationRsResult;
import com.bms.agif.bean.result.BuyerButlerAgentRelationRsResult;
import com.bms.agif.constant.ApiUrlDef;
import com.bms.agif.service.*;
import com.bms.agif.validator.AgentRelationSearchValidator;
import com.bms.agif.validator.ButlerBuyerRelationAddValidator;
import com.bms.agif.validator.ButlerBuyerRelationUpdateValidator;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.*;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * Created by yuan_zhifei on 2017/3/15.
 */
@RestController
@Api(value = "bms-agif-api", description = "买家管家买手合伙人关系", position = 1, tags = "ButlerBuyerRelationRestController")
public class ButlerBuyerRelationRestController extends BaseRestController {
    @Autowired
    private AgifButlerBuyerRelationService agifButlerBuyerRelationService;
    @Autowired
    private AgifButlerService agifButlerService;
    @Autowired
    private AgifAgentService agifAgentService;
    @Autowired
    private AgifAgentDemesneService agifAgentDemesneService;
    @Autowired
    private AgifPartnerDistributionService agifPartnerDistributionService;
    @Autowired
    private AgifPartnerService agifPartnerService;
    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @ApiOperation(value = "买家所属的买手和管家信息查询", notes = "买家所属的买手和管家信息查询", position = 1)
    @RequestMapping(value = "/agent/byBuyer/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<ButlerBuyerRelationRsPageParam> searchButlerBuyerInfo(@RequestBody ButlerBuyerRelationRsPageParam pageParam) {
        BaseRestPaginationResult<ButlerBuyerRelationRsPageParam> paginationResult = this.agifButlerBuyerRelationService.findPageList(pageParam);
        return paginationResult;
    }

    @ApiOperation(value = "买家和买手（管家）关系查询", notes = "买家和买手（管家）关系查询", position = 2)
    @RequestMapping(value = "/relation/buyer/agent/butler/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<ButlerBuyerRelationRsPageParam> searchButlerBuyerRelationInfo(@RequestBody ButlerBuyerRelationRsPageParam pageParam) {
        BaseRestPaginationResult<ButlerBuyerRelationRsPageParam> paginationResult = this.agifButlerBuyerRelationService.findRelationPageList(pageParam);
        if (paginationResult != null) {
            if (CollectionUtils.isNotEmpty(paginationResult.getData())) {
                String[] buyerIds = new String[paginationResult.getData().size()];
                for (int i = NumberConst.IntDef.INT_ZERO; i < paginationResult.getData().size(); i++) {
                    buyerIds[i] = paginationResult.getData().get(i).getBuyerId();
                }
                //调用根据买家ID查询买家信息接口
                BuyerBasicBuyerIdsRsParam buyerIdsRsParam = new BuyerBasicBuyerIdsRsParam();
                buyerIdsRsParam.setBuyerIds(buyerIds);
                String url = ConfigServerUtils.getAPIUrl(ApiUrlDef.BYIM_MODULE, ApiUrlDef.BUYER.searchBuyerByBuyerIds);
                RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
                BaseRestPaginationResult<BuyerAllRsParam> buyersResult = restApiClient.post(url, buyerIdsRsParam, new TypeReference<BaseRestPaginationResult<BuyerAllRsParam>>() {
                });
                if (buyersResult != null) {
                    if (CollectionUtils.isNotEmpty(paginationResult.getData())) {
                        ButlerBuyerRelationRsPageParam relationRsPageParam = null;
                        BuyerAllRsParam buyerAllRsParam = null;
                        for (int i = NumberConst.IntDef.INT_ZERO; i < paginationResult.getData().size(); i++) {
                            relationRsPageParam = paginationResult.getData().get(i);
                            for (int j = NumberConst.IntDef.INT_ZERO; j < buyersResult.getData().size(); j++) {
                                buyerAllRsParam = buyersResult.getData().get(j);
                                if (relationRsPageParam.getBuyerId().equals(buyerAllRsParam.getBuyerId())) {
                                    //优先使用买家物流区地区配送站领地ID编码名称
                                    if (buyerAllRsParam.getLgcsAreaId() != null) {
                                        relationRsPageParam.setLgcsAreaId(buyerAllRsParam.getLgcsAreaId());
                                    } else if (relationRsPageParam.getButlerLgcsAreaId() != null) {
                                        //买家物流区ID为空时使用管家物流区编码名称
                                        relationRsPageParam.setLgcsAreaId(relationRsPageParam.getButlerLgcsAreaId());
                                    } else {
                                        //管家物流区ID为空时使用买手物流区ID编码名称
                                        relationRsPageParam.setLgcsAreaId(relationRsPageParam.getAgentLgcsAreaId());
                                    }
                                    if (StringUtils.isNotEmpty(buyerAllRsParam.getLgcsAreaCode())) {
                                        relationRsPageParam.setLgcsAreaCode(buyerAllRsParam.getLgcsAreaCode());
                                    } else if (StringUtils.isNotEmpty(relationRsPageParam.getButlerLgcsAreaCode())) {
                                        relationRsPageParam.setLgcsAreaCode(relationRsPageParam.getButlerLgcsAreaCode());
                                    } else {
                                        relationRsPageParam.setLgcsAreaCode(relationRsPageParam.getAgentLgcsAreaCode());
                                    }
                                    if (buyerAllRsParam.getZoneId() != null) {
                                        relationRsPageParam.setZoneId(buyerAllRsParam.getZoneId());
                                    } else if (relationRsPageParam.getButlerZoneId() != null) {
                                        relationRsPageParam.setZoneId(relationRsPageParam.getButlerZoneId());
                                    } else {
                                        relationRsPageParam.setZoneId(relationRsPageParam.getAgentZoneId());
                                    }
                                    if (StringUtils.isNotEmpty(buyerAllRsParam.getZoneCode())) {
                                        relationRsPageParam.setZoneCode(buyerAllRsParam.getZoneCode());
                                    } else if (StringUtils.isNotEmpty(relationRsPageParam.getButlerZoneCode())) {
                                        relationRsPageParam.setZoneCode(relationRsPageParam.getButlerZoneCode());
                                    } else {
                                        relationRsPageParam.setZoneCode(relationRsPageParam.getAgentZoneCode());
                                    }
                                    if (StringUtils.isNotEmpty(buyerAllRsParam.getZoneName())) {
                                        relationRsPageParam.setZoneName(buyerAllRsParam.getZoneName());
                                    } else if (StringUtils.isNotEmpty(relationRsPageParam.getButlerZoneName())) {
                                        relationRsPageParam.setZoneName(relationRsPageParam.getButlerZoneName());
                                    } else {
                                        relationRsPageParam.setZoneName(relationRsPageParam.getAgentZoneName());
                                    }
                                    if (StringUtils.isNotEmpty(buyerAllRsParam.getLgcsAreaName())) {
                                        relationRsPageParam.setLgcsAreaName(buyerAllRsParam.getLgcsAreaName());
                                    } else if (StringUtils.isNotEmpty(relationRsPageParam.getButlerLgcsAreaName())) {
                                        relationRsPageParam.setLgcsAreaName(relationRsPageParam.getButlerLgcsAreaName());
                                    } else {
                                        relationRsPageParam.setLgcsAreaName(relationRsPageParam.getAgentLgcsAreaName());
                                    }
                                    if (buyerAllRsParam.getDistributionId() != null) {
                                        relationRsPageParam.setDistributionId(buyerAllRsParam.getDistributionId());
                                    }
                                    if (StringUtils.isNotEmpty(buyerAllRsParam.getDistributionCode())) {
                                        relationRsPageParam.setDistributionCode(buyerAllRsParam.getDistributionCode());
                                    }
                                    if (StringUtils.isNotEmpty(buyerAllRsParam.getDistributionName())) {
                                        relationRsPageParam.setDistributionName(buyerAllRsParam.getDistributionName());
                                    }
                                    if (buyerAllRsParam.getDemesneId() != null) {
                                        relationRsPageParam.setDemesneId(buyerAllRsParam.getDemesneId());
                                    }
                                    if (StringUtils.isNotEmpty(buyerAllRsParam.getDemesneCode())) {
                                        relationRsPageParam.setDemesneCode(buyerAllRsParam.getDemesneCode());
                                    }
                                    if (StringUtils.isNotEmpty(buyerAllRsParam.getDemesneName())) {
                                        relationRsPageParam.setDemesneName(buyerAllRsParam.getDemesneName());
                                    }
                                    relationRsPageParam.setBuyerName(buyerAllRsParam.getBuyerName());
                                    relationRsPageParam.setBuyerCode(buyerAllRsParam.getBuyerCode());
                                    relationRsPageParam.setBuyerAccount(buyerAllRsParam.getAccountName());
                                    relationRsPageParam.setBuyerTelNo(buyerAllRsParam.getTelNo());
                                    relationRsPageParam.setBuyerStoreNo(buyerAllRsParam.getStoreNo());
                                    relationRsPageParam.setBuyerBossName(buyerAllRsParam.getBossName());
                                    relationRsPageParam.setBuyerType(buyerAllRsParam.getBuyerType());
                                    relationRsPageParam.setBuyerTypeName(buyerAllRsParam.getBuyerTypeName());
                                    relationRsPageParam.setBuyerMarketId(buyerAllRsParam.getMarketId());
                                    relationRsPageParam.setBuyerMarketName(buyerAllRsParam.getMarketName());
                                    break;
                                } else {
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
        }
        return paginationResult;
    }

    @ApiOperation(value = "买家和买手（管家）关系查询(全体买家报表数据)", notes = "买家和买手（管家）关系查询(全体买家报表数据)", position = 5)
    @RequestMapping(value = "/relation/buyer/butler/agent/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<BuyerButlerAgentRelationRsResult> searchBuyerButlerAgents(@RequestBody BuyerButlerAgentRelationRsPageParam pageParam) {
        if (StringUtils.isNotEmpty(pageParam.getAgentCode())) {
            pageParam.setAgentCode(DbUtils.buildLikeCondition(pageParam.getAgentCode(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(pageParam.getAgentName())) {
            pageParam.setAgentName(DbUtils.buildLikeCondition(pageParam.getAgentName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(pageParam.getAgentAccount())) {
            pageParam.setAgentAccount(DbUtils.buildLikeCondition(pageParam.getAgentAccount(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(pageParam.getAgentTelNo())) {
            pageParam.setAgentTelNo(DbUtils.buildLikeCondition(pageParam.getAgentTelNo(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(pageParam.getButlerCode())) {
            pageParam.setButlerCode(DbUtils.buildLikeCondition(pageParam.getButlerCode(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(pageParam.getButlerName())) {
            pageParam.setButlerName(DbUtils.buildLikeCondition(pageParam.getButlerName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(pageParam.getButlerAccount())) {
            pageParam.setButlerAccount(DbUtils.buildLikeCondition(pageParam.getButlerAccount(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(pageParam.getButlerTelNo())) {
            pageParam.setButlerTelNo(DbUtils.buildLikeCondition(pageParam.getButlerTelNo(), DbUtils.LikeMode.PARTIAL));
        }
        return this.agifButlerBuyerRelationService.findBuyerButlerAgentPageList(pageParam);
    }


    @ApiOperation(value = "买家和管家关系绑定", notes = "买家和管家关系绑定", position = 1)
    @RequestMapping(value = "/relation/buyer/butler/_binding", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerBuyerRelationAddValidator.class)
    public Integer relationButlerBuyerBinding(@RequestBody List<ButlerBuyerRelationRsPageParam> pageParam) {
        return agifButlerBuyerRelationService.bing(pageParam);
    }

    @ApiOperation(value = "买家和管家关系解除", notes = "买家和管家关系解除", position = 1)
    @RequestMapping(value = "/relation/buyer/butler/_release", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerBuyerRelationUpdateValidator.class)
    public Integer relationButlerBuyerRelease(@RequestBody List<ButlerBuyerRelationRsPageParam> pageParam) {

        return agifButlerBuyerRelationService.unBind(pageParam);
    }

    @ApiOperation(value = "AGIF0212I买家买手上级角色查询", notes = "AGIF0212I买家买手上级角色查询", position = 1)
    @RequestMapping(value = "/agent/relation/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = AgentRelationSearchValidator.class)
    public List<AgentRelationRsResult> searchAgentRelation(@RequestBody AgentRelationRsParam rsParam) {
        List<AgentRelationRsResult> rsResults = new ArrayList<>();
        //判断传入参数为买家ID
        String[] buyerIds = new String[]{rsParam.getAgentId()};
        ButlerRsParam butlerRsParam = null;
        BuyerBasicBuyerIdsRsParam buyerIdsRsParam = new BuyerBasicBuyerIdsRsParam();
        buyerIdsRsParam.setBuyerIds(buyerIds);
        String url = ConfigServerUtils.getAPIUrl(ApiUrlDef.BYIM_MODULE, ApiUrlDef.BUYER.searchBuyerByBuyerIds);
        RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
        //根据买家ID查询买家信息
        BaseRestPaginationResult<BuyerAllRsParam> buyersResult = restApiClient.post(url, buyerIdsRsParam, new TypeReference<BaseRestPaginationResult<BuyerAllRsParam>>() {
        });
        if (buyersResult != null && CollectionUtils.isNotEmpty(buyersResult.getData())) {
            //根据买家ID查询
            BuyerAllRsParam buyer = buyersResult.getData().get(NumberConst.IntDef.INT_ZERO);
            ButlerBuyerRelationRsParam relationRsParam = new ButlerBuyerRelationRsParam();
            relationRsParam.setBuyerId(buyer.getBuyerId());
            List<ButlerBuyerRelationRsParam> butlerBuyerRelations = agifButlerBuyerRelationService.findList(relationRsParam);
            if (CollectionUtils.isNotEmpty(butlerBuyerRelations)) {
                ButlerBuyerRelationRsParam buyerRelationRsParam = butlerBuyerRelations.get(NumberConst.IntDef.INT_ZERO);
                butlerRsParam = new ButlerRsParam();
                butlerRsParam.setButlerId(buyerRelationRsParam.getButlerId());
                rsResults = this.findButlerAgentPartnerResult(buyer, butlerRsParam);
            }
        } else {
            //判断传入参数为管家ID
            butlerRsParam = new ButlerRsParam();
            butlerRsParam.setButlerId(rsParam.getAgentId());
            //根据管家ID查询管家信息
            BaseRestPaginationResult<ButlerRsParam> butlerResult = agifButlerService.findPageList(butlerRsParam);
            if (butlerResult != null && CollectionUtils.isNotEmpty(butlerResult.getData())) {
                //根据买手ID查询买手信息
                butlerRsParam = butlerResult.getData().get(NumberConst.IntDef.INT_ZERO);
                AgentDemesnePageParam demesnePageParam = new AgentDemesnePageParam();
                demesnePageParam.setAgentId(butlerRsParam.getAgentId());
                BaseRestPaginationResult<AgentDemesnePageParam> agentResult = agifAgentService.findPageList(demesnePageParam);
                if (agentResult != null && CollectionUtils.isNotEmpty(agentResult.getData())) {
                    AgentRelationRsResult rsResult = new AgentRelationRsResult();
                    demesnePageParam = agentResult.getData().get(NumberConst.IntDef.INT_ZERO);
                    rsResult.setAgentId(demesnePageParam.getAgentId());
                    rsResult.setAgentCode(demesnePageParam.getAgentCode());
                    rsResult.setAgentName(demesnePageParam.getAgentName());
                    rsResult.setRoleType("agent");
                    rsResults.add(rsResult);
                    //根据买手ID查询领地信息
                    /*AgentDemesnePageParam demesneParam = new AgentDemesnePageParam();
                    demesneParam.setAgentId(demesnePageParam.getAgentId());
                    rsResult = this.findDistributionResult(demesneParam);
                    rsResults.add(rsResult);*/
                }
            }/* else {
                //传入参数为买手ID根据买手ID查询领地信息
                AgentRelationRsResult rsResult = new AgentRelationRsResult();
                AgentDemesnePageParam demesnePageParam = new AgentDemesnePageParam();
                demesnePageParam.setAgentId(rsParam.getAgentId());
                rsResult = this.findDistributionResult(demesnePageParam);
                rsResults.add(rsResult);

            }*/
        }
        return rsResults;
    }

    //管家、买手、合伙人信息
    private List<AgentRelationRsResult> findButlerAgentPartnerResult(BuyerAllRsParam buyer, ButlerRsParam butlerRsParam) {
        List<AgentRelationRsResult> rsResults = new ArrayList<>();
        //根据管家ID查询管家信息
        BaseRestPaginationResult<ButlerRsParam> butlerResult = agifButlerService.findPageList(butlerRsParam);
        if (butlerResult != null && CollectionUtils.isNotEmpty(butlerResult.getData())) {
            AgentRelationRsResult rsResult = new AgentRelationRsResult();
            butlerRsParam = butlerResult.getData().get(NumberConst.IntDef.INT_ZERO);
            rsResult.setAgentId(butlerRsParam.getButlerId());
            rsResult.setAgentCode(butlerRsParam.getButlerCode());
            rsResult.setAgentName(butlerRsParam.getButlerName());
            rsResult.setRoleType("butler");
            rsResults.add(rsResult);
            //根据买手ID查询买手信息
            AgentDemesnePageParam demesnePageParam = new AgentDemesnePageParam();
            demesnePageParam.setAgentId(butlerRsParam.getAgentId());
            BaseRestPaginationResult<AgentDemesnePageParam> agentResult = agifAgentService.findPageList(demesnePageParam);
            if (agentResult != null && CollectionUtils.isNotEmpty(agentResult.getData())) {
                rsResult = new AgentRelationRsResult();
                demesnePageParam = agentResult.getData().get(NumberConst.IntDef.INT_ZERO);
                rsResult.setAgentId(demesnePageParam.getAgentId());
                rsResult.setAgentCode(demesnePageParam.getAgentCode());
                rsResult.setAgentName(demesnePageParam.getAgentName());
                rsResult.setRoleType("agent");
                rsResults.add(rsResult);
                /*AgentDemesnePageParam demesneParam = new AgentDemesnePageParam();
                if (buyer.getDistributionId() != null) {
                    //根据买家配送站Id查询合伙人信息
                    PartnerDistributionRsParam distributionRsParam = new PartnerDistributionRsParam();
                    distributionRsParam.setDistributionId(buyer.getDistributionId());
                    distributionRsParam.setLgcsAreaId(buyer.getLgcsAreaId());
                    distributionRsParam.setZoneId(buyer.getZoneId());
                    rsResult = this.findPartnerResult(distributionRsParam);
                } else {
                    //根据买手ID查询领地信息
                    demesneParam.setAgentId(demesnePageParam.getAgentId());
                    rsResult = this.findDistributionResult(demesneParam);
                }
                rsResults.add(rsResult);*/
            }
        }
        return rsResults;
    }

    //配送站信息
    /*private AgentRelationRsResult findDistributionResult(AgentDemesnePageParam demesnePageParam) {
        AgentRelationRsResult rsResult = new AgentRelationRsResult();
        BaseRestPaginationResult<AgentDemesnePageParam> demesneResult = agifAgentDemesneService.findPageList(demesnePageParam);
        if (demesneResult != null && CollectionUtils.isNotEmpty(demesneResult.getData())) {
            rsResult = new AgentRelationRsResult();
            demesnePageParam = demesneResult.getData().get(NumberConst.IntDef.INT_ZERO);
            //根据买手领地配送站ID查询合伙人配送站信息
            PartnerDistributionRsParam distributionRsParam = new PartnerDistributionRsParam();
            distributionRsParam.setDistributionId(demesnePageParam.getDistributionId());
            distributionRsParam.setLgcsAreaId(demesnePageParam.getLgcsAreaId());
            distributionRsParam.setZoneId(demesnePageParam.getZoneId());
            rsResult = this.findPartnerResult(distributionRsParam);
        }
        return rsResult;
    }*/

    //根据配送站ID查询合伙人信息
    /*private AgentRelationRsResult findPartnerResult(PartnerDistributionRsParam distributionRsParam) {
        AgentRelationRsResult rsResult = new AgentRelationRsResult();
        BaseRestPaginationResult<PartnerDistributionRsParam> distributionResult = agifPartnerDistributionService.findPageList(distributionRsParam);
        if (distributionResult != null && CollectionUtils.isNotEmpty(distributionResult.getData())) {
            distributionRsParam = distributionResult.getData().get(NumberConst.IntDef.INT_ZERO);
            PartnerRsParam partnerRsParam = new PartnerRsParam();
            partnerRsParam.setPartnerId(distributionRsParam.getPartnerId());
            //根据合伙人ID查询合伙人信息
            BaseRestPaginationResult<PartnerRsParam> partnerResult = agifPartnerService.findPageList(partnerRsParam);
            if (partnerResult != null && CollectionUtils.isNotEmpty(partnerResult.getData())) {
                rsResult = new AgentRelationRsResult();
                partnerRsParam = partnerResult.getData().get(NumberConst.IntDef.INT_ZERO);
                rsResult.setAgentId(partnerRsParam.getPartnerId());
                rsResult.setAgentCode(partnerRsParam.getPartnerCode());
                rsResult.setAgentName(partnerRsParam.getPartnerName());
                rsResult.setRoleType("partner");
            }
        }
        return rsResult;
    }*/

}
