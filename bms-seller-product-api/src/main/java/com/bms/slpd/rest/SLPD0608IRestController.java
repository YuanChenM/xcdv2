package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0608IParam;
import com.bms.slpd.bean.result.SLPD0608IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.services.SLPD0608IService;
import com.bms.slpd.utils.MessageUtils;
import com.framework.base.rest.RestResponse;
import com.framework.base.rest.SearchRestRequest;
import com.framework.boot.base.BaseRestController;
import com.framework.i18n.util.MessageManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "查询加工技术标准指标",tags = "SLPD0608IRestController")
public class SLPD0608IRestController extends BaseRestController {
    @Autowired
    private SLPD0608IService slpd0608IService;

    @ApiOperation(value = "查询加工技术标准档案卡(差异卡)信息",
            notes = "1.传入breedIds则查询加工技术标准档案卡信息" +
                    "2.传入productIds则查询加工技术标准档案差异卡信息")
    @RequestMapping(value = "/products/process/technology/standards/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0608IResult findMctStdsAndDifStds(@RequestBody SLPD0608IParam requestParam) {
        SLPD0608IResult result = slpd0608IService.findMctStdsAndDifStds(requestParam);
        result.setMessage(MessageUtils.getSuccessMessage());
        return result;
    }
}
