package com.bms.linv.business.impl;

import com.bms.linv.bean.entity.InvmComoAlocDealDetail;
import com.bms.linv.bean.entity.InvmComoAlocInventory;
import com.bms.linv.bean.entity.InvmLoadAlocDealDetail;
import com.bms.linv.bean.entity.InvmLoadAlocInventory;
import com.bms.linv.bean.param.*;
import com.bms.linv.business.LinvAllocationBusinessService;
import com.bms.linv.business.LinvPublicMethodService;
import com.bms.linv.dao.InvmComoAlocDealDetailDao;
import com.bms.linv.dao.InvmLoadAlocDealDetailDao;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by zheng_xu on 2017/4/14.
 */
@Service
public class LinvAllocationBusinessServiceImpl extends BaseServiceImpl implements LinvAllocationBusinessService {
    @Autowired
    private LinvPublicMethodService linvPublicMethodService;
    @Autowired
    private InvmLoadAlocDealDetailDao invmLoadAlocDealDetailDao;
    @Autowired
    private InvmComoAlocDealDetailDao invmComoAlocDealDetailDao;

    /**
     * 产品库存占用
     * 
     * @param param
     */
    @Override
    public void allocatedProduct(List<LINV0103IParam> param) {
        Date time = DateUtils.getCurrent();
        String sign = "WMS";
        //业务单号重复验证
        checkProductAlocTran(param);

        for (LINV0103IParam linv0103IParam : param) {
            //封装对象
            InvmLoadAlocInventory loadAlocParam = linv0103IParam.searchLoadAlocParam();
            InvmLoadAlocDealDetail dealDetail = linv0103IParam.saveLoadAlocDetailParam(sign, time);
            //调用共通
            linvPublicMethodService.alocProduct(loadAlocParam, dealDetail);
        }
    }

    /**
     * 产品库存占用业务单号重复验证
     *
     * @param param
     */
    private void checkProductAlocTran(List<LINV0103IParam> param) {
        for (int i = 0; i < param.size(); i++) {
            LINV0103IAllocationParam allocation = param.get(i).getAllocation();
            InvmLoadAlocDealDetail dealDetail = new InvmLoadAlocDealDetail();
            dealDetail.setTransactionId(allocation.getTransactionId());
            dealDetail.setTransactionNo(allocation.getTransactionNo());
            dealDetail.setTransactionDetailId(allocation.getTransactionDetailId());
            dealDetail.setTransactionSequence(allocation.getTransactionSequence());
            int count = invmLoadAlocDealDetailDao.count(dealDetail);
            if (count > 0) {
                throw new BusinessException("LINV.P_ALLOCATED", "业务单号重复");
            }
        }
    }

    /**
     * 产品占用取消
     * 
     * @param params
     */
    @Override
    public void cancelProcductAloc(List<LINV0104IParam> params) {
        for (int i = 0; i < params.size(); i++) {
            LINV0104IParam invParam = params.get(i);
            InvmLoadAlocDealDetail dealDetail = new InvmLoadAlocDealDetail();
            dealDetail.setTransactionId(invParam.getTransactionId());
            dealDetail.setTransactionNo(invParam.getTransactionNo());
            dealDetail.setTransactionDetailId(invParam.getTransactionDetailId());
            dealDetail.setTransactionSource(invParam.getTransactionSource());
            dealDetail.setTransactionSequence(invParam.getTransactionSequence());
            dealDetail.setBizType(invParam.getBizType());

            InvmLoadAlocDealDetail invResult = invmLoadAlocDealDetailDao.querySumQtyByTran(dealDetail);
            if (invResult != null) {
                //check取消数量
                if (invParam.getCancelQty().compareTo(invResult.getAlocQty()) > 0) {
                    throw new BusinessException("LINV.CANCEL_P_ALOC", "取消数量大于当前业务单号对应的占用数量");
                }
                InvmLoadAlocInventory loadAlocInv = new InvmLoadAlocInventory();
                loadAlocInv.setAlocNo(invResult.getAlocNo());
                loadAlocInv.setAlocQty(BigDecimal.valueOf(0).subtract(invParam.getCancelQty()));

                InvmLoadAlocDealDetail loadAlocDetail = new InvmLoadAlocDealDetail();
                loadAlocDetail.setTransactionId(invParam.getTransactionId());
                loadAlocDetail.setTransactionNo(invParam.getTransactionNo());
                loadAlocDetail.setTransactionDetailId(invParam.getTransactionDetailId());
                loadAlocDetail.setTransactionSource(invParam.getTransactionSource());
                loadAlocDetail.setTransactionSequence(invParam.getTransactionSequence());
                loadAlocDetail.setTransactionType(LINV0104IParam.TRANSACTION_TYPE);
                loadAlocDetail.setTransactionTime(DateUtils.getCurrent());
                loadAlocDetail.setBizType(invParam.getBizType());
                loadAlocDetail.setAlocQty(BigDecimal.valueOf(0).subtract(invParam.getCancelQty()));
                linvPublicMethodService.cancelProcductAloc(loadAlocInv, loadAlocDetail);
            } else {
                throw new BusinessException("LINV.CANCEL_P_ALOC", "未查询到当前产品占用明细记录！");
            }
        }
    }

    /**
     * 货权人商品占用
     * 
     * @param param
     */
    @Override
    public void allocatedComm(List<LINV0107IParam> param) {
        Date time = DateUtils.getCurrent();
        String sign = "WMS";
        //业务单号重复验证
        checkComoAlocTran(param);

        for (LINV0107IParam linv0107IParam : param) {
            //封装对象
            InvmComoAlocInventory comoAlocInv = linv0107IParam.searchCommAloc();
            InvmComoAlocDealDetail comoAlocDetail = linv0107IParam.saveComAlocDetail(sign, time);
            //调用共通
            linvPublicMethodService.alocOwComm(comoAlocInv, comoAlocDetail);
        }
    }

    /**
     * 商品库存占用业务单号重复验证
     *
     * @param param
     */
    private void checkComoAlocTran(List<LINV0107IParam> param) {
        for (int i = 0; i < param.size(); i++) {
            LINV0107IAllocationParam allocation = param.get(i).getAllocation();
            InvmComoAlocDealDetail dealDetail = new InvmComoAlocDealDetail();
            dealDetail.setTransactionId(allocation.getTransactionId());
            dealDetail.setTransactionNo(allocation.getTransactionNo());
            dealDetail.setTransactionDetailId(allocation.getTransactionDetailId());
            dealDetail.setTransactionSequence(allocation.getTransactionSequence());
            int count = invmComoAlocDealDetailDao.count(dealDetail);
            if (count > 0) {
                throw new BusinessException("LINV.C_ALLOCATED", "业务单号重复");
            }
        }
    }

    /**
     * 货权人商品占用取消
     * 
     * @param params
     */
    @Override
    public void cancelOwComAloc(List<LINV0108IParam> params) {
        for (int i = 0; i < params.size(); i++) {
            LINV0108IParam invParam=params.get(i);
            InvmComoAlocDealDetail dealDetail = new InvmComoAlocDealDetail();
            dealDetail.setTransactionId(invParam.getTransactionId());
            dealDetail.setTransactionNo(invParam.getTransactionNo());
            dealDetail.setTransactionDetailId(invParam.getTransactionDetailId());
            dealDetail.setTransactionSource(invParam.getTransactionSource());
            dealDetail.setTransactionSequence(invParam.getTransactionSequence());
            dealDetail.setBizType(invParam.getBizType());
            InvmComoAlocDealDetail invResult = invmComoAlocDealDetailDao.querySumQtyByTran(dealDetail);
            if(invResult != null){
                // check数量
                if (invParam.getCancelQty().compareTo(invResult.getAlocQty()) > 0) {
                    throw new BusinessException("LINV.CANCEL_C_ALOC", "取消数量大于当前业务单号对应的占用数量");
                }
                InvmComoAlocInventory comoAlocInv = new InvmComoAlocInventory();
                comoAlocInv.setAlocNo(invResult.getAlocNo());
                comoAlocInv.setAlocQty(BigDecimal.valueOf(0).subtract(invParam.getCancelQty()));

                InvmComoAlocDealDetail comoAlocDetail = new InvmComoAlocDealDetail();
                comoAlocDetail.setTransactionId(invParam.getTransactionId());
                comoAlocDetail.setTransactionNo(invParam.getTransactionNo());
                comoAlocDetail.setTransactionDetailId(invParam.getTransactionDetailId());
                comoAlocDetail.setTransactionSource(invParam.getTransactionSource());
                comoAlocDetail.setTransactionSequence(invParam.getTransactionSequence());
                comoAlocDetail.setTransactionTime(DateUtils.getCurrent());
                comoAlocDetail.setTransactionType(LINV0108IParam.TRANSACTION_TYPE);
                comoAlocDetail.setAlocQty(BigDecimal.valueOf(0).subtract(invParam.getCancelQty()));
                comoAlocDetail.setBizType(invParam.getBizType());

                linvPublicMethodService.cancelOwComAloc(comoAlocInv,comoAlocDetail);
            }else{
                throw new BusinessException("LINV.CANCEL_C_ALOC", "未查询到当前货权人商品占用明细记录");
            }
        }
    }

    /**
     * 货权人商品占用修改
     *
     * @param param
     */
    @Override
    public void modifyCommAloc(List<LINV0109IParam> param) {
        Date time = DateUtils.getCurrent();
        String sign = "WMS";
        for (LINV0109IParam linv0109IParam : param) {
            LINV0109ISourceParam source = linv0109IParam.getSource();
            LINV0109IAllocationParam allocation = linv0109IParam.getAllocation();

            InvmComoAlocDealDetail comoAlocDetail = new InvmComoAlocDealDetail();
            comoAlocDetail.setTransactionId(allocation.getTransactionId());
            comoAlocDetail.setTransactionNo(allocation.getTransactionNo());
            comoAlocDetail.setTransactionDetailId(allocation.getTransactionDetailId());
            comoAlocDetail.setTransactionSource(allocation.getTransactionSource());
            comoAlocDetail.setTransactionSequence(allocation.getTransactionSequence());
            comoAlocDetail.setBizType(allocation.getBizType());
            InvmComoAlocDealDetail invResult = invmComoAlocDealDetailDao.querySumQtyByTran(comoAlocDetail);
            if (null != invResult) {
                // check数量
                if (allocation.getOldAlocQty().compareTo(invResult.getAlocQty()) != 0) {
                    throw new BusinessException("LINV.CANCEL_C_ALOC", "原占用数量不符合当前业务单号对应的占用数量");
                }
            // 1、货权人商品占用释放
            InvmComoAlocInventory cancelComoAloc = linv0109IParam.searchCommAloc();
                cancelComoAloc.setAlocQty(BigDecimal.valueOf(0).subtract(allocation.getOldAlocQty()));
            InvmComoAlocDealDetail cancelComoAlocDeal = linv0109IParam.saveComAlocDetail(sign, time);
                cancelComoAlocDeal.setAlocQty(BigDecimal.valueOf(0).subtract(allocation.getOldAlocQty()));
            linvPublicMethodService.cancelOwComAloc(cancelComoAloc, cancelComoAlocDeal);
            // 2、货权人商品占用
            InvmComoAlocInventory comoAlocInv = linv0109IParam.searchCommAloc();
                comoAlocInv.setAlocQty(allocation.getNewAlocQty());
                InvmComoAlocDealDetail comoAlocDealDetail = linv0109IParam.saveComAlocDetail(sign, time);
                comoAlocDealDetail.setAlocQty(allocation.getNewAlocQty());
                linvPublicMethodService.alocOwComm(comoAlocInv, comoAlocDealDetail);
            } else {
                throw new BusinessException("LINV.CANCEL_C_ALOC", "未查询到当前业务单号对应占用明细记录");
            }
        }
    }

    @Override
    public BaseDao getBaseDao() {
        return null;
    }
}
