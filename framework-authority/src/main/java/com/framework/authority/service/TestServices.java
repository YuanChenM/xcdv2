package com.framework.authority.service;

import java.util.List;

import com.framework.authority.entity.Test;

/**
 * Created by zhang_jian3 on 2016/11/2.
 */
public interface TestServices {
    public List<Test> findList(int skip, int limit);

    public void save(Test entity);
}
