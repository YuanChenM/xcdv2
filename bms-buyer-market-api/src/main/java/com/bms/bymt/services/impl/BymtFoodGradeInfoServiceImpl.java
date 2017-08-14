/*
 * 2016/12/14 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.bms.bymt.services.impl;

import com.bms.bymt.bean.entity.BymtFoodGradeInfo;
import com.bms.bymt.bean.param.FoodGradeInfoParam;
import com.bms.bymt.bean.result.FoodGradeRsResult;
import com.bms.bymt.dao.BymtFoodGradeInfoDao;
import com.bms.bymt.services.BymtFoodGradeInfoService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * BymtFoodGradeInfoService接口实现类。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class BymtFoodGradeInfoServiceImpl extends BaseServiceImpl implements BymtFoodGradeInfoService {

    Logger logger = LoggerFactory.getLogger(BymtFoodGradeInfoServiceImpl.class);
    @Autowired
    private BymtFoodGradeInfoDao bymtFoodGradeInfoDao;

    @Override
    public BaseDao getBaseDao() {
        return bymtFoodGradeInfoDao;
    }

    @Override
    public long addFoodGradeInfo(FoodGradeInfoParam reqParam){
        // 判断详情ID是否存在 == 0表示存在 不存在直接新增 否则先删除在新增
        if(reqParam.getGradeInfoId() != null && NumberUtils.compare(reqParam.getGradeInfoId().longValue(), 0L) == 1){
            BymtFoodGradeInfo foodGradeInfo  = new BymtFoodGradeInfo();
            foodGradeInfo.setFoodMarketId(reqParam.getFoodMarketId());
            foodGradeInfo.setGradeInfoId(reqParam.getGradeInfoId());
            foodGradeInfo.setDelFlg(true);
            this.modify(foodGradeInfo);
        }
        BymtFoodGradeInfo filter = BeanUtils.toBean(reqParam, BymtFoodGradeInfo.class);
        Long gradeInfoId = this.maxId("BYMT_FOOD_GRADE_INFO");
        filter.setGradeInfoId(gradeInfoId);
        filter.setCrtId(this.getLoginUserId());
        filter.setUpdId(this.getLoginUserId());
        filter.setUpdTime(DateUtils.getCurrent());
        filter.setCrtTime(DateUtils.getCurrent());
        filter.setVersion(1);
        filter.setDelFlg(false);
        try {
            int result =  this.save(filter);
            if(result > 0){
                return gradeInfoId;
            }
        }catch (Exception e){
            logger.error("数据库调用失败:" + e.getMessage());
        }
        return 0L;
    };

    @Override
    public FoodGradeRsResult findBuyerMarketFoodDefineGrade(FoodGradeInfoParam gradeInfoParam) {
        return bymtFoodGradeInfoDao.findBuyerMarketFoodDefineGrade(gradeInfoParam);
    }
}