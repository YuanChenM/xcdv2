/*
 * 2017/04/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.linv.services.impl;

import com.bms.linv.bean.entity.InvmLoadAlocDealDetail;
import com.bms.linv.bean.entity.InvmLoadAlocInventory;
import com.bms.linv.bean.param.LINV0104IParam;
import com.bms.linv.business.LinvPublicMethodService;
import com.bms.linv.dao.InvmLoadAlocInventoryDao;
import com.bms.linv.dao.InvmLoadDealDetailDao;
import com.bms.linv.services.InvmLoadAlocInventoryService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>InvmLoadAlocInventoryService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 @Service
 public class InvmLoadAlocInventoryServiceImpl extends BaseServiceImpl implements InvmLoadAlocInventoryService {

    @Autowired
    private InvmLoadAlocInventoryDao invmLoadAlocInventoryDao;

    @Autowired
    private InvmLoadDealDetailDao invmLoadDealDetailDao;

    @Autowired
    private LinvPublicMethodService linvPublicMethodService;

    @Override
    public BaseDao getBaseDao() {
      return invmLoadAlocInventoryDao;
    }

    @Override
    public void cancelLoadAlocInvCounts(List<LINV0104IParam> invLists){

        for(LINV0104IParam param:invLists){
            // 新增一条占用明细
            InvmLoadAlocDealDetail dealDetail = BeanUtils.toBean(param,InvmLoadAlocDealDetail.class);
            dealDetail.setTransactionType(LINV0104IParam.TRANSACTION_TYPE);
            dealDetail.setTransactionTime(DateUtils.getCurrent());
            InvmLoadAlocDealDetail result =invmLoadDealDetailDao.findOne(dealDetail);
            if(result != null){
                InvmLoadAlocInventory loadAlocInv = new InvmLoadAlocInventory();
                loadAlocInv.setAlocNo(result.getAlocNo());
                linvPublicMethodService.cancelProcductAloc(loadAlocInv,dealDetail);
            }else{
                throw new BusinessException("LIVM","产品库存明细表数据为空");
            }

        }

    }
 }