/*
 * 2017/02/16 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
 package com.bms.region.services.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.region.bean.entity.RegnLogisticsDistribution;
import com.bms.region.bean.param.*;
import com.bms.region.bean.result.LogisticsDistributionRsResult;
import com.bms.region.bean.result.LogisticsZoneRestResult;
import com.bms.region.constant.ApiUrlDef;
import com.bms.region.dao.RegnLogisticsDistributionDao;
import com.bms.region.dao.RegnLogisticsZoneDao;
import com.bms.region.services.RegnCommonService;
import com.bms.region.services.RegnLogisticsDistributionService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <p>RegnLogisticsDistributionService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
 @Service
 public class RegnLogisticsDistributionServiceImpl extends BaseServiceImpl implements RegnLogisticsDistributionService{

    @Autowired
    private RegnLogisticsDistributionDao regnLogisticsDistributionDao;

    @Autowired
    private RegnCommonService regnCommonService;

    @Autowired
    private RegnLogisticsZoneDao regnLogisticsZoneDao;

    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @Override
    public BaseDao getBaseDao() {
      return regnLogisticsDistributionDao;
    }

     @Override
     public int add(RegnLogDistributionParam param){

         int checkNum = regnLogisticsDistributionDao.getParamCount(param);
         if (checkNum > NumberUtils.INTEGER_ZERO) {
             throw new BusinessException("region", "REGN.E00013");
         }
         RegnLogisticsDistribution distribution = BeanUtils.toBean(param,RegnLogisticsDistribution.class);
         distribution.setDistributionId(this.maxId("REGN_LOGISTICS_DISTRIBUTION"));
         String maxCode = regnLogisticsDistributionDao.findMaxCode(param);
         if(maxCode == null){
             distribution.setDistributionCode("01");
         }else{
             distribution.setDistributionCode(maxCode);
         }
         distribution.setCrtId(this.getLoginUserId());
         distribution.setUpdId(this.getLoginUserId());
         distribution.setCrtTime(DateUtils.getCurrent());
         distribution.setUpdTime(DateUtils.getCurrent());
         distribution.setVersion(NumberConst.IntDef.INT_ONE);
         int res = this.save(distribution);
         if(StringUtils.isNotEmpty(param.getPartnerId())){
            // 买手系统 销售合伙人配送站关联关系表插入数据信息
             param.setDistributionId(distribution.getDistributionId());
             param.setDistributionCode(distribution.getDistributionCode());
             this.doWorkPartnerInfo(param);
         }
         return res;
     }

     @Override
     public void update(BaseBean<RegnLogDistributionParam, RegnLogDistributionParam> paramBaseBean) {
         BaseBean<RegnLogisticsDistribution,RegnLogisticsDistribution> bean = new BaseBean<>();
         RegnLogisticsDistribution filterEntity = BeanUtils.toBean(paramBaseBean.getFilter(), RegnLogisticsDistribution.class);
         RegnLogisticsDistribution targetEntity = BeanUtils.toBean(paramBaseBean.getTarget(), RegnLogisticsDistribution.class);
         targetEntity.setUpdTime(DateUtils.getCurrent());
         targetEntity.setUpdId(this.getLoginUserId());
         if(targetEntity.getDisableFlg() == null || targetEntity.getDisableFlg().equals("1")) {
             paramBaseBean.getTarget().setDistributionId(filterEntity.getDistributionId());
             int checkNum = regnLogisticsDistributionDao.getParamCount(paramBaseBean.getTarget());
             if (checkNum > NumberUtils.INTEGER_ZERO) {
                 throw new BusinessException("region", "REGN.E00013");
             }
             // 如果名称和类型变动或者删除 才校验 否则不做校验处理
             RegnLogDistributionParam param = new RegnLogDistributionParam();
             param.setDistributionId(filterEntity.getDistributionId());
             LogisticsDistributionRsResult disResult = regnLogisticsDistributionDao.findOne(param);
             if(!disResult.getDistributionName().equals(targetEntity.getDistributionName())
                     || !disResult.getDistributionType().equals(targetEntity.getDistributionType())){
                 // 优先验证其他系统是否已经使用
                 HashMap<String,Long> checkParam = new HashMap<>();
                 checkParam.put("distributionId",filterEntity.getDistributionId());
                 regnCommonService.checkSystemUse(checkParam);
             }
         }else if("0".equals(targetEntity.getDisableFlg())){
             HashMap<String,Long> checkParam = new HashMap<>();
             checkParam.put("distributionId",filterEntity.getDistributionId());
             regnCommonService.checkSystemUse(checkParam);
         }
         if(targetEntity.getDisableFlg() != null && targetEntity.getDisableFlg().equals("2")){
             targetEntity.setDisableFlg(null);
             targetEntity.setDistributionCode(null);
             targetEntity.setDistributionName(null);
             targetEntity.setZoneId(null);
         }
         bean.setFilter(filterEntity);
         bean.setTarget(targetEntity);

         regnLogisticsDistributionDao.modify(bean);

         if(StringUtils.isNotEmpty(paramBaseBean.getTarget().getPartnerId())){
             // 補全信息
             paramBaseBean.getTarget().setDistributionId(paramBaseBean.getFilter().getDistributionId());
             this.doWorkPartnerInfo(paramBaseBean.getTarget());
         }
     }

     public void doWorkPartnerInfo(RegnLogDistributionParam soures){
         RegnLogisticsZoneParam zoneParam = new RegnLogisticsZoneParam();
         zoneParam.setZoneId(soures.getZoneId());
         LogisticsZoneRestResult zone = regnLogisticsZoneDao.findOne(zoneParam);
         RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
         ArrayList<AgifDistributionParam> list = new ArrayList<>();
         AgifDistributionParam addAgifDistributionParam = BeanUtils.toBean(soures,AgifDistributionParam.class);
         addAgifDistributionParam.setId(NumberUtils.LONG_ONE);
         try{
             BeanUtils.copyProperties(addAgifDistributionParam,zone);
         }catch (Exception e){
         }
         String addUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.AGIF_MODULE,ApiUrlDef.AGIF.addPartnerDistribution);
         list.add(addAgifDistributionParam);
         restApiClient.post(addUrl, list, new TypeReference<Integer>(){});
     }
 }