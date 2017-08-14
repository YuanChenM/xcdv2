/*
 * 2016/12/06 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services;

import com.bms.byim.bean.param.TreeRsParam;
import com.bms.byim.bean.result.TreeRsResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>ByimTreeSampleService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface TreeSampleService extends BaseService {
    @Transactional(readOnly = true)
    TreeRsResult findItemList(TreeRsParam treeRsParam);

    @Transactional(readOnly = true)
    TreeRsResult findItemTree(TreeRsParam treeRsParam);
}