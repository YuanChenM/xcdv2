package com.bms.dictionary.service.impl;

import com.bms.dictionary.bean.entity.DictLeafNode;
import com.bms.dictionary.bean.entity.DictNodeValue;
import com.bms.dictionary.bean.param.CreateDataParam;
import com.bms.dictionary.dao.NodeValueDao;
import com.bms.dictionary.service.NodeValueService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhu_kai1 on 2016/12/29.
 */
@Service
public class NodeValueServiceImpl extends BaseServiceImpl implements NodeValueService {
    @Autowired
    private NodeValueDao nodeValueDao;

    @Override
    public BaseDao getBaseDao() {
        return nodeValueDao;
    }

    /**
     * 创建子节点
     * @param createDataParam
     * @return
     */
    public Boolean createDataNode(CreateDataParam createDataParam){

        DictLeafNode tempNode = nodeValueDao.findDictId(createDataParam);
        int count=0;
        if(tempNode.getDictId() !=null){
            for(DictNodeValue dictNodeValue:createDataParam.getValues()){
                long nodeValueId = super.maxId("dict_node_value");
                dictNodeValue.setDataId(nodeValueId);
                dictNodeValue.setCrtId(super.getLoginUserId());
                dictNodeValue.setCrtTime(DateUtils.getCurrent());
                dictNodeValue.setDictId(tempNode.getDictId());
            }
            count = nodeValueDao.save(createDataParam);
        }
        return count>0?true:false;
    }
}
