/*
 * 2017/04/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.linv.services;
 import com.bms.linv.bean.param.LINV0114IParam;
 import com.bms.linv.bean.result.LINV0114IResult;
 import com.framework.base.rest.result.BaseRestPaginationResult;
 import com.framework.boot.base.BaseService;
 import org.springframework.transaction.annotation.Transactional;

/**
 * <p>InvmWhInfoService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 public interface InvmWhInfoService extends BaseService{
     /**
      * 查询仓库信息
      */
     @Transactional(readOnly = true)
     BaseRestPaginationResult<LINV0114IResult> findWhInfo(LINV0114IParam linv0114IParam);
 }