package com.bms.dictionary.service;

import com.bms.dictionary.bean.entity.DictNodeValue;
import com.bms.dictionary.bean.param.CreateDictParam;
import com.bms.dictionary.bean.param.FindNodeParam;
import com.bms.dictionary.bean.param.FindSubNodeParam;
import com.bms.dictionary.bean.result.FindNodeResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zhu_kai1 on 2016/12/29.
 */
public interface LoadNodeService extends BaseService {
    @Transactional
    String createDictLeafNode(CreateDictParam createDictParam);
    @Transactional
    int deleteLeafNode(HashMap<String,Object> map);
    @Transactional(readOnly = true)
    HashMap<String, List<DictNodeValue>> getSubNode(FindSubNodeParam findSubNodeParam);
    @Transactional(readOnly = true)
    FindNodeResult getNode(FindNodeParam findNodeParam);
}
