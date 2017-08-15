package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0408IParam;
import com.bms.slpd.bean.result.SLPD0408IResult;
import com.bms.slpd.services.SLPD0408IService;
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
@Api(description = "修改品牌与品牌所有人关系",
        tags = "SLPD0408IRestController")
public class SLPD0408IRestController extends BaseRestController {
    @Autowired
    private SLPD0408IService slpd0408IService;

    @ApiOperation(value = "修改品牌与品牌所有人关系",
            notes = "beans传入参数,target为指定修改字段.根据beans和target修改品牌与品牌所有人关系")
    @RequestMapping(value = "/brand/owner/relations/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0408IResult modifyBrandOwnerRelations(@RequestBody SLPD0408IParam restRequest) {

        SLPD0408IResult slpd0408IResult = slpd0408IService.updateBrandOwnerRelations(restRequest);

        slpd0408IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0408IResult;
    }

}
