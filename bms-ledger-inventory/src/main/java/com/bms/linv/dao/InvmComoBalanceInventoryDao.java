/*
 * 2017/04/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.linv.dao;
import com.bms.linv.bean.entity.InvmComoBalanceInventory;
import com.framework.boot.base.BaseDao;

import java.util.List;

 /**
 * <p>InvmComoBalanceInventoryDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 public interface InvmComoBalanceInventoryDao extends BaseDao{

   List<InvmComoBalanceInventory> findAlltoSub(InvmComoBalanceInventory param);

 }