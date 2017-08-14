package com.bms.linv.services.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.linv.bean.entity.*;
import com.bms.linv.bean.param.LINV0115IDealParam;
import com.bms.linv.bean.param.LINV0115ILgcsAreaParam;
import com.bms.linv.bean.param.LINV0115IParam;
import com.bms.linv.bean.param.LINV0115IProductParam;
import com.bms.linv.bean.result.LINV0115IProductResult;
import com.bms.linv.bean.result.LINV0115IResult;
import com.bms.linv.business.LinvPublicMethodService;
import com.bms.linv.constant.LinvApiUrlConstant;
import com.bms.linv.constant.LinvTypeCodeMaster;
import com.bms.linv.dao.InvmLoadDao;
import com.bms.linv.services.InvmComoInvTransferCompleteService;
import com.framework.base.web.result.BaseWebPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhang_jian4 on 2017/4/21.
 */
@Service
public class InvmComoInvTransferCompleteServiceImpl extends BaseServiceImpl implements InvmComoInvTransferCompleteService {

    @Autowired
    private RestApiClientFactory restApiClientFactory;
    @Autowired
    private LinvPublicMethodService publicMethodService;
    @Autowired
    private InvmLoadDao invmLoadDao;


    /**
     * 库存划拨完成接口
     */
    @Override
    public LINV0115IResult modifyComoInvTransferComplete(List<LINV0115IParam> paramList){
        LINV0115IResult result = new LINV0115IResult();
        RestApiClient restClient = restApiClientFactory.newApiRestClient();
        InvmComoInventory inventory = null;
        InvmComoDealDetail dealDetail = null;
        InvmComoBalanceInventory balanceInventory = null;
        List<Long> commodityIds = null;
        InvmLoad load = null;
        InvmLoadDealDetail loadDealDetail = null;
        if(CollectionUtils.isNotEmpty(paramList)){
            for (LINV0115IParam param : paramList){
                // 提供默认值
//                param.getSource().setSalePlatform("001");
                if(StringUtils.isEmpty(param.getSource().getMasterOwnerCode())){
                    param.getSource().setMasterOwnerCode("00000001");
                }
                if(StringUtils.isEmpty(param.getSource().getMasterOwnerType())){
                    param.getSource().setMasterOwnerType("001");
                }
                if(param.getDeal().getTransactionSequence() == null){
                    param.getDeal().setTransactionSequence(1);
                }
                //// 扣减原商品库存
                inventory = convertInvertory(param,"REDUCE");
                dealDetail = convertDealDetail(param);
                publicMethodService.reduceComoInv(inventory,dealDetail);
                //// 增加新商品库存
                inventory = convertInvertory(param, "ADD");
                dealDetail.setDealQty(dealDetail.getDealQty().abs());
                balanceInventory = convertBalanceInventory(param);
                publicMethodService.addComoInv(inventory,dealDetail,balanceInventory);

                // 调用商品接口，根据商品ID获取产品销售状态
                String url = ConfigServerUtils.getAPIUrl(LinvApiUrlConstant.COMO.CODE,
                        LinvApiUrlConstant.COMO.URIS.COMM_INFO_SEARCH);
                commodityIds = new ArrayList<>();
                commodityIds.add(param.getSource().getOldCommodityId());
                commodityIds.add(param.getDeal().getNewCommodityId());
                LINV0115IProductResult oldProduct = new LINV0115IProductResult();
                LINV0115IProductResult newProduct = new LINV0115IProductResult();
                LINV0115IProductParam productParam = new LINV0115IProductParam();
                productParam.setCommodityIds(commodityIds);
                BaseWebPaginationResult<LINV0115IProductResult> productResult = restClient.post(url, productParam,
                        new TypeReference<BaseWebPaginationResult<LINV0115IProductResult>>() {});
                if(productResult!=null && CollectionUtils.isNotEmpty(productResult.getData()) && productResult.getTotal() > 1){
                    if(productResult.getData().get(0).getCommodityId().equals(param.getSource().getOldCommodityId())){
                        oldProduct = productResult.getData().get(0);
                        newProduct = productResult.getData().get(1);
                    }else {
                        oldProduct = productResult.getData().get(1);
                        newProduct = productResult.getData().get(0);
                    }
                }else {
                    result.setMessage("商品ID有误，库存划拨失败！");
                    return result;
                }

                /// 扣减产品原销售标签库存
                load = convertLoad(param,oldProduct,"REDUCE");
                loadDealDetail = convertLoadDealDetail(param,oldProduct);
                publicMethodService.reduceProductInv(load,loadDealDetail);
                InvmLoad invmLoadResult = invmLoadDao.findOne(load);
                if(invmLoadResult == null){
                    throw new BusinessException("LINV.REDUCE_P_INV", "未查询到当前产品库存！");
                }
                //// 增加产品新销售标签库存
                load = convertLoad(param,newProduct,"ADD");
                loadDealDetail.setDealQty(loadDealDetail.getDealQty().abs());
                loadDealDetail.setSaleStatusId(newProduct.getSaleStatusId());
                load.setWhId(invmLoadResult.getWhId());
                load.setWhCode(invmLoadResult.getWhCode());
                load.setLaCode(invmLoadResult.getLaCode());
                publicMethodService.addProductInv(load,loadDealDetail);
            }
            result.setMessage("库存划拨完成");
        }else {
            result.setMessage("库存信息不能为空");
        }

        return result;
    }


    private InvmComoInventory convertInvertory(LINV0115IParam param, String handleType){
        InvmComoInventory inventory = new InvmComoInventory();
        RestApiClient restClient = restApiClientFactory.newApiRestClient();
        if(handleType.equals("ADD")){
            inventory.setCommodityId(param.getDeal().getNewCommodityId().toString());
            inventory.setIvQty(param.getDeal().getTransferQty());
        }else {
            inventory.setCommodityId(param.getSource().getOldCommodityId().toString());
            inventory.setIvQty(new BigDecimal("-" + param.getDeal().getTransferQty()));
//            inventory.setOwnerId(param.getSource().getMasterOwnerId());
//            inventory.setOwnerCode(param.getSource().getMasterOwnerCode());
//            inventory.setOwnerType(param.getSource().getMasterOwnerType());
        }
        inventory.setOwnerId(param.getSource().getOwnerId());
        inventory.setOwnerCode(param.getSource().getOwnerCode());
        inventory.setOwnerType(param.getSource().getOwnerType());
        inventory.setOwnerDType(param.getSource().getOwnerdType());

        inventory.setLaId(param.getSource().getLogicAreaId());
        // 调用物流区查询接口，根据物流区ID获取物流区CODE等信息
        String url = ConfigServerUtils.getAPIUrl(LinvApiUrlConstant.REGION.REGION,
                LinvApiUrlConstant.REGION.URIS.REGION_SEARCH);
        LINV0115ILgcsAreaParam lgcsAreaParam = new LINV0115ILgcsAreaParam();
        List<LINV0115ILgcsAreaParam> lgcsAreaParamList = new ArrayList<>();
        lgcsAreaParam.setLgcsAreaId(param.getSource().getLogicAreaId());
        lgcsAreaParamList.add(lgcsAreaParam);
        lgcsAreaParamList = restClient.post(url, lgcsAreaParam,
                new TypeReference<ArrayList<LINV0115ILgcsAreaParam>>() {});
        if(CollectionUtils.isNotEmpty(lgcsAreaParamList)){
            inventory.setLaCode(lgcsAreaParamList.get(0).getLgcsAreaCode());
        }
        inventory.setSplatCode(param.getSource().getSalePlatform());
        inventory.setUom(param.getSource().getUom());
//        inventory.setIvQty(param.getDeal().getTransferQty());
        inventory.setIvType(param.getSource().getIvType());
        inventory.setComoIvType(LinvTypeCodeMaster.COMO_INENTORY_TYPE.Actual);
        return inventory;
    }

    private InvmComoDealDetail convertDealDetail(LINV0115IParam param){
        InvmComoDealDetail dealDetail = new InvmComoDealDetail();
        dealDetail.setTransactionId(param.getDeal().getTransactionId());
        dealDetail.setTransactionNo(param.getDeal().getTransactionNo());
        dealDetail.setTransactionDetailId(param.getDeal().getTransactionDetailId());
        dealDetail.setTransactionSource(param.getDeal().getTransactionSource());
        dealDetail.setBizType(param.getDeal().getBizType());
        dealDetail.setDealQty(new BigDecimal("-"+param.getDeal().getTransferQty()));
        dealDetail.setTransactionType(LINV0115IDealParam.TRANSACTION_TYPE);
        dealDetail.setTransactionTime(DateUtils.getCurrent());
        return dealDetail;
    }

    private InvmComoBalanceInventory convertBalanceInventory(LINV0115IParam param){
        InvmComoBalanceInventory balanceInventory = new InvmComoBalanceInventory();
        balanceInventory.setTransactionId(param.getDeal().getTransactionId());
        balanceInventory.setTransactionNo(param.getDeal().getTransactionNo());
        balanceInventory.setTransactionDetailId(param.getDeal().getTransactionDetailId());
        balanceInventory.setTransactionSource(param.getDeal().getTransactionSource());
        balanceInventory.setBizType(param.getDeal().getBizType());
        balanceInventory.setRefNo(param.getDeal().getRefNo());
        balanceInventory.setTransactionType(LINV0115IDealParam.TRANSACTION_TYPE);
        balanceInventory.setTransactionTime(DateUtils.getCurrent());
        balanceInventory.setInboundQty(param.getDeal().getTransferQty());
        balanceInventory.setOutboundQty(BigDecimal.valueOf(0));
        return balanceInventory;
    }

    private InvmLoad convertLoad(LINV0115IParam param, LINV0115IProductResult product, String handleType){
        InvmLoad load = new InvmLoad();
        if(handleType.equals("ADD")){
            load.setIvQty(param.getDeal().getTransferQty());
//            load.setOwnerId(param.getSource().getOwnerId());
//            load.setOwnerCode(param.getSource().getOwnerCode());
//            load.setOwnerType(param.getSource().getOwnerType());
        }else {
            load.setIvQty(new BigDecimal("-" + param.getDeal().getTransferQty()));
        }

        load.setSaleStatusId(product.getSaleStatusId());
        load.setSaleStatusCode(product.getSaleStatusCode());
        load.setOwnerId(param.getSource().getMasterOwnerId());
        load.setOwnerCode(param.getSource().getMasterOwnerCode());
        load.setOwnerType(param.getSource().getMasterOwnerType());
        load.setLaId(param.getSource().getLogicAreaId());
        load.setSplatCode(param.getSource().getSalePlatform());
        load.setIvType(param.getSource().getIvType());
        load.setSkuCode(param.getSource().getSkuCode());
        load.setLotNo(param.getSource().getLotNo());
        load.setUom(param.getSource().getUom());
        return load;
    }

    private InvmLoadDealDetail convertLoadDealDetail(LINV0115IParam param, LINV0115IProductResult product){
        InvmLoadDealDetail loadDealDetail = new InvmLoadDealDetail();
        loadDealDetail.setRefNo(param.getDeal().getRefNo());
        loadDealDetail.setTransactionId(param.getDeal().getTransactionId());
        loadDealDetail.setTransactionNo(param.getDeal().getTransactionNo());
        loadDealDetail.setTransactionSource(param.getDeal().getTransactionSource());
        loadDealDetail.setTransactionDetailId(param.getDeal().getTransactionDetailId());
        loadDealDetail.setTransactionSequence(param.getDeal().getTransactionSequence());
        loadDealDetail.setDealQty(new BigDecimal("-"+param.getDeal().getTransferQty()));
        loadDealDetail.setBizType(param.getDeal().getBizType());

        loadDealDetail.setSkuCode(param.getSource().getSkuCode());
        loadDealDetail.setSaleStatusId(product.getSaleStatusId());
        loadDealDetail.setTransactionType(LINV0115IDealParam.TRANSACTION_TYPE);
        loadDealDetail.setTransactionTime(DateUtils.getCurrent());
        return loadDealDetail;
    }
    @Override
    public BaseDao getBaseDao() {
        return null;
    }
}
