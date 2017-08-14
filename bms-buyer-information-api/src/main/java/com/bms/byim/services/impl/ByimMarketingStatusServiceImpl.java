/*
 * 2016/12/06 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services.impl;

import com.bms.byim.bean.entity.ByimMarketingStatus;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.MarketingStatusRsParam;
import com.bms.byim.bean.result.MarketingStatusTreeRsResult;
import com.bms.byim.dao.ByimMarketingStatusDao;
import com.bms.byim.services.ByimMarketingStatusService;
import com.bms.byim.utils.DBUtil;
import com.bms.byim.utils.RestCommUtil;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>ByimMarketingStatusService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class ByimMarketingStatusServiceImpl extends BaseServiceImpl implements ByimMarketingStatusService {

    @Autowired
    private ByimMarketingStatusDao ByimMarketingStatusDao;

    @Override
    public BaseDao getBaseDao() {
        return ByimMarketingStatusDao;
    }

    /**
     * 通过父节点查询买家上线状态
     *
     * @param marketingStatus
     * @return
     */
    @Override
    public List<ByimMarketingStatus> findMarketingStatusListByParentId(ByimMarketingStatus marketingStatus) {
        return ByimMarketingStatusDao.findMarketingStatusListByParentId(marketingStatus);
    }

    @Override
    public ByimMarketingStatus findMarketingStatusById(MarketingStatusRsParam statusParam) {
        return ByimMarketingStatusDao.findMarketingStatusById(statusParam);
    }

    /**
     * 查询买家上线状态列表集合
     *
     * @param statusRsParam
     * @return
     */
    @Override
    public MarketingStatusTreeRsResult findItemList(MarketingStatusRsParam statusRsParam) {
        MarketingStatusTreeRsResult statusRsResult = new MarketingStatusTreeRsResult();
        List<MarketingStatusRsParam> statusRsParamList = this.findList(statusRsParam);
        if (CollectionUtils.isEmpty(statusRsParamList)) {
            statusRsResult.setItemList(new ArrayList<MarketingStatusTreeRsResult>());
            statusRsResult.setHasChild(false);
        } else {
            Map<Long, Boolean> map = new HashMap<>();
            //获取父节点集合
            List<MarketingStatusRsParam> beans = ByimMarketingStatusDao.findParentList();
            for (MarketingStatusRsParam bean : beans) {
                map.put(bean.getParentId(), true);
            }
            List<MarketingStatusTreeRsResult> treeRsResults = new ArrayList<>();
            MarketingStatusTreeRsResult treeItem = null;
            for (MarketingStatusRsParam rsParam : statusRsParamList) {
                treeItem = BeanUtils.toBean(rsParam, MarketingStatusTreeRsResult.class);
                map.put(rsParam.getParentId(), true);
                if (map.containsKey(rsParam.getMarketingStatusId())) {
                    treeItem.setHasChild(true);
                } else {
                    treeItem.setHasChild(false);
                }
                treeRsResults.add(treeItem);
            }
            statusRsResult.setItemList(treeRsResults);
            statusRsResult.setHasChild(true);
        }
        return statusRsResult;
    }

    /**
     * 查询买家上线状态树集合
     *
     * @param statusRsParam
     * @return
     */
    @Override
    public MarketingStatusTreeRsResult findItemTree(MarketingStatusRsParam statusRsParam) {
        MarketingStatusTreeRsResult result = new MarketingStatusTreeRsResult();
        List<MarketingStatusRsParam> trees = this.findList(statusRsParam);

        MarketingStatusTreeRsResult treeItem;
        long parentId = -1;
        for (MarketingStatusRsParam tree : trees) {
            treeItem = BeanUtils.toBean(tree, MarketingStatusTreeRsResult.class);
            if (parentId == -1) {
                parentId = treeItem.getParentId();
                result.setItemList(new ArrayList<MarketingStatusTreeRsResult>());
                result.getItemList().add(treeItem);
                result.setHasChild(true);
            } else {
                addTargetToTree(parentId, result, treeItem);
            }
        }
        return result;
    }

    private List<MarketingStatusRsParam> findList(MarketingStatusRsParam statusRsParam) {
        statusRsParam.setMarketingStatusCode(DBUtil.buildLikeCondition(statusRsParam.getMarketingStatusCode(), DBUtil.LikeMode.PARTIAL));
        statusRsParam.setMarketingStatusName(DBUtil.buildLikeCondition(statusRsParam.getMarketingStatusName(), DBUtil.LikeMode.PARTIAL));
        statusRsParam.setNodePath(DBUtil.buildLikeCondition(statusRsParam.getNodePath(), DBUtil.LikeMode.FRONT));
        return ByimMarketingStatusDao.findItemList(statusRsParam);
    }

    private void addTargetToTree(long treeId, MarketingStatusTreeRsResult tree, MarketingStatusTreeRsResult target) {
        MarketingStatusTreeRsResult lastItem;
        int treeSize;
        if (Long.compare(target.getParentId(), treeId) == NumberConst.IntDef.INT_ZERO) {
            tree.getItemList().add(target);
            tree.setHasChild(true);
        } else {
            treeSize = tree.getItemList().size();
            if (treeSize > NumberConst.IntDef.INT_ZERO) {
                lastItem = tree.getItemList().get(treeSize - NumberConst.IntDef.INT_ONE);
                if (CollectionUtils.isEmpty(lastItem.getItemList())) {
                    lastItem.setItemList(new ArrayList<MarketingStatusTreeRsResult>());
                }
                addTargetToTree(lastItem.getMarketingStatusId(), lastItem, target);
            }
        }
    }

    /**
     * 批量新增买家上线状态
     *
     * @param statusParamList
     * @return
     */
    @Override
    public int saveStatusParamList(List<ByimMarketingStatus> statusParamList) {
        List<List<ByimMarketingStatus>> list = RestCommUtil.insertRanking(statusParamList);
        int result = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(list)) {
            int listCount = list.size();
            for (int i = NumberConst.IntDef.INT_ZERO; i < listCount; i++) {
                int res = this.batchSave(list.get(i));
                result = result + res;
            }
        }
        return result;
    }

    /**
     * 批量修改买家上线状态
     *
     * @param statusParamList
     * @return
     */
    @Override
    public int modifyMarketingstatusList(List<BaseBean<MarketingStatusRsParam, MarketingStatusRsParam>> statusParamList) {
        BaseBean<ByimMarketingStatus, ByimMarketingStatus> baseBean = new BaseBean<>();
        Date currentDate = DateUtils.getCurrent();
        int listSize = statusParamList.size();
        int result = NumberConst.IntDef.INT_ZERO;
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            MarketingStatusRsParam filter = statusParamList.get(i).getFilter();
            MarketingStatusRsParam target = statusParamList.get(i).getTarget();
            ByimMarketingStatus marketingStatusEntityFilter = BeanUtils.toBean(filter, ByimMarketingStatus.class);
            ByimMarketingStatus marketingStatusEntityTarget = BeanUtils.toBean(target, ByimMarketingStatus.class);
            marketingStatusEntityTarget.setUpdId(getLoginUserId());
            marketingStatusEntityTarget.setUpdTime(currentDate);
            baseBean.setFilter(marketingStatusEntityFilter);
            baseBean.setTarget(marketingStatusEntityTarget);
            //true删除,false修改
            if (StringUtils.isNotEmpty(StringUtils.toString(target.getDelFlg()))) {
                //查询删除ID的节点地址
                ByimMarketingStatus marketingStatus = this.ByimMarketingStatusDao.findNodePath(marketingStatusEntityFilter);
                if (marketingStatus != null) {
                    //String nodePath = DBUtil.buildLikeCondition(marketingStatus.getNodePath() + ",", DBUtil.LikeMode.FRONT);
                    //通过节点地址查询需要删除的节点
                    marketingStatusEntityFilter.setNodePath(marketingStatus.getNodePath());
                    List marketingStatusIds = this.ByimMarketingStatusDao.findMarketingStatusIds(marketingStatusEntityFilter);
                    if (CollectionUtils.isNotEmpty(marketingStatusIds)) {
                        result = this.ByimMarketingStatusDao.findMarketingStatusUse(marketingStatusIds);
                        if (result > 0) {//判断父节点下子节点是否被使用
                            result = NumberConst.IntDef.INT_N_TWO;
                        } else {
                            result = this.ByimMarketingStatusDao.deleteMarketingStatus(marketingStatusIds);
                        }
                    }
                }
            } else {
                int res = this.modify(baseBean);
                result = result + res;
            }
        }
        return result;
    }

    /**
     * 判断买家上线状态是否被使用
     *
     * @param statusParamList
     * @return
     */
    @Override
    public int findMarketingStatus(List<BaseBean<MarketingStatusRsParam, MarketingStatusRsParam>> statusParamList) {
        int result = NumberConst.IntDef.INT_ZERO;
        for (int i = NumberConst.IntDef.INT_ZERO; i < statusParamList.size(); i++) {
            result = ByimMarketingStatusDao.findMarketingStatus(statusParamList.get(i));
        }
        return result;
    }
}