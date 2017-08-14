package com.bms.linv.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bms.linv.bean.entity.InvmComoAlocInventory;
import com.bms.linv.bean.entity.InvmComoInventory;
import com.bms.linv.bean.param.LINV0106IParam;
import com.bms.linv.bean.param.LINV0106ISourceParam;
import com.bms.linv.bean.result.LINV0106IResult;
import com.framework.boot.base.BaseService;

/**
 * Created by wang_haichun on 2017/4/18.
 */
public interface InvmComoInvReturnCompleteService extends BaseService {

    String TRANSACTION_TYPE = "106";

    /**
     * 货权交易退货完成接口
     */
    @Transactional
    LINV0106IResult modifyComoInvReturnComplete(List<LINV0106IParam> param);

    /**
     * 查询货权人商品占用
     */
    @Transactional(readOnly = true)
    InvmComoAlocInventory findComoAlocInv(LINV0106ISourceParam param);

    /**
     * 查询货权人商品库存
     */
    @Transactional(readOnly = true)
    InvmComoInventory findComoInv(LINV0106ISourceParam param);

    /**
     * 退货方商品库存减少
     */
    @Transactional
    int modifyComoInv(InvmComoInventory comoInventory);

}
