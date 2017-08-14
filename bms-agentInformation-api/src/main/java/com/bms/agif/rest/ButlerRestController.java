package com.bms.agif.rest;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerRsParam;
import com.bms.agif.service.AgifButlerAccountService;
import com.bms.agif.service.AgifButlerService;
import com.bms.agif.validator.ButlerAddValidator;
import com.bms.agif.validator.ButlerUpdateValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao_zhifa on 2017/3/2.
 */
@RestController
@Api(value = "bms-agent-info", description = "冻品管家基本信息接口", position = 1, tags = "ButlerRestController")
public class ButlerRestController extends BaseRestController {

    @Autowired
    private AgifButlerService agifButlerService;
    @Autowired
    private AgifButlerAccountService agifButlerAccountService;

    @ApiOperation(value = "冻品管家基本信息新增", notes = "冻品管家基本信息新增")
    @RequestMapping(value = "/butler/basic/_add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerAddValidator.class)
    public String add(@RequestBody ButlerRsParam butlerRsParam) {

        return agifButlerService.insertButlerAndAddress(butlerRsParam);

    }

    @ApiOperation(value = "冻品管家基础信息批量新增操作",
            notes = "冻品管家基础信息批量新增操作",
            position = 5)
    @RequestMapping(value = "/butler/batchSave",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public List batchSave(@RequestBody List<ButlerRsParam> paramList){
        List list = new ArrayList();
        for (ButlerRsParam butlerRsParam : paramList){
            try {
                add(butlerRsParam);
            }catch (Exception e){
                list.add(butlerRsParam.getTelNo());
            }finally {
                continue;
            }
        }
        return list;
    }

    @ApiOperation(value = "冻品管家基本信息修改", notes = "冻品管家基本信息修改")
    @RequestMapping(value = "/butler/basic/_update", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerUpdateValidator.class)
    public Integer update(@RequestBody BaseBean<ButlerRsParam, ButlerRsParam> butlerRsParam) {
        return agifButlerService.updateButler(butlerRsParam);
    }

    @ApiOperation(value = "冻品管家基本信息查询", notes = "冻品管家基本信息查询")
    @RequestMapping(value = "/butler/basic/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    BaseRestPaginationResult<ButlerRsParam> find(@RequestBody ButlerRsParam butlerRsParam) {
        butlerRsParam.setAccountName(DbUtils.buildLikeCondition(butlerRsParam.getAccountName(), DbUtils.LikeMode.PARTIAL));
        butlerRsParam.setTelNo(DbUtils.buildLikeCondition(butlerRsParam.getTelNo(), DbUtils.LikeMode.PARTIAL));
        butlerRsParam.setButlerCode(DbUtils.buildLikeCondition(butlerRsParam.getButlerCode(), DbUtils.LikeMode.PARTIAL));
        butlerRsParam.setButlerName(DbUtils.buildLikeCondition(butlerRsParam.getButlerName(), DbUtils.LikeMode.PARTIAL));
        butlerRsParam.setAgentCode(DbUtils.buildLikeCondition(butlerRsParam.getAgentCode(), DbUtils.LikeMode.PARTIAL));
        butlerRsParam.setAgentName(DbUtils.buildLikeCondition(butlerRsParam.getAgentName(), DbUtils.LikeMode.PARTIAL));
        return agifButlerService.findPageList(butlerRsParam);
    }
}
