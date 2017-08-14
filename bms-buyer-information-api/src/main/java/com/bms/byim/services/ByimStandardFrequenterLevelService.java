/*
 * 2017/02/22 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services;

import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.StandardFrequenterLevelRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>ByimStandardFrequenterLevelService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ByimStandardFrequenterLevelService extends BaseService {

    @Transactional
    int updateFrequenterLevel(List<BaseBean<StandardFrequenterLevelRsParam, StandardFrequenterLevelRsParam>> param);

    @Transactional
    int insertFrequenterLevel(List<StandardFrequenterLevelRsParam> param);

}