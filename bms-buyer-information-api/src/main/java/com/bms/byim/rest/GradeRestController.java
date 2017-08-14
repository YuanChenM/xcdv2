package com.bms.byim.rest;

import com.bms.byim.bean.param.BuyerAccountRsParam;
import com.bms.byim.bean.param.GradeRsParam;
import com.bms.byim.services.ByimBuyerService;
import com.bms.byim.services.ByimGradeService;
import com.bms.byim.validator.GradeAddValidator;
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
 * Created by yuan_zhifei on 2016/3/21.
 */
@RestController
@Api(value = "bms-byim-api",
        description = "买家定性评级信息",
        position = 1,
        tags = "GradeRestController")
public class GradeRestController extends BaseRestController {
    @Autowired
    private ByimGradeService byimGradeService;
    @Autowired
    private ByimBuyerService byimBuyerService;

    @ApiOperation(value = "买家定性评级信息新增", notes = "买家定性评级信息新增", position = 1)
    @RequestMapping(value = "/buyers/grade/_add", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = GradeAddValidator.class)
    public Integer addFrequenterLevel(@RequestBody GradeRsParam gradeRsParam) {
        return byimGradeService.saveGrade(gradeRsParam);
    }

    @ApiOperation(value = "买家定性评级信息查询", notes = "买家定性评级信息查询", position = 2)
    @RequestMapping(value = "/buyers/grade/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<GradeRsParam> search(@RequestBody GradeRsParam gradeRsParam) {
        gradeRsParam.setGrade(DbUtils.buildLikeCondition(gradeRsParam.getGrade(), DbUtils.LikeMode.PARTIAL));
        if (StringUtils.isEmpty(gradeRsParam.getBuyerId()) && StringUtils.isNotEmpty(gradeRsParam.getBuyerCode())) {
            //通过买家编码查询买家ID
            BuyerAccountRsParam accountRsParam = new BuyerAccountRsParam();
            accountRsParam.setBuyerCode(gradeRsParam.getBuyerCode());
            String buyerId = byimBuyerService.findBuyerId(accountRsParam);
            gradeRsParam.setBuyerId(buyerId);
        }
        return this.byimGradeService.findPageList(gradeRsParam);
    }
}
