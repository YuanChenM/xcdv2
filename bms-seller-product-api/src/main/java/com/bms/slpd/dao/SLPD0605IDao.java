package com.bms.slpd.dao;

import com.bms.slpd.bean.result.field.SLPD0605IDifFedStdResult;
import com.bms.slpd.bean.result.field.SLPD0605IFedStdResult;
import com.framework.boot.base.BaseDao;

import java.io.Serializable;
import java.util.List;

/*
 *查询饲养指标档案卡与差异卡
 */
public interface SLPD0605IDao extends BaseDao {

    List<SLPD0605IFedStdResult> searchStd(Serializable var1);

    List<SLPD0605IDifFedStdResult> searchDif(Serializable var1);


}