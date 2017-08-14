package com.framework.authority.dao;

import java.util.List;

import com.framework.authority.bean.entity.UserDoc;
import com.framework.authority.bean.param.UserParam;

/**
 * Created by zhang_jian3 on 2016/12/7.
 */
public interface UserDao {
    List<UserDoc> findList(UserParam request);

    List<UserDoc> findAccurateList(UserParam request);

    Long findCount(UserParam request);

    void save(UserDoc entity);

    int update(UserDoc entity);

    int delete(List<String> entity);
}
