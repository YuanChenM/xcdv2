package com.framework.core.db;

import com.framework.base.consts.StringConst;
import com.framework.core.utils.StringUtils;

import java.util.Map;

/**
 * @author liu_tao2
 * @version 1.0
 */
public class DbUtils {
    private static final String DIGIT_CHAR = "ABCDEFGHJKLMNPQRSTUVWXYZ";

    /**
     * Like condition modes.
     */
    public enum LikeMode {
        /**
         * front match
         */
        FRONT, /**
         * front match
         */
        BEHIND, /**
         * partial match
         */
        PARTIAL
    }

    /**
     * <p>
     * Escapes the characters in a <code>String</code> to be suitable to pass to an SQL query.
     * </p>
     * <p>
     * <p>
     * For example,
     * <p>
     * <pre>
     * statement
     *     .executeQuery(&quot;SELECT * FROM MOVIES WHERE TITLE='&quot; + StringEscapeUtils.escapeSql(&quot;McHale's Navy&quot;) + &quot;'&quot;);
     * </pre>
     * <p>
     * </p>
     * <p>
     * <p>
     * At present, this method only turns single-quotes into doubled single-quotes (<code>"McHale's Navy"</code> =>
     * <code>"McHale''s Navy"</code>). It does not handle the cases of percent (%) or underscore (_) for use in LIKE
     * clauses.
     * </p>
     * <p>
     * see http://www.jguru.com/faq/view.jsp?EID=8881
     *
     * @param str the string to escape, may be null
     * @return a new String, escaped for SQL, <code>null</code> if null string input
     */
    public static String escapeSql(String str) {
        if (str == null) {
            return null;
        }
        return StringUtils.replace(str, "'", "''");
    }

    /**
     * Calculate next sequence string.
     * <p>
     * For example: A->B, B->C, AA->AB, AZ->BA
     * </p>
     *
     * @param value current value
     * @return next value
     */
    public static String nextSequenceString(String value) {
        int len = value.length();
        StringBuilder sb = new StringBuilder(len);
        boolean addFlag = true;
        for (int i = len - 1; i >= 0; i--) {
            if (addFlag) {
                int index = DIGIT_CHAR.indexOf(value.charAt(i));
                index++;
                if (index >= DIGIT_CHAR.length()) {
                    index = 0;
                    if (i == 0) {
                        throw new IllegalArgumentException("Overflow for parameter:" + value);
                    }
                } else {
                    addFlag = false;
                }
                sb.insert(0, DIGIT_CHAR.charAt(index));
            } else {
                sb.insert(0, value.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * Replace the like conditon in parameter.
     * Escape "!", "%", "_" in condition and add "%" by match mode.
     *
     * @param filterMap the parameter for query
     * @param itemName  query condition item name
     * @param matchMode <code>CoreConst.LikeMode</code>
     */
    public static void buildLikeCondition(Map<String, Object> filterMap, String itemName, LikeMode matchMode) {
        if (filterMap != null && !StringUtils.isEmpty(itemName)
                && filterMap.containsKey(itemName)) {
            String paramValue = filterMap.get(itemName) == null ? "" : filterMap.get(itemName).toString();
            filterMap.put(itemName, buildLikeCondition(paramValue, matchMode));
        }


    }

    /**
     * Replace the like conditon in parameter.
     * Escape "!", "%", "_" in condition and add "%" at the end.
     *
     * @param filterMap the parameter for query
     * @param itemName  query condition item name
     */
    public static void buildLikeCondition(Map<String, Object> filterMap, String itemName) {
        buildLikeCondition(filterMap, itemName, LikeMode.FRONT);
    }

    /**
     * <p>
     * Escape "!", "%", "_" in condition and add "%" at the end.
     * </p>
     *
     * @param condition query condition to be changed
     * @return query condition
     */
    public static String buildLikeCondition(String condition) {
        return buildLikeCondition(condition, LikeMode.FRONT);
    }

    /**
     * <p>
     * Escape "!", "%", "_" in condition and add "%" by match mode.
     * </p>
     *
     * @param condition query condition to be changed
     * @param matchMode <code>CoreConst.LikeMode</code>
     * @return query condition
     */
    public static String buildLikeCondition(String condition, LikeMode matchMode) {
        String changedCond = condition;
        if (!StringUtils.isEmpty(condition)) {
            // escape "!"
            if (condition.contains(StringConst.EXCLAMATION)) {
                changedCond = changedCond.replace(StringConst.EXCLAMATION,
                        StringConst.EXCLAMATION + StringConst.EXCLAMATION);
            }
            // escape "%"
            if (condition.contains(StringConst.PRE)) {
                changedCond = changedCond.replace(StringConst.PRE, StringConst.EXCLAMATION + StringConst.PRE);
            }
            // escape "_"
            if (condition.contains(StringConst.UNDERLINE)) {
                changedCond = changedCond.replace(StringConst.UNDERLINE,
                        StringConst.EXCLAMATION + StringConst.UNDERLINE);
            }
            if (matchMode == LikeMode.FRONT || matchMode == LikeMode.PARTIAL) {
                changedCond = changedCond + StringConst.PRE;
            }
            if (matchMode == LikeMode.BEHIND || matchMode == LikeMode.PARTIAL) {
                changedCond = StringConst.PRE + changedCond;
            }
        }
        return changedCond;
    }
}
