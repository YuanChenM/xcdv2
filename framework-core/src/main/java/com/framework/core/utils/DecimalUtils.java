package com.framework.core.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.regex.Pattern;

/**
 * <p>BigDecimal工具类，提供加、减、乘、除、取模、舍入和比较等操作。</p>
 *
 * @Author xia_xiaojie
 * @CreateDate 2016/10/21
 * @Version 1.0
 */
public final class DecimalUtils  {

    public static BigDecimal toBigDecimal(Object obj) {
        if (obj == null) {
            return BigDecimal.ZERO;
        }
        try {
            BigDecimal ret;
            if (obj instanceof BigDecimal) {
                ret = (BigDecimal) obj;
            } else if (obj instanceof String) {
                ret = new BigDecimal((String) obj);
            } else if (obj instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) obj);
            } else if (obj instanceof Number) {
                ret = new BigDecimal(((Number) obj).doubleValue());
            } else {
                return BigDecimal.ZERO;
            }
            return ret;
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

    public static BigDecimal getBigDecimal(Object obj) {
        BigDecimal ret = null;
        if (obj == null) {
            return ret;
        }
        try {
            if (obj instanceof BigDecimal) {
                ret = (BigDecimal) obj;
            } else if (obj instanceof String) {
                ret = new BigDecimal((String) obj);
                String regEx = "^[0-9]*$";
                String str = String.valueOf(obj).replace('.', '0').replace('-', '0');
                if (Pattern.compile(regEx).matcher(str).matches() == false) {
                    ret = null;
                }
            } else if (obj instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) obj);
            } else if (obj instanceof Number) {
                ret = new BigDecimal(((Number) obj).doubleValue());
            }
            return ret;
        } catch (Exception e) {
            return ret;
        }
    }

    public static BigDecimal add(BigDecimal bd1, BigDecimal bd2) {
        bd1 = (null == bd1) ? BigDecimal.ZERO : bd1;
        bd2 = (null == bd1) ? BigDecimal.ZERO : bd2;
        return bd1.add(bd2);
    }

    public static BigDecimal subtract(BigDecimal bd1, BigDecimal bd2) {
        bd1 = (null == bd1) ? BigDecimal.ZERO : bd1;
        bd2 = (null == bd1) ? BigDecimal.ZERO : bd2;
        return bd1.subtract(bd2);
    }

    public static BigDecimal multiply(BigDecimal bd1, BigDecimal bd2) {
        return (bd1 != null && bd2 != null) ? bd1.multiply(bd2) : BigDecimal.ZERO;
    }

    public static BigDecimal multiplyAndRound(BigDecimal bd1, BigDecimal bd2, int newScale, int roundingMode) {
        return (bd1 != null && bd2 != null) ? bd1.multiply(bd2).divide(BigDecimal.ONE, newScale, roundingMode) : BigDecimal.ZERO;
    }

    public static BigDecimal multiplyAndRound(BigDecimal bd1, BigDecimal bd2, int newScale) {
        return multiplyAndRound(bd1, bd2, newScale, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal divide(BigDecimal bd1, BigDecimal bd2, int newScale, RoundingMode roundingMode) {
        if (null == bd1 || 0 == bd1.compareTo(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        if (null == bd2 || 0 == bd2.compareTo(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        return bd1.divide(bd2, newScale, roundingMode);
    }

    public static BigDecimal divide(BigDecimal bd1, BigDecimal bd2, int newScale, int roundingMode) {
        if (null == bd1 || 0 == bd1.compareTo(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        if (null == bd2 || 0 == bd2.compareTo(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        return bd1.divide(bd2, newScale, roundingMode);
    }

    public static BigDecimal divideAndRound(BigDecimal bd1, BigDecimal bd2, int newScale) {
        return divide(bd1, bd2, newScale, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal divideAndRound(BigDecimal bd1, BigDecimal bd2) {
        return divideAndRound(bd1, bd2, 10);
    }

    public static BigDecimal divideNoRemainder(BigDecimal bd1, BigDecimal bd2) {
        if (null == bd1 || 0 == bd1.compareTo(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        if (null == bd2 || 0 == bd2.compareTo(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        return bd1.divide(bd2);
    }

    public static BigDecimal remainder(BigDecimal bd1, BigDecimal bd2) {
        if (null == bd1 || 0 == bd1.compareTo(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        if (null == bd2 || 0 == bd2.compareTo(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        BigDecimal[] bds = bd1.divideAndRemainder(bd2);
        return bds[1];
    }

    public static BigDecimal round(BigDecimal decimal, int scale, int roundingMode) {
        return (null == decimal) ? BigDecimal.ZERO : decimal.setScale(scale, roundingMode);
    }

    public static BigDecimal roundHalfUp(BigDecimal decimal, int scale) {
        return (null == decimal) ? BigDecimal.ZERO : decimal.setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal roundMoney(BigDecimal decimal) {
        return roundHalfUp(decimal, 2);
    }

    public static BigDecimal roundWeight(BigDecimal decimal) {
        return roundHalfUp(decimal, 3);
    }

    public static boolean isZero(BigDecimal bd) {
        if (bd != null && bd.compareTo(BigDecimal.ZERO) == 0) {
            return true;
        }
        return false;
    }

    public static boolean eq(BigDecimal bd1, BigDecimal bd2) {
        bd1 = (null == bd1) ? BigDecimal.ZERO : bd1;
        bd2 = (null == bd2) ? BigDecimal.ZERO : bd2;
        return bd1.compareTo(bd2) == 0;
    }

    public static boolean gt(BigDecimal bd1, BigDecimal bd2) {
        bd1 = (null == bd1) ? BigDecimal.ZERO : bd1;
        bd2 = (null == bd2) ? BigDecimal.ZERO : bd2;
        return bd1.compareTo(bd2) > 0;
    }

    public static boolean ge(BigDecimal bd1, BigDecimal bd2) {
        bd1 = (null == bd1) ? BigDecimal.ZERO : bd1;
        bd2 = (null == bd2) ? BigDecimal.ZERO : bd2;
        return bd1.compareTo(bd2) >= 0;
    }

    public static boolean lt(BigDecimal bd1, BigDecimal bd2) {
        bd1 = (null == bd1) ? BigDecimal.ZERO : bd1;
        bd2 = (null == bd2) ? BigDecimal.ZERO : bd2;
        return bd1.compareTo(bd2) < 0;
    }

    public static boolean le(BigDecimal bd1, BigDecimal bd2) {
        bd1 = (null == bd1) ? BigDecimal.ZERO : bd1;
        bd2 = (null == bd2) ? BigDecimal.ZERO : bd2;
        return bd1.compareTo(bd2) <= 0;
    }

}
