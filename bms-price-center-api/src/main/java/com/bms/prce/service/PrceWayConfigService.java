/*
 * 2017/01/10 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.prce.service;

import com.bms.prce.bean.param.PRCE0206IParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>PrceWayConfigService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface PrceWayConfigService extends BaseService {
    @Transactional
    List<Long> modifyWayConfig(List<PRCE0206IParam> param);
}