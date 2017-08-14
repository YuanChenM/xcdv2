package com.bms.linv.business.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.bms.linv.bean.entity.*;
import com.bms.linv.bean.param.*;
import com.bms.linv.dao.InvmCommInfoDao;
import com.bms.linv.dao.InvmLoadAlocDealDetailDao;
import com.bms.linv.dao.InvmLoadDealDetailDao;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.linv.business.LinvOutboundBusinessService;
import com.bms.linv.business.LinvPublicMethodService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;

/**
 * 出库业务处理服务实现处理
 * Created by wang_fan on 2017/4/19.
 */
@Service
public class LinvOutboundBusinessServiceImpl extends BaseServiceImpl implements LinvOutboundBusinessService {

    @Autowired
    private LinvPublicMethodService linvPublicMethodService;

    @Autowired
    private InvmLoadDealDetailDao invmLoadDealDetailDao;

    @Autowired
    private InvmCommInfoDao invmCommInfoDao;
    /**
     * 销售发货业务
     * 
     * @param params
     */
    @Override
    public void dispatchLoads(List<LINV0102IParam> params) {
        Date time = DateUtils.getCurrent();
        //业务单号重复验证
        checkProductTran(params);

        for (int i = 0; i < params.size(); i++) {
            LINV0102ISourceParam source = params.get(i).getSource();
            LINV0102IDealParam deal = params.get(i).getDeal();

            //1、释放产品占用
            cancelProcductAloc(time, source, deal);

            // 2、出库方产品库存减少
            reduceProductInv(time, source, deal);

            //3、释放商品占用
            cancelOwComAloc(time, source, deal);

            //4、出库方商品库存减少
            reduceComoInv(time, source, deal);

        }
    }

    /**
     * 产品库存占用业务单号重复验证
     *
     * @param params
     */
    private void checkProductTran(List<LINV0102IParam> params) {
        for (int i = 0; i < params.size(); i++) {
            LINV0102IDealParam deal = params.get(i).getDeal();
            InvmLoadAlocDealDetail dealDetail = new InvmLoadAlocDealDetail();
            dealDetail.setTransactionId(deal.getTransactionId());
            dealDetail.setTransactionNo(deal.getTransactionNo());
            dealDetail.setTransactionDetailId(deal.getTransactionDetailId());
            dealDetail.setTransactionSequence(deal.getTransactionSequence());
            int count = invmLoadDealDetailDao.count(dealDetail);
            if (count > 0) {
                throw new BusinessException("LINV_PRODUCT", "业务单号重复");
            }
        }
    }

    /**
     * 出库方商品库存减少
     * @param time
     * @param source
     * @param deal
     */
    private void reduceComoInv(Date time, LINV0102ISourceParam source, LINV0102IDealParam deal) {
        InvmComoInventory comoInv= new InvmComoInventory();
        comoInv.setLaId(source.getLogicAreaId());
        comoInv.setSplatCode(source.getSalePlatform());
        comoInv.setOwnerId(source.getOwnerId());
        comoInv.setOwnerType(source.getOwnerType());
        comoInv.setUom(source.getUom());
        comoInv.setCommodityId(source.getCommodityId());
        comoInv.setIvQty(BigDecimal.valueOf(0).subtract(deal.getDispatchedQty()));
        comoInv.setIvType(source.getIvType());
        comoInv.setComoIvType("001");

        InvmComoDealDetail comoDealDetail = new InvmComoDealDetail();
        comoDealDetail.setTransactionId(deal.getTransactionId());
        comoDealDetail.setTransactionNo(deal.getTransactionNo());
        comoDealDetail.setTransactionDetailId(deal.getTransactionDetailId());
        comoDealDetail.setTransactionSource(deal.getTransactionSource());
        comoDealDetail.setTransactionType(LINV0102IParam.TRANSACTION_TYPE);
        comoDealDetail.setTransactionTime(time);
        comoDealDetail.setRefNo(deal.getRefNo());
        comoDealDetail.setBizType(deal.getBizType());
        comoDealDetail.setDealPrice(deal.getSellPrice());
        comoDealDetail.setDealQty(BigDecimal.valueOf(0).subtract(deal.getDispatchedQty()));
        comoDealDetail.setTgtId(deal.getTargetId());
        comoDealDetail.setTgtCode(deal.getTargetCode());
        comoDealDetail.setTgtType(deal.getTargetType());

        linvPublicMethodService.reduceComoInv(comoInv,comoDealDetail);
    }

    /**
     * 释放商品占用
     * @param time
     * @param source
     * @param deal
     */
    private void cancelOwComAloc(Date time, LINV0102ISourceParam source, LINV0102IDealParam deal) {
        InvmComoAlocInventory comoAlocInv = new InvmComoAlocInventory();
        comoAlocInv.setLaId(source.getLogicAreaId());
        comoAlocInv.setSplatCode(source.getSalePlatform());
        comoAlocInv.setOwnerId(source.getOwnerId());
        comoAlocInv.setOwnerType(source.getOwnerType());
        comoAlocInv.setCommodityId(source.getCommodityId());
        comoAlocInv.setUom(source.getUom());
        comoAlocInv.setBizType(deal.getBizType());
        comoAlocInv.setIvType(source.getIvType());
        comoAlocInv.setAlocQty(BigDecimal.valueOf(0).subtract(deal.getReleaseQty()));
        comoAlocInv.setTgtId(deal.getTargetId());
        comoAlocInv.setTgtCode(deal.getTargetCode());
        comoAlocInv.setTgtType(deal.getTargetType());

        InvmComoAlocDealDetail comoAlocDetail = new InvmComoAlocDealDetail();
        comoAlocDetail.setTransactionId(deal.getTransactionId());
        comoAlocDetail.setTransactionNo(deal.getTransactionNo());
        comoAlocDetail.setTransactionDetailId(deal.getTransactionDetailId());
        comoAlocDetail.setTransactionSequence(deal.getTransactionSequence());
        comoAlocDetail.setTransactionSource(deal.getTransactionSource());
        comoAlocDetail.setTransactionType(LINV0102IParam.TRANSACTION_TYPE);
        comoAlocDetail.setTransactionTime(time);
        comoAlocDetail.setRefNo(deal.getRefNo());
        comoAlocDetail.setBizType(deal.getBizType());
        comoAlocDetail.setAlocPrice(deal.getSellPrice());
        comoAlocDetail.setAlocQty(BigDecimal.valueOf(0).subtract(deal.getReleaseQty()));
        comoAlocDetail.setTgtId(deal.getTargetId());
        comoAlocDetail.setTgtCode(deal.getTargetCode());
        comoAlocDetail.setTgtType(deal.getTargetType());

        linvPublicMethodService.cancelOwComAloc(comoAlocInv,comoAlocDetail);
    }

    /**
     * 出库方产品库存减少
     * @param time
     * @param source
     * @param deal
     */
    private void reduceProductInv(Date time, LINV0102ISourceParam source, LINV0102IDealParam deal) {
        InvmLoad invmLoad = new InvmLoad();
        invmLoad.setLaId(source.getLogicAreaId());
        invmLoad.setSplatCode(source.getSalePlatform());
        invmLoad.setOwnerId(source.getMasterOwnerId());
        invmLoad.setOwnerType(source.getMasterOwnerType());
        //invmLoad.setWhId(source.getWhId());
        invmLoad.setSpId(source.getSupplierId());
        invmLoad.setSkuCode(source.getSkuCode());
        invmLoad.setLotNo(source.getLotNo());
        invmLoad.setUom(source.getUom());
        invmLoad.setIvQty(BigDecimal.valueOf(0).subtract(deal.getDispatchedQty()));
        invmLoad.setIvType(source.getIvType());
        //销售状态取商品扣减的销售状态
        InvmCommInfo param= new InvmCommInfo();
        param.setCommodityId(source.getCommodityId());
        InvmCommInfo commInfo = invmCommInfoDao.findOne(param);
        invmLoad.setSaleStatusId(commInfo.getSaleStatusId());

        InvmLoadDealDetail loadDealDetail = new InvmLoadDealDetail();
        loadDealDetail.setTransactionId(deal.getTransactionId());
        loadDealDetail.setTransactionNo(deal.getTransactionNo());
        loadDealDetail.setTransactionDetailId(deal.getTransactionDetailId());
        loadDealDetail.setTransactionSequence(deal.getTransactionSequence());
        loadDealDetail.setTransactionSource(deal.getTransactionSource());
        loadDealDetail.setTransactionType(LINV0102IParam.TRANSACTION_TYPE);
        loadDealDetail.setTransactionTime(time);
        loadDealDetail.setRefNo(deal.getRefNo());
        loadDealDetail.setBizType(deal.getBizType());
        loadDealDetail.setSpId(source.getSupplierId());
        loadDealDetail.setSkuCode(source.getSkuCode());
        loadDealDetail.setLotNo(source.getLotNo());
        loadDealDetail.setSaleStatusId(source.getSalesStatusId());
        loadDealDetail.setDealQty(BigDecimal.valueOf(0).subtract(deal.getDispatchedQty()));
        loadDealDetail.setDealPrice(deal.getSellPrice());
        loadDealDetail.setTgtId(deal.getTargetId());
        loadDealDetail.setTgtCode(deal.getTargetCode());
        loadDealDetail.setTgtType(deal.getTargetType());

        linvPublicMethodService.reduceProductInv(invmLoad,loadDealDetail);
    }

    /**
     * 释放产品占用
     * @param time
     * @param source
     * @param deal
     */
    private void cancelProcductAloc(Date time, LINV0102ISourceParam source, LINV0102IDealParam deal) {
        InvmLoadAlocInventory loadAlocInv = new InvmLoadAlocInventory();
        loadAlocInv.setReleaseTransactionId(deal.getReleaseTransactionId());
        loadAlocInv.setReleaseTransactionNo(deal.getReleaseTransactionNo());
        loadAlocInv.setReleaseTransactionDetailId(deal.getReleaseTransactionDetailId());
        loadAlocInv.setAlocQty(BigDecimal.valueOf(0).subtract(deal.getReleaseQty()));

        InvmLoadAlocDealDetail loadAlocDetail = new InvmLoadAlocDealDetail();
        loadAlocDetail.setTransactionId(deal.getTransactionId());
        loadAlocDetail.setTransactionNo(deal.getTransactionNo());
        loadAlocDetail.setTransactionDetailId(deal.getTransactionDetailId());
        loadAlocDetail.setTransactionSequence(deal.getTransactionSequence());
        loadAlocDetail.setTransactionSource(deal.getTransactionSource());
        loadAlocDetail.setTransactionType(LINV0102IParam.TRANSACTION_TYPE);
        loadAlocDetail.setTransactionTime(time);
        loadAlocDetail.setRefNo(deal.getRefNo());
        loadAlocDetail.setBizType(deal.getBizType());
        loadAlocDetail.setAlocPrice(deal.getSellPrice());
        loadAlocDetail.setAlocQty(BigDecimal.valueOf(0).subtract(deal.getReleaseQty()));
        loadAlocDetail.setTgtId(deal.getTargetId());
        loadAlocDetail.setTgtCode(deal.getTargetCode());
        loadAlocDetail.setTgtType(deal.getTargetType());

        linvPublicMethodService.cancelProcductAloc(loadAlocInv,loadAlocDetail);
    }

    @Override
    public BaseDao getBaseDao() {
        return null;
    }

}
