package com.bms.dictionary.service.impl;

import com.bms.dictionary.bean.entity.DictLeafNode;
import com.bms.dictionary.bean.entity.DictNodeValue;
import com.bms.dictionary.bean.param.CreateDataParam;
import com.bms.dictionary.bean.param.CreateDictParam;
import com.bms.dictionary.bean.param.FindNodeParam;
import com.bms.dictionary.bean.param.FindSubNodeParam;
import com.bms.dictionary.bean.result.FindNodeResult;
import com.bms.dictionary.dao.LeafNodeDao;
import com.bms.dictionary.dao.NodeValueDao;
import com.bms.dictionary.service.LoadNodeService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhu_kai1 on 2016/12/29.
 */
@Service
public class LoadNodeServiceImpl extends BaseServiceImpl implements LoadNodeService {
    @Autowired
    private LeafNodeDao leafNodeDao;

    @Autowired
    private NodeValueDao nodeValueDao;

    @Override
    public String createDictLeafNode(CreateDictParam createDictParam) {
        int checkCount = leafNodeDao.checkDictLeafNode(createDictParam);
        DictLeafNode dictLeafNode =null;
        if(checkCount == NumberConst.IntDef.INT_ZERO){
            DictLeafNode tempNode = null;
            if(!createDictParam.getIsRoot()){
                tempNode = leafNodeDao.findOne(createDictParam);
            }
            dictLeafNode = getDictLeafNode(createDictParam, tempNode);
            // 新增目录
            int count = leafNodeDao.save(dictLeafNode);
            if(count == NumberConst.IntDef.INT_ZERO){
                throw new BusinessException("dictionaryCode","dictionary.Common.E014");
            }
            // 新增目录属性
            CreateDataParam createDataParam = new CreateDataParam();
            if(!CollectionUtils.isEmpty(createDictParam.getValues())) {
                createDataParam.setValues(createDictParam.getValues());
                for (DictNodeValue dictNodeValue : createDataParam.getValues()) {
                    long nodeValueId =super.maxId("dict_node_value");
                    dictNodeValue.setDataId(nodeValueId);
                    dictNodeValue.setDictId(dictLeafNode.getDictId());
                    dictNodeValue.setCrtId(super.getLoginUserId());
                    dictNodeValue.setCrtTime(DateUtils.getCurrent());
                }
                int createCount = nodeValueDao.save(createDataParam);
                if (createCount == NumberConst.IntDef.INT_ZERO) {
                    throw new BusinessException("dictionaryCode", "dictionary.Common.E015");
                }
            }
        }else{
            throw new BusinessException("dictionaryCode","dictionary.Business.E001",createDictParam.getRootCode(),createDictParam.getDictCode());
        }

        return StringUtils.toString(dictLeafNode.getDictId());
    }

    @Override
    public int deleteLeafNode(HashMap<String,Object> map) {
       List<DictLeafNode> dictLeafNodeList = leafNodeDao.selectFullPath((List)map.get("dictIds"));
        // 删除本身属性值
        nodeValueDao.deletePartNodeValue(map);
        HashMap<String,Object> temp = new HashMap<>();
        List<String> fullPathList = new ArrayList<>();
        List<String> dictIdList = new ArrayList<>();
        for (DictLeafNode leafNode : dictLeafNodeList){
            temp.put("updTime", map.get("updTime"));
            temp.put("updId", map.get("updId"));
            fullPathList.add(leafNode.getFullpath());
            dictIdList.add(StringUtils.toString(leafNode.getDictId()));
        }
        if(CollectionUtils.isNotEmpty(dictIdList) && CollectionUtils.isNotEmpty(fullPathList)){
            temp.put("dictIds",dictIdList);
            temp.put("fullPathList",fullPathList);
            // 删除该节点下面的子节点
            leafNodeDao.delSubNode(temp);
            // 删除该节点下面子节点的属性
            nodeValueDao.deletePartNodeValue(temp);
        }
        // 删除该节点本身
        return leafNodeDao.deleteLeafNode(map);
    }

    @Override
    public HashMap<String, List<DictNodeValue>> getSubNode(FindSubNodeParam findSubNodeParam) {
        List<FindNodeResult> resultList = leafNodeDao.getSubNode(findSubNodeParam);
        if (CollectionUtils.isEmpty(resultList)) {
            return null;
        }
        HashMap<String, List<DictNodeValue>> hashResult = new HashMap<>();
        for (FindNodeResult rs : resultList) {
            List<DictNodeValue> rsList = new ArrayList<>();
            for (DictNodeValue nv : rs.getValues()) {
                rsList.add(nv);
            }
            if(!findSubNodeParam.isDetail()){
                hashResult.put(rs.getDictCode(), null);
            }else {
                hashResult.put(rs.getDictCode(), rsList);
            }
        }
        return hashResult;
    }

    @Override
    public FindNodeResult getNode(FindNodeParam findNodeParam) {
        FindNodeResult rs = leafNodeDao.getNode(findNodeParam);
        if (null == rs) {
            return rs;
        }
        if(!findNodeParam.isDetail()){
            rs.setValues(new ArrayList<DictNodeValue>());
        }
        return rs;
    }

    /**
     * 构建DictLeafNode（父类）
     * @param createDictParam
     * @return
     */
    private DictLeafNode getDictLeafNode(CreateDictParam createDictParam,  DictLeafNode tempNode) {
        DictLeafNode dictLeafNode = new DictLeafNode();
        long dict_Id = super.maxId("dict_leaf_node");
        dictLeafNode.setDictId(dict_Id);
        if(createDictParam.getIsRoot()){
            dictLeafNode.setParentId(dictLeafNode.getDictId());
            dictLeafNode.setFullpath(StringUtils.toStr(dict_Id));
        }else{
            if(null !=tempNode){
                dictLeafNode.setParentId(tempNode.getParentId());
                String path =String.format(tempNode.getFullpath()+","+StringUtils.toStr(dict_Id));
                dictLeafNode.setFullpath(path);
            }else{
                throw new BusinessException("dictionaryCode","dictionary.Common.E013",createDictParam.getParentCode(),createDictParam.getRootCode());
            }
        }
        dictLeafNode.setDictCn(createDictParam.getDictCn());
        dictLeafNode.setDictEn(createDictParam.getDictEn());
        dictLeafNode.setDictCode(createDictParam.getDictCode());
        dictLeafNode.setRoot(createDictParam.getIsRoot());
        dictLeafNode.setCrtId(super.getLoginUserId());
        dictLeafNode.setCrtTime(DateUtils.getCurrent());
        return dictLeafNode;
    }


    @Override
    public BaseDao getBaseDao() {
        return leafNodeDao;
    }
}
