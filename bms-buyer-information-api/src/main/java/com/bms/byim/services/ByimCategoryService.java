/*
 * 2016/12/06 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services;

import com.bms.byim.bean.entity.ByimCategory;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.CategoryRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>ByimCategoryService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ByimCategoryService extends BaseService {
    @Transactional(readOnly = true)
    ByimCategory findByByimCategoryCode(ByimCategory rsParam);

    @Transactional
    Integer executeBatchSave(List<ByimCategory> paramList);

    @Transactional
    List<CategoryRsParam> executeModify(List<BaseBean<ByimCategory, ByimCategory>> paramList);

    @Transactional(readOnly = true)
    Integer checkedCategoryId(CategoryRsParam param);

    @Transactional(readOnly = true)
    List<CategoryRsParam>  findListInfo(CategoryRsParam param);

    @Transactional(readOnly = true)
    int nameCount(CategoryRsParam param);
}