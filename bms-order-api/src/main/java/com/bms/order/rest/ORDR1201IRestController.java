package com.bms.order.rest;

import com.bms.order.bean.param.ORDR1201IRestParam;
import com.bms.order.bean.result.ORDR1201IRestResult;
import com.bms.order.services.ORDR1201IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sun_jiaju on 2017/05/10.
 */
@RestController
@Api(description = "历史订单查询",
        tags = "ORDR1201IRestController", value = "ORDR1201I", position = 0)
public class ORDR1201IRestController extends BaseRestController {
    @Autowired
    private ORDR1201IService ordr1201IService;

    @ApiOperation(value = "历史订单查询", notes = "历史订单查询")
    @RequestMapping(value = "/order/history/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<ORDR1201IRestResult> searchWayType(@RequestBody ORDR1201IRestParam param) {

        param.setOrderCode(DbUtils.buildLikeCondition(param.getOrderCode()));
        param.setBuyerCode(DbUtils.buildLikeCondition(param.getBuyerCode()));
        param.setBuyerName(DbUtils.buildLikeCondition(param.getBuyerName()));
        param.setMarket(DbUtils.buildLikeCondition(param.getMarket()));
        param.setReceiverAddress(DbUtils.buildLikeCondition(param.getReceiverAddress()));
        param.setReceiverTel(DbUtils.buildLikeCondition(param.getReceiverTel()));
        param.setFrozenGoodsHouseKeep(DbUtils.buildLikeCondition(param.getFrozenGoodsHouseKeep()));
        param.setClassCode(DbUtils.buildLikeCondition(param.getClassCode()));
        param.setClassName(DbUtils.buildLikeCondition(param.getClassName()));
        param.setBreedCode(DbUtils.buildLikeCondition(param.getBreedCode()));
        param.setBreedName(DbUtils.buildLikeCondition(param.getBreedName()));
        param.setFeatureCode(DbUtils.buildLikeCondition(param.getFeatureCode()));
        param.setFeatureName(DbUtils.buildLikeCondition(param.getFeatureName()));
        param.setNormsName(DbUtils.buildLikeCondition(param.getNormsName()));
        param.setPdCode(DbUtils.buildLikeCondition(param.getPdCode()));
        param.setPdName(DbUtils.buildLikeCondition(param.getPdName()));
        param.setPdGradeName(DbUtils.buildLikeCondition(param.getPdGradeName()));
        param.setSupplierName(DbUtils.buildLikeCondition(param.getSupplierName()));
        param.setSalesParty(DbUtils.buildLikeCondition(param.getSalesParty()));
        param.setOrderSource(DbUtils.buildLikeCondition(param.getOrderSource()));
        param.setOrderStatus(DbUtils.buildLikeCondition(param.getOrderStatus()));
        param.setBuyerType(DbUtils.buildLikeCondition(param.getBuyerType()));
        param.setOrderType(DbUtils.buildLikeCondition(param.getOrderType()));

        return ordr1201IService.findPageList(param);
    }
}
