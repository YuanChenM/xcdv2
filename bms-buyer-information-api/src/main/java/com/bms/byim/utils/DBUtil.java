package com.bms.byim.utils;

import com.framework.core.utils.StringUtils;

/**
 * Created by yuan_chen1 on 2016/12/29.
 */
public class DBUtil {

    public static String buildLikeCondition(String condition, LikeMode matchMode){
        String changedCond = condition;
        if(!StringUtils.isEmpty(condition)) {
            if(condition.contains("!")) {
                changedCond = condition.replace("!", "!!");
            }

            if(condition.contains("%")) {
                changedCond = changedCond.replace("%", "!%");
            }

            if(condition.contains("_")) {
                changedCond = changedCond.replace("_", "!_");
            }

            if(matchMode == LikeMode.FRONT || matchMode == LikeMode.PARTIAL) {
                changedCond = changedCond + "%";
            }

            if(matchMode == LikeMode.BEHIND || matchMode == LikeMode.PARTIAL) {
                changedCond = "%" + changedCond;
            }
        }

        return changedCond;
    }
    public static enum LikeMode {
        FRONT,
        BEHIND,
        PARTIAL;

        private LikeMode() {
        }
    }
}
