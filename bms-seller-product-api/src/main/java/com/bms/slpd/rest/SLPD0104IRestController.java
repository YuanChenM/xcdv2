package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0104IParam;
import com.bms.slpd.bean.result.SLPD0104IResult;
import com.bms.slpd.bean.result.wrapper.SlpdMachiningResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.services.SLPD0104IService;
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
@Api(description = "查询产品二级分类", tags = "SLPD0104IController")
public class SLPD0104IRestController extends BaseRestController {

    @Autowired
    private SLPD0104IService slpd0104IService;

    @ApiOperation(value = "查询产品二级分类",
            notes = "根据classesIds,classesCodes,machiningIds,machiningCodes,classesName,machiningName查询产品二级分类信息,delFlg默认查询所有数据")
    @RequestMapping(value = "/classes/machinings/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0104IResult findMachinings(@RequestBody SLPD0104IParam requestParam) {
        List<SlpdMachiningResult> results = slpd0104IService.findMachinings(requestParam);
        SLPD0104IResult slpd0104IRsResult = new SLPD0104IResult();
        slpd0104IRsResult.setMachiningList(results);
        slpd0104IRsResult.setMessage(new String[]{MessageConstant.SUCCESS});

        return slpd0104IRsResult;
    }

}
