package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0407IParam;
import com.bms.slpd.bean.result.SLPD0407IResult;
import com.bms.slpd.services.SLPD0407IService;
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
@Api(description = "新增品牌与品牌所有人关系",
        tags = "SLPD0407IRestController")
public class SLPD0407IRestController extends BaseRestController {
    @Autowired
    private SLPD0407IService slpd0407IService;

    @ApiOperation(value = "新增品牌与品牌所有人关系",
            notes = "传入bean参数列表,新增数据")
    @RequestMapping(value = "/brand/owner/relations/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0407IResult addBrandOwnerRelations(@RequestBody SLPD0407IParam param) {
        SLPD0407IResult slpd0407IResult = slpd0407IService.saveBrandOwnerRelation(param.getBeans());

        slpd0407IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0407IResult;
    }

}
