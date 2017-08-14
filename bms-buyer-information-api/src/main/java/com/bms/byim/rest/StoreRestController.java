package com.bms.byim.rest;

import com.bms.byim.bean.entity.ByimStore;
import com.bms.byim.bean.param.StoreRsParam;
import com.bms.byim.services.ByimBuyerService;
import com.bms.byim.services.ByimStoreService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
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

import java.util.Date;
import java.util.List;

/**
 * Created by yuan_zhifei on 2017/2/9.
 */
@RestController
@Api(value = "bms-byim-api", description = "买家店铺信息接口", position = 1, tags = "StoreRestController")
public class StoreRestController extends BaseRestController {

    Logger logger = LoggerFactory.getLogger(DeliveryAreaRestController.class);

    @Autowired
    private ByimStoreService storeService;
    @Autowired
    private ByimBuyerService basicService;

    @ApiOperation(value = "买家店铺信息查询", notes = "买家店铺信息查询")
    @RequestMapping(value = "/buyers/Store/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer search(@RequestBody List<StoreRsParam> storeRsParams) {
        int result = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(storeRsParams)) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < storeRsParams.size(); i++) {
                result = this.storeService.findTerminalMarketUse(storeRsParams.get(i));
            }
        }
        return result;
    }

    @ApiOperation(value = "买家店铺信息修改", notes = "买家店铺信息修改")
    @RequestMapping(value = "/buyers/Store/_update", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer update(@RequestBody StoreRsParam storeRsParam) {
        int result = NumberConst.IntDef.INT_ZERO;
        if (storeRsParam != null) {
            String loginUserId = this.storeService.getLoginUserId();
            Date currentDate = DateUtils.getCurrent();
            ByimStore store = new ByimStore();
            store.setMarketId(storeRsParam.getMarketId());
            store.setMarketName(storeRsParam.getMarketName());
            store.setMarketScale(storeRsParam.getMarketLevelName());
            store.setMarketCode(storeRsParam.getMarketCode());
            store.setUpdId(loginUserId);
            store.setUpdTime(currentDate);
            result = this.storeService.modifyStore(store);
            //查询需要变更的买家id
            /*List<StoreRsParam> rsParams = this.storeService.findList(storeRsParam);
            if (CollectionUtils.isNotEmpty(rsParams)) {
                for (int i = NumberConst.IntDef.INT_ZERO; i < rsParams.size(); i++) {
                    BuyerBasicRsParam basicRsParamFilter = new BuyerBasicRsParam();
                    BuyerBasicRsParam basicRsParamTarget = new BuyerBasicRsParam();
                    basicRsParamFilter.setBuyerId(rsParams.get(i).getBuyerId());
                    ByimBuyer basicInfo = this.basicService.findOne(basicRsParamFilter);
                    basicRsParamTarget.setMarketId(storeRsParam.getMarketId());
                    //basicRsParamTarget.setLgcsAreaCode(basicInfo.getLgcsAreaCode());
                    //basicRsParamTarget.setLgcsAreaName(basicInfo.getLgcsAreaName());
                    //basicRsParamTarget.setCityCode(basicInfo.getCityCode());
                    //basicRsParamTarget.setCityName(basicInfo.getCityName());
                    basicRsParamTarget.setMarketCode(storeRsParam.getMarketCode());
                    basicRsParamTarget.setMarketType(rsParams.get(i).getMarketType());
                    basicRsParamTarget.setBuyerFirstCategory(basicInfo.getBuyerFirstCategory());
                    basicRsParamTarget.setMarketScaleCode(storeRsParam.getMarketLevel());
                    *//*if (StringUtils.isNotEmpty(basicInfo.getDistrictCode())) {
                        basicRsParamTarget.setDistrictCode(basicInfo.getDistrictCode());
                    }*//*
                    basicRsParamTarget = createBuyerCode(basicRsParamTarget);
                    ByimBuyer byimBasicFilter = BeanUtils.toBean(basicRsParamFilter, ByimBuyer.class);
                    ByimBuyer byimBasicTarget = BeanUtils.toBean(basicRsParamTarget, ByimBuyer.class);
                    byimBasicTarget.setUpdId(loginUserId);
                    byimBasicTarget.setUpdTime(currentDate);
                    BaseBean<ByimBuyer, ByimBuyer> baseBean = new BaseBean<>();
                    baseBean.setFilter(byimBasicFilter);
                    baseBean.setTarget(byimBasicTarget);
                    //修改买家编码，买家物流区地区
                    this.basicService.modify(baseBean);
                }
            }*/
        }
        return result;
    }

    /**
     * 设置买家编码
     *
     * @param buyerBasicRsParam
     */
    /*public BuyerBasicRsParam createBuyerCode(BuyerBasicRsParam buyerBasicRsParam) {
        String buyerCode = null;

        if ("01".equals(buyerBasicRsParam.getBuyerFirstCategory())) {
            //分销买家
            *//*buyerCode = buyerBasicRsParam.getBuyerFirstCategory() + buyerBasicRsParam.getLgcsAreaCode() +
                    buyerBasicRsParam.getCityCode() + buyerBasicRsParam.getMarketScaleCode() +
                    buyerBasicRsParam.getMarketCode().substring(buyerBasicRsParam.getMarketCode().length() - 2);*//*
            buyerCode = buyerBasicRsParam.getMarketCode();
            int sequenceCode = NumberUtils.toInt(this.basicService.findMarketSequenceCode(buyerBasicRsParam));
            buyerCode = buyerCode + StringUtil.PadLeft(StringUtils.toStr(sequenceCode + 1), 3, "0");
        } else if ("02".equals(buyerBasicRsParam.getBuyerFirstCategory())) {
            //菜场买家
            *//*buyerCode = buyerBasicRsParam.getBuyerFirstCategory() + buyerBasicRsParam.getLgcsAreaCode() +
                    buyerBasicRsParam.getCityCode() + buyerBasicRsParam.getDistrictCode() +
                    buyerBasicRsParam.getMarketCode().substring(buyerBasicRsParam.getMarketCode().length() - 3);*//*
            buyerCode = buyerBasicRsParam.getMarketCode();
            int sequenceCode = NumberUtils.toInt(this.basicService.findMarketSequenceCode(buyerBasicRsParam));
            buyerCode = buyerCode + StringUtil.PadLeft(StringUtils.toStr(sequenceCode + 1), 3, "0");
        } else if ("03".equals(buyerBasicRsParam.getBuyerFirstCategory()) || "04".equals(buyerBasicRsParam.getBuyerFirstCategory())) {
            //用户买家(团膳,火锅)
            buyerCode = buyerBasicRsParam.getBuyerFirstCategory() + buyerBasicRsParam.getLgcsAreaCode() +
                    buyerBasicRsParam.getCityCode() + buyerBasicRsParam.getDistrictCode();
            int sequenceCode = NumberUtils.toInt(this.basicService.findDistrictSequenceCode(buyerBasicRsParam));
            buyerCode = buyerCode + StringUtil.PadLeft(StringUtils.toStr(sequenceCode + 1), 4, "0");
        } else if ("05".equals(buyerBasicRsParam.getBuyerFirstCategory()) || "06".equals(buyerBasicRsParam.getBuyerFirstCategory())) {
            //用户买家(加工厂,中餐)
            buyerCode = buyerBasicRsParam.getBuyerFirstCategory();
            if (!StringUtils.isEmpty(buyerBasicRsParam.getBuyerSubCategory())) {
                buyerCode = buyerCode + buyerBasicRsParam.getBuyerSubCategory();
            } else {
                buyerCode = buyerCode + "00";
            }
            buyerCode = buyerCode + buyerBasicRsParam.getLgcsAreaCode() +
                    buyerBasicRsParam.getCityCode() + buyerBasicRsParam.getDistrictCode();
            int sequenceCode = NumberUtils.toInt(this.basicService.findDistrictSequenceCode(buyerBasicRsParam));
            buyerCode = buyerCode + StringUtil.PadLeft(StringUtils.toStr(sequenceCode + 1), 4, "0");
        }
        buyerBasicRsParam.setBuyerCode(buyerCode);
        return buyerBasicRsParam;
    }*/

}
