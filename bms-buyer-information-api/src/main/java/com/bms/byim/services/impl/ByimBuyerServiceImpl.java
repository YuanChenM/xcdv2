/*
 * 2016/12/29 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.byim.bean.entity.*;
import com.bms.byim.bean.param.*;
import com.bms.byim.bean.result.BuyerIsUpdateRsResult;
import com.bms.byim.constant.ApiUrlDef;
import com.bms.byim.dao.ByimBuyerDao;
import com.bms.byim.rest.BuyerBuyerRestController;
import com.bms.byim.services.*;
import com.bms.byim.utils.StringUtil;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.framework.base.bean.Pagination;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.param.BaseRestPaginationParam;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>ByimBasicService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class ByimBuyerServiceImpl extends BaseServiceImpl implements ByimBuyerService {

    @Autowired
    private ByimBuyerDao byimBasicDao;
    @Autowired
    private ByimCommService byimCommService;
    @Autowired
    private RestApiClientFactory restApiClientFactory;
    @Autowired
    private ByimStoreService byimStoreService;
    @Autowired
    private ByimEmployeeService byimEmployeeService;
    @Autowired
    private ByimDeliveryAddrService byimDeliveryAddrService;
    @Autowired
    private ByimBuyerPoolRelationShipService byimBuyerPoolRelationShipService;
    @Autowired
    private ByimMailAddresseeService byimMailAddresseeService;
    @Autowired
    private ByimMailSendHistoryService byimMailSendHistoryService;
    @Autowired
    private RestApiClientFactory apiClientFactory;
    @Autowired
    private BuyerBuyerRestController buyerBasicRestController;

    @Override
    public BaseDao getBaseDao() {
        return byimBasicDao;
    }

    /**
     * 保存买家必要信息
     *
     * @param buyerBasicRsParam
     * @return
     */
    @Override
    public BuyerBasicRsParam insertBuyerBasic(BuyerBasicRsParam buyerBasicRsParam) {
        //设置买家编码
        createBuyerCode(buyerBasicRsParam);
        //设置买家ID
        createBuyerId(buyerBasicRsParam);
        //设置买家上线状态
        createMarketingStatus(buyerBasicRsParam);
        //设置城市信息获取对应的物流区信息
//        createLgcsArea(buyerBasicRsParam);
        //设置共通字段
        createCommon(buyerBasicRsParam);
        //通过城市查询物流区和地区
        List<CityLogRsParam> restResults = null;
        if (buyerBasicRsParam.getLgcsAreaId() == null) {
            //CityLogRsParam cityLogRsParam = BeanUtils.toBean(buyerBasicRsParam, CityLogRsParam.class);
            CityLogRsParam cityLogRsParam = new CityLogRsParam();
            cityLogRsParam.setDistrictId(buyerBasicRsParam.getDistrictId());
            cityLogRsParam.setDistrictCode(buyerBasicRsParam.getDistrictCode());
            cityLogRsParam.setDistrictName(buyerBasicRsParam.getDistrictName());
            cityLogRsParam.setSearchLevel(2);
            cityLogRsParam.setRelaType("4");
            restResults = selectLog(cityLogRsParam);
            if(CollectionUtils.isEmpty(restResults)){
                CityLogRsParam cityLogRsParam1 = new CityLogRsParam();
                cityLogRsParam1.setCityId(buyerBasicRsParam.getCityId());
                cityLogRsParam1.setCityCode(buyerBasicRsParam.getCityCode());
                cityLogRsParam1.setCityName(buyerBasicRsParam.getCityName());
                cityLogRsParam1.setSearchLevel(2);
                cityLogRsParam1.setRelaType("1");
                restResults = selectLog(cityLogRsParam1);
            }
        }

        //更新买家基本信息
        /**
         * 临时测试添加
         */
        buyerBasicRsParam.setCrtId(this.getLoginUserId());
        buyerBasicRsParam.setUpdId(this.getLoginUserId());
        ByimBuyer byimBasic = BeanUtils.toBean(buyerBasicRsParam, ByimBuyer.class);
        String buyerCode = this.byimBasicDao.findCode();
        if (!CollectionUtils.isEmpty(restResults)) {
            if (byimBasic.getLgcsAreaId() == null) {
                byimBasic.setLgcsAreaId(restResults.get(0).getLgcsAreaId());
                byimBasic.setLgcsAreaCode(restResults.get(0).getLgcsAreaCode());
                byimBasic.setLgcsAreaName(restResults.get(0).getLgcsAreaName());
            }
            if (byimBasic.getZoneId() == null) {
                byimBasic.setZoneId(restResults.get(0).getZoneId());
                byimBasic.setZoneCode(restResults.get(0).getZoneCode());
                byimBasic.setZoneName(restResults.get(0).getZoneName());
            }
        }
        byimBasic.setBuyerCode(buyerCode);
        byimBasic.setFrequenterLevelF("频次未定级");
        byimBasic.setFrequenterLevelA("量级未定级");
        byimBasic.setFrequenterLevelCode("0");
        byimBasic.setGrade("未定性");
        if (StringUtils.isEmpty(byimBasic.getPaymentPeriodType())) {
            byimBasic.setPaymentPeriodType("01");
            byimBasic.setPaymentPeriodName("立即付款");
        }
        int updateCount = this.save(byimBasic);
        if (updateCount > 0) {
            sendEmail(null, byimBasic);
        }
        //添加买家账号信息
        ByimAccount account = new ByimAccount();
        account.setAccountId(this.maxId("BYIM_ACCOUNT"));
        account.setAccountNo(buyerBasicRsParam.getAccountNo());
        account.setTelNo(buyerBasicRsParam.getTelNo());
        account.setPassword(buyerBasicRsParam.getPassword());
        account.setMailAddr(buyerBasicRsParam.getMailAddr());
        account.setBuyerId(buyerBasicRsParam.getBuyerId());
        account.setDelFlg(false);
        account.setCrtId(getLoginUserId());
        account.setCrtTime(DateUtils.getCurrent());
        account.setUpdId(getLoginUserId());
        account.setUpdTime(DateUtils.getCurrent());
        account.setVersion(NumberConst.IntDef.INT_ONE);
        this.byimBasicDao.saveAccount(account);
        buyerBasicRsParam.setStoreId(this.maxId("BYIM_STORE"));
        //更新买家店铺信息
        ByimStore byimStore = BeanUtils.toBean(buyerBasicRsParam, ByimStore.class);
        this.byimStoreService.save(byimStore);
        return buyerBasicRsParam;
    }

    public List<CityLogRsParam> selectLog(CityLogRsParam cityLogRsParam) {

        String url = ConfigServerUtils.getAPIUrl(ApiUrlDef.REGN_MODULE, ApiUrlDef.REGION.relationSearch);
//        String url =ApiUrlDef.REGION_ENV +  ApiUrlDef.REGION.relationSearch;
        RestApiClient restApiClient = apiClientFactory.newApiRestClient();
        ArrayList<CityLogRsParam> response;
        response = restApiClient.post(url, cityLogRsParam,
                new TypeReference<ArrayList<CityLogRsParam>>() {
                });
        return response;
    }


    /**
     * 设置买家编码
     *
     * @param buyerBasicRsParam
     */
    public void createBuyerCode(BuyerBasicRsParam buyerBasicRsParam) {
        String displayCode = null;

        if ("01".equals(buyerBasicRsParam.getBuyerFirstCategory())) {
            //分销买家
            /*buyerCode = buyerBasicRsParam.getBuyerFirstCategory() + buyerBasicRsParam.getLgcsAreaCode() +
                    buyerBasicRsParam.getCityCode() + buyerBasicRsParam.getMarketScaleCode() +
                    buyerBasicRsParam.getMarketCode().substring(buyerBasicRsParam.getMarketCode().length() - 2);*/
            displayCode = buyerBasicRsParam.getMarketCode();
            int sequenceCode = NumberUtils.toInt(this.byimBasicDao.findMarketSequenceCode(buyerBasicRsParam));
            displayCode = displayCode + StringUtil.PadLeft(StringUtils.toStr(sequenceCode + 1), 3, "0");
        } else if ("02".equals(buyerBasicRsParam.getBuyerFirstCategory())) {
            //菜场买家
            /*buyerCode = buyerBasicRsParam.getBuyerFirstCategory() + buyerBasicRsParam.getLgcsAreaCode() +
                    buyerBasicRsParam.getCityCode() + buyerBasicRsParam.getDistrictCode() +
                    buyerBasicRsParam.getMarketCode().substring(buyerBasicRsParam.getMarketCode().length() - 3);*/
            displayCode = buyerBasicRsParam.getMarketCode();
            int sequenceCode = NumberUtils.toInt(this.byimBasicDao.findMarketSequenceCode(buyerBasicRsParam));
            displayCode = displayCode + StringUtil.PadLeft(StringUtils.toStr(sequenceCode + 1), 3, "0");
        } else if ("03".equals(buyerBasicRsParam.getBuyerFirstCategory()) || "04".equals(buyerBasicRsParam.getBuyerFirstCategory())) {
            //用户买家(团膳,火锅)
            displayCode = buyerBasicRsParam.getBuyerFirstCategory() + buyerBasicRsParam.getProvinceCode() +
                    buyerBasicRsParam.getCityCode() + buyerBasicRsParam.getDistrictCode();
            int sequenceCode = NumberUtils.toInt(this.byimBasicDao.findDistrictSequenceCode(buyerBasicRsParam));
            displayCode = displayCode + StringUtil.PadLeft(StringUtils.toStr(sequenceCode + 1), 4, "0");
        } else if ("05".equals(buyerBasicRsParam.getBuyerFirstCategory()) || "06".equals(buyerBasicRsParam.getBuyerFirstCategory())) {
            //用户买家(加工厂,中餐)
            displayCode = buyerBasicRsParam.getBuyerFirstCategory();
            if (!StringUtils.isEmpty(buyerBasicRsParam.getBuyerSubCategory())) {
                displayCode = displayCode + buyerBasicRsParam.getBuyerSubCategory();
            } else {
                displayCode = displayCode + "00";
            }
            displayCode = displayCode + buyerBasicRsParam.getProvinceCode() +
                    buyerBasicRsParam.getCityCode() + buyerBasicRsParam.getDistrictCode();
            int sequenceCode = NumberUtils.toInt(this.byimBasicDao.findDistrictSequenceCode(buyerBasicRsParam));
            displayCode = displayCode + StringUtil.PadLeft(StringUtils.toStr(sequenceCode + 1), 4, "0");
        }
        buyerBasicRsParam.setDisplayCode(displayCode);
    }

    /**
     * 设置买家ID
     *
     * @param buyerBasicRsParam
     */
    public void createBuyerId(BuyerBasicRsParam buyerBasicRsParam) {
        String buyerId = StringUtils.toString(UUID.randomUUID());
        buyerBasicRsParam.setBuyerId(buyerId);
    }

    /**
     * 设置买家上线状态
     *
     * @param buyerBasicRsParam
     */
    public void createMarketingStatus(BuyerBasicRsParam buyerBasicRsParam) {
        //需要根据买家QQ和买家微信先设置买家上线状态
        ByimBuyer buyerMarketingStatus = getMarketingStatus(buyerBasicRsParam.getBuyerId(), buyerBasicRsParam.getBuyerQq(), buyerBasicRsParam.getBuyerWechat());
        buyerBasicRsParam.setMarketingFirstStatus(buyerMarketingStatus.getMarketingFirstStatus());
        buyerBasicRsParam.setMarketingFirstStatusName(buyerMarketingStatus.getMarketingFirstStatusName());
    }

    /**
     * 设置买家上线状态
     *
     * @param buyerId     买家ID
     * @param buyerQq     买家QQ
     * @param buyerWechat 买家微信
     */
    public ByimBuyer getMarketingStatus(String buyerId, String buyerQq, String buyerWechat) {
        //根据买家ID查询该买家最新数据
        ByimBuyer byimBasic = new ByimBuyer();
        byimBasic.setBuyerId(buyerId);
        ByimBuyer byimBasicResult = this.findOne(byimBasic);
        if (byimBasicResult == null) {
            byimBasicResult = new ByimBuyer();
            if (StringUtils.isEmpty(buyerQq) && StringUtils.isEmpty(buyerWechat)) {
                byimBasicResult.setMarketingFirstStatus("02");
                byimBasicResult.setMarketingFirstStatusName("未营销成功买家");
            } else {
                byimBasicResult.setMarketingFirstStatus("01");
                byimBasicResult.setMarketingFirstStatusName("预注册买家");
            }
        } else {
            if (buyerQq != null && buyerWechat != null) {
                String currentMarketingStatus = byimBasicResult.getMarketingFirstStatus();
                if ("01".equals(currentMarketingStatus) || "02".equals(currentMarketingStatus)) {
                    if (StringUtils.isEmpty(buyerQq) && StringUtils.isEmpty(buyerWechat)) {
                        byimBasicResult.setMarketingFirstStatus("02");
                        byimBasicResult.setMarketingFirstStatusName("未营销成功买家");
                    } else {
                        byimBasicResult.setMarketingFirstStatus("01");
                        byimBasicResult.setMarketingFirstStatusName("预注册买家");
                    }
                }
            }
        }
        return byimBasicResult;
    }

    /**
     * 设置买家对应的物流区信息
     *
     * @param buyerBasicRsParam
     */
    public void createLgcsArea(BuyerBasicRsParam buyerBasicRsParam) {
        //根据选择的城市信息获取对应的物流区信息
        if (StringUtils.isEmpty(buyerBasicRsParam.getLgcsAreaCode())) {
            CityLgcsAreaParam cityParam = BeanUtils.toBean(buyerBasicRsParam, CityLgcsAreaParam.class);
            List<CityLgcsAreaParam> lgcsArea = byimCommService.searchCityLgcs(cityParam);
            if (!CollectionUtils.isEmpty(lgcsArea)) {
                buyerBasicRsParam.setLgcsAreaId(lgcsArea.get(0).getLgcsAreaId());
                buyerBasicRsParam.setLgcsAreaCode(lgcsArea.get(0).getLgcsAreaCode());
                buyerBasicRsParam.setLgcsAreaName(lgcsArea.get(0).getLgcsAreaName());
            } else {
                buyerBasicRsParam.setLgcsAreaId(99999L);
                buyerBasicRsParam.setLgcsAreaCode("99");
                buyerBasicRsParam.setLgcsAreaName("其他");
            }
        }
    }

    /**
     * 设置共通字段
     *
     * @param buyerBasicRsParam
     */
    public void createCommon(BuyerBasicRsParam buyerBasicRsParam) {
        buyerBasicRsParam.setDelFlg(false);
        buyerBasicRsParam.setCrtId(getLoginUserId());
        buyerBasicRsParam.setCrtTime(DateUtils.getCurrent());
        buyerBasicRsParam.setUpdId(getLoginUserId());
        buyerBasicRsParam.setUpdTime(DateUtils.getCurrent());
        buyerBasicRsParam.setVersion(1);
    }

    /**
     * 更新买家基本信息
     *
     * @param updateParam
     * @return
     */
    @Override
    public BuyerIsUpdateRsResult updateBuyerBasic(BaseBean<BuyerOtherRsParam, BuyerOtherRsParam> updateParam) {
        BuyerIsUpdateRsResult isUpdateRsResult = new BuyerIsUpdateRsResult();
        if (StringUtils.isEmpty(updateParam.getFilter().getBuyerId()) && StringUtils.isEmpty(updateParam.getFilter().getBuyerCode())) {
            throw new BusinessException("BYIM", "BYIM.E00015");
        }
        if (StringUtils.isNotEmpty(updateParam.getFilter().getBuyerCode())) {
            String buyerId = this.byimBasicDao.findBuyerId(updateParam.getFilter());
            updateParam.getFilter().setBuyerId(buyerId);
        }
        int resultCount = 0;
        //修改买家上线状态
        if (StringUtils.isEmpty(updateParam.getTarget().getMarketingFirstStatus()) && !(updateParam.getTarget().isDelFlg())) {
            ByimBuyer buyerMarketingStatus = getMarketingStatus(updateParam.getFilter().getBuyerId(), updateParam.getTarget().getBuyerQq(), updateParam.getTarget().getBuyerWechat());
            updateParam.getTarget().setMarketingFirstStatus(buyerMarketingStatus.getMarketingFirstStatus());
            updateParam.getTarget().setMarketingFirstStatusName(buyerMarketingStatus.getMarketingFirstStatusName());
        }
        updateParam.getTarget().setUpdId(getLoginUserId());
        updateParam.getTarget().setUpdTime(DateUtils.getCurrent());
        //买家名称，不允许和其他买家帐号，名称相同
        BuyerBasicRsParam basicRsParam = new BuyerBasicRsParam();
        basicRsParam.setBuyerId(updateParam.getFilter().getBuyerId());
        basicRsParam.setBuyerName(updateParam.getTarget().getBuyerName());
        int nameCount = this.byimBasicDao.checkBuyerNameIsExist(basicRsParam);
        //int accountNo = this.byimBasicDao.checkBuyerAccountNoIsExist(basicRsParam);
        if (nameCount > NumberConst.IntDef.INT_ZERO) {
            resultCount = NumberConst.IntDef.INT_N_ONE;
            throw new BusinessException("BYIM", "BYIM.E00017");
        }/* else if (accountNo > NumberConst.IntDef.INT_ZERO) {
            resultCount = NumberConst.IntDef.INT_N_TWO;
        }*/ else {
            isUpdateRsResult = this.checkIsUpdate(updateParam);
            //更新删除买家基本信息
            resultCount = modifyBuyerBasic(resultCount, updateParam);

            //更新删除买家账号信息
            resultCount = modifyBuyerAccount(resultCount, updateParam);

            //更新删除买家店铺信息
            resultCount = modifyBuyerStore(resultCount, updateParam);
            //更新删除买家买家池关系
            resultCount = modifyBuyerPoolRelationShip(resultCount, updateParam);
            //如果删除买家删除买家的雇员和配送地址信息
            resultCount = deleteBuyerEmployee(resultCount, updateParam);
            //删除买家管家关系
            resultCount = deleteBuyerButlerRelationShip(resultCount,updateParam);
        }
        isUpdateRsResult.setModifyResult(resultCount);
        return isUpdateRsResult;
    }

    //判断买家是否更新必要信息
    private BuyerIsUpdateRsResult checkIsUpdate(BaseBean<BuyerOtherRsParam, BuyerOtherRsParam> updateParam) {
        BuyerIsUpdateRsResult isUpdateRsResult = new BuyerIsUpdateRsResult();
        BuyerOtherRsParam target = updateParam.getTarget();
        //更新变化买家信息发送fms删除不发送fms
        if (!target.isDelFlg()) {
            BuyerOtherRsParam filter = updateParam.getFilter();
            BuyerAllRsParam buyerAllRsParam = new BuyerAllRsParam();
            buyerAllRsParam.setPagination(null);
            StoreRsParam storeRsParam = new StoreRsParam();
            if (StringUtils.isNotEmpty(filter.getBuyerId())) {
                buyerAllRsParam.setBuyerId(filter.getBuyerId());
                storeRsParam.setBuyerId(filter.getBuyerId());
            } else if (StringUtils.isNotEmpty(filter.getBuyerCode())) {
                String buyerId = this.byimBasicDao.findBuyerId(updateParam.getFilter());
                buyerAllRsParam.setBuyerId(buyerId);
                storeRsParam.setBuyerId(buyerId);
            } else {
                throw new BusinessException("BYIM", "BYIM.E00015");
            }
            //判断是否修改买家必要信息
            List<BuyerAllRsParam> buyers = this.byimBasicDao.findPageList(buyerAllRsParam);
            BuyerAllRsParam buyer = null;
            isUpdateRsResult.setIsUpdate(false);
            if (CollectionUtils.isNotEmpty(buyers)) {
                buyer = buyers.get(NumberConst.IntDef.INT_ZERO);
                if (target.getBuyerName() != null && !isUpdateRsResult.getIsUpdate()) {
                    if (!target.getBuyerName().equals(buyer.getBuyerName())) {
                        isUpdateRsResult.setIsUpdate(true);
                    }
                }
                if (target.getBuyerAddr() != null && !isUpdateRsResult.getIsUpdate()) {
                    if (!target.getBuyerAddr().equals(buyer.getBuyerAddr())) {
                        isUpdateRsResult.setIsUpdate(true);
                    }
                }
                if (target.getProvinceId() != null && !isUpdateRsResult.getIsUpdate()) {
                    if (!target.getProvinceId().equals(buyer.getProvinceId())) {
                        isUpdateRsResult.setIsUpdate(true);
                    }
                }
                if (target.getDistrictId() != null && !isUpdateRsResult.getIsUpdate()) {
                    if (!target.getDistrictId().equals(buyer.getDistrictId())) {
                        isUpdateRsResult.setIsUpdate(true);
                    }
                }
                if (target.getStreetId() != null && !isUpdateRsResult.getIsUpdate()) {
                    if (!target.getStreetId().equals(buyer.getStreetId())) {
                        isUpdateRsResult.setIsUpdate(true);
                    }
                }
                if (target.getCityId() != null && !isUpdateRsResult.getIsUpdate()) {
                    if (!target.getCityId().equals(buyer.getCityId())) {
                        isUpdateRsResult.setIsUpdate(true);
                    }
                }
                if (target.getPaymentPeriodType() != null && !isUpdateRsResult.getIsUpdate()) {
                    if (!target.getPaymentPeriodType().equals(buyer.getPaymentPeriodType())) {
                        isUpdateRsResult.setIsUpdate(true);
                    }
                }
                if (target.getBuyerType() != null && !isUpdateRsResult.getIsUpdate()) {
                    if (!target.getBuyerType().equals(buyer.getBuyerType())) {
                        isUpdateRsResult.setIsUpdate(true);
                    }
                }
                if (target.getBuyerFirstCategory() != null && !isUpdateRsResult.getIsUpdate()) {
                    if (!target.getBuyerFirstCategory().equals(buyer.getBuyerFirstCategory())) {
                        isUpdateRsResult.setIsUpdate(true);
                    }
                }
            }
            if (target.getMarketId() != null) {
                storeRsParam.setMarketId(target.getMarketId());
                //判断是否变更批发市场
                List<StoreRsParam> stores = this.byimStoreService.findList(storeRsParam);
                if (CollectionUtils.isNotEmpty(stores) && !isUpdateRsResult.getIsUpdate()) {
                    StoreRsParam store = stores.get(NumberConst.IntDef.INT_ZERO);
                    if (!target.getMarketId().equals(store.getMarketId())) {
                        isUpdateRsResult.setIsUpdate(true);
                    } else {
                        isUpdateRsResult.setIsUpdate(false);
                    }
                } else {
                    isUpdateRsResult.setIsUpdate(true);
                }
            }
        } else {
            isUpdateRsResult.setIsUpdate(false);
        }
        return isUpdateRsResult;
    }

    /**
     * 更新删除买家基本信息
     *
     * @param resultCount
     * @param updateParam
     * @return
     */
    public int modifyBuyerBasic(int resultCount, BaseBean<BuyerOtherRsParam, BuyerOtherRsParam> updateParam) {
        //查询买家基本信息
        BuyerAllRsParam buyerAllRsParam = new BuyerAllRsParam();
        buyerAllRsParam.setBuyerId(updateParam.getFilter().getBuyerId());
        List<BuyerAllRsParam> paginationResult = this.getBaseDao().findPageList(buyerAllRsParam);
        if (CollectionUtils.isNotEmpty(paginationResult)) {
            //买家基本信息
            Date currentDate = DateUtils.getCurrent();
            String loginUserId = this.getLoginUserId();
            ByimBuyer byimBasicFilter = BeanUtils.toBean(updateParam.getFilter(), ByimBuyer.class);
            ByimBuyer byimBasicTarget = BeanUtils.toBean(updateParam.getTarget(), ByimBuyer.class);
            //判断是否修改物流区划信息
            if (byimBasicTarget.getLgcsAreaId() == null && StringUtils.isEmpty(updateParam.getTarget().getModifyLgcs())) {
                byimBasicTarget.setLgcsAreaId(paginationResult.get(NumberConst.IntDef.INT_ZERO).getLgcsAreaId());
            }
            if (byimBasicTarget.getZoneId() == null && StringUtils.isEmpty(updateParam.getTarget().getModifyLgcs())) {
                byimBasicTarget.setZoneId(paginationResult.get(NumberConst.IntDef.INT_ZERO).getZoneId());
            }
            if (byimBasicTarget.getDistributionId() == null && StringUtils.isEmpty(updateParam.getTarget().getModifyLgcs())) {
                byimBasicTarget.setDistributionId(paginationResult.get(NumberConst.IntDef.INT_ZERO).getDistributionId());
            }
            if (byimBasicTarget.getDemesneId() == null && StringUtils.isEmpty(updateParam.getTarget().getModifyLgcs())) {
                byimBasicTarget.setDemesneId(paginationResult.get(NumberConst.IntDef.INT_ZERO).getDemesneId());
            }
            byimBasicTarget.setUpdId(loginUserId);
            byimBasicTarget.setUpdTime(currentDate);
            BaseBean<ByimBuyer, ByimBuyer> byimBasicBaseBean = new BaseBean<>();
            byimBasicBaseBean.setFilter(byimBasicFilter);
            byimBasicBaseBean.setTarget(byimBasicTarget);
            int updateCount = this.modify(byimBasicBaseBean);
            resultCount = resultCount + updateCount;
            if (updateCount > 0) {
                sendEmail(byimBasicFilter, byimBasicTarget);
            }
        }
        return resultCount;
    }


    /**
     * 更新删除买家账号信息
     *
     * @param resultCount
     * @param updateParam
     * @return
     */
    public int modifyBuyerAccount(int resultCount, BaseBean<BuyerOtherRsParam, BuyerOtherRsParam> updateParam) {
        if (updateParam.getTarget().isDelFlg()) {
            ByimAccount byimAccount = BeanUtils.toBean(updateParam.getFilter(), ByimAccount.class);
            byimAccount.setUpdId(getLoginUserId());
            byimAccount.setUpdTime(DateUtils.getCurrent());
            resultCount = resultCount + this.byimBasicDao.deleteAccount(byimAccount);
        }
        return resultCount;
    }


    /**
     * 更新删除买家店铺信息
     *
     * @param resultCount
     * @param updateParam
     * @return
     */
    public int modifyBuyerStore(int resultCount, BaseBean<BuyerOtherRsParam, BuyerOtherRsParam> updateParam) {
        if (updateParam.getFilter().getStoreId() != null || updateParam.getTarget().isDelFlg()) {
            //买家店铺信息
            ByimStore byimStoreFilter = BeanUtils.toBean(updateParam.getFilter(), ByimStore.class);
            ByimStore byimStoreTarget = BeanUtils.toBean(updateParam.getTarget(), ByimStore.class);
            BaseBean<ByimStore, ByimStore> byimStoreBaseBean = new BaseBean<>();
            byimStoreBaseBean.setFilter(byimStoreFilter);
            byimStoreBaseBean.setTarget(byimStoreTarget);
            resultCount = resultCount + this.byimStoreService.modify(byimStoreBaseBean);
        }
        return resultCount;
    }

    /**
     * 更新删除买家池买家关系表
     *
     * @param resultCount
     * @param updateParam
     * @return
     */
    public int modifyBuyerPoolRelationShip(int resultCount, BaseBean<BuyerOtherRsParam, BuyerOtherRsParam> updateParam) {
        ByimBuyerPoolRelationShip buyerPoolRelationShip = BeanUtils.toBean(updateParam.getFilter(), ByimBuyerPoolRelationShip.class);
        List<BuyerPoolRelationShipRsParam> currentBuyerPoolRelationShip = this.byimBuyerPoolRelationShipService.findList(buyerPoolRelationShip);
        if (!CollectionUtils.isEmpty(currentBuyerPoolRelationShip)) {
            if ((currentBuyerPoolRelationShip.size() == 1 && ("01".equals(currentBuyerPoolRelationShip.get(0).getMarketingFirstStatus()) || "02".equals(currentBuyerPoolRelationShip.get(0).getMarketingFirstStatus()))) || updateParam.getTarget().isDelFlg()) {
                ByimBuyerPoolRelationShip buyerPoolRelationShipFilter = BeanUtils.toBean(updateParam.getFilter(), ByimBuyerPoolRelationShip.class);
                ByimBuyerPoolRelationShip buyerPoolRelationShipTarget = BeanUtils.toBean(updateParam.getTarget(), ByimBuyerPoolRelationShip.class);
                BaseBean<ByimBuyerPoolRelationShip, ByimBuyerPoolRelationShip> buyerPoolRelationShipBaseBean = new BaseBean<>();
                buyerPoolRelationShipBaseBean.setFilter(buyerPoolRelationShipFilter);
                buyerPoolRelationShipBaseBean.setTarget(buyerPoolRelationShipTarget);
                List<BaseBean<ByimBuyerPoolRelationShip, ByimBuyerPoolRelationShip>> buyerPoolRelationShipList = new ArrayList<>();
                buyerPoolRelationShipList.add(buyerPoolRelationShipBaseBean);
                resultCount = resultCount + this.byimBuyerPoolRelationShipService.executeUpdate(buyerPoolRelationShipList);
            }
        }
        return resultCount;
    }

    /**
     * 删除买家管家关系
     * @param resultCount
     * @param updateParam
     * @return
     */
    public int deleteBuyerButlerRelationShip(int resultCount, BaseBean<BuyerOtherRsParam, BuyerOtherRsParam> updateParam){
        ButlerBuyerRelationRsPageParam butlerBuyerRelationRsPageParam = BeanUtils.toBean(updateParam.getFilter(), ButlerBuyerRelationRsPageParam.class);
        ArrayList<ButlerBuyerRelationRsPageParam> butlerBuyerRelationRsPageParamList = new ArrayList<>();
        butlerBuyerRelationRsPageParamList.add(butlerBuyerRelationRsPageParam);
//        String url = "http://localhost:8095/oms-agif/" + ApiUrlDef.AGIF.buyerButlerRelation;
        String url = ConfigServerUtils.getAPIUrl(ApiUrlDef.AGIF_MODULE, ApiUrlDef.AGIF.buyerButlerRelation);
        RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
        Integer rsResult = restApiClient.post(url, butlerBuyerRelationRsPageParamList, new TypeReference<Integer>() {
        });
        resultCount +=rsResult;
        return resultCount;
    }


    @Override
    public String findMarketSequenceCode(Serializable param) {
        return byimBasicDao.findMarketSequenceCode(param);
    }

    @Override
    public String findDistrictSequenceCode(Serializable param) {
        return byimBasicDao.findDistrictSequenceCode(param);
    }

    /**
     * 删除买家信息
     *
     * @param updateParam
     */
    public int deleteBuyerEmployee(int resultCount, BaseBean<BuyerOtherRsParam, BuyerOtherRsParam> updateParam) {
        if (updateParam.getTarget().isDelFlg()) {
            //买家雇员信息
            ByimEmployee byimEmployeeFilter = BeanUtils.toBean(updateParam.getFilter(), ByimEmployee.class);
            ByimEmployee byimEmployeeTarget = BeanUtils.toBean(updateParam.getTarget(), ByimEmployee.class);
            BaseBean<ByimEmployee, ByimEmployee> byimByimEmployeeBaseBean = new BaseBean<>();
            byimByimEmployeeBaseBean.setFilter(byimEmployeeFilter);
            byimByimEmployeeBaseBean.setTarget(byimEmployeeTarget);
            resultCount = resultCount + this.byimEmployeeService.modify(byimByimEmployeeBaseBean);
            //买家配送地址信息
            ByimDeliveryAddr byimDeliveryAddrFilter = BeanUtils.toBean(updateParam.getFilter(), ByimDeliveryAddr.class);
            ByimDeliveryAddr byimDeliveryAddrTarget = BeanUtils.toBean(updateParam.getTarget(), ByimDeliveryAddr.class);
            BaseBean<ByimDeliveryAddr, ByimDeliveryAddr> byimByimDeliveryAddrBaseBean = new BaseBean<>();
            byimByimDeliveryAddrBaseBean.setFilter(byimDeliveryAddrFilter);
            byimByimDeliveryAddrBaseBean.setTarget(byimDeliveryAddrTarget);
            resultCount = resultCount + this.byimDeliveryAddrService.modify(byimByimDeliveryAddrBaseBean);
        }
        return resultCount;
    }

    @Override
    public <O extends Serializable, T extends BaseRestPaginationParam> BaseRestPaginationResult<O> findPageListToBuyerIds(T param) {
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

        List data1 = byimBasicDao.findPageListToBuyerIds(param);
        pageResult.setTotal(page.getTotal());
        if (page.getTotal() != 0L) {
            pageResult.setData(data1);
        } else {
            pageResult.setData(new ArrayList());
        }

        return pageResult;
    }

    @Override
    public <O extends Serializable, T extends BaseRestPaginationParam> BaseRestPaginationResult<O> findBuyerAllInfoList(T param) {
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

        List data1 = byimBasicDao.findBuyerAllInfoList(param);
        pageResult.setTotal(page.getTotal());
        if (page.getTotal() != 0L) {
            pageResult.setData(data1);
        } else {
            pageResult.setData(new ArrayList());
        }

        return pageResult;
    }

    /**
     * 账号名是否已经存在
     *
     * @param basicRsParam
     * @return
     */
    @Override
    public int checkAccountIsExist(BuyerBasicRsParam basicRsParam) {
        return byimBasicDao.checkAccountIsExist(basicRsParam);
    }

    /**
     * 账号名是否与其他买家名称相同
     *
     * @param basicRsParam
     * @return
     */
    @Override
    public int checkNameIsExist(BuyerBasicRsParam basicRsParam) {
        return byimBasicDao.checkNameIsExist(basicRsParam);
    }

    /**
     * 查询手机号是否重复
     *
     * @param basicRsParam
     * @return
     */
    @Override
    public int checkTelNoIsExist(BuyerBasicRsParam basicRsParam) {
        return byimBasicDao.checkTelNoIsExist(basicRsParam);
    }

    @Override
    public int checkBuyerNameIsExist(BuyerBasicRsParam basicRsParam) {
        return byimBasicDao.checkBuyerNameIsExist(basicRsParam);
    }

    @Override
    public int checkBuyerAccountNoIsExist(BuyerBasicRsParam basicRsParam) {
        return byimBasicDao.checkBuyerAccountNoIsExist(basicRsParam);
    }

    @Override
    public BuyerAccountRsParam findBuyerAccount(BuyerAccountRsParam accountRsParam) {
        return byimBasicDao.findBuyerAccount(accountRsParam);
    }

    @Override
    public int updateBuyerAccount(BaseBean<ByimAccount, ByimAccount> baseBean) {
        return byimBasicDao.updateBuyerAccount(baseBean);
    }

    @Override
    public String findBuyerId(BuyerAccountRsParam accountRsParam) {
        BuyerOtherRsParam otherRsParam = new BuyerOtherRsParam();
        otherRsParam.setBuyerCode(accountRsParam.getBuyerCode());
        return byimBasicDao.findBuyerId(otherRsParam);
    }

    @Override
    public int deleteAccount(ByimAccount byimAccount) {
        return byimBasicDao.deleteAccount(byimAccount);
    }

    public void sendEmail(ByimBuyer oldBean, ByimBuyer newBean) {
        String oldWechat = "";
        String oldQq = "";
        String newWechat = "";
        String newQq = "";

        // 新增
        if (oldBean == null) {
            newWechat = newBean.getBuyerWechat() == null ? "" : newBean.getBuyerWechat();
            newQq = newBean.getBuyerQq() == null ? "" : newBean.getBuyerQq();
        } else {
            oldWechat = oldBean.getBuyerWechat() == null ? "" : oldBean.getBuyerWechat();
            oldQq = oldBean.getBuyerQq() == null ? "" : oldBean.getBuyerQq();
            newWechat = newBean.getBuyerWechat() == null ? "" : newBean.getBuyerWechat();
            newQq = newBean.getBuyerQq() == null ? "" : newBean.getBuyerQq();
        }

        if (!oldWechat.equals(newWechat) || !oldQq.equals(newQq)) {
            MailAddresseeRsParam param = new MailAddresseeRsParam();
            List<MailAddresseeRsParam> mailAddresseeRsParamList = byimMailAddresseeService.findList(param);
            if (mailAddresseeRsParamList.size() > 0) {
                MailRsParam mailParam = new MailRsParam();
                int count = mailAddresseeRsParamList.size();
                int toCount = 0;
                int ccCount = 0;
                for (int i = 0; i < count; i++) {
                    if (mailAddresseeRsParamList.get(i).getSendType().equals("0")) {
                        toCount++;
                    } else {
                        ccCount++;
                    }
                }
                //接收邮件
                String[] to = null;
                //抄送邮件
                String[] cc = null;
                if (toCount > 0) {
                    to = new String[toCount];
                }
                if (ccCount > 0) {
                    cc = new String[ccCount];
                }
                MailAddresseeRsParam mailAddresseeRsParam = new MailAddresseeRsParam();
                ccCount = 0;
                toCount = 0;
                for (int i = 0; i < count; i++) {
                    mailAddresseeRsParam = mailAddresseeRsParamList.get(i);
                    if (mailAddresseeRsParam.getSendType().equals("0")) {
                        to[toCount++] = mailAddresseeRsParam.getAddresseeEmail();
                    } else {
                        cc[ccCount++] = mailAddresseeRsParam.getAddresseeEmail();
                    }
                }
                if (to != null) {
                    mailParam.setMailTo(to);
                }
                if (cc != null) {
                    mailParam.setMailCC(cc);
                }


                // 主题
                String sub = "买家QQ号、微信号变更通知";
                mailParam.setSubject(sub);

                // 获取手机号
                BuyerAllRsParam buyerAllRsParam = new BuyerAllRsParam();
                buyerAllRsParam.setBuyerId(newBean.getBuyerId());
                List<BuyerAllRsParam> buyerAllRsParamList = buyerBasicRestController.search(buyerAllRsParam).getData();
                if (CollectionUtils.isNotEmpty(buyerAllRsParamList)) {
                    buyerAllRsParam = buyerAllRsParamList.get(0);
                }
                //内容
                String content = "买家编码：" + buyerAllRsParam.getBuyerCode() + "\n"
                        + "买家名称：" + buyerAllRsParam.getBuyerName() + "\n"
                        + "买家手机号：" + buyerAllRsParam.getTelNo() + "\n"
                        + "买家qq号：" + newQq + "\n"
                        + "买家微信号：" + newWechat;
                mailParam.setContent(content);
//            RestApiClient restApiClient = apiClientFactory.newApiRestClient();
//            String url = "http://10.20.16.83:8095/base-mail/api/text/mail/simple/_send";
////          String url = ConfigServerUtils.getAPIUrl("bms-bypo-api/", "api/buyerPool/_search");
//            BaseRestPaginationResult<String> response = restApiClient.post(url,mailParam,new TypeReference<BaseRestPaginationResult<String>>(){});
                // 保存内容到数据库履历表
//            if(response.getTotal() > 0){
//
//            }
//            int i = 0;
                RsRequest<MailRsParam> request = new RsRequest<>();
                request.setSiteCode("1");
                request.setAuth("MSK00001");
                request.setLoginId("msk01");
                request.setParam(mailParam);
                RestApiClient restApiClient = apiClientFactory.newApiRestClient();
//            String url = "http://10.30.10.16:8095/base-mail/api/text/mail/simple/_send";
                String url = ConfigServerUtils.getAPIUrl("base-mail", "api/text/mail/simple/_send");
                RsResponse<String> response = restApiClient.post(url, request, new TypeReference<RsResponse<String>>() {
                });
                ByimMailSendHistory byimMailSendHistory = new ByimMailSendHistory();
                if (response.getStatus().equals("S")) {
                    byimMailSendHistory.setIsSuccess("1");
                } else {
                    byimMailSendHistory.setIsSuccess("0");
                }
//            ByimMailSendHistory byimMailSendHistory = new ByimMailSendHistory();
                Long maxId = byimMailSendHistoryService.maxId("BYIM_MAIL_SEND_HISTORY");
                byimMailSendHistory.setMailSendHistoryId(maxId);
                byimMailSendHistory.setBuyerId(newBean.getBuyerId());
                byimMailSendHistory.setEmailTopic(sub);
                byimMailSendHistory.setEmailContent(content);


                Date currentDate = DateUtils.getCurrent();
                byimMailSendHistory.setCrtId(this.getLoginUserId());
                byimMailSendHistory.setUpdId(this.getLoginUserId());
                byimMailSendHistory.setCrtTime(currentDate);
                byimMailSendHistory.setUpdTime(currentDate);

                int addCount = byimMailSendHistoryService.save(byimMailSendHistory);
                if (addCount > 0) {

                }
            }
        }


    }
}