/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.agif.bean.entity.AgifAgentDemesne;
import com.bms.agif.bean.param.AgentDemesneParam;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerDemesneParam;
import com.bms.agif.bean.param.DemesneParam;
import com.bms.agif.constant.ApiUrlDef;
import com.bms.agif.dao.AgifAgentDemesneDao;
import com.bms.agif.dao.AgifButlerDemesneDao;
import com.bms.agif.service.AgifAgentDemesneService;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>AgifAgentDemesneService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class AgifAgentDemesneServiceImpl extends BaseServiceImpl implements AgifAgentDemesneService {

    @Autowired
    private AgifAgentDemesneDao agifAgentDemesneDao;

    @Autowired
    private AgifButlerDemesneDao agifButlerDemesneDao;

    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @Override
    public BaseDao getBaseDao() {
        return agifAgentDemesneDao;
    }

    public void updateAgifAgentDemesneInfo(BaseBean<AgentDemesneParam, AgentDemesneParam> param) {
        BaseBean<AgifAgentDemesne, AgifAgentDemesne> baseBean = new BaseBean<>();
        AgifAgentDemesne filterEntity = BeanUtils.toBean(param.getFilter(), AgifAgentDemesne.class);
        AgifAgentDemesne targetEntity = BeanUtils.toBean(param.getTarget(), AgifAgentDemesne.class);
        targetEntity.setUpdTime(DateUtils.getCurrent());
        targetEntity.setUpdId(this.getLoginUserId());
        baseBean.setFilter(filterEntity);
        baseBean.setTarget(targetEntity);
        this.modify(baseBean);
    }

    ;

    public Long addAgifAgentDemesneInfo(AgentDemesneParam param) {
        if(param.getAgentDemesneId() == null || param.getAgentDemesneId() <= 0){
            //新增的时候 关系ID为1  说明是通过区划过来的信息 不用反向在回去做区划的更新
            DemesneParam demesneParam = BeanUtils.toBean(param,DemesneParam.class);
            this.updateDemesneInfo(demesneParam);
        }
        AgifAgentDemesne bean = BeanUtils.toBean(param, AgifAgentDemesne.class);
        Long agentDemesneId = this.maxId("AGIF_AGENT_DEMESNE");
        bean.setAgentDemesneId(agentDemesneId);
        bean.setCrtId(this.getLoginUserId());
        bean.setUpdId(this.getLoginUserId());
        bean.setCrtTime(DateUtils.getCurrent());
        bean.setUpdTime(DateUtils.getCurrent());
        // 先删除管家相关信息
        agifAgentDemesneDao.deleteButlerDemesne(bean);
        //经过前台确认后 该处删除老的买手领地关联
        agifAgentDemesneDao.deleteDemesne(bean);
        // 删除重复的新增
        this.save(bean);
        return agentDemesneId;
    };

    /**
     * 通过物流区、配送站获取销售合伙人ID 更新到买手信息中
     * 备注： 正常情况根据物流区、地区、配送站信息只能查到一个销售合伙人
     * 表字段作废
     * @param param
     */
//    public void editAgifAgentInfo(AgentDemesneParam param) {
//        // 根据销售合伙人配送站信息表查找销售合伙人ID
//        PartnerDistributionRsParam partnerDistributionRsParam = BeanUtils.toBean(param,PartnerDistributionRsParam.class);
//        partnerDistributionRsParam.setPagination(null);
//        List<PartnerDistributionRsParam> list = agifPartnerDistributionDao.findPageList(partnerDistributionRsParam);
//        if(CollectionUtils.isNotEmpty(list)){
//            for (PartnerDistributionRsParam bean:list){
//                // 更新销售合伙人ID 到买手信息表中
//                AgifAgent filterAgent = new AgifAgent();
//                filterAgent.setAgentId(param.getAgentId());
//                AgifAgent targetAgent = BeanUtils.toBean(bean,AgifAgent.class);
//                targetAgent.setUpdId(this.getLoginUserId());
//                targetAgent.setUpdTime(DateUtils.getCurrent());
//                BaseBean<AgifAgent,AgifAgent> baseBean = new BaseBean<>();
//                baseBean.setFilter(filterAgent);
//                baseBean.setTarget(targetAgent);
//                agifAgentService.modify(baseBean);
//            }
//        }
//    }

    @Override
    public void deleteAgifAgentDemesneInfo(AgentDemesneParam param) {

        DemesneParam demeParam = this.findOne(param.getAgentDemesneId());
        // 先删除管家关系
        ButlerDemesneParam req = new ButlerDemesneParam();
        req.setAgentDemesneId(param.getAgentDemesneId());
        if(param.getAgentDemesneId() > NumberUtils.LONG_ZERO){
            List<ButlerDemesneParam> butlerDemesneParams = agifButlerDemesneDao.findAll(req);
            if(CollectionUtils.isNotEmpty(butlerDemesneParams)){
                ArrayList<Long> butlerDemesneIds = new ArrayList<>();
                for(ButlerDemesneParam butlerDemesneParam:butlerDemesneParams){
                    butlerDemesneIds.add(butlerDemesneParam.getButlerDemesneId());
                    agifButlerDemesneDao.remove(butlerDemesneIds);
                }
            }
        }
        // 在删除买手领地关系
        ArrayList<Long> agentDemesneIds = new ArrayList<>();
        agentDemesneIds.add(param.getAgentDemesneId());
        this.remove(agentDemesneIds);
        // 对应更新领授权合伙人信息
        demeParam.setAuthorizedAgent("");
        this.updateDemesneInfo(demeParam);

    }

    public void updateDemesneInfo(DemesneParam demeParam){
        BaseBean<DemesneParam, DemesneParam> baseBean = new BaseBean<>();
        DemesneParam filterParam = BeanUtils.toBean(demeParam,DemesneParam.class);
        DemesneParam targetParam = BeanUtils.toBean(demeParam,DemesneParam.class);
        targetParam.setDisableFlg("2");
        baseBean.setFilter(filterParam);
        baseBean.setTarget(targetParam);
        String url = ConfigServerUtils.getAPIUrl(ApiUrlDef.REGN_MODULE, ApiUrlDef.REGION.demesneUpdate);
        RestApiClient restClient = restApiClientFactory.newApiRestClient();
        Integer result = restClient.post(url, baseBean, new TypeReference<Integer>() {
        });
    }
}