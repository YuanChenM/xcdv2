package com.framework.interfaceLog.dao.impl;

import java.sql.Timestamp;
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
import com.framework.interfaceLog.bean.entity.LogHistoryDoc;
import com.framework.interfaceLog.bean.entity.LogInterfaceDoc;
import com.framework.interfaceLog.bean.param.LogInterfaceParam;
import com.framework.interfaceLog.dao.InterfaceInfoDao;
import com.framework.interfaceLog.utils.EntityUtil;
import com.mongodb.WriteResult;

/**
 * Created by 健 on 2017/4/26.
 */
@Repository
public class InterfaceInfoDaoImpl implements InterfaceInfoDao {

    public static final Logger logger = LoggerFactory.getLogger(InterfaceInfoDaoImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<LogInterfaceDoc> findList(LogInterfaceParam request) {
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
        criteria.and("delFlg").is(false);
        query.addCriteria(criteria);
        com.framework.base.bean.Sort[] baseRestSortParam = request.getSort();
        if (ArrayUtils.isNotEmpty(baseRestSortParam)) {
            query.with(new Sort(new Sort.Order(Sort.Direction.DESC, baseRestSortParam[0].getSortField())));
        }
        /**
         * 判断是否分页
         */
        if (null != request.getPagination()) {
            query.skip(pageParam.getStartPos() * pageParam.getPageSize()).limit(pageParam.getPageSize());
        }
        List<LogInterfaceDoc> list = this.mongoTemplate.find(query, LogInterfaceDoc.class);
        return list;
    }

    @Override
    public Long findCount(LogInterfaceParam request) {
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
        criteria.and("delFlg").is(false);
        query.addCriteria(criteria);
        return this.mongoTemplate.count(query, LogInterfaceDoc.class);
    }

    @Override
    public LogInterfaceDoc findOne(LogInterfaceDoc entity) {
        LogInterfaceDoc result = new LogInterfaceDoc();
        Query query = new Query();
        Criteria criteria = new Criteria();
        Map<String, Object> map = EntityUtil.entityToMap(entity);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof String) {
                query.addCriteria(new Criteria(entry.getKey()).regex("^.*" + entry.getValue() + ".*$"));
            } else {
                query.addCriteria(new Criteria(entry.getKey()).is(entry.getValue()));
            }
        }
        criteria.and("delFlg").is(false);
        query.addCriteria(criteria);
        List<LogInterfaceDoc> list = this.mongoTemplate.find(query, LogInterfaceDoc.class);
        if (null != list && list.size() > 0) {
            result = list.get(0);
        }
        return result;
    }

    @Override
    public boolean save(LogInterfaceDoc entity) {
        boolean flag = false;
        entity.setLogId(UUIDUtils.genPrimaryKey());
        entity.setDelFlg(false);
        entity.setCrtTime(new Timestamp(System.currentTimeMillis()));
        logger.debug("Insert: " + entity.toString());
        this.mongoTemplate.insert(entity);
        flag = true;
        return flag;
    }

    @Override
    public boolean saveHistory(LogHistoryDoc entity) {
        boolean flag = false;
        logger.debug("Insert: " + entity.toString());
        this.mongoTemplate.insert(entity);
        flag = true;
        return flag;
    }

    @Override
    public int update(LogInterfaceDoc entity) {
        logger.debug("update: " + entity.toString());
        Query query = new Query(new Criteria("logId").is(entity.getLogId()).and("delFlg").is(false));
        Update update = new Update();
        Map<String, Object> map = EntityUtil.entityToMap(entity);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            update.set(entry.getKey(), entry.getValue());
        }
        WriteResult writeResult = this.mongoTemplate.updateMulti(query, update, LogInterfaceDoc.class);
        logger.debug("update结束，update条数：{}", writeResult.getN());
        return writeResult.getN();
    }

    @Override
    public int delete(List<String> entity) {
        logger.debug("开始删除");
        Query query = new Query(Criteria.where("logId").in(entity));
        Update update = new Update();
        // 删除标志（已删除）
        update.set("delFlg", true);
        WriteResult writeResult = this.mongoTemplate.updateMulti(query, update, LogInterfaceDoc.class);
        logger.debug("删除结束，删除条数：{}", writeResult.getN());
        return writeResult.getN();

    }
}
