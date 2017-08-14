/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.bymt.dao;

import com.bms.bymt.bean.param.FoodGradeInfoParam;
import com.bms.bymt.bean.result.FoodGradeRsResult;
import com.framework.boot.base.BaseDao;
 /**
 * <p>BymtFoodGradeInfoDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 public interface BymtFoodGradeInfoDao extends BaseDao{
  FoodGradeRsResult findBuyerMarketFoodDefineGrade(FoodGradeInfoParam gradeInfoParam);
 }