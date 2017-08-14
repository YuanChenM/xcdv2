/*
 * 2017/05/02 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerLevelStandardPageParam;
import com.bms.agif.bean.result.ButlerLevelStandardResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>AgifButlerLevelStandardService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface AgifButlerLevelStandardService extends BaseService {

    @Transactional
    ButlerLevelStandardResult saveButlerLevelStandard(List<ButlerLevelStandardPageParam> param);

    @Transactional
    ButlerLevelStandardResult modifyButlerLevelStandard(List<BaseBean<ButlerLevelStandardPageParam, ButlerLevelStandardPageParam>> param);
}