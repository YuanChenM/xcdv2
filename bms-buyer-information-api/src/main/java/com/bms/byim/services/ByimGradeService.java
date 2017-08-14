/*
 * 2017/03/21 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services;

import com.bms.byim.bean.param.GradeRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>ByimGradeService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ByimGradeService extends BaseService {
    @Transactional
    int saveGrade(GradeRsParam gradeRsParam);
}