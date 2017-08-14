/*
 * 2016/12/29 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services;

import com.bms.byim.bean.entity.ByimEmployee;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.EmployeeRsParam;
import com.bms.byim.bean.result.EmployeeRsResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>ByimEmployeeService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ByimEmployeeService extends BaseService {
    @Transactional
    EmployeeRsResult executeBatchSave(List<ByimEmployee> paramList);

    @Transactional
    int executeUpdate(BaseBean<EmployeeRsParam, EmployeeRsParam> param);
}