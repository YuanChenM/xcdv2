package com.bms.slpd.rest;


import com.bms.slpd.bean.param.SLPD0614IParam;
import com.bms.slpd.bean.result.SLPD0614IResult;
import com.bms.slpd.services.SLPD0614IService;
import com.bms.slpd.utils.MessageUtils;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ding_guangjian on 2016/12/8.
 */
@RestController
@Api(description = "查询通用质量标准指标",
        tags = "SLPD0614IRestController")
public class SLPD0614IRestController extends BaseRestController {
    @Autowired
    private SLPD0614IService slpd0614IService;

    @ApiOperation(value = "查询通用质量标准指标",
            notes = "filter传入breedIds,findAllFlag,productIds查询通用质量标准指标,传入productIds时查询差异卡与标准卡信息,传入breedIds时,当findAllFlag等于1时,查询差异卡与标准卡,否则只查询标准卡,当参数同时传入时,只根据productIds查询")
    @RequestMapping(value = "/products/universal/quality/standards/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0614IResult findGnqStandards(@RequestBody SLPD0614IParam param) {
        SLPD0614IResult slpd = slpd0614IService.findDifAndStdGnq(param);
        slpd.setMessage(MessageUtils.getSuccessMessage());
        return slpd;
    }

}
