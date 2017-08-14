/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.bymt.services.impl;

import com.bms.bymt.bean.entity.BymtLevelStandard;
import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.dao.BymtLevelStandardDao;
import com.bms.bymt.services.BymtLevelStandardService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>BymtLevelStandardService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class BymtLevelStandardServiceImpl extends BaseServiceImpl implements BymtLevelStandardService {

    @Autowired
    private BymtLevelStandardDao bymtLevelStandardDao;

    @Override
    public BaseDao getBaseDao() {
        return bymtLevelStandardDao;
    }

    @Override
    public int saveLevelStandard(BymtLevelStandard param) {
        Date currentDate = DateUtils.getCurrent();
        Long standardId = this.maxId("BYMT_LEVEL_STANDARD");
        param.setStandardId(standardId);
        param.setDelFlg(false);
        param.setCrtTime(currentDate);
        param.setUpdTime(currentDate);
        param.setCrtId(getLoginUserId());
        param.setUpdId(getLoginUserId());
        param.setVersion(NumberConst.IntDef.INT_ONE);
        int count = this.save(param);
        return count;
    }

    @Override
    public int modifyLevelStandard(BaseBean<BymtLevelStandard, BymtLevelStandard> param) {
        Date currentDate = DateUtils.getCurrent();
        param.getTarget().setUpdTime(currentDate);
        param.getTarget().setUpdId(getLoginUserId());
        return this.modify(param);
    }
}