package com.batch.bybatch.dao;

import com.batch.bybatch.bean.entity.ByimBuyer;
import com.batch.bybatch.bean.entity.ByimFrequenterLevel;
import com.batch.bybatch.bean.entity.ByimGrade;
import com.batch.bybatch.bean.result.ByimBuyerResult;
import com.batch.bybatch.bean.result.StandardFrequenterLevelResult;
import com.batch.bybatch.bean.result.StandardGradeResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by guan_zhongheng on 2017/2/23.
 */
public interface BYIM0101BDao extends BaseDao{

    /**
     * 查询买家基础信息
     * @return
     */
    List<ByimBuyerResult> findByimBasicList();

    /**
     * 查询常客买家定级标准表
     * @return
     */
    List<StandardFrequenterLevelResult> findStandardLevelList();

    /**
     * 查询买家定性评级标准表
     * @return
     */
    List<StandardGradeResult> findStandardGradeList();

    /**
     * 更新买家基础信息标准信息
     * @param byimBuyer
     */
    void updateStandard(ByimBuyer byimBuyer);

    /**
     * 更新买家计算标准履历信息
     * @param bean
     */
    void saveFrequenterLevel(ByimFrequenterLevel bean);

    /**
     * 更新买家计算等级履历信息
     * @param bean
     */
    void saveGrade(ByimGrade bean);
}
