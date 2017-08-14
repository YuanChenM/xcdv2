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
import com.framework.resource.bean.entity.PageResourceDoc;
import com.framework.resource.bean.param.PageResourceDocParam;
import com.framework.resource.dao.PageResourceDao;
import com.framework.resource.service.impl.PageResourceServiceImpl;
import com.framework.resource.utils.EntityUtil;
import com.mongodb.WriteResult;

/**
 * Created by dai_youcheng on 2016-12-7.
 */
@Repository
public class PageResourceDaoImpl implements PageResourceDao {
    private static Logger logger = LoggerFactory.getLogger(PageResourceServiceImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(PageResourceDoc param) {
        logger.info("开始新增");
        param.setPageId(UUIDUtils.genPrimaryKey());
        param.setDelFlg(false);
        this.mongoTemplate.insert(param);
        logger.info("新增结束,新增pageID:{}", param.getPageId());
    }

    @Override
    public int delete(List<String> pageIdList) {
        logger.info("开始删除");
        Query query = new Query(Criteria.where("pageId").in(pageIdList));
        Update update = new Update();
        // 删除标志（已删除）
        update.set("delFlg", true);
        WriteResult writeResult = this.mongoTemplate.updateMulti(query, update, PageResourceDoc.class);
        logger.info("删除结束，删除条数：{}", writeResult.getN());
        return writeResult.getN();
    }

    @Override
    public int update(PageResourceDoc param) {
        logger.info("开始更新");
        Map<String, Object> map = EntityUtil.entityToMap(param);
        Query query = new Query();
        query.addCriteria(new Criteria().where("pageId").is(param.getPageId()));
        Update update = new Update();
        map.remove("pageId");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            update.set(entry.getKey(), entry.getValue());
        }
        WriteResult writeResult = this.mongoTemplate.updateMulti(query, update, PageResourceDoc.class);
        logger.info("更新结束，更新条数：{}", writeResult.getN());
        return writeResult.getN();
    }

    @Override
    public List<PageResourceDoc> findList(PageResourceDocParam request) {
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
        List<PageResourceDoc> list = this.mongoTemplate.find(query, PageResourceDoc.class);
        return list;
    }

    @Override
    public Long findCount(PageResourceDocParam request) {
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
        return this.mongoTemplate.count(query, PageResourceDoc.class);
    }
}
