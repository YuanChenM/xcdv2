package com.framework.authority.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.framework.authority.bean.entity.GroupDoc;
import com.framework.authority.bean.entity.TreeNodeBean;
import com.framework.authority.bean.param.GroupParam;
import com.framework.authority.dao.GroupDao;
import com.framework.authority.utils.EntityUtil;
import com.framework.base.bean.Pagination;
import com.framework.core.utils.ArrayUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.UUIDUtils;
import com.mongodb.WriteResult;

/**
 * Created by zhang_jian3 on 2016/12/7.
 */
@Repository
public class GroupDaoImpl implements GroupDao {

    /**
     * logger
     */
    public static final Logger logger = LoggerFactory.getLogger(GroupDaoImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询方法
     *
     * @param request 参数
     * @return 返回
     */
    @Override
    public List<GroupDoc> findList(GroupParam request) {

        // 输入参数
        GroupParam param = request;

        // 分页
        Pagination pageParam = request.getPagination();

        Query query = new Query();
        Map<String, Object> map = EntityUtil.entityToMap(param);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof String) {
                query.addCriteria(new Criteria(entry.getKey()).regex("^.*" + entry.getValue() + ".*$"));
            } else if (entry.getValue() instanceof List) {
                for (TreeNodeBean treeNodeBean : (List<TreeNodeBean>) entry.getValue()) {
                    Map<String, Object> resourceMap = EntityUtil.entityToMap(treeNodeBean);
                    for (Map.Entry<String, Object> treeNodeBeanEntry : resourceMap.entrySet()) {
                        query.addCriteria(new Criteria(entry.getKey() + "." + treeNodeBeanEntry.getKey())
                            .regex("^.*" + treeNodeBeanEntry.getValue() + ".*$"));
                    }
                }
            } else {
                query.addCriteria(new Criteria(entry.getKey()).is(entry.getValue()));
            }
        }
        /**
         * 删除标志
         */
        query.addCriteria(new Criteria("delFlg").is(false));
        com.framework.base.bean.Sort[] baseRestSortParam = request.getSort();
        if (ArrayUtils.isNotEmpty(baseRestSortParam)) {
            query.with(new Sort(new Sort.Order(Sort.Direction.ASC, baseRestSortParam[0].getSortField())));
        }
        // 判断是否分页
        if (null != request.getPagination()) {
            query.skip(pageParam.getStartPos() * pageParam.getPageSize()).limit(pageParam.getPageSize());
        }
        List<GroupDoc> list = this.mongoTemplate.find(query, GroupDoc.class);

        return list;
    }

    @Override
    public List<GroupDoc> findAccurateList(GroupParam request) {

        // 输入参数
        GroupParam param = request;

        // 分页
        Pagination pageParam = request.getPagination();

        Query query = new Query();
        Map<String, Object> map = EntityUtil.entityToMap(param);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof List) {
                for (TreeNodeBean treeNodeBean : (List<TreeNodeBean>) entry.getValue()) {
                    Map<String, Object> resourceMap = EntityUtil.entityToMap(treeNodeBean);
                    for (Map.Entry<String, Object> treeNodeBeanEntry : resourceMap.entrySet()) {
                        query.addCriteria(new Criteria(entry.getKey() + "." + treeNodeBeanEntry.getKey())
                            .regex("^.*" + treeNodeBeanEntry.getValue() + ".*$"));
                    }
                }
            } else
                query.addCriteria(new Criteria(entry.getKey()).is(entry.getValue()));
        }
        /**
         * 删除标志
         */
        query.addCriteria(new Criteria("delFlg").is(false));
        com.framework.base.bean.Sort[] baseRestSortParam = request.getSort();
        if (ArrayUtils.isNotEmpty(baseRestSortParam)) {
            query.with(new Sort(new Sort.Order(Sort.Direction.ASC, baseRestSortParam[0].getSortField())));
        }
        // 判断是否分页
        if (null != request.getPagination()) {
            query.skip(pageParam.getStartPos() * pageParam.getPageSize()).limit(pageParam.getPageSize());
        }
        List<GroupDoc> list = this.mongoTemplate.find(query, GroupDoc.class);
        return list;
    }

    @Override
    public Long findCount(GroupParam request) {
        GroupParam param = request;
        Query query = new Query();
        Map<String, Object> map = EntityUtil.entityToMap(param);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof String) {
                query.addCriteria(new Criteria(entry.getKey()).regex("^.*" + entry.getValue() + ".*$"));
            } else if (entry.getValue() instanceof List) {
                for (TreeNodeBean treeNodeBean : (List<TreeNodeBean>) entry.getValue()) {
                    Map<String, Object> resourceMap = EntityUtil.entityToMap(treeNodeBean);
                    for (Map.Entry<String, Object> treeNodeBeanEntry : resourceMap.entrySet()) {
                        query.addCriteria(new Criteria(entry.getKey() + "." + treeNodeBeanEntry.getKey())
                            .regex("^.*" + treeNodeBeanEntry.getValue() + ".*$"));
                    }
                }
            } else {
                query.addCriteria(new Criteria(entry.getKey()).is(entry.getValue()));
            }
        }
        query.addCriteria(new Criteria("delFlg").is(false));
        return this.mongoTemplate.count(query, GroupDoc.class);
    }

    /**
     * 保存数据
     *
     * @param entity
     * @return
     */
    @Override
    public boolean save(GroupDoc entity) {

        // 删除标志
        entity.setDelFlg(false);
        // 主键
        entity.setGroupId(UUIDUtils.genPrimaryKey());
        this.mongoTemplate.insert(entity);
        return true;
    }

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    @Override
    public int update(GroupDoc entity) {

        Query query = new Query();
        Criteria And = Criteria.where("groupId").is(entity.getGroupId()).and("delFlg").is(false);
        query.addCriteria(And);
        Map<String, Object> map = EntityUtil.entityToMap(entity);
        Update update = new Update();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            update.set(entry.getKey(), entry.getValue());
        }
        update.set("crtTime", new Date());
        WriteResult writeResult = this.mongoTemplate.updateMulti(query, update, GroupDoc.class);
        return writeResult.getN();
    }

    /**
     * 批量删除数据(逻辑删除)
     *
     * @param entity
     * @return
     */
    @Override
    public int delete(List<String> entity) {

        Query query = new Query(new Criteria().where("groupId").in(entity));
        Update update = new Update();
        // 删除标志（已删除）
        update.set("delFlg", true);
        // 删除时间
        update.set("crtTime", new Date());
        WriteResult writeResult = this.mongoTemplate.updateMulti(query, update, GroupDoc.class);
        return writeResult.getN();
    }

    @Override
    public List<TreeNodeBean> findTreeNode(List<String> groupIds) {
        List<TreeNodeBean> returnList = new ArrayList<>();
        Query query = new Query(Criteria.where("groupCode").in(groupIds));
        query.with(new Sort(new Sort.Order(Sort.Direction.ASC, "path")));
        List<GroupDoc> list = this.mongoTemplate.find(query, GroupDoc.class);
        for (GroupDoc groupDoc : list) {
            List<TreeNodeBean> oneList = groupDoc.getTreeNode();
            if (!CollectionUtils.isEmpty(oneList)) {
                returnList.addAll(oneList);
            }
        }
        return returnList;
    }
}
