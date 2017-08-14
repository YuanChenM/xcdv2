package com.bms.dictionary.dao;

import com.bms.dictionary.bean.entity.DictLeafNode;
import com.bms.dictionary.bean.param.CreateDictParam;
import com.bms.dictionary.bean.param.FindNodeParam;
import com.bms.dictionary.bean.param.FindSubNodeParam;
import com.bms.dictionary.bean.param.SubNodeLoadParam;
import com.bms.dictionary.bean.result.FindNodeResult;
import com.framework.boot.base.BaseDao;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zhu_kai1 on 2016/12/29.
 */
public interface LeafNodeDao extends BaseDao {
    // 校验树根节点下是否有重复的dictCode
    int checkDictLeafNode(CreateDictParam dictParam);

    List<DictLeafNode> selectFullPath(List<String> list);

    int deleteLeafNode(HashMap<String,Object> map);

    int delSubNode(HashMap<String,Object> temp);

    List<FindNodeResult> getSubNode(FindSubNodeParam findSubNodeParam);

    FindNodeResult getNode(FindNodeParam findNodeParam);

    List<DictLeafNode> loadSubNode(SubNodeLoadParam subNodeLoadParam);
}
