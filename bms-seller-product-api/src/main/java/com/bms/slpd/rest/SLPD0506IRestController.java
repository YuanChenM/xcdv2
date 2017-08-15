package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0506IParam;
import com.bms.slpd.bean.result.SLPD0506IResult;
import com.bms.slpd.services.SLPD0506IService;
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
@Api(description = "查询品牌单品关联",
        tags = "SLPD0506IRestController")
public class SLPD0506IRestController extends BaseRestController {

    @Autowired
    private SLPD0506IService slpd0506IService;

    @ApiOperation(value = "查询品牌单品关联",
            notes = "查询品牌单品关联")
    @RequestMapping(value = "/products/classes/machinings/breeds/brands/items/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0506IResult findBrandItemRelations(@RequestBody SLPD0506IParam restRequest) {
        SLPD0506IResult restResult = null;
        if (restRequest.isLocalCache()) {
            restResult = findBrandItemsByCache(restRequest);
        }
        else {
            restResult = findBrandItemsBySql(restRequest);
        }

        //String[] args = new String[]{MessageManager.getMessage(MessageConstant.Label.BrandItemRelation)};
        //String message = MessageManager.getMessage(MessageConstant.Info.I000001, args);
        //String[] messages = new String[]{message};
        //
        //restResult.setMessage(messages);
        return restResult;
    }

    private SLPD0506IResult findBrandItemsByCache(SLPD0506IParam restRequest) {
        return null;
    }

    private SLPD0506IResult findBrandItemsBySql(SLPD0506IParam restRequest) {
        return this.slpd0506IService.findBrandItemsBySql(restRequest);
    }


}
