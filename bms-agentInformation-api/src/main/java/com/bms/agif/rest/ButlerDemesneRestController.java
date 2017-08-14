package com.bms.agif.rest;

import com.bms.agif.bean.entity.AgifButlerDemesne;
import com.bms.agif.bean.param.ButlerDemesneRsParam;
import com.bms.agif.service.AgifButlerDemesneService;
import com.bms.agif.validator.ButlerDemesneAddValidator;
import com.bms.agif.validator.ButlerDemesneDeleteValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tao_zhifa on 2017/3/10.
 */
@RestController
@Api(value = "bms-agent-info", description = "冻品管家领地管理接口", position = 1, tags = "ButlerDemesneRestController")
public class ButlerDemesneRestController extends BaseRestController {

    @Autowired
    private AgifButlerDemesneService agifButlerDemesneService;

    @ApiOperation(value = "冻品管家领地管理新增", notes = "冻品管家领地管理新增")
    @RequestMapping(value = "/butler/demesne/_add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerDemesneAddValidator.class)
    public Integer add(@RequestBody List<ButlerDemesneRsParam> butlerDemesneList) {
        List<AgifButlerDemesne> demesneList = new ArrayList<>();
        int size = butlerDemesneList.size();
        for (int i = 0; i < size; i++) {
            String loginUser =agifButlerDemesneService.getLoginUserId();
            AgifButlerDemesne bean = BeanUtils.toBean(butlerDemesneList.get(i), AgifButlerDemesne.class);
            Date currentDate = DateUtils.getCurrent();
            Long maxId = agifButlerDemesneService.maxId("AGIF_BUTLER_DEMESNE");
            bean.setUpdTime(currentDate);
            bean.setCrtTime(currentDate);
            bean.setUpdId(loginUser);
            bean.setCrtId(loginUser);
            bean.setDelFlg(false);
            bean.setVersion(1);
            bean.setButlerDemesneId(maxId);
            demesneList.add(bean);
        }
        return agifButlerDemesneService.batchSave(demesneList);
    }
//
//    @ApiOperation(value = "冻品管家领地管理删除", notes = "冻品管家领地管理删除")
//    @RequestMapping(value = "/butler/demesne/_delete", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
//    @Validator(validatorClass = ButlerDemesneUpdateValidator.class)
//    public Integer update(@RequestBody ButlerDemesneRsParam butlerDemesneRsParam) {
//        AgifButlerDemesne agifButlerDemesne = BeanUtils.toBean(butlerDemesneRsParam,AgifButlerDemesne.class);
//        int count = agifButlerDemesneService.modify(agifButlerDemesne);
//        return count;
//    }

    @ApiOperation(value = "冻品管家领地管理查询", notes = "冻品管家领地管理查询")
    @RequestMapping(value = "/butler/demesne/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    BaseRestPaginationResult<ButlerDemesneRsParam> find(@RequestBody ButlerDemesneRsParam butlerDemesneRsParam) {
        butlerDemesneRsParam.setLgcsAreaName(DbUtils.buildLikeCondition(butlerDemesneRsParam.getLgcsAreaName(), DbUtils.LikeMode.PARTIAL));
        butlerDemesneRsParam.setZoneName(DbUtils.buildLikeCondition(butlerDemesneRsParam.getZoneName(), DbUtils.LikeMode.PARTIAL));
        butlerDemesneRsParam.setDistributionName(DbUtils.buildLikeCondition(butlerDemesneRsParam.getDistributionName(), DbUtils.LikeMode.PARTIAL));
        butlerDemesneRsParam.setDemesneName(DbUtils.buildLikeCondition(butlerDemesneRsParam.getDemesneName(), DbUtils.LikeMode.PARTIAL));
        butlerDemesneRsParam.setDemesneCode(DbUtils.buildLikeCondition(butlerDemesneRsParam.getDemesneCode(), DbUtils.LikeMode.PARTIAL));
        butlerDemesneRsParam.setAuthorizedPartner(DbUtils.buildLikeCondition(butlerDemesneRsParam.getAuthorizedPartner(), DbUtils.LikeMode.PARTIAL));
        return agifButlerDemesneService.findPageList(butlerDemesneRsParam);
    }

    @ApiOperation(value = "冻品管家领地管理物理删除", notes = "冻品管家领地管理物理删除")
    @RequestMapping(value = "/butler/demesne/_delete", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerDemesneDeleteValidator.class)
    public Integer update(@RequestBody ArrayList<Long> butlerDemesneIdList ) {
        int count = agifButlerDemesneService.remove(butlerDemesneIdList);

        return count;
    }
}
