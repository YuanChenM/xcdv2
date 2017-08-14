/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service.impl;

import com.bms.agif.bean.entity.AgifButler;
import com.bms.agif.bean.entity.AgifButlerAccount;
import com.bms.agif.bean.entity.AgifButlerBuyerRelation;
import com.bms.agif.bean.param.*;
import com.bms.agif.dao.AgifAgentDao;
import com.bms.agif.dao.AgifButlerDao;
import com.bms.agif.dao.AgifPartnerDao;
import com.bms.agif.service.AgifButlerAccountService;
import com.bms.agif.service.AgifButlerBuyerRelationService;
import com.bms.agif.service.AgifButlerService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * <p>AgifButlerService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class AgifButlerServiceImpl extends BaseServiceImpl implements AgifButlerService {

    @Autowired
    private AgifButlerDao AgifButlerDao;
    @Autowired
    private AgifPartnerDao agifPartnerDao;
    @Autowired
    private AgifAgentDao agifAgentDao;
    @Autowired
    private AgifButlerBuyerRelationService agifButlerBuyerRelationService;

    @Autowired
    private AgifButlerAccountService agifButlerAccountService;

    @Override
    public BaseDao getBaseDao() {
        return AgifButlerDao;
    }

    @Override
    public String insertButlerAndAddress(ButlerRsParam butlerRsParam) {
        int nameCount = this.getCount(butlerRsParam);
        if (nameCount > NumberUtils.INTEGER_ZERO) {
            throw new BusinessException("agif", "AGIF.E03002");
        }

        AccountParam accountParam = new AccountParam();
        accountParam.setTelNo(butlerRsParam.getTelNo());
        AccountParam accountBean = agifAgentDao.selectAgentTel(accountParam);
        if (accountBean != null) {
            if (!accountBean.getAgentName().equals(butlerRsParam.getButlerName())) {
                throw new BusinessException("agif", "AGIF.E03003"); //该手机号已被不同名的买手或合伙人使用
            }
        }

        PartnerRsParam partnerRsParam = new PartnerRsParam();
        partnerRsParam.setTelNo(butlerRsParam.getTelNo());
        PartnerRsParam partnerBean = agifPartnerDao.selectPartnerTel(partnerRsParam);
        if (partnerBean != null) {
            if (!partnerBean.getPartnerName().equals(butlerRsParam.getButlerName())) {
                throw new BusinessException("agif", "AGIF.E03003"); //该手机号已被不同名的买手或合伙人使用
            }
        }

        AgifButler bean = BeanUtils.toBean(butlerRsParam, AgifButler.class);
        String agentCode = this.agifPartnerDao.findAgentCode();
        String butlerCode = this.agifPartnerDao.findButlerCode();
        String partnerCode = this.agifPartnerDao.findPartnerCode();
        if (Integer.valueOf(partnerCode) > Integer.valueOf(agentCode)) {
            if (Integer.valueOf(partnerCode) > Integer.valueOf(butlerCode)) {
                bean.setButlerCode(StringUtils.toString(partnerCode));
            } else {
                bean.setButlerCode(StringUtils.toString(butlerCode));
            }
        } else {
            if (Integer.valueOf(agentCode) > Integer.valueOf(butlerCode)) {
                bean.setButlerCode(StringUtils.toString(agentCode));
            } else {
                bean.setButlerCode(StringUtils.toString(butlerCode));
            }
        }
        String ID = StringUtils.toString(UUID.randomUUID());
        Date currentDate = DateUtils.getCurrent();
        String loginUser = getLoginUserId();
        bean.setUpdTime(currentDate);
        bean.setCrtTime(currentDate);
        bean.setUpdId(loginUser);
        bean.setCrtId(loginUser);
        bean.setVersion(1);
        bean.setDelFlg(false);
        bean.setButlerId(ID);
        int count = save(bean);
        if (count > 0) {
            butlerRsParam.setButlerId(ID);
            ButlerAccountRsParam butlerAccountRsParam = BeanUtils.toBean(butlerRsParam, ButlerAccountRsParam.class);
            int agifAccountServiceCount = agifButlerAccountService.getCount(butlerAccountRsParam);
            if (agifAccountServiceCount != NumberUtils.INTEGER_ZERO) {
                throw new BusinessException("agif", "AGIF.E03001"); //账号已经存在
            }
            AgifButlerAccount agifButlerAccount = BeanUtils.toBean(butlerAccountRsParam, AgifButlerAccount.class);
            Long maxId = agifButlerAccountService.maxId("AGIF_BUTLER_ACCOUNT");
            agifButlerAccount.setUpdTime(currentDate);
            agifButlerAccount.setCrtTime(currentDate);
            agifButlerAccount.setUpdId(loginUser);
            agifButlerAccount.setCrtId(loginUser);
            agifButlerAccount.setDelFlg(false);
            agifButlerAccount.setVersion(1);
            agifButlerAccount.setAccountId(maxId);
            int accountCount = agifButlerAccountService.save(agifButlerAccount);
            if (accountCount > 0) {
                return bean.getButlerId();
            }
        }
        return null;
    }


    @Override
    public int updateButler(BaseBean<ButlerRsParam, ButlerRsParam> butlerRsParam) {
        if (StringUtils.isEmpty(butlerRsParam.getFilter().getButlerId()) && StringUtils.isEmpty(butlerRsParam.getFilter().getButlerCode())) {
            throw new BusinessException("AGIF", "AGIF.E03004");
        }

        int nameCount = getCount(butlerRsParam.getTarget());
        if (nameCount > NumberUtils.INTEGER_ZERO) {
            throw new BusinessException("agif", "AGIF.E03002");
        }


        ButlerAccountRsParam butlerAccountRsParam = new ButlerAccountRsParam();
        butlerAccountRsParam.setTelNo(butlerRsParam.getTarget().getTelNo());
        butlerAccountRsParam.setAccountName(butlerRsParam.getTarget().getAccountName());
        butlerAccountRsParam.setButlerId(butlerRsParam.getFilter().getButlerId());
        int agifAccountServiceCount = agifButlerAccountService.getCount(butlerAccountRsParam);
        if (agifAccountServiceCount != NumberUtils.INTEGER_ZERO) {
            throw new BusinessException("agif", "AGIF.E03005"); //手机号已经存在
        }

        AccountParam accountParam = new AccountParam();
        accountParam.setTelNo(butlerRsParam.getTarget().getTelNo());
        AccountParam accountBean = agifAgentDao.selectAgentTel(accountParam);
        if (accountBean != null) {
            if (!accountBean.getAgentName().equals(butlerRsParam.getTarget().getButlerName())) {
                throw new BusinessException("agif", "AGIF.E03003"); //该手机号已被不同名的买手或合伙人使用
            }
        }

        PartnerRsParam partnerRsParam = new PartnerRsParam();
        partnerRsParam.setTelNo(butlerRsParam.getTarget().getTelNo());
        PartnerRsParam partnerBean = agifPartnerDao.selectPartnerTel(partnerRsParam);
        if (partnerBean != null) {
            if (!partnerBean.getPartnerName().equals(butlerRsParam.getTarget().getButlerName())) {
                throw new BusinessException("agif", "AGIF.E03003"); //该手机号已被不同名的买手或合伙人使用
            }
        }

        Date currentDate = DateUtils.getCurrent();
        BaseBean<AgifButler, AgifButler> bean = new BaseBean<>();
        AgifButler filter = BeanUtils.toBean(butlerRsParam.getFilter(), AgifButler.class);
        AgifButler target = BeanUtils.toBean(butlerRsParam.getTarget(), AgifButler.class);
        String loginUser = getLoginUserId();
        target.setUpdId(loginUser);
        target.setUpdTime(currentDate);
        bean.setTarget(target);
        bean.setFilter(filter);

        //解除买家,买手,管家关系
        String agentId = AgifButlerDao.selectAgent(butlerRsParam.getFilter());
        if (!agentId.equals(butlerRsParam.getTarget().getAgentId())) {
            AgifButlerBuyerRelation agifButlerBuyerRelation = new AgifButlerBuyerRelation();
            agifButlerBuyerRelation.setButlerId(butlerRsParam.getTarget().getButlerId());
            agifButlerBuyerRelation.setAgentId(agentId);
            agifButlerBuyerRelation.setUpdId(getLoginUserId());
            agifButlerBuyerRelation.setUpdTime(currentDate);
            agifButlerBuyerRelation.setEndTime(currentDate);
            agifButlerBuyerRelationService.modify(agifButlerBuyerRelation);
        }

        int count = modify(bean);

        if (count != NumberUtils.INTEGER_ZERO) {
            if (bean.getTarget().getDelFlg()) {
                AgifButlerAccount agifButlerAccount = BeanUtils.toBean(butlerRsParam.getFilter(), AgifButlerAccount.class);
                agifButlerAccount.setUpdId(loginUser);
                agifButlerAccount.setUpdTime(currentDate);
                agifButlerAccountService.delete(agifButlerAccount);
            } else {
                BaseBean<AgifButlerAccount, AgifButlerAccount> baseBeanAccount = new BaseBean<>();
                AgifButlerAccount filterAccount = BeanUtils.toBean(butlerRsParam.getFilter(), AgifButlerAccount.class);
                AgifButlerAccount targetAccount = BeanUtils.toBean(butlerRsParam.getTarget(), AgifButlerAccount.class);
                targetAccount.setUpdId(loginUser);
                targetAccount.setUpdTime(currentDate);
                baseBeanAccount.setFilter(filterAccount);
                baseBeanAccount.setTarget(targetAccount);
                agifButlerAccountService.updateAccount(baseBeanAccount);
            }

        }

        return count;
    }
}