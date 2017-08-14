package com.bms.agif.rest;

import com.bms.agif.bean.param.AgentRelationParam;
import com.bms.agif.bean.param.ButlerBuyerRelationRsPageParam;
import com.bms.agif.bean.result.AgentRelationResult;
import com.bms.agif.service.AgifButlerBuyerRelationService;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/10.
 * 买家买手系统群内角色关系管理
 */
@RestController
@Api(value = "bms-agif-api", description = "买家买手系统群内角色关系管理", position = 1, tags = "AgentRelationRestController")
public class AgentRelationRestController extends BaseRestController {
    @Autowired
    private AgifButlerBuyerRelationService agifButlerBuyerRelationService;
    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @ApiOperation(value = "买家买手上级角色查询", notes = "根据ID查询买家买手系统群内部上级角色列表", position = 1)
    @RequestMapping(value = "/agent/relation/_search",
            method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<AgentRelationResult> findAgents(@RequestBody AgentRelationParam param) {
        //List<AgentRelationResult> results = this.agifButlerBuyerRelationService.findPageList(param);
        List<AgentRelationResult> results = new ArrayList<>();
        return results;
    }
}
