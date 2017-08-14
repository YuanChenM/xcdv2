package com.bms.byim.rest;

import com.bms.byim.bean.entity.ByimStorePicture;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.BuyerAccountRsParam;
import com.bms.byim.bean.param.StorePictureRsParam;
import com.bms.byim.bean.result.StorePictureRsResult;
import com.bms.byim.services.ByimBuyerService;
import com.bms.byim.services.ByimStorePictureService;
import com.bms.byim.validator.StorePictureAddValidator;
import com.bms.byim.validator.StorePictureModifyValidator;
import com.bms.byim.validator.StorePictureSearchValidator;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yuan_zhifei on 2016/12/30.
 */
@RestController
@Api(value = "bms-byim-api",
        description = "买家店铺证照图片信息",
        position = 1,
        tags = "StorePictureRestController")
public class StorePictureRestController extends BaseRestController {
    Logger logger = LoggerFactory.getLogger(StorePictureRestController.class);
    @Autowired
    private ByimStorePictureService storePictureService;

    @Autowired
    private ByimBuyerService byimBuyerService;

    @ApiOperation(value = "买家店铺证照信息查询", notes = "买家店铺证照信息查询")
    @RequestMapping(value = "/buyers/store/photo/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = StorePictureSearchValidator.class)
    public List<ByimStorePicture> searchStorePhoto(@RequestBody StorePictureRsParam param) {
        if (StringUtils.isEmpty(param.getBuyerId()) && StringUtils.isNotEmpty(param.getBuyerCode())) {
            //通过买家编码查询买家ID
            BuyerAccountRsParam accountRsParam = new BuyerAccountRsParam();
            accountRsParam.setBuyerCode(param.getBuyerCode());
            String buyerId = byimBuyerService.findBuyerId(accountRsParam);
            param.setBuyerId(buyerId);
        }
        List<ByimStorePicture> storePictureList = this.storePictureService.findList(param);
        return storePictureList;
    }

    @ApiOperation(value = "买家店铺证照信息新增", notes = "买家店铺证照信息新增")
    @RequestMapping(value = "/buyers/store/photo/_add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = StorePictureAddValidator.class)
    public Integer addStorePhoto(@RequestBody List<StorePictureRsParam> paramList) {
        return storePictureService.saveStorePictures(paramList);
    }

    @ApiOperation(value = "买家店铺证照信息更新", notes = "买家店铺证照信息更新")
    @RequestMapping(value = "/buyers/store/photo/_modify",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = StorePictureModifyValidator.class)
    public Integer modifyStorePhoto(@RequestBody List<BaseBean<StorePictureRsParam, StorePictureRsParam>> paramRequest) {
        return this.storePictureService.modifyStorePhotos(paramRequest);
    }
}
