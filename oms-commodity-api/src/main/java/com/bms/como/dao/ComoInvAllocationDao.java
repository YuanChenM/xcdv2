/*
 * 2017/03/27 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.como.dao;

import com.framework.boot.base.BaseDao;
import org.apache.ibatis.annotations.Param;

/**
 * <p>ComoInvAllocationDao。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ComoInvAllocationDao extends BaseDao {

    /**
     * 根据AL-年月 查询数量
     */
    int findInvAllocationCodeCount(@Param("allocationCode") String allocationCode);
}