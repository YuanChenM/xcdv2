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
import com.framework.resource.bean.entity.SysResourceDoc;
import com.framework.resource.bean.param.SysResourceParam;
import com.framework.resource.dao.SysResourceDao;
import com.framework.resource.service.SysResourceService;
import com.framework.resource.utils.EntityUtil;
import com.mongodb.WriteResult;

/**
 * Created by dai_youcheng on 2016-12-7.
 */
@Repository
public class SysResourceDaoImpl implements SysResourceDao {

    /**
     * logger
     */
    public static final Logger logger = LoggerFactory.getLogger(SysResourceService.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<SysResourceDoc> findList(SysResourceParam request) {
        // 分页
        Pagination pageParam = request.getPagination();
        Query query = new Query();
        Criteria criteria = new Criteria();
        Map<String, Object> map = EntityUtil.entityToMap(request);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof String) {
                query.addCriteria(new Criteria(entry.getKey()).regex("^.*" + entry.getValue() + ".*$"));
            } else {
                query.addCriteria(new Criteria(entry.getKey()).is(entry.getValue()));
            }
        }
        query.addCriteria(criteria);
        query.addCriteria(new Criteria("delFlg").is(false));
        com.framework.base.bean.Sort[] baseRestSortParam = request.getSort();
        if (ArrayUtils.isNotEmpty(baseRestSortParam)) {
            query.with(new Sort(new Sort.Order(Sort.Direction.ASC, baseRestSortParam[0].getSortField())));
        }
        if (null != pageParam) {
            query.skip(pageParam.getStartPos() * pageParam.getPageSize()).limit(pageParam.getPageSize());
        }
        List<SysResourceDoc> list = this.mongoTemplate.find(query, SysResourceDoc.class);
        return list;
    }

    @Override
    public Long findCount(SysResourceParam request) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        Map<String, Object> map = EntityUtil.entityToMap(request);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof String) {
                query.addCriteria(new Criteria(entry.getKey()).regex("^.*" + entry.getValue() + ".*$"));
            } else {
                query.addCriteria(new Criteria(entry.getKey()).is(entry.getValue()));
            }
        }
        query.addCriteria(criteria);
        query.addCriteria(new Criteria("delFlg").is(false));

        return this.mongoTemplate.count(query, SysResourceDoc.class);
    }

    @Override
    public int delete(List<String> sysResourceParam) {
        logger.info("list:" + sysResourceParam.toString());
        Query query = new Query(Criteria.where("sysId").in(sysResourceParam));
        Update update = new Update();
        update.set("crtTime", new java.util.Date(System.currentTimeMillis()));
        update.set("delFlg", true);
        WriteResult writeResult = this.mongoTemplate.updateMulti(query, update, SysResourceDoc.class);
        return writeResult.getN();
    }

    @Override
    public int update(SysResourceParam sysResourceParam) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("sysId").is(sysResourceParam.getSysId());
        Update update = new Update();
        Map<String, Object> map = EntityUtil.entityToMap(sysResourceParam);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            update.set(entry.getKey(), entry.getValue());
        }
        query.addCriteria(criteria);
        WriteResult writeResult = this.mongoTemplate.updateMulti(query, update, SysResourceDoc.class);
        return writeResult.getN();
    }

    @Override
    public boolean insert(SysResourceDoc sysResourceDoc) {
        sysResourceDoc.setSysId(UUIDUtils.genPrimaryKey());
        sysResourceDoc.setDelFlg(false);
        logger.info("sysResourceDoc" + sysResourceDoc.toString());
        this.mongoTemplate.insert(sysResourceDoc);
        return true;
    }

}
