package com.bms.como.util;

import com.framework.base.consts.NumberConst;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao_zhifa on 2016/12/7.
 */
public class RestCommUtil {
    /**
     * 返回一个存放100条数据的集合
     *
     * @param paramList
     */
    public static <T> List<List<T>> insertRanking(List<T> paramList) {
        int insert_max = NumberConst.IntDef.INT_HUNDRED;
        List<List<T>> returnList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(paramList)) {
            int length = paramList.size();
            int start = NumberConst.IntDef.INT_ZERO;
            int end = length > insert_max ? insert_max : length;
            while (start < length) {
                List<T> insertList = paramList.subList(start, end);
                returnList.add(insertList);
                start = end;
                end = length > (end + insert_max) ? (end + insert_max) : length;
            }
        }
        return returnList;
    }
}
