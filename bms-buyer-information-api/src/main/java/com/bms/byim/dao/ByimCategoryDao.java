/*
 * 2016/12/06 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.dao;

import com.bms.byim.bean.entity.ByimCategory;
import com.bms.byim.bean.param.CategoryRsParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * <p>ByimCategoryDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ByimCategoryDao extends BaseDao {
    ByimCategory findByByimCategoryCode(ByimCategory rsParam);

    Integer checkedCategoryId(CategoryRsParam param);

    List<CategoryRsParam> findListInfo (CategoryRsParam param);

    Integer modifyDelFag(CategoryRsParam param);
    Integer modifyLikeDelFag(CategoryRsParam param);
    Integer nameCount(CategoryRsParam param);

    String selectCode();
}