package com.bms.agif.rest;

import com.alibaba.fastjson.TypeReference;
import com.bms.agif.bean.entity.AgifPartnerDistribution;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.LogisDistributionRsParm;
import com.bms.agif.bean.param.PartnerDistributionRsParam;
import com.bms.agif.constant.ApiUrlDef;
import com.bms.agif.service.AgifPartnerDistributionService;
import com.bms.agif.validator.PartnerDistributionAddValidator;
import com.bms.agif.validator.PartnerDistributionUpdateValidator;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yuan_zhifei on 2017/3/2.
 */
@RestController
@Api(value = "bms-agif-api", description = "合伙人配送站信息", position = 1, tags = "PartnerDistributionRestController")
public class PartnerDistributionRestController extends BaseRestController {
    @Autowired
    private RestApiClientFactory restApiClientFactory;
    @Autowired
    private AgifPartnerDistributionService distributionService;

    @ApiOperation(value = "销售合伙人配送站信息新增", notes = "销售合伙人配送站信息新增", position = 1)
    @RequestMapping(value = "/partner/distribution/_add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = PartnerDistributionAddValidator.class)
    public Integer addPartnerDistribution(@RequestBody List<PartnerDistributionRsParam> distributionRsParams) {
        int result = NumberConst.IntDef.INT_ZERO;
        PartnerDistributionRsParam distributionRsParam = null;
        List<AgifPartnerDistribution> partnerDistributions = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(distributionRsParams)) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < distributionRsParams.size(); i++) {
                distributionRsParam = distributionRsParams.get(i);
                //验证合伙人是否已绑定过此配送站
                result = this.distributionService.findDistributionIsExist(distributionRsParam);
                if (result > NumberConst.IntDef.INT_ZERO) {
                    continue;
                } else {
                    result = this.distributionService.saveDistribution(distributionRsParam);
                }
            }
        }
        return result;
    }

    /**
     * 验证合伙人是否已绑定过其他物流区配送站配送站
     *
     * @param
     * @return
     */
    /*private int checkParams(List<PartnerDistributionRsParam> distributionRsParams) {
        PartnerDistributionRsParam distributionRsParam = null;
        int result = NumberConst.IntDef.INT_ZERO;
        for (int i = NumberConst.IntDef.INT_ZERO; i < distributionRsParams.size(); i++) {
            distributionRsParam = distributionRsParams.get(i);
            result = this.distributionService.findLgcsAreaIsExist(distributionRsParam);
        }
        return result;
    }*/
    @ApiOperation(value = "销售合伙人配送站信息编辑", notes = "销售合伙人配送站信息编辑", position = 2)
    @RequestMapping(value = "/partner/distribution/_update", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = PartnerDistributionUpdateValidator.class)
    public Integer updatePartnerDistribution(@RequestBody BaseBean<PartnerDistributionRsParam, PartnerDistributionRsParam> baseBean) {
        BaseBean<AgifPartnerDistribution, AgifPartnerDistribution> distributionBaseBean = new BaseBean<>();
        String loginUserId = this.distributionService.getLoginUserId();
        Date currentDate = DateUtils.getCurrent();
        AgifPartnerDistribution distributionFilter = BeanUtils.toBean(baseBean.getFilter(), AgifPartnerDistribution.class);
        AgifPartnerDistribution distributionTarget = BeanUtils.toBean(baseBean.getTarget(), AgifPartnerDistribution.class);
        distributionTarget.setUpdId(loginUserId);
        distributionTarget.setUpdTime(currentDate);
        distributionTarget.setCrtId(loginUserId);
        distributionTarget.setCrtTime(currentDate);
        distributionBaseBean.setFilter(distributionFilter);
        distributionBaseBean.setTarget(distributionTarget);
        int result = this.distributionService.modify(distributionBaseBean);
        return result;
    }

    @ApiOperation(value = "销售合伙人配送站信息删除", notes = "销售合伙人配送站信息删除", position = 3)
    @RequestMapping(value = "/partner/distribution/_delete", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer deletePartnerDistribution(@RequestBody PartnerDistributionRsParam distributionRsParam) {
        //查询物流区配送站授权合伙人信息
        LogisDistributionRsParm logisDistributionRsParm = new LogisDistributionRsParm();
        logisDistributionRsParm.setDistributionId(distributionRsParam.getDistributionId());
        //String searchUrl = ApiUrlDef.REGION_ENV + ApiUrlDef.REGION.distributionSearch;
        String searchUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.REGN_MODULE, ApiUrlDef.REGION.distributionSearch);
        RestApiClient searchRestApiClient = restApiClientFactory.newApiRestClient();
        BaseRestPaginationResult<LogisDistributionRsParm> searchResult = searchRestApiClient.post(searchUrl,
                logisDistributionRsParm, new TypeReference<BaseRestPaginationResult<LogisDistributionRsParm>>() {
                });
        logisDistributionRsParm = searchResult.getData().get(NumberConst.IntDef.INT_ZERO);
        if (StringUtils.isNotEmpty(logisDistributionRsParm.getAuthorizedPartner())) {
            if (logisDistributionRsParm.getAuthorizedPartner().contains(distributionRsParam.getPartnerName())) {
                String authorizedPartner = logisDistributionRsParm.getAuthorizedPartner().replace(distributionRsParam.getPartnerName(), "");
                if (logisDistributionRsParm.getAuthorizedPartner().indexOf(distributionRsParam.getPartnerName() + ",") > 0) {
                    authorizedPartner = logisDistributionRsParm.getAuthorizedPartner().replace(distributionRsParam.getPartnerName() + ",", "");
                }else if (logisDistributionRsParm.getAuthorizedPartner().indexOf("," + distributionRsParam.getPartnerName()) > 0) {
                    authorizedPartner = logisDistributionRsParm.getAuthorizedPartner().replace("," + distributionRsParam.getPartnerName(), "");
                }
               /* authorizedPartner = logisDistributionRsParm.getAuthorizedPartner().replace(distributionRsParam.getPartnerName() + ",", "");
                authorizedPartner = logisDistributionRsParm.getAuthorizedPartner().replace("," + distributionRsParam.getPartnerName(), "");*/
                distributionRsParam.setAuthorizedPartner(authorizedPartner);
            }
        }
        //更新物流区配送站授权合伙人信息
        BaseBean<LogisDistributionRsParm, LogisDistributionRsParm> baseBean = new BaseBean<>();
        LogisDistributionRsParm distributionParmFilter = new LogisDistributionRsParm();
        distributionParmFilter.setDistributionId(distributionRsParam.getDistributionId());
        LogisDistributionRsParm distributionParmTarget = new LogisDistributionRsParm();
        distributionParmTarget.setAuthorizedPartner(distributionRsParam.getAuthorizedPartner());
        distributionParmTarget.setDistributionType(logisDistributionRsParm.getDistributionType());
        distributionParmTarget.setDistributionName(logisDistributionRsParm.getDistributionName());
        distributionParmTarget.setDistributionCode(logisDistributionRsParm.getDistributionCode());
        distributionParmTarget.setDisableFlg(StringUtils.toString(NumberConst.IntDef.INT_TWO));
        baseBean.setFilter(distributionParmFilter);
        baseBean.setTarget(distributionParmTarget);
        //String url = ApiUrlDef.REGION_ENV + ApiUrlDef.REGION.distributionUpdate;
        String url = ConfigServerUtils.getAPIUrl(ApiUrlDef.REGN_MODULE, ApiUrlDef.REGION.distributionUpdate);
        RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
        Integer updateResult = restApiClient.post(url, baseBean, new TypeReference<Integer>() {
        });
        int result = this.distributionService.remove(distributionRsParam);
        return result;
    }

    @ApiOperation(value = "销售合伙人配送站信息查询", notes = "销售合伙人配送站信息查询", position = 4)
    @RequestMapping(value = "/partner/distribution/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<PartnerDistributionRsParam> searchPartnerDistribution(@RequestBody PartnerDistributionRsParam distributionRsParam) {
        distributionRsParam.setLgcsAreaName(DbUtils.buildLikeCondition(distributionRsParam.getLgcsAreaName(), DbUtils.LikeMode.PARTIAL));
        distributionRsParam.setZoneName(DbUtils.buildLikeCondition(distributionRsParam.getZoneName(), DbUtils.LikeMode.PARTIAL));
        distributionRsParam.setDistributionCode(DbUtils.buildLikeCondition(distributionRsParam.getDistributionCode(), DbUtils.LikeMode.PARTIAL));
        distributionRsParam.setDistributionName(DbUtils.buildLikeCondition(distributionRsParam.getDistributionName(), DbUtils.LikeMode.PARTIAL));
        BaseRestPaginationResult<PartnerDistributionRsParam> result = this.distributionService.findPageList(distributionRsParam);
        return result;
    }
}
