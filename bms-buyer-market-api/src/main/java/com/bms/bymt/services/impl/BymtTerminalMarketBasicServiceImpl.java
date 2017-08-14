/*
 * 2016/12/14 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.bms.bymt.services.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.bymt.bean.entity.BymtTerminalMarketBasic;
import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.StoreRsParam;
import com.bms.bymt.bean.param.TerminalMarketBasicRsParam;
import com.bms.bymt.constant.ApiUrlDef;
import com.bms.bymt.dao.BymtTerminalMarketBasicDao;
import com.bms.bymt.services.BymtTerminalMarketBasicService;
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
 * <p>
 * BymtTerminalMarketBasicService接口实现类。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class BymtTerminalMarketBasicServiceImpl extends BaseServiceImpl implements BymtTerminalMarketBasicService {

    private static Map<String,String> checkNum;

    @Autowired
    private BymtTerminalMarketBasicDao bymtTerminalMarketBasicDao;

    @Override
    public BaseDao getBaseDao() {
        return bymtTerminalMarketBasicDao;
    }

    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @Override
    public Integer addTerminalModuleBasic(List<TerminalMarketBasicRsParam> params) {
        checkNum = new HashMap<>();
        List<BymtTerminalMarketBasic> terminalMarketBasicList = new ArrayList<>();
        Date curTime = DateUtils.getCurrent();
        int size = params.size();
        if (CollectionUtils.isNotEmpty(params)) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < size; i++) {
                BymtTerminalMarketBasic terminalMarketBasic = BeanUtils.toBean(params.get(i),
                        BymtTerminalMarketBasic.class);
                // 获取批发市场编码
                terminalMarketBasic.setTermMarketCode(null);
                this.getMarketCode(terminalMarketBasic);
                UUID uuid = UUID.randomUUID();
                terminalMarketBasic.setTermMarketId(uuid.toString());
                terminalMarketBasic.setUpdTime(curTime);
                terminalMarketBasic.setUpdId(getLoginUserId());
                terminalMarketBasic.setCrtTime(curTime);
                terminalMarketBasic.setCrtId(getLoginUserId());
                terminalMarketBasic.setDelFlg(false);
                terminalMarketBasic.setVersion(NumberConst.IntDef.INT_ZERO);
                terminalMarketBasicList.add(terminalMarketBasic);
            }
        }
        int count = NumberConst.IntDef.INT_ZERO;
        List<List<BymtTerminalMarketBasic>> utilList = RestCommUtil.insertRanking(terminalMarketBasicList);
        if (CollectionUtils.isNotEmpty(utilList)) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < utilList.size(); i++) {
                count += bymtTerminalMarketBasicDao.batchInsert(utilList.get(i));
            }
        }
        return count;
    }

    @Override
    public Integer updateTerminalMarketBasic(
            List<BaseBean<TerminalMarketBasicRsParam, TerminalMarketBasicRsParam>> param) {
        checkNum = new HashMap<>();
        List<BaseBean<TerminalMarketBasicRsParam, TerminalMarketBasicRsParam>> terminalMarketParamList = param;
        int listSize = terminalMarketParamList.size();
        Date curTime = DateUtils.getCurrent();
        int resultLine = NumberConst.IntDef.INT_ZERO;
        BaseBean<BymtTerminalMarketBasic, BymtTerminalMarketBasic> beanEntity;
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            // 获取批发市场编码
            beanEntity = new BaseBean<>();
            BymtTerminalMarketBasic filterEntity = BeanUtils.toBean(terminalMarketParamList.get(i).getFilter(),
                    BymtTerminalMarketBasic.class);
            BymtTerminalMarketBasic targetEntity = BeanUtils.toBean(terminalMarketParamList.get(i).getTarget(),
                    BymtTerminalMarketBasic.class);

            this.getMarketCode(targetEntity);
            targetEntity.setUpdTime(curTime);
            targetEntity.setUpdId(this.getLoginUserId());
            beanEntity.setFilter(filterEntity);
            beanEntity.setTarget(targetEntity);
            int line = bymtTerminalMarketBasicDao.modify(beanEntity);
            //批发市场变更时买家系统下的批发市场也同时变更
            StoreRsParam storeRsParam = new StoreRsParam();
            storeRsParam.setMarketId(filterEntity.getTermMarketId());
            storeRsParam.setMarketName(targetEntity.getTermMarketName());
            storeRsParam.setMarketCode(targetEntity.getTermMarketCode());
            //获取批发市场级别名称
            storeRsParam.setMarketLevelName(terminalMarketParamList.get(i).getTarget().getTermMarketLevelName());
            storeRsParam.setMarketLevel(targetEntity.getTermMarketLevel());
            String url = ConfigServerUtils.getAPIUrl(ApiUrlDef.BYIM_MODULE, ApiUrlDef.STORE.storeUpdate);
            RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
            Integer result = restApiClient.post(url, storeRsParam, new TypeReference<Integer>() {
            });
            resultLine += line;
        }

        return resultLine;
    }

    // 批发市场编码生成规则修改
    public void getMarketCode(BymtTerminalMarketBasic param) {
        // 满足当前条件的批发市场编码 注：当该处不为删除的情况下
        if (param.getDelFlg() == null || param.getDelFlg() == false) {
            if (param.getZoneCode() != null && param.getLgcsAreaCode() != null && param.getTermMarketLevel() != null) {
                String marketCode = bymtTerminalMarketBasicDao.findMaxMarketCode(param);
                String code = "";
                String strIndex = "01" + param.getLgcsAreaCode() + param.getZoneCode() + param.getTermMarketLevel();
                if (StringUtils.isNotEmpty(marketCode)) {
                    if(checkNum.get(marketCode) != null && !"".equals(checkNum.get(marketCode))){
                        code = "0" + (Long.parseLong(checkNum.get(marketCode)) + 1);
                    }else{
                        code = marketCode;
                    }
                    checkNum.put(marketCode,code);
                } else {
                    String paramCode = strIndex + "01";
                    if(checkNum.get(paramCode) != null && !"".equals(checkNum.get(paramCode))){
                        code = "0" + (Long.parseLong(checkNum.get(paramCode)) + 1);
                    }else{
                        code = strIndex + "01";
                    }
                    checkNum.put(paramCode,code);
                }
                param.setTermMarketCode(code);
            }
        }
    }
}