/*
 * 2017/04/14 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.bms.linv.services.impl;

import com.bms.linv.bean.param.LINV0112IInvParam;
import com.bms.linv.bean.param.LINV0113IParam;
import com.bms.linv.bean.result.LINV0112IInvResult;
import com.bms.linv.bean.result.LINV0113IResult;
import com.bms.linv.dao.InvmComoInventoryDao;
import com.bms.linv.dao.InvmComoInventoryRelationDao;
import com.bms.linv.services.InvmComoInventoryService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * InvmComoInventoryService接口实现类。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class InvmComoInventoryServiceImpl extends BaseServiceImpl implements InvmComoInventoryService {

    @Autowired
    private InvmComoInventoryDao invmComoInventoryDao;

    @Autowired
    private InvmComoInventoryRelationDao invmComoInventoryRelationDao;

    @Override
    public BaseDao getBaseDao() {
        return invmComoInventoryDao;
    }

    /**
     * 货权商品库存查询
     */
    @Override
    public BaseRestPaginationResult<LINV0113IResult> findComoInv(LINV0113IParam param) {
        BaseRestPaginationResult<LINV0113IResult> result = findPageList(param);
        return result;
    }

    /**
     * 平台商品总库存查询
     */
    @Override
    public List<LINV0112IInvResult> findComoInvRelation(LINV0112IInvParam param) {
        List<LINV0112IInvResult> resultList = new ArrayList<>();
        //saId不为空时，根据sald查到合伙人信息，然后分别查询买手、合伙人、平台卖家的可用库存，三者去最大
        if (null != param.getSaleId() && param.getSaleId().length > 0) {
            List<String> partner = new ArrayList<>();//买手的上级合伙人集合
                param.setPartner(null);
            //查询买手、合伙人、平台卖家，取三者最大的可用数量
            resultList = invmComoInventoryRelationDao.findAll(param);
        }else{
            //直接查询
            param.setSaleId(null);
            param.setPartner(null);
            resultList = invmComoInventoryRelationDao.findAll(param);
        }

        if (resultList.size() > 0) {
            for (int i = 0; i < resultList.size(); i++) {
                LINV0112IInvResult resultParam = new LINV0112IInvResult();
                resultParam.setCommodityId(resultList.get(i).getCommodityId());
                resultParam.setIvType(resultList.get(i).getIvType());
                LINV0112IInvResult result = invmComoInventoryRelationDao.findProductMaxQty(resultParam);
                if (null != result) {
                    if (resultList.get(i).getAvailableQty().compareTo(result.getAvailableQty()) > 0) {
                        resultList.get(i).setAvailableQty(result.getAvailableQty());
                        resultList.get(i).setTotalQty(result.getTotalQty());
                        resultList.get(i).setAllocatedQty(result.getAllocatedQty());
                        resultList.get(i).setOnhandQty(result.getOnhandQty());
                    }
                }
            }
        }
        return resultList;
    }
}


