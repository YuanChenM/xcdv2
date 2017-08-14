/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.bymt.services.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.bymt.bean.entity.BymtFoodMarketBasic;
import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.MarketFoodModuleBasicRsParam;
import com.bms.bymt.bean.param.StoreRsParam;
import com.bms.bymt.constant.ApiUrlDef;
import com.bms.bymt.dao.BymtFoodMarketBasicDao;
import com.bms.bymt.services.BymtFoodMarketBasicService;
import com.bms.bymt.utils.RestCommUtil;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>BymtFoodMarketBasicService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class BymtFoodMarketBasicServiceImpl extends BaseServiceImpl implements BymtFoodMarketBasicService {


    private static Map<String, String> checkNum;

    @Autowired
    private BymtFoodMarketBasicDao bymtFoodMarketBasicDao;

    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @Override
    public BaseDao getBaseDao() {
        return bymtFoodMarketBasicDao;
    }

    @Override
    public int addFoodMarketBasic(List<MarketFoodModuleBasicRsParam> params) {
        checkNum = new HashMap<>();
        List<BymtFoodMarketBasic> foodBasicList = new ArrayList<>();
        Date curTime = DateUtils.getCurrent();
        if (CollectionUtils.isNotEmpty(params)) {
            int size = params.size();
            for (int i = NumberConst.IntDef.INT_ZERO; i < size; i++) {
                BymtFoodMarketBasic foodBasic = BeanUtils.toBean(params.get(i), BymtFoodMarketBasic.class);
                foodBasic.setFoodMarketCode(null);
                this.getMarketCode(foodBasic);
                UUID uuid = UUID.randomUUID();
                foodBasic.setFoodMarketId(uuid.toString());
                foodBasic.setCrtTime(curTime);
                foodBasic.setUpdTime(curTime);
                foodBasic.setUpdId(getLoginUserId());
                foodBasic.setCrtId(getLoginUserId());
                foodBasic.setDelFlg(false);
                foodBasic.setVersion(NumberConst.IntDef.INT_ZERO);
                foodBasicList.add(foodBasic);
            }
        }
        int count = NumberConst.IntDef.INT_ZERO;
        List<List<BymtFoodMarketBasic>> utilList = RestCommUtil.insertRanking(foodBasicList);
        if (CollectionUtils.isNotEmpty(utilList)) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < utilList.size(); i++) {
                count += bymtFoodMarketBasicDao.batchInsert(utilList.get(i));
            }
        }
        return count;
    }

    @Override
    public Integer updateFoodMarketBasic(List<BaseBean<MarketFoodModuleBasicRsParam, MarketFoodModuleBasicRsParam>> param) {
        checkNum = new HashMap<>();
        List<BaseBean<MarketFoodModuleBasicRsParam, MarketFoodModuleBasicRsParam>> foodMarketParamList = param;
        int listSize = foodMarketParamList.size();
        Date curTime = DateUtils.getCurrent();
        int resultLine = NumberConst.IntDef.INT_ZERO;
        BaseBean<BymtFoodMarketBasic, BymtFoodMarketBasic> beanEntity;
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            beanEntity = new BaseBean<>();
            BymtFoodMarketBasic filterEntity = BeanUtils.toBean(foodMarketParamList.get(i).getFilter(), BymtFoodMarketBasic.class);
            BymtFoodMarketBasic targetEntity = BeanUtils.toBean(foodMarketParamList.get(i).getTarget(), BymtFoodMarketBasic.class);
            this.getMarketCode(targetEntity);
            targetEntity.setUpdTime(curTime);
            targetEntity.setUpdId(getLoginUserId());
            beanEntity.setFilter(filterEntity);
            beanEntity.setTarget(targetEntity);
            int line = bymtFoodMarketBasicDao.modify(beanEntity);
            resultLine += line;//批发市场变更时买家系统下的批发市场也同时变更
            StoreRsParam storeRsParam = new StoreRsParam();
            storeRsParam.setMarketId(filterEntity.getFoodMarketId());
            storeRsParam.setMarketName(targetEntity.getFoodMarketName());
            storeRsParam.setMarketCode(targetEntity.getFoodMarketCode());
            //获取批发市场级别名称
            storeRsParam.setMarketLevelName(foodMarketParamList.get(i).getTarget().getFoodMarketLevelName());
            storeRsParam.setMarketLevel(targetEntity.getFoodMarketLevel());
            String url = ConfigServerUtils.getAPIUrl(ApiUrlDef.BYIM_MODULE, ApiUrlDef.STORE.storeUpdate);
            RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
            Integer result = restApiClient.post(url, storeRsParam, new TypeReference<Integer>() {
            });
        }
        return resultLine;
    }

    // 批发市场编码生成规则修改
    public void getMarketCode(BymtFoodMarketBasic param) {
        // 满足当前条件的批发市场编码 注：当该处不为删除的情况下
        if (param.getDelFlg() == null || param.getDelFlg() == false) {
            if (param.getZoneCode() != null && param.getLgcsAreaCode() != null && param.getDistrictCode() != null) {
                String foodMarketCode = bymtFoodMarketBasicDao.findMaxFoodCode(param);
                String code = "";
                String strIndex = "02" + param.getLgcsAreaCode() + param.getZoneCode() + param.getDistrictCode();
                if (StringUtils.isNotEmpty(foodMarketCode)) {
                    if (checkNum.get(foodMarketCode) != null && !"".equals(checkNum.get(foodMarketCode))) {
                        code = "0" + (Long.parseLong(checkNum.get(foodMarketCode)) + 1);
                    } else {
                        code = foodMarketCode;
                    }
                    checkNum.put(foodMarketCode, code);
                } else {
                    String paramCode = strIndex + "01";
                    if (checkNum.get(paramCode) != null && !"".equals(checkNum.get(paramCode))) {
                        code = "0" + (Long.parseLong(checkNum.get(paramCode)) + 1);
                    } else {
                        code = strIndex + "001";
                    }
                    checkNum.put(paramCode, code);
                }
                param.setFoodMarketCode(code);
            }
        }
    }
}