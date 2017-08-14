package com.bms.dictionary.dao;

import com.bms.dictionary.bean.entity.DictLeafNode;
import com.bms.dictionary.bean.param.CreateDataParam;
import com.framework.boot.base.BaseDao;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zhu_kai1 on 2016/12/29.
 */
public interface NodeValueDao extends BaseDao{
    // 查询目录的dictId
    DictLeafNode findDictId(CreateDataParam createDataParam);

    int deletePartNodeValue(HashMap<String,Object> map);
}
