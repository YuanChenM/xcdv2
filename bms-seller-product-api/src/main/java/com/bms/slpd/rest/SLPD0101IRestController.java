package com.bms.slpd.rest;

import com.bms.slpd.bean.entity.SlpdClasses;
import com.bms.slpd.bean.param.SLPD0101IParam;
import com.bms.slpd.bean.result.SLPD0101IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.services.SLPD0101IService;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(description = "查询产品一级分类", tags = "SLPD0101IRestController")
public class SLPD0101IRestController extends BaseRestController {

    @Autowired
    private SLPD0101IService slpdClassesService;

    @ApiOperation(value = "查询产品一级分类",
            notes = "根据classesIds,classesCodes,classesName,delFlg,auditStu查询对应的产品一级分类信息")
    @RequestMapping(value = "/classes/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0101IResult findClasses(@RequestBody SLPD0101IParam requestParam) {

        List<SlpdClasses> results = slpdClassesService.findClasses(requestParam);
        SLPD0101IResult slpd0101IRsResult = new SLPD0101IResult();
        slpd0101IRsResult.setClassesList(results);
        slpd0101IRsResult.setMessage(new String[]{MessageConstant.SUCCESS});

        return slpd0101IRsResult;
    }
}
