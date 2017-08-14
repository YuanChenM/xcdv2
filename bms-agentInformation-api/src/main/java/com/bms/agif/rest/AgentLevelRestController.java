package com.bms.agif.rest;

import com.bms.agif.bean.param.AgentLevelRsParam;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.result.AgentLevelRsResult;
import com.bms.agif.service.AgifAgentLevelService;
import com.bms.agif.validator.AgentAddValidator;
import com.bms.agif.validator.AgentLevelAddValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
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
 * Created by yuan_zhifei on 2017/5/12.
 */
@RestController
@Api(value = "bms-agif-api", description = "买手等级信息", position = 1, tags = "AgentLevelRestController")
public class AgentLevelRestController extends BaseRestController {
    @Autowired
    private AgifAgentLevelService agifAgentLevelService;

    @ApiOperation(value = "买手等级信息新增", notes = "买手等级信息新增", position = 1)
    @RequestMapping(value = "/agent/level/_add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = AgentLevelAddValidator.class)
    public AgentLevelRsResult addAgentLevel(@RequestBody AgentLevelRsParam levelRsParam) {
        return agifAgentLevelService.addAgentLevel(levelRsParam);
    }


    @ApiOperation(value = "买手等级信息修改", notes = "买手等级信息修改", position = 2)
    @RequestMapping(value = "/agent/level/_update", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer updateAgentLevel(@RequestBody BaseBean<AgentLevelRsParam, AgentLevelRsParam> baseBean) {
        return agifAgentLevelService.updateAgentLevel(baseBean);
    }

    @ApiOperation(value = "买手等级信息查询", notes = "买手等级信息查询", position = 3)
    @RequestMapping(value = "/agent/level/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<AgentLevelRsResult> searchAgentLevel(@RequestBody AgentLevelRsParam levelRsParam) {
        levelRsParam.setFrequenterAgentF(DbUtils.buildLikeCondition(levelRsParam.getFrequenterAgentF(), DbUtils.LikeMode.PARTIAL));
        levelRsParam.setFrequenterAgentA(DbUtils.buildLikeCondition(levelRsParam.getFrequenterAgentA(), DbUtils.LikeMode.PARTIAL));
        return agifAgentLevelService.findPageList(levelRsParam);
    }
}
