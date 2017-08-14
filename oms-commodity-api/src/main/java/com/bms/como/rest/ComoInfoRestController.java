package com.bms.como.rest;

import com.bms.como.bean.param.BaseBean;
import com.bms.como.bean.param.ComoDefaultRsParam;
import com.bms.como.bean.param.ComoInfoRsParam;
import com.bms.como.bean.param.ComoProductRsParam;
import com.bms.como.bean.result.ComoDefaultResult;
import com.bms.como.bean.result.ComoInfoResult;
import com.bms.como.bean.result.ComoProductResult;
import com.bms.como.constant.MessageConstant;
import com.bms.como.service.ComoInfoService;
import com.bms.como.validator.ComoDefaultValidator;
import com.bms.como.validator.ComoInfoAddValidator;
import com.bms.como.validator.ComoInfoUpdateValidator;
import com.bms.fms.notice.FmsNotice;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.StringUtils;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wang_haichun on 2017/3/28.
 */
@RestController
@Api(value = "bms-commodity-api", description = "商品信息", tags = "ComoInfoRestController")
public class ComoInfoRestController extends BaseRestController {
    Logger logger = LoggerFactory.getLogger(ComoInfoRestController.class);

    @Autowired
    private ComoInfoService comoInfoService;
    @Autowired
    private FmsNotice fmsNotice;




    @ApiOperation(value = "商品信息新增接口", notes = "商品信息新增接口", position = 1)
    @RequestMapping(value = "/commodity/info/_create", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ComoInfoAddValidator.class)
    public ComoInfoResult saveComoInfo(@RequestBody ComoInfoRsParam comoInfoRsParam) {
        ComoInfoResult result = comoInfoService.saveComeInfo(comoInfoRsParam);
        try{
            fmsNotice.sendCommodity(String.valueOf(result.getCommodityId()));
        }catch (Exception e){
            logger.debug("fmsNotice.sendCommodity("+result.getCommodityId()+")失败,原因："+e.getMessage());
        }
       return result;
    }


    @ApiOperation(value = "商品信息编辑接口", notes = "商品信息编辑接口", position = 2)
    @RequestMapping(value = "/commodity/info/_modify", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ComoInfoUpdateValidator.class)
    public ComoInfoResult modifyComoInfo(@RequestBody BaseBean<ComoInfoRsParam, ComoInfoRsParam> comoInfoRsParam) {
        return comoInfoService.modifyComoInfo(comoInfoRsParam);
    }




    @ApiOperation(value = "商品信息查询接口", notes = "商品信息查询接口", position = 3)
    @RequestMapping(value = "/commodity/info/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<ComoProductResult> searchComoInfo(@RequestBody ComoProductRsParam comoProductRsParam) {
        BaseRestPaginationResult<ComoProductResult> paginationResult = this.comoInfoService.searchComoInfo(comoProductRsParam);
        return paginationResult;
    }


    @ApiOperation(value = "查询产品下默认商品数量接口", notes = "查询产品下默认商品数量接口", position = 4)
    @RequestMapping(value = "/commodity/default/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ComoDefaultValidator.class)
    public ComoDefaultResult findComoDefaultCount(@RequestBody ComoDefaultRsParam param) {
        ComoDefaultResult result = new ComoDefaultResult();
        int count = comoInfoService.findComoDefaultCount(param);
        result.setProductPid(param.getProductPid());
        result.setCount(count);
        result.setMessage(MessageConstant.SUCCESS);
        return result;
    }

}
