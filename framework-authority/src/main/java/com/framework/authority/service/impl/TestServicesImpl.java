package com.framework.authority.service.impl;

import java.util.List;

import com.framework.authority.service.TestServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.framework.authority.entity.Test;

/**
 * Created by zhang_jian3 on 2016/11/2.
 */
@Service
public class TestServicesImpl implements TestServices {

    public static final Logger logger = LoggerFactory.getLogger(TestServicesImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Test> findList(int skip, int limit) {
        Query query = new Query();
        query.with(new Sort(new Sort.Order(Sort.Direction.ASC, "_id")));
        query.skip(skip).limit(limit);
        return this.mongoTemplate.find(query, Test.class);
    }

    @Override
    public void save(Test entity) {
        logger.info("Insert: " + entity.toString());
        this.mongoTemplate.insert(entity);
    }
}
