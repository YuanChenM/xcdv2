/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.bymt.services;

import com.bms.bymt.bean.param.TermGradeResultParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>BymtTermGradeResultService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 public interface BymtTermGradeResultService extends BaseService{

  @Transactional
  long addTermGradeResult(TermGradeResultParam reqParam);
 }