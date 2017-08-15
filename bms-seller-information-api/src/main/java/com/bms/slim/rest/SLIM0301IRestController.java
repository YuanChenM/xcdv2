package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0301IParam;
import com.bms.slim.bean.result.SLIM0301IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0301IService;
import com.bms.slim.utils.MessageUtils;
import com.bms.slim.validator.SLIM0301IValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.i18n.util.MessageManager;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wang_haichun on 2017/1/12.
 */
@RestController
@Api(value = "新增卖家品牌",
        description = "新增卖家品牌",
        tags = "SLIM0301IRestController")
public class SLIM0301IRestController extends BaseRestController {

    @Autowired
    private SLIM0301IService slim0301IService;


    @ApiOperation(value = "新增卖家品牌",notes = "传入bean参数列表,新增数据")
    @RequestMapping(value = "/sellers/brands/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLIM0301IValidator.class)
    public SLIM0301IResult addSellerBrands(@RequestBody SLIM0301IParam slim0301IParam){
        SLIM0301IResult SLIM0301IResult = slim0301IService.add(slim0301IParam.getSellerBreedList());
        SLIM0301IResult.setMessage(MessageUtils.getSuccessMessage());
        return SLIM0301IResult;

    }

















}
