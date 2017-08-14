/*
 * 2017/01/10 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.prce.service;

import com.bms.prce.bean.param.PRCE0209IParam;
import com.bms.prce.bean.result.PRCE0208IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>PrcePricePlateDetailService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface PrcePricePlateDetailService extends BaseService {
    void dealPlateDetail(List<PRCE0208IResult> results);

    @Transactional
    int modifyPricePlate(List<PRCE0209IParam> param);
}