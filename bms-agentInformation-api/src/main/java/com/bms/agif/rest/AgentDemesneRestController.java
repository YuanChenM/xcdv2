package com.bms.agif.rest;

import com.bms.agif.bean.param.AgentDemesnePageParam;
import com.bms.agif.bean.param.AgentDemesneParam;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.result.AgentDemesneResult;
import com.bms.agif.service.AgifAgentDemesneService;
import com.bms.agif.validator.AgentDemesneAddValidator;
import com.bms.agif.validator.AgentDemesneDeleteValidator;
import com.bms.agif.validator.AgentDemesneUpdateValidator;
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
 * Created by guan_zhongheng on 2017/3/2.
 */
@RestController
@Api(value = "bms-agif-api",
        description = "买手领地信息操作",
        position = 1,
        tags = "AgifAgentDemesneRestController")
public class AgentDemesneRestController extends BaseRestController {

    @Autowired
    private AgifAgentDemesneService agifAgentDemesneService;

    @ApiOperation(value = "买手领地关联信息查询操作",
            notes = "买手领地关联信息查询操作",
            position = 5)
    @RequestMapping(value = "/agent/demesne/_search",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseRestPaginationResult<AgentDemesneResult> search(@RequestBody AgentDemesnePageParam param){

        if (StringUtils.isNotEmpty(param.getLgcsAreaName())) {
            param.setLgcsAreaName(DbUtils.buildLikeCondition(param.getLgcsAreaName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getZoneName())) {
            param.setZoneName(DbUtils.buildLikeCondition(param.getZoneName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getDistributionCode())) {
            param.setDistributionCode(DbUtils.buildLikeCondition(param.getDistributionCode(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getDistributionName())) {
            param.setDistributionName(DbUtils.buildLikeCondition(param.getDistributionName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getAuthorizedPartner())) {
            param.setAuthorizedPartner(DbUtils.buildLikeCondition(param.getAuthorizedPartner(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getAuthorizedAgent())) {
            param.setAuthorizedAgent(DbUtils.buildLikeCondition(param.getAuthorizedAgent(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getDemesneCode())) {
            param.setDemesneCode(DbUtils.buildLikeCondition(param.getDemesneCode(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getDemesneName())) {
            param.setDemesneName(DbUtils.buildLikeCondition(param.getDemesneName(), DbUtils.LikeMode.PARTIAL));
        }
        return agifAgentDemesneService.findPageList(param);
    }

    @ApiOperation(value = "买手领地关联新增操作",
            notes = "买手领地关联新增操作",
            position = 5)
    @RequestMapping(value = "/agent/demesne/_add",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = AgentDemesneAddValidator.class)
    public Long add(@RequestBody AgentDemesneParam param){
        // 新增之前先刪除數據
        // 前台界面过来的信息新增关系 此处要同步更新区划领地的买手信息


        return agifAgentDemesneService.addAgifAgentDemesneInfo(param);
    }

    @ApiOperation(value = "买手领地关联修改操作",
            notes = "买手领地关联修改操作",
            position = 5)
    @RequestMapping(value = "/agent/demesne/_update",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = AgentDemesneUpdateValidator.class)
    public void update(@RequestBody BaseBean<AgentDemesneParam, AgentDemesneParam> param){
        agifAgentDemesneService.updateAgifAgentDemesneInfo(param);
    }

    @ApiOperation(value = "买手领地关联物流删除操作",
            notes = "买手领地关联物流删除操作",
            position = 5)
    @RequestMapping(value = "/agent/demesne/_delete",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = AgentDemesneDeleteValidator.class)
    public void delete(@RequestBody AgentDemesneParam param){
        agifAgentDemesneService.deleteAgifAgentDemesneInfo(param);
    }

}
