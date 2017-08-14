package com.bms.issue.service.impl;

import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.param.ISSU0211IFilter;
import com.bms.issue.bean.result.ISSU0211IRestResult;
import com.bms.issue.common.rest.SearchRestParam;
import com.bms.issue.common.rest.SearchRestResult;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.ISSU0211IDao;
import com.bms.issue.service.ISSU0211IService;
import com.framework.base.bean.Pagination;
import com.framework.base.bean.Sort;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.db.DbUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/21.
 */
@Service
public class ISSU0211IServiceImpl extends BaseServiceImpl implements ISSU0211IService {

    @Autowired
    private ISSU0211IDao issu0211IDao;


    @Override
    public SearchRestResult<ISSU0211IRestResult> execute(Operator operator, SearchRestParam<ISSU0211IFilter> param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        SearchRestResult<ISSU0211IRestResult> result = new SearchRestResult<>();
        blackboard.setOperator(operator);
        map.put("param", param);
        map.put("result", result);
        map.put("blackboard", blackboard);
        pre(map);
        process(map);
        post(map);
        return result;
    }


    /**
     * 准备
     *
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {

        // 获取参数
        @SuppressWarnings("unchecked")
        SearchRestParam<ISSU0211IFilter> param = (SearchRestParam<ISSU0211IFilter>) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        ISSU0211IFilter filter = param.getFilter();

        // 操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);

        // 数据权限验证
        checkDataAuthority(operator, filter);

        // 处理filter
        if(null != filter){
            processFilter(filter);
        }

        // 处理sort
        processSort(param.getSort());
        //处理分页层级
        calculateLevel(param);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        SearchRestParam<ISSU0211IFilter> param = (SearchRestParam<ISSU0211IFilter>) map.get("param");
        BaseRestPaginationResult<ISSU0211IRestResult> restResult = findPageList(param);
        SearchRestResult<ISSU0211IRestResult> result = (SearchRestResult<ISSU0211IRestResult>) map.get("result");
        result.setData(restResult.getData());
        result.setTotal(restResult.getTotal());
    }

    /**
     * 收尾
     *
     * @param map HashMap
     */
    private void post(HashMap<String, Object> map) {

    }

    private void checkDataAuthority(Operator operator,ISSU0211IFilter filter){
        //目前没有
    }



    /**
     *
     * @param filter
     */
    private void processFilter(ISSU0211IFilter filter){
        // 移除空字符串
        removeBlank(filter);

        // 移除空数组
        removeEmpty(filter);

        // 设置模糊检索
        setSearchCondition(filter);
    }

    /**
     * 移除空字符串
     * @param filter
     */
    private void removeBlank(ISSU0211IFilter filter){
        filter.setItemDesc(strRemoveBlank(filter.getItemDesc()));
        filter.setItemSolution(strRemoveBlank(filter.getItemSolution()));
        filter.setItemExcutor(strRemoveBlank(filter.getItemExcutor()));
        filter.setItemStartTimeFrom(strRemoveBlank(filter.getItemStartTimeFrom()));
        filter.setItemStartTimeTo(strRemoveBlank(filter.getItemStartTimeTo()));
        filter.setItemEndTimeFrom(strRemoveBlank(filter.getItemEndTimeFrom()));
        filter.setItemEndTimeTo(strRemoveBlank(filter.getItemEndTimeTo()));
        filter.setItemResult(strRemoveBlank(filter.getItemResult()));
        filter.setItemFeedBack(strRemoveBlank(filter.getItemFeedBack()));
        filter.setItemCloser(strRemoveBlank(filter.getItemCloser()));
        filter.setItemCloseTimeFrom(strRemoveBlank(filter.getItemCloseTimeFrom()));
        filter.setItemCloseTimeTo(strRemoveBlank(filter.getItemCloseTimeTo()));

    }


    /**
     * 移除空数组
     * @param filter
     */
    private void removeEmpty(ISSU0211IFilter filter){

        if (filter.getItemId() != null && filter.getItemId().length == 0)
            filter.setItemId(null);

        if (filter.getQuestionId() != null && filter.getQuestionId().length == 0)
            filter.setQuestionId(null);

        if (filter.getAccessoryId() != null && filter.getAccessoryId().length == 0)
            filter.setAccessoryId(null);

        if (filter.getFileId() != null && filter.getFileId().length == 0)
            filter.setFileId(null);
    }

    /**
     * 设置模糊检索
     * @param filter
     */
    private void setSearchCondition(ISSU0211IFilter filter){

        filter.setItemDesc(
                likeCondition(filter.getItemDesc(), DbUtils.LikeMode.FRONT));

        filter.setItemSolution(
                likeCondition(filter.getItemSolution(), DbUtils.LikeMode.FRONT));

        filter.setItemExcutor(
                likeCondition(filter.getItemExcutor(), DbUtils.LikeMode.FRONT));

        filter.setItemResult(
                likeCondition(filter.getItemResult(), DbUtils.LikeMode.FRONT));

        filter.setItemFeedBack(
                likeCondition(filter.getItemFeedBack(), DbUtils.LikeMode.FRONT));

        filter.setItemCloser(
                likeCondition(filter.getItemCloser(), DbUtils.LikeMode.FRONT));
    }


    /**
     * 获取模糊检索字符串
     *
     * @param condition
     * @param likeMode
     * @return
     */
    private String likeCondition(String condition, DbUtils.LikeMode likeMode) {
        return condition == null ? null : DbUtils.buildLikeCondition(condition, likeMode);
    }


    /**
     * trim
     *
     * @param str
     * @return
     */
    private String strRemoveBlank(String str) {
        if (str == null)
            return null;
        str = str.trim();
        return str.equals("") ? null : str.trim();
    }

    /**
     * 处理排序字段
     *
     * @param sorts
     */
    private void processSort(Sort[] sorts) {
        if (sorts == null || sorts.length == 0)
            return;

        // 创建映射
        Map<String, String> sortMap = initSortMap();

        for (Sort sort : sorts) {
            // 映射
            String inputField = sort.getSortField();
            String dbField = sortMap.get(inputField);
            if (dbField == null)
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E000011, inputField);
            sort.setSortField(dbField);
        }
    }

    private Map<String, String> initSortMap() {
        Map<String, String> sortMap = new HashMap<>();
        sortMap.put("questionId","L1_questionId");
        sortMap.put("itemId","L1_itemId");
        sortMap.put("itemDesc","itemDesc");
        sortMap.put("itemSolution","itemSolution");
        sortMap.put("itemExcutor","itemExcutor");
        sortMap.put("itemStartTime","itemStartTime");
        sortMap.put("itemEndTime","itemEndTime");
        sortMap.put("itemResult","itemResult");
        sortMap.put("itemFeedBack","itemFeedBack");
        sortMap.put("itemCloser","itemCloser");
        sortMap.put("itemCloseTime","itemCloseTime");
        sortMap.put("accessoryId","accessoryId");
        sortMap.put("accessoryType","accessoryType");
        sortMap.put("fileId","fileId");
        sortMap.put("fileName","fileName");
        sortMap.put("fileType","fileType");
        return sortMap;
    }


    /**
     * 计算分页/查询层级
     */
    private void calculateLevel(SearchRestParam<ISSU0211IFilter> param) {
        Integer pagingLevel = param.getPagingLevel();
        Pagination pagination = param.getPagination();
        @SuppressWarnings("unused")
        ISSU0211IFilter filter = param.getFilter();
        int searchLevel = 0;

        int level1 = 1; // NOTIFICATION
        int level2 = 2; // DETAIL
        int levelAll = 99; // ALL

        // 如果不需要分页
        if (pagination == null) { // && pagingLevel == null
            // 分页层级最高 查询层级2
            pagingLevel = levelAll;
            searchLevel = pagingLevel;
            param.setSearchLevel(searchLevel);
            param.setPagingLevel(pagingLevel);
            return;
        }

        // 计算查询层级
        if(null != filter.getAccessoryId()
                || null != filter.getFileId()){
            searchLevel = level2;
        }

        int sortLevel = 0;
        if(null != param.getSort()){
            for (Sort sort : param.getSort()) {
                String field = sort.getSortField();
                if (field.startsWith("L2") && sortLevel < level2)
                    sortLevel = level2;
                else if (field.startsWith("L1") && sortLevel < level1)
                    sortLevel = level1;
            }
        }

        if (sortLevel > pagingLevel)
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E000012);

        // 如果查询层级比分页层级浅，查询层级=分页层级
        if (searchLevel < pagingLevel)
            searchLevel = pagingLevel;

        // 设置层级
        param.setSearchLevel(searchLevel);
        param.setPagingLevel(pagingLevel);
    }


    @Override
    public BaseDao getBaseDao() {
        return issu0211IDao;
    }
}
