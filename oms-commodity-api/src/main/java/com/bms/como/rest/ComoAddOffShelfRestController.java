package com.bms.como.rest;

import com.bms.como.bean.param.ComoAddOffShelfRsParam;
import com.bms.como.bean.param.ComoProductRsParam;
import com.bms.como.bean.result.ComoProductResult;
import com.bms.como.bean.result.ComoShelfListRsResult;
import com.bms.como.service.ComoAddOffShelfService;
import com.bms.como.service.ComoInfoService;
import com.bms.como.validator.ComoAddOffHandleValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
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

/**
 * Created by zhang_jian4 on 2017/3/31.
 */
@RestController
@Api(description = "商品销售上下架管理", tags = "ComoAddOffShelfRestController")
public class ComoAddOffShelfRestController extends BaseRestController {
    @Autowired
    private ComoAddOffShelfService addOffShelfService;
    @Autowired
    private ComoInfoService comoInfoService;


    @ApiOperation(value = "商品销售上下架管理接口", notes = "商品销售上下架管理接口", position = 1)
    @RequestMapping(value = "/commodity/shelflist/_handle", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ComoAddOffHandleValidator.class)
    public ComoShelfListRsResult handleCommodityAddOffShelf(@RequestBody ComoAddOffShelfRsParam comoInfoRsParam) {
        ComoProductRsParam comoProductRsParam = setParam(comoInfoRsParam);
        BaseRestPaginationResult<ComoProductResult> paginationResult = this.comoInfoService.searchComoInfo(comoProductRsParam);
        // 判断该商品是否存在
        if(paginationResult.getTotal()>0){
            return addOffShelfService.handleCommodityAddOffShelf(comoInfoRsParam);
        }else {
            ComoShelfListRsResult result = new ComoShelfListRsResult();
            result.setMessage("没有符合条件的商品！");
            return result;
        }

    }

    private ComoProductRsParam setParam(ComoAddOffShelfRsParam comoInfoRsParam){
        ComoProductRsParam comoProductRsParam = new ComoProductRsParam();
        comoProductRsParam.setCommodityIds(comoInfoRsParam.getCommodityId());
        comoProductRsParam.setSaleStatusIds(comoInfoRsParam.getSaleStatusId());
        comoProductRsParam.setCommodityName(comoInfoRsParam.getCommodityName());
        comoProductRsParam.setClassesIds(comoInfoRsParam.getClassesId());
        comoProductRsParam.setMachiningIds(comoInfoRsParam.getMachiningId());
        comoProductRsParam.setBreedIds(comoInfoRsParam.getBreedId());
        comoProductRsParam.setBreedName(comoInfoRsParam.getBreedName());
        comoProductRsParam.setBrandIds(comoInfoRsParam.getBrandId());
        comoProductRsParam.setItemIds(comoInfoRsParam.getItemId());
        comoProductRsParam.setItemName(comoInfoRsParam.getItemName());
        comoProductRsParam.setQualityGradeType(comoInfoRsParam.getQualityGradeType());
        return comoProductRsParam;
    }
}
