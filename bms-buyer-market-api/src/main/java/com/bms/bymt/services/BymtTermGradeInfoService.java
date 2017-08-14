/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.bymt.services;

import com.bms.bymt.bean.param.TermGradeInfoParam;
import com.bms.bymt.bean.result.TerminalModuleDefGradeResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>BymtTermGradeInfoService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 public interface BymtTermGradeInfoService extends BaseService{

  @Transactional
  public long addTermGradeInfo(TermGradeInfoParam reqParam);

  @Transactional(readOnly = true)
  public TerminalModuleDefGradeResult findBuyerMarketTerminalDefineGrade(TermGradeInfoParam gradeInfoParam);

 }