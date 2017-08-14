/*
 * 2017/02/16 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.region.services.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.region.bean.entity.RegnLogisticsDemesne;
import com.bms.region.bean.param.*;
import com.bms.region.bean.result.LogisticsDistributionRsResult;
import com.bms.region.constant.ApiUrlDef;
import com.bms.region.dao.RegnLogisticsDemesneDao;
import com.bms.region.dao.RegnLogisticsDistributionDao;
import com.bms.region.services.RegnCommonService;
import com.bms.region.services.RegnLogisticsDemesneService;
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

import java.util.HashMap;

/**
 * <p>RegnLogisticsDemesneService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class RegnLogisticsDemesneServiceImpl extends BaseServiceImpl implements RegnLogisticsDemesneService {

    @Autowired
    private RegnLogisticsDemesneDao regnLogisticsDemesneDao;

    @Autowired
    private RegnCommonService regnCommonService;

    @Autowired
    private RegnLogisticsDistributionDao regnLogisticsDistributionDao;

    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @Override
    public BaseDao getBaseDao() {
        return regnLogisticsDemesneDao;
    }

    @Override
    public void update(BaseBean<RegnLogDemesneParam, RegnLogDemesneParam> paramBaseBean) {
        BaseBean<RegnLogisticsDemesne, RegnLogisticsDemesne> bean = new BaseBean<>();
        RegnLogisticsDemesne filterEntity = BeanUtils.toBean(paramBaseBean.getFilter(), RegnLogisticsDemesne.class);
        RegnLogisticsDemesne targetEntity = BeanUtils.toBean(paramBaseBean.getTarget(), RegnLogisticsDemesne.class);
        targetEntity.setUpdTime(DateUtils.getCurrent());
        targetEntity.setUpdId(this.getLoginUserId());
        bean.setFilter(filterEntity);
        bean.setTarget(targetEntity);
        if (targetEntity.getDisableFlg() == null || targetEntity.getDisableFlg().equals("1")) {
            paramBaseBean.getTarget().setDemesneId(filterEntity.getDemesneId());
            int checkNum = regnLogisticsDemesneDao.getParamCount(paramBaseBean.getTarget());
            if (checkNum > NumberUtils.INTEGER_ZERO) {
                throw new BusinessException("region", "REGN.E00013");
            }
            // 如果名称和类型变动或者删除 才校验 否则不做校验处理
            RegnLogDemesneParam oneParam = new RegnLogDemesneParam();
            oneParam.setDemesneId(filterEntity.getDemesneId());
            RegnLogDemesneParam oneResult = regnLogisticsDemesneDao.findOne(oneParam);
            if(!oneResult.getDemesneName().equals(targetEntity.getDemesneName())
                    || !oneResult.getDemesneType().equals(targetEntity.getDemesneType())){
                // 优先验证其他系统是否已经使用
                HashMap<String,Long> checkParam = new HashMap<>();
                checkParam.put("demesneId",filterEntity.getDemesneId());
                regnCommonService.checkSystemUse(checkParam);
            }
        }else if("0".equals(targetEntity.getDisableFlg())){
            // 优先验证其他系统是否已经使用
            HashMap<String,Long> checkParam = new HashMap<>();
            checkParam.put("demesneId",filterEntity.getDemesneId());
            regnCommonService.checkSystemUse(checkParam);
        }
        if (targetEntity.getDisableFlg() != null && targetEntity.getDisableFlg().equals("2")) {
            targetEntity.setDisableFlg(null);
            targetEntity.setDemesneCode(null);
            targetEntity.setDemesneName(null);
            targetEntity.setDistributionId(null);
        }
        regnLogisticsDemesneDao.modify(bean);

        if (StringUtils.isNotEmpty(paramBaseBean.getTarget().getAgentId())) {
            paramBaseBean.getTarget().setDemesneId(paramBaseBean.getFilter().getDemesneId());
            this.doWorkAgentInfo(paramBaseBean.getTarget());
        }


    }

    @Override
    public int add(RegnLogDemesneParam param) {
        int checkNum = regnLogisticsDemesneDao.getParamCount(param);
        if (checkNum > NumberUtils.INTEGER_ZERO) {
            throw new BusinessException("region", "REGN.E00013");
        }
        RegnLogisticsDemesne demesne = BeanUtils.toBean(param, RegnLogisticsDemesne.class);
        demesne.setDemesneId(this.maxId("REGN_LOGISTICS_DEMESNE"));
        String maxCode = regnLogisticsDemesneDao.findMaxCode(param);
        if (maxCode != null) {
            demesne.setDemesneCode(maxCode);
        } else {
            demesne.setDemesneCode("01");
        }
        demesne.setCrtId(this.getLoginUserId());
        demesne.setUpdId(this.getLoginUserId());
        demesne.setCrtTime(DateUtils.getCurrent());
        demesne.setUpdTime(DateUtils.getCurrent());
        demesne.setVersion(NumberConst.IntDef.INT_ONE);
        int res = this.save(demesne);
        if (StringUtils.isNotEmpty(param.getAgentId())) {
            param.setDemesneId(demesne.getDemesneId());
            param.setDemesneCode(demesne.getDemesneCode());
            this.doWorkAgentInfo(param);
        }
        return res;
    }

    public void doWorkAgentInfo(RegnLogDemesneParam soures) {
        RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
        RegnLogDistributionParam param = new RegnLogDistributionParam();
        param.setDistributionId(soures.getDistributionId());
        LogisticsDistributionRsResult disResult = regnLogisticsDistributionDao.findOne(param);
        AgentDemesneParam demesneParam = BeanUtils.toBean(soures, AgentDemesneParam.class);
        try{
            BeanUtils.copyProperties(demesneParam,disResult);
        }catch (Exception e){
        }
        demesneParam.setAgentDemesneId(NumberUtils.LONG_ONE); // 用於提醒買手 是通過區劃過去的新增
        String addUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.AGIF_MODULE, ApiUrlDef.AGIF.addAgentDemesneInfo);
        restApiClient.post(addUrl, demesneParam, new TypeReference<Integer>() {
        });
    }
}