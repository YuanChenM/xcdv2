package com.bms.agif.util;

import com.framework.base.consts.NumberConst;
import org.apache.commons.collections.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tao_zhifa on 2016/12/7
 * @version 1.0
 */
public class RestCommUtil {

    /**
     * 将传入List按每100条截取为一个list返回
     *
     * @param paramList
     * @param <T>
     * @return
     */
    public static <T extends Serializable> List<List<T>> insertRanking(List<T> paramList) {
        int insert_max = NumberConst.IntDef.INT_HUNDRED;
        List<List<T>> returnList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(paramList)) {
            List<T> insertList;
            int length = paramList.size();
            int start = NumberConst.IntDef.INT_ZERO;
            int end = length > insert_max ? insert_max : length;
            while (start < length) {
                insertList = paramList.subList(start, end);
                returnList.add(insertList);
                start = end;
                end = length > (end + insert_max) ? (end + insert_max) : length;
            }
        }
        return returnList;
    }
}
