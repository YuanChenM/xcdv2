/*
 * 2017/04/14 自动生成 新規作成
 * (c) 江苏润和.
 */
 package com.bms.linv.dao;

import com.bms.linv.bean.param.LINV0116IParam;
import com.bms.linv.bean.result.LINV0116ISrcListResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

 /**
 * <p>
 * InvmComoBalanceDealDetailDao接口。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
 public interface InvmComoBalanceDealDetailDao extends BaseDao{

    List<LINV0116ISrcListResult> findOutBoundInfo(LINV0116IParam param);
 }