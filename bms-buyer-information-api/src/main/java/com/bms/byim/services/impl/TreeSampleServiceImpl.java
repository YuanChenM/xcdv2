/*
 * 2016/12/06 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services.impl;

import com.bms.byim.bean.entity.Tree;
import com.bms.byim.bean.param.TreeRsParam;
import com.bms.byim.bean.result.TreeRsResult;
import com.bms.byim.dao.TreeSampleDao;
import com.bms.byim.services.TreeSampleService;
import com.bms.byim.utils.DBUtil;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>ByimTreeSampleService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class TreeSampleServiceImpl extends BaseServiceImpl implements TreeSampleService {

    @Autowired
    private TreeSampleDao treeSampleDao;

    @Override
    public BaseDao getBaseDao() {
        return treeSampleDao;
    }

    private List<Tree> findList(TreeRsParam treeRsParam) {
        Tree tree = BeanUtils.toBean(treeRsParam, Tree.class);
        tree.setItemCode(DBUtil.buildLikeCondition(tree.getItemCode(), DBUtil.LikeMode.PARTIAL));
        tree.setItemName(DBUtil.buildLikeCondition(tree.getItemName(), DBUtil.LikeMode.PARTIAL));
        tree.setNodePath(DBUtil.buildLikeCondition(tree.getNodePath(), DBUtil.LikeMode.FRONT));
        return treeSampleDao.findItemList(tree);
    }

    @Override
    public TreeRsResult findItemList(TreeRsParam treeRsParam) {
        TreeRsResult result = new TreeRsResult();
        List<Tree> trees = this.findList(treeRsParam);
        if (CollectionUtils.isEmpty(trees)) {
            result.setItemList(new ArrayList<TreeRsResult>());
            result.setHasChild(false);
        } else {
            Map<Long,Boolean> map = new HashMap<>();
            List<Tree> beans = treeSampleDao.findParentList();
            for (Tree bean : beans) {
                map.put(bean.getParentId(), true);
            }
            List<TreeRsResult> treeRsResults = new ArrayList<>();
            TreeRsResult treeItem;
            for (Tree tree : trees) {
                treeItem = BeanUtils.toBean(tree, TreeRsResult.class);
                map.put(tree.getParentId(), true);
                if(map.containsKey(tree.getItemId())){
                    treeItem.setHasChild(true);
                }else{
                    treeItem.setHasChild(false);
                }
                treeRsResults.add(treeItem);
            }
            result.setItemList(treeRsResults);
            result.setHasChild(true);
        }
        return result;
    }

    @Override
    public TreeRsResult findItemTree(TreeRsParam treeRsParam) {
        TreeRsResult result = new TreeRsResult();
        List<Tree> trees = this.findList(treeRsParam);

        TreeRsResult treeItem;
        long parentId = -1;
        for (Tree tree : trees) {

            treeItem = BeanUtils.toBean(tree, TreeRsResult.class);

            if (parentId == -1) {
                parentId = treeItem.getParentId();
                result.setItemList(new ArrayList<TreeRsResult>());
                result.getItemList().add(treeItem);
                result.setHasChild(true);
            } else {
                addTargetToTree(parentId, result, treeItem);
            }
        }
        return result;
    }

    private void addTargetToTree(long treeId, TreeRsResult tree, TreeRsResult target) {
        TreeRsResult lastItem;
        int treeSize;
        if (Long.compare(target.getParentId(), treeId) == 0) {
            tree.getItemList().add(target);
            tree.setHasChild(true);
        } else {

            treeSize = tree.getItemList().size();
            if (treeSize > 0) {
                lastItem = tree.getItemList().get(treeSize - 1);
                if (CollectionUtils.isEmpty(lastItem.getItemList())) {
                    lastItem.setItemList(new ArrayList<TreeRsResult>());
                }
                addTargetToTree(lastItem.getItemId(), lastItem, target);
            }
        }
    }
}