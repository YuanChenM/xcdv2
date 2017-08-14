/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>AgifButlerService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface AgifButlerService extends BaseService {
    @Transactional
    String insertButlerAndAddress(ButlerRsParam butlerRsParam);

    @Transactional
    int updateButler(BaseBean<ButlerRsParam, ButlerRsParam> butlerRsParam);
}