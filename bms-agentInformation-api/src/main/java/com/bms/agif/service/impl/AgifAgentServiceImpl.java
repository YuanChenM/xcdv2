/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service.impl;

import com.bms.agif.bean.entity.AgifAccount;
import com.bms.agif.bean.entity.AgifAgent;
import com.bms.agif.bean.entity.AgifAgentAccount;
import com.bms.agif.bean.param.*;
import com.bms.agif.dao.AgifAgentDao;
import com.bms.agif.dao.AgifButlerDao;
import com.bms.agif.dao.AgifPartnerDao;
import com.bms.agif.service.AgifAccountService;
import com.bms.agif.service.AgifAgentDemesneService;
import com.bms.agif.service.AgifAgentService;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.*;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <p>AgifAgentService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class AgifAgentServiceImpl extends BaseServiceImpl implements AgifAgentService {

    @Autowired
    private AgifAgentDao AgifAgentDao;

    @Autowired
    private AgifPartnerDao agifPartnerDao;

    @Autowired
    private AgifAccountService agifAccountService;

    @Autowired
    private AgifAgentDemesneService agifAgentDemesneService;

    @Autowired
    private AgifButlerDao agifButlerDao;

    @Override
    public BaseDao getBaseDao() {
        return AgifAgentDao;
    }

    @Override
    public String addAgifAgentInfo(AccountParam param) {
        int nameCount = this.getCount(param);
        if (nameCount > NumberUtils.INTEGER_ZERO) {
            throw new BusinessException("agif", "AGIF.E02001");
        }
        AgifAgent bean = BeanUtils.toBean(param, AgifAgent.class);
        String agentCode = this.agifPartnerDao.findAgentCode();
        String butlerCode = this.agifPartnerDao.findButlerCode();
        String partnerCode = this.agifPartnerDao.findPartnerCode();
        if (Integer.valueOf(partnerCode) > Integer.valueOf(agentCode)) {
            if (Integer.valueOf(partnerCode) > Integer.valueOf(butlerCode)) {
                bean.setAgentCode(StringUtils.toString(partnerCode));
            } else {
                bean.setAgentCode(StringUtils.toString(butlerCode));
            }
        } else {
            if (Integer.valueOf(agentCode) > Integer.valueOf(butlerCode)) {
                bean.setAgentCode(StringUtils.toString(agentCode));
            } else {
                bean.setAgentCode(StringUtils.toString(butlerCode));
            }
        }
        UUID uid = UUID.randomUUID();
        bean.setAgentId(uid.toString());
        bean.setCrtId(this.getLoginUserId());
        bean.setUpdId(this.getLoginUserId());
        bean.setCrtTime(DateUtils.getCurrent());
        bean.setUpdTime(DateUtils.getCurrent());
        int agentCount = this.save(bean);
        if (agentCount > 0) {
            param.setAgentId(uid.toString());
            int count = agifAccountService.getCount(param);
            if (count != NumberUtils.INTEGER_ZERO) {
                throw new BusinessException("agif", "AGIF.E03001"); //账号已经存在
            }

            PartnerRsParam partnerRsParam = new PartnerRsParam();
            partnerRsParam.setTelNo(param.getTelNo());
            PartnerRsParam partnerRsBean = agifPartnerDao.selectPartnerTel(partnerRsParam);
            if (partnerRsBean != null) {
                if (!partnerRsBean.getPartnerName().equals(param.getAgentName())) {
                    throw new BusinessException("agif", "AGIF.E02002"); //该手机号已被不同名的销售合伙人或管家使用
                }
            }

            ButlerRsParam butlerRsParam = new ButlerRsParam();
            butlerRsParam.setTelNo(param.getTelNo());
            ButlerRsParam butlerRsBean = agifButlerDao.selectButlerTel(butlerRsParam);
            if (butlerRsBean != null) {
                if (!butlerRsBean.getButlerName().equals(param.getAgentName())) {
                    throw new BusinessException("agif", "AGIF.E02002"); //该手机号已被不同名的销售合伙人或管家使用
                }
            }

            AgifAccount agifAccount = BeanUtils.toBean(param, AgifAccount.class);
            Long accountId = agifAccountService.maxId("AGIF_ACCOUNT");
            agifAccount.setAccountId(accountId);
            agifAccount.setCrtId(agifAccountService.getLoginUserId());
            agifAccount.setUpdId(agifAccountService.getLoginUserId());
            agifAccount.setCrtTime(DateUtils.getCurrent());
            agifAccount.setUpdTime(DateUtils.getCurrent());
            int accountCount = agifAccountService.save(agifAccount);
            if (accountCount > 0) {
                return uid.toString();
            }
        }
        return null;
    }

    @Override
    public void updateAgifAgentInfo(BaseBean<AccountParam, AccountParam> param) {
        if (StringUtils.isEmpty(param.getFilter().getAgentId()) && StringUtils.isEmpty(param.getFilter().getAgentCode())) {
            throw new BusinessException("AGIF", "AGIF.E02003");
        }

        int nameCount = this.getCount(param.getTarget());
        if (nameCount > NumberUtils.INTEGER_ZERO) {
            throw new BusinessException("agif", "AGIF.E02001");
        }


        AccountParam accountParam = new AccountParam();
        accountParam.setTelNo(param.getTarget().getTelNo());
        accountParam.setAccountName(param.getTarget().getAccountName());
        accountParam.setAgentId(param.getFilter().getAgentId());
        int telCount = agifAccountService.getCount(accountParam);
        if (telCount != NumberUtils.INTEGER_ZERO) {
            throw new BusinessException("agif", "AGIF.E03005"); //手机号已经存在
        }

        PartnerRsParam partnerRsParam = new PartnerRsParam();
        partnerRsParam.setTelNo(param.getTarget().getTelNo());
        PartnerRsParam partnerRsBean = agifPartnerDao.selectPartnerTel(partnerRsParam);
        if (partnerRsBean != null) {
            if (!partnerRsBean.getPartnerName().equals(param.getTarget().getAgentName())) {
                throw new BusinessException("agif", "AGIF.E02002"); //该手机号已被不同名的销售合伙人或管家使用
            }
        }

        ButlerRsParam butlerRsParam = new ButlerRsParam();
        butlerRsParam.setTelNo(param.getTarget().getTelNo());
        ButlerRsParam butlerRsBean = agifButlerDao.selectButlerTel(butlerRsParam);
        if (butlerRsBean != null) {
            if (!butlerRsBean.getButlerName().equals(param.getTarget().getAgentName())) {
                throw new BusinessException("agif", "AGIF.E02002"); //该手机号已被不同名的销售合伙人或管家使用
            }
        }

        BaseBean<AgifAgent, AgifAgent> baseBean = new BaseBean<>();
        AgifAgent filterEntity = BeanUtils.toBean(param.getFilter(), AgifAgent.class);
        AgifAgent targetEntity = BeanUtils.toBean(param.getTarget(), AgifAgent.class);
        targetEntity.setUpdTime(DateUtils.getCurrent());
        targetEntity.setUpdId(this.getLoginUserId());
        baseBean.setFilter(filterEntity);
        baseBean.setTarget(targetEntity);
        int count = this.modify(baseBean);

        if (count != NumberUtils.INTEGER_ZERO) {
            if (baseBean.getTarget().getDelFlg()) {
                AgifAgentAccount agifAgentAccount = BeanUtils.toBean(param.getFilter(), AgifAgentAccount.class);
                agifAgentAccount.setUpdId(this.getLoginUserId());
                agifAgentAccount.setUpdTime(DateUtils.getCurrent());
                agifAccountService.delete(agifAgentAccount);
                AgentDemesneParam demesneParam = new AgentDemesneParam();
                AgentDemesnePageParam demesnePageParam = new AgentDemesnePageParam();
                demesnePageParam.setAgentId(param.getFilter().getAgentId());
                //根据买手ID查询买手领地信息
                BaseRestPaginationResult<AgentDemesnePageParam> paginationResult = agifAgentDemesneService.findPageList(demesnePageParam);
                if (paginationResult != null && CollectionUtils.isNotEmpty(paginationResult.getData())) {
                    for (int i = NumberConst.IntDef.INT_ZERO; i < paginationResult.getData().size(); i++) {
                        demesnePageParam = paginationResult.getData().get(i);
                        //删除买手关联的领地并更新领地授权买手
                        demesneParam.setAgentDemesneId(demesnePageParam.getAgentDemesneId());
                        agifAgentDemesneService.deleteAgifAgentDemesneInfo(demesneParam);
                    }
                }
            } else {
                BaseBean<AgifAgentAccount, AgifAgentAccount> baseBeanAccount = new BaseBean<>();
                AgifAgentAccount filterAccount = BeanUtils.toBean(param.getFilter(), AgifAgentAccount.class);
                AgifAgentAccount targetAccount = BeanUtils.toBean(param.getTarget(), AgifAgentAccount.class);
                targetAccount.setUpdId(this.getLoginUserId());
                targetAccount.setUpdTime(DateUtils.getCurrent());
                baseBeanAccount.setFilter(filterAccount);
                baseBeanAccount.setTarget(targetAccount);
                agifAccountService.updateAccount(baseBeanAccount);
            }

        }
    }

}