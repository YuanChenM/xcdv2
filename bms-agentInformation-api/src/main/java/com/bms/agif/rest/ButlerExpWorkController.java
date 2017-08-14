package com.bms.agif.rest;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerExpWorkRsParam;
import com.bms.agif.service.AgifButlerExpWorkService;
import com.bms.agif.validator.ButlerExpWorkAddValidator;
import com.bms.agif.validator.ButlerExpWorkUpdateValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
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
 * Created by zhao_chen  on 2017/3/2.
 */
@RestController
@Api(value = "bms-agif-api", description = "管家工作经历信息", position = 1, tags = "ButlerExpWorkController")
public class ButlerExpWorkController extends BaseRestController {

    @Autowired
    private AgifButlerExpWorkService butlerExpWorkService;

    @ApiOperation(value = "管家工作经历信息查询", notes = "管家工作经历信息查询")
    @RequestMapping(value = "/butler/work/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<ButlerExpWorkRsParam> search(@RequestBody ButlerExpWorkRsParam param) {
        /*buyerAllRsParam.setBossName(DbUtils.buildLikeCondition(buyerAllRsParam.getBossName(), DbUtils.LikeMode.PARTIAL));*/
        BaseRestPaginationResult<ButlerExpWorkRsParam> basicRsResult = butlerExpWorkService.findPageList(param);
        return basicRsResult;
    }

    @ApiOperation(value = "管家工作经历信息新增", notes = "管家工作经历信息新增")
    @RequestMapping(value = "/butler/work/_add", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerExpWorkAddValidator.class)
    public Integer add(@RequestBody ButlerExpWorkRsParam param) {
        Integer result = butlerExpWorkService.saveExpWork(param);
        return result;
    }

    @ApiOperation(value = "管家工作经历信息更新", notes = "管家工作经历信息更新")
    @RequestMapping(value = "/butler/work/_update", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerExpWorkUpdateValidator.class)
    public Integer update(@RequestBody BaseBean<ButlerExpWorkRsParam, ButlerExpWorkRsParam> updateRsParam) {
        Integer resultCount = butlerExpWorkService.updateExpWork(updateRsParam);
        return resultCount;
    }

}
