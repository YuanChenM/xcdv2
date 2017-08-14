/*
 * 2016/12/14 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.bms.bymt.services.impl;

import com.bms.bymt.bean.entity.BymtFoodGradeInfo;
import com.bms.bymt.bean.entity.BymtFoodGradeResult;
import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.FoodGradeResultParam;
import com.bms.bymt.bean.param.MarketFoodModuleBasicRsParam;
import com.bms.bymt.dao.BymtFoodGradeResultDao;
import com.bms.bymt.services.BymtFoodGradeInfoService;
import com.bms.bymt.services.BymtFoodGradeResultService;
import com.bms.bymt.services.BymtFoodMarketBasicService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * BymtFoodGradeResultService接口实现类。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class BymtFoodGradeResultServiceImpl extends BaseServiceImpl implements BymtFoodGradeResultService {

    @Autowired
    private BymtFoodGradeResultDao bymtFoodGradeResultDao;

    @Autowired
    private BymtFoodMarketBasicService bymtFoodMarketBasicService;
    @Autowired
    private BymtFoodGradeInfoService bymtFoodGradeInfoService;

    @Override
    public BaseDao getBaseDao() {
        return bymtFoodGradeResultDao;
    }

    @Override
    public long addFoodGradeResult(FoodGradeResultParam reqParam) {
        // 判断详情ID是否存在 == 0表示存在 不存在直接新增 否则先删除在新增
        if(reqParam.getGradeInfoId() != null && NumberUtils.compare(reqParam.getGradeInfoId().longValue(), 0L) == 1){
            BymtFoodGradeResult bymtFoodGradeResult = new BymtFoodGradeResult();
            bymtFoodGradeResult.setGradeResultId(reqParam.getGradeResultId());
            bymtFoodGradeResult.setGradeInfoId(reqParam.getGradeInfoId());
            bymtFoodGradeResult.setDelFlg(true);
            this.modify(bymtFoodGradeResult);
        }
        BymtFoodGradeResult filter = BeanUtils.toBean(reqParam, BymtFoodGradeResult.class);
        Long gradeResultId = this.maxId("BYMT_FOOD_GRADE_RESULT");
        filter.setGradeResultId(gradeResultId);
        filter.setCrtId(getLoginUserId());
        filter.setUpdId(getLoginUserId());
        filter.setUpdTime(DateUtils.getCurrent());
        filter.setCrtTime(DateUtils.getCurrent());
        filter.setVersion(1);
        filter.setDelFlg(false);
        this.save(filter);

        BymtFoodGradeInfo bymtFoodGradeInfo = bymtFoodGradeInfoService.findOne(reqParam.getGradeInfoId());
        MarketFoodModuleBasicRsParam param = new MarketFoodModuleBasicRsParam();
        param.setFoodMarketId(bymtFoodGradeInfo.getFoodMarketId());
        param.setFoodMarketLevel(reqParam.getFoodMarketLevel());
        BaseBean<MarketFoodModuleBasicRsParam, MarketFoodModuleBasicRsParam> baseBean = new BaseBean<>();
        baseBean.setFilter(param);
        baseBean.setTarget(param);
        List<BaseBean<MarketFoodModuleBasicRsParam, MarketFoodModuleBasicRsParam>> paramList = new ArrayList<>();
        paramList.add(baseBean);
        bymtFoodMarketBasicService.updateFoodMarketBasic(paramList);

        return gradeResultId;
    }
}