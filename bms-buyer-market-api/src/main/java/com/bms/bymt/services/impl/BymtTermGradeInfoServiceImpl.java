/*
 * 2016/12/14 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.bms.bymt.services.impl;

import com.bms.bymt.bean.entity.BymtTermGradeInfo;
import com.bms.bymt.bean.param.TermGradeInfoParam;
import com.bms.bymt.bean.result.TerminalModuleDefGradeResult;
import com.bms.bymt.dao.BymtTermGradeInfoDao;
import com.bms.bymt.services.BymtTermGradeInfoService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>BymtTermGradeInfoService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class BymtTermGradeInfoServiceImpl extends BaseServiceImpl implements BymtTermGradeInfoService {

    @Autowired
    private BymtTermGradeInfoDao bymtTermGradeInfoDao;

    @Override
    public BaseDao getBaseDao() {
        return bymtTermGradeInfoDao;
    }

    @Override
    public long addTermGradeInfo(TermGradeInfoParam reqParam) {
        // 判断详情ID是否存在 == 0表示存在 不存在直接新增 否则先删除在新增
        if (reqParam.getTermMarketId() != null && reqParam.getGradeInfoId() != null && NumberUtils.compare(reqParam.getGradeInfoId().longValue(), 0L) == 1) {
            BymtTermGradeInfo bymtTermGradeInfo = new BymtTermGradeInfo();
            bymtTermGradeInfo.setTermMarketId(reqParam.getTermMarketId());
            bymtTermGradeInfo.setDelFlg(true);
            this.modify(bymtTermGradeInfo);
        }
        BymtTermGradeInfo filter = BeanUtils.toBean(reqParam, BymtTermGradeInfo.class);
        Long gradeInfoId = this.maxId("BYMT_TERM_GRADE_INFO");
        filter.setGradeInfoId(gradeInfoId);
        filter.setCrtId(getLoginUserId());
        filter.setUpdId(getLoginUserId());
        filter.setCrtId(getLoginUserId());
        filter.setUpdId(getLoginUserId());
        filter.setUpdTime(DateUtils.getCurrent());
        filter.setCrtTime(DateUtils.getCurrent());
        filter.setVersion(NumberConst.IntDef.INT_ZERO);
        this.save(filter);
        return gradeInfoId;
    }

    @Override
    public TerminalModuleDefGradeResult findBuyerMarketTerminalDefineGrade(TermGradeInfoParam gradeInfoParam) {
        return bymtTermGradeInfoDao.getDefineGrade(gradeInfoParam);
    }
}