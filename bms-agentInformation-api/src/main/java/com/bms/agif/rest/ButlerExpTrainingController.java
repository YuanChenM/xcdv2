package com.bms.agif.rest;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerExpTrainingRsParam;
import com.bms.agif.service.AgifButlerExpTrainingService;
import com.bms.agif.validator.ButlerExpTrainingAddValidator;
import com.bms.agif.validator.ButlerExpTrainingUpdateValidator;
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
@Api(value = "bms-agif-api", description = "管家培训经历信息", position = 1, tags = "ButlerExpTrainingController")
public class ButlerExpTrainingController extends BaseRestController {

    @Autowired
    private AgifButlerExpTrainingService butlerExpTrainingService;

    @ApiOperation(value = "管家培训经历信息查询", notes = "管家培训经历信息查询")
    @RequestMapping(value = "/butler/train/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<ButlerExpTrainingRsParam> search(@RequestBody ButlerExpTrainingRsParam param) {
        /*buyerAllRsParam.setBossName(DbUtils.buildLikeCondition(buyerAllRsParam.getBossName(), DbUtils.LikeMode.PARTIAL));*/
        BaseRestPaginationResult<ButlerExpTrainingRsParam> expTraining = butlerExpTrainingService.findPageList(param);
        return expTraining;
    }


    @ApiOperation(value = "管家培训经历信息新增", notes = "管家培训经历信息新增")
    @RequestMapping(value = "/butler/train/_add", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerExpTrainingAddValidator.class)
    public Integer add(@RequestBody ButlerExpTrainingRsParam param) {
        Integer result = butlerExpTrainingService.saveExpTraining(param);
        return result;
    }

    @ApiOperation(value = "管家培训经历信息更新", notes = "管家培训经历信息更新")
    @RequestMapping(value = "/butler/train/_update", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerExpTrainingUpdateValidator.class)
    public Integer update(@RequestBody BaseBean<ButlerExpTrainingRsParam, ButlerExpTrainingRsParam> updateRsParam) {
        Integer resultCount = butlerExpTrainingService.updateExpTraining(updateRsParam);
        return resultCount;
    }

}
