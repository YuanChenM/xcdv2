/*
 * 2017/01/10 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.prce.service;

import com.bms.prce.bean.param.PRCE0212IParam;
import com.bms.prce.bean.param.PRCE0214IParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>PrceProductInfoService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface PrceProductInfoService extends BaseService {

    // 商品同步
    @Transactional
    int prceGoodsSync();

    // 价盘删除
    @Transactional
    int plateDelete(List<PRCE0214IParam> param);
}