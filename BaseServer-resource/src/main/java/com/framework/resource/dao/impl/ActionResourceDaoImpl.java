package com.framework.resource.dao.impl;

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

import com.framework.base.bean.Pagination;
import com.framework.core.utils.ArrayUtils;
import com.framework.core.utils.UUIDUtils;
import com.framework.resource.bean.entity.ActionResourceDoc;
import com.framework.resource.bean.param.ActionResourceParam;
import com.framework.resource.dao.ActionResourceDao;
import com.framework.resource.service.impl.ActionResourceServiceImpl;
import com.framework.resource.utils.EntityUtil;
import com.mongodb.WriteResult;

/**
 * Created by dai_youcheng on 2016-12-7.
 */
@Repository
public class ActionResourceDaoImpl implements ActionResourceDao {
    public static final Logger logger = LoggerFactory.getLogger(ActionResourceServiceImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<ActionResourceDoc> findList(ActionResourceParam request) {
        // 分页
        Pagination pageParam = request.getPagination();
        Query query = new Query();
        Map<String, Object> map = EntityUtil.entityToMap(request);
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
        return this.mongoTemplate.find(query, ActionResourceDoc.class);
    }

    @Override
    public Long findCount(ActionResourceParam request) {
        // 输入参数
        ActionResourceParam param = request;
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

        return this.mongoTemplate.count(query, ActionResourceDoc.class);

    }

    @Override
    public boolean save(ActionResourceDoc entity) {
        entity.setActionId(UUIDUtils.genPrimaryKey());
        entity.setDelFlg(false);
        entity.setCrtTime(new java.util.Date(System.currentTimeMillis()));
        this.mongoTemplate.insert(entity);
        return true;
    }

    @Override
    public int update(ActionResourceDoc entity) {
        Query query = new Query();
        Criteria And = Criteria.where("actionId").is(entity.getActionId());
        query.addCriteria(And);
        Map<String, Object> map = EntityUtil.entityToMap(entity);
        Update update = new Update();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            update.set(entry.getKey(), entry.getValue());
        }
        WriteResult writeResult = this.mongoTemplate.updateMulti(query, update, ActionResourceDoc.class);
        return writeResult.getN();
    }

    @Override
    public int delete(List<String> entity) {
        Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("actionId").in(entity));
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("delFlg", true);
        update.set("crtTime", new java.util.Date(System.currentTimeMillis()));
        WriteResult writeResult = this.mongoTemplate.updateMulti(query, update, ActionResourceDoc.class);
        return writeResult.getN();
    }
}
