package com.bms.agif.rest;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.PartnerAgentPageRsParam;
import com.bms.agif.bean.param.PartnerRsParam;
import com.bms.agif.service.AgifPartnerService;
import com.bms.agif.validator.PartnerAddValidator;
import com.bms.agif.validator.PartnerUpdateValidator;
import com.bms.fms.notice.FmsNotice;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.CollectionUtils;
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
 * Created by yuan_zhifei on 2017/3/2.
 */
@RestController
@Api(value = "bms-agif-api", description = "销售合伙人基本信息", position = 1, tags = "PartnerRestController")
public class PartnerRestController extends BaseRestController {
    @Autowired
    private AgifPartnerService partnerService;
    @Autowired
    private FmsNotice fmsNotice;

    @ApiOperation(value = "销售合伙人基本信息新增", notes = "销售合伙人基本信息新增", position = 1)
    @RequestMapping(value = "/partner/basic/_add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = PartnerAddValidator.class)
    public String addPartner(@RequestBody PartnerRsParam partnerRsParam) {
        String partnerId = partnerService.insertPartnerAndAddress(partnerRsParam);
        if (!StringUtils.isEmpty(partnerId)) {
            fmsNotice.sendPartner(partnerId);
        }
        return partnerId;
    }

    @ApiOperation(value = "销售合伙人基本信息编辑", notes = "销售合伙人基本信息编辑", position = 2)
    @RequestMapping(value = "/partner/basic/_update", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = PartnerUpdateValidator.class)
    public Integer updatePartner(@RequestBody BaseBean<PartnerRsParam, PartnerRsParam> baseBean) {


        PartnerRsParam partnerRsParam = new PartnerRsParam();
        partnerRsParam.setPartnerId(baseBean.getFilter().getPartnerId());

        BaseRestPaginationResult<PartnerRsParam> partnerList = this.partnerService.findPageList(partnerRsParam);
        int result = this.partnerService.updateAgifPartner(baseBean);

        PartnerRsParam taget = baseBean.getTarget();
        Boolean delFlg = baseBean.getTarget().isDelFlg();
        String partnerId = baseBean.getTarget().getPartnerId();
        if (CollectionUtils.isNotEmpty(partnerList.getData())) {
            if (!delFlg) {
                if (CollectionUtils.isNotEmpty(partnerList.getData())) {
                    PartnerRsParam partnerResult = partnerList.getData().get(0);
                    if ((null != taget.getTelNo()&&(!taget.getTelNo().equals(partnerResult.getTelNo())))
                            || (null != taget.getAccountName() &&(!taget.getAccountName().equals(partnerResult.getAccountName())))
                            || (null != taget.getPartnerName() &&(!taget.getPartnerName().equals(partnerResult.getPartnerName())))
                            || (null != taget.getProvinceId() &&(!taget.getProvinceId().equals(partnerResult.getProvinceId())))
                            || (null != taget.getCityId() &&(!taget.getCityId().equals(partnerResult.getCityId())))
                            || (null != taget.getDistrictId() &&(!taget.getDistrictId().equals(partnerResult.getDistrictId())))
                            || (null != taget.getStreetId() &&(!taget.getStreetId().equals(partnerResult.getStreetId())))
                            || (null != taget.getPartnerAddr() &&(!taget.getPartnerAddr().equals(partnerResult.getPartnerAddr())))
                            || (null != taget.getCategoryCode() &&(!taget.getCategoryCode().equals(partnerResult.getCategoryCode())))
                            ){
                        if (StringUtils.isNotEmpty(partnerId)) {
                            fmsNotice.sendPartner(partnerId);
                        }
                    }
                }

            }
        }

        return result;
    }

    @ApiOperation(value = "销售合伙人基本信息查询", notes = "销售合伙人基本信息查询", position = 3)
    @RequestMapping(value = "/partner/basic/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<PartnerRsParam> searchPartner(@RequestBody PartnerRsParam partnerRsParam) {
        partnerRsParam.setAccountName(DbUtils.buildLikeCondition(partnerRsParam.getAccountName(), DbUtils.LikeMode.PARTIAL));
        partnerRsParam.setTelNo(DbUtils.buildLikeCondition(partnerRsParam.getTelNo(), DbUtils.LikeMode.PARTIAL));
        partnerRsParam.setPartnerName(DbUtils.buildLikeCondition(partnerRsParam.getPartnerName(), DbUtils.LikeMode.PARTIAL));
        partnerRsParam.setPartnerCode(DbUtils.buildLikeCondition(partnerRsParam.getPartnerCode(), DbUtils.LikeMode.PARTIAL));
        BaseRestPaginationResult<PartnerRsParam> result = this.partnerService.findPageList(partnerRsParam);
        return result;
    }

    @ApiOperation(value = "销售合伙人配送站领地买手信息查询", notes = "销售合伙人配送站领地买手信息查询", position = 4)
    @RequestMapping(value = "/partner/agent/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<PartnerAgentPageRsParam> searchDistributionDemesne(@RequestBody PartnerAgentPageRsParam agentPageRsParam) {
        agentPageRsParam.setLgcsAreaName(DbUtils.buildLikeCondition(agentPageRsParam.getLgcsAreaName(), DbUtils.LikeMode.PARTIAL));
        agentPageRsParam.setZoneName(DbUtils.buildLikeCondition(agentPageRsParam.getZoneName(), DbUtils.LikeMode.PARTIAL));
        agentPageRsParam.setDistributionCode(DbUtils.buildLikeCondition(agentPageRsParam.getDistributionCode(), DbUtils.LikeMode.PARTIAL));
        agentPageRsParam.setDistributionName(DbUtils.buildLikeCondition(agentPageRsParam.getDistributionName(), DbUtils.LikeMode.PARTIAL));
        agentPageRsParam.setDemesneCode(DbUtils.buildLikeCondition(agentPageRsParam.getDemesneCode(), DbUtils.LikeMode.PARTIAL));
        agentPageRsParam.setDemesneName(DbUtils.buildLikeCondition(agentPageRsParam.getDemesneName(), DbUtils.LikeMode.PARTIAL));
        agentPageRsParam.setAgentCode(DbUtils.buildLikeCondition(agentPageRsParam.getAgentCode(), DbUtils.LikeMode.PARTIAL));
        agentPageRsParam.setAgentName(DbUtils.buildLikeCondition(agentPageRsParam.getAgentName(), DbUtils.LikeMode.PARTIAL));
        agentPageRsParam.setTelNo(DbUtils.buildLikeCondition(agentPageRsParam.getTelNo(), DbUtils.LikeMode.PARTIAL));
        BaseRestPaginationResult<PartnerAgentPageRsParam> result = this.partnerService.findAgentPageList(agentPageRsParam);
        return result;
    }
}
