/*
 * 2017/01/10 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.prce.service;

import com.bms.prce.bean.param.PRCE0211IParam;
import com.bms.prce.bean.result.PRCE0211IResult;
import com.framework.boot.base.BaseService;

import java.util.List;

/**
 * <p>PrcePricePlateCompareService。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface PrcePricePlateCompareService extends BaseService {
    List<PRCE0211IResult> comparePricePlates(List<PRCE0211IParam> param);
}