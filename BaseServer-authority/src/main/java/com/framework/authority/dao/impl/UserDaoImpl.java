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

import com.framework.authority.bean.entity.TreeNodeBean;
import com.framework.authority.bean.entity.UserDoc;
import com.framework.authority.bean.param.UserParam;
import com.framework.authority.dao.UserDao;
import com.framework.authority.utils.EntityUtil;
import com.framework.base.bean.Pagination;
import com.framework.core.utils.ArrayUtils;
import com.framework.core.utils.UUIDUtils;
import com.mongodb.WriteResult;

/**
 * Created by zhang_jian3 on 2016/12/7.
 */
@Repository
public class UserDaoImpl implements UserDao {
    public static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询方法
     *
     * @param request 参数
     * @return 返回
     */
    @Override
    public List<UserDoc> findList(UserParam request) {
        UserParam entity = request;
        Pagination pageParam = entity.getPagination();
        Query query = new Query();
        Criteria criteria = new Criteria();
        Map<String, Object> map = EntityUtil.entityToMap(entity);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof String) {
                query.addCriteria(new Criteria(entry.getKey()).regex("^.*" + entry.getValue() + ".*$"));
            } else if (entry.getValue() instanceof List && !"group".equals(entry.getKey())) {
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
        criteria.and("delFlg").is(false);
        query.addCriteria(criteria);
        com.framework.base.bean.Sort[] baseRestSortParam = request.getSort();
        if (ArrayUtils.isNotEmpty(baseRestSortParam)) {
            query.with(new Sort(new Sort.Order(Sort.Direction.ASC, baseRestSortParam[0].getSortField())));
        }
        /**
         * 判断是否分页
         */
        if (null != request.getPagination()) {
            query.skip(pageParam.getStartPos() * pageParam.getPageSize()).limit(pageParam.getPageSize());
        }
        List<UserDoc> list = this.mongoTemplate.find(query, UserDoc.class);
        return list;
    }

    @Override
    public List<UserDoc> findAccurateList(UserParam request) {
        UserParam entity = request;
        Pagination pageParam = entity.getPagination();
        Query query = new Query();
        Criteria criteria = new Criteria();
        Map<String, Object> map = EntityUtil.entityToMap(entity);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof List && !"group".equals(entry.getKey())) {
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
        criteria.and("delFlg").is(false);
        query.addCriteria(criteria);
        com.framework.base.bean.Sort[] baseRestSortParam = request.getSort();
        if (ArrayUtils.isNotEmpty(baseRestSortParam)) {
            query.with(new Sort(new Sort.Order(Sort.Direction.ASC, baseRestSortParam[0].getSortField())));
        }
        /**
         * 判断是否分页
         */
        if (null != request.getPagination()) {
            query.skip(pageParam.getStartPos() * pageParam.getPageSize()).limit(pageParam.getPageSize());
        }
        List<UserDoc> list = this.mongoTemplate.find(query, UserDoc.class);
        return list;
    }

    @Override
    public Long findCount(UserParam request) {
        UserParam entity = request;
        Query query = new Query();
        Criteria criteria = new Criteria();
        Map<String, Object> map = EntityUtil.entityToMap(entity);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof String) {
                query.addCriteria(new Criteria(entry.getKey()).regex("^.*" + entry.getValue() + ".*$"));
            } else if (entry.getValue() instanceof List && !"group".equals(entry.getKey())) {
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
        criteria.and("delFlg").is(false);
        query.addCriteria(criteria);
        return this.mongoTemplate.count(query, UserDoc.class);
    }

    /**
     * 保存数据
     *
     * @param entity
     * @return
     */
    @Override
    public void save(UserDoc entity) {
        entity.setUserId(UUIDUtils.genPrimaryKey());
        entity.setDelFlg(false);
        logger.info("Insert: " + entity.toString());
        this.mongoTemplate.insert(entity);
    }

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    @Override
    public int update(UserDoc entity) {
        logger.info("update: " + entity.toString());
        Query query = new Query(new Criteria("userId").is(entity.getUserId()).and("delFlg").is(false));
        Update update = new Update();
        Map<String, Object> map = EntityUtil.entityToMap(entity);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            update.set(entry.getKey(), entry.getValue());
        }
        WriteResult writeResult = this.mongoTemplate.updateMulti(query, update, UserDoc.class);
        logger.info("update结束，update条数：{}", writeResult.getN());
        return writeResult.getN();
    }

    /**
     * 批量删除数据
     *
     * @param entity
     * @return
     */
    @Override
    public int delete(List<String> entity) {
        logger.info("开始删除");
        Query query = new Query(Criteria.where("userId").in(entity));
        Update update = new Update();
        // 删除标志（已删除）
        update.set("delFlg", true);
        WriteResult writeResult = this.mongoTemplate.updateMulti(query, update, UserDoc.class);
        logger.info("删除结束，删除条数：{}", writeResult.getN());
        return writeResult.getN();
    }
}
