/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.bymt.services;

import com.bms.bymt.bean.entity.BymtLevelStandard;
import com.bms.bymt.bean.param.BaseBean;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>BymtLevelStandardService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface BymtLevelStandardService extends BaseService {

    @Transactional
    int saveLevelStandard(BymtLevelStandard param);

    @Transactional
    int modifyLevelStandard(BaseBean<BymtLevelStandard, BymtLevelStandard> param);


}