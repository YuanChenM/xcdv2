/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.agif.bean.entity.AgifPartnerDistribution;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.LogisDistributionRsParm;
import com.bms.agif.bean.param.PartnerDistributionRsParam;
import com.bms.agif.constant.ApiUrlDef;
import com.bms.agif.dao.AgifPartnerDistributionDao;
import com.bms.agif.service.AgifPartnerDistributionService;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>AgifPartnerDistributionService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class AgifPartnerDistributionServiceImpl extends BaseServiceImpl implements AgifPartnerDistributionService {
    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @Autowired
    private AgifPartnerDistributionDao AgifPartnerDistributionDao;
    /*@Autowired
    private AgifAgentDemesneDao agifAgentDemesneDao;
    @Autowired
    private AgifButlerDemesneDao agifButlerDemesneDao;*/

    @Override
    public BaseDao getBaseDao() {
        return AgifPartnerDistributionDao;
    }

    @Override
    public int findLgcsAreaIsExist(PartnerDistributionRsParam distributionRsParam) {
        return AgifPartnerDistributionDao.findLgcsAreaIsExist(distributionRsParam);
    }

    @Override
    public int saveDistribution(PartnerDistributionRsParam distributionRsParam) {
        int result = NumberConst.IntDef.INT_ZERO;
        this.remove(distributionRsParam);
        if (distributionRsParam.getId() == null) {
            //更新物流区配送站授权合伙人信息
            BaseBean<LogisDistributionRsParm, LogisDistributionRsParm> baseBean = new BaseBean<>();
            LogisDistributionRsParm distributionParmFilter = new LogisDistributionRsParm();
            distributionParmFilter.setDistributionId(distributionRsParam.getDistributionId());
            LogisDistributionRsParm distributionParmTarget = new LogisDistributionRsParm();
            distributionParmTarget.setAuthorizedPartner(distributionRsParam.getAuthorizedPartner());
            distributionParmTarget.setDistributionType(distributionRsParam.getDistributionType());
            distributionParmTarget.setDistributionCode(distributionRsParam.getDistributionCode());
            distributionParmTarget.setDistributionName(distributionRsParam.getDistributionName());
            distributionParmTarget.setDisableFlg(StringUtils.toString(NumberConst.IntDef.INT_TWO));
            baseBean.setFilter(distributionParmFilter);
            baseBean.setTarget(distributionParmTarget);
            //String url = ApiUrlDef.REGION_ENV + ApiUrlDef.REGION.distributionUpdate;
            String url = ConfigServerUtils.getAPIUrl(ApiUrlDef.REGN_MODULE, ApiUrlDef.REGION.distributionUpdate);
            RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
            Integer updateResult = restApiClient.post(url, baseBean, new TypeReference<Integer>() {
            });
            Date currentDate = DateUtils.getCurrent();
            String loginUserId = this.getLoginUserId();
            AgifPartnerDistribution partnerDistribution = BeanUtils.toBean(distributionRsParam, AgifPartnerDistribution.class);
            Long id = this.maxId("AGIF_PARTNER_DISTRIBUTION");
            partnerDistribution.setId(id);
            partnerDistribution.setUpdId(loginUserId);
            partnerDistribution.setUpdTime(currentDate);
            partnerDistribution.setCrtId(loginUserId);
            partnerDistribution.setCrtTime(currentDate);
            partnerDistribution.setDelFlg(false);
            partnerDistribution.setVersion(NumberConst.IntDef.INT_ONE);
            result = this.save(partnerDistribution);
        } else {
            Date currentDate = DateUtils.getCurrent();
            String loginUserId = this.getLoginUserId();
            AgifPartnerDistribution partnerDistribution = BeanUtils.toBean(distributionRsParam, AgifPartnerDistribution.class);
            Long id = this.maxId("AGIF_PARTNER_DISTRIBUTION");
            partnerDistribution.setId(id);
            partnerDistribution.setUpdId(loginUserId);
            partnerDistribution.setUpdTime(currentDate);
            partnerDistribution.setCrtId(loginUserId);
            partnerDistribution.setCrtTime(currentDate);
            partnerDistribution.setDelFlg(false);
            partnerDistribution.setVersion(NumberConst.IntDef.INT_ONE);
            result = this.save(partnerDistribution);
        }

        return result;
    }

    @Override
    public int findDistributionIsExist(PartnerDistributionRsParam distributionRsParam) {
        return AgifPartnerDistributionDao.findDistributionIsExist(distributionRsParam);
    }

   /* @Override
    public int deletePartnerDistribution(PartnerDistributionRsParam distributionRsParam) {
        int result = NumberConst.IntDef.INT_ZERO;
        //先删除买手领地管家关系
        AgentDemesneParam demesneParam = new AgentDemesneParam();
        demesneParam.setDistributionId(distributionRsParam.getDistributionId());
        //查询要删除的买手领地信息
        List<AgentDemesneParam> demesneParamList = agifAgentDemesneDao.findAll(demesneParam);
        AgentDemesneParam agentDemesneParam = null;
        if (CollectionUtils.isNotEmpty(demesneParamList)) {
            ArrayList<Long> agentDemesneIds = new ArrayList<>();
            for (int i = NumberConst.IntDef.INT_ZERO; i < demesneParamList.size(); i++) {
                agentDemesneParam = demesneParamList.get(i);
                //查询要删除的管家领地信息
                ButlerDemesneParam butlerDemesneParam = new ButlerDemesneParam();
                butlerDemesneParam.setAgentDemesneId(agentDemesneParam.getAgentDemesneId());
                List<ButlerDemesneParam> butlerDemesneParams = agifButlerDemesneDao.findAll(butlerDemesneParam);
                if (CollectionUtils.isNotEmpty(butlerDemesneParams)) {
                    ArrayList<Long> butlerDemesneIds = new ArrayList<>();
                    for (ButlerDemesneParam butlerDemesne : butlerDemesneParams) {
                        butlerDemesneIds.add(butlerDemesne.getButlerDemesneId());
                        int count = agifButlerDemesneDao.remove(butlerDemesneIds);
                        result += count;
                    }
                }
                agentDemesneIds.add(agentDemesneParam.getAgentDemesneId());
                int count = agifAgentDemesneDao.remove(agentDemesneIds);
                result += count;
            }
        }
        return result;
    }*/

    /*@Override
    public int savePartnerDistributions(List<AgifPartnerDistribution> partnerDistributions) {
        List<List<AgifPartnerDistribution>> list = RestCommUtil.insertRanking(partnerDistributions);
        int result = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(list)) {
            int listCount = list.size();
            for (int i = NumberConst.IntDef.INT_ZERO; i < listCount; i++) {
                int res = this.batchSave(list.get(i));
                result = result + res;
            }
        }
        return result;
    }*/
}