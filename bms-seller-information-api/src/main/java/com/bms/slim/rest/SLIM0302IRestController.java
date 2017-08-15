package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0302IParam;
import com.bms.slim.bean.result.SLIM0302IResult;
import com.bms.slim.bean.result.wrapper.SlimSellerBrandResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0302IService;
import com.bms.slim.utils.MessageUtils;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import com.framework.i18n.util.MessageManager;
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
@Api(description = "查询卖家品牌列表接口",
        tags = "SLIM0302IRestController")
public class SLIM0302IRestController extends BaseRestController {

    @Autowired
    private SLIM0302IService slim0302IService;


    @ApiOperation(value = "查询卖家品牌列表",
            notes = "传入卖家品牌IDList,实体卖家IDList,品牌ID,删除标志查询品牌信息")
    @RequestMapping(value = "/sellers/brands/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0302IResult findBrands(@RequestBody SLIM0302IParam slim0302IParam) {
        BaseRestPaginationResult<SlimSellerBrandResult> pagingResult = slim0302IService.findSellerBrandList(slim0302IParam);
        SLIM0302IResult slim0302IResult = BeanUtils.toBean(pagingResult, SLIM0302IResult.class);
        slim0302IResult.setMessage(MessageUtils.getSuccessMessage());
        return slim0302IResult;
    }

}
