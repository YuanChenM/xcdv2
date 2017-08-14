/*
 * 2017/02/22 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services;

import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.StandardGradeRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>ByimStandardGradeService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ByimStandardGradeService extends BaseService {

    @Transactional
    int updateStandardGrade(List<BaseBean<StandardGradeRsParam, StandardGradeRsParam>> param);

    @Transactional
    int insertStandardGrade(List<StandardGradeRsParam> param);
}