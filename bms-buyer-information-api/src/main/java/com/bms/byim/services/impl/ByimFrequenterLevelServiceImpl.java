package com.bms.byim.services.impl;

import com.bms.byim.bean.entity.ByimBuyer;
import com.bms.byim.bean.entity.ByimFrequenterLevel;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.BuyerAllRsParam;
import com.bms.byim.bean.param.FrequenterLevelRsParam;
import com.bms.byim.bean.param.StandardFrequenterLevelRsParam;
import com.bms.byim.dao.ByimBuyerDao;
import com.bms.byim.dao.ByimFrequenterLevelDao;
import com.bms.byim.dao.ByimStandardFrequenterLevelDao;
import com.bms.byim.services.ByimFrequenterLevelService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by yuan_zhifei on 2017/3/21.
 */
@Service
public class ByimFrequenterLevelServiceImpl extends BaseServiceImpl implements ByimFrequenterLevelService {
    @Autowired
    private ByimFrequenterLevelDao frequenterLevelDao;
    @Autowired
    private ByimBuyerDao byimBuyerDao;
    @Autowired
    private ByimStandardFrequenterLevelDao standardFrequenterLevelDao;

    @Override
    public BaseDao getBaseDao() {
        return frequenterLevelDao;
    }

    @Override
    public int saveFrequenterLevel(FrequenterLevelRsParam levelRsParam) {
        //查询常客买家定级标准信息获取常客买家等级编码
        List<StandardFrequenterLevelRsParam> standardLevelRsParams = this.standardFrequenterLevelDao.findLevelStandards();
        if (CollectionUtils.isNotEmpty(standardLevelRsParams)) {
            StandardFrequenterLevelRsParam standardLevel = null;
            //常客等级（频次）
            int levelFCode = NumberConst.IntDef.INT_N_ONE;
            //常客等级（量级）
            int levelACode = NumberConst.IntDef.INT_N_ONE;
            int j = standardLevelRsParams.size();
            for (int i = NumberConst.IntDef.INT_ZERO; i < standardLevelRsParams.size(); i++) {
                standardLevel = standardLevelRsParams.get(i);
                if (("频次" + standardLevel.getLevelStandard()).equals(levelRsParam.getFrequenterLevelF())) {
                    levelFCode = j;
                }
                if (("量级" + standardLevel.getLevelStandard()).equals(levelRsParam.getFrequenterLevelA())) {
                    levelACode = j;
                }
                j--;
            }
            //取最大级别的编码
            if (levelFCode != NumberConst.IntDef.INT_N_ONE) {
                if (levelACode != NumberConst.IntDef.INT_N_ONE) {
                    if (levelFCode > levelACode) {
                        levelRsParam.setFrequenterLevelCode(StringUtils.toString(levelFCode));
                    } else {
                        levelRsParam.setFrequenterLevelCode(StringUtils.toString(levelACode));
                    }
                } else {
                    levelRsParam.setFrequenterLevelCode(StringUtils.toString(levelFCode));
                }
            } else {
                if (levelACode != NumberConst.IntDef.INT_N_ONE) {
                    levelRsParam.setFrequenterLevelCode(StringUtils.toString(levelACode));
                } else {
                    levelRsParam.setFrequenterLevelCode("0");
                }
            }
        } else {
            levelRsParam.setFrequenterLevelCode("0");
        }

        Date currentDate = DateUtils.getCurrent();
        String loginUserId = this.getLoginUserId();
        //查询买家基本信息
        BuyerAllRsParam buyerAllRsParam = new BuyerAllRsParam();
        buyerAllRsParam.setBuyerId(levelRsParam.getBuyerId());
        List<BuyerAllRsParam> paginationResult = this.byimBuyerDao.findPageList(buyerAllRsParam);
        if (CollectionUtils.isNotEmpty(paginationResult)) {
            //更新买家信息
            BaseBean<ByimBuyer, ByimBuyer> baseBean = new BaseBean<>();
            ByimBuyer buyerFilter = new ByimBuyer();
            ByimBuyer buyerTarget = new ByimBuyer();
            buyerFilter.setBuyerId(levelRsParam.getBuyerId());
            buyerTarget.setFrequenterLevelCode(levelRsParam.getFrequenterLevelCode());
            buyerTarget.setFrequenterLevelF(levelRsParam.getFrequenterLevelF());
            buyerTarget.setFrequenterLevelA(levelRsParam.getFrequenterLevelA());
            buyerTarget.setLgcsAreaId(paginationResult.get(NumberConst.IntDef.INT_ZERO).getLgcsAreaId());
            buyerTarget.setZoneId(paginationResult.get(NumberConst.IntDef.INT_ZERO).getZoneId());
            buyerTarget.setDistributionId(paginationResult.get(NumberConst.IntDef.INT_ZERO).getDistributionId());
            buyerTarget.setDemesneId(paginationResult.get(NumberConst.IntDef.INT_ZERO).getDemesneId());
            buyerTarget.setUpdId(loginUserId);
            buyerTarget.setUpdTime(currentDate);
            buyerTarget.setDelFlg(false);
            baseBean.setFilter(buyerFilter);
            baseBean.setTarget(buyerTarget);
            this.byimBuyerDao.modify(baseBean);
        }
        ByimFrequenterLevel frequenterLevel = BeanUtils.toBean(levelRsParam, ByimFrequenterLevel.class);
        Long levelId = this.maxId("BYIM_FREQUENTER_LEVEL");
        frequenterLevel.setLevelId(levelId);
        frequenterLevel.setCrtId(loginUserId);
        frequenterLevel.setCrtTime(currentDate);
        frequenterLevel.setUpdId(loginUserId);
        frequenterLevel.setUpdTime(currentDate);
        frequenterLevel.setDelFlg(false);
        frequenterLevel.setVersion(NumberConst.IntDef.INT_ONE);
        return this.save(frequenterLevel);
    }
}
