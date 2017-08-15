package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0202IParam;
import com.bms.slpd.bean.result.SLPD0202IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.services.SLPD0202IService;
import com.bms.slpd.validator.SLPD0202IValidator;
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
@Api(description = "新增品种",
        tags = "SLPD0202IRestController")
public class SLPD0202IRestController extends BaseRestController {

    @Autowired
    private SLPD0202IService slpd0202IService;

    @ApiOperation(value = "新增品种",
            notes = "传入参数bean,功能标识insertFlg为必须字段.根据insertFlg分为以下四个功能." +
                    "功能一:单独新增一级分类:必须传入classesName,其他值必须为空." +
                    "功能二:单独新增二级分类:必须传入machiningName和classesId,其他值必须为空." +
                    "功能三:单独新增品种:必须传入classesId,machiningId,breedSalesName,可选择字段:breedScientificName,breedLocalName,stdTypeList.其他字段必须为空." +
                    "功能四:同时新增一级分类,二级分类,品种(快速录入):必须传入classesName.machiningName,breedSalesName,可选择字段:breedScientificName,breedLocalName,stdTypeList.其他字段必须为空")
    @RequestMapping(value = "/classes/machinings/breeds/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0202IValidator.class)
    public SLPD0202IResult addClassesMachiningsBreeds(@RequestBody SLPD0202IParam requestParam) {
        SLPD0202IResult slpd0202IResult = slpd0202IService.saveBreedsByFlg(requestParam);
        return slpd0202IResult;
    }

}
