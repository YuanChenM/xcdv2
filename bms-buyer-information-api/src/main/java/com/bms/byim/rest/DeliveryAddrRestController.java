package com.bms.byim.rest;

import com.bms.byim.bean.entity.ByimDeliveryAddr;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.BuyerAccountRsParam;
import com.bms.byim.bean.param.DeliveryAddrRsParam;
import com.bms.byim.bean.param.DeliveryAreaCodeRsParam;
import com.bms.byim.bean.result.DeliveryAddrRsResult;
import com.bms.byim.bean.result.DeliveryAreaCodeResult;
import com.bms.byim.services.ByimBuyerService;
import com.bms.byim.services.ByimDeliveryAddrService;
import com.bms.byim.validator.DeliveryAddrAddValidator;
import com.bms.byim.validator.DeliveryAddrSearchValidator;
import com.bms.byim.validator.DeliveryAddrUpdateValidator;
import com.bms.byim.validator.DeliveryAreaCodeSearchValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
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

import java.util.List;

/**
 * Created by zhao_chen1 on 2016/12/30.
 */
@RestController
@Api(value = "bms-byim-api", description = "买家配送地址信息", position = 1, tags = "ByimDeliveryAddrRestController")
public class DeliveryAddrRestController extends BaseRestController {

    Logger logger = LoggerFactory.getLogger(DeliveryAddrRestController.class);

    @Autowired
    private ByimDeliveryAddrService byimDeliveryAddrService;

    @Autowired
    private ByimBuyerService byimBuyerService;

    @ApiOperation(value = "买家配送地址信息查询", notes = "买家配送地址信息查询")
    @RequestMapping(value = "/buyers/delivery/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = DeliveryAddrSearchValidator.class)
    public BaseRestPaginationResult<DeliveryAddrRsParam> SearchByDeliveryAddrSearch(@RequestBody DeliveryAddrRsParam param) {
        logger.info("买家配送地址信息查询开始");
        BaseRestPaginationResult<DeliveryAddrRsParam> basePagePagingResult;
        if (StringUtils.isEmpty(param.getBuyerId()) && StringUtils.isNotEmpty(param.getBuyerCode())) {
            //通过买家编码查询买家ID
            BuyerAccountRsParam accountRsParam = new BuyerAccountRsParam();
            accountRsParam.setBuyerCode(param.getBuyerCode());
            String buyerId = byimBuyerService.findBuyerId(accountRsParam);
            param.setBuyerId(buyerId);
        }
        basePagePagingResult = byimDeliveryAddrService.findPageList(param);
        return basePagePagingResult;
    }


    @ApiOperation(value = "买家配送地址信息新增", notes = "买家配送地址信息新增")
    @RequestMapping(value = "/buyers/delivery/_add", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = DeliveryAddrAddValidator.class)
    public DeliveryAddrRsResult addByDeliveryAddr(@RequestBody DeliveryAddrRsParam param) {
        ByimDeliveryAddr addrEntity = BeanUtils.toBean(param, ByimDeliveryAddr.class);
        DeliveryAddrRsResult addrRsResult = new DeliveryAddrRsResult();
        addrRsResult = this.byimDeliveryAddrService.addDeliveryAddr(addrEntity);
        return addrRsResult;
    }


    @ApiOperation(value = "买家配送地址信息更新", notes = "买家配送地址信息更新")
    @RequestMapping(value = "/buyers/delivery/_update", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = DeliveryAddrUpdateValidator.class)
    public Integer updateByDeliveryAddr(@RequestBody BaseBean<DeliveryAddrRsParam, DeliveryAddrRsParam> param) {
        int count;
        count = this.byimDeliveryAddrService.updateDeliveryAddr(param);
        return count;
    }

    @ApiOperation(value = "买家配送地址的区域环标码查询", notes = "买家配送地址的区域环标码查询")
    @RequestMapping(value = "/buyers/delivery/areaCode/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = DeliveryAreaCodeSearchValidator.class)
    public DeliveryAreaCodeResult SearchByDeliveryAddrSearch(@RequestBody DeliveryAreaCodeRsParam rsParam) {
        DeliveryAreaCodeResult result = new DeliveryAreaCodeResult();
        List<DeliveryAreaCodeResult> codeResults = this.byimDeliveryAddrService.findList(rsParam);
        if (CollectionUtils.isNotEmpty(codeResults)) {
            for (DeliveryAreaCodeResult areaCodeResult : codeResults) {
                if (areaCodeResult != null) {
                    if (StringUtils.isNotEmpty(areaCodeResult.getDeliveryAreaCode())) {
                        result.setDeliveryAreaCode(areaCodeResult.getDeliveryAreaCode());
                        break;
                    } else {
                        result.setDeliveryAreaCode("0");
                    }
                } else {
                    result.setDeliveryAreaCode("0");
                }
            }
        } else {
            result.setDeliveryAreaCode("0");
        }
        return result;
    }
}
