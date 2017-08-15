 package com.bms.order.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bms.order.bean.param.ORDR0904IFilter;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.ORDR0904IDao;
import com.framework.base.bean.Pagination;
import com.framework.base.bean.Sort;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.db.DbUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0904IFilter;
import com.bms.order.bean.result.ORDR0904IRestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.services.ORDR0904IService;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 买手退货信息查询接口Service
 * 
 * @author li_huiqian
 */
@Service
public class ORDR0904IServiceImpl extends BaseServiceImpl implements ORDR0904IService {

    @Autowired
    private ORDR0904IDao ordr0904IDao;

    /**
     * 查询买手退货相关信息
     * 
     * @param operator
     *            操作者
     * @param param ORDR0904IBean
     *
     */
    @Override
    public SearchRestResult<ORDR0904IRestResult> execute(Operator operator, SearchRestParam<ORDR0904IFilter> param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        SearchRestResult<ORDR0904IRestResult> result = new SearchRestResult<>();

        blackboard.setOperator(operator);
        map.put("param", param);
        map.put("blackboard", blackboard);
        map.put("result", result);

        pre(map);
        process(map);
        post(map);

        return result;
    }

    /**
     * 准备
     * 
     * @param map
     *            HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        SearchRestParam<ORDR0904IFilter> param = (SearchRestParam<ORDR0904IFilter>) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        ORDR0904IFilter filter = param.getFilter();
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

        // 计算分页/查询层级
        calculateLevel(param);
    }


    /**
     * 数据权限
     * @param operator
     * @param filter
     */
    private void checkDataAuthority(Operator operator,ORDR0904IFilter filter){
        // TODO: 2017/3/8 目前没有
    }

    private void processFilter(ORDR0904IFilter filter){
        // 移除空字符串
        removeBlank(filter);

        // 移除空数组
        removeEmpty(filter);

        // 设置模糊检索
        setSearchCondition(filter);

    }

    private void processSort(Sort[] sorts){
        if (sorts == null || sorts.length == 0)
            return;

        // 创建映射
        Map<String, String> sortMap = initSortMap();

        for (Sort sort : sorts) {
            // 映射
            String inputField = sort.getSortField();
            String dbField = sortMap.get(inputField);
            if (dbField == null)
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000011, inputField);
            sort.setSortField(dbField);
        }
    }

    private void calculateLevel(SearchRestParam<ORDR0904IFilter> param){
        Integer pagingLevel = param.getPagingLevel();
        Pagination pagination = param.getPagination();
        @SuppressWarnings("unused")
        ORDR0904IFilter filter = param.getFilter();
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
        searchLevel = level1;
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
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000012);

        // 如果查询层级比分页层级浅，查询层级=分页层级
        if (searchLevel < pagingLevel)
            searchLevel = pagingLevel;

        // 设置层级
        param.setSearchLevel(searchLevel);
        param.setPagingLevel(pagingLevel);
    }

    private void removeBlank(ORDR0904IFilter filter){
        filter.setReturnCode(strRemoveBlank(filter.getReturnCode()));
        filter.setOrderCode(strRemoveBlank(filter.getOrderCode()));
        filter.setLogisticsZoneCode(strRemoveBlank(filter.getLogisticsZoneCode()));
        filter.setBsCode(strRemoveBlank(filter.getBsCode()));
        filter.setBsName(strRemoveBlank(filter.getBsName()));
        filter.setApplyUserId(strRemoveBlank(filter.getApplyUserId()));
        filter.setApplyUserName(strRemoveBlank(filter.getApplyUserName()));
        filter.setApplyTimeFrom(strRemoveBlank(filter.getApplyTimeFrom()));
        filter.setApplyTimeTo(strRemoveBlank(filter.getApplyTimeTo()));
        filter.setReturnType(strRemoveBlank(filter.getReturnType()));
        filter.setReturnStatus(strRemoveBlank(filter.getReturnStatus()));


    }

    private void removeEmpty(ORDR0904IFilter filter){
        if (filter.getReturnId() != null && filter.getReturnId().length == 0)
            filter.setReturnId(null);
        if (filter.getLogisticsZoneId() != null && filter.getLogisticsZoneId().length == 0)
            filter.setLogisticsZoneId(null);
        if (filter.getBsId() != null && filter.getBsId().length == 0)
            filter.setBsId(null);
    }

    private void setSearchCondition(ORDR0904IFilter filter){
        filter.setReturnCode(likeCondition(filter.getReturnCode(), DbUtils.LikeMode.FRONT));
        filter.setOrderCode(likeCondition(filter.getOrderCode(), DbUtils.LikeMode.FRONT));
        filter.setBsName(likeCondition(filter.getBsName(),DbUtils.LikeMode.FRONT));
        filter.setApplyUserName(likeCondition(filter.getApplyUserName(), DbUtils.LikeMode.FRONT));

    }

    private Map<String, String> initSortMap() {
        Map<String, String> sortMap = new HashMap<>();
        sortMap.put("returnId","L1_returnId");
        sortMap.put("returnCode","L1_returnCode");
        sortMap.put("orderId","L1_orderId");
        sortMap.put("orderCode","L1_orderCode");
        sortMap.put("bsId","L1_bsId");
        sortMap.put("bsCode","L1_bsCode");
        sortMap.put("bsName","L1_bsName");
        sortMap.put("returnSource","L1_returnSource");
        sortMap.put("returnType","L1_returnType");
        sortMap.put("returnAmount","L1_returnAmount");
        sortMap.put("returnReasonId","L1_returnReasonId");
        sortMap.put("returnReasonName","L1_returnReasonName");
        sortMap.put("applyUserType","L1_applyUserType");
        sortMap.put("applyUid","L1_applyUid");
        sortMap.put("applyUname","L1_applyUname");
        sortMap.put("applyTime","L1_applyTime");
        sortMap.put("applyRemark","L1_applyRemark");
        sortMap.put("confirmUserType","L1_confirmUserType");
        sortMap.put("confirmUid","L1_confirmUid");
        sortMap.put("confirmUname","L1_confirmUname");
        sortMap.put("confirmTime","L1_confirmTime");
        sortMap.put("confirmRemark","L1_confirmRemark");
        sortMap.put("returnStatus","L1_returnStatus");
        sortMap.put("delFlg","L1_delFlg");
        sortMap.put("crtId","L1_crtId");
        sortMap.put("crtTime","L1_crtTime");
        sortMap.put("updId","L1_updId");
        sortMap.put("updTime","L1_updTime");
        sortMap.put("ver","L1_ver");
        sortMap.put("detailId","L2_detailId");
        sortMap.put("bsStockpileSplitDetailId","L2_bsStockpileSplitDetailId");
        sortMap.put("goodsId","L2_goodsId");
        sortMap.put("goodsUnit","L2_goodsUnit");
        sortMap.put("returnQty","L2_returnQty");
        sortMap.put("detailReasonId","L2_detailReasonId");
        sortMap.put("detailReasonName","L2_detailReasonName");
        sortMap.put("delFlg","L2_delFlg");
        sortMap.put("crtId","L2_crtId");
        sortMap.put("crtTime","L2_crtTime");
        sortMap.put("updId","L2_updId");
        sortMap.put("updTime","L2_updTime");
        sortMap.put("ver","L2_ver");
        return sortMap;
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
     * 执行
     * 
     * @param map
     *            HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        SearchRestParam<ORDR0904IFilter> param = (SearchRestParam<ORDR0904IFilter>) map.get("param");
        SearchRestResult<ORDR0904IRestResult> result = (SearchRestResult<ORDR0904IRestResult>) map.get("result");
        List<ORDR0904IRestResult> restResults = ordr0904IDao.findReturnInfo(param);
        int count = restResults.size();
        if (param.getPagination() != null)
            count = ordr0904IDao.getCount(param);
        result.setTotal(count);
        result.setData(restResults);
        // 执行操作

    }

    /**
     * 收尾
     * 
     * @param map
     *            HashMap
     */
    private void post(HashMap<String, Object> map) {
        // 获取参数

        // 执行操作

    }


    @Override
    public BaseDao getBaseDao() {
        return ordr0904IDao;
    }
}
