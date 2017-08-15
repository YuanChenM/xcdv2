package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0203IParam;
import com.bms.slpd.bean.result.SLPD0203IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.services.SLPD0203IService;
import com.bms.slpd.validator.SLPD0203IValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "修改品种",
        tags = "SLPD0203IRestController")
public class SLPD0203IRestController extends BaseRestController {
    @Autowired
    private SLPD0203IService slpd0203IService;

    @ApiOperation(value = "修改品种",
            notes = "bean为新增的参数!" +
                    "功能一:单独修改一级分类:必须传入classeId,可选择字段:classesName,classesCode,其他值必须为空." +
                    "功能二:单独修改二级分类:必须传入machiningId,可选择字段:machiningName,machiningCode,其他值必须为空." +
                    "功能三:单独修改品种:必须传入classesId,可选择字段:breedCode,breedSalesName,breedScientifucName,breedLocalName,stdTypeList.其他字段必须为空.")
    @RequestMapping(value = "/classes/machinings/breeds/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0203IValidator.class)
    public SLPD0203IResult modifyClassesMachiningsBreeds(@RequestBody SLPD0203IParam restRequest) {

        SLPD0203IResult result = slpd0203IService.updateBreedByFlg(restRequest);

//        result.setMessage(new String[]{MessageConstant.SUCCESS});
        return result;
    }
}
