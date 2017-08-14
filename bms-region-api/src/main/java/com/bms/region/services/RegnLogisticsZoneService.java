/*
 * 2017/02/16 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.region.services;

import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.RegnLogisticsZoneParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>RegnLogisticsCityService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 public interface RegnLogisticsZoneService extends BaseService{

  @Transactional
  int addLogisticsCity(RegnLogisticsZoneParam logisticsCityParam);

  @Transactional
  void updateLogisticsCity(BaseBean<RegnLogisticsZoneParam,RegnLogisticsZoneParam> logisticsCityParam);

 }