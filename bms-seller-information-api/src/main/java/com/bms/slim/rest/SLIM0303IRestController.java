package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0303IParam;
import com.bms.slim.bean.result.SLIM0303IResult;
import com.bms.slim.services.SLIM0303IService;
import com.bms.slim.utils.MessageUtils;
import com.framework.base.rest.RestResponse;
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
 * Created by wang_haichun on 2017/1/13.
 */
@RestController
@Api(description = "修改卖家品牌",
        tags = "SLIM0303IRestController")
public class SLIM0303IRestController extends BaseRestController {

    @Autowired
    private SLIM0303IService slim0303IService;



    @ApiOperation(value = "修改卖家品牌",
            notes = "传入参数,target为指定修改字段.根据target修改品牌")
    @RequestMapping(value = "/sellers/brands/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0303IResult modifyBrandStandards(@RequestBody SLIM0303IParam slim0303IParam) {
        SLIM0303IResult slim0303IResult = slim0303IService.updateSellerBrands(slim0303IParam);
        slim0303IResult.setMessage(MessageUtils.getSuccessMessage());
        return slim0303IResult;
    }

}
