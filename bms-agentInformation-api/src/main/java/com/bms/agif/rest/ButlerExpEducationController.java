package com.bms.agif.rest;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerExpEducationRsParam;
import com.bms.agif.service.AgifButlerExpEducationService;
import com.bms.agif.validator.ButlerExpEducationAddValidator;
import com.bms.agif.validator.ButlerExpEducationUpdateValidator;
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
@Api(value = "bms-agif-api", description = "管家教育经历信息", position = 1, tags = "ButlerExpEducationController")
public class ButlerExpEducationController extends BaseRestController {

    @Autowired
    private AgifButlerExpEducationService butlerExpEducationService;

    @ApiOperation(value = "管家教育经历信息查询", notes = "管家教育经历信息查询")
    @RequestMapping(value = "/butler/education/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<ButlerExpEducationRsParam> search(@RequestBody ButlerExpEducationRsParam param) {
        BaseRestPaginationResult<ButlerExpEducationRsParam> basicRsResult = butlerExpEducationService.findPageList(param);
        return basicRsResult;
    }

    @ApiOperation(value = "管家教育经历信息新增", notes = "管家教育经历信息新增")
    @RequestMapping(value = "/butler/education/_add", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerExpEducationAddValidator.class)
    public Integer add(@RequestBody ButlerExpEducationRsParam param) {
        Integer result = butlerExpEducationService.saveExpEducation(param);
        return result;
    }

    @ApiOperation(value = "管家教育经历信息更新", notes = "管家教育经历信息更新")
    @RequestMapping(value = "/butler/education/_update", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerExpEducationUpdateValidator.class)
    public Integer update(@RequestBody BaseBean<ButlerExpEducationRsParam, ButlerExpEducationRsParam> param ) {
        Integer resultCount = butlerExpEducationService.updateExpEducation(param);
        return resultCount;
    }

}
