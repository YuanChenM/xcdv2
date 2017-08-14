/*
 * 2017/03/21 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services.impl;

import com.bms.byim.bean.entity.ByimBuyer;
import com.bms.byim.bean.entity.ByimGrade;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.BuyerAllRsParam;
import com.bms.byim.bean.param.GradeRsParam;
import com.bms.byim.dao.ByimBuyerDao;
import com.bms.byim.dao.ByimGradeDao;
import com.bms.byim.services.ByimGradeService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>ByimGradeService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class ByimGradeServiceImpl extends BaseServiceImpl implements ByimGradeService {

    @Autowired
    private ByimGradeDao byimGradeDao;
    @Autowired
    private ByimBuyerDao byimBuyerDao;

    @Override
    public BaseDao getBaseDao() {
        return byimGradeDao;
    }

    @Override
    public int saveGrade(GradeRsParam gradeRsParam) {
        Date currentDate = DateUtils.getCurrent();
        String loginUserId = this.getLoginUserId();
        //查询买家基本信息
        BuyerAllRsParam buyerAllRsParam = new BuyerAllRsParam();
        buyerAllRsParam.setBuyerId(gradeRsParam.getBuyerId());
        List<BuyerAllRsParam> paginationResult = this.byimBuyerDao.findPageList(buyerAllRsParam);
        if (CollectionUtils.isNotEmpty(paginationResult)) {
            //更新买家信息
            BaseBean<ByimBuyer, ByimBuyer> baseBean = new BaseBean<>();
            ByimBuyer buyerFilter = new ByimBuyer();
            ByimBuyer buyerTarget = new ByimBuyer();
            buyerFilter.setBuyerId(gradeRsParam.getBuyerId());
            buyerTarget.setGrade(gradeRsParam.getGrade());
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
        ByimGrade grade = BeanUtils.toBean(gradeRsParam, ByimGrade.class);
        Long gradeId = this.maxId("BYIM_GRADE");
        grade.setGradeId(gradeId);
        grade.setCrtId(loginUserId);
        grade.setCrtTime(currentDate);
        grade.setUpdId(loginUserId);
        grade.setUpdTime(currentDate);
        grade.setDelFlg(false);
        grade.setVersion(NumberConst.IntDef.INT_ONE);
        return this.save(grade);
    }
}