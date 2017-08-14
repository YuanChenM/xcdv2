/*
 * 2017/04/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.linv.services.impl;
import com.bms.linv.bean.param.LINV0114IParam;
import com.bms.linv.bean.result.LINV0114IResult;
import com.bms.linv.dao.InvmWhInfoDao;
import com.bms.linv.services.InvmWhInfoService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
 import com.framework.boot.base.BaseServiceImpl;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 /**
 * <p>InvmWhInfoService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 @Service
 public class InvmWhInfoServiceImpl extends BaseServiceImpl implements InvmWhInfoService {

    @Autowired
    private InvmWhInfoDao invmWhInfoDao;

    @Override
    public BaseDao getBaseDao() {
      return invmWhInfoDao;
    }

     public BaseRestPaginationResult<LINV0114IResult> findWhInfo(LINV0114IParam linv0114IParam){
         return this.findPageList(linv0114IParam);
     }
 }