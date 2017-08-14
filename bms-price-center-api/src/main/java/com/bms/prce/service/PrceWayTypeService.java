/*
 * 2017/01/10 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.prce.service;

import com.bms.prce.bean.param.PRCE0202IParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>PrceWayTypeService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface PrceWayTypeService extends BaseService {
    @Transactional
    int modifyWayType(PRCE0202IParam param);
}