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

import com.framework.authority.bean.entity.TreeDoc;
import com.framework.authority.bean.param.TreeParam;
import com.framework.authority.dao.TreeDao;
import com.framework.authority.utils.EntityUtil;
import com.framework.base.bean.Pagination;
import com.framework.core.utils.ArrayUtils;
import com.framework.core.utils.UUIDUtils;
import com.mongodb.WriteResult;

/**
 * Created by zhang_jian3 on 2016/12/16.
 */
@Repository
public class TreeDaoImpl implements TreeDao {

    public static final Logger logger = LoggerFactory.getLogger(TreeDaoImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<TreeDoc> findList(TreeParam request) {
        // 输入参数
        TreeParam param = request;
        // 分页
        Pagination pageParam = request.getPagination();
        Query query = new Query();
        Map<String, Object> map = EntityUtil.entityToMap(param);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof String) {
                query.addCriteria(new Criteria(entry.getKey()).regex("^.*" + entry.getValue() + ".*$"));
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
        return this.mongoTemplate.find(query, TreeDoc.class);
    }

    @Override
    public List<TreeDoc> findAccurateList(TreeParam request) {
        // 输入参数
        TreeParam param = request;
        // 分页
        Pagination pageParam = request.getPagination();
        Query query = new Query();
        Map<String, Object> map = EntityUtil.entityToMap(param);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
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
        return this.mongoTemplate.find(query, TreeDoc.class);
    }

    @Override
    public Long findCount(TreeParam request) {
        // 输入参数
        TreeParam param = request;
        Query query = new Query();
        Map<String, Object> map = EntityUtil.entityToMap(param);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof String) {
                query.addCriteria(new Criteria(entry.getKey()).regex("^.*" + entry.getValue() + ".*$"));
            } else {
                query.addCriteria(new Criteria(entry.getKey()).is(entry.getValue()));
            }
        }
        query.addCriteria(new Criteria("delFlg").is(false));
        return this.mongoTemplate.count(query, TreeDoc.class);
    }

    @Override
    public void save(TreeDoc entity) {
        entity.setTreeId(UUIDUtils.genPrimaryKey());
        entity.setDelFlg(false);
        logger.info("Insert: " + entity);
        this.mongoTemplate.insert(entity);
    }

    @Override
    public int update(TreeDoc entity) {
        Query query = new Query();
        Criteria And = Criteria.where("treeId").is(entity.getTreeId());
        query.addCriteria(And);
        Map<String, Object> map = EntityUtil.entityToMap(entity);
        Update update = new Update();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            update.set(entry.getKey(), entry.getValue());
        }
        WriteResult writeResult = this.mongoTemplate.updateMulti(query, update, TreeDoc.class);
        return writeResult.getN();
    }

    @Override
    public int delete(List<String> entity) {
        Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("treeId").in(entity));
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("delFlg", true);
        update.set("crtTime", new java.util.Date(System.currentTimeMillis()));
        WriteResult writeResult = this.mongoTemplate.updateMulti(query, update, TreeDoc.class);
        return writeResult.getN();
    }
}
