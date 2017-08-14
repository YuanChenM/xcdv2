package com.bms.linv.dao;

import com.bms.linv.bean.entity.InvmComoAlocInventory;
import com.bms.linv.bean.entity.InvmComoBalanceInventory;
import com.bms.linv.bean.entity.InvmComoInventory;
import com.bms.linv.bean.param.LINV0106IDealParam;
import com.bms.linv.bean.param.LINV0106ISourceParam;
import com.framework.boot.base.BaseDao;

import java.util.Map;

/**
 * Created by wang_haichun on 2017/4/18.
 */
public interface InvmComoInvReturnCompleteDao extends BaseDao {

    /**
     *查询货权人商品占用
     */
    InvmComoAlocInventory findComoAlocInv(LINV0106ISourceParam param);


    /**
     *释放货权人商品占用
     */
    int modifyComoAlocInv(InvmComoAlocInventory comoAlocInventory);


    /**
     *查询货权人商品库存余量
     */
    InvmComoBalanceInventory  findComoBalanceInv(LINV0106IDealParam param);


    /**
     *查询货权人商品库存
     */
    InvmComoInventory findComoInv(LINV0106ISourceParam param);


    /**
     *退货方商品库存减少
     */
    int modifyComoInv(InvmComoInventory comoInventory);


    /**
     *查询货权人商品库存余量
     * @param map
     */
    InvmComoBalanceInventory  findComoBalanceInvRetrun(Map<String, Object> map);
}
