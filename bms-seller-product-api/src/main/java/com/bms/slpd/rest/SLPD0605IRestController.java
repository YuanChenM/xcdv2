package com.bms.slpd.rest;


import com.bms.slpd.bean.param.SLPD0605IParam;
import com.bms.slpd.bean.result.SLPD0605IResult;
import com.bms.slpd.services.SLPD0605IService;
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


@RestController
@Api(description = "查询饲养标准指标",tags = "Slpd0605IRestController")
public class SLPD0605IRestController extends BaseRestController {
    @Autowired
    private SLPD0605IService slpd0605IService;

    @ApiOperation(value = "查询饲养标准指标",
            notes = "filter传入breedIds,findAllFlag,productIds查询饲养标准指标信息,传入productIds时查询差异卡与标准卡信息,传入breedIds时,当findAllFlag等于1时,查询差异卡与标准卡,否则只查询标准卡,当参数同时传入时,只根据productIds查询")
    @RequestMapping(value = "/products/feed/standards/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0605IResult findFedStandards(@RequestBody SLPD0605IParam param) {
        SLPD0605IResult slpd = slpd0605IService.searchDifAndStdFeds(param);
        slpd.setMessage(MessageUtils.getSuccessMessage());
        return slpd;
    }
}
