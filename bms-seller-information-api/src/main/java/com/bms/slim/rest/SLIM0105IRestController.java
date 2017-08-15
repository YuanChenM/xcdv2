package com.bms.slim.rest;

import com.bms.slim.bean.entity.SlimSellerBusinessQualification;
import com.bms.slim.bean.param.SLIM0105IParam;
import com.bms.slim.bean.result.SLIM0105IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0105IService;
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
@Api(tags = "SLIM0105IRestController", description = "查询卖家经营资质(内部接口)")
public class SLIM0105IRestController extends BaseRestController {

    @Autowired
    private SLIM0105IService slim0105IService;

    @ApiOperation(value = "查询卖家经营资质(内部接口)",
            notes = "根据entitySellerId查询对应的卖家经营资质")
    @RequestMapping(value = "/sellers/business/qualifications/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0105IResult addSBQs(@RequestBody SLIM0105IParam entitySellerId) {
        SlimSellerBusinessQualification entityResult = slim0105IService.findSBQ(entitySellerId);
        SLIM0105IResult result = new SLIM0105IResult();
        result.setMessages(new String[]{MessageConstant.SUCCESS});
        result.setData(entityResult);
        return result;
    }
}
