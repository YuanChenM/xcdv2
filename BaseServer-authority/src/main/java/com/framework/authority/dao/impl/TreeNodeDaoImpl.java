package com.framework.authority.dao.impl;

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

import com.framework.authority.bean.entity.ResourceBean;
import com.framework.authority.bean.entity.TreeNodeDoc;
import com.framework.authority.bean.param.TreeNodeParam;
import com.framework.authority.dao.TreeNodeDao;
import com.framework.authority.utils.EntityUtil;
import com.framework.base.bean.Pagination;
import com.framework.core.utils.ArrayUtils;
import com.mongodb.WriteResult;

/**
 * Created by zhang_jian3 on 2016/12/7.
 */
@Repository
public class TreeNodeDaoImpl implements TreeNodeDao {

    public static final Logger logger = LoggerFactory.getLogger(TreeNodeDaoImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<TreeNodeDoc> findList(TreeNodeParam request) {
        // 输入参数
        TreeNodeParam param = request;
        // 分页
        Pagination pageParam = param.getPagination();
        Query query = new Query();
        Map<String, Object> map = EntityUtil.entityToMap(param);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof String) {
                query.addCriteria(new Criteria(entry.getKey()).regex("^.*" + entry.getValue() + ".*$"));
            } else if (entry.getValue() instanceof List) {
                for (ResourceBean resourceBean : (List<ResourceBean>) entry.getValue()) {
                    Map<String, Object> resourceMap = EntityUtil.entityToMap(resourceBean);
                    for (Map.Entry<String, Object> resourceEntry : resourceMap.entrySet()) {
                        query.addCriteria(
                            new Criteria(entry.getKey() + "." + resourceEntry.getKey()).is(resourceEntry.getValue()));
                    }
                }
            } else {
                query.addCriteria(new Criteria(entry.getKey()).is(entry.getValue()));
            }
        }
        query.addCriteria(new Criteria("delFlg").is(false));
        com.framework.base.bean.Sort[] baseRestSortParam = request.getSort();
        if (ArrayUtils.isNotEmpty(baseRestSortParam)) {
            query.with(new Sort(new Sort.Order(Sort.Direction.ASC, baseRestSortParam[0].getSortField())));
        }
        if (null != pageParam) {
            query.skip(pageParam.getStartPos() * pageParam.getPageSize()).limit(pageParam.getPageSize());
        }
        return this.mongoTemplate.find(query, TreeNodeDoc.class);
    }

    @Override
    public List<TreeNodeDoc> findAccurateList(TreeNodeParam request) {
        // 输入参数
        TreeNodeParam param = request;
        // 分页
        Pagination pageParam = param.getPagination();
        Query query = new Query();
        Map<String, Object> map = EntityUtil.entityToMap(param);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof List) {
                for (ResourceBean resourceBean : (List<ResourceBean>) entry.getValue()) {
                    Map<String, Object> resourceMap = EntityUtil.entityToMap(resourceBean);
                    for (Map.Entry<String, Object> resourceEntry : resourceMap.entrySet()) {
                        query.addCriteria(
                            new Criteria(entry.getKey() + "." + resourceEntry.getKey()).is(resourceEntry.getValue()));
                    }
                }
            } else
                query.addCriteria(new Criteria(entry.getKey()).is(entry.getValue()));
        }
        query.addCriteria(new Criteria("delFlg").is(false));
        com.framework.base.bean.Sort[] baseRestSortParam = request.getSort();
        if (ArrayUtils.isNotEmpty(baseRestSortParam)) {
            query.with(new Sort(new Sort.Order(Sort.Direction.ASC, baseRestSortParam[0].getSortField())));
        }
        if (null != pageParam) {
            query.skip(pageParam.getStartPos() * pageParam.getPageSize()).limit(pageParam.getPageSize());
        }
        return this.mongoTemplate.find(query, TreeNodeDoc.class);
    }

    @Override
    public Long findCount(TreeNodeParam request) {
        // 输入参数
        TreeNodeParam param = request;
        Query query = new Query();
        Map<String, Object> map = EntityUtil.entityToMap(param);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof String) {
                query.addCriteria(new Criteria(entry.getKey()).regex("^.*" + entry.getValue() + ".*$"));
            } else if (entry.getValue() instanceof List) {
                for (ResourceBean resourceBean : (List<ResourceBean>) entry.getValue()) {
                    Map<String, Object> resourceMap = EntityUtil.entityToMap(resourceBean);
                    for (Map.Entry<String, Object> resourceEntry : resourceMap.entrySet()) {
                        query.addCriteria(
                            new Criteria(entry.getKey() + "." + resourceEntry.getKey()).is(resourceEntry.getValue()));
                    }
                }
            } else {
                query.addCriteria(new Criteria(entry.getKey()).is(entry.getValue()));
            }
        }
        query.addCriteria(new Criteria("delFlg").is(false));

        return this.mongoTemplate.count(query, TreeNodeDoc.class);
    }

    @Override
    public void save(TreeNodeDoc entity) {
        // entity.setNodeId(UUIDUtils.genPrimaryKey());
        entity.setDelFlg(false);
        logger.info("Insert: " + entity);
        this.mongoTemplate.insert(entity);
    }

    @Override
    public int update(TreeNodeDoc entity) {
        Query query = new Query();
        Criteria And = Criteria.where("nodeId").is(entity.getNodeId());
        query.addCriteria(And);
        Map<String, Object> map = EntityUtil.entityToMap(entity);
        Update update = new Update();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            update.set(entry.getKey(), entry.getValue());
        }
        WriteResult writeResult = this.mongoTemplate.updateMulti(query, update, TreeNodeDoc.class);
        return writeResult.getN();
    }

    @Override
    public int delete(List<String> entity) {
        Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("nodeId").in(entity));
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("delFlg", true);
        update.set("crtTime", new java.util.Date(System.currentTimeMillis()));
        WriteResult writeResult = this.mongoTemplate.updateMulti(query, update, TreeNodeDoc.class);
        return writeResult.getN();
    }

    @Override
    public List<TreeNodeDoc> findTreeNodeDetail(List<String> nodeIds) {
        Query query = new Query(Criteria.where("nodeCode").in(nodeIds));
        query.with(new Sort(new Sort.Order(Sort.Direction.ASC, "path")));
        return this.mongoTemplate.find(query, TreeNodeDoc.class);
    }
}
