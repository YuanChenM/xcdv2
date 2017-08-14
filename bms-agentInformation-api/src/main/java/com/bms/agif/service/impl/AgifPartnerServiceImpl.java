/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.agif.bean.entity.AgifPartner;
import com.bms.agif.bean.entity.AgifPartnerAccount;
import com.bms.agif.bean.param.*;
import com.bms.agif.constant.ApiUrlDef;
import com.bms.agif.dao.AgifAgentDao;
import com.bms.agif.dao.AgifButlerDao;
import com.bms.agif.dao.AgifPartnerDao;
import com.bms.agif.service.AgifPartnerAccountService;
import com.bms.agif.service.AgifPartnerDistributionService;
import com.bms.agif.service.AgifPartnerService;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.framework.base.bean.Pagination;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.param.BaseRestPaginationParam;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.*;
import com.framework.exception.BusinessException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

/**
 * <p>AgifPartnerService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class AgifPartnerServiceImpl extends BaseServiceImpl implements AgifPartnerService {

    @Autowired
    private AgifPartnerDao AgifPartnerDao;
    @Autowired
    private AgifPartnerDistributionService distributionService;
    @Autowired
    private RestApiClientFactory restApiClientFactory;
    @Autowired
    private AgifPartnerAccountService agifPartnerAccountService;

    @Autowired
    private AgifAgentDao agifAgentDao;

    @Autowired
    private AgifButlerDao agifButlerDao;

    @Override
    public BaseDao getBaseDao() {
        return AgifPartnerDao;
    }

    @Autowired
    private AgifPartnerAccountService partnerAccountService;

    @Override
    public <O extends Serializable, T extends BaseRestPaginationParam> BaseRestPaginationResult<O> findAgentPageList(T param) {
        BaseRestPaginationResult pageResult = new BaseRestPaginationResult();
        Page page;
        if (param == null) {
            page = PageHelper.startPage(0, 0, true, Boolean.valueOf(false), Boolean.valueOf(true));
        } else {
            Pagination data = param.getPagination();
            if (data == null) {
                page = PageHelper.startPage(0, 0, true, Boolean.valueOf(false), Boolean.valueOf(true));
            } else {
                page = PageHelper.startPage(data.getStartPos(), data.getPageSize(), true, Boolean.valueOf(false), Boolean.valueOf(true));
            }

            this.setSort(param.getSort());
        }

        List data1 = this.AgifPartnerDao.findAgentPageList(param);
        pageResult.setTotal(page.getTotal());
        if (page.getTotal() != 0L) {
            pageResult.setData(data1);
        } else {
            pageResult.setData(new ArrayList());
        }

        return pageResult;
    }

    @Override
    public String insertPartnerAndAddress(PartnerRsParam partnerRsParam) {
        int nameCount = this.getCount(partnerRsParam);
        if (nameCount > NumberUtils.INTEGER_ZERO) {
            throw new BusinessException("agif", "AGIF.E01001");
        }
        AgifPartner partner = BeanUtils.toBean(partnerRsParam, AgifPartner.class);
        String agentCode = this.AgifPartnerDao.findAgentCode();
        String butlerCode = this.AgifPartnerDao.findButlerCode();
        String partnerCode = this.AgifPartnerDao.findPartnerCode();
        if (Integer.valueOf(partnerCode) > Integer.valueOf(agentCode)) {
            if (Integer.valueOf(partnerCode) > Integer.valueOf(butlerCode)) {
                partner.setPartnerCode(StringUtils.toString(partnerCode));
            } else {
                partner.setPartnerCode(StringUtils.toString(butlerCode));
            }
        } else {
            if (Integer.valueOf(agentCode) > Integer.valueOf(butlerCode)) {
                partner.setPartnerCode(StringUtils.toString(agentCode));
            } else {
                partner.setPartnerCode(StringUtils.toString(butlerCode));
            }
        }
        Date currentDate = DateUtils.getCurrent();
        String loginUserId = this.getLoginUserId();
        String ID = StringUtils.toString(UUID.randomUUID());
        partner.setPartnerId(ID);
        partner.setUpdId(loginUserId);
        partner.setUpdTime(currentDate);
        partner.setCrtId(loginUserId);
        partner.setCrtTime(currentDate);
        partner.setDelFlg(false);
        partner.setVersion(NumberConst.IntDef.INT_ONE);
        int result = this.save(partner);
        if (result > 0) {
            partnerRsParam.setPartnerId(ID);
            PartnerAccountRsParam partnerAccountRsParam = BeanUtils.toBean(partnerRsParam, PartnerAccountRsParam.class);
            int count = partnerAccountService.getCount(partnerAccountRsParam);
            if (count != NumberUtils.INTEGER_ZERO) {
                throw new BusinessException("agif", "AGIF.E03001");
            }

            AccountParam accountParam = new AccountParam();
            accountParam.setTelNo(partnerRsParam.getTelNo());
            AccountParam accountBean = agifAgentDao.selectAgentTel(accountParam);
            if (accountBean != null) {
                if (!accountBean.getAgentName().equals(partnerRsParam.getPartnerName())) {
                    throw new BusinessException("agif", "AGIF.E01002"); //该手机号已被不同名的买手或管家使用
                }
            }

            ButlerRsParam butlerRsParam = new ButlerRsParam();
            butlerRsParam.setTelNo(partnerRsParam.getTelNo());
            ButlerRsParam butlerRsBean = agifButlerDao.selectButlerTel(butlerRsParam);
            if (butlerRsBean != null) {
                if (!butlerRsBean.getButlerName().equals(partnerRsParam.getPartnerName())) {
                    throw new BusinessException("agif", "AGIF.E01002"); //该手机号已被不同名的买手或管家使用
                }
            }

            AgifPartnerAccount partnerAccount = BeanUtils.toBean(partnerAccountRsParam, AgifPartnerAccount.class);
            Long accountId = this.partnerAccountService.maxId("AGIF_PARTNER_ACCOUNT");
            partnerAccount.setAccountId(accountId);
            partnerAccount.setUpdId(loginUserId);
            partnerAccount.setUpdTime(currentDate);
            partnerAccount.setCrtId(loginUserId);
            partnerAccount.setCrtTime(currentDate);
            partnerAccount.setDelFlg(false);
            partnerAccount.setVersion(NumberConst.IntDef.INT_ONE);
            int partnerCount = this.partnerAccountService.save(partnerAccount);
            if (partnerCount > 0) {
                return partner.getPartnerId();
            }
        }
        return null;
    }

    @Override
    public int updateAgifPartner(BaseBean<PartnerRsParam, PartnerRsParam> baseBean) {

        if (StringUtils.isEmpty(baseBean.getFilter().getPartnerId()) && StringUtils.isEmpty(baseBean.getFilter().getPartnerCode())) {
            throw new BusinessException("AGIF", "AGIF.E01003");
        }

        int nameCount = this.getCount(baseBean.getTarget());
        if (nameCount > NumberUtils.INTEGER_ZERO) {
            throw new BusinessException("agif", "AGIF.E01001");
        }


        PartnerAccountRsParam partnerAccountRsParam = new PartnerAccountRsParam();
        partnerAccountRsParam.setTelNo(baseBean.getTarget().getTelNo());
        partnerAccountRsParam.setAccountName(baseBean.getTarget().getAccountName());
        partnerAccountRsParam.setPartnerId(baseBean.getFilter().getPartnerId());
        int partnerAccountServiceCount = partnerAccountService.getCount(partnerAccountRsParam);
        if (partnerAccountServiceCount != NumberUtils.INTEGER_ZERO) {
            throw new BusinessException("agif", "AGIF.E03005");
        }

        AccountParam accountParam = new AccountParam();
        accountParam.setTelNo(baseBean.getTarget().getTelNo());
        AccountParam accountBean = agifAgentDao.selectAgentTel(accountParam);
        if (accountBean != null) {
            if (!accountBean.getAgentName().equals(baseBean.getTarget().getPartnerName())) {
                throw new BusinessException("agif", "AGIF.E01002"); //该手机号已被不同名的买手或管家使用
            }
        }

        ButlerRsParam butlerRsParam = new ButlerRsParam();
        butlerRsParam.setTelNo(baseBean.getTarget().getTelNo());
        ButlerRsParam butlerRsBean = agifButlerDao.selectButlerTel(butlerRsParam);
        if (butlerRsBean != null) {
            if (!butlerRsBean.getButlerName().equals(baseBean.getTarget().getPartnerName())) {
                throw new BusinessException("agif", "AGIF.E01002"); //该手机号已被不同名的买手或管家使用
            }
        }

        BaseBean<AgifPartner, AgifPartner> partnerBaseBean = new BaseBean<>();
        String loginUserId = this.getLoginUserId();
        Date currentDate = DateUtils.getCurrent();
        AgifPartner partnerFilter = BeanUtils.toBean(baseBean.getFilter(), AgifPartner.class);
        AgifPartner partnerTarget = BeanUtils.toBean(baseBean.getTarget(), AgifPartner.class);
        partnerTarget.setUpdId(loginUserId);
        partnerTarget.setUpdTime(currentDate);
        partnerTarget.setCrtId(loginUserId);
        partnerTarget.setCrtTime(currentDate);
        partnerBaseBean.setFilter(partnerFilter);
        partnerBaseBean.setTarget(partnerTarget);
        if (partnerTarget.getDelFlg()) {
            //删除合伙人
            PartnerDistributionRsParam distributionRsParam = new PartnerDistributionRsParam();
            distributionRsParam.setPartnerId(partnerFilter.getPartnerId());
            BaseRestPaginationResult<PartnerDistributionRsParam> paginationResult = this.distributionService.findPageList(distributionRsParam);
            //查询合伙人信息
            PartnerRsParam partner = new PartnerRsParam();
            BaseRestPaginationResult<PartnerRsParam> partnerResult = this.findPageList(baseBean.getFilter());
            if (partnerResult != null) {
                partner = partnerResult.getData().get(NumberConst.IntDef.INT_ZERO);
            }
            if (paginationResult != null) {
                //更新配送站授权合伙人
                if (CollectionUtils.isNotEmpty(paginationResult.getData())) {
                    for (int i = NumberConst.IntDef.INT_ZERO; i < paginationResult.getData().size(); i++) {
                        //查询物流区配送站授权合伙人信息
                        LogisDistributionRsParm logisDistributionRsParm = new LogisDistributionRsParm();
                        logisDistributionRsParm.setDistributionId(paginationResult.getData().get(i).getDistributionId());
                        //String searchUrl = ApiUrlDef.REGION_ENV + ApiUrlDef.REGION.distributionSearch;
                        String searchUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.REGN_MODULE, ApiUrlDef.REGION.distributionSearch);
                        RestApiClient searchRestApiClient = restApiClientFactory.newApiRestClient();
                        BaseRestPaginationResult<LogisDistributionRsParm> searchResult = searchRestApiClient.post(searchUrl,
                                logisDistributionRsParm, new TypeReference<BaseRestPaginationResult<LogisDistributionRsParm>>() {
                                });
                        logisDistributionRsParm = searchResult.getData().get(NumberConst.IntDef.INT_ZERO);
                        if (StringUtils.isNotEmpty(logisDistributionRsParm.getAuthorizedPartner())) {
                            if (logisDistributionRsParm.getAuthorizedPartner().contains(partner.getPartnerName())) {
                                String authorizedPartner = logisDistributionRsParm.getAuthorizedPartner().replace(partner.getPartnerName(), "");
                                if (logisDistributionRsParm.getAuthorizedPartner().indexOf(partner.getPartnerName() + ",") > 0) {
                                    authorizedPartner = logisDistributionRsParm.getAuthorizedPartner().replace(partner.getPartnerName() + ",", "");
                                } else if (logisDistributionRsParm.getAuthorizedPartner().indexOf("," + partner.getPartnerName()) > 0) {
                                    authorizedPartner = logisDistributionRsParm.getAuthorizedPartner().replace("," + partner.getPartnerName(), "");
                                }
                                logisDistributionRsParm.setAuthorizedPartner(authorizedPartner);
                            }
                        }
                        //更新物流区配送站授权合伙人信息
                        BaseBean<LogisDistributionRsParm, LogisDistributionRsParm> LogisDistributionBaseBean = new BaseBean<>();
                        LogisDistributionRsParm distributionParmFilter = new LogisDistributionRsParm();
                        distributionParmFilter.setDistributionId(paginationResult.getData().get(i).getDistributionId());
                        LogisDistributionRsParm distributionParmTarget = new LogisDistributionRsParm();
                        distributionParmTarget.setAuthorizedPartner(logisDistributionRsParm.getAuthorizedPartner());
                        distributionParmTarget.setDistributionType(logisDistributionRsParm.getDistributionType());
                        distributionParmTarget.setDistributionName(logisDistributionRsParm.getDistributionName());
                        distributionParmTarget.setDistributionCode(logisDistributionRsParm.getDistributionCode());
                        distributionParmTarget.setDisableFlg(StringUtils.toString(NumberConst.IntDef.INT_TWO));
                        LogisDistributionBaseBean.setFilter(distributionParmFilter);
                        LogisDistributionBaseBean.setTarget(distributionParmTarget);
                        //String url = ApiUrlDef.REGION_ENV + ApiUrlDef.REGION.distributionUpdate;
                        String url = ConfigServerUtils.getAPIUrl(ApiUrlDef.REGN_MODULE, ApiUrlDef.REGION.distributionUpdate);
                        RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
                        Integer updateResult = restApiClient.post(url, LogisDistributionBaseBean, new TypeReference<Integer>() {
                        });
                    }
                }
            }
            //删除合伙人配送站
            this.distributionService.remove(distributionRsParam);
        }
        int result = this.modify(partnerBaseBean);

        if (result != NumberUtils.INTEGER_ZERO) {
            if (partnerBaseBean.getTarget().getDelFlg()) {
                AgifPartnerAccount agifPartnerAccount = BeanUtils.toBean(partnerBaseBean.getFilter(), AgifPartnerAccount.class);
                agifPartnerAccount.setUpdId(loginUserId);
                agifPartnerAccount.setUpdTime(currentDate);
                agifPartnerAccountService.delete(agifPartnerAccount);
            } else {
                BaseBean<AgifPartnerAccount, AgifPartnerAccount> baseBeanAccount = new BaseBean<>();
                AgifPartnerAccount filterAccount = BeanUtils.toBean(baseBean.getFilter(), AgifPartnerAccount.class);
                AgifPartnerAccount targetAccount = BeanUtils.toBean(baseBean.getTarget(), AgifPartnerAccount.class);
                targetAccount.setUpdId(loginUserId);
                targetAccount.setUpdTime(currentDate);
                baseBeanAccount.setFilter(filterAccount);
                baseBeanAccount.setTarget(targetAccount);
                agifPartnerAccountService.updateAccount(baseBeanAccount);
            }

        }

        return result;
    }
}
