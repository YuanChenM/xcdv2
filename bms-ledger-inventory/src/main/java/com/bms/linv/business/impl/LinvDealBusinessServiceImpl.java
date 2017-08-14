package com.bms.linv.business.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.druid.util.StringUtils;
import com.bms.linv.bean.param.*;
import com.bms.linv.constant.LinvTypeCodeMaster;
import com.bms.linv.dao.InvmComoDealDetailDao;
import com.bms.linv.dao.InvmNameInfoDao;
import com.framework.base.consts.NumberConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.linv.bean.entity.*;
import com.bms.linv.business.LinvDealBusinessService;
import com.bms.linv.business.LinvPublicMethodService;
import com.bms.linv.dao.InvmComoInventoryDao;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;

/**
 * 商品交易处理
 * Created by wang_fan on 2017/4/18.
 */
@Service
public class LinvDealBusinessServiceImpl extends BaseServiceImpl implements LinvDealBusinessService {

    @Autowired
    private LinvPublicMethodService linvPublicMethodService;

    @Autowired
    private InvmComoInventoryDao invmComoInventoryDao;

    @Autowired
    private InvmComoDealDetailDao invmComoDealDetailDao;

    @Autowired
    private InvmNameInfoDao invmNameInfoDao;

    /**
     * 商品交易处理
     * 
     * @PARAM PARAMS
     */
    @Override
    public void dealStore(List<LINV0105IParam> params) {
        Date time = DateUtils.getCurrent();

        //业务单号重复验证
        checkComoTran(params);

        for (int i = 0; i < params.size(); i++) {
            LINV0105ISourceParam source = params.get(i).getSource();
            LINV0105IDealParam deal = params.get(i).getDeal();

            // 1、根据释放数量释放出库方商品占用库存占用数量
            subComoAloc(time, source, deal);



            // 2、扣减出库方商品库存
            if (deal.isDeductSrcInv()) {
                subCommoInv(time,source , deal);
            }

            // 3、根据标记，增加目标（入库）方商品库存
            if (deal.isAddTargetInv()) {
                // 插入商品库存
                saveComoInv(time, deal,source);
            }
        }
    }

    /**
     * 商品库存业务单号重复验证
     *
     * @param params
     */
    private void checkComoTran(List<LINV0105IParam> params) {
        for (int i = 0; i < params.size(); i++) {
            LINV0105IDealParam deal = params.get(i).getDeal();
            InvmComoDealDetail dealDetail = new InvmComoDealDetail();
            dealDetail.setTransactionId(deal.getTransactionId());
            dealDetail.setTransactionNo(deal.getTransactionNo());
            dealDetail.setTransactionDetailId(deal.getTransactionDetailId());
            int count = invmComoDealDetailDao.count(dealDetail);
            if (count > 0) {
                throw new BusinessException("LINV_COMOIDITY", "业务单号重复");
            }
        }
    }

    /**
     * 插入商品库存、交易明细、余量明细
     *
     * @param time
     * @param deal
     */
    private void saveComoInv(Date time, LINV0105IDealParam deal,LINV0105ISourceParam source) {
        //查询（出库方）商品库存获取到基础信息
        InvmComoInventory invmComoInfo = new InvmComoInventory();
        // 查询条件
        invmComoInfo.setLaId(source.getLogicAreaId());
        invmComoInfo.setSplatCode(source.getSalePlatform());
        invmComoInfo.setOwnerId(source.getOwnerId());
        invmComoInfo.setOwnerCode(source.getOwnerCode());
        invmComoInfo.setOwnerType(source.getOwnerType());
        invmComoInfo.setCommodityId(source.getCommodityId());
        invmComoInfo.setIvType(source.getIvType());
        invmComoInfo.setUom(source.getUom());
       // invmComoInfo.setComoIvType(source.getComoIvType());
        InvmComoInventory comoInventory = invmComoInventoryDao.findOne(invmComoInfo);
        if(null == comoInventory){
            throw new BusinessException("LINV.REDUCE_C_INV", "未查询到当前货权人(出库方)商品库存！");
        }

        comoInventory.setStoreNo(null);
        comoInventory.setOwnerId(deal.getTargetId());
        comoInventory.setOwnerCode(deal.getTargetCode());
        comoInventory.setOwnerType(deal.getTargetType());
        comoInventory.setIvQty(deal.getDealQty());
        comoInventory.setComoIvType(source.getComoIvType());

        // 将目标放名称录入名称信息表中
        if (!StringUtils.isEmpty(deal.getTargetName())) {
            InvmNameInfo nameInfo = new InvmNameInfo();
            nameInfo.setType(LinvTypeCodeMaster.NAME_INFO.OWNER);
            nameInfo.setCode(deal.getTargetCode());
            nameInfo.setName(deal.getTargetName());
            nameInfo.setDelFlg(false);
            nameInfo.setCrtId("WMS");
            nameInfo.setCrtTime(time);
            nameInfo.setUpdId("WMS");
            nameInfo.setUpdTime(time);
            invmNameInfoDao.save(nameInfo);
        }

        // 插入商品交易明细
        InvmComoDealDetail invmComoDealDetail = new InvmComoDealDetail();
        invmComoDealDetail.setTransactionId(deal.getTransactionId());
        invmComoDealDetail.setTransactionNo(deal.getTransactionNo());
        invmComoDealDetail.setTransactionDetailId(deal.getTransactionDetailId());
        invmComoDealDetail.setTransactionSource(deal.getTransactionSource());
        invmComoDealDetail.setTransactionType(LINV0105IParam.TRANSACTION_TYPE);
        invmComoDealDetail.setTransactionTime(time);
        invmComoDealDetail.setRefNo(deal.getRefNo());
        invmComoDealDetail.setBizType(deal.getBizType());
        invmComoDealDetail.setDealPrice(deal.getDealPrice());
        invmComoDealDetail.setDealQty(deal.getDealQty());

        // 商品库存余量
        InvmComoBalanceInventory invmComoBalanceInventory = new InvmComoBalanceInventory();
        invmComoBalanceInventory.setTransactionId(deal.getTransactionId());
        invmComoBalanceInventory.setTransactionNo(deal.getTransactionNo());
        invmComoBalanceInventory.setTransactionDetailId(deal.getTransactionDetailId());
        invmComoBalanceInventory.setTransactionSource(deal.getTransactionSource());
        invmComoBalanceInventory.setTransactionType(LINV0105IParam.TRANSACTION_TYPE);
        invmComoBalanceInventory.setTransactionTime(time);
        invmComoBalanceInventory.setRefNo(deal.getRefNo());
        invmComoBalanceInventory.setBizType(deal.getBizType());
        invmComoBalanceInventory.setDealPrice(deal.getDealPrice());
        invmComoBalanceInventory.setInboundQty(deal.getDealQty());
        invmComoBalanceInventory.setOutboundQty(BigDecimal.valueOf(0));

        linvPublicMethodService.addComoInv(comoInventory, invmComoDealDetail, invmComoBalanceInventory);

    }

    /**
     * 扣减商品库存
     *
     * @param time
     * @param source
     * @param deal
     */
    private void subCommoInv(Date time, LINV0105ISourceParam source , LINV0105IDealParam deal) {

        //查询（出库方）商品库存获取到基础信息
        InvmComoInventory invmComoInfo = new InvmComoInventory();
        // 查询条件
        invmComoInfo.setLaId(source.getLogicAreaId());
        invmComoInfo.setSplatCode(source.getSalePlatform());
        invmComoInfo.setOwnerId(source.getOwnerId());
        invmComoInfo.setOwnerCode(source.getOwnerCode());
        invmComoInfo.setOwnerType(source.getOwnerType());
        invmComoInfo.setCommodityId(source.getCommodityId());
        invmComoInfo.setIvType(source.getIvType());
        invmComoInfo.setUom(source.getUom());
        invmComoInfo.setComoIvType(source.getComoIvType());
        InvmComoInventory comoInventory = invmComoInventoryDao.findOne(invmComoInfo);
        if(null == comoInventory){
            throw new BusinessException("LINV.REDUCE_C_INV", "未查询到当前货权人(出库方)商品库存！");
        }

            comoInventory.setIvQty(BigDecimal.valueOf(0).subtract(deal.getDealQty()));
            // 插入商品库存交易明细
            InvmComoDealDetail invmComoDealDetail = new InvmComoDealDetail();
            invmComoDealDetail.setTransactionId(deal.getTransactionId());
            invmComoDealDetail.setTransactionNo(deal.getTransactionNo());
            invmComoDealDetail.setTransactionDetailId(deal.getTransactionDetailId());
            invmComoDealDetail.setTransactionSource(deal.getTransactionSource());
            invmComoDealDetail.setTransactionType(LINV0105IParam.TRANSACTION_TYPE);
            invmComoDealDetail.setTransactionTime(time);
            invmComoDealDetail.setRefNo(deal.getRefNo());
            invmComoDealDetail.setBizType(deal.getBizType());
            invmComoDealDetail.setDealPrice(deal.getDealPrice());
            invmComoDealDetail.setDealQty(BigDecimal.valueOf(0).subtract(deal.getDealQty()));
            invmComoDealDetail.setTgtId(deal.getTargetId());
            invmComoDealDetail.setTgtCode(deal.getTargetCode());
            invmComoDealDetail.setTgtType(deal.getTargetType());

            linvPublicMethodService.reduceComoInv(comoInventory, invmComoDealDetail);
    }

    /**
     * 释放商品占用库存占用数量
     *
     * @param time
     * @param source
     * @param deal
     */
    private void subComoAloc(Date time, LINV0105ISourceParam source, LINV0105IDealParam deal) {
        if (deal.getReleaseQty().compareTo(BigDecimal.ZERO) == NumberConst.IntDef.INT_ONE) {
        if (deal.getDealQty().compareTo(deal.getReleaseQty()) > 0) {
            throw new BusinessException("LINV.RELEASE_C_ALOC", "交易数量大于商品占用释放数量！");
        }
        InvmComoAlocInventory invmComoAlocInventory = new InvmComoAlocInventory();
        // 查询条件
        invmComoAlocInventory.setLaId(source.getLogicAreaId());
        invmComoAlocInventory.setSplatCode(source.getSalePlatform());
        invmComoAlocInventory.setOwnerId(source.getOwnerId());
        invmComoAlocInventory.setOwnerCode(source.getOwnerCode());
        invmComoAlocInventory.setOwnerType(source.getOwnerType());
        invmComoAlocInventory.setCommodityId(source.getCommodityId());
        invmComoAlocInventory.setIvType(source.getIvType());
        invmComoAlocInventory.setUom(source.getUom());
        invmComoAlocInventory.setComoIvType(source.getComoIvType());
        invmComoAlocInventory.setAlocQty(BigDecimal.valueOf(0).subtract(deal.getReleaseQty()));
        invmComoAlocInventory.setTgtId(deal.getTargetId());
        invmComoAlocInventory.setTgtCode(deal.getTargetCode());
        invmComoAlocInventory.setTgtType(deal.getTargetType());
        invmComoAlocInventory.setBizType(deal.getBizType());

        // 插入商品占用交易明细
        InvmComoAlocDealDetail dealDetail = new InvmComoAlocDealDetail();

        dealDetail.setTransactionId(deal.getTransactionId());
        dealDetail.setTransactionNo(deal.getTransactionNo());
        dealDetail.setTransactionDetailId(deal.getTransactionDetailId());
        dealDetail.setTransactionSequence(deal.getTransactionSequence());
        dealDetail.setTransactionSource(deal.getTransactionSource());
        dealDetail.setTransactionType(LINV0105IParam.TRANSACTION_TYPE);
        dealDetail.setTransactionTime(time);
        dealDetail.setRefNo(deal.getRefNo());
        dealDetail.setBizType(deal.getBizType());
        dealDetail.setAlocQty(BigDecimal.valueOf(0).subtract(deal.getReleaseQty()));

        linvPublicMethodService.cancelOwComAloc(invmComoAlocInventory, dealDetail);
    }
    }

    @Override
    public BaseDao getBaseDao() {
        return null;
    }
}
