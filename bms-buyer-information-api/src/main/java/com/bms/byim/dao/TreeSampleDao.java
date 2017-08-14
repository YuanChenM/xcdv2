/*
 * 2016/12/06 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.dao;

import com.bms.byim.bean.entity.Tree;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * <p>ByimTreeSampleDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface TreeSampleDao extends BaseDao {
    List<Tree> findItemList(Tree tree);
    List<Tree> findParentList();
}