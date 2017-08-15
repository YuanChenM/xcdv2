package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0617IParam;
import com.bms.slpd.bean.result.SLPD0617IResult;
import com.bms.slpd.services.SLPD0617IService;
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
@Api(description = "查询安全标准指标",tags = "SLPD0617IRestController")
public class SLPD0617IRestController extends BaseRestController {

    @Autowired
    private SLPD0617IService slpd0617IService;

    @ApiOperation(value = "查询安全标准指标(差异)",
            notes = "1.传入breedIds则查询安全标准档案卡信息" +
                    " 2.传入productIds则查询安全标准档案差异卡信息")
    @RequestMapping(value = "/products/safety/standards/_find", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0617IResult findSafetyStds(@RequestBody SLPD0617IParam requestParam) {
        SLPD0617IResult result = slpd0617IService.findSftStdsAndDifStds(requestParam);
        result.setMessage(MessageUtils.getSuccessMessage());
        return result;
    }
}
